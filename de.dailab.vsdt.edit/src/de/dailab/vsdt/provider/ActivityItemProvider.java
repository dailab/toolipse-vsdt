/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.provider;


import java.util.ArrayList;
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

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;

/**
 * This is the item provider adapter for a {@link de.dailab.vsdt.Activity} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ActivityItemProvider
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
	public ActivityItemProvider(AdapterFactory adapterFactory) {
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
			addActivityTypePropertyDescriptor(object);
			addInMessagePropertyDescriptor(object);
			addOutMessagePropertyDescriptor(object);
			addImplementationPropertyDescriptor(object);
			addInstantiatePropertyDescriptor(object);
			addPerformersPropertyDescriptor(object);
			addScriptPropertyDescriptor(object);
			addActivityRefPropertyDescriptor(object);
			addDiagramRefPropertyDescriptor(object);
			addProcessRefPropertyDescriptor(object);
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
	 * This adds a property descriptor for the Activity Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addActivityTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Activity_activityType_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Activity_activityType_feature", "_UI_Activity_type"),
				 VsdtPackage.Literals.ACTIVITY__ACTIVITY_TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the In Message feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInMessagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Activity_inMessage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Activity_inMessage_feature", "_UI_Activity_type"),
				 VsdtPackage.Literals.ACTIVITY__IN_MESSAGE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Out Message feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOutMessagePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Activity_outMessage_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Activity_outMessage_feature", "_UI_Activity_type"),
				 VsdtPackage.Literals.ACTIVITY__OUT_MESSAGE,
				 true,
				 false,
				 true,
				 null,
				 null,
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
				 getString("_UI_Activity_implementation_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Activity_implementation_feature", "_UI_Activity_type"),
				 VsdtPackage.Literals.ACTIVITY__IMPLEMENTATION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Instantiate feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInstantiatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Activity_instantiate_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Activity_instantiate_feature", "_UI_Activity_type"),
				 VsdtPackage.Literals.ACTIVITY__INSTANTIATE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Performers feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPerformersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Activity_performers_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Activity_performers_feature", "_UI_Activity_type"),
				 VsdtPackage.Literals.ACTIVITY__PERFORMERS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Script feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addScriptPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Activity_script_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Activity_script_feature", "_UI_Activity_type"),
				 VsdtPackage.Literals.ACTIVITY__SCRIPT,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Sub Process Ref feature.
	 * <!-- begin-user-doc -->
	 * prevent self-reference
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addActivityRefPropertyDescriptor(Object object) {
		ItemPropertyDescriptor propertyDescriptor= new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				 getString("_UI_Activity_activityRef_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Activity_activityRef_feature", "_UI_Activity_type"),
				 VsdtPackage.Literals.ACTIVITY__ACTIVITY_REF,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_ActivityTypeAttributesPropertyCategory"),
				 null) {
			@Override
			protected Collection<?> getComboBoxObjects(Object object) {
				Collection<?> collection= super.getComboBoxObjects(object);
				if (collection.contains(object)) {
					collection.remove(object);
				}
				return collection;
			}
		};
		itemPropertyDescriptors.add(propertyDescriptor);
	}
	
	/**
	 * This adds a property descriptor for the Diagram Ref feature.
	 * <!-- begin-user-doc -->
	 * search the workspace for other BPMN diagrams and list the result
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addDiagramRefPropertyDescriptor(Object object) {
		ItemPropertyDescriptor propertyDescriptor= new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				 getString("_UI_Activity_diagramRef_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Activity_diagramRef_feature", "_UI_Activity_type"),
				 VsdtPackage.Literals.ACTIVITY__DIAGRAM_REF,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_SubprocessAttributesPropertyCategory"),
				 null) {
			@Override
			protected Collection<?> getComboBoxObjects(Object object) {
				return super.getComboBoxObjects(object);
				// with VSDT 1.2, no other files have to be included anymore
//				Collection<BusinessProcessDiagram> collection= new ArrayList<BusinessProcessDiagram>();
//				Resource thisResource= ((Activity) object).getPool().getParentDiagram().eResource();
//				List<Resource> allResources= ResourceFinder.getResources(thisResource,"vsdt");
//				
//				for (Resource resource : allResources) {
//					for (EObject element : resource.getContents()) {
//						if (element instanceof BusinessProcessDiagram) {
//							BusinessProcessDiagram bpd = (BusinessProcessDiagram) element;
//							collection.add(bpd);
//						}
//					}
//				}
//				
//				return collection;
			}
		};
		itemPropertyDescriptors.add(propertyDescriptor);
	}
	
	/**
	 * This adds a property descriptor for the Process Ref feature.
	 * <!-- begin-user-doc -->
	 * filter choices, so that only processes of the given diagram can be selected
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected void addProcessRefPropertyDescriptor(Object object) {
		ItemPropertyDescriptor propertyDescriptor= new ItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				getResourceLocator(),
				 getString("_UI_Activity_processRef_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Activity_processRef_feature", "_UI_Activity_type"),
				 VsdtPackage.Literals.ACTIVITY__PROCESS_REF,
				 true,
				 false,
				 true,
				 null,
				 getString("_UI_SubprocessAttributesPropertyCategory"),
				 null){
			@Override
			protected Collection<?> getComboBoxObjects(Object object) {
				Activity activity= (Activity) object;
				Collection<Pool> collection= new ArrayList<Pool>();
				//null-value for de-selecting the process
				collection.add(null);
				//if a diagram reference is set, add the diagram's processes to the list 
				if (activity.getDiagramRef() != null) {
					BusinessProcessDiagram bpd= activity.getDiagramRef();
					for (Pool pool : bpd.getPools()) {
						if (pool.getParticipant() == activity.getPool().getParticipant()) {
							collection.add(pool);
						}
					}
				}
				return collection;
			}
		};
		itemPropertyDescriptors.add(propertyDescriptor);
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
			childrenFeatures.add(VsdtPackage.Literals.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS);
			childrenFeatures.add(VsdtPackage.Literals.ACTIVITY__INPUT_SETS);
			childrenFeatures.add(VsdtPackage.Literals.ACTIVITY__OUTPUT_SETS);
			childrenFeatures.add(VsdtPackage.Literals.ACTIVITY__IO_RULES);
			childrenFeatures.add(VsdtPackage.Literals.ACTIVITY__LOOP_ATTRIBUTES);
			childrenFeatures.add(VsdtPackage.Literals.ACTIVITY__BOUNDARY_EVENTS);
			childrenFeatures.add(VsdtPackage.Literals.ACTIVITY__TRANSACTION);
			childrenFeatures.add(VsdtPackage.Literals.ACTIVITY__INPUT_PROPERTY_MAPS);
			childrenFeatures.add(VsdtPackage.Literals.ACTIVITY__OUTPUT_PROPERTY_MAPS);
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
	 * This returns Activity.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Activity"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Activity)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Activity_type") :
			getString("_UI_Activity_type") + " " + label;
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

		switch (notification.getFeatureID(Activity.class)) {
			case VsdtPackage.ACTIVITY__AD_HOC:
			case VsdtPackage.ACTIVITY__ACTIVITY_TYPE:
			case VsdtPackage.ACTIVITY__INSTANTIATE:
			case VsdtPackage.ACTIVITY__PERFORMERS:
			case VsdtPackage.ACTIVITY__SCRIPT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case VsdtPackage.ACTIVITY__AD_HOC_COMPLETION_CONDITION:
			case VsdtPackage.ACTIVITY__PROPERTIES:
			case VsdtPackage.ACTIVITY__CONTAINED_FLOW_OBJECTS:
			case VsdtPackage.ACTIVITY__INPUT_SETS:
			case VsdtPackage.ACTIVITY__OUTPUT_SETS:
			case VsdtPackage.ACTIVITY__IO_RULES:
			case VsdtPackage.ACTIVITY__LOOP_ATTRIBUTES:
			case VsdtPackage.ACTIVITY__BOUNDARY_EVENTS:
			case VsdtPackage.ACTIVITY__TRANSACTION:
			case VsdtPackage.ACTIVITY__INPUT_PROPERTY_MAPS:
			case VsdtPackage.ACTIVITY__OUTPUT_PROPERTY_MAPS:
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
				(VsdtPackage.Literals.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS,
				 VsdtFactory.eINSTANCE.createStart()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS,
				 VsdtFactory.eINSTANCE.createIntermediate()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS,
				 VsdtFactory.eINSTANCE.createEnd()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS,
				 VsdtFactory.eINSTANCE.createActivity()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS,
				 VsdtFactory.eINSTANCE.createGateway()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.ACTIVITY__INPUT_SETS,
				 VsdtFactory.eINSTANCE.createInputSet()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.ACTIVITY__OUTPUT_SETS,
				 VsdtFactory.eINSTANCE.createOutputSet()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.ACTIVITY__IO_RULES,
				 VsdtFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.ACTIVITY__LOOP_ATTRIBUTES,
				 VsdtFactory.eINSTANCE.createStandardLoopAttSet()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.ACTIVITY__LOOP_ATTRIBUTES,
				 VsdtFactory.eINSTANCE.createMultiLoopAttSet()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.ACTIVITY__BOUNDARY_EVENTS,
				 VsdtFactory.eINSTANCE.createIntermediate()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.ACTIVITY__TRANSACTION,
				 VsdtFactory.eINSTANCE.createTransaction()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.ACTIVITY__INPUT_PROPERTY_MAPS,
				 VsdtFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(VsdtPackage.Literals.ACTIVITY__OUTPUT_PROPERTY_MAPS,
				 VsdtFactory.eINSTANCE.createExpression()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == VsdtPackage.Literals.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION ||
			childFeature == VsdtPackage.Literals.ACTIVITY__IO_RULES ||
			childFeature == VsdtPackage.Literals.ACTIVITY__INPUT_PROPERTY_MAPS ||
			childFeature == VsdtPackage.Literals.ACTIVITY__OUTPUT_PROPERTY_MAPS ||
			childFeature == VsdtPackage.Literals.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS ||
			childFeature == VsdtPackage.Literals.ACTIVITY__BOUNDARY_EVENTS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
