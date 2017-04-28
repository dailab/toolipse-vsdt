package de.dailab.vsdt.vsdtagents;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessSystemEditPart;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizard;

/**
 * Utility Class providing functionality needed for more than one view.
 * 
 * @author kuester
 */
public class Util {

	public static final String NL = System.getProperty("line.separator");


	/**
	 * @param starters	optional list to be filled with starter rules, or null (only for VSDT)
	 * @return	Service Sources from current Editor Input
	 */
	public static List<String> getServiceSrcs(Map<String, Serializable[]> starterRules) throws Exception {
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		List<String> serviceSrcs = null;
		if (editor != null) {
			IEditorInput input = editor.getEditorInput();
			// check whether editor is JADL or VSDT editor
			// read content of current editor
			if (input instanceof FileEditorInput) {
				IFile file = ((FileEditorInput) input).getFile();
				if (file.getName().endsWith(".jadl")) {
					serviceSrcs = getSrcFromJadlFile(file.getContents());
				} else
				if (file.getName().endsWith(".vsdtd")) {
					URI fileUri = URI.createURI(file.getLocationURI().toString());
					serviceSrcs = getSrcFromVsdtFile(fileUri, starterRules);
				}
			}
			if (input instanceof URIEditorInput) {
				URI uri = ((URIEditorInput) input).getURI();
				if ("vsdtd".equals(uri.fileExtension())) {
					serviceSrcs = getSrcFromVsdtFile(uri, starterRules);
				}
			}
		}
		return serviceSrcs;
	}

	
	/**
	 * Read JADL Source code from a given JADL file, basically just opening
	 * the file in an input steam and reading the contents.
	 * 
	 * @param fileIS	input stream for some JADL file
	 * @return			content of the file
	 * @throws Exception
	 */
	public static List<String> getSrcFromJadlFile(InputStream fileIS) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(fileIS));
		StringBuffer buffer = new StringBuffer();
		for (String line = reader.readLine(); line != null; line= reader.readLine()) {
			buffer.append(line).append(NL);
		}
		reader.close();
		String serviceSrc = buffer.toString();
		return Collections.singletonList(serviceSrc);
	}
	
	
	/**
	 * Read VSDT source file, transform content to temporary JADL services,
	 * read JADL files and return the contents.
	 * 
	 * @param uri		URI of some VSDT file
	 * @param starters	optional list to be filled with starter rules, or null
	 *                  Starter Rules is map (Service to Start -> Event (e.g. a Message)
	 * @return			content of JADL files generated from VSDT file
	 * @throws Exception
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static List<String> getSrcFromVsdtFile(URI uri, Map<String, Serializable[]> starterRules) throws Exception {
		List<String> serviceSrcs = new ArrayList<String>();
		// invoke transformation for given file
		
		try {
			// using reflection so we do not need reference to JADL++ module
			Class wizardClass = Class.forName("de.dailab.vsdt.trafo.jiacv.wizard.Bpmn2JiacVExportWizard");
			Class resultClass = Class.forName("de.dailab.vsdt.trafo.jiacv.export.JiacVResultSaver");
			
			BpmnExportWizard wizard = (BpmnExportWizard) wizardClass.newInstance();
			Object sourceObject = wizard.getSouceObject(uri);
			wizard.performTransformation(sourceObject, null);
			try {
				serviceSrcs = (List) resultClass.getMethod("getServiceSources").invoke(wizard.getResultSaver());
				if (starterRules != null) {
					Map<String, Serializable[]> rules = (Map) resultClass.getMethod("getStarterRulesSimple").invoke(wizard.getResultSaver());
					starterRules.putAll(rules);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			System.err.println("Could not create JADL Sources: JADL++ Transformation not found!");
		}
		
		return serviceSrcs;
	}

	/**
	 * Get the URI of the currently active editor, if it is some sort of 
	 * File- or URI-editor, otherwise return null.
	 * 
	 * Note: this does not work if the editor is a sub-editor, e.g. a 
	 * VSDT diagram editor as opposed to a VSDT meta diagram editor.
	 * 
	 * @return		URI of active file- or URI-editor, or null
	 */
	public static URI getEditorUri() {
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editor != null) {
			IEditorInput input = editor.getEditorInput();
			URI uri = null;
			if (input instanceof FileEditorInput) {
				IFile file = ((FileEditorInput) input).getFile();
				uri = URI.createURI(file.getLocationURI().toString());
			}
			if (input instanceof URIEditorInput) {
				uri = ((URIEditorInput) input).getURI();
			}
			return uri;
		}
		return null;
	}
	
	/**
	 * Try to get the Business Process System object from the currently active 
	 * VSDT editor, if any. If no VSDT editor is opened, returns null.
	 * works for both VSDT "Meta" and VSDT "BPMN" editors.
	 * 
	 * @param editor	the editor part to use, or null to get active editor
	 * @return 			the BPS in the currently opened VSDT editor, if any, or null
	 */
	public static BusinessProcessSystem getVsdtModelBps(IEditorPart editor) {
		if (editor == null) {
			editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		}
		if (editor instanceof de.dailab.vsdt.meta.diagram.part.VsdtDiagramEditor) {
			de.dailab.vsdt.meta.diagram.part.VsdtDiagramEditor vsdteditor = (de.dailab.vsdt.meta.diagram.part.VsdtDiagramEditor) editor;
			BusinessProcessSystemEditPart editPart = (BusinessProcessSystemEditPart) vsdteditor.getDiagramEditPart(); 
			return (BusinessProcessSystem) ((View) editPart.getModel()).getElement();
		}
		if (editor instanceof VsdtDiagramEditor) {
			VsdtDiagramEditor vsdteditor = (VsdtDiagramEditor) editor;
			BusinessProcessDiagramEditPart editPart = (BusinessProcessDiagramEditPart) vsdteditor.getDiagramEditPart();
			return editPart.getCastedModel().getParent();
		}
		return null;
	}
	
	/**
	 * Try to get the Business Process Diagram object from the currently active
	 * VSDT editor, if any. If no VSDT BPMN editor is opened, return null.
	 *
	 * @param editor	the editor part to use, or null to get active editor
	 * @return			the BPD is the currently opened VSDT BPMN editor, if any, or null
	 */
	public static BusinessProcessDiagram getVsdtModelBpd(IEditorPart editor) {
		if (editor == null) {
			editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		}
		if (editor instanceof VsdtDiagramEditor) {
			VsdtDiagramEditor vsdteditor = (VsdtDiagramEditor) editor;
			BusinessProcessDiagramEditPart editPart = (BusinessProcessDiagramEditPart) vsdteditor.getDiagramEditPart();
			return editPart.getCastedModel();
		}
		return null;
	}

