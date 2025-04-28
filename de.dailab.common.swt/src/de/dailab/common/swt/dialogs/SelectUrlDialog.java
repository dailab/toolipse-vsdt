package de.dailab.common.swt.dialogs;

import java.io.File;
import java.net.URL;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * This dialog is used for entering a remote URL or browsing the local file system.
 * While it's intended use is for selecting a WSDL file, it can be used for other 
 * URL-selection-specific purposes as well.
 * 
 * @author kuester
 */
public class SelectUrlDialog extends TitleAreaDialog {
	
	public static final String TITLE= "Select URL";
	public static final String MESSAGE= "Specify a URL or select a local file.";
	public static final String ERROR_LOAD_WSDL= "An error occured when loading the file.";
	
	/** text field for manually typing in the desired URL */
	private Text urlText;

	/** button for browsing the local file system */
	private Button browseButton;
	
	/** the selected or entered URL, or null */
	private URL url;
	
	/**
	 * Create a new SelectUrlDialog
	 * 
	 * @param parentShell	the parent shell (will be blocked)
	 */
	public SelectUrlDialog(Shell parentShell) {
		super(parentShell);
		this.setTitle(TITLE);
		this.setShellStyle(getShellStyle() | SWT.RESIZE);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		// editing the text field will on the fly validate the URL
		urlText= new Text(parent, SWT.BORDER);
		urlText.setLayoutData(new GridData( GridData.FILL_HORIZONTAL));
		urlText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				try {
					url= new URL(urlText.getText());
				} catch (Exception ex) {
					setErrorMessage("Can not parse URL");
				}
			}
		});
	
		// the button browses the local file system and parses the selected file to a URL
		browseButton= new Button(parent, SWT.NONE);
		browseButton.setText("Browse...");
		browseButton.setLayoutData(new GridData( GridData.HORIZONTAL_ALIGN_END));
		browseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog= new FileDialog(getParentShell());
				String fileName= dialog.open();
				if (fileName != null) {
					try {
						url= new File(fileName).toURI().toURL();
						urlText.setText(url.toString());
					} catch (Exception ex) {
						setErrorMessage("Failed to retrieve file URL");
					}
				}
			}
		});
		return parent;
	}
	
	@Override
	protected Control createContents(Composite parent) {
		Control superContent = super.createContents(parent);
		parent.getShell().setText( TITLE );
		setMessage(MESSAGE);
		return superContent;
	}
	
	/**
	 * @return		the selected URL, or null
	 */
	public URL getUrl() {
		return url;
	}
	
}
