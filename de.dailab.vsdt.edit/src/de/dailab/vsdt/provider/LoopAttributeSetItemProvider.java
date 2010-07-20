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
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import de.dailab.common.gmf.ExpandableItemProviderAdapter;

/**
 * This is the item provider adapter for a {@link de.dailab.vsdt.LoopAttributeSet} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class LoopAttributeSetItemProvider
	extends ExpandableItemProviderAdapter
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
	public LoopAttributeSetItemProvider(AdapterFactory adapterFactory) {
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

//			addLoopCounterPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

//	/**
//	 * This adds a property descriptor for the Loop Counter feature.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	protected void addLoopCounterPropertyDescriptor(Object object) {
//		itemPropertyDescriptors.add
//			(createItemPropertyDescriptor
//				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
//				 getResourceLocator(),
//				 getString("_UI_LoopAttributeSet_loopCounter_feature"),
//				 getString("_UI_PropertyDescriptor_description", "_UI_LoopAttributeSet_loopCounter_feature", "_UI_LoopAttributeSet_type"),
//				 VsdtPackage.Literals.LOOP_ATTRIBUTE_SET__LOOP_COUNTER,
//				 true,
//				 false,
//				 false,
//				 ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE,
//				 null,
//				 null));
//	}

//	/**
//	 * This returns the label text for the adapted class.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated
//	 */
//	@Override
//	public String getText(Object object) {
//		LoopAttributeSet loopAttributeSet = (LoopAttributeSet)object;
//		return getString("_UI_LoopAttributeSet_type") + " " + loopAttributeSet.getLoopCounter();
//	}

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

//		switch (notification.getFeatureID(LoopAttributeSet.class)) {
//			case VsdtPackage.LOOP_ATTRIBUTE_SET__LOOP_COUNTER:
//				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
//				return;
//		}
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
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return VsdtEditPlugin.INSTANCE;
	}

}
