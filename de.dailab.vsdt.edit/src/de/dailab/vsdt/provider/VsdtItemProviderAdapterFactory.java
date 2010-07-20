/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import de.dailab.vsdt.util.VsdtAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VsdtItemProviderAdapterFactory extends VsdtAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VsdtItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.BusinessProcessSystem} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusinessProcessSystemItemProvider businessProcessSystemItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.BusinessProcessSystem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBusinessProcessSystemAdapter() {
		if (businessProcessSystemItemProvider == null) {
			businessProcessSystemItemProvider = new BusinessProcessSystemItemProvider(this);
		}

		return businessProcessSystemItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.BusinessProcessDiagram} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusinessProcessDiagramItemProvider businessProcessDiagramItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.BusinessProcessDiagram}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBusinessProcessDiagramAdapter() {
		if (businessProcessDiagramItemProvider == null) {
			businessProcessDiagramItemProvider = new BusinessProcessDiagramItemProvider(this);
		}

		return businessProcessDiagramItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Start} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StartItemProvider startItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Start}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStartAdapter() {
		if (startItemProvider == null) {
			startItemProvider = new StartItemProvider(this);
		}

		return startItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Intermediate} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntermediateItemProvider intermediateItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Intermediate}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntermediateAdapter() {
		if (intermediateItemProvider == null) {
			intermediateItemProvider = new IntermediateItemProvider(this);
		}

		return intermediateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.End} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndItemProvider endItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.End}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEndAdapter() {
		if (endItemProvider == null) {
			endItemProvider = new EndItemProvider(this);
		}

		return endItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Activity} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityItemProvider activityItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Activity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createActivityAdapter() {
		if (activityItemProvider == null) {
			activityItemProvider = new ActivityItemProvider(this);
		}

		return activityItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.InputSet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputSetItemProvider inputSetItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.InputSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInputSetAdapter() {
		if (inputSetItemProvider == null) {
			inputSetItemProvider = new InputSetItemProvider(this);
		}

		return inputSetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.OutputSet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputSetItemProvider outputSetItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.OutputSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOutputSetAdapter() {
		if (outputSetItemProvider == null) {
			outputSetItemProvider = new OutputSetItemProvider(this);
		}

		return outputSetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.StandardLoopAttSet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardLoopAttSetItemProvider standardLoopAttSetItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.StandardLoopAttSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStandardLoopAttSetAdapter() {
		if (standardLoopAttSetItemProvider == null) {
			standardLoopAttSetItemProvider = new StandardLoopAttSetItemProvider(this);
		}

		return standardLoopAttSetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.MultiLoopAttSet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiLoopAttSetItemProvider multiLoopAttSetItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.MultiLoopAttSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMultiLoopAttSetAdapter() {
		if (multiLoopAttSetItemProvider == null) {
			multiLoopAttSetItemProvider = new MultiLoopAttSetItemProvider(this);
		}

		return multiLoopAttSetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Transaction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransactionItemProvider transactionItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Transaction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTransactionAdapter() {
		if (transactionItemProvider == null) {
			transactionItemProvider = new TransactionItemProvider(this);
		}

		return transactionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Gateway} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GatewayItemProvider gatewayItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Gateway}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGatewayAdapter() {
		if (gatewayItemProvider == null) {
			gatewayItemProvider = new GatewayItemProvider(this);
		}

		return gatewayItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Pool} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PoolItemProvider poolItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Pool}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPoolAdapter() {
		if (poolItemProvider == null) {
			poolItemProvider = new PoolItemProvider(this);
		}

		return poolItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Lane} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LaneItemProvider laneItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Lane}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLaneAdapter() {
		if (laneItemProvider == null) {
			laneItemProvider = new LaneItemProvider(this);
		}

		return laneItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.DataObject} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataObjectItemProvider dataObjectItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.DataObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataObjectAdapter() {
		if (dataObjectItemProvider == null) {
			dataObjectItemProvider = new DataObjectItemProvider(this);
		}

		return dataObjectItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.TextAnnotation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextAnnotationItemProvider textAnnotationItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.TextAnnotation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTextAnnotationAdapter() {
		if (textAnnotationItemProvider == null) {
			textAnnotationItemProvider = new TextAnnotationItemProvider(this);
		}

		return textAnnotationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Group} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupItemProvider groupItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Group}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createGroupAdapter() {
		if (groupItemProvider == null) {
			groupItemProvider = new GroupItemProvider(this);
		}

		return groupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.SequenceFlow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceFlowItemProvider sequenceFlowItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.SequenceFlow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSequenceFlowAdapter() {
		if (sequenceFlowItemProvider == null) {
			sequenceFlowItemProvider = new SequenceFlowItemProvider(this);
		}

		return sequenceFlowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.MessageFlow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageFlowItemProvider messageFlowItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.MessageFlow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMessageFlowAdapter() {
		if (messageFlowItemProvider == null) {
			messageFlowItemProvider = new MessageFlowItemProvider(this);
		}

		return messageFlowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Association} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationItemProvider associationItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Association}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAssociationAdapter() {
		if (associationItemProvider == null) {
			associationItemProvider = new AssociationItemProvider(this);
		}

		return associationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Participant} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParticipantItemProvider participantItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Participant}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParticipantAdapter() {
		if (participantItemProvider == null) {
			participantItemProvider = new ParticipantItemProvider(this);
		}

		return participantItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Message} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageItemProvider messageItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Message}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMessageAdapter() {
		if (messageItemProvider == null) {
			messageItemProvider = new MessageItemProvider(this);
		}

		return messageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Implementation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplementationItemProvider implementationItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Implementation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createImplementationAdapter() {
		if (implementationItemProvider == null) {
			implementationItemProvider = new ImplementationItemProvider(this);
		}

		return implementationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Assignment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignmentItemProvider assignmentItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Assignment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAssignmentAdapter() {
		if (assignmentItemProvider == null) {
			assignmentItemProvider = new AssignmentItemProvider(this);
		}

		return assignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Property} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyItemProvider propertyItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Property}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPropertyAdapter() {
		if (propertyItemProvider == null) {
			propertyItemProvider = new PropertyItemProvider(this);
		}

		return propertyItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.Expression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionItemProvider expressionItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExpressionAdapter() {
		if (expressionItemProvider == null) {
			expressionItemProvider = new ExpressionItemProvider(this);
		}

		return expressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link de.dailab.vsdt.DataType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeItemProvider dataTypeItemProvider;

	/**
	 * This creates an adapter for a {@link de.dailab.vsdt.DataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDataTypeAdapter() {
		if (dataTypeItemProvider == null) {
			dataTypeItemProvider = new DataTypeItemProvider(this);
		}

		return dataTypeItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (businessProcessSystemItemProvider != null) businessProcessSystemItemProvider.dispose();
		if (businessProcessDiagramItemProvider != null) businessProcessDiagramItemProvider.dispose();
		if (poolItemProvider != null) poolItemProvider.dispose();
		if (laneItemProvider != null) laneItemProvider.dispose();
		if (startItemProvider != null) startItemProvider.dispose();
		if (intermediateItemProvider != null) intermediateItemProvider.dispose();
		if (endItemProvider != null) endItemProvider.dispose();
		if (activityItemProvider != null) activityItemProvider.dispose();
		if (standardLoopAttSetItemProvider != null) standardLoopAttSetItemProvider.dispose();
		if (multiLoopAttSetItemProvider != null) multiLoopAttSetItemProvider.dispose();
		if (inputSetItemProvider != null) inputSetItemProvider.dispose();
		if (outputSetItemProvider != null) outputSetItemProvider.dispose();
		if (transactionItemProvider != null) transactionItemProvider.dispose();
		if (gatewayItemProvider != null) gatewayItemProvider.dispose();
		if (dataObjectItemProvider != null) dataObjectItemProvider.dispose();
		if (textAnnotationItemProvider != null) textAnnotationItemProvider.dispose();
		if (groupItemProvider != null) groupItemProvider.dispose();
		if (sequenceFlowItemProvider != null) sequenceFlowItemProvider.dispose();
		if (messageFlowItemProvider != null) messageFlowItemProvider.dispose();
		if (associationItemProvider != null) associationItemProvider.dispose();
		if (participantItemProvider != null) participantItemProvider.dispose();
		if (messageItemProvider != null) messageItemProvider.dispose();
		if (implementationItemProvider != null) implementationItemProvider.dispose();
		if (assignmentItemProvider != null) assignmentItemProvider.dispose();
		if (propertyItemProvider != null) propertyItemProvider.dispose();
		if (expressionItemProvider != null) expressionItemProvider.dispose();
		if (dataTypeItemProvider != null) dataTypeItemProvider.dispose();
	}

}
