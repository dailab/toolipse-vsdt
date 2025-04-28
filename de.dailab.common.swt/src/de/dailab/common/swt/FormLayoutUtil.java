package de.dailab.common.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * This Utility-Class can be used in various dialogs, wizards and property sheets for
 * easily creating uniformly laid out user interfaces.
 * 
 * Note: Currently this class is based on the TabbedPropertySheetWidgetFactory, but this
 * should not be a problem when using this class for other kinds of dialogs, except
 * one should set the background-color of the FlatFormComposite to null.
 * 
 * TODO: Use something more general than TabbedPropertySheetWidgetFactory
 * 
 * @author kuester
 */
public class FormLayoutUtil {

	/**redefined standard label with; should match the length of the longest label*/
	public static final int STANDARD_LABEL_WIDTH= 120;

	private static TabbedPropertySheetWidgetFactory widgetFactory;
	
	public static TabbedPropertySheetWidgetFactory getWidgetFactory() {
		if (widgetFactory == null) {
			widgetFactory= new TabbedPropertySheetWidgetFactory();
		}
		return widgetFactory;
	}
	
	public static Composite createFlatFormComposite(Composite parent) {
		return getWidgetFactory().createFlatFormComposite(parent);
	}
	
	/**
	 * Provides a simple, line-efficient way to add a new Text to a form. The label is created with
	 * standard-label-width.
	 * 
	 * @param parent		the parent composite
	 * @param caption		the label's caption
	 * @param top			the control just above the label, or null, if the label is the top-most control
	 * @param left			position of the left side of the label as percentage of the form or another control
	 * @return				the newly created label, already inserted into the parent composite
	 */
	public static CLabel addLabel(Composite parent, String caption, Object top, Object left) {
		return addLabel(parent, caption, top, left, STANDARD_LABEL_WIDTH);
	}
	
	/**
	 * Provides a simple, line-efficient way to add a new Text to a form. The label with can be -1 which will
	 * mean that the label can choose it's preferred width
	 *
	 * @param parent		the parent composite
	 * @param caption		the label's caption
	 * @param top			the control just above the label, or null, if the label is the top-most control
	 * @param left			position of the left side of the label as percentage of the form or another control
	 * @param width			the label's width
	 * @return				the newly created label, already inserted into the parent composite
	 */
	public static CLabel addLabel(Composite parent, String caption, Object top, Object left, int width) {
    	CLabel label = getWidgetFactory().createCLabel(parent, caption);
        FormData data = new FormData();
        data.left = createFormAttachment(left,0);
        if (width != -1) {
        	data.right = createFormAttachment(left,width);
        }
        data.top = createFormAttachment(top, 0);
        label.setLayoutData(data);
        return label;
    }
    
    /**
	 * Provides a simple, line-efficient way to add a new Text to a form. The Text is positioned just right
	 * of a given label and stretches a given amount
	 *
	 * @param parent		the parent composite
     * @param top			control atop of the button or 0 for top position
     * @param left			control left of the button form width percentage or null
     * @param right			control right of the button form width percentage or null
	 * @param style			some SWT-style, e.g. MULTI for text areas, or 0 
	 * @return				the newly created text, already inserted into the parent composite
	 */
	public static Text addText(Composite parent, Object top, Object left, Object right, int style) {
    	Text text = getWidgetFactory().createText(parent, "", /*SWT.BORDER |*/ style ); //$NON-NLS-1$
        text.setLayoutData(createFormData(top, left, right));
    	return text;
    }
    
    /**
     * Provides a simple, line-efficient way to add a new Spinner to a form
     * 
     * @param parent		the parent composite
     * @param top			control atop of the button or 0 for top position
     * @param left			control left of the button form width percentage or null
     * @param right			control right of the button form width percentage or null
     * @return				new spinner
     */
	public static Spinner addSpinner(Composite parent, Object top, Object left, Object right) {
    	Spinner spinner= new Spinner(parent, SWT.BORDER);
    	spinner.setLayoutData(createFormData(top, left, right));
    	return spinner;
    }
    
    /**
     * Provides a simple, line-efficient way to add a new Button to a form. The Button is given
     * a caption and it can be positioned below, left and right of any other control or form percentage.
     * Note that at least one of left or right should not be null. 
	 *
     * @param parent		the parent composite
     * @param caption		the button's caption
     * @param style			the button style (for checkBoxes, radio buttons etc.)
     * @param top			control atop of the button or 0 for top position
     * @param left			control left of the button, form width percentage or null
     * @param right			control right of the button, form width percentage or null
     * @return				new button
     */
	public static Button addButton(Composite parent, String caption, int style, Object top, Object left, Object right) {
    	Button button= getWidgetFactory().createButton(parent, caption, style);
        button.setLayoutData(createFormData(top, left, right));
        return button;
    }
    
    /**
     * 
     * @param parent		the parent composite
     * @param style			the comboBox style, e.g. read_only, simple
     * @param top			control atop of the comboBox or 0 for top position
     * @param left			control left of the comboBox, form width percentage or null
     * @param right			control right of the comboBox, form width percentage or null
     * @return				new combo box
     */
	public static Combo addCombo(Composite parent, int style, Object top, Object left, Object right) {
    	Combo combo= new Combo(parent,style);
    	combo.setLayoutData(createFormData(top, left, right));
    	return combo;
    }
    
