package de.dailab.vsdt.diagram.dialogs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.wsdl.Definition;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * This dialog shows the details of the Web service currently selected
 * in the given viewer.
 * 
 * @author kuester
 */
public class WSDLDetailsDialog extends TitleAreaDialog {
	
	public static final String TITLE= "Web Service Details";
	public static final String MESSAGE= "Details on the selected Web Service.";
	public static final String ERROR_LOAD_WSDL= "An error occured when loading the WSDL.";
	public static final String FONT= "Courier";
	
	public static final String WSDL_DEFAULT= "Click here to load the full WSDL Definition";
	
	public static final int WIDTH= 640;
	public static final int HEIGHT= 480;

	private Text wsdlText;
	
	private Definition definition;
	
	/**
	 * Create a new ServiceDetailsDialog
	 * 
	 * @param parentShell	the parent shell (will be blocked)
	 * @param definition	WSDL service Definition
	 */
	public WSDLDetailsDialog(Shell parentShell, Definition definition) {
		super(parentShell);
		this.definition= definition;
		this.setTitle(TITLE);
		this.setShellStyle(getShellStyle() | SWT.RESIZE);
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		wsdlText= new Text(parent, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		wsdlText.setLayoutData(new GridData( GridData.FILL_BOTH));
		wsdlText.setEditable(false);
		wsdlText.setText(WSDL_DEFAULT);
		wsdlText.setBackground(ColorConstants.white);
		wsdlText.setFont(new Font(getShell().getDisplay(), FONT, 10, SWT.NORMAL));
		wsdlText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if (e.getSource() == wsdlText &&
						WSDL_DEFAULT.equals(wsdlText.getText())) {
					loadWsdl();
				}
			}
		});
		return parent;
	}
	
	@Override
	protected Control createContents(Composite parent) {
		Control superContent = super.createContents(parent);
		
		parent.getShell().setMinimumSize( WIDTH, HEIGHT );
		parent.getShell().setSize( WIDTH, HEIGHT );
		parent.getShell().setText( TITLE );
		setMessage(MESSAGE);
		
		
		return superContent;
	}

	private void loadWsdl() {
		BufferedReader reader= null;
		try {
			reader= new BufferedReader(new InputStreamReader(
					new URL(definition.getDocumentBaseURI()).openStream()));
			StringBuffer buffer= new StringBuffer();
			String line= reader.readLine();
			while (line != null) {
				if (! line.trim().isEmpty()) {
					buffer.append(line);
					buffer.append(System.getProperty("line.separator"));	
				}
				line= reader.readLine();
			}
			reader.close();
			wsdlText.setText(buffer.toString());
		} catch (IOException e) {
			setErrorMessage(ERROR_LOAD_WSDL);
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
			}
		}
	}
}
