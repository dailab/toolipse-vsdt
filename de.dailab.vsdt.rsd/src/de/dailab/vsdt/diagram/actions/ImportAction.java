package de.dailab.vsdt.diagram.actions;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import de.dailab.vsdt.diagram.rsd.IRsdWS;
import de.dailab.vsdt.diagram.rsd.VsdtRsdPlugin;
import de.dailab.vsdt.diagram.views.rsd.RsdView;

/**
 * Executing this action triggers a series of dialogs to prompt the user whether to execute
 * a number of Commands: Given that some WebService is selected in the RSD View and that the 
 * currently active editor is a VSDT BPMN editor, a BPMN WebService element can be created for
 * the selected WebService, along with a pool representing the participant of the WebService
 * and message flow from the currently selected activity to that pool.
 * Each step is wrapped in a command.
 * 
 * @author kuester
 */
public class ImportAction extends ImportWebServiceAction {

	/**the view, which is needed to get the selected web service*/
	private RsdView view;
	
	public ImportAction(RsdView view) {
		super(view.getViewer());
		this.view= view;
		ISharedImages shImg= PlatformUI.getWorkbench().getSharedImages();
		shImg.getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT);
		this.setImageDescriptor(VsdtRsdPlugin.getImageDescriptor(VsdtRsdPlugin.IMAGE_IMPORT));
	}

	@Override
	protected boolean getElementsToImport(Viewer viewer) {
		IRsdWS ws= (IRsdWS) view.getSelectedElement();
		if (ws != null) {
			//get BPMN elements
			implementation= ws.getWebService();
			inMessage= ws.getInputMessage();
			outMessage= ws.getOutputMessage();
			return true;
		} else {
			return false;
		}
	}
	
}
