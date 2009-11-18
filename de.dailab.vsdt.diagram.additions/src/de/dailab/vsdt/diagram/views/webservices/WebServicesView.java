package de.dailab.vsdt.diagram.views.webservices;

import javax.wsdl.Definition;
import javax.wsdl.Input;
import javax.wsdl.Message;
import javax.wsdl.Operation;
import javax.wsdl.Output;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import de.dailab.common.swt.views.AbstractStructuredViewerView;
import de.dailab.vsdt.diagram.actions.ImportWebServiceAction;
import de.dailab.vsdt.diagram.actions.OpenWebServiceAction;
import de.dailab.vsdt.diagram.actions.RemoveWebServiceAction;
import de.dailab.vsdt.diagram.actions.ShowWebServiceDetailsAction;

/**
 * This view provides the capability to open Web service URLs and to inspect
 * the respective Definition objects. Operations and Messages from the Definition
 * can then be imported into the currently opened BPMN diagram.  
 * 
 * @author kuester
 */
public class WebServicesView extends AbstractStructuredViewerView {
	
	private WebSeviceAccessor accessor= new WebSeviceAccessor();

	private Action importAction= null;
	private Action openAction= null;
	private Action removeAction= null;
	private Action showDetailsAction= null;
	
	public void createPartControl(Composite composite) {
		// Create the Viewer
		viewer= new TreeViewer(composite);
		viewer.setContentProvider(new WebServiceViewContentProvider());
		viewer.setLabelProvider(new WebServiceViewLabelProvider());
		viewer.setInput(accessor);
		super.createPartControl(composite);
	}
	
	@Override
	protected void performDoubleClick() {
		updateActionEnablement();
	}
	
	/**
	 * creates the Action objects
	 */
	@Override
	protected void makeActions() {
		openAction= new OpenWebServiceAction(viewer);
		importAction= new ImportWebServiceAction(viewer);
		removeAction= new RemoveWebServiceAction(viewer);
		showDetailsAction= new ShowWebServiceDetailsAction(viewer);
		contributeToToolBar(openAction, showDetailsAction, importAction, removeAction);
		hookContextMenu(showDetailsAction, importAction, removeAction);
		updateActionEnablement();
	}

	/**
	 * Enables or disables the several Actions depending on the currently selected
	 * item in the viewer.
	 */
	@Override
	protected void updateActionEnablement() {
		Object selection= getSelectedElement();
		boolean importEnabled= 
			selection instanceof Message || 
			selection instanceof Operation ||
			selection instanceof Input || 
			selection instanceof Output;
		importAction.setEnabled(importEnabled);
		boolean removeEnabled=
			selection instanceof Definition;
		removeAction.setEnabled(removeEnabled);
		boolean detailsEnabled=
			selection instanceof Definition;
		showDetailsAction.setEnabled(detailsEnabled);
	}
	
}