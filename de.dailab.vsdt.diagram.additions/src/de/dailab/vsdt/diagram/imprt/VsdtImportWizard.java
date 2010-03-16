package de.dailab.vsdt.diagram.imprt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;


public class VsdtImportWizard extends Wizard implements IImportWizard {
	
	private static final String NL = System.getProperty("line.separator");
	private static final String TITLE= "Import and Merge VSDT Diagrams";
	private static final String SUCCESS_TITLE= "Import Complete";
	private static final String SUCCESS_MESSAGE= "Import completed.";
	private static final String SUCCESS_WARN_MESSAGE= "Import completed with warnings.";
	private static final String ERROR_TRAFO_TITLE= "Import Error";
	private static final String ERROR_TRAFO_MESSAGE= "An error occured during Import.";
	
	/** the options page */
	protected VsdtImportWizardOptionsPage optionsPage= null;
	
	/** the selected file(s) */
	protected IStructuredSelection selection= new StructuredSelection();
	
	public VsdtImportWizard() {
		this.setWindowTitle(TITLE);
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		if (selection instanceof TreeSelection) {
			this.selection= selection;	
		}
	}
	
	public void addPages() {
		optionsPage= new VsdtImportWizardOptionsPage(TITLE, selection); 
		this.addPage(optionsPage);
	}
	
	@Override
	public boolean performFinish() {
		List<Resource> from= new ArrayList<Resource>();
		for (IFile file : optionsPage.getSelectedResources()) {
			URI fileURI = URI.createFileURI(
					new File(file.getLocationURI()).getAbsolutePath());
			from.add(getResource(fileURI));
		}
		Resource to= getResource(optionsPage.getPath());
		boolean backup= optionsPage.isDoBackup();
		boolean layout= optionsPage.isDoLayout();
		boolean merge= optionsPage.isDoMerge();
		VsdtDiagramImporter importer= new VsdtDiagramImporter(from, to, backup, layout, merge);
		
		try {
			importer.doImport();
		} catch (Exception e) {
			e.printStackTrace();
			String message= e.getStackTrace().length > 0 ? message= e.getStackTrace()[0].toString() : e.getMessage();
			MessageDialog.openError(this.getShell(), ERROR_TRAFO_TITLE, ERROR_TRAFO_MESSAGE + NL + message);
			return false;
		}
		if (! importer.getErrors().isEmpty()) {
			MessageDialog.openError(this.getShell(), ERROR_TRAFO_TITLE, ERROR_TRAFO_MESSAGE);
		} else if (! importer.getWarnings().isEmpty()) {
			MessageDialog.openWarning(this.getShell(), SUCCESS_TITLE, SUCCESS_WARN_MESSAGE);
		} else {
			MessageDialog.openInformation(this.getShell(), SUCCESS_TITLE, SUCCESS_MESSAGE);
		}

		// refresh directory 
		try {
			WorkspaceSynchronizer.getFile(to).getParent().refreshLocal(1, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		return true;
	}
	
	/**
	 * Get EMF Resource for a given file URI.
	 * 
	 * @param uri	URI of the source file
	 * @return		EMF Resource Object
	 */
	protected Resource getResource(URI uri) {
		ResourceSet resourceSet= new ResourceSetImpl();
		Resource resource= resourceSet.getResource(uri, true);
		return resource;
	}
	
}
