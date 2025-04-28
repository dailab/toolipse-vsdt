package de.dailab.common.gmf.properties;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

import de.dailab.common.gmf.Util;
import de.dailab.common.gmf.command.SetListPropertyValueCommand;
import de.dailab.common.gmf.command.SetPropertyValueCommand;
import de.dailab.common.swt.FormLayoutUtil;

/**
 * this is an abstract superclass for the custom "fancy" property sheets. it mainly provides simple access
 * to the property source (for synchronized setting of new property values) and extracts
 * the edit part and the eObject from the selection
 * 
 * what subclasses have to provide:
 *  1.: extend setInput and cast the eObject to the proper type required in the property section (optional)
 *  2.: implement internalRefresh() to set the content of text fields, the state of check boxed etc. according to the model (remove modify listeners first!)
 *  3.: implement createControls() to create the controls (widgets) for the property section
 *  4.: implement some way to update the property values, e.g. implementing a modify or a focus listener, and calling
 *      propSource.setPropertyValue("PropName", propText.getText()); with PropName being the name as displayed (!) in the property item provider
 *      (usually the feature name with capitalized first letter)
 *  5.: implement getObjectClass() and return the EClass for which this section is to be shown
 *      
 * Calling Complex Actions:
 * The property sheet can also hold buttons to provide actions similar to those in the context menu, e.g. to initialize some
 * property or to open a dialog. In this case the above way, using propSource.setPropertyvalue() can not be applied. Instead, do the same as
 * in a custom action and use 
 *      OperationHistoryFactory.getOperationHistory().execute([someAbstractTransactionCommand],new NullProgressMonitor(), null);
 * wrapped in the AbstractTransactionCommand you can set attribute values, call EOperation, open dialogs, etc.
 * 
 * @author kuester
 */
public abstract class AbstractGmfPropertySection extends AbstractPropertySection implements ITabbedPropertyConstants, IFilter {

	/**redefined standard label with; should match the length of the longest label*/
	public static final int STANDARD_LABEL_WIDTH= 120;
	
	/**the graphical edit part from the structural selection*/
    protected IGraphicalEditPart editPart;
    
    /**the eObject represented in the property sheet*/
    protected EObject eObject;

    @Override
    public final void refresh() {
    	// do refresh if this is still an adapter for the eObject and the eObject is still
    	// contained in some other eObject or in the resource
		if (eObject.eAdapters().contains(thisAdapter) && 
				(eObject.eContainer() != null || eObject.eResource() != null)) {
    		internalRefresh();
    	}
    }
    
    /**
     * This method has to be overwritten instead of refresh to avoid some complications
     * with the view being refreshed after the corresponding model element has already
     * been deleted from the model.
     */
    protected abstract void internalRefresh();

    public boolean select(Object toTest) {
    	if (toTest instanceof IGraphicalEditPart) {
			IGraphicalEditPart editPart= (IGraphicalEditPart) toTest;
			EObject eObject= (EObject) ((View)editPart.getModel()).getElement();
			if (eObject != null) {
				EClass clazz= getObjectClass();
				return eObject.eClass().equals(clazz) || eObject.eClass().getEAllSuperTypes().contains(clazz);
			}
		}	
		return false;
    }
    
    /**
     * This method is used in the select(Object) method
     * 
     * @return		EClass for which this tab should be shown 
     */
    protected abstract EClass getObjectClass();
    
