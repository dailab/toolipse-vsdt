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
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;

/**
 * This is the item provider adapter for a {@link de.dailab.vsdt.BusinessProcessDiagram} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BusinessProcessDiagramItemProvider
	extends IdObjectItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcessDiagramItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(VsdtPackage.Literals.BUSINESS_PROCESS_DIAGRAM__POOLS);
			childrenFeatures.add(VsdtPackage.Literals.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS);
			childrenFeatures.add(VsdtPackage.Literals.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS);
			childrenFeatures.add(VsdtPackage.Literals.BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS);
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
	 * This returns BusinessProcessDiagram.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BusinessProcessDiagram"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * print filename, too
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((BusinessProcessDiagram)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_BusinessProcessDiagram_type") :
			getString("_UI_BusinessProcessDiagram_type") + " " + label;
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

		switch (notification.getFeatureID(BusinessProcessDiagram.class)) {
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__POOLS:
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS:
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS:
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS:
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
				(VsdtPackage.Literals.BUSINESS_PROCESS_DIAGRAM__POOLS,
				 VsdtFactory.eINSTANCE.createPool()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS,
				 VsdtFactory.eINSTANCE.createDataObject()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS,
				 VsdtFactory.eINSTANCE.createTextAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS,
				 VsdtFactory.eINSTANCE.createGroup()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS,
				 VsdtFactory.eINSTANCE.createSequenceFlow()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS,
				 VsdtFactory.eINSTANCE.createMessageFlow()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS,
				 VsdtFactory.eINSTANCE.createAssociation()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS,
				 VsdtFactory.eINSTANCE.createParticipant()));
	}

}
