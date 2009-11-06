package de.dailab.vsdt.diagram.views.rsd;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import de.dailab.common.gmf.ui.views.AbstractStructuredViewerView;
import de.dailab.vsdt.diagram.actions.ConnectAction;
import de.dailab.vsdt.diagram.actions.ImportAction;
import de.dailab.vsdt.diagram.actions.RefreshServicesAction;
import de.dailab.vsdt.diagram.actions.ShowDetailsAction;
import de.dailab.vsdt.diagram.actions.SwapLayoutAction;
import de.dailab.vsdt.diagram.rsd.IRsdClient;
import de.dailab.vsdt.diagram.rsd.IRsdWS;
import de.dailab.vsdt.diagram.rsd.client.Axis2RsdClient;

/**
 * With this RSD view the user can connect to the ''Rich Service Directory'' and use it to look
 * for published web services. Ultimately, these services can be imported as message/webservie/pool
 * into an existing BPMN diagram.
 * 
 * @author kuester
 */
public class RsdView extends AbstractStructuredViewerView {
	
	public static final String SERVICE_LIST= "Content of the Rich Service Directory";
	public static final String SERVICE_DETAILS= "Service Details";
	
	public static GridLayout layoutWide= new GridLayout(2,true);
	public static GridLayout layoutHigh= new GridLayout(1,false);
	
	protected Composite theComposite;
	protected ServicePropertyComposite propComposite;
	
	protected IRsdClient client;
	
	protected Action connectAction;
	protected Action refreshServicesAction;
	protected Action showDetailsAction;
	protected Action importAction;
	protected Action swapLayoutAction;
	
	
	@Override
	public void createPartControl(Composite parent) {
		theComposite= new Composite(parent, 0);
		theComposite.setLayout(layoutWide);
		
		Group viewerGroup= new Group(theComposite, SWT.NONE);
		viewerGroup.setText(SERVICE_LIST);
		viewerGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		viewerGroup.setLayout(new FillLayout(SWT.HORIZONTAL | SWT.VERTICAL));
		
		viewer = new TableViewer(viewerGroup);
		viewer.setContentProvider(new RsdViewContentProvider());
		viewer.setLabelProvider(new RsdViewLabelProvider());
		viewer.setInput(getViewSite());
		
		Group selectionGroup= new Group(theComposite, SWT.NONE);
		selectionGroup.setText(SERVICE_DETAILS);
		selectionGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		selectionGroup.setLayout(new FillLayout(SWT.HORIZONTAL | SWT.VERTICAL));
		propComposite= new ServicePropertyComposite(selectionGroup, SWT.NONE);
		
		super.createPartControl(parent);
	}
	
	@Override
	protected void performDoubleClick() {
		showDetailsAction.run();
	}
	
	@Override
	protected void performSelectionChanged(ISelection selection) {
		super.performSelectionChanged(selection);
		if (selection instanceof StructuredSelection) {
			propComposite.displayProperties((IRsdWS) getSelectedElement());
		}
	}

	@Override
	protected void makeActions() {
		connectAction= new ConnectAction(this);
		refreshServicesAction= new RefreshServicesAction(this);
		showDetailsAction= new ShowDetailsAction(this);
		importAction= new ImportAction(this);
		swapLayoutAction= new SwapLayoutAction(this);
		
		contributeToToolBar(connectAction, refreshServicesAction, showDetailsAction, importAction, swapLayoutAction);
		hookContextMenu(showDetailsAction, importAction);
		updateActionEnablement();
	}
	
	@Override
	protected void updateActionEnablement() {
		boolean wsSelected= getSelectedElement() instanceof IRsdWS;
		showDetailsAction.setEnabled(wsSelected);
		importAction.setEnabled(wsSelected);
	}

	public Composite getTheComposite() {
		return theComposite;
	}
	
	public IRsdClient getClient() {
		if (client == null) {
			client= new Axis2RsdClient();
		}
		return client;
	}

}