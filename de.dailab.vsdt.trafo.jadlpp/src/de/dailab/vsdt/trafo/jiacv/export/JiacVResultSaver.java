package de.dailab.vsdt.trafo.jiacv.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.xmi.XMLResource;

import de.dailab.jiactng.jadl.Agent;
import de.dailab.jiactng.jadl.ontology.JadlParseException;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.trafo.jiacv.util.JadlParser;

public class JiacVResultSaver extends MappingResultSaver {

	/** group services by use case, of by participant? */
	public static boolean groupByUsecase= true;

	@Override
	protected String getDirectorySuffix() {
		return "jiacv";
	}
	
	/**
	 * @param folder	folder where to save the stuff
	 * @return			successfully saved?
	 */
	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		JiacVExportWrapper wrapper= (JiacVExportWrapper) this.wrapper;
		// save JADL source code
		for (Agent model : wrapper.getJadlFiles()) {
			String fileName= wrapper.getJadlFileName(model);
			saveJadlXml(new File(baseDirectory, fileName + ".xml"), model);
			saveJadl(new File(baseDirectory, fileName), model);
		}
		// save starter rules
		Map<Participant, List<JiacVStarterRule>> rulesMap= wrapper.getStarterRules();
		for (Participant participant : rulesMap.keySet()) {
			List<JiacVStarterRule> rules= rulesMap.get(participant);
			String fileName= wrapper.getRulesFileName(participant);
			saveRules(new File(baseDirectory, fileName), rules);
		}
		// save AWE diagram
//		AgentWorld agentWorld= wrapper.getAgentWorld();
//		if (agentWorld != null) {
//			String fileName= wrapper.getAweFileName(agentWorld, true);
//			saveAgentWorldDiagram(new File(baseDirectory, fileName), agentWorld);
//		}
		return true;
	}
	
	/**
	 * Serialize the Services without saving them.
	 * 
	 * @return				List holding the serialized JADL services
	 * @throws JadlParseException
	 */
	public List<String> getServiceSources() throws Exception {
		JiacVExportWrapper wrapper= (JiacVExportWrapper) this.wrapper;
		List<String> serviceSources = new ArrayList<String>();
		for (Agent model : wrapper.getJadlFiles()) {
			String source= JadlParser.getInstance().serialize(model);
			serviceSources.add(source);
		}
		return serviceSources;
	}
	
	/**
	 * @return				Starter Rules generated for all the Participants
	 */
	public Map<Participant, List<JiacVStarterRule>> getStarterRules() {
		JiacVExportWrapper wrapper= (JiacVExportWrapper) this.wrapper;
		return wrapper.getStarterRules();
	}
	
	/**
	 * Get Starter Rules in simple form: Service Name -> Hint (e.g. Time, or Channel)
	 * @return
	 */
	public Map<String, Serializable[]> getStarterRulesSimple() {
		Map<String, Serializable[]> simpleRules = new HashMap<String, Serializable[]>();
		Map<Participant, List<JiacVStarterRule>> rules = getStarterRules();
		for (Participant participant : rules.keySet()) {
			for (JiacVStarterRule rule : rules.get(participant)) {
				Serializable[] objects= null;
				Event event = rule.getStartEvent();
				try {
					switch (event.getTrigger()) {
					case MESSAGE:
						if (event.getImplementation() instanceof MessageChannel) {
							MessageChannel msgChannel = (MessageChannel) event.getImplementation();
							String channel = msgChannel.getChannel() != null ? msgChannel.getChannel().getExpression() : null;
							String type    = msgChannel.getPayload() != null ? msgChannel.getPayload().getType()       : null;
							objects = new Serializable[] {channel, type};
						}
						break;
					case TIMER:
						String expression = event.getTimeExpression().getExpression();
						if (event.isAsDuration()) {
							// duration -> Long
							objects = new Serializable[] {new Long(expression)};
						} else {
							// date -> Date
							objects = new Serializable[] {DateFormat.getInstance().parse(expression)};
						}
						break;
					default:
						break;
					}
				} catch (Exception e) {
					System.err.println("Could not create starter for Event " + event);
				}
				if (objects != null) {
					simpleRules.put(rule.getServiceToStart().getName(), objects);	
				}
			}
		}
		return simpleRules;
		
	}
	
	/**
	 * Save JADL model to JADL source code using the Parser's serialization method.
	 * 
	 * @param file			file where to save the model
	 * @param model			the model to save
	 * @throws IOException
	 */
	private void saveJadl(File file, Agent model) throws IOException {
		String source= null;
		try {
			source= JadlParser.getInstance().serialize(model);
		} catch (JadlParseException e) {
			TrafoLog.warn(e.getLocalizedMessage());
		}
		if (source != null) {
			if (! file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			file.createNewFile();
			FileWriter writer= new FileWriter(file);
			writer.write(source);
			writer.close();
		}
	}
	
	private void saveJadlXml(File file, Agent model) throws IOException {
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");
		saveAsXmlResource(file, model, options, null);
	}
	
	/**
	 * Save Starter Rules derived from BPMN Start Events to text file.
	 * 
	 * @param file			file where to save the rules
	 * @param rules			the rules to save
	 */
	private void saveRules(File file, List<JiacVStarterRule> rules) throws IOException {
		// create file
		if (! file.exists()) {
			file.createNewFile();
		}
		FileWriter writer= new FileWriter(file);
		
		// write file header
		final String NL = System.getProperty("line.separator");
		StringBuffer buffer= new StringBuffer();
		
		buffer.append("package foo; // TODO package declaration" + NL);
		buffer.append(NL);
		buffer.append("# Standard imports" + NL);
		buffer.append("import java.io.Serializable;" + NL);
		buffer.append("import de.dailab.jiactng.agentcore.action.Action;" + NL);
		buffer.append("import de.dailab.jiactng.agentcore.action.DoAction;" + NL);
		buffer.append("import de.dailab.jiactng.agentcore.comm.message.IJiacMessage;" + NL);
		buffer.append("import de.dailab.jiactng.ruleengine.timer.TimeFact;" + NL);
		buffer.append(NL);
		if (rules.size() > 0) {
			buffer.append("# Domain imports" + NL);
			JiacVStarterRule rule = rules.get(0);
			List<DataType> types = rule.startEvent.getPool().getParent().getParent().getDataTypes();
			for (DataType type : types) {
				String fullName = type.getPackage() + "." + type.getName();
				buffer.append("import " + fullName + ";" + NL);
			}
			buffer.append(NL);
		}
		writer.write(buffer.toString());
		
		// write rules
		for (JiacVStarterRule rule : rules) {
			writer.write(rule.toDroolsRule());
		}
		// close file
		writer.close();
	}
	
	
	/**
	 * Save Agent World Model to diagram file and automatically do the layout
	 * 
	 * @param file			File where to save the diagram
	 * @param agentWorld	Agent World model to be saved
	 * @return				saving successful? otherwise the model can still be saved to XML
	 * @throws IOException
	 */
	/* CREATION OF AGENT WORLD DIAGRAM (deprecated)
	private boolean saveAgentWorldDiagram(File file, AgentWorld agentWorld) throws IOException {
		
		TransactionalEditingDomain editingDomain= GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		ResourceSet resourceSet = editingDomain.getResourceSet();

		URI diagramModelURI = URI.createFileURI(file.getAbsolutePath());
		URI tempDiagramModelURI = URI.createFileURI(file.getAbsolutePath() + ".tmp");
		
		// create file resource: use temporary file, is resource exists
		boolean merge = file.exists();
		Resource createdResource  = resourceSet.createResource( merge ? tempDiagramModelURI : diagramModelURI );
		Resource existingResource = merge ? resourceSet.getResource(diagramModelURI, true) : null;
		
		try {
			// write and save resource
			AbstractTransactionalCommand command = new CreateAgentworldDiagramCommand(editingDomain, agentWorld, createdResource, existingResource);
			OperationHistoryFactory.getOperationHistory().execute(command,
					new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			 // XXX For no apparent reason, an exception is thrown, saying that
			 // the transaction is already closing. However, this seems not to be
			 // doing any harm, so we'll just continue... 
		}
		
		if (existingResource != null) {
			existingResource.save(null);
		} else {
			createdResource.save(null);
		}
		return true;
	}
	CREATION OF AGENT WORLD DIAGRAM (deprecated) */
	
	/**
	 * Command for creating Agent World Diagram from Model and merging it with 
	 * existing AWE file
	 * 
	 * @author kuester
	 */
	/* CREATION OF AGENT WORLD DIAGRAM (deprecated)
	class CreateAgentworldDiagramCommand extends AbstractTransactionalCommand {
		private final AgentWorld model;
		private final Resource created;
		private final Resource existing;
		
		protected CreateAgentworldDiagramCommand(TransactionalEditingDomain editingDomain, AgentWorld model, Resource created, Resource existing) {
			super(editingDomain, Messages.AgentworldNewDiagramFileWizard_InitDiagramCommand, null);
			this.model = model;
			this.created = created;
			this.existing = existing;
		}
		
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			// create diagram and do layout
			Diagram diagram = ViewService.createDiagram(
					model,
					AgentWorldEditPart.MODEL_ID,
					AgentworldDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			created.getContents().add(diagram);
			created.getContents().add(diagram.getElement());
			new AgentworldDiagramContentInitializer().initDiagramContent(diagram);
			LayoutService.getInstance().layout(diagram, LayoutType.DEFAULT);
			
			if (existing != null) {
				// merge with existing
				DiagramImporter importer = new AweDiagramImporter(
						Collections.singletonList(created), existing, true, true, true);
				importer.doImport();
			}
			return CommandResult.newOKCommandResult();
		}
	}
	CREATION OF AGENT WORLD DIAGRAM (deprecated) */
}
