package de.dailab.vsdt.diagram.dialogs;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import de.dailab.vsdt.diagram.rsd.IRsdWS;
import de.dailab.vsdt.diagram.views.rsd.ServicePropertyComposite;

/**
 * This dialog shows all the details of a given IRsdWS web service.
 * 
 * @author kuester
 */
public class RsdServiceDetailsDialog extends TitleAreaDialog {
	
	public static final String TITLE= "WebService Details";
	public static final String MESSAGE= "Details on the selected WebService.";
	public static final String TAB_PROPERTIES= "Properties";
	public static final String TAB_WSDL= "WSDL";
	
	public static final int WIDTH= 550;
	public static final int HEIGHT= 400;

	private IRsdWS webService;
	
	private ServicePropertyComposite propComposite;
	private Text wsdlText;
	
	
	/**
	 * create a new ServiceDetailsDialog
	 * 
	 * @param parentShell	the parent shell (will be blocked)
	 * @param webService	the webService currently selected in the RSD View
	 */
	public RsdServiceDetailsDialog(Shell parentShell, IRsdWS webService) {
		super(parentShell);
		this.setTitle(TITLE);
		this.setShellStyle(getShellStyle() | SWT.RESIZE);

		this.webService= webService;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite superComposite = (Composite) super.createDialogArea(parent);
		
		Composite theComposite= new Composite(superComposite, SWT.NONE | SWT.BORDER);
		theComposite.setLayoutData( new GridData( GridData.FILL_BOTH ) );
		theComposite.setLayout(new FillLayout());
		
		TabFolder tabFolder= new TabFolder(theComposite,SWT.TOP);
		
		propComposite= new ServicePropertyComposite(tabFolder, SWT.NONE);
		
		Composite wsdlComposite= new Composite(tabFolder, SWT.NONE);
		wsdlComposite.setLayout(new FillLayout());
		wsdlText= new Text(wsdlComposite, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		wsdlText.setEditable(false);
		wsdlText.setBackground(ColorConstants.white);
		
		//put stuff into tabFolder
		TabItem tabItem;
		tabItem= new TabItem(tabFolder, SWT.NONE);
		tabItem.setText(TAB_PROPERTIES);
		tabItem.setControl(propComposite);
		tabItem= new TabItem(tabFolder, SWT.NONE);
		tabItem.setText(TAB_WSDL);
		tabItem.setControl(wsdlComposite);
		
		return superComposite;
	}
	
	
	@Override
	protected Control createContents(Composite parent) {
		Control superContent = super.createContents(parent);
		
		parent.getShell().setMinimumSize( WIDTH, HEIGHT );
		parent.getShell().setSize( WIDTH, HEIGHT );
		parent.getShell().setText( TITLE );
		setMessage(MESSAGE);
		
		propComposite.displayProperties(webService);
		
		String wsdl= restoreLineBreaks(webService.getWsdl());
		wsdlText.setText(wsdl);
		
		return superContent;
	}
	
	/**
	 * Simple method for restoring the line-breaks in the WSDL file delivered from the RSD.
	 * 
	 * @param wsdl	WSDL file with no line breaks
	 * @return		WSDL file with line breaks
	 */
	public static String restoreLineBreaks(String wsdl) {
		if (wsdl == null) {
			return "";
		}
		StringBuffer fromBuff= new StringBuffer(wsdl);
		StringBuffer toBuff= new StringBuffer();
		
		final String CLOSE_BRACKET= ">";
		final String NEWLINE= System.getProperty("line.separator");
		
		int index= fromBuff.indexOf(CLOSE_BRACKET);
		while (index > -1) {
			String substring= fromBuff.substring(0, index+1);
			fromBuff.replace(0, index+1, "");
			toBuff.append(substring);
			toBuff.append(NEWLINE);
			
			index= fromBuff.indexOf(CLOSE_BRACKET);
		}
		
		return toBuff.toString();
	}
}
