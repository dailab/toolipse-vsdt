package de.dailab.vsdt.diagram.ui;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import de.dailab.common.gmf.command.SetPropertyValueCommand;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.diagram.dialogs.EditExpressionDialog;
import de.dailab.vsdt.util.VsdtElementFactory;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * A Composite widget to be used for entering and editing Expression. It consists of
 * a text field and a button for opening the EditExpressionDialog, which then provides
 * some more features than the text field itself. The new value set for the expression
 * in the dialog will then be written back into the text field.
 * 
 * For full functionality, the Owner and Feature of the Expression to be edited should 
 * be provided. In that case the expression will be automatically updated on modifications
 * in the text field or the dialog. Further, and more importantly, the dialog can be used
 * for inserting existing properties into an expression and for checking whether there are
 * undefined properties used in the expression.
 * 
 * TODO for some reason, this appears as black on some systems (e.g. for Michael B., Fedora, Gnome 3)
 * 
 * @author kuester
 */
public class ExpressionComposite extends Composite {
	
	protected final Text expressionText;
	protected final Button editButton;
	
	protected String language;

	/** the owner of the expression, i.e. the EObject the Expression is contained in */
	protected EObject owner;
	
	/** the containment feature of the owner referencing the Expression */
	protected EReference feature;
	
	/**
	 * Create a new Expression Composite in the given parent. The Composite consists
	 * of a text field and a button.
	 * 
	 * @param parent		Parent Composite
	 */
	public ExpressionComposite(Composite parent) {
		super(parent, SWT.NONE);
    	setBackground(parent.getBackground());
    	setLayout(new GridLayout(2, false));
		
    	expressionText= new Text(this, SWT.BORDER);
    	expressionText.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, true));

    	editButton= new Button(this, SWT.NONE);
    	editButton.setText("..."); //$NON-NLS-1$
    	editButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
    	editButton.addSelectionListener(new ExpressionCompositeSelectionAdapter());
	}

	/**
	 * Sets the owner and the feature of the Expression. Additionally, the text field
	 * will be given a focus listener, using the owner and feature to update the model
	 * element when the expression is changed.
	 * 
	 * @param owner			EObject containing the Expression
	 * @param feature		Containment feature holding the Expression
	 */
	public void setOwnerAndFeature(EObject owner, EReference feature) {
		this.owner= owner;
		this.feature= feature;
		this.expressionText.addFocusListener(new ExpressionCompositeFocusAdapter());
	}

	/**
	 * @return			The Expression
	 */
	public String getExpression() {
		return expressionText.getText();
	}
	
	public void setValues(Expression expression) {
		this.expressionText.setText(expression != null && expression.getExpression() != null ? expression.getExpression() : "");
		this.language = expression != null ? expression.getLanguage() : null;
	}

	/**
	 * @param string	New value for Expression
	 */
	public void setExpression(String string) {
		expressionText.setText(string);
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public void setEnabled(boolean enabled) {
		expressionText.setEnabled(enabled);
		editButton.setEnabled(enabled);
		super.setEnabled(enabled);
	}
	
	/**
	 * Each listener, that is added to the composite, will be added to the Text field instead.
	 * Thus the Composite can be treated like a simple text field in many ways, making change easier.
	 */
	@Override
	public void addListener(int eventType, Listener listener) {
		expressionText.addListener(eventType, listener);
	}

	/**
	 * @return		The Expression Text field
	 */
	public Text getTextfield() {
		return expressionText;
	}
	
	/**
	 * If owner and Feature are set, the expression is updated with the current value
	 * of the expression text field and the information provided by the dialog.
	 *
	 * This will always create a new Expression (or set the expression to null if the
	 * text is empty) instead of changing an existing instance, as this would be much
	 * more complicated and error-prone for very limited benefit.
	 */
	private void updateModelElement() {
		if (owner != null && feature != null) {
			Expression expression= VsdtElementFactory.createExpression(expressionText.getText());
			if (expression != null) {
				expression.setLanguage(language);
			}
			SetPropertyValueCommand command= new SetPropertyValueCommand(owner, feature, expression);
	    	try {
	        	OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);	
	    	} catch (ExecutionException e) {
	    		e.printStackTrace();
	    	}
		}
	}
	
	/**
	 * This listener reacts on the button being pressed, opening an EditExpressionDialog
	 * and applying the changes if the OK button has been pressed.
	 * 
	 * @author kuester
	 */
	protected class ExpressionCompositeSelectionAdapter extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			String expression= expressionText.getText(); 
			EditExpressionDialog dialog= new EditExpressionDialog(shell, expression, language, false);
			if (owner != null) {
				BusinessProcessSystem bps = (BusinessProcessSystem) VsdtHelper.getRootElement(owner);
				dialog.setProperties(VsdtHelper.getVisibleProperties(owner));
				dialog.setParameters(bps.getParameters());
			}
			if (dialog.open() == Dialog.OK) {
				expressionText.setText(dialog.getExpression());
				language = dialog.getLanguage();
				updateModelElement();
			}
		}
	}
	
	/**
	 * This listener reacts to the text field, updating the model element (if specified)
	 * whenever the user switches away from the text field.
	 * 
	 * @author kuester
	 */
	protected class ExpressionCompositeFocusAdapter extends FocusAdapter {
		@Override
		public void focusLost(FocusEvent e) {
			updateModelElement();
		}
	}
	
}
