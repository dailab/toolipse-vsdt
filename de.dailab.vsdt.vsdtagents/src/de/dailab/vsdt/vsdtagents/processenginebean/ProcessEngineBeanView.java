package de.dailab.vsdt.vsdtagents.processenginebean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import de.dailab.common.swt.dialogs.SingleSelectDialog;
import de.dailab.common.swt.views.AbstractLabelProvider;
import de.dailab.common.swt.views.AbstractStructuredViewerView;
import de.dailab.common.swt.views.AbstractTreeContentProvider;
import de.dailab.jiactng.agentcore.ontology.IAgentDescription;
import de.dailab.jiactng.nodeplugin.JiacNodePlugin;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.vsdtagents.Util;
import de.dailab.vsdt.vsdtagents.VsdtAgents;

/**
 * This view provides a way to deploy the process diagram shown in the current
 * editor to a running VSDT interpreter agent and to see what interpreter
 * runtimes are currently running on those agents.
 * 
 * @author kuester
 */
public class ProcessEngineBeanView extends AbstractStructuredViewerView {

	// Actions
	private Action refreshAction;
	private Action deployAction;
	private Action undeployAction;
	
	
	/** the bean */
	private ProcessEngineBeanBean bean = null;
	
	/** list holding the interpreters */
	private ContentViewer interpreterViewer;
	
	/** map holding interpreter agents and their respective interpreter runtimes */
	private Map<IAgentDescription, Map<String, String>> interpreterAgents = null;
	
	/**
	 * Create the View's Controls and Actions
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new SashForm(parent, SWT.VERTICAL);

		// create tree viewer
		interpreterViewer = new TreeViewer(composite);
		interpreterViewer.setContentProvider(new DeploymentViewContentProvider());
		interpreterViewer.setLabelProvider(new DeploymentViewLabelProvider());
		interpreterViewer.addSelectionChangedListener(new DeploymentViewSelectionListener());
		
		// create actions
		refreshAction = new RefreshAction();
		deployAction = new DeployAction();
		undeployAction = new UndeployAction();
		contributeToToolBar(refreshAction, deployAction, undeployAction);
		updateActions();
	}

	@Override
	public void setFocus() {
	}
	
	/**
	 * Get reference to the Bean 
	 * 
	 * @return		the bean behind this view.
	 */
	private ProcessEngineBeanBean getBean() {
		if (bean == null) {
			bean = JiacNodePlugin.getAgentBean(ProcessEngineBeanBean.class);
		}
		return bean;
	}
	
