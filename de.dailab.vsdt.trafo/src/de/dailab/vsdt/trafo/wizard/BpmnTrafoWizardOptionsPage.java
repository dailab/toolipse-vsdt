package de.dailab.vsdt.trafo.wizard;

import java.util.List;

import org.apache.log4j.Level;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardExportResourcesPage;

public abstract class BpmnTrafoWizardOptionsPage extends WizardExportResourcesPage {
	
	public static final String LABEL_TITLE= "Select model file(s) and destination folder";
	public static final String LABEL_SELECT_FOLDER= "Select destination folder:";
	public static final String LABEL_BROWSE= "Browse";
	public static final String LABEL_CREATE_LOG= "Create Log File";
	public static final String LABEL_YES= "yes";
	public static final String LABEL_NO= "no";
	
	public static final boolean DEFAULT_CREATE_LOG= true;
	public static final String DEFAULT_LOG_LEVEL= Level.INFO.toString();
	
	private Text destinationText= null;
	private Label logLevelLabel= null;
	private Combo logLevelCombo= null;
	private String path= "";
	
	private boolean createLog= DEFAULT_CREATE_LOG;
	private String logLevel= DEFAULT_LOG_LEVEL;
	
	public BpmnTrafoWizardOptionsPage(String pageName, 
			IStructuredSelection selection) {
		super(pageName, selection);
		this.setDescription(getDescription());
		this.setTitle(LABEL_TITLE);
	}

	/**
	 * @return	The Extension of selectable files, e.g. 'bpmn', 'bpel', etc.
	 */
	public abstract String getExtension();
	
	/**
	 * @return	The Description for this Wizard page, telling the user what to do.
	 */
	public abstract String getDescription();
	
	@Override
	protected void createDestinationGroup(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		
		GridLayout gridLayout= new GridLayout(3,false);
		composite.setLayout(gridLayout);
		
        Label destinationLabel = new Label(composite, SWT.NONE);
        destinationLabel.setText(LABEL_SELECT_FOLDER);

        destinationText= new Text(composite,SWT.BORDER);
        GridData textData = new GridData(350,-1);
        destinationText.setText(path);
        destinationText.setLayoutData(textData);
        destinationText.addModifyListener(new ModifyListener() {
        	public void modifyText(ModifyEvent e) {
        		path= destinationText.getText();
        	}
        });
        
        Button browseButton= new Button(composite,SWT.NONE);
        browseButton.setText(LABEL_BROWSE);
        browseButton.addMouseListener(new MouseListener() {
        	public void mouseDown(MouseEvent e) {
        		DirectoryDialog dialog= new DirectoryDialog(getShell());
        		String filename= dialog.open();
        		if (filename != null) {
        			path= filename;
        			destinationText.setText(path);
        		}
        	}
			public void mouseDoubleClick(MouseEvent e) {
        	}
			public void mouseUp(MouseEvent e) {
			}
        });
	}
	
	@Override
	protected void createOptionsGroup(Composite parent) {
		
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout= new GridLayout(3,false);
		composite.setLayout(gridLayout);
		
		final Button button= new Button(composite, SWT.CHECK);
		button.setText(LABEL_CREATE_LOG);
		button.setSelection(DEFAULT_CREATE_LOG);
		button.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				createLog= button.getSelection();
				logLevelLabel.setEnabled(createLog);
				logLevelCombo.setEnabled(createLog);
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		logLevelLabel= new Label(composite,SWT.NONE);
		logLevelLabel.setText("Log Level");
		
		logLevelCombo= new Combo(composite, SWT.READ_ONLY);
		logLevelCombo.add(Level.FATAL.toString());
		logLevelCombo.add(Level.ERROR.toString());
		logLevelCombo.add(Level.WARN.toString());
		logLevelCombo.add(Level.INFO.toString());
		logLevelCombo.add(Level.DEBUG.toString());
		logLevelCombo.add(Level.ALL.toString());
		logLevelCombo.select(logLevelCombo.indexOf(DEFAULT_LOG_LEVEL));
		logLevelCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				logLevel= logLevelCombo.getItem(logLevelCombo.getSelectionIndex());
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	public void handleEvent(Event event) {
	}
	
	@Override
	public boolean isPageComplete() {
		List<IFile> selected = this.getSelectedResources();
		
		if (selected.size() > 0) {
			//set default path
			IFile file = (IFile) selected.get(0);
//			path= file.getProject().getLocation().toOSString();
			path= file.getParent().getLocation().toOSString();
			destinationText.setText(path);
		}
		
		if (destinationText.getText()==null || destinationText.getText().length() ==0 ){
			return false;
		}
		
		setErrorMessage(null);
		for (IFile file : selected) {
			if (! file.getFileExtension().endsWith(getExtension())) {
				setErrorMessage("Please select a number of ." + getExtension() + " files, and only those, for transformation.");
				return false;
			}
		}
		return selected.size() > 0;
	}
	
	/**
	 * same as super, but public and using a typed list
	 */
	@SuppressWarnings("unchecked")
	public List<IFile> getSelectedResources() {
		return super.getSelectedResources();
	}
	
	public String getPath() {
		return path;
	}
	
	public boolean getCreateLog() {
		return createLog;
	}
	
	public String getLogLevel() {
		return logLevel;
	}

}
