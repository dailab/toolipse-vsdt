package de.dailab.vsdt.diagram.actions;

import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

import de.dailab.vsdt.diagram.rsd.IRsdClient;
import de.dailab.vsdt.diagram.rsd.IRsdWS;
import de.dailab.vsdt.diagram.rsd.VsdtRsdPlugin;
import de.dailab.vsdt.diagram.views.rsd.RsdView;

/**
 * When executed, this action asks the RSD client for all services. If there are any services
 * available on the RSD, the services are shown in the RSD view, else a message pops up, saying
 * that no services can be found.
 * 
 * @author kuester
 */
public class RefreshServicesAction extends Action {

	public static final String TEXT= "Get Services";
	public static final String TOOLTIP= "Sends an inquiry for new services to the RSD" +
			" and display the services in the view.";
	public static final String NO_SERVICES= "No Services seem to be registered. Are you sure the URL is pointing to an RSD?";
	public static final String NOT_CONNECTED= "The Client is currently not connected.";

	private RsdView view;
	
	public RefreshServicesAction(RsdView view) {
		this.view= view;
		this.setText(TEXT);
		this.setToolTipText(TOOLTIP);
		this.setImageDescriptor(VsdtRsdPlugin.getImageDescriptor(VsdtRsdPlugin.IMAGE_REFRESH));
	}
	
	@Override
	public void run() {
		IRsdClient client= view.getClient();
		if (client != null && client.isConnected()) {
			List<IRsdWS> services= client.getAllServices();
			view.getViewer().refresh();
			if (services.isEmpty()) {
				MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), TEXT, NO_SERVICES);
			}
		} else {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), TEXT, NOT_CONNECTED);
		}
	}
	
}
