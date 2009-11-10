package de.dailab.vsdt.trafo.jiacv.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import de.dailab.agentworld.AgentWorld;
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
					
				// save file as XML
//				saveAsXml(new File(baseDirectory, fileName + EXT_XML), model);
				
				saveJadl(new File(baseDirectory, fileName + EXT_JADL), model);
			}
			if (object instanceof AgentWorld) {
				AgentWorld agentWorld= (AgentWorld) object;
				String fileName= agentWorld.getName();
				saveAsXml(new File(baseDirectory, fileName + EXT_AWE_MODEL), agentWorld);
				
				// generate AWE diagram
				createDiagramFile(agentWorld, fileName);
			}
		}
		return true;
	}
	
	private void saveAsXml(File file, EObject eObject) throws IOException {
		Resource res= new XMLResourceImpl(URI.createFileURI(file.getAbsolutePath()));
		res.getContents().add(eObject);
		res.save(null);
	}
	
	private void saveJadl(File file, Agent model) throws IOException {
//		GenericXTextVisitor modelVisitor= JadlVisitor.getInstance();
//		String source= modelVisitor.visitEObject(model);
		String source= null;
		try {
			source= new SimpleJadlParser().serializeShort(model);
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
	 * TODO
	 * {@link AgentworldInitDiagramFileAction}
	 * {@link AgentworldNewDiagramFileWizard} 
	 */
	private void createDiagramFile(AgentWorld agentWorld, String fileName) {
		// see AgentworldInitDiagramFileAction 
		
//		try {
//			Resource resource = resourceSet.getResource(domainModelURI, true);
//			diagramRoot = (EObject) resource.getContents().get(0);
//		} catch (WrappedException ex) {
//			AgentworldDiagramEditorPlugin.getInstance().logError(
//					"Unable to load resource: " + domainModelURI, ex); //$NON-NLS-1$
//		}
		
		
//		List affectedFiles = new LinkedList();
//		IFile diagramFile = null; //myFileCreationPage.createNewFile();
//		AgentworldDiagramEditorUtil.setCharset(diagramFile);
//		affectedFiles.add(diagramFile);
//		URI diagramModelURI = null; //URI.createPlatformResourceURI(diagramFile.getFullPath().toString(), true);
//		ResourceSet resourceSet = null; //myEditingDomain.getResourceSet();
//		final Resource diagramResource = resourceSet
//				.createResource(diagramModelURI);
		
		
		
//		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
//				myEditingDomain,
//				Messages.AgentworldNewDiagramFileWizard_InitDiagramCommand,
//				affectedFiles) {
//
//			protected CommandResult doExecuteWithResult(
//					IProgressMonitor monitor, IAdaptable info)
//					throws ExecutionException {

		
//				int diagramVID = AgentworldVisualIDRegistry
//						.getDiagramVisualID(diagramRootElementSelectionPage
//								.getModelElement());
//				if (diagramVID != AgentWorldEditPart.VISUAL_ID) {
//					return;
//				}
//				Diagram diagram = ViewService.createDiagram(
//						diagramRootElementSelectionPage.getModelElement(),
//						AgentWorldEditPart.MODEL_ID,
//						AgentworldDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
//				diagramResource.getContents().add(diagram);
//				diagramResource.getContents().add(diagram.getElement());
//				new AgentworldDiagramContentInitializer()
//						.initDiagramContent(diagram);
		
		
		
//				return CommandResult.newOKCommandResult();
//			}
//		};
//		try {
//			OperationHistoryFactory.getOperationHistory().execute(command,
//					new NullProgressMonitor(), null);
//			diagramResource.save(AgentworldDiagramEditorUtil.getSaveOptions());
//			AgentworldDiagramEditorUtil.openDiagram(diagramResource);
//		} catch (ExecutionException e) {
//			AgentworldDiagramEditorPlugin.getInstance().logError(
//					"Unable to create model and diagram", e); //$NON-NLS-1$
//		} catch (IOException ex) {
//			AgentworldDiagramEditorPlugin.getInstance().logError(
//					"Save operation failed for: " + diagramModelURI, ex); //$NON-NLS-1$
//		} catch (PartInitException ex) {
//			AgentworldDiagramEditorPlugin.getInstance().logError(
//					"Unable to open editor", ex); //$NON-NLS-1$
//		}
		
		
	}
	
}