    /**
     * gets the first element from the selection and assigns it to the editPart-field,
     * then extracts the eObject
     * this method can be extended with casting the eObject to the proper type and storing it
     * in another attribute
     */
    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (selection instanceof IStructuredSelection) {
	        Object input = ((IStructuredSelection) selection).getFirstElement();
	        if (input instanceof IGraphicalEditPart) {
	        	this.editPart= (IGraphicalEditPart) input;
	        	this.eObject= ((View)editPart.getModel()).getElement();
	        }
        }
        updateAdapter();
    }
    
    /**
	 * adapted from generated XYZPropertySection
	 * 
	 * @deprecated	because sometimes there seem to be some problems with GMF 2.1
     * 				Use setPropertyValue(EObject, EStructuralFeature, Object) instead.
	 */
    @Deprecated
	public IPropertySource getPropertySource(Object object) {
		AdapterFactory af= null;
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(object);
		if (editingDomain != null) {
			af= ((AdapterFactoryEditingDomain) editingDomain).getAdapterFactory();
		}
		if (af != null) {
			IItemPropertySource ips = (IItemPropertySource) af.adapt(object,
					IItemPropertySource.class);
			if (ips != null) {
				return new PropertySource(object, ips);
			}
		}
		// instead of returning null, return a "no-op" property source
		return new PropertySource(object, null) {
			@Override
			public void setPropertyValue(Object propertyId, Object value) {
				//do nothing
				System.err.println("No PropertySource found for Object " + object.toString());
			}
		};
	}

    /**
     * Sets the value of a given attribute of a given eObject. This is done by creating and
     * executing a command which uses the EMF reflective API. The EStructuralFeature must be a 
     * feature of the EObject or one of its super classes, and the value must be of the appropriate
     * type. 
     * 
     * @param object		Some EObject
     * @param feature		Some Feature of that EObject
     * @param value			New Value for that Feature
     */
    public static void setPropertyValue(final EObject object, final EStructuralFeature feature, final Object value) {
    	SetPropertyValueCommand command= new SetPropertyValueCommand(object, feature, value);
    	try {
        	OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);	
    	} catch (ExecutionException e) {
    		e.printStackTrace();
    	}
    }
    
    /**
     * Extends the list feature of a given model element by a given object. At this, the
     * list of the model element has to be initialized. The method creates and executes
     * executing a command which uses the EMF reflective API. The EStructuralFeature must be a 
     * feature of the EObject or one of its super classes, and the value must be of the appropriate
     * type. 
     * 
     * @param object		Some EObject
     * @param feature		An initialized list feature of that EObject
     * @param value			A Value by which the is to be extended
     * @param remove		remove value from list?
     */
    public static void setListPropertyValue(final EObject object, final EStructuralFeature feature, Object value, boolean remove) {
    	SetListPropertyValueCommand command= new SetListPropertyValueCommand(object, feature, value, remove);
    	
    	try {
        	OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);	
    	} catch (ExecutionException e) {
    		e.printStackTrace();
    	}
    }
	
	/**
	 * this is the adapter listening to changes on the model object, e.g. in case of undo / redo
	 */
    protected Adapter thisAdapter= new Adapter() {
    	Notifier target= null;
    	public Notifier getTarget() {
    		return target;
    	}
    	public boolean isAdapterForType(Object type) {
    		// TODO when to return true and false in isAdapterForType?
    		return false;
    	}
    	public void notifyChanged(Notification notification) {
    		refresh();
    	}
    	public void setTarget(Notifier newTarget) {
    		target= newTarget;
    	}
    };
    
    /**
     * if the adapter's current target is not the eObject, 
     * unlink the adapter from the target and link it to the eObject instead
     */
    private void updateAdapter() {
		if (eObject != thisAdapter.getTarget()) {
			unlinkAdapter();
			if (eObject != null) {
 	    		eObject.eAdapters().add(thisAdapter);
	    	}
		}
    }
    
    /**
     * unlink the adapter from it's current target
     */
    private void unlinkAdapter() {
    	if (thisAdapter.getTarget() != null) {
    		thisAdapter.getTarget().eAdapters().remove(thisAdapter);
    	}
    }
    
    @Override
    public void aboutToBeShown() {
    	super.aboutToBeShown();
    	updateAdapter();
    }
    
    @Override
    public void aboutToBeHidden() {
    	super.aboutToBeHidden();
    	unlinkAdapter();
    }
    
    @Override
    public void dispose() {
    	super.dispose();
    	unlinkAdapter();
    }
    
    /**
     * little helper method for initializing text fields, which may not have a null value,
     * with the values from the model, which might be null
     * 
     * @param s		some string
     * @return		the given string, or "" if the string is null
     */
    protected String nonNull(String s) {
    	return Util.nonNull(s);
    }
    
    /**
     * another little helper method for returning values from the text fields, returning null if the text field is empty
     * 
     * @param s		some string
     * @return		the string, or null if the string is empty
     */
    protected String nullIfEmpty(String s) {
    	return Util.nullIfEmpty(s);
    }

    
    /*
     * BELOW THIN LINE ARE ONLY METHODS FOR SIMPLYFYING THE LAYOUT OF THE PROPERTY SECTION
     * 
     * XXX NOTE: Moved to de.dailab.common.gmf.ui.FormLayoutUtil
     *           These methods are kept here for compatibility, but please change to the
     *           methods of the new class, and also do not modify these methods any further.
     */
	
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
    @Deprecated
	protected CLabel addLabel(Composite parent, String caption, Object top, Object left) {
		return FormLayoutUtil.addLabel(parent, caption, top, left);
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
    @Deprecated
    protected CLabel addLabel(Composite parent, String caption, Object top, Object left, int width) {
    	return FormLayoutUtil.addLabel(parent, caption, top, left, width);
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
    @Deprecated
    protected Text addText(Composite parent, Object top, Object left, Object right, int style) {
    	return FormLayoutUtil.addText(parent, top, left, right, style);
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
    @Deprecated
    protected Spinner addSpinner(Composite parent, Object top, Object left, Object right) {
    	return FormLayoutUtil.addSpinner(parent, top, left, right);
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
    @Deprecated
    protected Button addButton(Composite parent, String caption, int style, Object top, Object left, Object right) {
    	return FormLayoutUtil.addButton(parent, caption, style, top, left, right);
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
    @Deprecated
    protected Combo addCombo(Composite parent, int style, Object top, Object left, Object right) {
    	return FormLayoutUtil.addCombo(parent, style, top, left, right);
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
    @Deprecated
    protected DateTime addDateTime(Composite parent, Object top, Object left, Object right, int style) {
        return FormLayoutUtil.addDateTime(parent, top, left, right, style);
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
    @Deprecated
    protected Group addGroup(Composite parent, String caption, Object top, Object left, Object right) {
    	return FormLayoutUtil.addGroup(parent, caption, top, left, right);
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
    @Deprecated
    protected List addList(Composite parent, int style, Object top, Object left, Object right) {
    	return FormLayoutUtil.addList(parent, style, top, left, right);
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
    @Deprecated
    protected FormData createFormData(Object top, Object left, Object right) {
    	return FormLayoutUtil.createFormData(top, left, right);
    }
    
    /**
     * creates a form attachment from a given object which has to be either
     * a control or an integer. Otherwise null is returned.
     * 
     * @param object	some control or numerator
     * @return			new FormAttachment(object) or null
     */
    @Deprecated
    protected FormAttachment createFormAttachment(Object object, int offset) {
         return FormLayoutUtil.createFormAttachment(object, offset);
    }
    
}