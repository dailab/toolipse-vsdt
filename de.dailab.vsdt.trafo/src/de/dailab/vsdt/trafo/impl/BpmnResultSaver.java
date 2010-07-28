package de.dailab.vsdt.trafo.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.diagram.part.Messages;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessSystemEditPart;
import de.dailab.vsdt.meta.diagram.part.VsdtDiagramEditorUtil;
import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.base.util.TrafoLog;

/**
 * Default implementation of MappingResultSaver to be used for BPMN files. This 
 * class can be used for importing BPMN diagrams from other sources, e.g. BPEL.
 * 
 * @author kuester
 */
public class BpmnResultSaver extends MappingResultSaver {

	public static boolean createDiagramFile= true;
	
	public static boolean createModelFile= true;
	
	/** file extensions */
	public static final String EXT= ".vsdt";
	
	/** 
	 * this suffix is inserted between the filename and the extension, e.g. to 
	 * distinguish from existing files with same extension when importing from 
	 * other BPMN editors
	 */
	private String suffix= "";

	/**
	 * Save the result to a couple of BPEL and WSDL files for each pool/process 
	 * in the diagram. Additionally the content of the log list can be saved to 
	 * a text file.
	 * 
	 * @param path		path where to save the stuff
	 * @return			successfully saved?
	 */
	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		//iterate over all BPDs in the list
		for (Object object : wrapper.getTargetModels()) {
			if (object instanceof BusinessProcessSystem) {
				BusinessProcessSystem bps= (BusinessProcessSystem) object;
				
				if (createModelFile) {
					// create model file
					File file= new File(baseDirectory, bps.getNameOrId() + suffix + EXT);
					Map<Object, Object> options = new HashMap<Object, Object>();
					options.put(XMLResource.OPTION_ENCODING, "UTF-8");
					saveAsXmlResource(file, bps, options, null); // Problem with IDs when using VSDT resource factory
				}
				if (createDiagramFile) {
					//create diagram file
					File file= new File(baseDirectory, bps.getNameOrId() + suffix + ".vsdtd");
					saveVSDTDiagram(file, bps);
				}
			}
		}
		return true;
	}
	
	public void setSuffix(String suffix) {
		this.suffix= suffix;
	}
	
	/**
	 * Save VSDT Model to diagram file.
	 * 
	 * @param file			File where to save the diagram
	 * @param bpd			VSDT model to be saved
	 * @return				saving successful? otherwise the model can still be saved to XML
	 * @throws IOException
	 */
	private boolean saveVSDTDiagram(File file, BusinessProcessSystem bps) throws IOException {
		
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
		final BusinessProcessSystem model= bps;

		AbstractTransactionalCommand command = new AbstractTransactionalCommand(
				editingDomain,
				Messages.VsdtNewDiagramFileWizard_InitDiagramCommand,
				null) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				Diagram diagram = ViewService.createDiagram(
						model,
						BusinessProcessSystemEditPart.MODEL_ID,
						VsdtDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				diagramResource.getContents().add(diagram);
				diagramResource.getContents().add(diagram.getElement());
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command,
					new NullProgressMonitor(), null);
			diagramResource.save(VsdtDiagramEditorUtil.getSaveOptions());
			return true;
		} catch (ExecutionException e) {
			TrafoLog.warn("Unable to create diagram file; creating model file instead");
			return false;
		}
	}

}
