package de.dailab.vsdt.diagram.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @generated
 */
public class VsdtCreationWizard extends Wizard implements INewWizard {

	/**
	 * @generated
	 */
	private IWorkbench workbench;

	/**
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * @generated
	 */
	protected VsdtCreationWizardPage diagramModelFilePage;

	/**
	 * @generated
	 */
	protected VsdtCreationWizardPage domainModelFilePage;

	/**
	 * @generated
	 */
	protected Resource diagram;

	/**
	 * @generated
	 */
	private boolean openNewlyCreatedDiagramEditor = true;

	/**
	 * @generated
	 */
	public IWorkbench getWorkbench() {
		return workbench;
	}

	/**
	 * @generated
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	 * @generated
	 */
	public final Resource getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void setOpenNewlyCreatedDiagramEditor(
			boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(Messages.VsdtCreationWizardTitle);
		setDefaultPageImageDescriptor(VsdtDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewVsdtWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * do not create domainModelFilePage
	 * 
	 * @generated NOT
	 */
	public void addPages() {
		diagramModelFilePage = new VsdtCreationWizardPage(
				"DiagramModelFile", getSelection(), "bpmn_diagram"); //$NON-NLS-1$ //$NON-NLS-2$
		diagramModelFilePage
				.setTitle(Messages.VsdtCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage
				.setDescription(Messages.VsdtCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

//		domainModelFilePage = new VsdtCreationWizardPage(
//				"DomainModelFile", getSelection(), "bpmn"); //$NON-NLS-1$ //$NON-NLS-2$
//		domainModelFilePage
//				.setTitle(Messages.VsdtCreationWizard_DomainModelFilePageTitle);
//		domainModelFilePage
//				.setDescription(Messages.VsdtCreationWizard_DomainModelFilePageDescription);
//		addPage(domainModelFilePage);
	}

	/**
	 * Model File is automatically created with the same name
	 * 
	 * @generated NOT
	 */
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor)
					throws CoreException, InterruptedException {
				URI diagramURI= diagramModelFilePage.getURI();
				String modelName= diagramURI.toString().replace(".bpmn_diagram", ".bpmn");
				URI modelURI= URI.createURI(modelName);
				diagram = VsdtDiagramEditorUtil.createDiagram(diagramURI, modelURI, monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						VsdtDiagramEditorUtil.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog.openError(getContainer().getShell(),
								Messages.VsdtCreationWizardOpenEditorError,
								null, e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(getContainer().getShell(),
						Messages.VsdtCreationWizardCreationError, null,
						((CoreException) e.getTargetException()).getStatus());
			} else {
				VsdtDiagramEditorPlugin.getInstance().logError(
						"Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}
}
