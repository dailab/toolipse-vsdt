package de.dailab.vsdt.diagram.imprt;

import java.io.File;
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
	
	public static final String EXTENSION = "vsdtd";
	
	private static final String LABEL_TITLE= "From VSDT diagrams:";
	private static final String LABEL_SELECT_FOLDER= "Into VSDT diagram:";
	private static final String LABEL_BROWSE= "Browse...";
	private static final String LABEL_BACKUP= "Backup original file";
	private static final String LABEL_LAYOUT= "Preserve layout";
	private static final String LABEL_MERGE= "Merge identical";
	
	public static final boolean DEFAULT_BACKUP= true;
	public static final boolean DEFAULT_LAYOUT= false;
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

		Button b= createCheckbox(composite, LABEL_BACKUP, DEFAULT_BACKUP, listener);
		b= createCheckbox(composite, LABEL_LAYOUT, DEFAULT_LAYOUT, listener);
		b.setEnabled(false);
		b= createCheckbox(composite, LABEL_MERGE, DEFAULT_MERGE, listener);
		b.setEnabled(false);
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
				if (! EXTENSION.equals(file.getFileExtension()) ) {
					setErrorMessage("Only files of type '" + EXTENSION + "' can be imported!");
					return false;
				}
			}
			if (! new File(uri.toFileString()).exists() ) {
				setErrorMessage("Target file does not exist.");
				return false;
			}
			if (! EXTENSION.equals(uri.fileExtension())) {
				setErrorMessage("Target file must be of type '" + EXTENSION + "'.");
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
					
//					ResourceSelectionDialog dialog= new ResourceSelectionDialog(
//							getShell(), selection, null); 
//					if (ResourceSelectionDialog.OK == dialog.open()) {
//						Object[] res = dialog.getResult();
//						for (Object r : res) {
//							System.out.println(r.getClass().getSimpleName());
//							System.out.println(r.toString());
//						}
//					}
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
