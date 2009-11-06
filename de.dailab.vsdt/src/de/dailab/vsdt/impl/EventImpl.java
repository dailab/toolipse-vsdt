/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.End;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getTimeDate <em>Time Date</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getTimeCycle <em>Time Cycle</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getRuleName <em>Rule Name</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getRuleExpression <em>Rule Expression</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getErrorCode <em>Error Code</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getSignal <em>Signal</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getLinkedTo <em>Linked To</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EventImpl extends FlowObjectImpl implements Event {
	/**
	 * The default value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected static final TriggerType TRIGGER_EDEFAULT = TriggerType.NONE;
	/**
	 * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrigger()
	 * @generated
	 * @ordered
	 */
	protected TriggerType trigger = TRIGGER_EDEFAULT;
	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected Message message;
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
	 * The cached value of the '{@link #getTimeDate() <em>Time Date</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeDate()
	 * @generated
	 * @ordered
	 */
	protected Expression timeDate;
	/**
	 * The cached value of the '{@link #getTimeCycle() <em>Time Cycle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeCycle()
	 * @generated
	 * @ordered
	 */
	protected Expression timeCycle;
	/**
	 * The default value of the '{@link #getRuleName() <em>Rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleName()
	 * @generated
	 * @ordered
	 */
	protected static final String RULE_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRuleName() <em>Rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleName()
	 * @generated
	 * @ordered
	 */
	protected String ruleName = RULE_NAME_EDEFAULT;
	/**
	 * The cached value of the '{@link #getRuleExpression() <em>Rule Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression ruleExpression;
	/**
	 * The default value of the '{@link #getErrorCode() <em>Error Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorCode()
	 * @generated
	 * @ordered
	 */
	protected static final String ERROR_CODE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getErrorCode() <em>Error Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrorCode()
	 * @generated
	 * @ordered
	 */
	protected String errorCode = ERROR_CODE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected Activity activity;
	/**
	 * The default value of the '{@link #getSignal() <em>Signal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignal()
	 * @generated
	 * @ordered
	 */
	protected static final String SIGNAL_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSignal() <em>Signal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignal()
	 * @generated
	 * @ordered
	 */
	protected String signal = SIGNAL_EDEFAULT;
	/**
	 * The cached value of the '{@link #getLinkedTo() <em>Linked To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkedTo()
	 * @generated
	 * @ordered
	 */
	protected Event linkedTo;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TriggerType getTrigger() {
		return trigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrigger(TriggerType newTrigger) {
		TriggerType oldTrigger = trigger;
		trigger = newTrigger == null ? TRIGGER_EDEFAULT : newTrigger;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__TRIGGER, oldTrigger, trigger));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getMessage() {
		if (message != null && message.eIsProxy()) {
			InternalEObject oldMessage = (InternalEObject)message;
			message = (Message)eResolveProxy(oldMessage);
			if (message != oldMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.EVENT__MESSAGE, oldMessage, message));
			}
		}
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(Message newMessage) {
		Message oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__MESSAGE, oldMessage, message));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.EVENT__IMPLEMENTATION, oldImplementation, implementation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__IMPLEMENTATION, oldImplementation, implementation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTimeDate() {
		return timeDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeDate(Expression newTimeDate, NotificationChain msgs) {
		Expression oldTimeDate = timeDate;
		timeDate = newTimeDate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__TIME_DATE, oldTimeDate, newTimeDate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeDate(Expression newTimeDate) {
		if (newTimeDate != timeDate) {
			NotificationChain msgs = null;
			if (timeDate != null)
				msgs = ((InternalEObject)timeDate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.EVENT__TIME_DATE, null, msgs);
			if (newTimeDate != null)
				msgs = ((InternalEObject)newTimeDate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.EVENT__TIME_DATE, null, msgs);
			msgs = basicSetTimeDate(newTimeDate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__TIME_DATE, newTimeDate, newTimeDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTimeCycle() {
		return timeCycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeCycle(Expression newTimeCycle, NotificationChain msgs) {
		Expression oldTimeCycle = timeCycle;
		timeCycle = newTimeCycle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__TIME_CYCLE, oldTimeCycle, newTimeCycle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeCycle(Expression newTimeCycle) {
		if (newTimeCycle != timeCycle) {
			NotificationChain msgs = null;
			if (timeCycle != null)
				msgs = ((InternalEObject)timeCycle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.EVENT__TIME_CYCLE, null, msgs);
			if (newTimeCycle != null)
				msgs = ((InternalEObject)newTimeCycle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.EVENT__TIME_CYCLE, null, msgs);
			msgs = basicSetTimeCycle(newTimeCycle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__TIME_CYCLE, newTimeCycle, newTimeCycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRuleName() {
		return ruleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleName(String newRuleName) {
		String oldRuleName = ruleName;
		ruleName = newRuleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__RULE_NAME, oldRuleName, ruleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRuleExpression() {
		return ruleExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRuleExpression(Expression newRuleExpression, NotificationChain msgs) {
		Expression oldRuleExpression = ruleExpression;
		ruleExpression = newRuleExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__RULE_EXPRESSION, oldRuleExpression, newRuleExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRuleExpression(Expression newRuleExpression) {
		if (newRuleExpression != ruleExpression) {
			NotificationChain msgs = null;
			if (ruleExpression != null)
				msgs = ((InternalEObject)ruleExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.EVENT__RULE_EXPRESSION, null, msgs);
			if (newRuleExpression != null)
				msgs = ((InternalEObject)newRuleExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.EVENT__RULE_EXPRESSION, null, msgs);
			msgs = basicSetRuleExpression(newRuleExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__RULE_EXPRESSION, newRuleExpression, newRuleExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setErrorCode(String newErrorCode) {
		String oldErrorCode = errorCode;
		errorCode = newErrorCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__ERROR_CODE, oldErrorCode, errorCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getActivity() {
		if (activity != null && activity.eIsProxy()) {
			InternalEObject oldActivity = (InternalEObject)activity;
			activity = (Activity)eResolveProxy(oldActivity);
			if (activity != oldActivity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.EVENT__ACTIVITY, oldActivity, activity));
			}
		}
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity basicGetActivity() {
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivity(Activity newActivity) {
		Activity oldActivity = activity;
		activity = newActivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__ACTIVITY, oldActivity, activity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSignal() {
		return signal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignal(String newSignal) {
		String oldSignal = signal;
		signal = newSignal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__SIGNAL, oldSignal, signal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getLinkedTo() {
		if (linkedTo != null && linkedTo.eIsProxy()) {
			InternalEObject oldLinkedTo = (InternalEObject)linkedTo;
			linkedTo = (Event)eResolveProxy(oldLinkedTo);
			if (linkedTo != oldLinkedTo) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.EVENT__LINKED_TO, oldLinkedTo, linkedTo));
			}
		}
		return linkedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event basicGetLinkedTo() {
		return linkedTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * added self-opposite behavior
	 * FIXME: doesn't work; is reset to null on reloading the diagram
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setLinkedTo(Event newLinkedTo) {
		Event oldLinkedTo = linkedTo;
		linkedTo = newLinkedTo;
		
//		if (newLinkedTo != null && newLinkedTo.getLinkedTo() != this) {
//			newLinkedTo.setLinkedTo(this);
//		}
//		if (oldLinkedTo != null) {
//			oldLinkedTo.setLinkedTo(null);
//		}
		
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__LINKED_TO, oldLinkedTo, linkedTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method returns the trigger types that may be used for this event in the
	 * context it is used in. The trigger type depends on the event's type (Start, End,
	 * Intermediate), and in case of Intermediate whether it is attached to an activity
	 * and whether it is throwing or catching.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<TriggerType> getValidTriggerTypes() {
		EList<TriggerType> triggers= new BasicEList<TriggerType>();
		triggers.add(TriggerType.NONE);
		triggers.add(TriggerType.MESSAGE);
		triggers.add(TriggerType.MULTIPLE);
		triggers.add(TriggerType.SIGNAL);
		if (this instanceof Start) {
			triggers.add(TriggerType.TIMER);
			triggers.add(TriggerType.RULE);
		}
		if (this instanceof Intermediate) {
			if (! this.isThrowing()) {
				triggers.add(TriggerType.TIMER);
				triggers.add(TriggerType.RULE);
			}
			if (((Intermediate) this).getAttachedTo() != null) {
				triggers.add(TriggerType.CANCEL);
				triggers.add(TriggerType.ERROR);
				triggers.add(TriggerType.COMPENSATION);
			} else {
				triggers.add(TriggerType.LINK);
			}
		}
		if (this instanceof End) {
			triggers.add(TriggerType.ERROR);
			triggers.add(TriggerType.CANCEL);
			triggers.add(TriggerType.COMPENSATION);
			triggers.add(TriggerType.TERMINATE);
		}
		return triggers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns whether this event is throwing or catching. Start events are always catching,
	 * End events are always throwing. Intermediate events are always catching, if attached
	 * to an activity. Ambiguities exist in the case of Message and Signal trigger. In the first
	 * case, the Message's participant can be taken into account. The default is false.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isThrowing() {
		if (this instanceof Start) {
			return false;
		}
		if (this instanceof End) {
			return true;			
		}
		if (this instanceof Intermediate) {
			if (((Intermediate)this).getAttachedTo() != null) {
				return false;
			}
			if (getTrigger()==TriggerType.MESSAGE) {
				if (! getOutgoingMsg().isEmpty()) {
					return true;
				}
				if (! getIncomingMsg().isEmpty()) {
					return false;
				}
//				if (getImplementation() != null && getPool() != null) { // could be a reply
//					return getImplementation().getParticipant() != getPool().getParticipant();
//				}
//				if (getMessage() != null && getMessage().getFrom() != null && getPool() != null) {
//					return getMessage().getFrom() == getPool().getParticipant();
//				}
			}
			boolean b=! isStartingNode() && isEndingNode(); //defaults to false, if event has no sequence flows at all
			return b;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.EVENT__TIME_DATE:
				return basicSetTimeDate(null, msgs);
			case VsdtPackage.EVENT__TIME_CYCLE:
				return basicSetTimeCycle(null, msgs);
			case VsdtPackage.EVENT__RULE_EXPRESSION:
				return basicSetRuleExpression(null, msgs);
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
			case VsdtPackage.EVENT__TRIGGER:
				return getTrigger();
			case VsdtPackage.EVENT__MESSAGE:
				if (resolve) return getMessage();
				return basicGetMessage();
			case VsdtPackage.EVENT__IMPLEMENTATION:
				if (resolve) return getImplementation();
				return basicGetImplementation();
			case VsdtPackage.EVENT__TIME_DATE:
				return getTimeDate();
			case VsdtPackage.EVENT__TIME_CYCLE:
				return getTimeCycle();
			case VsdtPackage.EVENT__RULE_NAME:
				return getRuleName();
			case VsdtPackage.EVENT__RULE_EXPRESSION:
				return getRuleExpression();
			case VsdtPackage.EVENT__ERROR_CODE:
				return getErrorCode();
			case VsdtPackage.EVENT__ACTIVITY:
				if (resolve) return getActivity();
				return basicGetActivity();
			case VsdtPackage.EVENT__SIGNAL:
				return getSignal();
			case VsdtPackage.EVENT__LINKED_TO:
				if (resolve) return getLinkedTo();
				return basicGetLinkedTo();
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
			case VsdtPackage.EVENT__TRIGGER:
				setTrigger((TriggerType)newValue);
				return;
			case VsdtPackage.EVENT__MESSAGE:
				setMessage((Message)newValue);
				return;
			case VsdtPackage.EVENT__IMPLEMENTATION:
				setImplementation((Implementation)newValue);
				return;
			case VsdtPackage.EVENT__TIME_DATE:
				setTimeDate((Expression)newValue);
				return;
			case VsdtPackage.EVENT__TIME_CYCLE:
				setTimeCycle((Expression)newValue);
				return;
			case VsdtPackage.EVENT__RULE_NAME:
				setRuleName((String)newValue);
				return;
			case VsdtPackage.EVENT__RULE_EXPRESSION:
				setRuleExpression((Expression)newValue);
				return;
			case VsdtPackage.EVENT__ERROR_CODE:
				setErrorCode((String)newValue);
				return;
			case VsdtPackage.EVENT__ACTIVITY:
				setActivity((Activity)newValue);
				return;
			case VsdtPackage.EVENT__SIGNAL:
				setSignal((String)newValue);
				return;
			case VsdtPackage.EVENT__LINKED_TO:
				setLinkedTo((Event)newValue);
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
			case VsdtPackage.EVENT__TRIGGER:
				setTrigger(TRIGGER_EDEFAULT);
				return;
			case VsdtPackage.EVENT__MESSAGE:
				setMessage((Message)null);
				return;
			case VsdtPackage.EVENT__IMPLEMENTATION:
				setImplementation((Implementation)null);
				return;
			case VsdtPackage.EVENT__TIME_DATE:
				setTimeDate((Expression)null);
				return;
			case VsdtPackage.EVENT__TIME_CYCLE:
				setTimeCycle((Expression)null);
				return;
			case VsdtPackage.EVENT__RULE_NAME:
				setRuleName(RULE_NAME_EDEFAULT);
				return;
			case VsdtPackage.EVENT__RULE_EXPRESSION:
				setRuleExpression((Expression)null);
				return;
			case VsdtPackage.EVENT__ERROR_CODE:
				setErrorCode(ERROR_CODE_EDEFAULT);
				return;
			case VsdtPackage.EVENT__ACTIVITY:
				setActivity((Activity)null);
				return;
			case VsdtPackage.EVENT__SIGNAL:
				setSignal(SIGNAL_EDEFAULT);
				return;
			case VsdtPackage.EVENT__LINKED_TO:
				setLinkedTo((Event)null);
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
			case VsdtPackage.EVENT__TRIGGER:
				return trigger != TRIGGER_EDEFAULT;
			case VsdtPackage.EVENT__MESSAGE:
				return message != null;
			case VsdtPackage.EVENT__IMPLEMENTATION:
				return implementation != null;
			case VsdtPackage.EVENT__TIME_DATE:
				return timeDate != null;
			case VsdtPackage.EVENT__TIME_CYCLE:
				return timeCycle != null;
			case VsdtPackage.EVENT__RULE_NAME:
				return RULE_NAME_EDEFAULT == null ? ruleName != null : !RULE_NAME_EDEFAULT.equals(ruleName);
			case VsdtPackage.EVENT__RULE_EXPRESSION:
				return ruleExpression != null;
			case VsdtPackage.EVENT__ERROR_CODE:
				return ERROR_CODE_EDEFAULT == null ? errorCode != null : !ERROR_CODE_EDEFAULT.equals(errorCode);
			case VsdtPackage.EVENT__ACTIVITY:
				return activity != null;
			case VsdtPackage.EVENT__SIGNAL:
				return SIGNAL_EDEFAULT == null ? signal != null : !SIGNAL_EDEFAULT.equals(signal);
			case VsdtPackage.EVENT__LINKED_TO:
				return linkedTo != null;
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
		result.append(" (trigger: ");
		result.append(trigger);
		result.append(", ruleName: ");
		result.append(ruleName);
		result.append(", errorCode: ");
		result.append(errorCode);
		result.append(", signal: ");
		result.append(signal);
		result.append(')');
		return result.toString();
	}

} //EventImpl