    /**
     * Provides a simple, line-efficient way to add a new DateTime to a form. Style can be either one of
     * DATE, TIME or CALENDAR and SHORT, MEDIUM or LONG
	 *
     * @param parent		the parent composite
     * @param top			control atop of the DateTime or 0 for top position
     * @param left			control left of the DateTime form width percentage or null
     * @param right			control right of the DateTime form width percentage or null
     * @param style			style of the DateTime control
     * @return
     */
	public static DateTime addDateTime(Composite parent, Object top, Object left, Object right, int style) {
    	DateTime date= new DateTime(parent, style);
        date.setLayoutData(createFormData(top, left, right));
        return date;
    }

    /**
     * Provides a simple, line-efficient way to add a new Group to a form.
	 *
     * @param parent		the parent composite
     * @param caption		the group's caption
     * @param top			control atop of the group or 0 for top position
     * @param left			control left of the group's form width percentage or null
     * @param right			control right of the group's form width percentage or null
     * @return
     */
	public static Group addGroup(Composite parent, String caption, Object top, Object left, Object right) {
    	Group group= getWidgetFactory().createGroup(parent, caption);
    	group.setLayout(new FormLayout());
    	group.setLayoutData(createFormData(top, left, right));
    	return group;
    }
    
    /**
     * Provides a simple, line-efficient way to add a new List to a form.
	 *
     * @param parent		the parent composite
     * @param style			list style, e.g. single or multi
     * @param top			control atop of the List or 0 for top position
     * @param left			control left of the List's form width percentage or null
     * @param right			control right of the List's form width percentage or null
     * @return
     */
	public static List addList(Composite parent, int style, Object top, Object left, Object right) {
    	List list= getWidgetFactory().createList(parent, style);
    	list.setLayoutData(createFormData(top, left, right));
    	return list;
    }
    
    /**
     * Create a standard form data object from a given set of top, left an right objects.
     * These objects can be a number, i.e. the percentage of the form's width/height,
     * another object, or null, for not attachment at this side
     * 
     * @param top		top attachment
     * @param left		left attachment
     * @param right		right attachment
     * @return
     */
	public static FormData createFormData(Object top, Object left, Object right) {
    	FormData data= new FormData();
    	data.top= createFormAttachment(top,0);
    	data.left= createFormAttachment(left,0);
    	data.right= createFormAttachment(right,0);
    	return data;
    }
    
    /**
     * creates a form attachment from a given object which has to be either
     * a control or an integer. Otherwise null is returned.
     * 
     * @param object	some control or numerator
     * @return			new FormAttachment(object) or null
     */
	public static FormAttachment createFormAttachment(Object object, int offset) {
    	 if (object instanceof Integer) {
             return new FormAttachment((Integer) object, offset);
         }
         if (object instanceof Control) {
        	 return new FormAttachment((Control) object, offset);
         }
         return null;
    }
	

    /**
     * Comfortably creates a FormData object which can be used as LayoutData.
     * Four parameters have to be specified matching the four attachment sides
     * of the widget. Null values are accepted as well, which enables a flexible
     * usage of this method. Valid parameter values are either widgets or integers
     * determining the percentage adjustment. 
     * 
     * @author 			luetze
     * @param left		Left margin
     * @param right		Right margin
     * @param top		Top margin
     * @param bottm		Bottom margin
     * @return 			The new FormData object which can be used as LayoutSetting
     * 
     */
	public static FormData createFormData(Object left, Object right, Object top, Object bottom) {
    	FormData data = new FormData();
    	if (left != null) {
    		data.left = FormLayoutUtil.createFormAttachment(left, 0);
    	}
    	if (right != null) {
    		data.right = FormLayoutUtil.createFormAttachment(right, 0);
    	}
    	if (top != null) {
    		data.top = FormLayoutUtil.createFormAttachment(top, 0);
    	}
    	if (bottom != null) {
    		data.bottom = FormLayoutUtil.createFormAttachment(bottom, 0);
    	}
    	return data;
    }

    /**
     * This Method is a bit unconventional. You can use it to create a FormData object
     * by specifying each side including a shift. While the side can be either a control,
     * a percentage value or null if you don't want to use a specification, the shift is
     * the integer value of the shifted pixels.
     * 
     * @author luetze
     * @param l			The left border 
     * @param oL		Shift from the left border
     * @param r			The right border
     * @param oR		Shift from the right border
     * @param t			The top border
     * @param oT		Shift from the top border
     * @param b			The bottom Border
     * @param oB		Shift from the bottom border
     * @return			The new FormData object which can be used as LayoutSetting
     */
	public static FormData createFormData(Object l, int oL, Object r, int oR, Object t, int oT, Object b, int oB) {
		FormData data = new FormData();
    	if (l != null) {
    		data.left = FormLayoutUtil.createFormAttachment(l, oL);
    	}
    	if (r != null) {
    		data.right = FormLayoutUtil.createFormAttachment(r, oR);
    	}
    	if (t != null) {
    		data.top = FormLayoutUtil.createFormAttachment(t, oT);
    	}
    	if (b != null) {
    		data.bottom = FormLayoutUtil.createFormAttachment(b, oB);
    	}
    	return data;
	}
	
}
