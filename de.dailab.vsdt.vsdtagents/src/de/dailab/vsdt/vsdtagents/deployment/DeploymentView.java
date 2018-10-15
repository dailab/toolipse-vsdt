package de.dailab.vsdt.vsdtagents.deployment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import de.dailab.common.swt.dialogs.MultiSelectDialog;
import de.dailab.common.swt.views.AbstractLabelProvider;
import de.dailab.common.swt.views.AbstractStructuredViewerView;
import de.dailab.common.swt.views.AbstractTreeContentProvider;
import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import de.dailab.jiactng.agentcore.ontology.IAgentDescription;
import de.dailab.jiactng.nodeplugin.JiacNodePlugin;
import de.dailab.vsdt.vsdtagents.Util;
import de.dailab.vsdt.vsdtagents.VsdtAgents;

/**
 * This View provides functionality for Deploying Services from a currently
 * active VSDT or JADL source code editor. The Services are displayed in a tree
 * view, from which they can be imported or directly invoked. Apart from providing
 * means for comfortably testing JADL services, this View can be used for 'remote'
 * deployment of JADL services.
 * 
 * @author kuester
 */
public class DeploymentView extends AbstractStructuredViewerView {

	public static final String NL = System.getProperty("line.separator");
	
	// Actions
	private Action refreshAction;
	private Action deployAction;
	private Action deployWithRulesAction;
	private Action importAction;
	private Action invokeAction;
	private Action undeployAction;
	
	/** the bean */
	private DeploymentBean bean = null;
	
	/** list holding the services */
	private ContentViewer servicesViewer;
	
	/** text field for showing detailed information on selection */
	private Text detailsText;

	/** this map is holding the mapping of agents to services */
	private Map<IAgentDescription, List<IActionDescription>> agentsToServices = null;
	
	/** this map is holding the mapping of nodes to agents */
	private Map<String, List<IAgentDescription>> nodesToAgents = null;
	
	
	/**
	 * Create the View's Controls and Actions
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new SashForm(parent, SWT.VERTICAL);

		// create tree viewer
		servicesViewer = new TreeViewer(composite);
		servicesViewer.setContentProvider(new DeploymentViewContentProvider());
		servicesViewer.setLabelProvider(new DeploymentViewLabelProvider());
		servicesViewer.addSelectionChangedListener(new DeploymentViewSelectionListener());
		
		// create lower details pane
		detailsText = new Text(composite, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);

		// create actions
		refreshAction = new RefreshAction();
		deployAction = new DeployAction(false);
		deployWithRulesAction = new DeployAction(true);
		importAction = new ImportActionAction(servicesViewer);
		invokeAction = new InvokeAction();
		undeployAction = new UndeployAction();
		contributeToToolBar(refreshAction, deployAction, deployWithRulesAction, 
				importAction, invokeAction, undeployAction);
		updateActions();
	}

	@Override
	public void setFocus() {
	}
	
	/**
	 * Get reference to the Bean using a static instance (set by the bean's
	 * doStart method).
	 * 
	 * @return		the DeploymentBean behind this view.
	 */
	private DeploymentBean getBean() {
		if (bean == null && JiacNodePlugin.getDefault().getNode() != null) {
			bean = JiacNodePlugin.getAgentBean(DeploymentBean.class);
		}
		return bean;
	}
	
	/**
	 * Get Actions from Bean and Refresh Services Viewer accordingly
	 */
	private void refresh() {
		if (getBean() == null) {
			// node not yet started
			openMessageDialog(MessageDialog.ERROR, "JIAC Node has not yet started. Please try again later.");
			return;
		}
		
		// get list of services from bean
		List<IActionDescription> actions = getBean().getServices();

		// populate agents-to-services map
		agentsToServices = new HashMap<IAgentDescription, List<IActionDescription>>();
		for (IActionDescription action : actions) {
			IAgentDescription provider = action.getProviderDescription();
			if (! agentsToServices.containsKey(provider)) {
				agentsToServices.put(provider, new ArrayList<IActionDescription>());
			}
			agentsToServices.get(provider).add(action);
		}
		
		// populate nodes-to-agents map
		nodesToAgents = new HashMap<String, List<IAgentDescription>>();
		for (IAgentDescription agent : agentsToServices.keySet()) {
			String nodeID = agent.getAgentNodeUUID() + " @ " + agent.getOwner();
			if (! nodesToAgents.containsKey(nodeID)) {
				nodesToAgents.put(nodeID, new ArrayList<IAgentDescription>());
			}
			nodesToAgents.get(nodeID).add(agent);
		}
		
		// set viewer's input
		// what is set as input here is irrelevant; this is just to call getElements()
		servicesViewer.setInput(nodesToAgents);
	}

