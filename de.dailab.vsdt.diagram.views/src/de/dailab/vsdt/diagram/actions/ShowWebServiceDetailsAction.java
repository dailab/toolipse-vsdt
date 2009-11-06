package de.dailab.vsdt.diagram.actions;

import javax.wsdl.Definition;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import de.dailab.vsdt.diagram.dialogs.WSDLDetailsDialog;

/**
 * When executed, this action shows detailed information about the selected service.
 * 
 * @author kuester
 */
public class ShowWebServiceDetailsAction extends Action {

	public static final String TEXT= "Show Web Service Details";
	public static final String TOOLTIP= "Opens a dialog showing the details for the selected service.";

	private final Viewer viewer;
	
	public ShowWebServiceDetailsAction(Viewer viewer) {
		this.viewer= viewer;
		this.setText(TEXT);
		this.setToolTipText(TOOLTIP);
		this.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
	}
	
	@Override
	public void run() {
		Object selection= ((IStructuredSelection) viewer.getSelection()).getFirstElement();
		if (selection instanceof Definition) {
			Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			new WSDLDetailsDialog(shell, (Definition) selection).open();
		}
	}
}
