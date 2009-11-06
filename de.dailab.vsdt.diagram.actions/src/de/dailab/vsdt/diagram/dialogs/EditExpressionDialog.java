package de.dailab.vsdt.diagram.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.dailab.common.gmf.Util;
import de.dailab.common.gmf.ui.FormLayoutUtil;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.diagram.ui.VsdtFeatureCombo;
import de.dailab.vsdt.vxl.Variable;
import de.dailab.vsdt.vxl.util.VxlParseException;
import de.dailab.vsdt.vxl.util.VxlParser;

/**
 * This dialog an be used for editing a given expression. The expression is assumed to follow the
 * VXL (VSDT Expression Language) syntax, allowing it to check the expression's syntax and to 
 * insert properties available in the current element's scope into the expression.
 * 
 * Later, these expressions can easily be translated to other languages.
 * 
 * Currently, this dialog works on a copy of the Expression string, not the Expression
 * itself, thus it can not be directly modified in the dialog but has been updated after
 * the OK button has been pressed.
 * 
 * @author kuester
 */
public class EditExpressionDialog extends TitleAreaDialog {

	public static final String NL= System.getProperty("line.separator");
	
	public static final int WIDTH= 550;
	public static final int HEIGHT= 250;
	
	public static final String TITLE= "Edit Expression";
	public static final String MESSAGE= "Compose and validate expressions according to the " +
			"VSDT Expression Language (VXL).  If VXL is set as the diagram's Expression Language, " +
			"these expressions will be translated to the target language when being exported.";
	
	protected String expression;
	protected boolean forceValidation;
	
	protected Text expressionText;
	protected Button checkButton;
	
	protected List<Property> properties= null;
	protected VsdtFeatureCombo<Property> propertiesCombo;
	protected Button insertPropertyButton;

	/**
	 * Constructor.
	 * 
	 * @param parentShell		the shell
	 * @param expression		the expression to edit
	 * @param forceValidation	force validation when hitting ok button
	 */
	public EditExpressionDialog(Shell parentShell, String expression, boolean forceValidation) {
		super(parentShell);
		this.expression= expression;
		this.forceValidation= forceValidation;
		this.setTitle(TITLE);
		this.setShellStyle(getShellStyle());
	}

	@Override
	protected Control createContents(Composite parent) {
		Control superContent = super.createContents(parent);
		
		parent.getShell().setMinimumSize( WIDTH, HEIGHT );
		parent.getShell().setSize( WIDTH, HEIGHT );
		parent.getShell().setText( TITLE );
		setMessage( MESSAGE);
		
		return superContent;
	}
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite superComposite = (Composite) super.createDialogArea(parent);
		Composite composite = FormLayoutUtil.createFlatFormComposite(parent);
		composite.setBackground(parent.getBackground());
		composite.setLayoutData( new GridData( GridData.FILL_BOTH ) );

		CLabel label;

		// Text field
		label= FormLayoutUtil.addLabel(composite, "Expression", 0, 0);
		expressionText= FormLayoutUtil.addText(composite, 0, label, 100, SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);
		((FormData) expressionText.getLayoutData()).height= 45;
		expressionText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				expression= expressionText.getText();
			}
		});
		expressionText.setText(Util.nonNull(expression));

		// Syntax check
		checkButton= FormLayoutUtil.addButton(composite, "Check", SWT.NONE, expressionText, null, 100);
		checkButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				checkExpression();
			}
		});
		
		// Properties
		insertPropertyButton= FormLayoutUtil.addButton(composite, "Insert Property", SWT.NONE, expressionText, null, checkButton);
		insertPropertyButton.setEnabled(properties != null);
		insertPropertyButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				insertProperty();
			}
		});
		
		label= FormLayoutUtil.addLabel(composite, "Properties", expressionText, 0);
		propertiesCombo= new VsdtFeatureCombo<Property>(FormLayoutUtil.addCombo(composite, SWT.READ_ONLY, expressionText, label, insertPropertyButton));
		propertiesCombo.getCombo().setEnabled(properties != null);
		if (properties != null) {
			propertiesCombo.fillCombo(properties);
		}
		
		return superComposite;
	}
	
	/**
	 * @return		New value for the expression, or null, if the new value is empty
	 */
	public String getExpression() {
		return Util.nullIfEmpty(expression);
	}
	
	/**
	 * Pass the properties that are visible in the scope of the Expression's owner.
	 * These properties are then displayed in a drop-down menu and can be inserted
	 * into the Expression as variables.
	 * 
	 * @param properties	Properties in the scope of the Expression to be edited
	 */
	public void setProperties(List<Property> properties) {
		this.properties= properties;
	}
	
	/**
	 * Create a new VxlParserHelper and try to parse the expression. If the expression
	 * can not be parsed or if there are parse errors these errors will be displayed
	 * to the user. Further, for each variable in the term it is checked if the variable
	 * can be found in the scope of the expression.
	 */
	private boolean checkExpression() {
		setMessage(MESSAGE);
		setErrorMessage(null);
		String expression= expressionText.getText();
		VxlParser parser= VxlParser.getInstance();
		try {
			parser.parse(expression);
			setMessage("Expression is valid.");
			
			if (properties != null) {
				List<String> varNames= new ArrayList<String>();
				for (Property prop : properties) {
					varNames.add(prop.getName());
				}
				List<Variable> unknownVars= parser.getUnknownVariables(varNames);
				if (! unknownVars.isEmpty()) {
					setErrorMessage("Variable '$" + unknownVars.get(0).getName() + "' cannot be resolved");
					return false;
				}
			}
		} catch (VxlParseException e) {
			if (! parser.getErrors().isEmpty()) {
				setErrorMessage(parser.getErrors().get(0).getMessage());
			} else if (! parser.getWarnings().isEmpty()) {
				setErrorMessage(parser.getWarnings().get(0).getMessage());
			} else {
				setErrorMessage("Parsing failed");
			}
			return false;
		}
		return true;
	}
	
	/**
	 * Get the currently selected entry from the properties combo 
	 * and insert it at the caret position. 
	 */
	private void insertProperty() {
		if (propertiesCombo != null) {
			Property selected= propertiesCombo.getSelected();
			int caret= expressionText.getCaretPosition();
			if (selected != null) {
				StringBuffer buffer= new StringBuffer();
				buffer.append(expression.substring(0, caret));
				buffer.append("$" + selected.getName());
				buffer.append(expression.substring(caret));
				expression= buffer.toString();
				expressionText.setText(expression);
			}
		}
	}
	
	@Override
	protected void okPressed() {
		if (! forceValidation || checkExpression()) {
			super.okPressed();	
		}
	}
}
