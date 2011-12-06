package de.dailab.vsdt.vsdtagents.agentstore;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * This dialog is used for describing the agent scripts to be uploaded to the
 * agent store. Basically this dialog provides not much more than an input field
 * for the service's name and its description. Later, it can be extended for e.g.
 * selection of an icon, assignment of tags, etc.
 * 
 * @author kuester
 */
public class UploadToAgentstoreDialog extends TitleAreaDialog {

	public static final String TITLE= "Upload to Agent Store Dialog";
	public static final String MESSAGE= "Please provide a description for " +
			"the agent script you want to upload to the Agent Store.";

	/** cached value for the name */
	private String name = "myScript";
	
	/** cached value for the description */
	private String description = "";

	/** cached value for the version */
	private String version = "1.0";
	
	/**
	 * Create new Upload to Agent Store Dialog
	 * 
	 * @param parentShell		The Shell
	 */
	public UploadToAgentstoreDialog(Shell parentShell) {
		super(parentShell);
		setTitle(TITLE);
		setShellStyle(getShellStyle() | SWT.RESIZE);
	}	

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control superContent = super.createContents(parent);
		parent.getShell().setSize(400, 300);
		parent.getShell().setText( TITLE );
		setMessage( MESSAGE );
		getButton(IDialogConstants.OK_ID).setEnabled(false);
		return superContent;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite superComposite = (Composite) super.createDialogArea(parent);

		Composite composite = new Composite(superComposite, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(2, false));
		
		// name
		createLabel(composite, "Name");
		final Text nameText = new Text(composite, SWT.BORDER);
		nameText.setText(name);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		nameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				name = nameText.getText();
				refresh();
			}
		});
		
		// description
		createLabel(composite, "Description");
		final Text descriptionText = new Text(composite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
		descriptionText.setText(description);
		descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		descriptionText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				description = descriptionText.getText();
				refresh();
			}
		});
		
		// version
		createLabel(composite, "Version");
		final Text versionText = new Text(composite, SWT.BORDER);
		versionText.setText(version);
		versionText.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		versionText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				version = versionText.getText();
				refresh();
			}
		});
		
		return superComposite;
	}

	private boolean notSet(String s) {
		return s == null || s.isEmpty();
	}

	private void refresh() {
		String errorMessage = null;
		if (notSet(name)) {
			errorMessage = "Please specify a name!";
		} else
		if (notSet(description)) {
			errorMessage = "Please specify a description!";
		} else
		if (notSet(version)) {
			errorMessage = "Please specify a version!";
		}
		setErrorMessage(errorMessage);
		getButton(IDialogConstants.OK_ID).setEnabled(errorMessage == null);
	}
	
	private void createLabel(Composite parent, String text) {
		Label label = new Label(parent, SWT.NONE);
		label.setText(text);
		label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
		
	public String getVersion() {
		return version;
	}
}
