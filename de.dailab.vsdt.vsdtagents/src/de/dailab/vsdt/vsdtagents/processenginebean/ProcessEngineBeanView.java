package de.dailab.vsdt.vsdtagents.processenginebean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import de.dailab.common.swt.dialogs.SingleSelectDialog;
import de.dailab.common.swt.views.AbstractLabelProvider;
import de.dailab.common.swt.views.AbstractStructuredViewerView;
import de.dailab.common.swt.views.AbstractTreeContentProvider;
import de.dailab.jiactng.agentcore.ontology.IAgentDescription;
import de.dailab.jiactng.nodeplugin.JiacNodePlugin;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessSystemEditPart;
import de.dailab.vsdt.vsdtagents.VsdtAgents;

/**
 * TODO Javadocs
 * 
 * @author kuester
 */
public class ProcessEngineBeanView extends AbstractStructuredViewerView {

	public static final String NL = System.getProperty("line.separator");
	
	// Actions
	private Action refreshAction;
	private Action deployAction;
	private Action undeployAction;

	// TODO actions for invoking actions or sending messages to the interpreter? for testing
	
	
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
	}

	/**
	 * Update the enablement of the various actions based on the current selection
	 * and the currently opened editor.
	 */
	private void updateActions() {
		// check type of active editor
		boolean isVsdtEditor = getVsdtModel() != null;
		
		// check type of selection
		Object element = getSelectedElement(interpreterViewer);
		boolean isAgent = element instanceof IAgentDescription;
		boolean isInterpreter = element instanceof String;
		
		// set action enablements
		refreshAction.setEnabled(true); // always enabled
		deployAction.setEnabled(isVsdtEditor && isAgent);
		undeployAction.setEnabled(isInterpreter);
	}
	
	protected BusinessProcessSystem getVsdtModel() {
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editor instanceof de.dailab.vsdt.meta.diagram.part.VsdtDiagramEditor) {
			de.dailab.vsdt.meta.diagram.part.VsdtDiagramEditor vsdteditor = (de.dailab.vsdt.meta.diagram.part.VsdtDiagramEditor) editor;
			BusinessProcessSystemEditPart editPart = (BusinessProcessSystemEditPart) vsdteditor.getDiagramEditPart(); 
			return (BusinessProcessSystem) ((View) editPart.getModel()).getElement();
		}
		if (editor instanceof VsdtDiagramEditor) {
			VsdtDiagramEditor vsdteditor = (VsdtDiagramEditor) editor;
			BusinessProcessDiagramEditPart editPart = (BusinessProcessDiagramEditPart) vsdteditor.getDiagramEditPart();
			return editPart.getCastedModel().getParent();
		}
		return null;
	}
	
	protected URI getEditorUri() {
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editor != null) {
			IEditorInput input = editor.getEditorInput();
			URI uri = null;
			if (input instanceof FileEditorInput) {
				IFile file = ((FileEditorInput) input).getFile();
				uri = URI.createURI(file.getLocationURI().toString());
			}
			if (input instanceof URIEditorInput) {
				uri = ((URIEditorInput) input).getURI();
			}
			return uri;
		}
		return null;
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
				// XXX der name ist vermutlich immer gleich; der node waere interessanter
				return ((IAgentDescription) element).getName();
			}
			if (element instanceof Map.Entry) {
				Map.Entry<String, String> entry = (Map.Entry<String, String>) element; 
				return entry.getKey() + ": " + entry.getValue();
			}
			return super.getText(element);
		}
		
		@Override
		protected ImageDescriptor getImageDescriptor(Object element) {
			if (element instanceof IAgentDescription) {
				return VsdtAgents.getImageDescriptor("agent.gif");
			}
			if (element instanceof String) {
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
								// get source of VSDT file
								File file = new File(getEditorUri().toFileString());
								StringBuilder builder = new StringBuilder();
								try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
									String line;
									while ((line = reader.readLine()) != null) {
										builder.append(line);
									}
								}
								String vsdtSource = builder.toString();
								
								// ask for participant
								BusinessProcessSystem vsdtModel = getVsdtModel();
								SingleSelectDialog<Participant> dialog = new SingleSelectDialog<Participant>(shell, 
										"Select Participant", "Select Participant to interpret.", vsdtModel.getParticipants()) {
									protected String getText(Participant p) {
										return p.getName();
									};
								};
								if (dialog.open() == SingleSelectDialog.OK) {
									// deploy process to interpreter
									IAgentDescription agent = getSelected(interpreterViewer, IAgentDescription.class);
									getBean().deployProcessToInterpreter(agent, vsdtSource, dialog.getSelected().getName());
									openMessageDialog(MessageDialog.INFORMATION, "Process sucessfully deployed");

									// refresh viewer
									refresh();
								}
							} catch (Exception e) {
								openMessageDialog(MessageDialog.ERROR, "Deploying Service Failed: " + e.getMessage());
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
//			IActionDescription service = getSelectedService();
//			if (service != null) {
//				if (openMessageDialog(MessageDialog.CONFIRM, "Undeploy Service " + service.getName() + "?")) {
//					if (getBean().undeploy(service)) {
//						openMessageDialog(MessageDialog.INFORMATION, "Undeployed Service " + service.getName());
//						refresh();
//					} else {
//						openMessageDialog(MessageDialog.ERROR, "Failed to undeploy Service " + service.getName());
//					}
//				}
//			}
		}
	}

}
