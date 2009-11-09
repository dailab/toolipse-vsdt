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
import org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty;
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
import org.xmlsoap.schemas.ws._2003._03.business.process.TWait;
import org.xmlsoap.schemas.ws._2003._03.business.process.TWhile;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TWhile</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getEmpty <em>Empty</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getInvoke <em>Invoke</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getReceive <em>Receive</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getReply <em>Reply</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getAssign <em>Assign</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getWait <em>Wait</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getThrow <em>Throw</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getTerminate <em>Terminate</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getFlow <em>Flow</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getWhile <em>While</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getPick <em>Pick</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TWhileImpl extends TActivityImpl implements TWhile {
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
	 * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected String condition = CONDITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TWhileImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TWHILE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__EMPTY, oldEmpty, newEmpty);
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
				msgs = ((InternalEObject)empty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__EMPTY, null, msgs);
			if (newEmpty != null)
				msgs = ((InternalEObject)newEmpty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__EMPTY, null, msgs);
			msgs = basicSetEmpty(newEmpty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__EMPTY, newEmpty, newEmpty));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__INVOKE, oldInvoke, newInvoke);
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
				msgs = ((InternalEObject)invoke).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__INVOKE, null, msgs);
			if (newInvoke != null)
				msgs = ((InternalEObject)newInvoke).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__INVOKE, null, msgs);
			msgs = basicSetInvoke(newInvoke, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__INVOKE, newInvoke, newInvoke));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__RECEIVE, oldReceive, newReceive);
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
				msgs = ((InternalEObject)receive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__RECEIVE, null, msgs);
			if (newReceive != null)
				msgs = ((InternalEObject)newReceive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__RECEIVE, null, msgs);
			msgs = basicSetReceive(newReceive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__RECEIVE, newReceive, newReceive));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__REPLY, oldReply, newReply);
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
				msgs = ((InternalEObject)reply).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__REPLY, null, msgs);
			if (newReply != null)
				msgs = ((InternalEObject)newReply).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__REPLY, null, msgs);
			msgs = basicSetReply(newReply, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__REPLY, newReply, newReply));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__ASSIGN, oldAssign, newAssign);
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
				msgs = ((InternalEObject)assign).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__ASSIGN, null, msgs);
			if (newAssign != null)
				msgs = ((InternalEObject)newAssign).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__ASSIGN, null, msgs);
			msgs = basicSetAssign(newAssign, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__ASSIGN, newAssign, newAssign));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__WAIT, oldWait, newWait);
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
				msgs = ((InternalEObject)wait).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__WAIT, null, msgs);
			if (newWait != null)
				msgs = ((InternalEObject)newWait).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__WAIT, null, msgs);
			msgs = basicSetWait(newWait, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__WAIT, newWait, newWait));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__THROW, oldThrow, newThrow);
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
				msgs = ((InternalEObject)throw_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__THROW, null, msgs);
			if (newThrow != null)
				msgs = ((InternalEObject)newThrow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__THROW, null, msgs);
			msgs = basicSetThrow(newThrow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__THROW, newThrow, newThrow));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__TERMINATE, oldTerminate, newTerminate);
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
				msgs = ((InternalEObject)terminate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__TERMINATE, null, msgs);
			if (newTerminate != null)
				msgs = ((InternalEObject)newTerminate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__TERMINATE, null, msgs);
			msgs = basicSetTerminate(newTerminate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__TERMINATE, newTerminate, newTerminate));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__FLOW, oldFlow, newFlow);
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
				msgs = ((InternalEObject)flow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__FLOW, null, msgs);
			if (newFlow != null)
				msgs = ((InternalEObject)newFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__FLOW, null, msgs);
			msgs = basicSetFlow(newFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__FLOW, newFlow, newFlow));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__SWITCH, oldSwitch, newSwitch);
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
				msgs = ((InternalEObject)switch_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__SWITCH, null, msgs);
			if (newSwitch != null)
				msgs = ((InternalEObject)newSwitch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__SWITCH, null, msgs);
			msgs = basicSetSwitch(newSwitch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__SWITCH, newSwitch, newSwitch));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__WHILE, oldWhile, newWhile);
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
				msgs = ((InternalEObject)while_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__WHILE, null, msgs);
			if (newWhile != null)
				msgs = ((InternalEObject)newWhile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__WHILE, null, msgs);
			msgs = basicSetWhile(newWhile, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__WHILE, newWhile, newWhile));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__SEQUENCE, oldSequence, newSequence);
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
				msgs = ((InternalEObject)sequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__SEQUENCE, null, msgs);
			if (newSequence != null)
				msgs = ((InternalEObject)newSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__SEQUENCE, null, msgs);
			msgs = basicSetSequence(newSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__SEQUENCE, newSequence, newSequence));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__PICK, oldPick, newPick);
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
				msgs = ((InternalEObject)pick).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__PICK, null, msgs);
			if (newPick != null)
				msgs = ((InternalEObject)newPick).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__PICK, null, msgs);
			msgs = basicSetPick(newPick, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__PICK, newPick, newPick));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__SCOPE, oldScope, newScope);
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
				msgs = ((InternalEObject)scope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__SCOPE, null, msgs);
			if (newScope != null)
				msgs = ((InternalEObject)newScope).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TWHILE__SCOPE, null, msgs);
			msgs = basicSetScope(newScope, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__SCOPE, newScope, newScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(String newCondition) {
		String oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TWHILE__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.TWHILE__EMPTY:
				return basicSetEmpty(null, msgs);
			case ProcessPackage.TWHILE__INVOKE:
				return basicSetInvoke(null, msgs);
			case ProcessPackage.TWHILE__RECEIVE:
				return basicSetReceive(null, msgs);
			case ProcessPackage.TWHILE__REPLY:
				return basicSetReply(null, msgs);
			case ProcessPackage.TWHILE__ASSIGN:
				return basicSetAssign(null, msgs);
			case ProcessPackage.TWHILE__WAIT:
				return basicSetWait(null, msgs);
			case ProcessPackage.TWHILE__THROW:
				return basicSetThrow(null, msgs);
			case ProcessPackage.TWHILE__TERMINATE:
				return basicSetTerminate(null, msgs);
			case ProcessPackage.TWHILE__FLOW:
				return basicSetFlow(null, msgs);
			case ProcessPackage.TWHILE__SWITCH:
				return basicSetSwitch(null, msgs);
			case ProcessPackage.TWHILE__WHILE:
				return basicSetWhile(null, msgs);
			case ProcessPackage.TWHILE__SEQUENCE:
				return basicSetSequence(null, msgs);
			case ProcessPackage.TWHILE__PICK:
				return basicSetPick(null, msgs);
			case ProcessPackage.TWHILE__SCOPE:
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
			case ProcessPackage.TWHILE__EMPTY:
				return getEmpty();
			case ProcessPackage.TWHILE__INVOKE:
				return getInvoke();
			case ProcessPackage.TWHILE__RECEIVE:
				return getReceive();
			case ProcessPackage.TWHILE__REPLY:
				return getReply();
			case ProcessPackage.TWHILE__ASSIGN:
				return getAssign();
			case ProcessPackage.TWHILE__WAIT:
				return getWait();
			case ProcessPackage.TWHILE__THROW:
				return getThrow();
			case ProcessPackage.TWHILE__TERMINATE:
				return getTerminate();
			case ProcessPackage.TWHILE__FLOW:
				return getFlow();
			case ProcessPackage.TWHILE__SWITCH:
				return getSwitch();
			case ProcessPackage.TWHILE__WHILE:
				return getWhile();
			case ProcessPackage.TWHILE__SEQUENCE:
				return getSequence();
			case ProcessPackage.TWHILE__PICK:
				return getPick();
			case ProcessPackage.TWHILE__SCOPE:
				return getScope();
			case ProcessPackage.TWHILE__CONDITION:
				return getCondition();
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
			case ProcessPackage.TWHILE__EMPTY:
				setEmpty((TEmpty)newValue);
				return;
			case ProcessPackage.TWHILE__INVOKE:
				setInvoke((TInvoke)newValue);
				return;
			case ProcessPackage.TWHILE__RECEIVE:
				setReceive((TReceive)newValue);
				return;
			case ProcessPackage.TWHILE__REPLY:
				setReply((TReply)newValue);
				return;
			case ProcessPackage.TWHILE__ASSIGN:
				setAssign((TAssign)newValue);
				return;
			case ProcessPackage.TWHILE__WAIT:
				setWait((TWait)newValue);
				return;
			case ProcessPackage.TWHILE__THROW:
				setThrow((TThrow)newValue);
				return;
			case ProcessPackage.TWHILE__TERMINATE:
				setTerminate((TTerminate)newValue);
				return;
			case ProcessPackage.TWHILE__FLOW:
				setFlow((TFlow)newValue);
				return;
			case ProcessPackage.TWHILE__SWITCH:
				setSwitch((TSwitch)newValue);
				return;
			case ProcessPackage.TWHILE__WHILE:
				setWhile((TWhile)newValue);
				return;
			case ProcessPackage.TWHILE__SEQUENCE:
				setSequence((TSequence)newValue);
				return;
			case ProcessPackage.TWHILE__PICK:
				setPick((TPick)newValue);
				return;
			case ProcessPackage.TWHILE__SCOPE:
				setScope((TScope)newValue);
				return;
			case ProcessPackage.TWHILE__CONDITION:
				setCondition((String)newValue);
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
			case ProcessPackage.TWHILE__EMPTY:
				setEmpty((TEmpty)null);
				return;
			case ProcessPackage.TWHILE__INVOKE:
				setInvoke((TInvoke)null);
				return;
			case ProcessPackage.TWHILE__RECEIVE:
				setReceive((TReceive)null);
				return;
			case ProcessPackage.TWHILE__REPLY:
				setReply((TReply)null);
				return;
			case ProcessPackage.TWHILE__ASSIGN:
				setAssign((TAssign)null);
				return;
			case ProcessPackage.TWHILE__WAIT:
				setWait((TWait)null);
				return;
			case ProcessPackage.TWHILE__THROW:
				setThrow((TThrow)null);
				return;
			case ProcessPackage.TWHILE__TERMINATE:
				setTerminate((TTerminate)null);
				return;
			case ProcessPackage.TWHILE__FLOW:
				setFlow((TFlow)null);
				return;
			case ProcessPackage.TWHILE__SWITCH:
				setSwitch((TSwitch)null);
				return;
			case ProcessPackage.TWHILE__WHILE:
				setWhile((TWhile)null);
				return;
			case ProcessPackage.TWHILE__SEQUENCE:
				setSequence((TSequence)null);
				return;
			case ProcessPackage.TWHILE__PICK:
				setPick((TPick)null);
				return;
			case ProcessPackage.TWHILE__SCOPE:
				setScope((TScope)null);
				return;
			case ProcessPackage.TWHILE__CONDITION:
				setCondition(CONDITION_EDEFAULT);
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
			case ProcessPackage.TWHILE__EMPTY:
				return empty != null;
			case ProcessPackage.TWHILE__INVOKE:
				return invoke != null;
			case ProcessPackage.TWHILE__RECEIVE:
				return receive != null;
			case ProcessPackage.TWHILE__REPLY:
				return reply != null;
			case ProcessPackage.TWHILE__ASSIGN:
				return assign != null;
			case ProcessPackage.TWHILE__WAIT:
				return wait != null;
			case ProcessPackage.TWHILE__THROW:
				return throw_ != null;
			case ProcessPackage.TWHILE__TERMINATE:
				return terminate != null;
			case ProcessPackage.TWHILE__FLOW:
				return flow != null;
			case ProcessPackage.TWHILE__SWITCH:
				return switch_ != null;
			case ProcessPackage.TWHILE__WHILE:
				return while_ != null;
			case ProcessPackage.TWHILE__SEQUENCE:
				return sequence != null;
			case ProcessPackage.TWHILE__PICK:
				return pick != null;
			case ProcessPackage.TWHILE__SCOPE:
				return scope != null;
			case ProcessPackage.TWHILE__CONDITION:
				return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
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
		result.append(" (condition: ");
		result.append(condition);
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


} //TWhileImpl