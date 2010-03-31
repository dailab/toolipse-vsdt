package de.dailab.vsdt.trafo.jiacv.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutService;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;

import de.dailab.agentworld.AgentWorld;
import de.dailab.agentworld.diagram.edit.parts.AgentWorldEditPart;
import de.dailab.agentworld.diagram.part.AgentworldDiagramContentInitializer;
import de.dailab.agentworld.diagram.part.AgentworldDiagramEditorPlugin;
import de.dailab.agentworld.diagram.part.AgentworldDiagramEditorUtil;
import de.dailab.agentworld.diagram.part.Messages;
import de.dailab.agentworldeditor.util.imprt.AweDiagramImporter;
import de.dailab.common.gmf.imprt.DiagramImporter;
import de.dailab.jiactng.jadl.Agent;
import de.dailab.jiactng.jadl.ontology.JadlParseException;
import de.dailab.jiactng.jadl.util.SimpleJadlParser;
import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.base.logger.TrafoLog;

public class JiacVResultSaver extends MappingResultSaver {

	/** group services by use case, of by participant? */
	public static boolean groupByUsecase= true;
	
	/**
	 * @param folder	folder where to save the stuff
	 * @return			successfully saved?
	 */
	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		JiacVExportWrapper wrapper= (JiacVExportWrapper) this.wrapper;
		for (Agent model : wrapper.getJadlFiles()) {
			String fileName= wrapper.getJadlFileName(model);
				
			// save JADL model as XML
//				saveAsXmlResource(new File(baseDirectory, fileName + EXT_XML), model, null, null);
			// save JADL source code
			saveJadl(new File(baseDirectory, fileName), model);
		}
		// TODO
//		for (JiacVStarterRule starterRule : wrapper.getStarterRules()) {
//		}
		AgentWorld agentWorld= wrapper.getAgentWorld();
		if (agentWorld != null) {
			String fileName= wrapper.getAweFileName(agentWorld, true);
			
			// save AWE diagram
			saveAgentWorldDiagram(new File(baseDirectory, fileName), agentWorld);
		}
		return true;
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
			source= SimpleJadlParser.getInstance().serializeShort(model);
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
	
	/**
	 * Save Agent World Model to diagram file and automatically do the layout
	 * 
	 * @param file			File where to save the diagram
	 * @param agentWorld	Agent World model to be saved
	 * @return				saving successful? otherwise the model can still be saved to XML
	 * @throws IOException
	 */
	private boolean saveAgentWorldDiagram(File file, AgentWorld agentWorld) throws IOException {
		
		TransactionalEditingDomain editingDomain= GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		ResourceSet resourceSet = editingDomain.getResourceSet();

		URI diagramModelURI = URI.createFileURI(file.getAbsolutePath());
		URI tempDiagramModelURI = URI.createFileURI(file.getAbsolutePath() + ".tmp");
		
		// create file resource: use temporary file, is resource exists
		boolean merge = file.exists();
		Resource resource = resourceSet.createResource( merge ? tempDiagramModelURI : diagramModelURI );
		
		try {
			// write and save resource
			AbstractTransactionalCommand command = new CreateAgentworldDiagramCommand(editingDomain, resource, agentWorld);
			OperationHistoryFactory.getOperationHistory().execute(command,
					new NullProgressMonitor(), null);
			resource.save(AgentworldDiagramEditorUtil.getSaveOptions());

			// if resource existed, merge resources and delete temporary file
			if (merge) {
				Resource existingResource = resourceSet.getResource(diagramModelURI, true);
				command = new MergeDiagramsCommand(editingDomain, resource, existingResource);
				OperationHistoryFactory.getOperationHistory().execute(command,
						new NullProgressMonitor(), null);
			}
		} catch (ExecutionException e) {
			TrafoLog.warn("Unable to create Agent World Diagram.");
			return false;
		}
		return true;
	}
	
	/**
	 * Command for creating Agent World Diagram from Model
	 * 
	 * @author kuester
	 */
	class CreateAgentworldDiagramCommand extends AbstractTransactionalCommand {
		private final AgentWorld model;
		private final Resource diagramResource;
		
		protected CreateAgentworldDiagramCommand(TransactionalEditingDomain editingDomain, Resource resource, AgentWorld model) {
			super(editingDomain, Messages.AgentworldNewDiagramFileWizard_InitDiagramCommand, null);
			this.model = model;
			this.diagramResource = resource;
		}
		
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			Diagram diagram = ViewService.createDiagram(
					model,
					AgentWorldEditPart.MODEL_ID,
					AgentworldDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			diagramResource.getContents().add(diagram);
			diagramResource.getContents().add(diagram.getElement());
			new AgentworldDiagramContentInitializer().initDiagramContent(diagram);
			
			// do layout
			LayoutService.getInstance().layout(diagram, LayoutType.DEFAULT);
			
			return CommandResult.newOKCommandResult();
		}
	
	}
	
	/**
	 * Command for merging new with old Agent World Diagram
	 * 
	 * @author kuester
	 */
	class MergeDiagramsCommand extends AbstractTransactionalCommand {
		protected final Resource created;
		protected final Resource existing;
		
		protected MergeDiagramsCommand(TransactionalEditingDomain editingDomain, Resource created, Resource existing) {
			super(editingDomain, Messages.AgentworldNewDiagramFileWizard_InitDiagramCommand, null);
			this.created = created;
			this.existing = existing;
		}
		
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			try {
				DiagramImporter importer = new AweDiagramImporter(
						Collections.singletonList(created), existing, true, true, true);
				importer.doImport();
				created.delete(null);
			} catch (IOException e) {
				return CommandResult.newErrorCommandResult(e);
			}
			return CommandResult.newOKCommandResult();
		}
	
	}
	
}
