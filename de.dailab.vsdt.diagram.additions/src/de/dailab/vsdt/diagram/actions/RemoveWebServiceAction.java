package de.dailab.vsdt.diagram.actions;

import javax.wsdl.Definition;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.dailab.vsdt.diagram.views.webservices.WebSeviceAccessor;

/**
 * This Action is used to remove the selected item from the given Viewer.
 * 
 * @author kuester
 */
public class RemoveWebServiceAction extends Action {

	public static final String TEXT= "Remove Web Service";
	public static final String TOOLTIP= "Removes the selected Web service from the list";
	
	public static final String DIALOG_REMOVE_TITLE= "Remove Web Service?";

	private final Viewer viewer;
	private final WebSeviceAccessor accessor;
	
	/**
	 * @param viewer	The viewer to remove the selected item from
	 */
	public RemoveWebServiceAction(Viewer viewer) {
		this.viewer= viewer;
		this.accessor= (WebSeviceAccessor) viewer.getInput();
		this.setText(TEXT);
		this.setToolTipText(TOOLTIP);
		this.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
	}
	
	@Override
	public void run() {
		// open input dialog and ask for URL
		IWorkbenchWindow window= PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (MessageDialog.openConfirm(window.getShell(), DIALOG_REMOVE_TITLE, DIALOG_REMOVE_TITLE)) {
			Object selection= ((IStructuredSelection) viewer.getSelection()).getFirstElement();
			if (selection instanceof Definition) {
				accessor.getDefinition().remove((Definition) selection);
				viewer.refresh();
			}
		}
	}
}
