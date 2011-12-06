package de.dailab.vsdt.vsdtagents.deployment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.dailab.jiactng.agentcore.ontology.IActionDescription;

/**
 * A Simple Dialog for entering Parameter values for a Service Call. For each
 * Input Parameter, a Text field is displayed, where the user can type a value,
 * which is then parsed to an actual instance of the Class given in the Action
 * Description.
 * 
 * Currently the Types of Input Parameters to be assigned with this Dialog are
 * restricted to String, primitive types, and their respective Wrapper Classes.
 * 
 * TODO Later, this Dialog could be extended to
 * - check Getters and Setters of Java-Beans using Reflection
 * - set arbitrary attributes for Ecore-Objects
 * - create elements for list-type arguments 
 * 
 * @see #supported
 * @see #isSupported(IActionDescription)
 *
 * @author kuester
 */
public class ServiceParameterDialog extends TitleAreaDialog {

	/** Title for the Dialog */
	public static final String TITLE= "Service Input Parameters";
	
	/** Supported Parameter Classes */
	public static Class[] supported = new Class[] {
			String.class,
			Boolean.class, boolean.class,
			Byte.class, byte.class,
			Character.class, char.class,
			Short.class, short.class,
			Integer.class, int.class,
			Long.class, long.class,
			Float.class, float.class,
			Double.class, double.class,
	};

	/**
	 * Check whether the given Service is supported by this dialog, i.e. whether
	 * the dialog can be used for entering and parsing instances of the classes
	 * used as parameters for this Service.
	 * 
	 * @see #parseValue(String, Class)
	 * 
	 * @param service	some Service
	 * @return			parameter of this service supported by this dialog?
	 */
	public static boolean isSupported(IActionDescription service) {
		try {
			for (Class clazz : service.getInputTypes()) {
				if (! Arrays.asList(supported).contains(clazz)) {
					return false;
				}
			}
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}

	
	/** The service to be invoked */
	protected final IActionDescription service;
	
	/** An Array of Text fields holding the values */
	protected List<Text> inputFields;

	/** the parsed values from the Text fields, or null */
	protected List<Serializable> inputValues;
	
	/**
	 * Create Instance of Service Parameter Dialog. Call open() method for 
	 * displaying the dialog.
	 * 
	 * @param parentShell	The Shell
	 * @param service		The Service to Invoke
	 */
	public ServiceParameterDialog(Shell parentShell, IActionDescription service) {
		super(parentShell);
		if (service == null) throw new IllegalArgumentException("Service must not be null");
		this.service = service;
		this.inputValues = null;
	}

	/*
	 * Set up Dialog Frame
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control composite = super.createContents(parent);
		parent.getShell().setText( TITLE );
		setTitle(TITLE);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		setMessage( "Input parameters for Service " + service.getName());
		return composite ;
	}

	/*
	 * Create Contents of the Actual Dialog Area below the Title section.
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite superComposite = (Composite) super.createDialogArea(parent);
	    
		ScrolledComposite scrolledComposite= new ScrolledComposite( superComposite, SWT.V_SCROLL | SWT.H_SCROLL);
	    scrolledComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite group= new Composite(scrolledComposite, SWT.NONE);
		scrolledComposite.setContent(group);
		group.setLayout(new GridLayout(2, false));
		
		try {
			inputFields = new ArrayList<Text>();
			
			for (int i = 0; i < service.getInputTypes().size(); i++) {
				Class clazz = service.getInputTypes().get(i);
				
				// create Label
				Label label= new Label(group, SWT.NONE);
				label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
				label.setText(String.format("arg%d (%s):", i, clazz.getSimpleName()));
				
				// create Text field
				Text text= new Text(group, SWT.BORDER);
		    	text.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		    	inputFields.add(text);
			}
		} catch (ClassNotFoundException e) {
			setErrorMessage("Class Not Found: " + e.getMessage());
		}
		scrolledComposite.setMinHeight(group.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		return superComposite;
	}

	/*
	 * Check Input Fields and parse Values according to Classes. 
	 */
	@Override
	protected void okPressed() {
		if (inputFields != null) {
			try {
				inputValues = new ArrayList<Serializable>(inputFields.size());
				for (int i = 0; i < service.getInputTypes().size(); i++) {
					Class clazz = service.getInputTypes().get(i);
					String string = inputFields.get(i).getText();
					// parse value according to class
					Serializable value = parseValue(string, clazz);
					inputValues.add(value);
				}
			} catch (ClassNotFoundException e) {
				setErrorMessage("Class Not Found: " + e.getMessage());
			}
		}
		super.okPressed();
	}

	/**
	 * @return		the Values for the input parameters set in the dialog
	 */
	public Serializable[] getInputValues() {
		return inputValues.toArray(new Serializable[inputValues.size()]);
	}
	
	/**
	 * Parse and return value given in String according to Class.
	 * 
	 * @param string	String holding some value
	 * @param clazz		some Class
	 * @return			Instance of Class according to Value
	 */
	private Serializable parseValue(String string, Class clazz) {
		Serializable value = null;
		if (clazz == String.class)
			value = string;
		if (clazz == Boolean.class || clazz == boolean.class)
			value = Boolean.parseBoolean(string);
		if (clazz == Byte.class || clazz == byte.class)
			value = Byte.parseByte(string);
		if (clazz == Character.class || clazz == char.class)
			value = string.charAt(0);
		if (clazz == Short.class || clazz == short.class)
			value = Short.parseShort(string);
		if (clazz == Integer.class || clazz == int.class)
			value = Integer.parseInt(string);
		if (clazz == Long.class || clazz == long.class)
			value = Long.parseLong(string);
		if (clazz == Float.class || clazz == float.class)
			value = Float.parseFloat(string);
		if (clazz == Double.class || clazz == double.class)
			value = Double.parseDouble(string);
		return value;
	}

}
