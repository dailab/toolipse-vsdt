package de.dailab.vsdt.meta.diagram.part;

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

import de.dailab.vsdt.diagram.part.VsdtCreationWizardOptionsPage;

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
	 * @generated NOT
	 */
	protected VsdtCreationWizardOptionsPage optionsPage;

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
		setDefaultPageImageDescriptor(VsdtMetaDiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewVsdtWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * + options page
	 * @generated NOT
	 */
	public void addPages() {
		diagramModelFilePage = new VsdtCreationWizardPage(
				"DiagramModelFile", getSelection(), "vsdtd"); //$NON-NLS-1$ //$NON-NLS-2$
		diagramModelFilePage
				.setTitle(Messages.VsdtCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage
				.setDescription(Messages.VsdtCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

		// BEGIN @generated NOT
		optionsPage = new VsdtCreationWizardOptionsPage() {
			@Override
			public void setVisible(boolean visible) {
				if (visible && getDiagramName() == null) {
					// guess Diagram Name from file name
					String fileName = diagramModelFilePage.getFileName();
					fileName = fileName.substring(0, fileName.length()
							- ".vsdtd".length()); //$NON-NLS-1$
					setDiagramName(fileName);
				}
				super.setVisible(visible);
			}
		};
		addPage(optionsPage);
		// END @generated NOT
	}

	/**
	 * + pass options page to createDiagram method
	 * @generated NOT
	 */
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor)
					throws CoreException, InterruptedException {

				// BEGIN @generated NOT
				URI diagramURI = diagramModelFilePage.getURI();
				diagram = VsdtDiagramEditorUtil.createDiagram(diagramURI,
						monitor, optionsPage);
				// END @generated NOT

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
				VsdtMetaDiagramEditorPlugin.getInstance().logError(
						"Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}

}
