/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.AbstractProcess;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.Association;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.DataObject;
import de.dailab.vsdt.DirectionType;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.InputSet;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.LoopAttributeSet;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.OutputSet;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Transaction;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#isAdHoc <em>Ad Hoc</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getContainedFlowObjects <em>Contained Flow Objects</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getInputSets <em>Input Sets</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getOutputSets <em>Output Sets</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getIORules <em>IO Rules</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getStartQuantity <em>Start Quantity</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getLoopAttributes <em>Loop Attributes</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getBoundaryEvents <em>Boundary Events</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getActivityType <em>Activity Type</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getInMessage <em>In Message</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getOutMessage <em>Out Message</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#isInstantiate <em>Instantiate</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getPerformers <em>Performers</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getScript <em>Script</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getActivityRef <em>Activity Ref</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getTransaction <em>Transaction</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getDiagramRef <em>Diagram Ref</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getProcessRef <em>Process Ref</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getInputPropertyMaps <em>Input Property Maps</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ActivityImpl#getOutputPropertyMaps <em>Output Property Maps</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActivityImpl extends FlowObjectImpl implements Activity {
	/**
	 * The default value of the '{@link #isAdHoc() <em>Ad Hoc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAdHoc()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AD_HOC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAdHoc() <em>Ad Hoc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAdHoc()
	 * @generated
	 * @ordered
	 */
	protected boolean adHoc = AD_HOC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAdHocCompletionCondition() <em>Ad Hoc Completion Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdHocCompletionCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression adHocCompletionCondition;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

	/**
	 * The cached value of the '{@link #getContainedFlowObjects() <em>Contained Flow Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedFlowObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowObject> containedFlowObjects;

	/**
	 * The cached value of the '{@link #getInputSets() <em>Input Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSets()
	 * @generated
	 * @ordered
	 */
	protected EList<InputSet> inputSets;

	/**
	 * The cached value of the '{@link #getOutputSets() <em>Output Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputSets()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputSet> outputSets;

	/**
	 * The cached value of the '{@link #getIORules() <em>IO Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIORules()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> ioRules;

	/**
	 * The default value of the '{@link #getStartQuantity() <em>Start Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartQuantity()
	 * @generated
	 * @ordered
	 */
	protected static final int START_QUANTITY_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getStartQuantity() <em>Start Quantity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartQuantity()
	 * @generated
	 * @ordered
	 */
	protected int startQuantity = START_QUANTITY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLoopAttributes() <em>Loop Attributes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopAttributes()
	 * @generated
	 * @ordered
	 */
	protected LoopAttributeSet loopAttributes;

	/**
	 * The cached value of the '{@link #getBoundaryEvents() <em>Boundary Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundaryEvents()
	 * @generated
	 * @ordered
	 */
	protected EList<Intermediate> boundaryEvents;

	/**
	 * The default value of the '{@link #getActivityType() <em>Activity Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivityType()
	 * @generated
	 * @ordered
	 */
	protected static final ActivityType ACTIVITY_TYPE_EDEFAULT = ActivityType.NONE;

	/**
	 * The cached value of the '{@link #getActivityType() <em>Activity Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivityType()
	 * @generated
	 * @ordered
	 */
	protected ActivityType activityType = ACTIVITY_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInMessage() <em>In Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInMessage()
	 * @generated
	 * @ordered
	 */
	protected Message inMessage;

	/**
	 * The cached value of the '{@link #getOutMessage() <em>Out Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutMessage()
	 * @generated
	 * @ordered
	 */
	protected Message outMessage;

	/**
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected Implementation implementation;

	/**
	 * The default value of the '{@link #isInstantiate() <em>Instantiate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInstantiate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INSTANTIATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInstantiate() <em>Instantiate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInstantiate()
	 * @generated
	 * @ordered
	 */
	protected boolean instantiate = INSTANTIATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPerformers() <em>Performers</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPerformers()
	 * @generated
	 * @ordered
	 */
	protected EList<String> performers;

	/**
	 * The default value of the '{@link #getScript() <em>Script</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected static final String SCRIPT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScript() <em>Script</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScript()
	 * @generated
	 * @ordered
	 */
	protected String script = SCRIPT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getActivityRef() <em>Activity Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivityRef()
	 * @generated
	 * @ordered
	 */
	protected Activity activityRef;

	/**
	 * The cached value of the '{@link #getTransaction() <em>Transaction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransaction()
	 * @generated
	 * @ordered
	 */
	protected Transaction transaction;

	/**
	 * The cached value of the '{@link #getDiagramRef() <em>Diagram Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagramRef()
	 * @generated
	 * @ordered
	 */
	protected BusinessProcessDiagram diagramRef;

	/**
	 * The cached value of the '{@link #getProcessRef() <em>Process Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessRef()
	 * @generated
	 * @ordered
	 */
	protected Pool processRef;

	/**
	 * The cached value of the '{@link #getInputPropertyMaps() <em>Input Property Maps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputPropertyMaps()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> inputPropertyMaps;

	/**
	 * The cached value of the '{@link #getOutputPropertyMaps() <em>Output Property Maps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputPropertyMaps()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> outputPropertyMaps;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAdHoc() {
		return adHoc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * automatically create ad hoc attribute set
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdHoc(boolean newAdHoc) {
		boolean oldAdHoc = adHoc;
		adHoc = newAdHoc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__AD_HOC, oldAdHoc, adHoc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getAdHocCompletionCondition() {
		return adHocCompletionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdHocCompletionCondition(Expression newAdHocCompletionCondition, NotificationChain msgs) {
		Expression oldAdHocCompletionCondition = adHocCompletionCondition;
		adHocCompletionCondition = newAdHocCompletionCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__AD_HOC_COMPLETION_CONDITION, oldAdHocCompletionCondition, newAdHocCompletionCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdHocCompletionCondition(Expression newAdHocCompletionCondition) {
		if (newAdHocCompletionCondition != adHocCompletionCondition) {
			NotificationChain msgs = null;
			if (adHocCompletionCondition != null)
				msgs = ((InternalEObject)adHocCompletionCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.ACTIVITY__AD_HOC_COMPLETION_CONDITION, null, msgs);
			if (newAdHocCompletionCondition != null)
				msgs = ((InternalEObject)newAdHocCompletionCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.ACTIVITY__AD_HOC_COMPLETION_CONDITION, null, msgs);
			msgs = basicSetAdHocCompletionCondition(newAdHocCompletionCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__AD_HOC_COMPLETION_CONDITION, newAdHocCompletionCondition, newAdHocCompletionCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<Property>(Property.class, this, VsdtPackage.ACTIVITY__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowObject> getContainedFlowObjects() {
		if (containedFlowObjects == null) {
			containedFlowObjects = new EObjectContainmentWithInverseEList<FlowObject>(FlowObject.class, this, VsdtPackage.ACTIVITY__CONTAINED_FLOW_OBJECTS, VsdtPackage.FLOW_OBJECT__PARENT);
		}
		return containedFlowObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputSet> getInputSets() {
		if (inputSets == null) {
			inputSets = new EObjectContainmentEList<InputSet>(InputSet.class, this, VsdtPackage.ACTIVITY__INPUT_SETS);
		}
		return inputSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputSet> getOutputSets() {
		if (outputSets == null) {
			outputSets = new EObjectContainmentEList<OutputSet>(OutputSet.class, this, VsdtPackage.ACTIVITY__OUTPUT_SETS);
		}
		return outputSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getIORules() {
		if (ioRules == null) {
			ioRules = new EObjectContainmentEList<Expression>(Expression.class, this, VsdtPackage.ACTIVITY__IO_RULES);
		}
		return ioRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartQuantity() {
		return startQuantity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartQuantity(int newStartQuantity) {
		int oldStartQuantity = startQuantity;
		startQuantity = newStartQuantity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__START_QUANTITY, oldStartQuantity, startQuantity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopAttributeSet getLoopAttributes() {
		return loopAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoopAttributes(LoopAttributeSet newLoopAttributes, NotificationChain msgs) {
		LoopAttributeSet oldLoopAttributes = loopAttributes;
		loopAttributes = newLoopAttributes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__LOOP_ATTRIBUTES, oldLoopAttributes, newLoopAttributes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopAttributes(LoopAttributeSet newLoopAttributes) {
		if (newLoopAttributes != loopAttributes) {
			NotificationChain msgs = null;
			if (loopAttributes != null)
				msgs = ((InternalEObject)loopAttributes).eInverseRemove(this, VsdtPackage.LOOP_ATTRIBUTE_SET__PARENT_ACTIVITY, LoopAttributeSet.class, msgs);
			if (newLoopAttributes != null)
				msgs = ((InternalEObject)newLoopAttributes).eInverseAdd(this, VsdtPackage.LOOP_ATTRIBUTE_SET__PARENT_ACTIVITY, LoopAttributeSet.class, msgs);
			msgs = basicSetLoopAttributes(newLoopAttributes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__LOOP_ATTRIBUTES, newLoopAttributes, newLoopAttributes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Intermediate> getBoundaryEvents() {
		if (boundaryEvents == null) {
			boundaryEvents = new EObjectContainmentWithInverseEList<Intermediate>(Intermediate.class, this, VsdtPackage.ACTIVITY__BOUNDARY_EVENTS, VsdtPackage.INTERMEDIATE__ATTACHED_TO);
		}
		return boundaryEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityType getActivityType() {
		return activityType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivityType(ActivityType newActivityType) {
		ActivityType oldActivityType = activityType;
		activityType = newActivityType == null ? ACTIVITY_TYPE_EDEFAULT : newActivityType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__ACTIVITY_TYPE, oldActivityType, activityType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getInMessage() {
		if (inMessage != null && inMessage.eIsProxy()) {
			InternalEObject oldInMessage = (InternalEObject)inMessage;
			inMessage = (Message)eResolveProxy(oldInMessage);
			if (inMessage != oldInMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.ACTIVITY__IN_MESSAGE, oldInMessage, inMessage));
			}
		}
		return inMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetInMessage() {
		return inMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInMessage(Message newInMessage) {
		Message oldInMessage = inMessage;
		inMessage = newInMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__IN_MESSAGE, oldInMessage, inMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getOutMessage() {
		if (outMessage != null && outMessage.eIsProxy()) {
			InternalEObject oldOutMessage = (InternalEObject)outMessage;
			outMessage = (Message)eResolveProxy(oldOutMessage);
			if (outMessage != oldOutMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.ACTIVITY__OUT_MESSAGE, oldOutMessage, outMessage));
			}
		}
		return outMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetOutMessage() {
		return outMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutMessage(Message newOutMessage) {
		Message oldOutMessage = outMessage;
		outMessage = newOutMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__OUT_MESSAGE, oldOutMessage, outMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Implementation getImplementation() {
		if (implementation != null && implementation.eIsProxy()) {
			InternalEObject oldImplementation = (InternalEObject)implementation;
			implementation = (Implementation)eResolveProxy(oldImplementation);
			if (implementation != oldImplementation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.ACTIVITY__IMPLEMENTATION, oldImplementation, implementation));
			}
		}
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Implementation basicGetImplementation() {
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImplementation(Implementation newImplementation) {
		Implementation oldImplementation = implementation;
		implementation = newImplementation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__IMPLEMENTATION, oldImplementation, implementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInstantiate() {
		return instantiate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstantiate(boolean newInstantiate) {
		boolean oldInstantiate = instantiate;
		instantiate = newInstantiate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__INSTANTIATE, oldInstantiate, instantiate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getPerformers() {
		if (performers == null) {
			performers = new EDataTypeUniqueEList<String>(String.class, this, VsdtPackage.ACTIVITY__PERFORMERS);
		}
		return performers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getScript() {
		return script;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScript(String newScript) {
		String oldScript = script;
		script = newScript;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__SCRIPT, oldScript, script));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getActivityRef() {
		if (activityRef != null && activityRef.eIsProxy()) {
			InternalEObject oldActivityRef = (InternalEObject)activityRef;
			activityRef = (Activity)eResolveProxy(oldActivityRef);
			if (activityRef != oldActivityRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.ACTIVITY__ACTIVITY_REF, oldActivityRef, activityRef));
			}
		}
		return activityRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity basicGetActivityRef() {
		return activityRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivityRef(Activity newActivityRef) {
		Activity oldActivityRef = activityRef;
		activityRef = newActivityRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__ACTIVITY_REF, oldActivityRef, activityRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transaction getTransaction() {
		return transaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransaction(Transaction newTransaction, NotificationChain msgs) {
		Transaction oldTransaction = transaction;
		transaction = newTransaction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__TRANSACTION, oldTransaction, newTransaction);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransaction(Transaction newTransaction) {
		if (newTransaction != transaction) {
			NotificationChain msgs = null;
			if (transaction != null)
				msgs = ((InternalEObject)transaction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.ACTIVITY__TRANSACTION, null, msgs);
			if (newTransaction != null)
				msgs = ((InternalEObject)newTransaction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.ACTIVITY__TRANSACTION, null, msgs);
			msgs = basicSetTransaction(newTransaction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__TRANSACTION, newTransaction, newTransaction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcessDiagram getDiagramRef() {
		if (diagramRef != null && diagramRef.eIsProxy()) {
			InternalEObject oldDiagramRef = (InternalEObject)diagramRef;
			diagramRef = (BusinessProcessDiagram)eResolveProxy(oldDiagramRef);
			if (diagramRef != oldDiagramRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.ACTIVITY__DIAGRAM_REF, oldDiagramRef, diagramRef));
			}
		}
		return diagramRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcessDiagram basicGetDiagramRef() {
		return diagramRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagramRef(BusinessProcessDiagram newDiagramRef) {
		BusinessProcessDiagram oldDiagramRef = diagramRef;
		diagramRef = newDiagramRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__DIAGRAM_REF, oldDiagramRef, diagramRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pool getProcessRef() {
		if (processRef != null && processRef.eIsProxy()) {
			InternalEObject oldProcessRef = (InternalEObject)processRef;
			processRef = (Pool)eResolveProxy(oldProcessRef);
			if (processRef != oldProcessRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.ACTIVITY__PROCESS_REF, oldProcessRef, processRef));
			}
		}
		return processRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pool basicGetProcessRef() {
		return processRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessRef(Pool newProcessRef) {
		Pool oldProcessRef = processRef;
		processRef = newProcessRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ACTIVITY__PROCESS_REF, oldProcessRef, processRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getInputPropertyMaps() {
		if (inputPropertyMaps == null) {
			inputPropertyMaps = new EObjectContainmentEList<Expression>(Expression.class, this, VsdtPackage.ACTIVITY__INPUT_PROPERTY_MAPS);
		}
		return inputPropertyMaps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getOutputPropertyMaps() {
		if (outputPropertyMaps == null) {
			outputPropertyMaps = new EObjectContainmentEList<Expression>(Expression.class, this, VsdtPackage.ACTIVITY__OUTPUT_PROPERTY_MAPS);
		}
		return outputPropertyMaps;
	}

	/**
	 * initialize input set depending on associated data objects
	 * @generated NOT
	 */
	public void initializeInputSet() {
		InputSet input= VsdtFactory.eINSTANCE.createInputSet();
		
		for (Association association : getIncomingAss()) {
			if ((association.getDirection() == DirectionType.ONE ||
					association.getDirection()== DirectionType.BOTH) &&
					association.getSource() instanceof DataObject) {
				input.getInputs().add((DataObject)association.getSource());
			}	
		}
		for (Association association : getOutgoingAss()) {
			if (association.getDirection() == de.dailab.vsdt.DirectionType.BOTH &&
					association.getTarget() instanceof DataObject) {
				input.getInputs().add((DataObject)association.getTarget());
			}	
		}
		
		if (! input.getInputs().isEmpty()) {
			this.getInputSets().add(input);
		}
	}
	
	/**
	 * initialize output set depending on associated data objects
	 * @generated NOT
	 */
	public void initializeOutputSet() {
		OutputSet output= VsdtFactory.eINSTANCE.createOutputSet();
		
		for (Iterator<Association> iter = getIncomingAss().iterator(); iter.hasNext();) {
			Association association = iter.next();
			if (	association.getDirection()== DirectionType.BOTH &&
					association.getSource() instanceof DataObject) {
				output.getOutputs().add((DataObject)association.getSource());
			}	
		}
		for (Iterator<Association> iter = getOutgoingAss().iterator(); iter.hasNext();) {
			Association association = iter.next();
			if ((association.getDirection() == DirectionType.ONE ||
					association.getDirection()== DirectionType.BOTH) &&
					association.getTarget() instanceof DataObject) {
				output.getOutputs().add((DataObject)association.getTarget());
			}	
		}
		
		if (! output.getOutputs().isEmpty()) {
			this.getOutputSets().add(output);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * calculate a value for the isCompensation field.
	 * The isCompensation field is set accordingly and the new 
	 * value is returned
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isCompensation() {
		boolean isComp= false;
		//iterate over associations
		for (Association association : getIncomingAss()) {
			if (association.getSource() instanceof Intermediate) {
				Intermediate intermediate = (Intermediate) association.getSource();
				if (intermediate.getTrigger() == TriggerType.COMPENSATION) {
					isComp= true;
					break;
				}
			}
		}
		return isComp;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FlowObject> getGraphicalElements() {
		return getContainedFlowObjects();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.ACTIVITY__CONTAINED_FLOW_OBJECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContainedFlowObjects()).basicAdd(otherEnd, msgs);
			case VsdtPackage.ACTIVITY__LOOP_ATTRIBUTES:
				if (loopAttributes != null)
					msgs = ((InternalEObject)loopAttributes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.ACTIVITY__LOOP_ATTRIBUTES, null, msgs);
				return basicSetLoopAttributes((LoopAttributeSet)otherEnd, msgs);
			case VsdtPackage.ACTIVITY__BOUNDARY_EVENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getBoundaryEvents()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.ACTIVITY__AD_HOC_COMPLETION_CONDITION:
				return basicSetAdHocCompletionCondition(null, msgs);
			case VsdtPackage.ACTIVITY__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case VsdtPackage.ACTIVITY__CONTAINED_FLOW_OBJECTS:
				return ((InternalEList<?>)getContainedFlowObjects()).basicRemove(otherEnd, msgs);
			case VsdtPackage.ACTIVITY__INPUT_SETS:
				return ((InternalEList<?>)getInputSets()).basicRemove(otherEnd, msgs);
			case VsdtPackage.ACTIVITY__OUTPUT_SETS:
				return ((InternalEList<?>)getOutputSets()).basicRemove(otherEnd, msgs);
			case VsdtPackage.ACTIVITY__IO_RULES:
				return ((InternalEList<?>)getIORules()).basicRemove(otherEnd, msgs);
			case VsdtPackage.ACTIVITY__LOOP_ATTRIBUTES:
				return basicSetLoopAttributes(null, msgs);
			case VsdtPackage.ACTIVITY__BOUNDARY_EVENTS:
				return ((InternalEList<?>)getBoundaryEvents()).basicRemove(otherEnd, msgs);
			case VsdtPackage.ACTIVITY__TRANSACTION:
				return basicSetTransaction(null, msgs);
			case VsdtPackage.ACTIVITY__INPUT_PROPERTY_MAPS:
				return ((InternalEList<?>)getInputPropertyMaps()).basicRemove(otherEnd, msgs);
			case VsdtPackage.ACTIVITY__OUTPUT_PROPERTY_MAPS:
				return ((InternalEList<?>)getOutputPropertyMaps()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VsdtPackage.ACTIVITY__AD_HOC:
				return isAdHoc();
			case VsdtPackage.ACTIVITY__AD_HOC_COMPLETION_CONDITION:
				return getAdHocCompletionCondition();
			case VsdtPackage.ACTIVITY__PROPERTIES:
				return getProperties();
			case VsdtPackage.ACTIVITY__CONTAINED_FLOW_OBJECTS:
				return getContainedFlowObjects();
			case VsdtPackage.ACTIVITY__INPUT_SETS:
				return getInputSets();
			case VsdtPackage.ACTIVITY__OUTPUT_SETS:
				return getOutputSets();
			case VsdtPackage.ACTIVITY__IO_RULES:
				return getIORules();
			case VsdtPackage.ACTIVITY__START_QUANTITY:
				return getStartQuantity();
			case VsdtPackage.ACTIVITY__LOOP_ATTRIBUTES:
				return getLoopAttributes();
			case VsdtPackage.ACTIVITY__BOUNDARY_EVENTS:
				return getBoundaryEvents();
			case VsdtPackage.ACTIVITY__ACTIVITY_TYPE:
				return getActivityType();
			case VsdtPackage.ACTIVITY__IN_MESSAGE:
				if (resolve) return getInMessage();
				return basicGetInMessage();
			case VsdtPackage.ACTIVITY__OUT_MESSAGE:
				if (resolve) return getOutMessage();
				return basicGetOutMessage();
			case VsdtPackage.ACTIVITY__IMPLEMENTATION:
				if (resolve) return getImplementation();
				return basicGetImplementation();
			case VsdtPackage.ACTIVITY__INSTANTIATE:
				return isInstantiate();
			case VsdtPackage.ACTIVITY__PERFORMERS:
				return getPerformers();
			case VsdtPackage.ACTIVITY__SCRIPT:
				return getScript();
			case VsdtPackage.ACTIVITY__ACTIVITY_REF:
				if (resolve) return getActivityRef();
				return basicGetActivityRef();
			case VsdtPackage.ACTIVITY__TRANSACTION:
				return getTransaction();
			case VsdtPackage.ACTIVITY__DIAGRAM_REF:
				if (resolve) return getDiagramRef();
				return basicGetDiagramRef();
			case VsdtPackage.ACTIVITY__PROCESS_REF:
				if (resolve) return getProcessRef();
				return basicGetProcessRef();
			case VsdtPackage.ACTIVITY__INPUT_PROPERTY_MAPS:
				return getInputPropertyMaps();
			case VsdtPackage.ACTIVITY__OUTPUT_PROPERTY_MAPS:
				return getOutputPropertyMaps();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VsdtPackage.ACTIVITY__AD_HOC:
				setAdHoc((Boolean)newValue);
				return;
			case VsdtPackage.ACTIVITY__AD_HOC_COMPLETION_CONDITION:
				setAdHocCompletionCondition((Expression)newValue);
				return;
			case VsdtPackage.ACTIVITY__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case VsdtPackage.ACTIVITY__CONTAINED_FLOW_OBJECTS:
				getContainedFlowObjects().clear();
				getContainedFlowObjects().addAll((Collection<? extends FlowObject>)newValue);
				return;
			case VsdtPackage.ACTIVITY__INPUT_SETS:
				getInputSets().clear();
				getInputSets().addAll((Collection<? extends InputSet>)newValue);
				return;
			case VsdtPackage.ACTIVITY__OUTPUT_SETS:
				getOutputSets().clear();
				getOutputSets().addAll((Collection<? extends OutputSet>)newValue);
				return;
			case VsdtPackage.ACTIVITY__IO_RULES:
				getIORules().clear();
				getIORules().addAll((Collection<? extends Expression>)newValue);
				return;
			case VsdtPackage.ACTIVITY__START_QUANTITY:
				setStartQuantity((Integer)newValue);
				return;
			case VsdtPackage.ACTIVITY__LOOP_ATTRIBUTES:
				setLoopAttributes((LoopAttributeSet)newValue);
				return;
			case VsdtPackage.ACTIVITY__BOUNDARY_EVENTS:
				getBoundaryEvents().clear();
				getBoundaryEvents().addAll((Collection<? extends Intermediate>)newValue);
				return;
			case VsdtPackage.ACTIVITY__ACTIVITY_TYPE:
				setActivityType((ActivityType)newValue);
				return;
			case VsdtPackage.ACTIVITY__IN_MESSAGE:
				setInMessage((Message)newValue);
				return;
			case VsdtPackage.ACTIVITY__OUT_MESSAGE:
				setOutMessage((Message)newValue);
				return;
			case VsdtPackage.ACTIVITY__IMPLEMENTATION:
				setImplementation((Implementation)newValue);
				return;
			case VsdtPackage.ACTIVITY__INSTANTIATE:
				setInstantiate((Boolean)newValue);
				return;
			case VsdtPackage.ACTIVITY__PERFORMERS:
				getPerformers().clear();
				getPerformers().addAll((Collection<? extends String>)newValue);
				return;
			case VsdtPackage.ACTIVITY__SCRIPT:
				setScript((String)newValue);
				return;
			case VsdtPackage.ACTIVITY__ACTIVITY_REF:
				setActivityRef((Activity)newValue);
				return;
			case VsdtPackage.ACTIVITY__TRANSACTION:
				setTransaction((Transaction)newValue);
				return;
			case VsdtPackage.ACTIVITY__DIAGRAM_REF:
				setDiagramRef((BusinessProcessDiagram)newValue);
				return;
			case VsdtPackage.ACTIVITY__PROCESS_REF:
				setProcessRef((Pool)newValue);
				return;
			case VsdtPackage.ACTIVITY__INPUT_PROPERTY_MAPS:
				getInputPropertyMaps().clear();
				getInputPropertyMaps().addAll((Collection<? extends Expression>)newValue);
				return;
			case VsdtPackage.ACTIVITY__OUTPUT_PROPERTY_MAPS:
				getOutputPropertyMaps().clear();
				getOutputPropertyMaps().addAll((Collection<? extends Expression>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VsdtPackage.ACTIVITY__AD_HOC:
				setAdHoc(AD_HOC_EDEFAULT);
				return;
			case VsdtPackage.ACTIVITY__AD_HOC_COMPLETION_CONDITION:
				setAdHocCompletionCondition((Expression)null);
				return;
			case VsdtPackage.ACTIVITY__PROPERTIES:
				getProperties().clear();
				return;
			case VsdtPackage.ACTIVITY__CONTAINED_FLOW_OBJECTS:
				getContainedFlowObjects().clear();
				return;
			case VsdtPackage.ACTIVITY__INPUT_SETS:
				getInputSets().clear();
				return;
			case VsdtPackage.ACTIVITY__OUTPUT_SETS:
				getOutputSets().clear();
				return;
			case VsdtPackage.ACTIVITY__IO_RULES:
				getIORules().clear();
				return;
			case VsdtPackage.ACTIVITY__START_QUANTITY:
				setStartQuantity(START_QUANTITY_EDEFAULT);
				return;
			case VsdtPackage.ACTIVITY__LOOP_ATTRIBUTES:
				setLoopAttributes((LoopAttributeSet)null);
				return;
			case VsdtPackage.ACTIVITY__BOUNDARY_EVENTS:
				getBoundaryEvents().clear();
				return;
			case VsdtPackage.ACTIVITY__ACTIVITY_TYPE:
				setActivityType(ACTIVITY_TYPE_EDEFAULT);
				return;
			case VsdtPackage.ACTIVITY__IN_MESSAGE:
				setInMessage((Message)null);
				return;
			case VsdtPackage.ACTIVITY__OUT_MESSAGE:
				setOutMessage((Message)null);
				return;
			case VsdtPackage.ACTIVITY__IMPLEMENTATION:
				setImplementation((Implementation)null);
				return;
			case VsdtPackage.ACTIVITY__INSTANTIATE:
				setInstantiate(INSTANTIATE_EDEFAULT);
				return;
			case VsdtPackage.ACTIVITY__PERFORMERS:
				getPerformers().clear();
				return;
			case VsdtPackage.ACTIVITY__SCRIPT:
				setScript(SCRIPT_EDEFAULT);
				return;
			case VsdtPackage.ACTIVITY__ACTIVITY_REF:
				setActivityRef((Activity)null);
				return;
			case VsdtPackage.ACTIVITY__TRANSACTION:
				setTransaction((Transaction)null);
				return;
			case VsdtPackage.ACTIVITY__DIAGRAM_REF:
				setDiagramRef((BusinessProcessDiagram)null);
				return;
			case VsdtPackage.ACTIVITY__PROCESS_REF:
				setProcessRef((Pool)null);
				return;
			case VsdtPackage.ACTIVITY__INPUT_PROPERTY_MAPS:
				getInputPropertyMaps().clear();
				return;
			case VsdtPackage.ACTIVITY__OUTPUT_PROPERTY_MAPS:
				getOutputPropertyMaps().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VsdtPackage.ACTIVITY__AD_HOC:
				return adHoc != AD_HOC_EDEFAULT;
			case VsdtPackage.ACTIVITY__AD_HOC_COMPLETION_CONDITION:
				return adHocCompletionCondition != null;
			case VsdtPackage.ACTIVITY__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case VsdtPackage.ACTIVITY__CONTAINED_FLOW_OBJECTS:
				return containedFlowObjects != null && !containedFlowObjects.isEmpty();
			case VsdtPackage.ACTIVITY__INPUT_SETS:
				return inputSets != null && !inputSets.isEmpty();
			case VsdtPackage.ACTIVITY__OUTPUT_SETS:
				return outputSets != null && !outputSets.isEmpty();
			case VsdtPackage.ACTIVITY__IO_RULES:
				return ioRules != null && !ioRules.isEmpty();
			case VsdtPackage.ACTIVITY__START_QUANTITY:
				return startQuantity != START_QUANTITY_EDEFAULT;
			case VsdtPackage.ACTIVITY__LOOP_ATTRIBUTES:
				return loopAttributes != null;
			case VsdtPackage.ACTIVITY__BOUNDARY_EVENTS:
				return boundaryEvents != null && !boundaryEvents.isEmpty();
			case VsdtPackage.ACTIVITY__ACTIVITY_TYPE:
				return activityType != ACTIVITY_TYPE_EDEFAULT;
			case VsdtPackage.ACTIVITY__IN_MESSAGE:
				return inMessage != null;
			case VsdtPackage.ACTIVITY__OUT_MESSAGE:
				return outMessage != null;
			case VsdtPackage.ACTIVITY__IMPLEMENTATION:
				return implementation != null;
			case VsdtPackage.ACTIVITY__INSTANTIATE:
				return instantiate != INSTANTIATE_EDEFAULT;
			case VsdtPackage.ACTIVITY__PERFORMERS:
				return performers != null && !performers.isEmpty();
			case VsdtPackage.ACTIVITY__SCRIPT:
				return SCRIPT_EDEFAULT == null ? script != null : !SCRIPT_EDEFAULT.equals(script);
			case VsdtPackage.ACTIVITY__ACTIVITY_REF:
				return activityRef != null;
			case VsdtPackage.ACTIVITY__TRANSACTION:
				return transaction != null;
			case VsdtPackage.ACTIVITY__DIAGRAM_REF:
				return diagramRef != null;
			case VsdtPackage.ACTIVITY__PROCESS_REF:
				return processRef != null;
			case VsdtPackage.ACTIVITY__INPUT_PROPERTY_MAPS:
				return inputPropertyMaps != null && !inputPropertyMaps.isEmpty();
			case VsdtPackage.ACTIVITY__OUTPUT_PROPERTY_MAPS:
				return outputPropertyMaps != null && !outputPropertyMaps.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == AbstractProcess.class) {
			switch (derivedFeatureID) {
				case VsdtPackage.ACTIVITY__AD_HOC: return VsdtPackage.ABSTRACT_PROCESS__AD_HOC;
				case VsdtPackage.ACTIVITY__AD_HOC_COMPLETION_CONDITION: return VsdtPackage.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION;
				case VsdtPackage.ACTIVITY__PROPERTIES: return VsdtPackage.ABSTRACT_PROCESS__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == FlowObjectContainer.class) {
			switch (derivedFeatureID) {
				case VsdtPackage.ACTIVITY__CONTAINED_FLOW_OBJECTS: return VsdtPackage.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == AbstractProcess.class) {
			switch (baseFeatureID) {
				case VsdtPackage.ABSTRACT_PROCESS__AD_HOC: return VsdtPackage.ACTIVITY__AD_HOC;
				case VsdtPackage.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION: return VsdtPackage.ACTIVITY__AD_HOC_COMPLETION_CONDITION;
				case VsdtPackage.ABSTRACT_PROCESS__PROPERTIES: return VsdtPackage.ACTIVITY__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == FlowObjectContainer.class) {
			switch (baseFeatureID) {
				case VsdtPackage.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS: return VsdtPackage.ACTIVITY__CONTAINED_FLOW_OBJECTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (adHoc: ");
		result.append(adHoc);
		result.append(", startQuantity: ");
		result.append(startQuantity);
		result.append(", activityType: ");
		result.append(activityType);
		result.append(", instantiate: ");
		result.append(instantiate);
		result.append(", performers: ");
		result.append(performers);
		result.append(", script: ");
		result.append(script);
		result.append(')');
		return result.toString();
	}

} //ActivityImpl
