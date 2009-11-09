/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process.impl;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivity;
import org.xmlsoap.schemas.ws._2003._03.business.process.TAssign;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelations;
import org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFlow;
import org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke;
import org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage;
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
 * An implementation of the model object '<em><b>TOn Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getCorrelations <em>Correlations</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getEmpty <em>Empty</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getInvoke <em>Invoke</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getReceive <em>Receive</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getReply <em>Reply</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getAssign <em>Assign</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getWait <em>Wait</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getThrow <em>Throw</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getTerminate <em>Terminate</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getFlow <em>Flow</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getWhile <em>While</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getPick <em>Pick</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getPortType <em>Port Type</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TOnMessageImpl extends TExtensibleElementsImpl implements TOnMessage {
	/**
	 * The cached value of the '{@link #getCorrelations() <em>Correlations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelations()
	 * @generated
	 * @ordered
	 */
	protected TCorrelations correlations;

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
	 * The default value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected String operation = OPERATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPartnerLink() <em>Partner Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerLink()
	 * @generated
	 * @ordered
	 */
	protected static final String PARTNER_LINK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartnerLink() <em>Partner Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerLink()
	 * @generated
	 * @ordered
	 */
	protected String partnerLink = PARTNER_LINK_EDEFAULT;

	/**
	 * The default value of the '{@link #getPortType() <em>Port Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortType()
	 * @generated
	 * @ordered
	 */
	protected static final QName PORT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPortType() <em>Port Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortType()
	 * @generated
	 * @ordered
	 */
	protected QName portType = PORT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVariable() <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected String variable = VARIABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TOnMessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TON_MESSAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCorrelations getCorrelations() {
		return correlations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCorrelations(TCorrelations newCorrelations, NotificationChain msgs) {
		TCorrelations oldCorrelations = correlations;
		correlations = newCorrelations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__CORRELATIONS, oldCorrelations, newCorrelations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrelations(TCorrelations newCorrelations) {
		if (newCorrelations != correlations) {
			NotificationChain msgs = null;
			if (correlations != null)
				msgs = ((InternalEObject)correlations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__CORRELATIONS, null, msgs);
			if (newCorrelations != null)
				msgs = ((InternalEObject)newCorrelations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__CORRELATIONS, null, msgs);
			msgs = basicSetCorrelations(newCorrelations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__CORRELATIONS, newCorrelations, newCorrelations));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__EMPTY, oldEmpty, newEmpty);
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
				msgs = ((InternalEObject)empty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__EMPTY, null, msgs);
			if (newEmpty != null)
				msgs = ((InternalEObject)newEmpty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__EMPTY, null, msgs);
			msgs = basicSetEmpty(newEmpty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__EMPTY, newEmpty, newEmpty));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__INVOKE, oldInvoke, newInvoke);
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
				msgs = ((InternalEObject)invoke).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__INVOKE, null, msgs);
			if (newInvoke != null)
				msgs = ((InternalEObject)newInvoke).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__INVOKE, null, msgs);
			msgs = basicSetInvoke(newInvoke, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__INVOKE, newInvoke, newInvoke));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__RECEIVE, oldReceive, newReceive);
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
				msgs = ((InternalEObject)receive).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__RECEIVE, null, msgs);
			if (newReceive != null)
				msgs = ((InternalEObject)newReceive).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__RECEIVE, null, msgs);
			msgs = basicSetReceive(newReceive, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__RECEIVE, newReceive, newReceive));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__REPLY, oldReply, newReply);
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
				msgs = ((InternalEObject)reply).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__REPLY, null, msgs);
			if (newReply != null)
				msgs = ((InternalEObject)newReply).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__REPLY, null, msgs);
			msgs = basicSetReply(newReply, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__REPLY, newReply, newReply));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__ASSIGN, oldAssign, newAssign);
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
				msgs = ((InternalEObject)assign).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__ASSIGN, null, msgs);
			if (newAssign != null)
				msgs = ((InternalEObject)newAssign).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__ASSIGN, null, msgs);
			msgs = basicSetAssign(newAssign, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__ASSIGN, newAssign, newAssign));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__WAIT, oldWait, newWait);
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
				msgs = ((InternalEObject)wait).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__WAIT, null, msgs);
			if (newWait != null)
				msgs = ((InternalEObject)newWait).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__WAIT, null, msgs);
			msgs = basicSetWait(newWait, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__WAIT, newWait, newWait));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__THROW, oldThrow, newThrow);
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
				msgs = ((InternalEObject)throw_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__THROW, null, msgs);
			if (newThrow != null)
				msgs = ((InternalEObject)newThrow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__THROW, null, msgs);
			msgs = basicSetThrow(newThrow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__THROW, newThrow, newThrow));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__TERMINATE, oldTerminate, newTerminate);
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
				msgs = ((InternalEObject)terminate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__TERMINATE, null, msgs);
			if (newTerminate != null)
				msgs = ((InternalEObject)newTerminate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__TERMINATE, null, msgs);
			msgs = basicSetTerminate(newTerminate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__TERMINATE, newTerminate, newTerminate));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__FLOW, oldFlow, newFlow);
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
				msgs = ((InternalEObject)flow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__FLOW, null, msgs);
			if (newFlow != null)
				msgs = ((InternalEObject)newFlow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__FLOW, null, msgs);
			msgs = basicSetFlow(newFlow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__FLOW, newFlow, newFlow));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__SWITCH, oldSwitch, newSwitch);
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
				msgs = ((InternalEObject)switch_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__SWITCH, null, msgs);
			if (newSwitch != null)
				msgs = ((InternalEObject)newSwitch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__SWITCH, null, msgs);
			msgs = basicSetSwitch(newSwitch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__SWITCH, newSwitch, newSwitch));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__WHILE, oldWhile, newWhile);
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
				msgs = ((InternalEObject)while_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__WHILE, null, msgs);
			if (newWhile != null)
				msgs = ((InternalEObject)newWhile).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__WHILE, null, msgs);
			msgs = basicSetWhile(newWhile, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__WHILE, newWhile, newWhile));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__SEQUENCE, oldSequence, newSequence);
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
				msgs = ((InternalEObject)sequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__SEQUENCE, null, msgs);
			if (newSequence != null)
				msgs = ((InternalEObject)newSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__SEQUENCE, null, msgs);
			msgs = basicSetSequence(newSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__SEQUENCE, newSequence, newSequence));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__PICK, oldPick, newPick);
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
				msgs = ((InternalEObject)pick).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__PICK, null, msgs);
			if (newPick != null)
				msgs = ((InternalEObject)newPick).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__PICK, null, msgs);
			msgs = basicSetPick(newPick, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__PICK, newPick, newPick));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__SCOPE, oldScope, newScope);
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
				msgs = ((InternalEObject)scope).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__SCOPE, null, msgs);
			if (newScope != null)
				msgs = ((InternalEObject)newScope).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TON_MESSAGE__SCOPE, null, msgs);
			msgs = basicSetScope(newScope, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__SCOPE, newScope, newScope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(String newOperation) {
		String oldOperation = operation;
		operation = newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPartnerLink() {
		return partnerLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartnerLink(String newPartnerLink) {
		String oldPartnerLink = partnerLink;
		partnerLink = newPartnerLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__PARTNER_LINK, oldPartnerLink, partnerLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getPortType() {
		return portType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPortType(QName newPortType) {
		QName oldPortType = portType;
		portType = newPortType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__PORT_TYPE, oldPortType, portType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariable(String newVariable) {
		String oldVariable = variable;
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TON_MESSAGE__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.TON_MESSAGE__CORRELATIONS:
				return basicSetCorrelations(null, msgs);
			case ProcessPackage.TON_MESSAGE__EMPTY:
				return basicSetEmpty(null, msgs);
			case ProcessPackage.TON_MESSAGE__INVOKE:
				return basicSetInvoke(null, msgs);
			case ProcessPackage.TON_MESSAGE__RECEIVE:
				return basicSetReceive(null, msgs);
			case ProcessPackage.TON_MESSAGE__REPLY:
				return basicSetReply(null, msgs);
			case ProcessPackage.TON_MESSAGE__ASSIGN:
				return basicSetAssign(null, msgs);
			case ProcessPackage.TON_MESSAGE__WAIT:
				return basicSetWait(null, msgs);
			case ProcessPackage.TON_MESSAGE__THROW:
				return basicSetThrow(null, msgs);
			case ProcessPackage.TON_MESSAGE__TERMINATE:
				return basicSetTerminate(null, msgs);
			case ProcessPackage.TON_MESSAGE__FLOW:
				return basicSetFlow(null, msgs);
			case ProcessPackage.TON_MESSAGE__SWITCH:
				return basicSetSwitch(null, msgs);
			case ProcessPackage.TON_MESSAGE__WHILE:
				return basicSetWhile(null, msgs);
			case ProcessPackage.TON_MESSAGE__SEQUENCE:
				return basicSetSequence(null, msgs);
			case ProcessPackage.TON_MESSAGE__PICK:
				return basicSetPick(null, msgs);
			case ProcessPackage.TON_MESSAGE__SCOPE:
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
			case ProcessPackage.TON_MESSAGE__CORRELATIONS:
				return getCorrelations();
			case ProcessPackage.TON_MESSAGE__EMPTY:
				return getEmpty();
			case ProcessPackage.TON_MESSAGE__INVOKE:
				return getInvoke();
			case ProcessPackage.TON_MESSAGE__RECEIVE:
				return getReceive();
			case ProcessPackage.TON_MESSAGE__REPLY:
				return getReply();
			case ProcessPackage.TON_MESSAGE__ASSIGN:
				return getAssign();
			case ProcessPackage.TON_MESSAGE__WAIT:
				return getWait();
			case ProcessPackage.TON_MESSAGE__THROW:
				return getThrow();
			case ProcessPackage.TON_MESSAGE__TERMINATE:
				return getTerminate();
			case ProcessPackage.TON_MESSAGE__FLOW:
				return getFlow();
			case ProcessPackage.TON_MESSAGE__SWITCH:
				return getSwitch();
			case ProcessPackage.TON_MESSAGE__WHILE:
				return getWhile();
			case ProcessPackage.TON_MESSAGE__SEQUENCE:
				return getSequence();
			case ProcessPackage.TON_MESSAGE__PICK:
				return getPick();
			case ProcessPackage.TON_MESSAGE__SCOPE:
				return getScope();
			case ProcessPackage.TON_MESSAGE__OPERATION:
				return getOperation();
			case ProcessPackage.TON_MESSAGE__PARTNER_LINK:
				return getPartnerLink();
			case ProcessPackage.TON_MESSAGE__PORT_TYPE:
				return getPortType();
			case ProcessPackage.TON_MESSAGE__VARIABLE:
				return getVariable();
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
			case ProcessPackage.TON_MESSAGE__CORRELATIONS:
				setCorrelations((TCorrelations)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__EMPTY:
				setEmpty((TEmpty)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__INVOKE:
				setInvoke((TInvoke)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__RECEIVE:
				setReceive((TReceive)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__REPLY:
				setReply((TReply)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__ASSIGN:
				setAssign((TAssign)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__WAIT:
				setWait((TWait)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__THROW:
				setThrow((TThrow)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__TERMINATE:
				setTerminate((TTerminate)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__FLOW:
				setFlow((TFlow)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__SWITCH:
				setSwitch((TSwitch)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__WHILE:
				setWhile((TWhile)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__SEQUENCE:
				setSequence((TSequence)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__PICK:
				setPick((TPick)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__SCOPE:
				setScope((TScope)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__OPERATION:
				setOperation((String)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__PARTNER_LINK:
				setPartnerLink((String)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__PORT_TYPE:
				setPortType((QName)newValue);
				return;
			case ProcessPackage.TON_MESSAGE__VARIABLE:
				setVariable((String)newValue);
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
			case ProcessPackage.TON_MESSAGE__CORRELATIONS:
				setCorrelations((TCorrelations)null);
				return;
			case ProcessPackage.TON_MESSAGE__EMPTY:
				setEmpty((TEmpty)null);
				return;
			case ProcessPackage.TON_MESSAGE__INVOKE:
				setInvoke((TInvoke)null);
				return;
			case ProcessPackage.TON_MESSAGE__RECEIVE:
				setReceive((TReceive)null);
				return;
			case ProcessPackage.TON_MESSAGE__REPLY:
				setReply((TReply)null);
				return;
			case ProcessPackage.TON_MESSAGE__ASSIGN:
				setAssign((TAssign)null);
				return;
			case ProcessPackage.TON_MESSAGE__WAIT:
				setWait((TWait)null);
				return;
			case ProcessPackage.TON_MESSAGE__THROW:
				setThrow((TThrow)null);
				return;
			case ProcessPackage.TON_MESSAGE__TERMINATE:
				setTerminate((TTerminate)null);
				return;
			case ProcessPackage.TON_MESSAGE__FLOW:
				setFlow((TFlow)null);
				return;
			case ProcessPackage.TON_MESSAGE__SWITCH:
				setSwitch((TSwitch)null);
				return;
			case ProcessPackage.TON_MESSAGE__WHILE:
				setWhile((TWhile)null);
				return;
			case ProcessPackage.TON_MESSAGE__SEQUENCE:
				setSequence((TSequence)null);
				return;
			case ProcessPackage.TON_MESSAGE__PICK:
				setPick((TPick)null);
				return;
			case ProcessPackage.TON_MESSAGE__SCOPE:
				setScope((TScope)null);
				return;
			case ProcessPackage.TON_MESSAGE__OPERATION:
				setOperation(OPERATION_EDEFAULT);
				return;
			case ProcessPackage.TON_MESSAGE__PARTNER_LINK:
				setPartnerLink(PARTNER_LINK_EDEFAULT);
				return;
			case ProcessPackage.TON_MESSAGE__PORT_TYPE:
				setPortType(PORT_TYPE_EDEFAULT);
				return;
			case ProcessPackage.TON_MESSAGE__VARIABLE:
				setVariable(VARIABLE_EDEFAULT);
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
			case ProcessPackage.TON_MESSAGE__CORRELATIONS:
				return correlations != null;
			case ProcessPackage.TON_MESSAGE__EMPTY:
				return empty != null;
			case ProcessPackage.TON_MESSAGE__INVOKE:
				return invoke != null;
			case ProcessPackage.TON_MESSAGE__RECEIVE:
				return receive != null;
			case ProcessPackage.TON_MESSAGE__REPLY:
				return reply != null;
			case ProcessPackage.TON_MESSAGE__ASSIGN:
				return assign != null;
			case ProcessPackage.TON_MESSAGE__WAIT:
				return wait != null;
			case ProcessPackage.TON_MESSAGE__THROW:
				return throw_ != null;
			case ProcessPackage.TON_MESSAGE__TERMINATE:
				return terminate != null;
			case ProcessPackage.TON_MESSAGE__FLOW:
				return flow != null;
			case ProcessPackage.TON_MESSAGE__SWITCH:
				return switch_ != null;
			case ProcessPackage.TON_MESSAGE__WHILE:
				return while_ != null;
			case ProcessPackage.TON_MESSAGE__SEQUENCE:
				return sequence != null;
			case ProcessPackage.TON_MESSAGE__PICK:
				return pick != null;
			case ProcessPackage.TON_MESSAGE__SCOPE:
				return scope != null;
			case ProcessPackage.TON_MESSAGE__OPERATION:
				return OPERATION_EDEFAULT == null ? operation != null : !OPERATION_EDEFAULT.equals(operation);
			case ProcessPackage.TON_MESSAGE__PARTNER_LINK:
				return PARTNER_LINK_EDEFAULT == null ? partnerLink != null : !PARTNER_LINK_EDEFAULT.equals(partnerLink);
			case ProcessPackage.TON_MESSAGE__PORT_TYPE:
				return PORT_TYPE_EDEFAULT == null ? portType != null : !PORT_TYPE_EDEFAULT.equals(portType);
			case ProcessPackage.TON_MESSAGE__VARIABLE:
				return VARIABLE_EDEFAULT == null ? variable != null : !VARIABLE_EDEFAULT.equals(variable);
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
		result.append(" (operation: ");
		result.append(operation);
		result.append(", partnerLink: ");
		result.append(partnerLink);
		result.append(", portType: ");
		result.append(portType);
		result.append(", variable: ");
		result.append(variable);
		result.append(')');
		return result.toString();
	}

	/**
	 * @param tActivity	some concrete activity
	 * @return			the list for the given activity
	 * @generated NOT
	 */
	public void setActivity(TActivity tActivity) {
		if (tActivity instanceof TAssign) {
			setAssign((TAssign)tActivity);
		}
		if (tActivity instanceof TEmpty) {
			setEmpty((TEmpty)tActivity);
		}
		if (tActivity instanceof TFlow) {
			setFlow((TFlow)tActivity);
		}
		if (tActivity instanceof TInvoke) {
			setInvoke((TInvoke)tActivity);
		}
		if (tActivity instanceof TReceive) {
			setReceive((TReceive)tActivity);
		}
		if (tActivity instanceof TReply) {
			setReply((TReply)tActivity);
		}
		if (tActivity instanceof TScope) {
			setScope((TScope)tActivity);
		}
		if (tActivity instanceof TSequence) {
			setSequence((TSequence)tActivity);
		}
		if (tActivity instanceof TSwitch) {
			setSwitch((TSwitch)tActivity);
		}
		if (tActivity instanceof TTerminate) {
			setTerminate((TTerminate)tActivity);
		}
		if (tActivity instanceof TThrow) {
			setThrow((TThrow)tActivity);
		}
		if (tActivity instanceof TWait) {
			setWait((TWait)tActivity);
		}
		if (tActivity instanceof TWhile) {
			setWhile((TWhile)tActivity);
		}
	}


} //TOnMessageImpl