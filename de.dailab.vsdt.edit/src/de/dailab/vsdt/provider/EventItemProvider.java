/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.dailab.vsdt.Event;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;


/**
 * This is the item provider adapter for a {@link de.dailab.vsdt.Event} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EventItemProvider
	extends FlowObjectItemProvider
	implements	
		IEditingDomainItemProvider,	
		IStructuredItemContentProvider,	
		ITreeItemContentProvider,	
		IItemLabelProvider,	
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addTriggerPropertyDescriptor(object);
			addMessagePropertyDescriptor(object);
			addImplementationPropertyDescriptor(object);
			addTimeDatePropertyDescriptor(object);
			addTimeCyclePropertyDescriptor(object);
			addRuleNamePropertyDescriptor(object);
			addRuleExpressionPropertyDescriptor(object);
			addErrorCodePropertyDescriptor(object);
			addActivityPropertyDescriptor(object);
			addSignalPropertyDescriptor(object);
			addLinkedToPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Trigger feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTriggerPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_trigger_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_trigger_feature", "_UI_Event_type"),
				 VsdtPackage.Literals.EVENT__TRIGGER,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Message feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMessagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_message_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_message_feature", "_UI_Event_type"),
				 VsdtPackage.Literals.EVENT__MESSAGE,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_TriggerAttributesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Implementation feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImplementationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_implementation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_implementation_feature", "_UI_Event_type"),
				 VsdtPackage.Literals.EVENT__IMPLEMENTATION,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_TriggerAttributesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Time Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimeDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_timeDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_timeDate_feature", "_UI_Event_type"),
				 VsdtPackage.Literals.EVENT__TIME_DATE,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_TriggerAttributesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Time Cycle feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimeCyclePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_timeCycle_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_timeCycle_feature", "_UI_Event_type"),
				 VsdtPackage.Literals.EVENT__TIME_CYCLE,
				 true,
				 false,
				 false,
				 null,
				 getString("_UI_TriggerAttributesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Rule Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRuleNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_ruleName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_ruleName_feature", "_UI_Event_type"),
				 VsdtPackage.Literals.EVENT__RULE_NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_TriggerAttributesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Rule Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRuleExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_ruleExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_ruleExpression_feature", "_UI_Event_type"),
				 VsdtPackage.Literals.EVENT__RULE_EXPRESSION,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_TriggerAttributesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Error Code feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addErrorCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_errorCode_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_errorCode_feature", "_UI_Event_type"),
				 VsdtPackage.Literals.EVENT__ERROR_CODE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 getString("_UI_TriggerAttributesPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Activity feature.
	 * <!-- begin-user-doc -->
	 * filter choices
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addActivityPropertyDescriptor(Object object) {
		ItemPropertyDescriptor propertyDescriptor= new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_activity_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_activity_feature", "_UI_Event_type"),
				 VsdtPackage.Literals.EVENT__ACTIVITY,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_TriggerAttributesPropertyCategory"),
				 null) {
				@Override
				protected Collection<?> getComboBoxObjects(Object object) {
					Collection<?> collection= super.getComboBoxObjects(object);
					Event event= (Event) object;
					if (event.getParent() != null) {
						collection.retainAll(event.getParent().getContainedFlowObjects());
					}
					if (event instanceof Intermediate && ((Intermediate)event).getAttachedTo() != null){
						Intermediate intermediate= (Intermediate) event;
						if (intermediate.getAttachedTo() != null) {
							collection.retainAll(intermediate.getAttachedTo().getParent().getContainedFlowObjects());
							collection.remove(intermediate.getAttachedTo());
						}
					}
					collection.add(null);
					return collection;
				}
			};
		itemPropertyDescriptors.add(propertyDescriptor);
	}

	/**
	 * This adds a property descriptor for the Signal feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSignalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_signal_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_signal_feature", "_UI_Event_type"),
				 VsdtPackage.Literals.EVENT__SIGNAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Linked To feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLinkedToPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Event_linkedTo_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Event_linkedTo_feature", "_UI_Event_type"),
				 VsdtPackage.Literals.EVENT__LINKED_TO,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(VsdtPackage.Literals.EVENT__RULE_EXPRESSION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Event)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Event_type") :
			getString("_UI_Event_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Event.class)) {
			case VsdtPackage.EVENT__TRIGGER:
			case VsdtPackage.EVENT__TIME_DATE:
			case VsdtPackage.EVENT__TIME_CYCLE:
			case VsdtPackage.EVENT__RULE_NAME:
			case VsdtPackage.EVENT__ERROR_CODE:
			case VsdtPackage.EVENT__SIGNAL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case VsdtPackage.EVENT__RULE_EXPRESSION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.EVENT__RULE_EXPRESSION,
				 VsdtFactory.eINSTANCE.createExpression()));
	}

}
