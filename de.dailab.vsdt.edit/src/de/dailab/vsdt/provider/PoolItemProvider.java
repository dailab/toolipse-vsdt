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
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.dailab.vsdt.Pool;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;

/**
 * This is the item provider adapter for a {@link de.dailab.vsdt.Pool} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PoolItemProvider
	extends NodeItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PoolItemProvider(AdapterFactory adapterFactory) {
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

			addAdHocPropertyDescriptor(object);
			addAdHocCompletionConditionPropertyDescriptor(object);
			addParticipantPropertyDescriptor(object);
			addBoundaryVisiblePropertyDescriptor(object);
			addProcessTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Ad Hoc feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAdHocPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractProcess_adHoc_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractProcess_adHoc_feature", "_UI_AbstractProcess_type"),
				 VsdtPackage.Literals.ABSTRACT_PROCESS__AD_HOC,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_ProcessPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Ad Hoc Completion Condition feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAdHocCompletionConditionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AbstractProcess_adHocCompletionCondition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AbstractProcess_adHocCompletionCondition_feature", "_UI_AbstractProcess_type"),
				 VsdtPackage.Literals.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION,
				 false,
				 false,
				 false,
				 null,
				 getString("_UI_ProcessPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Participant feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParticipantPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Pool_participant_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Pool_participant_feature", "_UI_Pool_type"),
				 VsdtPackage.Literals.POOL__PARTICIPANT,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_PoolPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Boundary Visible feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBoundaryVisiblePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Pool_boundaryVisible_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Pool_boundaryVisible_feature", "_UI_Pool_type"),
				 VsdtPackage.Literals.POOL__BOUNDARY_VISIBLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 getString("_UI_PoolPropertyCategory"),
				 null));
	}

	/**
	 * This adds a property descriptor for the Process Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProcessTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Pool_processType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Pool_processType_feature", "_UI_Pool_type"),
				 VsdtPackage.Literals.POOL__PROCESS_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
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
			childrenFeatures.add(VsdtPackage.Literals.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION);
			childrenFeatures.add(VsdtPackage.Literals.ABSTRACT_PROCESS__PROPERTIES);
			childrenFeatures.add(VsdtPackage.Literals.POOL__LANES);
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
	 * This returns Pool.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Pool"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Pool)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Pool_type") :
			getString("_UI_Pool_type") + " " + label;
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

		switch (notification.getFeatureID(Pool.class)) {
			case VsdtPackage.POOL__AD_HOC:
			case VsdtPackage.POOL__BOUNDARY_VISIBLE:
			case VsdtPackage.POOL__PROCESS_TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case VsdtPackage.POOL__AD_HOC_COMPLETION_CONDITION:
			case VsdtPackage.POOL__PROPERTIES:
			case VsdtPackage.POOL__LANES:
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
				(VsdtPackage.Literals.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION,
				 VsdtFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.ABSTRACT_PROCESS__PROPERTIES,
				 VsdtFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.POOL__LANES,
				 VsdtFactory.eINSTANCE.createLane()));
	}

}
