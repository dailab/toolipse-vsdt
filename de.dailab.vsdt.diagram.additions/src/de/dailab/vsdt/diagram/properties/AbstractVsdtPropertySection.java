package de.dailab.vsdt.diagram.properties;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.dailab.common.gmf.ui.FormLayoutUtil;
import de.dailab.common.gmf.ui.properties.AbstractGmfPropertySection;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.ui.ExpressionComposite;
import de.dailab.vsdt.util.VsdtElementFactory;

/**
 * Extending the Common Abstract GMF Property Section with helper methods
 * specific to the Visual Services Design Tool.
 * 
 * Implements FocusListener and SelectionListener, which are needed for nearly
 * each of its subclasses, providing default implementation for two never used
 * methods of these interfaces.
 * 
 * @author kuester
 */
public abstract class AbstractVsdtPropertySection extends AbstractGmfPropertySection 
implements FocusListener, SelectionListener {

	protected static VsdtPackage pack= VsdtPackage.eINSTANCE;
	
    /**
     * return the expression of an expression, or "" if either the expression wrapper or expression
     * string is null
     * 
     * @param expression	some BPMN expression
     * @return				expression string, or "" if null
     */
    protected String getExpression(Expression expression) {
    	if (expression != null && expression.getExpression() != null) {
			return expression.getExpression();
    	}
    	return "";
    }

    /**
     * Create a new Expression from a given String. Returns null, if the string
     * is null or empty.
     * 
     * @param expression	Some String, preferrably non-null and non-empty
     * @return				New Expression holding the non-empty, non-null string, or null
     */
    protected Expression createExpression(String expression) {
    	return VsdtElementFactory.createExpression(expression);
    }
    
    public void focusGained(FocusEvent e) {
    }
    
    public void widgetDefaultSelected(SelectionEvent e) {
    }
    
    protected ExpressionComposite addExpressionComposite(Composite parent, Object top, Object left, Object right) {
    	ExpressionComposite composite= new ExpressionComposite(parent);
    	composite.setLayoutData(FormLayoutUtil.createFormData(top, left, right));
    	composite.setLayout(new GridLayout(2, false));
    	return composite;
    }
    
}