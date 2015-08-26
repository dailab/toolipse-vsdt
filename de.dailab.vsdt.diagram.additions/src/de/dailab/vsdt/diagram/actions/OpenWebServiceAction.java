package de.dailab.vsdt.diagram.actions;

import java.net.URL;

import javax.wsdl.WSDLException;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.dailab.common.swt.dialogs.SelectUrlDialog;
import de.dailab.vsdt.diagram.views.webservices.WebSeviceAccessor;

/**
 * This Action is used to open a given Web service from a URL inquired from a 
 * input dialog. The resulting Definition is then added to the given Viewer's 
 * underlying model. 
 * 
 * @author kuester
 */
public class OpenWebServiceAction extends Action {

	public static final String TEXT= "Open WSDL...";
	public static final String TOOLTIP= "Opens a WSDL from a given URL";
	
	public static final String DIALOG_OPEN_TITLE= "Select Web Service";
	public static final String DIALOG_OPEN_MESSAGE="Please enter the URL of the Web service to open";
	public static final String DIALOG_ERROR_TITLE= "Error Opening WSDL";
	public static final String DIALOG_ERROR_MESSAGE="An Error occured when trying to open the WSDL from the given URL";
	public static final String BAD_URL= "The given URL is not valid";

	private final Viewer viewer;
	private final WebSeviceAccessor accessor;
	
	/**
	 * @param viewer	The viewer holding the elements
	 */
	public OpenWebServiceAction(Viewer viewer) {
		this.viewer= viewer;
		this.accessor= (WebSeviceAccessor) viewer.getInput();
		this.setText(TEXT);
		this.setToolTipText(TOOLTIP);
		this.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_FOLDER));
	}
	
	@Override
	public void run() {
		// open input dialog and ask for URL
		IWorkbenchWindow window= PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		SelectUrlDialog dialog= new SelectUrlDialog(window.getShell());
		if (dialog.open() == Window.OK) {
			try {
				// request URI and set WSDL as input for viewer
				URL url= dialog.getUrl();
				if (url != null) {
					accessor.loadWSDL(url.toString());
					viewer.refresh();
				}
			} catch (WSDLException e) {
				MessageDialog.openError(window.getShell(), DIALOG_ERROR_TITLE, DIALOG_ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 * URL input validator which checks the validity of the given URL string by simply
	 * trying to create an URL object from it.
	 * 
	 * @author kuester
	 */
	public static class UrlInputValidator implements IInputValidator {
		public String isValid(String string) {
			// allow empty string, meaning that the default URL shall be used
			if (string == null || string.length() == 0) {
				return null;
			}
			// try to create URL from string
			try {
				new URL(string);
			} catch (Exception e) {
				return BAD_URL;
			}
			return null;
		}
	}
	
}