//	public static void waitForNode(){
//		//Wait for node to be initialized
//		while(!JiacNodePlugin.getDefault().isInitialized()){
//			try{
//				Thread.sleep(400);
//			} catch(Exception e){
//				e.printStackTrace();
//			}
//		}
//	}

//	/**
//	 * Read VSDT source file, transform content to temporary JADL services,
//	 * read JADL files and return the contents.
//	 * 
//	 * @param uri		URI of some VSDT file
//	 * @return			content of JADL files generated from VSDT file
//	 * @throws Exception
//	 */
//	public static List<String> getSrcFromVsdtFile(URI uri, Map<String, Serializable> starterRules) throws Exception {
//		List<String> serviceSrcs = new ArrayList<String>();
//		
//		// invoke transformation for given file
//		Bpmn2JiacVExportWizard wizard = new Bpmn2JiacVExportWizard();
//		Object sourceObject = wizard.getSouceObject(uri);
//		String targetDirectory = System.getProperty("user.home") + "/__DEPLOY_FROM_VSDT_TMP/";
//		wizard.performTransformation(sourceObject, targetDirectory);
//		
//		// search for JADL files in temporary directory
//		File tmpDir = new File(targetDirectory);
//		getAllJadlSources(tmpDir, serviceSrcs);
//		for (File dir : tmpDir.listFiles()) {
//			if (dir.isDirectory()) {
//				for (File file : dir.listFiles()) {
//					// parse JADL files
//					if (file.getName().endsWith(".jadl")) {
//						serviceSrcs.addAll(getSrcFromJadlFile(new FileInputStream(file)));
//					}
//					// delete visited files (JADL or otherwise)
//					file.delete();
//				}
//			}
//			// delete visited files and directories
//			dir.delete();
//		}
//		
//		// delete temporary directory
//		tmpDir.delete();
//		
//		return serviceSrcs;
//	}

	
//	/**
//	 * Recursively find all JADL sources in the given directory, and delete all
//	 * the temporary files on the fly.
//	 * 
//	 * @param dir				some temporary(!!) directory
//	 * @param serviceSources	list of service sources to be filled
//	 */
//	private static void getAllJadlSources(File dir, List<String> serviceSources) throws Exception {
//		for (File file : dir.listFiles()) {
//			if (file.isDirectory()) {
//				// descend into directories
//				getAllJadlSources(file, serviceSources);
//			} else if (file.getName().endsWith(".jadl")) {
//				// add jadl source
//				serviceSources.addAll(getSrcFromJadlFile(new FileInputStream(file)));
//			}
//			// delete visited files and directories
//			file.delete();
//		}
//	}
	
}
