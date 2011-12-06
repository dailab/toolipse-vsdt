package de.dailab.vsdt.vsdtagents.agentstore;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXB;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.MultipartPostMethod;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import de.dailab.common.swt.views.AbstractContentProvider;
import de.dailab.common.swt.views.AbstractLabelProvider;
import de.dailab.common.swt.views.AbstractStructuredViewerView;
import de.dailab.vsdt.vsdtagents.VsdtAgents;
import de.dailab.vsdt.vsdtagents.Util;
import de.dailab.vsdt.vsdtagents.agentstore.model.ListType;
import de.dailab.vsdt.vsdtagents.agentstore.model.ScriptType;

/**
 * This View provides functionality for uploading Services from a currently
 * active VSDT or JADL source code editor to the Agent Store. The Agent Store's 
 * Services are displayed in a List, from which they can be imported back into
 * the VSDT (or JADL edit).
 * 
 * @author kuester
 */
public class AgentstoreView extends AbstractStructuredViewerView {
	
	private static final String NL = System.getProperty("line.separator");
	
	/** default agent store URL */
	public final String DEFAULT_URL = "http://10.0.4.18:8080/AgentStore/";
	
	// Actions
	private Action refreshAction;
	private Action uploadAction;
	
	/** Text for displaying the URL of the currently displayed Agent Store */
	private Text agentStoreUrlText;
	
	/** list holding the services */
	private ContentViewer servicesViewer;
	
	/** text field for showing detailed information on selection */
	private Text detailsText;

	
	/**
	 * Create the View's Controls and Actions
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite composite = new SashForm(parent, SWT.VERTICAL);

		agentStoreUrlText = new Text(composite, SWT.NONE);
		agentStoreUrlText.setText(DEFAULT_URL);
		
		// create tree viewer
		servicesViewer = new ListViewer(composite);
		servicesViewer.setContentProvider(new AgentstoreViewContentProvider());
		servicesViewer.setLabelProvider(new AgentstoreViewLabelProvider());
		servicesViewer.addSelectionChangedListener(new AgentstoreViewSelectionListener());
		
		// create lower details pane
		detailsText = new Text(composite, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL | SWT.WRAP);

		// create actions
		refreshAction = new RefreshAction();
		uploadAction = new UploadAction();
		contributeToToolBar(refreshAction, uploadAction);
		updateActions();
	}

	@Override
	public void setFocus() {
	}
		
	/**
	 * Get Actions from Bean and Refresh Services Viewer accordingly
	 */
	private void refresh() {
		String baseUrl = getURL();
		if (baseUrl != null) {
			try {
				// get URL of services from agent store
				URL url = new URL(baseUrl + "agentScript/listAsXML/");
				// parse XML
				ListType list = JAXB.unmarshal(url, ListType.class);
				// set input for list view
				servicesViewer.setInput(list);
			} catch (Exception e) {
				e.printStackTrace();
				openMessageDialog(MessageDialog.ERROR, "Failed to fetch list of scripts");
			}
		}
	}

	/**
	 * Get and normalize selected URL, show error dialog if URL is invalid
	 * 
	 * @return	selected URL, always ending with '/', or null
	 */
	private String getURL() {
		String baseUrl = agentStoreUrlText.getText();
		if (checkUrl(baseUrl)) {
			return baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";
		} else {
			openMessageDialog(MessageDialog.ERROR, "Invalid URL");
			return null;
		}
	}
	
	/**
	 * Check whether the given URL is a valid Agent Store URL
	 * 
	 * @param url	some URL string
	 * @return		valid agent store URL?
	 */
	private boolean checkUrl(String url) {
		// TODO
		return true;
	}

	
	/**
	 * Show details on selected element
	 * 
	 * @param element	element for which to show details
	 */
	private void showDetails(Object element) {
		StringBuffer buffer = new StringBuffer();
		if (element instanceof ScriptType) {
			ScriptType script = (ScriptType) element;
			buffer.append(script.getName()).append(NL);
			buffer.append(script.getDescription());
		}
		detailsText.setText(buffer.toString());
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
		
		// set action enablements
		refreshAction.setEnabled(true); // always enabled
		uploadAction.setEnabled(isJadlEditor || isVsdtEditor);
	}
	
