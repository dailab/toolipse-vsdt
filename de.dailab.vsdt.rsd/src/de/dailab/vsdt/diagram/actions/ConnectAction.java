package de.dailab.vsdt.diagram.actions;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;

import de.dailab.vsdt.diagram.rsd.IRsdClient;
import de.dailab.vsdt.diagram.rsd.VsdtRsdPlugin;
import de.dailab.vsdt.diagram.rsd.client.Axis2RsdClient;
import de.dailab.vsdt.diagram.views.rsd.RsdView;

/**
 * When executed, this action connects to the RSD using the RsdView's client object.
 *  First, a dialog is opened and the user is prompted for a repository location. If no
 * location is given, then the default-location (which is provided by the client) is chosen
 * by passing null to the client.
 * Next, the client connects to the RSD. If the connection has been established, existing
 * services are fetched by executing the GetServicesAction, else a dialog pops up, saying
 * that there was a problem connecting to the RSD.
 * 
 * @author kuester
 */
public class ConnectAction extends Action {

	public static final String TEXT= "Connect to RSD";
	public static final String TOOLTIP= "Connects to a Rich Service Directory.";
	public static final String CONNECTION_FAILED= "Connection to RSD failed.";
	public static final String DIALOG_MESSAGE= "Please specify the URL of the Rich Sercice Directory to use. " +
			"If no value is given, the default repository will be used.";
	public static final String BAD_URL= "The given URL is not valid";

	private RsdView view;
	
	public ConnectAction(RsdView view) {
		this.view= view;
		this.setText(TEXT);
		this.setToolTipText(TOOLTIP);
		this.setImageDescriptor(VsdtRsdPlugin.getImageDescriptor(VsdtRsdPlugin.IMAGE_CONNECT));
				
	}
	
	@Override
	public void run() {
		InputDialog dialog= new InputDialog(
				view.getSite().getShell(),
				view.getTitle(),
				DIALOG_MESSAGE,
				Axis2RsdClient.defaultEndpoint,
				new UrlInputValidator());
		if (dialog.open() == InputDialog.OK) {
			view.showBusy(true);
			String endpoint= dialog.getValue();
			if (endpoint.trim().length() == 0) {
				endpoint= null; // use default endpoint
			}
			boolean ok= false;
			try {
				IRsdClient client= view.getClient();
				ok= client.connect(endpoint);
			} catch (Exception e) {
				e.printStackTrace();
				ok= false;
			}
			if (ok) {
				// fetch services, delegating to other action
				new RefreshServicesAction(view).run();
			} else {
				MessageDialog.openInformation(view.getSite().getShell(), TEXT, CONNECTION_FAILED);
			}
			view.showBusy(false);
		}
	}
	
	/**
	 * URL input validator which checks the validity of the given URL string by simply
	 * trying to create an URL object from it.
	 * 
	 * @author kuester
	 */
	protected class UrlInputValidator implements IInputValidator {
		public String isValid(String string) {
			// allow empty string, meaning that the default URL shall be used
			if (string == null || string.length() == 0) {
				return null;
			}
			// try to create URL from string
			try {
				new URI(string);
			} catch (URISyntaxException e) {
				return BAD_URL;
			}
			return null;
		}
	}
}
