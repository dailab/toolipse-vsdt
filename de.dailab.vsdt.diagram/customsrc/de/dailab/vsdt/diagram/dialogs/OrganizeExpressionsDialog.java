package de.dailab.vsdt.diagram.dialogs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.dailab.common.gmf.Util;
import de.dailab.common.swt.dialogs.AbstractOrganizeElementsDialog;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtFactory;

/**
 * A dialog used for organizing Expressions of a BPMN model element
 * 
 * TODO add more editing power, maybe connect to EditExpressionDialog
 * 
 * @author kuester
 */
public class OrganizeExpressionsDialog extends AbstractOrganizeElementsDialog<Expression> {
	
	private static final String LABEL_EXPRESSION = "Expression";
	private static final String LABEL_LANGUAGE = "Language";

	/**property name input field*/
	private Text expressionText;

	/** expression language to use for this expressions */
	private Text languageText;
	
	@Override
	public String getElementName() {
		return "Expression";
	}
	
	/**
	 * create a new Organize Expressions Dialog
	 * 
	 * @param parentShell		the parent shell (will be blocked)
	 * @param parentElement		the element that contains the expressions
	 * @param hint				hint used for elements containing multiple lists of expressions
	 */
	public OrganizeExpressionsDialog(Shell parentShell, EObject parentElement, int hint) {
		super(parentShell, parentElement, true, 4);
		if (parentElement instanceof Service) {
			if (hint == 0) {
				elements= ((Service) parentElement).getPreconditions();
			} else if (hint == 1) {
				elements= ((Service) parentElement).getEffects();
			}
		}
	}
	
	@Override
	protected void createEditGroupControls(Group editGroup) {
		//input lines
		new Label(editGroup,SWT.NONE).setText(LABEL_EXPRESSION);
		expressionText = new Text(editGroup,SWT.BORDER);
		expressionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		expressionText.addModifyListener(this);

		new Label(editGroup,SWT.NONE).setText(LABEL_LANGUAGE);
		languageText = new Text(editGroup,SWT.BORDER);
		languageText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		languageText.addModifyListener(this);
		
		// TODO button for opening EditExpressionDialog 
	}

	@Override
	protected Expression createNewElement() {
		return VsdtFactory.eINSTANCE.createExpression();
	}
	
	@Override
	protected Control getElementToFocus() {
		return expressionText;
	}

	@Override
	protected void updateElementFromEditGroup(Expression expression) {
		if (expression != null) {
			expression.setExpression(Util.nullIfEmpty(expressionText.getText()));
			expression.setLanguage(Util.nullIfEmpty(languageText.getText()));
		}
	}
	
	@Override
	protected void refreshEditGroup() {
		Expression expression = getSelectedElement();
		if (expression != null) {
			expressionText.setText(Util.nonNull(expression.getExpression()));
			languageText.setText(Util.nonNull(expression.getLanguage()));
		}
		expressionText.setEnabled(expression != null);
		languageText.setEnabled(expression != null);
		//TODO enable/disable button
	}
	
	@Override
	protected String getString(Expression expression) {
		if (expression != null) {
			StringBuilder builder = new StringBuilder();
			builder.append("'").append(expression.getExpression()).append("'");
			String language = expression.getExpressionLanguageToBeUsed();
			if (language != null) {
				builder.append(" (").append(language).append(")");
			}
			return builder.toString();
		}
		return super.getString(null);
	}
	
//	@Override
//	public void widgetSelected(SelectionEvent e) {
//		super.widgetSelected(e);
//		if (e.getSource() instanceof Button	) {
//			if (BUTTON_DATATYPES.equals(((Button) e.getSource()).getText())) {
//				OrganizeElementsAction.getDataTypesAction().run(VsdtHelper.getRootElement(parentElement));
//				// update data types combo
//				updateDataTypes(propTypeCombo, parentElement);
//			}
//		}
//	}
	
}
