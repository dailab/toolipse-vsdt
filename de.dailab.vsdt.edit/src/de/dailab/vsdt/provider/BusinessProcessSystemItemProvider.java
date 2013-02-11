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

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;

/**
 * This is the item provider adapter for a {@link de.dailab.vsdt.BusinessProcessSystem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BusinessProcessSystemItemProvider
	extends IdObjectItemProvider
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
	public BusinessProcessSystemItemProvider(AdapterFactory adapterFactory) {
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

			addVersionPropertyDescriptor(object);
			addAuthorPropertyDescriptor(object);
			addLanguagePropertyDescriptor(object);
			addExpressionLanguagePropertyDescriptor(object);
			addQueryLanguagePropertyDescriptor(object);
			addCreationDatePropertyDescriptor(object);
			addModificationDatePropertyDescriptor(object);
			addExecutablePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BusinessProcessSystem_version_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BusinessProcessSystem_version_feature", "_UI_BusinessProcessSystem_type"),
				 VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__VERSION,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Author feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAuthorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BusinessProcessSystem_author_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BusinessProcessSystem_author_feature", "_UI_BusinessProcessSystem_type"),
				 VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__AUTHOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Language feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLanguagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BusinessProcessSystem_language_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BusinessProcessSystem_language_feature", "_UI_BusinessProcessSystem_type"),
				 VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__LANGUAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Expression Language feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExpressionLanguagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BusinessProcessSystem_expressionLanguage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BusinessProcessSystem_expressionLanguage_feature", "_UI_BusinessProcessSystem_type"),
				 VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__EXPRESSION_LANGUAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Query Language feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addQueryLanguagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BusinessProcessSystem_queryLanguage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BusinessProcessSystem_queryLanguage_feature", "_UI_BusinessProcessSystem_type"),
				 VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__QUERY_LANGUAGE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Creation Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCreationDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BusinessProcessSystem_creationDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BusinessProcessSystem_creationDate_feature", "_UI_BusinessProcessSystem_type"),
				 VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__CREATION_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Modification Date feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addModificationDatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BusinessProcessSystem_modificationDate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BusinessProcessSystem_modificationDate_feature", "_UI_BusinessProcessSystem_type"),
				 VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__MODIFICATION_DATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Executable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExecutablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BusinessProcessSystem_executable_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BusinessProcessSystem_executable_feature", "_UI_BusinessProcessSystem_type"),
				 VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__EXECUTABLE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES);
			childrenFeatures.add(VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__PARTICIPANTS);
			childrenFeatures.add(VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__MESSAGE_CHANNELS);
			childrenFeatures.add(VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__SERVICES);
			childrenFeatures.add(VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__DATA_TYPES);
			childrenFeatures.add(VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__PARAMETERS);
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
	 * This returns BusinessProcessSystem.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BusinessProcessSystem"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((BusinessProcessSystem)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_BusinessProcessSystem_type") :
			getString("_UI_BusinessProcessSystem_type") + " " + label;
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

		switch (notification.getFeatureID(BusinessProcessSystem.class)) {
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__VERSION:
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__AUTHOR:
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__LANGUAGE:
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__EXPRESSION_LANGUAGE:
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__QUERY_LANGUAGE:
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__CREATION_DATE:
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__MODIFICATION_DATE:
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__EXECUTABLE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES:
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARTICIPANTS:
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__MESSAGE_CHANNELS:
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__SERVICES:
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__DATA_TYPES:
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM__PARAMETERS:
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
				(VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES,
				 VsdtFactory.eINSTANCE.createBusinessProcessDiagram()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__PARTICIPANTS,
				 VsdtFactory.eINSTANCE.createParticipant()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__MESSAGE_CHANNELS,
				 VsdtFactory.eINSTANCE.createMessageChannel()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__SERVICES,
				 VsdtFactory.eINSTANCE.createService()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__DATA_TYPES,
				 VsdtFactory.eINSTANCE.createDataType()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.BUSINESS_PROCESS_SYSTEM__PARAMETERS,
				 VsdtFactory.eINSTANCE.createParameter()));
	}

}
