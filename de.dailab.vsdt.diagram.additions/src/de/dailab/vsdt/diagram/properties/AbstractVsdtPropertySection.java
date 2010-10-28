package de.dailab.vsdt.diagram.properties;

import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.text.FlowFigureLayout;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.dailab.common.gmf.properties.AbstractGmfPropertySection;
import de.dailab.common.swt.FormLayoutUtil;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.IdObject;
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
	
	public static final String DISPLAY_NAME= "Name",
							   DISPLAY_DOCUMENTATION= "Documentation",
							   DISPLAY_ID= "Id",
							   DISPLAY_GENERATE_ID= "Generate ID";

    protected IdObject idObject;
    
	private Text nameText;
//	private Text idText;
    private Text docText;
    
    protected Control lastControl = null;
    
    protected Composite composite;
    protected Composite buttonComposite;

    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getIdObject();
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof IdObject) {
        	this.idObject= (IdObject) eObject;
        }
    }

    @Override
 	protected void internalRefresh() {
    	nameText.setText(nonNull(idObject.getName()));
//    	idText.setText(nonNull(idObject.getId()));
        docText.setText(nonNull(idObject.getDocumentation()));
    }
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        composite = getWidgetFactory().createFlatFormComposite(parent);
        composite.setBackgroundMode(SWT.INHERIT_FORCE);
        CLabel label;
        
        // name
        label = FormLayoutUtil.addLabel(composite, DISPLAY_NAME, 0, 0);
        nameText= FormLayoutUtil.addText(composite, 0, label, 50, SWT.NONE);
        nameText.addFocusListener(this); 

//		// id
//		label = FormLayoutUtil.addLabel(composite, "Identifier", 0, 50);
//		idText= FormLayoutUtil.addText(composite, 0, label, 100, SWT.NONE);
//		idText.setEditable(false);
//		idText.addFocusListener(this);
        
        // button composite
        buttonComposite = new Composite(composite, SWT.NONE);
        RowLayout layout = new RowLayout();
        layout.marginTop = 0;
        layout.marginBottom = 0;
        buttonComposite.setLayout(layout);
        buttonComposite.setLayoutData(FormLayoutUtil.createFormData(0, 50, 100));
        
        // documentation
        label = FormLayoutUtil.addLabel(composite, DISPLAY_DOCUMENTATION, buttonComposite, 0);
        docText= FormLayoutUtil.addText(composite, buttonComposite, label, 100, SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);
        ((FormData) docText.getLayoutData()).height= 50;
        // improve text wrap
        ((FormData) docText.getLayoutData()).width= composite.getBounds().width;
        docText.addFocusListener(this);
        
        this.lastControl = docText;
    }
    
    
    public void focusLost(FocusEvent e) {
    	if (e.getSource().equals(nameText)) {
    		setPropertyValue(idObject, pack.getIdObject_Name(), nullIfEmpty(nameText.getText()));
    	}
//        	if (e.getSource().equals(idText)) {
//        		setPropertyValue(idObject, pack.getIdObject_Id(), nullIfEmpty(idText.getText()));
//    		}
    	if (e.getSource().equals(docText)) {
    		setPropertyValue(idObject, pack.getIdObject_Documentation(), nullIfEmpty(docText.getText()));
		}
    }

    public void focusGained(FocusEvent e) {
    }

    public void widgetSelected(SelectionEvent e) {
    }

    public void widgetDefaultSelected(SelectionEvent e) {
    }
    

    /*
     * Some Helper Methods
     */
    
    /**
     * Add button with given label to ButtonComposite.
     */
    protected Button addButton(String text) {
        Button button = new Button(buttonComposite, SWT.NONE);
        button.setText(text);
        button.addSelectionListener(this);
        return button;
    }

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
    
    protected ExpressionComposite addExpressionComposite(Composite parent, Object top, Object left, Object right) {
    	ExpressionComposite composite= new ExpressionComposite(parent);
    	composite.setLayoutData(FormLayoutUtil.createFormData(top, left, right));
    	composite.setLayout(new GridLayout(2, false));
    	return composite;
    }
    
}