	/**
	 * Get Actions from Bean and Refresh Services Viewer accordingly
	 */
	private void refresh() {
		try {
			// get list of interpreter agents
			List<IAgentDescription> agents = getBean().getInterpreterAgents();
			
			// get list of running interpreters for each interpreter agent
			interpreterAgents = new HashMap<>();
			for (IAgentDescription agent : agents) {
				interpreterAgents.put(agent, getBean().getRunningInterpreters(agent));
			}
			
			// set viewer's input (input is irrelevant, just to trigger the callback)
			interpreterViewer.setInput(interpreterAgents);
			
			updateActions();
		} catch (Exception e) {
			openMessageDialog(MessageDialog.ERROR, "Fetching Interpreter Runtimes Failed: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Update the enablement of the various actions based on the current selection
	 * and the currently opened editor.
	 */
	private void updateActions() {
		// check type of active editor
		boolean isVsdtEditor = Util.getVsdtModelBps(null) != null;
		
		// check type of selection
		Object element = getSelectedElement(interpreterViewer);
		boolean isAgent = element instanceof IAgentDescription;
		boolean isInterpreter = element instanceof Map.Entry;
		
		// set action enablements
		refreshAction.setEnabled(true); // always enabled
		deployAction.setEnabled(isVsdtEditor && isAgent);
		undeployAction.setEnabled(isInterpreter);
	}

	/**
	 * get source of VSDT file in active editor, if any
	 * @return
	 */
	private String getVsdtSource() throws IOException {
		BusinessProcessSystem bps = Util.getVsdtModelBps(null);
		if (bps == null) {
			throw new IllegalArgumentException("Active Editor must hold VSDT Process Diagram.");
		}
		URI uri = bps.eResource().getURI();
		InputStream is = bps.eResource().getResourceSet().getURIConverter().createInputStream(uri);

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			return reader.lines().collect(Collectors.joining("\n"));
		}
	}

	/**
	 * Ask user for participant from the given VSDT model.
	 */
	private Participant askForParticipant(Shell shell, BusinessProcessSystem vsdtModel) {
		SingleSelectDialog<Participant> dialog = new SingleSelectDialog<Participant>(shell,
				"Select Participant", "Select Participant:", vsdtModel.getParticipants()) {
			protected String getText(Participant p) {
				return p.getName();
			};
		};
		return dialog.open() == SingleSelectDialog.OK ? dialog.getSelected() : null;
	}
	
	/**
	 * Content Provider for the Services Viewer.
	 * 
	 * @author kuester
	 */
	protected class DeploymentViewContentProvider extends AbstractTreeContentProvider {
		
		@Override
		public Object[] getElements(Object input) {
			if (interpreterAgents != null) {
				return interpreterAgents.keySet().toArray();
			}
			return new Object[] {};
		}
		
		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof IAgentDescription) {
				return interpreterAgents.get(parentElement).entrySet().toArray();
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

		@SuppressWarnings("unchecked")
		@Override
		public String getText(Object element) {
			if (element instanceof IAgentDescription) {
				IAgentDescription agent = (IAgentDescription) element;
				return agent.getName() + " @ " + agent.getOwner();
			}
			if (element instanceof Map.Entry) {
				Map.Entry<String, String> entry = (Map.Entry<String, String>) element; 
				return entry.getValue();
			}
			return super.getText(element);
		}
		
		@Override
		protected ImageDescriptor getImageDescriptor(Object element) {
			if (element instanceof IAgentDescription) {
				return VsdtAgents.getImageDescriptor("agent.gif");
			}
			if (element instanceof Map.Entry) {
				return VsdtAgents.getImageDescriptor("role.gif");
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
				updateActions();
			}			
		}
	}

	
	/**
	 * This Action simply calls the Refresh method, refreshing the List of 
	 * Interpreters in the main view.
	 * 
	 * @author kuester
	 */
	protected class RefreshAction extends Action {
		
		public RefreshAction() {
			super("Refresh", VsdtAgents.getImageDescriptor("refresh.gif"));
			setToolTipText("Refresh List of Interpreter Agents.");
		}
		
		@Override
		public void run() {
			refresh();
		}
	}

	
	/**
	 * This action is used to deploy the process from the currently opened VSDT diagram
	 * to the selected interpreter agent instance.
	 * 
	 * @author kuester
	 */
	protected class DeployAction extends Action {
		
		public DeployAction() {
			super("Deploy", VsdtAgents.getImageDescriptor("import.gif"));
			setToolTipText("Deploy Process from active Editor to selected Interpreter Agent.");

		}
		
		@Override
		public void run() {
			if (openMessageDialog(MessageDialog.CONFIRM, "Deploy Process from active Editor to selected Interpreter Agent?")) {
			
				// start progress monitor
				try {
					final Shell shell = Display.getCurrent().getActiveShell();
					new ProgressMonitorDialog(shell).run(false, false, new IRunnableWithProgress() {
						@Override
						public void run(IProgressMonitor monitor) {
							try {
								// ask for participant
								BusinessProcessSystem vsdtModel = Util.getVsdtModelBps(null);
								Participant participant = askForParticipant(shell, vsdtModel);
								if (participant != null) {
									// deploy process to interpreter
									IAgentDescription agent = getSelected(interpreterViewer, IAgentDescription.class);
									getBean().deployProcessToInterpreter(agent, getVsdtSource(), participant.getName());
									openMessageDialog(MessageDialog.INFORMATION, "Process sucessfully deployed");

									// refresh viewer
									refresh();
								}
							} catch (Exception e) {
								openMessageDialog(MessageDialog.ERROR, "Deploying Service Failed: " + e.getMessage());
								e.printStackTrace();
							}
						}
					});
				} catch (InvocationTargetException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	/**
	 * This action removed the currently selected interpreter runtime from the
	 * interpreter agent it is running on.
	 * 
	 * @author kuester
	 */
	protected class UndeployAction extends Action {
		
		public UndeployAction() {
			super("Undeploy", VsdtAgents.getImageDescriptor("delete.gif"));
			setToolTipText("Undeploy the selected Process from the Interpreter Agent.");
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public void run() {
			ISelection selection = interpreterViewer.getSelection();
			TreeSelection treeSelection = (TreeSelection) selection;
			TreePath path = treeSelection.getPaths()[0];

			IAgentDescription agent = (IAgentDescription) path.getSegment(0);
			String id = ((Map.Entry<String, String>) path.getSegment(1)).getKey();

			if (openMessageDialog(MessageDialog.CONFIRM, "Remove selected Interpreter Runtime?")) {
				try {
					getBean().undeployInterpreterRuntime(agent, id);
					openMessageDialog(MessageDialog.INFORMATION, "Runtime removed");
					
					// refresh viewer
					refresh();
				} catch (Exception e) {
					openMessageDialog(MessageDialog.ERROR, "Failed to remove runtime: " + e.getMessage());
				}
			}
		}
	}

}