	/**
	 * Show details on selected element
	 * 
	 * @param element	element for which to show details
	 */
	private void showDetails(Object element) {
		detailsText.setText(element != null ? String.valueOf(element).trim() : "");
	}

	/**
	 * Update the enablement of the various actions based on the current selection
	 * and the currently opened editor.
	 */
	private void updateActions() {
		// check type of active editor
		boolean isVsdtEditor = true;
		boolean isJadlEditor = true;
		try {
			IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			if (editor != null) {
				IEditorInput input = editor.getEditorInput();
				if (input instanceof FileEditorInput) {
					IFile file = ((FileEditorInput) input).getFile();
					isJadlEditor = file.getName().endsWith(".jadl");
					isVsdtEditor = file.getName().endsWith(".vsdtd");
				}
				if (input instanceof URIEditorInput) {
					URI uri = ((URIEditorInput) input).getURI();
					isVsdtEditor = "vsdtd".equals(uri.fileExtension());
				}
			}
		} catch (Exception e) {
			// editor might not be initialized yet...
		}
		
		// check type of selection
		boolean isAction = false;
		boolean isJadlAgent = false;
		boolean isServiceStarterAgent = false;
		boolean isJadlService = false;
		boolean isSupportedTypes = true;
		Object element = getSelectedElement(servicesViewer);
		if (element instanceof IActionDescription) {
			isAction = true;
			IActionDescription action = (IActionDescription) element;
			isJadlService = "JADL".equals(action.getActionType());
			// do not check for supported types here; instead present to the user
			// a message dialog saying _why_ the service can not be invoked
//			isSupportedTypes = ServiceParameterDialog.isSupported(action);
		}
		if (element instanceof IAgentDescription) {
			IAgentDescription agent = (IAgentDescription) element;
			isJadlAgent = isInterpreterAgent(agent);
			isServiceStarterAgent = isServiceStarterAgent(agent);
		}
		
		// set action enablements
		refreshAction.setEnabled(true); // always enabled
		deployAction.setEnabled(isJadlAgent && (isVsdtEditor || isJadlEditor));
		importAction.setEnabled(isVsdtEditor && isAction);
		invokeAction.setEnabled(isAction && isSupportedTypes);
		undeployAction.setEnabled(isJadlService);
		deployWithRulesAction.setEnabled(deployAction.isEnabled() && isServiceStarterAgent);
	}
	
	/**
	 * @return		Service currently selected in Services Viewer, or null
	 */
	private IActionDescription getSelectedService() {
		Object element = getSelectedElement(servicesViewer);
		if (element instanceof IActionDescription) {
			return (IActionDescription) element;
		}
		return null; 
	}
	
	/**
	 * @param interpreterAgent	return interpreter agent, or null
	 * @return					(Interpreter-)Agent currently selected in Services Viewer, or null
	 */
	private IAgentDescription getSelectedAgent(boolean interpreterAgent) {
		Object element = getSelectedElement(servicesViewer);
		if (element instanceof IAgentDescription) {
			IAgentDescription agent = (IAgentDescription) element;
			if (interpreterAgent) {
				if (isInterpreterAgent(agent)) {
					return agent;
				}
			} else {
				return agent;
			}
		}
		return null;
	}
	

