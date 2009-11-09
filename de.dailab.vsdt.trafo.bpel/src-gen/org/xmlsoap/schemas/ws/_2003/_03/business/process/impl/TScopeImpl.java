/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivity;
import org.xmlsoap.schemas.ws._2003._03.business.process.TAssign;
import org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCompensationHandler;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSets;
import org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty;
import org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFlow;
import org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke;
import org.xmlsoap.schemas.ws._2003._03.business.process.TPick;
import org.xmlsoap.schemas.ws._2003._03.business.process.TReceive;
import org.xmlsoap.schemas.ws._2003._03.business.process.TReply;
import org.xmlsoap.schemas.ws._2003._03.business.process.TScope;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSequence;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch;
import org.xmlsoap.schemas.ws._2003._03.business.process.TTerminate;
import org.xmlsoap.schemas.ws._2003._03.business.process.TThrow;
import org.xmlsoap.schemas.ws._2003._03.business.process.TVariables;
import org.xmlsoap.schemas.ws._2003._03.business.process.TWait;
import org.xmlsoap.schemas.ws._2003._03.business.process.TWhile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TScope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getCorrelationSets <em>Correlation Sets</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getFaultHandlers <em>Fault Handlers</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getCompensationHandler <em>Compensation Handler</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getEventHandlers <em>Event Handlers</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getEmpty <em>Empty</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getInvoke <em>Invoke</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getReceive <em>Receive</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getReply <em>Reply</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getAssign <em>Assign</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getWait <em>Wait</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getThrow <em>Throw</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getTerminate <em>Terminate</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getFlow <em>Flow</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getWhile <em>While</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getPick <em>Pick</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl#getVariableAccessSerializable <em>Variable Access Serializable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TScopeImpl extends TActivityImpl implements TScope {
	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected TVariables variables;

	/**
	 * The cached value of the '{@link #getCorrelationSets() <em>Correlation Sets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationSets()
	 * @generated
	 * @ordered
	 */
	protected TCorrelationSets correlationSets;

	/**
	 * The cached value of the '{@link #getFaultHandlers() <em>Fault Handlers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultHandlers()
	 * @generated
	 * @ordered
	 */
	protected TFaultHandlers faultHandlers;

	/**
	 * The cached value of the '{@link #getCompensationHandler() <em>Compensation Handler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompensationHandler()
	 * @generated
	 * @ordered
	 */
	protected TCompensationHandler compensationHandler;

	/**
	 * The cached value of the '{@link #getEventHandlers() <em>Event Handlers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventHandlers()
	 * @generated
	 * @ordered
	 */
	protected TEventHandlers eventHandlers;

	/**
	 * The cached value of the '{@link #getEmpty() <em>Empty</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmpty()
	 * @generated
	 * @ordered
	 */
	protected TEmpty empty;

	/**
	 * The cached value of the '{@link #getInvoke() <em>Invoke</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvoke()
	 * @generated
	 * @ordered
	 */
	protected TInvoke invoke;

	/**
	 * The cached value of the '{@link #getReceive() <em>Receive</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceive()
	 * @generated
	 * @ordered
	 */
	protected TReceive receive;

	/**
	 * The cached value of the '{@link #getReply() <em>Reply</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReply()
	 * @generated
	 * @ordered
	 */
	protected TReply reply;

	/**
	 * The cached value of the '{@link #getAssign() <em>Assign</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssign()
	 * @generated
	 * @ordered
	 */
	protected TAssign assign;

	/**
	 * The cached value of the '{@link #getWait() <em>Wait</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWait()
	 * @generated
	 * @ordered
	 */
	protected TWait wait;

	/**
	 * The cached value of the '{@link #getThrow() <em>Throw</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrow()
	 * @generated
	 * @ordered
	 */
	protected TThrow throw_;

	/**
	 * The cached value of the '{@link #getTerminate() <em>Terminate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminate()
	 * @generated
	 * @ordered
	 */
	protected TTerminate terminate;

	/**
	 * The cached value of the '{@link #getFlow() <em>Flow</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFlow()
	 * @generated
	 * @ordered
	 */
	protected TFlow flow;

	/**
	 * The cached value of the '{@link #getSwitch() <em>Switch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitch()
	 * @generated
	 * @ordered
	 */
	protected TSwitch switch_;

	/**
	 * The cached value of the '{@link #getWhile() <em>While</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhile()
	 * @generated
	 * @ordered
	 */
	protected TWhile while_;

	/**
	 * The cached value of the '{@link #getSequence() <em>Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequence()
	 * @generated
	 * @ordered
	 */
	protected TSequence sequence;

	/**
	 * The cached value of the '{@link #getPick() <em>Pick</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPick()
	 * @generated
	 * @ordered
	 */
	protected TPick pick;

	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected TScope scope;

	/**
	 * The default value of the '{@link #getVariableAccessSerializable() <em>Variable Access Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableAccessSerializable()
	 * @generated
	 * @ordered
	 */
	protected static final TBoolean VARIABLE_ACCESS_SERIALIZABLE_EDEFAULT = TBoolean.NO;

	/**
	 * The cached value of the '{@link #getVariableAccessSerializable() <em>Variable Access Serializable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableAccessSerializable()
	 * @generated
	 * @ordered
	 */
	protected TBoolean variableAccessSerializable = VARIABLE_ACCESS_SERIALIZABLE_EDEFAULT;

	/**
	 * This is true if the Variable Access Serializable attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean variableAccessSerializableESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TScopeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TSCOPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TVariables getVariables() {
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariables(TVariables newVariables, NotificationChain msgs) {
		TVariables oldVariables = variables;
		variables = newVariables;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__VARIABLES, oldVariables, newVariables);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariables(TVariables newVariables) {
		if (newVariables != variables) {
			NotificationChain msgs = null;
			if (variables != null)
				msgs = ((InternalEObject)variables).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__VARIABLES, null, msgs);
			if (newVariables != null)
				msgs = ((InternalEObject)newVariables).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__VARIABLES, null, msgs);
			msgs = basicSetVariables(newVariables, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__VARIABLES, newVariables, newVariables));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCorrelationSets getCorrelationSets() {
		return correlationSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCorrelationSets(TCorrelationSets newCorrelationSets, NotificationChain msgs) {
		TCorrelationSets oldCorrelationSets = correlationSets;
		correlationSets = newCorrelationSets;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__CORRELATION_SETS, oldCorrelationSets, newCorrelationSets);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrelationSets(TCorrelationSets newCorrelationSets) {
		if (newCorrelationSets != correlationSets) {
			NotificationChain msgs = null;
			if (correlationSets != null)
				msgs = ((InternalEObject)correlationSets).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__CORRELATION_SETS, null, msgs);
			if (newCorrelationSets != null)
				msgs = ((InternalEObject)newCorrelationSets).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__CORRELATION_SETS, null, msgs);
			msgs = basicSetCorrelationSets(newCorrelationSets, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__CORRELATION_SETS, newCorrelationSets, newCorrelationSets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFaultHandlers getFaultHandlers() {
		return faultHandlers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultHandlers(TFaultHandlers newFaultHandlers, NotificationChain msgs) {
		TFaultHandlers oldFaultHandlers = faultHandlers;
		faultHandlers = newFaultHandlers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__FAULT_HANDLERS, oldFaultHandlers, newFaultHandlers);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultHandlers(TFaultHandlers newFaultHandlers) {
		if (newFaultHandlers != faultHandlers) {
			NotificationChain msgs = null;
			if (faultHandlers != null)
				msgs = ((InternalEObject)faultHandlers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__FAULT_HANDLERS, null, msgs);
			if (newFaultHandlers != null)
				msgs = ((InternalEObject)newFaultHandlers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__FAULT_HANDLERS, null, msgs);
			msgs = basicSetFaultHandlers(newFaultHandlers, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__FAULT_HANDLERS, newFaultHandlers, newFaultHandlers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCompensationHandler getCompensationHandler() {
		return compensationHandler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompensationHandler(TCompensationHandler newCompensationHandler, NotificationChain msgs) {
		TCompensationHandler oldCompensationHandler = compensationHandler;
		compensationHandler = newCompensationHandler;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__COMPENSATION_HANDLER, oldCompensationHandler, newCompensationHandler);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompensationHandler(TCompensationHandler newCompensationHandler) {
		if (newCompensationHandler != compensationHandler) {
			NotificationChain msgs = null;
			if (compensationHandler != null)
				msgs = ((InternalEObject)compensationHandler).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__COMPENSATION_HANDLER, null, msgs);
			if (newCompensationHandler != null)
				msgs = ((InternalEObject)newCompensationHandler).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__COMPENSATION_HANDLER, null, msgs);
			msgs = basicSetCompensationHandler(newCompensationHandler, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__COMPENSATION_HANDLER, newCompensationHandler, newCompensationHandler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TEventHandlers getEventHandlers() {
		return eventHandlers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventHandlers(TEventHandlers newEventHandlers, NotificationChain msgs) {
		TEventHandlers oldEventHandlers = eventHandlers;
		eventHandlers = newEventHandlers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__EVENT_HANDLERS, oldEventHandlers, newEventHandlers);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventHandlers(TEventHandlers newEventHandlers) {
		if (newEventHandlers != eventHandlers) {
			NotificationChain msgs = null;
			if (eventHandlers != null)
				msgs = ((InternalEObject)eventHandlers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__EVENT_HANDLERS, null, msgs);
			if (newEventHandlers != null)
				msgs = ((InternalEObject)newEventHandlers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__EVENT_HANDLERS, null, msgs);
			msgs = basicSetEventHandlers(newEventHandlers, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__EVENT_HANDLERS, newEventHandlers, newEventHandlers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TEmpty getEmpty() {
		return empty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEmpty(TEmpty newEmpty, NotificationChain msgs) {
		TEmpty oldEmpty = empty;
		empty = newEmpty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__EMPTY, oldEmpty, newEmpty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmpty(TEmpty newEmpty) {
		if (newEmpty != empty) {
			NotificationChain msgs = null;
			if (empty != null)
				msgs = ((InternalEObject)empty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__EMPTY, null, msgs);
			if (newEmpty != null)
				msgs = ((InternalEObject)newEmpty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__EMPTY, null, msgs);
			msgs = basicSetEmpty(newEmpty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__EMPTY, newEmpty, newEmpty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TInvoke getInvoke() {
		return invoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvoke(TInvoke newInvoke, NotificationChain msgs) {
		TInvoke oldInvoke = invoke;
		invoke = newInvoke;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__INVOKE, oldInvoke, newInvoke);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvoke(TInvoke newInvoke) {
		if (newInvoke != invoke) {
			NotificationChain msgs = null;
			if (invoke != null)
				msgs = ((InternalEObject)invoke).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__INVOKE, null, msgs);
			if (newInvoke != null)
				msgs = ((InternalEObject)newInvoke).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__INVOKE, null, msgs);
			msgs = basicSetInvoke(newInvoke, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__INVOKE, newInvoke, newInvoke));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TReceive getReceive() {
		return receive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReceive(TReceive newReceive, NotificationChain msgs) {
		TReceive oldReceive = receive;
		receive = newReceive;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__RECEIVE, oldReceive, newReceive);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReceive(TReceive newReceive) {
		if (newReceive != receive) {
			NotificationChain msgs = null;
			if (receive != null)
				msgs = ((InternalEObject)receive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__RECEIVE, null, msgs);
			if (newReceive != null)
				msgs = ((InternalEObject)newReceive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__RECEIVE, null, msgs);
			msgs = basicSetReceive(newReceive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__RECEIVE, newReceive, newReceive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TReply getReply() {
		return reply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReply(TReply newReply, NotificationChain msgs) {
		TReply oldReply = reply;
		reply = newReply;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__REPLY, oldReply, newReply);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReply(TReply newReply) {
		if (newReply != reply) {
			NotificationChain msgs = null;
			if (reply != null)
				msgs = ((InternalEObject)reply).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__REPLY, null, msgs);
			if (newReply != null)
				msgs = ((InternalEObject)newReply).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__REPLY, null, msgs);
			msgs = basicSetReply(newReply, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__REPLY, newReply, newReply));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TAssign getAssign() {
		return assign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssign(TAssign newAssign, NotificationChain msgs) {
		TAssign oldAssign = assign;
		assign = newAssign;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__ASSIGN, oldAssign, newAssign);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssign(TAssign newAssign) {
		if (newAssign != assign) {
			NotificationChain msgs = null;
			if (assign != null)
				msgs = ((InternalEObject)assign).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__ASSIGN, null, msgs);
			if (newAssign != null)
				msgs = ((InternalEObject)newAssign).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__ASSIGN, null, msgs);
			msgs = basicSetAssign(newAssign, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__ASSIGN, newAssign, newAssign));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TWait getWait() {
		return wait;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWait(TWait newWait, NotificationChain msgs) {
		TWait oldWait = wait;
		wait = newWait;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__WAIT, oldWait, newWait);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWait(TWait newWait) {
		if (newWait != wait) {
			NotificationChain msgs = null;
			if (wait != null)
				msgs = ((InternalEObject)wait).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__WAIT, null, msgs);
			if (newWait != null)
				msgs = ((InternalEObject)newWait).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__WAIT, null, msgs);
			msgs = basicSetWait(newWait, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__WAIT, newWait, newWait));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TThrow getThrow() {
		return throw_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThrow(TThrow newThrow, NotificationChain msgs) {
		TThrow oldThrow = throw_;
		throw_ = newThrow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__THROW, oldThrow, newThrow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThrow(TThrow newThrow) {
		if (newThrow != throw_) {
			NotificationChain msgs = null;
			if (throw_ != null)
				msgs = ((InternalEObject)throw_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__THROW, null, msgs);
			if (newThrow != null)
				msgs = ((InternalEObject)newThrow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__THROW, null, msgs);
			msgs = basicSetThrow(newThrow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__THROW, newThrow, newThrow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TTerminate getTerminate() {
		return terminate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTerminate(TTerminate newTerminate, NotificationChain msgs) {
		TTerminate oldTerminate = terminate;
		terminate = newTerminate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__TERMINATE, oldTerminate, newTerminate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTerminate(TTerminate newTerminate) {
		if (newTerminate != terminate) {
			NotificationChain msgs = null;
			if (terminate != null)
				msgs = ((InternalEObject)terminate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__TERMINATE, null, msgs);
			if (newTerminate != null)
				msgs = ((InternalEObject)newTerminate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__TERMINATE, null, msgs);
			msgs = basicSetTerminate(newTerminate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__TERMINATE, newTerminate, newTerminate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFlow getFlow() {
		return flow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFlow(TFlow newFlow, NotificationChain msgs) {
		TFlow oldFlow = flow;
		flow = newFlow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__FLOW, oldFlow, newFlow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlow(TFlow newFlow) {
		if (newFlow != flow) {
			NotificationChain msgs = null;
			if (flow != null)
				msgs = ((InternalEObject)flow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__FLOW, null, msgs);
			if (newFlow != null)
				msgs = ((InternalEObject)newFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__FLOW, null, msgs);
			msgs = basicSetFlow(newFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__FLOW, newFlow, newFlow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TSwitch getSwitch() {
		return switch_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSwitch(TSwitch newSwitch, NotificationChain msgs) {
		TSwitch oldSwitch = switch_;
		switch_ = newSwitch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__SWITCH, oldSwitch, newSwitch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwitch(TSwitch newSwitch) {
		if (newSwitch != switch_) {
			NotificationChain msgs = null;
			if (switch_ != null)
				msgs = ((InternalEObject)switch_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__SWITCH, null, msgs);
			if (newSwitch != null)
				msgs = ((InternalEObject)newSwitch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__SWITCH, null, msgs);
			msgs = basicSetSwitch(newSwitch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__SWITCH, newSwitch, newSwitch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TWhile getWhile() {
		return while_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhile(TWhile newWhile, NotificationChain msgs) {
		TWhile oldWhile = while_;
		while_ = newWhile;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__WHILE, oldWhile, newWhile);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhile(TWhile newWhile) {
		if (newWhile != while_) {
			NotificationChain msgs = null;
			if (while_ != null)
				msgs = ((InternalEObject)while_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__WHILE, null, msgs);
			if (newWhile != null)
				msgs = ((InternalEObject)newWhile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__WHILE, null, msgs);
			msgs = basicSetWhile(newWhile, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__WHILE, newWhile, newWhile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TSequence getSequence() {
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequence(TSequence newSequence, NotificationChain msgs) {
		TSequence oldSequence = sequence;
		sequence = newSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__SEQUENCE, oldSequence, newSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequence(TSequence newSequence) {
		if (newSequence != sequence) {
			NotificationChain msgs = null;
			if (sequence != null)
				msgs = ((InternalEObject)sequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__SEQUENCE, null, msgs);
			if (newSequence != null)
				msgs = ((InternalEObject)newSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__SEQUENCE, null, msgs);
			msgs = basicSetSequence(newSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__SEQUENCE, newSequence, newSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPick getPick() {
		return pick;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPick(TPick newPick, NotificationChain msgs) {
		TPick oldPick = pick;
		pick = newPick;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__PICK, oldPick, newPick);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPick(TPick newPick) {
		if (newPick != pick) {
			NotificationChain msgs = null;
			if (pick != null)
				msgs = ((InternalEObject)pick).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__PICK, null, msgs);
			if (newPick != null)
				msgs = ((InternalEObject)newPick).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__PICK, null, msgs);
			msgs = basicSetPick(newPick, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__PICK, newPick, newPick));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TScope getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScope(TScope newScope, NotificationChain msgs) {
		TScope oldScope = scope;
		scope = newScope;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__SCOPE, oldScope, newScope);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(TScope newScope) {
		if (newScope != scope) {
			NotificationChain msgs = null;
			if (scope != null)
				msgs = ((InternalEObject)scope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__SCOPE, null, msgs);
			if (newScope != null)
				msgs = ((InternalEObject)newScope).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSCOPE__SCOPE, null, msgs);
			msgs = basicSetScope(newScope, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__SCOPE, newScope, newScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBoolean getVariableAccessSerializable() {
		return variableAccessSerializable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableAccessSerializable(TBoolean newVariableAccessSerializable) {
		TBoolean oldVariableAccessSerializable = variableAccessSerializable;
		variableAccessSerializable = newVariableAccessSerializable == null ? VARIABLE_ACCESS_SERIALIZABLE_EDEFAULT : newVariableAccessSerializable;
		boolean oldVariableAccessSerializableESet = variableAccessSerializableESet;
		variableAccessSerializableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSCOPE__VARIABLE_ACCESS_SERIALIZABLE, oldVariableAccessSerializable, variableAccessSerializable, !oldVariableAccessSerializableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVariableAccessSerializable() {
		TBoolean oldVariableAccessSerializable = variableAccessSerializable;
		boolean oldVariableAccessSerializableESet = variableAccessSerializableESet;
		variableAccessSerializable = VARIABLE_ACCESS_SERIALIZABLE_EDEFAULT;
		variableAccessSerializableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ProcessPackage.TSCOPE__VARIABLE_ACCESS_SERIALIZABLE, oldVariableAccessSerializable, VARIABLE_ACCESS_SERIALIZABLE_EDEFAULT, oldVariableAccessSerializableESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVariableAccessSerializable() {
		return variableAccessSerializableESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.TSCOPE__VARIABLES:
				return basicSetVariables(null, msgs);
			case ProcessPackage.TSCOPE__CORRELATION_SETS:
				return basicSetCorrelationSets(null, msgs);
			case ProcessPackage.TSCOPE__FAULT_HANDLERS:
				return basicSetFaultHandlers(null, msgs);
			case ProcessPackage.TSCOPE__COMPENSATION_HANDLER:
				return basicSetCompensationHandler(null, msgs);
			case ProcessPackage.TSCOPE__EVENT_HANDLERS:
				return basicSetEventHandlers(null, msgs);
			case ProcessPackage.TSCOPE__EMPTY:
				return basicSetEmpty(null, msgs);
			case ProcessPackage.TSCOPE__INVOKE:
				return basicSetInvoke(null, msgs);
			case ProcessPackage.TSCOPE__RECEIVE:
				return basicSetReceive(null, msgs);
			case ProcessPackage.TSCOPE__REPLY:
				return basicSetReply(null, msgs);
			case ProcessPackage.TSCOPE__ASSIGN:
				return basicSetAssign(null, msgs);
			case ProcessPackage.TSCOPE__WAIT:
				return basicSetWait(null, msgs);
			case ProcessPackage.TSCOPE__THROW:
				return basicSetThrow(null, msgs);
			case ProcessPackage.TSCOPE__TERMINATE:
				return basicSetTerminate(null, msgs);
			case ProcessPackage.TSCOPE__FLOW:
				return basicSetFlow(null, msgs);
			case ProcessPackage.TSCOPE__SWITCH:
				return basicSetSwitch(null, msgs);
			case ProcessPackage.TSCOPE__WHILE:
				return basicSetWhile(null, msgs);
			case ProcessPackage.TSCOPE__SEQUENCE:
				return basicSetSequence(null, msgs);
			case ProcessPackage.TSCOPE__PICK:
				return basicSetPick(null, msgs);
			case ProcessPackage.TSCOPE__SCOPE:
				return basicSetScope(null, msgs);
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
			case ProcessPackage.TSCOPE__VARIABLES:
				return getVariables();
			case ProcessPackage.TSCOPE__CORRELATION_SETS:
				return getCorrelationSets();
			case ProcessPackage.TSCOPE__FAULT_HANDLERS:
				return getFaultHandlers();
			case ProcessPackage.TSCOPE__COMPENSATION_HANDLER:
				return getCompensationHandler();
			case ProcessPackage.TSCOPE__EVENT_HANDLERS:
				return getEventHandlers();
			case ProcessPackage.TSCOPE__EMPTY:
				return getEmpty();
			case ProcessPackage.TSCOPE__INVOKE:
				return getInvoke();
			case ProcessPackage.TSCOPE__RECEIVE:
				return getReceive();
			case ProcessPackage.TSCOPE__REPLY:
				return getReply();
			case ProcessPackage.TSCOPE__ASSIGN:
				return getAssign();
			case ProcessPackage.TSCOPE__WAIT:
				return getWait();
			case ProcessPackage.TSCOPE__THROW:
				return getThrow();
			case ProcessPackage.TSCOPE__TERMINATE:
				return getTerminate();
			case ProcessPackage.TSCOPE__FLOW:
				return getFlow();
			case ProcessPackage.TSCOPE__SWITCH:
				return getSwitch();
			case ProcessPackage.TSCOPE__WHILE:
				return getWhile();
			case ProcessPackage.TSCOPE__SEQUENCE:
				return getSequence();
			case ProcessPackage.TSCOPE__PICK:
				return getPick();
			case ProcessPackage.TSCOPE__SCOPE:
				return getScope();
			case ProcessPackage.TSCOPE__VARIABLE_ACCESS_SERIALIZABLE:
				return getVariableAccessSerializable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ProcessPackage.TSCOPE__VARIABLES:
				setVariables((TVariables)newValue);
				return;
			case ProcessPackage.TSCOPE__CORRELATION_SETS:
				setCorrelationSets((TCorrelationSets)newValue);
				return;
			case ProcessPackage.TSCOPE__FAULT_HANDLERS:
				setFaultHandlers((TFaultHandlers)newValue);
				return;
			case ProcessPackage.TSCOPE__COMPENSATION_HANDLER:
				setCompensationHandler((TCompensationHandler)newValue);
				return;
			case ProcessPackage.TSCOPE__EVENT_HANDLERS:
				setEventHandlers((TEventHandlers)newValue);
				return;
			case ProcessPackage.TSCOPE__EMPTY:
				setEmpty((TEmpty)newValue);
				return;
			case ProcessPackage.TSCOPE__INVOKE:
				setInvoke((TInvoke)newValue);
				return;
			case ProcessPackage.TSCOPE__RECEIVE:
				setReceive((TReceive)newValue);
				return;
			case ProcessPackage.TSCOPE__REPLY:
				setReply((TReply)newValue);
				return;
			case ProcessPackage.TSCOPE__ASSIGN:
				setAssign((TAssign)newValue);
				return;
			case ProcessPackage.TSCOPE__WAIT:
				setWait((TWait)newValue);
				return;
			case ProcessPackage.TSCOPE__THROW:
				setThrow((TThrow)newValue);
				return;
			case ProcessPackage.TSCOPE__TERMINATE:
				setTerminate((TTerminate)newValue);
				return;
			case ProcessPackage.TSCOPE__FLOW:
				setFlow((TFlow)newValue);
				return;
			case ProcessPackage.TSCOPE__SWITCH:
				setSwitch((TSwitch)newValue);
				return;
			case ProcessPackage.TSCOPE__WHILE:
				setWhile((TWhile)newValue);
				return;
			case ProcessPackage.TSCOPE__SEQUENCE:
				setSequence((TSequence)newValue);
				return;
			case ProcessPackage.TSCOPE__PICK:
				setPick((TPick)newValue);
				return;
			case ProcessPackage.TSCOPE__SCOPE:
				setScope((TScope)newValue);
				return;
			case ProcessPackage.TSCOPE__VARIABLE_ACCESS_SERIALIZABLE:
				setVariableAccessSerializable((TBoolean)newValue);
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
			case ProcessPackage.TSCOPE__VARIABLES:
				setVariables((TVariables)null);
				return;
			case ProcessPackage.TSCOPE__CORRELATION_SETS:
				setCorrelationSets((TCorrelationSets)null);
				return;
			case ProcessPackage.TSCOPE__FAULT_HANDLERS:
				setFaultHandlers((TFaultHandlers)null);
				return;
			case ProcessPackage.TSCOPE__COMPENSATION_HANDLER:
				setCompensationHandler((TCompensationHandler)null);
				return;
			case ProcessPackage.TSCOPE__EVENT_HANDLERS:
				setEventHandlers((TEventHandlers)null);
				return;
			case ProcessPackage.TSCOPE__EMPTY:
				setEmpty((TEmpty)null);
				return;
			case ProcessPackage.TSCOPE__INVOKE:
				setInvoke((TInvoke)null);
				return;
			case ProcessPackage.TSCOPE__RECEIVE:
				setReceive((TReceive)null);
				return;
			case ProcessPackage.TSCOPE__REPLY:
				setReply((TReply)null);
				return;
			case ProcessPackage.TSCOPE__ASSIGN:
				setAssign((TAssign)null);
				return;
			case ProcessPackage.TSCOPE__WAIT:
				setWait((TWait)null);
				return;
			case ProcessPackage.TSCOPE__THROW:
				setThrow((TThrow)null);
				return;
			case ProcessPackage.TSCOPE__TERMINATE:
				setTerminate((TTerminate)null);
				return;
			case ProcessPackage.TSCOPE__FLOW:
				setFlow((TFlow)null);
				return;
			case ProcessPackage.TSCOPE__SWITCH:
				setSwitch((TSwitch)null);
				return;
			case ProcessPackage.TSCOPE__WHILE:
				setWhile((TWhile)null);
				return;
			case ProcessPackage.TSCOPE__SEQUENCE:
				setSequence((TSequence)null);
				return;
			case ProcessPackage.TSCOPE__PICK:
				setPick((TPick)null);
				return;
			case ProcessPackage.TSCOPE__SCOPE:
				setScope((TScope)null);
				return;
			case ProcessPackage.TSCOPE__VARIABLE_ACCESS_SERIALIZABLE:
				unsetVariableAccessSerializable();
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
			case ProcessPackage.TSCOPE__VARIABLES:
				return variables != null;
			case ProcessPackage.TSCOPE__CORRELATION_SETS:
				return correlationSets != null;
			case ProcessPackage.TSCOPE__FAULT_HANDLERS:
				return faultHandlers != null;
			case ProcessPackage.TSCOPE__COMPENSATION_HANDLER:
				return compensationHandler != null;
			case ProcessPackage.TSCOPE__EVENT_HANDLERS:
				return eventHandlers != null;
			case ProcessPackage.TSCOPE__EMPTY:
				return empty != null;
			case ProcessPackage.TSCOPE__INVOKE:
				return invoke != null;
			case ProcessPackage.TSCOPE__RECEIVE:
				return receive != null;
			case ProcessPackage.TSCOPE__REPLY:
				return reply != null;
			case ProcessPackage.TSCOPE__ASSIGN:
				return assign != null;
			case ProcessPackage.TSCOPE__WAIT:
				return wait != null;
			case ProcessPackage.TSCOPE__THROW:
				return throw_ != null;
			case ProcessPackage.TSCOPE__TERMINATE:
				return terminate != null;
			case ProcessPackage.TSCOPE__FLOW:
				return flow != null;
			case ProcessPackage.TSCOPE__SWITCH:
				return switch_ != null;
			case ProcessPackage.TSCOPE__WHILE:
				return while_ != null;
			case ProcessPackage.TSCOPE__SEQUENCE:
				return sequence != null;
			case ProcessPackage.TSCOPE__PICK:
				return pick != null;
			case ProcessPackage.TSCOPE__SCOPE:
				return scope != null;
			case ProcessPackage.TSCOPE__VARIABLE_ACCESS_SERIALIZABLE:
				return isSetVariableAccessSerializable();
		}
		return super.eIsSet(featureID);
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
		result.append(" (variableAccessSerializable: ");
		if (variableAccessSerializableESet) result.append(variableAccessSerializable); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setActivity(TActivity activity) {
		if (activity instanceof TAssign) {
			setAssign((TAssign) activity);
		}
		if (activity instanceof TEmpty) {
			setEmpty((TEmpty) activity);
		}
		if (activity instanceof TFlow) {
			setFlow((TFlow) activity);
		}
		if (activity instanceof TInvoke) {
			setInvoke((TInvoke) activity);
		}
		if (activity instanceof TPick) {
			setPick((TPick) activity);
		}
		if (activity instanceof TReceive) {
			setReceive((TReceive) activity);
		}
		if (activity instanceof TReply) {
			setReply((TReply) activity);
		}
		if (activity instanceof TScope) {
			setScope((TScope) activity);
		}
		if (activity instanceof TSequence) {
			setSequence((TSequence) activity);
		}
		if (activity instanceof TSwitch) {
			setSwitch((TSwitch) activity);
		}
		if (activity instanceof TTerminate) {
			setTerminate((TTerminate) activity);
		}
		if (activity instanceof TThrow) {
			setThrow((TThrow) activity);
		}
		if (activity instanceof TWait) {
			setWait((TWait) activity);
		}
		if (activity instanceof TWhile) {
			setWhile((TWhile) activity);
		}
	}


} //TScopeImpl