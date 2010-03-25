package de.dailab.vsdt.diagram.imprt;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardExportResourcesPage;

public class VsdtImportWizardOptionsPage extends WizardExportResourcesPage {
	
	public static final String[] EXTENSIONS = new String[] { "vsdtd", "vsdt"/*, "vsdt_diagram"*/ };
	
	private static final String LABEL_TITLE= "From VSDT diagrams:";
	private static final String LABEL_SELECT_FOLDER= "Into VSDT diagram:";
	private static final String LABEL_BROWSE= "Browse...";
	private static final String LABEL_BACKUP= "Backup original file";
	private static final String LABEL_LAYOUT= "Preserve layout";
	private static final String LABEL_MERGE= "Merge identical";
	
	public static final boolean DEFAULT_BACKUP= true;
	public static final boolean DEFAULT_LAYOUT= true;
	public static final boolean DEFAULT_MERGE= false;
	
	private boolean doBackup= DEFAULT_BACKUP;
	private boolean doLayout= DEFAULT_LAYOUT;
	private boolean doMerge= DEFAULT_MERGE;

	private transient Text destinationText= null;
	private transient SelectionListener listener= null;

	private URI uri= null;
	
	public VsdtImportWizardOptionsPage(String pageName, 
			IStructuredSelection selection) {
		super(pageName, selection);
		this.setDescription(getDescription());
		this.setTitle(LABEL_TITLE);
		this.listener = new ButtonListener();
	}

	@Override
	protected void createDestinationGroup(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout= new GridLayout(3,false);
		composite.setLayout(gridLayout);
		
        Label destinationLabel = new Label(composite, SWT.NONE);
        destinationLabel.setText(LABEL_SELECT_FOLDER);

        destinationText= new Text(composite,SWT.BORDER);
        destinationText.setLayoutData(new GridData(350,-1));
        destinationText.addModifyListener(new ModifyListener() {
        	public void modifyText(ModifyEvent e) {
        		String path= destinationText.getText();
        		uri= URI.createFileURI(path);
        		updatePageCompletion();
        	}
        });
        
        Button browseButton= new Button(composite, SWT.NONE);
        browseButton.setText(LABEL_BROWSE);
        browseButton.addSelectionListener(listener);
	}
	
	@Override
	protected void createOptionsGroup(Composite parent) {
		Composite composite= new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());

		createCheckbox(composite, LABEL_BACKUP, DEFAULT_BACKUP, listener);
		createCheckbox(composite, LABEL_LAYOUT, DEFAULT_LAYOUT, listener);//.setEnabled(false);
		createCheckbox(composite, LABEL_MERGE, DEFAULT_MERGE, listener);//.setEnabled(false);
	}
	
	private Button createCheckbox(Composite parent, String text, boolean selection, SelectionListener listener) {
		Button button= new Button(parent, SWT.CHECK);
		button.setText(text);
		button.setSelection(selection);
		button.addSelectionListener(listener);
		return button;
	}

	public void handleEvent(Event event) {
		// XXX when is this called?
		System.err.println(event);
	}
	
	@Override
	public boolean isPageComplete() {
		setErrorMessage(null);
		List<IFile> selected = this.getSelectedResources();
		if (uri != null && selected.size() > 0) {
			for (IFile file : selected) {
				if (! Arrays.asList(EXTENSIONS).contains(file.getFileExtension())) {
					setErrorMessage("Only files of type 'vsdtd' or 'vsdt' can be imported!");
					return false;
				}
			}
			if (! new File(uri.toFileString()).exists() ) {
				setErrorMessage("Target file does not exist.");
				return false;
			}
			if (! EXTENSIONS[0].equals(uri.fileExtension())) {
				setErrorMessage("Target file must be of type '" + EXTENSIONS[0] + "'.");
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * same as super, but public and using a typed list
	 */
	public List<IFile> getSelectedResources() {
		return super.getSelectedResources();
	}
	
	public URI getPath() {
		return uri;
	}

	
	private class ButtonListener extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			if (e.getSource() instanceof Button) {
				Button button = (Button) e.getSource();
				if (LABEL_LAYOUT.equals(button.getText())) {
					doLayout = button.getSelection();
				}
				if (LABEL_MERGE.equals(button.getText())) {
					doMerge = button.getSelection();
				}
				if (LABEL_BROWSE.equals(button.getText())) {
					
					// TODO display fancier dialog here
					
					FileDialog dialog= new FileDialog(getShell());
					String filename= dialog.open();
					if (filename != null) {
						destinationText.setText(filename);
		        		uri= URI.createFileURI(filename);
					}
					
				}
			}
		}
	}
	
	public boolean isDoBackup() {
		return doBackup;
	}
	
	public boolean isDoLayout() {
		return doLayout;
	}
	
	public boolean isDoMerge() {
		return doMerge;
	}
	
}