	/**
	 * Check whether the given agent is an interpreter agent by checking for the
	 * existence of the respective actions (duck-typing like).
	 * 
	 * @param agent		some agent
	 * @return			is a JADL interpreter agent?
	 */
	private boolean isInterpreterAgent(IAgentDescription agent) {
		if (agentsToServices != null && agentsToServices.containsKey(agent)) {
			for (IActionDescription action : agentsToServices.get(agent)) {
				if (DeploymentBean.ACTION_DEPLOY.equals(action.getName())) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Check whether the given agent is a service starter agent by checking for
	 * the existence of the respective actions (duck-typing like).
	 * 
	 * @param agent		some agent
	 * @return			is a service-starter agent?
	 */
	private boolean isServiceStarterAgent(IAgentDescription agent) {
		if (agentsToServices != null && agentsToServices.containsKey(agent)) {
			for (IActionDescription action : agentsToServices.get(agent)) {
				if (DeploymentBean.ACTION_DEPLOY_WITH_RULES.equals(action.getName())) {
					return true;
				}
			}
		}
		return false;
	}
	

	/**
	 * Content Provider for the Services Viewer.
	 * 
	 * @author kuester
	 */
	protected class DeploymentViewContentProvider extends AbstractTreeContentProvider {
		
		@Override
		public Object[] getElements(Object input) {
			if (nodesToAgents != null) {
				Collection<String> nodeIDs= nodesToAgents.keySet();
				return nodeIDs.toArray();
			}
			return new Object[] {};
		}
		
		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof String) {
				String nodeID = (String) parentElement;
				if (nodesToAgents.containsKey(nodeID)) {
					return (nodesToAgents.get(nodeID)).toArray();
				}
			}
			if (parentElement instanceof IAgentDescription) {
				IAgentDescription agent = (IAgentDescription) parentElement;
				if (agentsToServices != null && agentsToServices.containsKey(agent)) {
					return (agentsToServices.get(parentElement)).toArray();
				}
			}
			return new Object[] {};
		}
	}

	
	/**
	 * Label Provider for Services Viewer.
	 * 
	 * @author kuester
	 */
	protected class DeploymentViewLabelProvider extends AbstractLabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof IAgentDescription) {
				return ((IAgentDescription) element).getName();
			}
			if (element instanceof IActionDescription) {
				return ((IActionDescription) element).getName();
			}
			return super.getText(element);
		}
		
		@Override
		protected ImageDescriptor getImageDescriptor(Object element) {
			if (element instanceof IAgentDescription) {
				if (isInterpreterAgent((IAgentDescription) element)) {
					return VsdtAgents.getImageDescriptor("jadl_agent.gif");
				} else {
					return VsdtAgents.getImageDescriptor("agent.gif");
				}
			}
			if (element instanceof IActionDescription) {
				return VsdtAgents.getImageDescriptor("action.gif");
			}
			if (element instanceof String) {
				return VsdtAgents.getImageDescriptor("node.gif");
			}
			return null;
		}

	}

	
	/**
	 * This class provides a Selection Listener for updating action enablement
	 * and the details panel.
	 * 
	 * @author kuester
	 */
	protected class DeploymentViewSelectionListener implements ISelectionChangedListener {
		
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			if (event.getSelection() instanceof TreeSelection) {
				showDetails(((TreeSelection) event.getSelection()).getFirstElement());
				updateActions();
			}			
		}
	}

	
	/**
	 * This Action simply calls the Refresh method, refreshing the List of JADL
	 * services in the main Viewer.
	 * 
	 * @author kuester
	 */
	protected class RefreshAction extends Action {
		
		public RefreshAction() {
			super("Refresh", VsdtAgents.getImageDescriptor("refresh.gif"));
			setToolTipText("Refresh List of Actions and Services.");
		}
		
		@Override
		public void run() {
			refresh();
		}
	}
	
	
	/**
	 * This Actions checks the currently opened Editor. If it holds a JADL file,
	 * the content of the file is read and passed on to the bean, where it is
	 * parsed and deployed as one or more JADL services. Finally, the list of
	 * Services is refreshed. 
	 * 
	 * @author kuester
	 */
	protected class DeployAction extends Action {
		
		final HashMap<String, Serializable[]> starterRules;
		
		public DeployAction(boolean useStarterRules) {
			super("Deploy", VsdtAgents.getImageDescriptor("import.gif"));
			setToolTipText("Deploy Services from active Editor to selected JADL Interpreter Agent.");

			// support starter rules?
			if (useStarterRules) {
				setText("Deploy with Starter Rules");
				setToolTipText("Deploy Services from active Editor to selected JADL Interpreter Agent (with Starter Rules).");
				starterRules = new HashMap<String, Serializable[]>();
			} else {
				starterRules = null;
			}
		}
		
		@Override
		public void run() {
			if (openMessageDialog(MessageDialog.CONFIRM, "Deploy Services from active Editor to selected JADL Interpreter Agent?")) {
			
				// get selected agent
				final IAgentDescription selectedAgent = getSelectedAgent(true);
				if (selectedAgent != null) {

						final Shell shell = Display.getDefault().getActiveShell();
						runInProgressMonitor(shell, false, false, (IProgressMonitor monitor) -> {

								try {
									// get service sources from active editor
									List<String> serviceSrcs = Util.getServiceSrcs(starterRules);
								
									// check whether any service source files have been found
									if (serviceSrcs != null) {
										
										Map<String, Boolean> servicesMap = new HashMap<String, Boolean>();
										for (String service : serviceSrcs) {
											servicesMap.put(service, true);
										}
										MultiSelectDialog<String> dialog = new MultiSelectDialog<String>(shell, "Select Services", "Select Services to deploy.", servicesMap) {
											protected String getText(String element) {
												int start = element.indexOf("service") + 8;
												int end   = element.indexOf("(") - 1;
												return element.substring(start, end);
											};
										};
										if (dialog.open() == MultiSelectDialog.OK) {
											List<String> selectedServices = dialog.getSelected();

											// invoke deploy action 
											Collection<String> newServices = new ArrayList<String>();
											for (String serviceSrc : selectedServices) {
												newServices.addAll(getBean().deployWithRules(selectedAgent, serviceSrc, starterRules));
											}
											
											if (! newServices.isEmpty()) {
												StringBuffer msgBuffer = new StringBuffer();
												int n = newServices.size();
												msgBuffer.append(String.format("%d Service%s Deployed", n, (n==1 ? "" : "s")));
												for (String service : newServices) {
													msgBuffer.append(NL).append(service);
												}
												openMessageDialog(MessageDialog.INFORMATION, msgBuffer.toString());
											} else {
												openMessageDialog(MessageDialog.INFORMATION, "No Services Deployed");
											}
										}										
									} else {
										// no valid editor -> service source is null, abort
										openMessageDialog(MessageDialog.INFORMATION, "Active Editor has to hold a JADL or VSDT file.");
										return;
									}
									
									// refresh viewer
									refresh();
								} catch (Exception e) {
									openMessageDialog(MessageDialog.ERROR, "Deploying Service Failed: " + e.getMessage());
								}
						});
				}
			}
		}
	}

	
	/**
	 * This Action calls the Bean's invoke Method for the Service currently
	 * selected in the Viewer and with a list of Parameters asked from the user
	 * using a special Parameter Dialog. The Results of the service invocation,
	 * if any, are again displayed to the user using a similar Dialog.
	 * 
	 * @author kuester
	 */
	protected class InvokeAction extends Action {
		
		public InvokeAction() {
			super("Invoke", VsdtAgents.getImageDescriptor("action.gif"));
			setToolTipText("Invoke selected JIAC Action or Service (for primitive argument and result types only).");
		}
		
		@Override
		public void run() {
			final IActionDescription service = getSelectedService();
			
			if (service != null) {
				// check input parameters for being primitive types or String
				if (! ServiceParameterDialog.isSupported(service)) {
					openMessageDialog(MessageDialog.ERROR, "Can not invoke: Unsupported Service Parameter Types.");
				}
				
				// open dialog, asking for input parameters
				Shell shell = Display.getDefault().getActiveShell();
				ServiceParameterDialog parameterDialog = new ServiceParameterDialog(shell, service);
				if (parameterDialog.open() == ServiceParameterDialog.OK) {
					runInProgressMonitor(shell, true, false, (IProgressMonitor monitor) -> {
								try {
									Serializable[] inputs = parameterDialog.getInputValues();
									Serializable[] results = getBean().invokeService(service, inputs);
									// open dialog showing the result
									StringBuffer buffer = new StringBuffer();
									buffer.append(String.format("Result for Service %s:", service.getName()));
									for (Serializable result : results) {
										buffer.append(NL);
										buffer.append(result != null && result.getClass().isArray() ?
												Arrays.toString((Object[]) result) : String.valueOf(result));
									}
									openMessageDialogSafe(MessageDialog.INFORMATION, buffer.toString());
								} catch (Exception e) {
									// error raised by the called service
									openMessageDialogSafe(MessageDialog.ERROR, "Invocation failed: " + e.getMessage());
								}
						});
				}
			}
		}
	}
	
	
	/**
	 * This Action calls the Bean's undeploy method with the Service currently
	 * selected in the Viewer. Afterwards, the list of services is refreshed. 
	 * 
	 * @author kuester
	 */
	protected class UndeployAction extends Action {
		
		public UndeployAction() {
			super("Undeploy", VsdtAgents.getImageDescriptor("delete.gif"));
			setToolTipText("Undeploy the selected JADL Service from its provider agent.");
		}
		
		@Override
		public void run() {
			IActionDescription service = getSelectedService();
			if (service != null) {
				if (openMessageDialog(MessageDialog.CONFIRM, "Undeploy Service " + service.getName() + "?")) {
					if (getBean().undeploy(service)) {
						openMessageDialog(MessageDialog.INFORMATION, "Undeployed Service " + service.getName());
						refresh();
					} else {
						openMessageDialog(MessageDialog.ERROR, "Failed to undeploy Service " + service.getName());
					}
				}
			}
		}
	}

}
