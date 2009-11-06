package de.dailab.vsdt.diagram.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;

import de.dailab.vsdt.diagram.dialogs.RsdServiceDetailsDialog;
import de.dailab.vsdt.diagram.rsd.IRsdWS;
import de.dailab.vsdt.diagram.rsd.VsdtRsdPlugin;
import de.dailab.vsdt.diagram.views.rsd.RsdView;

/**
 * When executed, this action shows detailed information about the selected service.
 * 
 * @author kuester
 */
public class ShowDetailsAction extends Action {

	public static final String TEXT= "Show Service Details";
	public static final String TOOLTIP= "Opens a dialog showing the details for the selected service.";

	public static final String ERROR_NO_SELECTION= "No webservice selected.";
	
	private RsdView view;
	
	public ShowDetailsAction(RsdView view) {
		this.view= view;
		this.setText(TEXT);
		this.setToolTipText(TOOLTIP);
		this.setImageDescriptor(VsdtRsdPlugin.getImageDescriptor(VsdtRsdPlugin.IMAGE_PROPERTIES));
	}
	
	@Override
	public void run() {
		Object ws= view.getSelectedElement();
		if (ws instanceof IRsdWS) {
			new RsdServiceDetailsDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), (IRsdWS) ws).open();
		}
	}
}