	/**
	 * Content Provider for the Services Viewer.
	 * 
	 * @author kuester
	 */
	protected class AgentstoreViewContentProvider extends AbstractContentProvider {
		
		@Override
		public Object[] getElements(Object input) {
			if (input instanceof ListType) {
				ListType list = (ListType) input;
				return list.getAgentScript().toArray();
			}
			return new Object[] {};
		}
		
	}

	
	/**
	 * Label Provider for Services Viewer.
	 * 
	 * @author kuester
	 */
	protected class AgentstoreViewLabelProvider extends AbstractLabelProvider {

		@Override
		public String getText(Object element) {
			if (element instanceof ScriptType) {
				ScriptType script = (ScriptType) element;
				return script.getName();
			}
			return super.getText(element);
		}
		
		@Override
		protected ImageDescriptor getImageDescriptor(Object element) {
			return VsdtAgents.getImageDescriptor("action.gif");
		}

	}

	
	/**
	 * This class provides a Selection Listener for updating action enablement
	 * and the details panel.
	 * 
	 * @author kuester
	 */
	protected class AgentstoreViewSelectionListener implements ISelectionChangedListener {
		
		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			if (event.getSelection() instanceof StructuredSelection) {
				showDetails(((StructuredSelection) event.getSelection()).getFirstElement());
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
	 * the content of the file is read and uploaded to the Agent Store.
	 * 
	 * This Action is to be moved to a separate view, the AgentStoreView
	 * 
	 * @author kuester
	 */
	protected class UploadAction extends Action {
		
		public UploadAction() {
			super("Upload", VsdtAgents.getImageDescriptor("import.gif"));
			setToolTipText("Upload Services from active Editor to Agent Store.");
		}
		
		@Override
		public void run() {

			if (openMessageDialog(MessageDialog.CONFIRM, "Upload editor content to Agent Store?")) {

				String baseUrl = agentStoreUrlText.getText();
				if (checkUrl(baseUrl)) {

					final String url = baseUrl + "agentScript/saveAPI";
					
					Shell shell = servicesViewer.getControl().getShell();
					UploadToAgentstoreDialog dialog = new UploadToAgentstoreDialog(shell);
		
					if (dialog.open() == InputDialog.OK) {
						final String baseName = dialog.getName();
						final String description = dialog.getDescription();
						final String version = dialog.getVersion();
						
						// start progress monitor
						try {
							ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(shell);
							progressMonitorDialog.run(false, false, new IRunnableWithProgress() {
								@Override
								public void run(IProgressMonitor monitor) {
		
									try {
										// get service sources from active editor
										List<String> serviceSrcs = Util.getServiceSrcs(null);
									
										// check whether any service source files have been found
										if (serviceSrcs != null) {
											for (int i = 0; i < serviceSrcs.size(); i++) {
												String serviceSrc = serviceSrcs.get(i);
												String name = baseName + "_" + i;
												
												// TODO use real tmp files
												
												// save to temporary file
												File file = new File(name + ".jadl");
												System.out.println(file.getAbsolutePath());
												file.createNewFile();
												FileWriter writer = new FileWriter(file);
												writer.write(serviceSrc);
												writer.close();
												
												// upload file using apache commons
												MultipartPostMethod mPost = new MultipartPostMethod(url);
												mPost.addParameter("versionNr", version);
												mPost.addParameter("name", name);
												mPost.addParameter("description", description);
												mPost.addParameter("scriptFile", file);
												
												HttpClient client = new HttpClient();
												client.setConnectionTimeout(5000);
												client.executeMethod(mPost);
												System.out.println("statusLine >>> " + mPost.getStatusLine());
												mPost.releaseConnection();
												
												// delete file
												file.delete();
											}
											int n = serviceSrcs.size();
											String msg = String.format("%d Agent Script%s added to AgentStore", n, (n==1 ? "" : "s"));
											openMessageDialog(MessageDialog.INFORMATION, msg);
										} else {
											// no valid editor -> service source is null, abort
											openMessageDialog(MessageDialog.INFORMATION, "Active Editor has to hold a JADL or VSDT file.");
											return;
										}
										
									} catch (Exception e) {
										openMessageDialog(MessageDialog.ERROR, "Uploading Service Failed: " + e.getMessage());
									}
								}
		
							});
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
}
