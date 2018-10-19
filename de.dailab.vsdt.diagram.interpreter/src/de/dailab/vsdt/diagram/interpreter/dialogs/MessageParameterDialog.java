package de.dailab.vsdt.diagram.interpreter.dialogs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.dailab.vsdt.Property;
import de.dailab.vsdt.diagram.ui.ExpressionComposite;
import de.dailab.vsdt.util.ExpressionHelper;

/**
 * This dialog is used for (a) inspecting and (b) setting the values passed from 
 * one Pool to another in an Interpreting Simulation.  The main purpose of this
 * is to provide return values for "black box" services when running an interpreting
 * simulation, whereas the user can enter appropriate return values depending on
 * the formerly sent input parameters.  Besides, it is also valuable for simply
 * tracing which values are sent between two private (non-"black box") Pools.  
 *
 * @author kuester
 */
public class MessageParameterDialog extends TitleAreaDialog {

	public static final String TITLE= "Message Parameters";
	public static final String WARNING_INCOMPLETE_INPUT= "There are unassigned " +
			"parameters left. Exit anyway?";
	
	/** The message being sent*/
	protected final List<Property> properties;
	
	/** Incoming or Outgoing message? (used only for a label) */
	protected final boolean incoming;
	
	/** Mapping of Properties to Text fields */ 
	protected final Map<Property, Text> propertyTextMap;
	
	/** Mapping of Properties to their values */
	protected final Map<Property, Object> valuesMap;
	
	/**
	 * Create new Message Parameter Dialog.  Besides the actual Message, also the
	 * Mapping of Properties to values has to be given.  This mapping is used (a)
	 * for getting the initial values for the Message's Properties, and (b) for 
	 * storing the new values after the dialog has been exited with OK.  Thus, 
	 * note that the Map (or its content) may be altered in the course if this
	 * dialog's execution.  You can either use the actual context of the simulation
	 * for this or create a new map holding only the Message's Properties and 
	 * then read the new values using {@link #getNewPropertyValue(Property)}.
	 * 
	 * @param parentShell	The Shell
	 * @param message		The Properties to show (and set)
	 * @param incoming		Incoming or outgoing message? Only used for a label
	 * @param valuesMap		Map holding the Properties' values
	 */
	public MessageParameterDialog(Shell parentShell, List<Property> properties, boolean incoming, Map<Property, Object> valuesMap) {
		super(parentShell);
		setTitle(TITLE);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		
		if (properties == null) throw new IllegalArgumentException("Properties must not be null");
		this.properties = properties;
		this.incoming = incoming;
		this.valuesMap = valuesMap;
		this.propertyTextMap = new HashMap<Property, Text>();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control superContent = super.createContents(parent);
		parent.getShell().setText( TITLE );
		setMessage( incoming ? "Receiving" : "Sending");
		setErrorMessage(null);
		return superContent;
	}

	/**
	 * Create a Group of Labels and Text fields similar (but not quite) like the
	 * {@link ExpressionComposite}.  The Text fields are populated with (a String
	 * representation of) the Property's value.
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite superComposite = (Composite) super.createDialogArea(parent);
	    ScrolledComposite scrolledComposite= new ScrolledComposite( superComposite, SWT.V_SCROLL | SWT.H_SCROLL);
	    scrolledComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		final Group group= new Group(scrolledComposite, SWT.NONE);
		scrolledComposite.setContent(group);
		group.setText("Properties");
		group.setLayout(new GridLayout(2, false));
		for (Property property : properties) {
			// create Label
			Label label= new Label(group, SWT.NONE);
			label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
			label.setText(property.getName() + ": "); // unicode rightward arrow
			// create Expression Edit Line
			final Text expressionText= new Text(group, SWT.BORDER);
	    	expressionText.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
	    	if (valuesMap.containsKey(property) && valuesMap.get(property) != null) {
	    		Object value= valuesMap.get(property);
	    		expressionText.setText(value instanceof String ? "\""+(String)value+"\"" : value.toString());
	    	}
			propertyTextMap.put(property, expressionText);
		}
		scrolledComposite.setMinHeight(group.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		return superComposite;
	}

	/**
	 * When the OK button is pressed, the expressions in the Text fields are 
	 * parsed and evaluated.  If all expressions are parsed and evaluated without
	 * errors, they are written to the {@link #valuesMap}; otherwise the method
	 * returns without exiting the dialog, and an error message is shown, so that
	 * the user can correct the error and try again.  If the Text field contains
	 * only white space characters, the Property will be assigned a null value.
	 */
	@Override
	protected void okPressed() {
		Map<Property, Object> newValues= new HashMap<>();
		// test-parse each value
		for (Entry<Property, Text> entry : propertyTextMap.entrySet()) {
			String expression= entry.getValue().getText().trim();
			if (expression.isEmpty()) {
				newValues.put(entry.getKey(), null);
			} else {
				try {
					Object result = ExpressionHelper.parseAndEvaluate(expression, null, "VXL");
					newValues.put(entry.getKey(), result);
				} catch (IllegalArgumentException e) {
					setErrorMessage(e.getMessage());
					return;
				}
			}
		}
		// not returned until now -> put new values in context
		valuesMap.putAll(newValues);
		super.okPressed();
	}
	
	/**
	 * @param property	One of the message's Properties
	 * @return			The Property's (new) value
	 */
	public Object getNewPropertyValue(Property property) {
		if (property != null) {
			return valuesMap.get(property);
		} else {
			return null;
		}
	}
}
