package de.dailab.vsdt.vsdtagents.processenginebean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.ui.PlatformUI;

import de.dailab.common.swt.dialogs.SingleSelectDialog;
import de.dailab.common.swt.views.AbstractLabelProvider;
import de.dailab.common.swt.views.AbstractStructuredViewerView;
import de.dailab.common.swt.views.AbstractTreeContentProvider;
import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import de.dailab.jiactng.agentcore.ontology.IAgentDescription;
import de.dailab.jiactng.nodeplugin.JiacNodePlugin;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.diagram.interpreter.view.DecorationHelper;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;
import de.dailab.vsdt.vsdtagents.Util;
import de.dailab.vsdt.vsdtagents.VsdtAgents;
import de.dailab.vsdt.vsdtagents.deployment.DeploymentView;
import de.dailab.vsdt.vsdtagents.deployment.ServiceParameterDialog;

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
	private Action invokeAction;
	private Action clearDecoration;
	private Action toggleShowState;
	
	
	/** the bean */
	private ProcessEngineBeanBean bean = null;
	
	/** list holding the interpreters */
	private ContentViewer interpreterViewer;
	
	/** map holding interpreter agents and their respective interpreter runtimes */
	private Map<IAgentDescription, Map<String, String>> interpreterAgents = null;
	
	/** map holding interpreter agents and their respective interpreter runtimes' actions */
	private Map<String, List<de.dailab.jiactng.agentcore.action.Action>> interpreterAgentActions = null;
	
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
		invokeAction = new InvokeAction();
		undeployAction = new UndeployAction();
		clearDecoration = new ClearDecorationAction();
		toggleShowState = new ToggleShowStateAction();
		contributeToToolBar(refreshAction, deployAction, invokeAction, undeployAction);
		contributeToMenu(clearDecoration, toggleShowState);
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
			// can not be lambda-fied due to checked exceptions
			interpreterAgents = new HashMap<>();
			for (IAgentDescription agent : agents) {
				interpreterAgents.put(agent, getBean().getRunningInterpreters(agent));
			}
			interpreterAgentActions = new HashMap<>();
			for (IAgentDescription agent : agents) {
				interpreterAgentActions.putAll(getBean().getExposedProcesses(agent));
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
		boolean isAction = element instanceof IActionDescription;
		
		// set action enablements
		refreshAction.setEnabled(true); // always enabled
		deployAction.setEnabled(isVsdtEditor && isAgent);
		undeployAction.setEnabled(isInterpreter);
		invokeAction.setEnabled(isAction);
		clearDecoration.setEnabled(true);
		toggleShowState.setEnabled(isInterpreter || isAgent);
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
		
		@SuppressWarnings("rawtypes")
		@Override
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof IAgentDescription) {
				return interpreterAgents.get(parentElement).entrySet().toArray();
			}
			if (parentElement instanceof Map.Entry) {
				return interpreterAgentActions.get(((Map.Entry) parentElement).getKey()).toArray();
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
			if (element instanceof IActionDescription) {
				IActionDescription action = (IActionDescription) element;
				return String.format("%s: %s -> %s", action.getName(), action.getInputTypeNames(), action.getResultTypeNames());
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
			if (element instanceof IActionDescription) {
				return VsdtAgents.getImageDescriptor("action.gif");
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
	 * Clear decoration (state markers) from all opened diagrams.
	 * 
	 * @author kuester
	 */
	protected class ClearDecorationAction extends Action {
		
		public ClearDecorationAction() {
			super("Clear Decoration", null);
			setToolTipText("Clear state decoration markers from opened diagrams.");
		}
		
		@Override
		public void run() {
			Stream.of(PlatformUI.getWorkbench().getWorkbenchWindows())
					.flatMap(wbw -> Stream.of(wbw.getPages()))
					.flatMap(wbp -> Stream.of(wbp.getEditorReferences()))
					.map(ref -> ref.getEditor(false))
					.filter(VsdtDiagramEditor.class::isInstance)
					.map(VsdtDiagramEditor.class::cast)
					.map(VsdtDiagramEditor::getDiagramEditPart)
					.forEach(DecorationHelper::clearDecorators);
		}
	}


	/**
	 * Toggle whether to show the state of the currently selected interpreter in the VSDT
	 * 
	 * @author kuester
	 */
	protected class ToggleShowStateAction extends Action {
		
		public ToggleShowStateAction() {
			super("Toggle Show State", null);
			setToolTipText("Toggle whether to show the state of the selected interpreter in the VSDT.");
		}
		
		@Override
		public void run() {
			try {
				IAgentDescription agent = getSelected(interpreterViewer, IAgentDescription.class);
				getBean().toggleShowState(agent);
			} catch (Exception e) {
				openMessageDialog(MessageDialog.ERROR, "Action failed: " + e.getMessage());
			}
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
				Shell shell = Display.getDefault().getActiveShell();
				// ask for participant
				BusinessProcessSystem vsdtModel = Util.getVsdtModelBps(null);
				Participant participant = askForParticipant(shell, vsdtModel);
				if (participant != null) {
					IAgentDescription agent = getSelected(interpreterViewer, IAgentDescription.class);
					try {
						String source = getVsdtSource();
						runInProgressMonitor(shell, true, false, (IProgressMonitor monitor) -> {
							try {
								// deploy process to interpreter
								getBean().deployProcessToInterpreter(agent, source, participant.getName());
								openMessageDialogSafe(MessageDialog.INFORMATION, "Process sucessfully deployed");
							} catch (Exception e) {
								// thrown by deploy method
								openMessageDialogSafe(MessageDialog.ERROR, "Deploying Service Failed: " + e.getMessage());
							}
						});
						// refresh viewer
						refresh();
					} catch (IOException e) {
						openMessageDialog(MessageDialog.ERROR, "Could not read VSDT source: " + e.getMessage());
					}
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
				} catch (Exception e) {
					openMessageDialog(MessageDialog.ERROR, "Failed to remove runtime: " + e.getMessage());
				}
				// refresh viewer
				refresh();
			}
		}
	}
	
	/**
	 * This Action calls the Bean's invoke Method for the Service currently
	 * selected in the Viewer and with a list of Parameters asked from the user
	 * using a special Parameter Dialog. The Results of the service invocation,
	 * if any, are again displayed to the user using a similar Dialog.
	 * 
	 * TODO unify/reduce code duplication with similar method in {@link DeploymentView}.
	 * 
	 * @author kuester
	 */
	protected class InvokeAction extends Action {
		
		public InvokeAction() {
			super("Invoke", VsdtAgents.getImageDescriptor("action.gif"));
			setToolTipText("Invoke selected Process (for primitive argument and result types only).");
		}
		
		@Override
		public void run() {
			Object selected = getSelectedElement(interpreterViewer);
			if (selected instanceof IActionDescription) {
				IActionDescription service = (IActionDescription) selected;

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
									Serializable[] results = getBean().invokeProcess(service, inputs);
									// open dialog showing the result
									StringBuffer buffer = new StringBuffer();
									buffer.append(String.format("Result for Service %s:", service.getName()));
									for (Serializable result : results) {
										buffer.append(DeploymentView.NL);
										buffer.append(result != null && result.getClass().isArray() ?
												Arrays.toString((Object[]) result) : String.valueOf(result));
									}
									openMessageDialogSafe(MessageDialog.INFORMATION, buffer.toString());
								} catch (Exception e) {
									// error raised by the called process
									openMessageDialogSafe(MessageDialog.ERROR, "Invocation failed: " + e.getMessage());
								}
						});
				}
			}
		}
	}

}
