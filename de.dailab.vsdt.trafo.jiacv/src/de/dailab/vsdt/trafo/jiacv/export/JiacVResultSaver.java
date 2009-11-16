package de.dailab.vsdt.trafo.jiacv.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
import de.dailab.jiactng.jadl.Agent;
import de.dailab.jiactng.jadl.ontology.JadlParseException;
import de.dailab.jiactng.jadl.util.SimpleJadlParser;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.base.logger.TrafoLog;

public class JiacVResultSaver extends MappingResultSaver {

	public static final String EXT_JADL=		".jadl";
	public static final String EXT_XML=			".xml";
	public static final String EXT_AWE_MODEL=	".agentworld";
	public static final String EXT_AWE_DIAGRAM=	".awe";
	
	/** group services by use case, of by participant? */
	public static boolean groupByUsecase= true;
	
	/**
	 * @param folder	folder where to save the stuff
	 * @return			successfully saved?
	 */
	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		for (Object object : wrapper.getTargetModels()) {
			if (object instanceof Agent) {
				Agent model= (Agent) object;

				// Name of the JADL file
				Pool originalPool= ((JiacVExportWrapper) wrapper).getPool(model);
				String poolName= originalPool.getName();
				String bpdName= originalPool.getParentDiagram().getName();
				String roleName= originalPool.getParticipant().getName();

				String fileName= groupByUsecase
						? ( bpdName + FILE_SEP + roleName + "_" + poolName )
						: ( roleName + FILE_SEP + bpdName + "_" + poolName );
					
				// save JADL model as XML
//				saveAsXmlResource(new File(baseDirectory, fileName + EXT_XML), model, null, null);
				
				// save JADL source code
				saveJadl(new File(baseDirectory, fileName + EXT_JADL), model);
			}
			if (object instanceof AgentWorld) {
				AgentWorld agentWorld= (AgentWorld) object;
				String fileName= agentWorld.getName();
				
				// save AWE diagram
				if (! saveAgentWorldDiagram(new File(baseDirectory, fileName + EXT_AWE_DIAGRAM), agentWorld)) {
					// save AWE model file
					saveAsXmlResource(new File(baseDirectory, fileName + EXT_AWE_MODEL), agentWorld, null, null);
				}
			}
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
		Resource resource= null;
		if (file.exists()) {
			resource = resourceSet.getResource(diagramModelURI, true);
			resource.delete(null);
		}
		resource = resourceSet.createResource(diagramModelURI);
		
		final Resource diagramResource= resource;
		final AgentWorld model= agentWorld;
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				editingDomain,
				Messages.AgentworldNewDiagramFileWizard_InitDiagramCommand,
				null) {
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
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					new NullProgressMonitor(), null);
			diagramResource.save(AgentworldDiagramEditorUtil.getSaveOptions());
			return true;
		} catch (ExecutionException e) {
			TrafoLog.warn("Unable to create Agent World Diagram; creating model file instead");
			return false;
		}
	}
	
}
