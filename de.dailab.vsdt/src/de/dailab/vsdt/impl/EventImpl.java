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
import de.dailab.vsdt.Start;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#isNonInterrupting <em>Non Interrupting</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getTimeExpression <em>Time Expression</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#isAsDuration <em>As Duration</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getRuleExpression <em>Rule Expression</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getErrorCode <em>Error Code</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getSignal <em>Signal</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#isSignalThrown <em>Signal Thrown</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.EventImpl#getLinkedTo <em>Linked To</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EventImpl extends FlowObjectImpl implements Event {
	/**
	 * The default value of the '{@link #isNonInterrupting() <em>Non Interrupting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNonInterrupting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NON_INTERRUPTING_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isNonInterrupting() <em>Non Interrupting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNonInterrupting()
	 * @generated
	 * @ordered
	 */
	protected boolean nonInterrupting = NON_INTERRUPTING_EDEFAULT;
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
	 * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplementation()
	 * @generated
	 * @ordered
	 */
	protected Implementation implementation;
	/**
	 * The cached value of the '{@link #getTimeExpression() <em>Time Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression timeExpression;
	/**
	 * The default value of the '{@link #isAsDuration() <em>As Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsDuration()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AS_DURATION_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isAsDuration() <em>As Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAsDuration()
	 * @generated
	 * @ordered
	 */
	protected boolean asDuration = AS_DURATION_EDEFAULT;
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
	 * The default value of the '{@link #isSignalThrown() <em>Signal Thrown</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSignalThrown()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SIGNAL_THROWN_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isSignalThrown() <em>Signal Thrown</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSignalThrown()
	 * @generated
	 * @ordered
	 */
	protected boolean signalThrown = SIGNAL_THROWN_EDEFAULT;
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
	 * @generated NOT
	 */
	public boolean isNonInterrupting() {
		if (isOnBoundary() || ((this instanceof Start) && isInEventedSubprocess())) {
			return nonInterrupting;
		} else {
			return false;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNonInterrupting(boolean newNonInterrupting) {
		boolean oldNonInterrupting = nonInterrupting;
		nonInterrupting = newNonInterrupting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__NON_INTERRUPTING, oldNonInterrupting, nonInterrupting));
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
	public Expression getTimeExpression() {
		return timeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeExpression(Expression newTimeExpression, NotificationChain msgs) {
		Expression oldTimeExpression = timeExpression;
		timeExpression = newTimeExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__TIME_EXPRESSION, oldTimeExpression, newTimeExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeExpression(Expression newTimeExpression) {
		if (newTimeExpression != timeExpression) {
			NotificationChain msgs = null;
			if (timeExpression != null)
				msgs = ((InternalEObject)timeExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.EVENT__TIME_EXPRESSION, null, msgs);
			if (newTimeExpression != null)
				msgs = ((InternalEObject)newTimeExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.EVENT__TIME_EXPRESSION, null, msgs);
			msgs = basicSetTimeExpression(newTimeExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__TIME_EXPRESSION, newTimeExpression, newTimeExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAsDuration() {
		return asDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAsDuration(boolean newAsDuration) {
		boolean oldAsDuration = asDuration;
		asDuration = newAsDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__AS_DURATION, oldAsDuration, asDuration));
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
	public boolean isSignalThrown() {
		return signalThrown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignalThrown(boolean newSignalThrown) {
		boolean oldSignalThrown = signalThrown;
		signalThrown = newSignalThrown;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__SIGNAL_THROWN, oldSignalThrown, signalThrown));
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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkedTo(Event newLinkedTo) {
		Event oldLinkedTo = linkedTo;
		linkedTo = newLinkedTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.EVENT__LINKED_TO, oldLinkedTo, linkedTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * This method returns the trigger types that may be used for this event in
	 * the context it is used in. The trigger type depends on the event's type
	 * (Start, End, Intermediate), and in case of Intermediate whether it is 
	 * attached to an activity and whether it is throwing or catching.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<TriggerType> getValidTriggerTypes() {
		EList<TriggerType> triggers= new BasicEList<TriggerType>();

		triggers.add(TriggerType.MESSAGE);
		triggers.add(TriggerType.MULTIPLE);
		triggers.add(TriggerType.SIGNAL);
		
		if (this instanceof Start) {
			triggers.add(TriggerType.TIMER);
			triggers.add(TriggerType.RULE);
			if (isInEventedSubprocess()) {
				triggers.add(TriggerType.ESCALATION);
				if (! isNonInterrupting()) {
					triggers.add(TriggerType.ERROR);
					triggers.add(TriggerType.COMPENSATION);
				}
			} else {
				triggers.add(TriggerType.NONE);
			}
		}
		if (this instanceof Intermediate) {
			if (isThrowing()) {
				triggers.add(TriggerType.ESCALATION);
				triggers.add(TriggerType.COMPENSATION);
				triggers.add(TriggerType.LINK);
			} else {
				triggers.add(TriggerType.TIMER);
				triggers.add(TriggerType.RULE);
				if (isOnBoundary()) {
					triggers.add(TriggerType.ESCALATION);
					if (! isNonInterrupting()) {
						triggers.add(TriggerType.CANCEL);
						triggers.add(TriggerType.ERROR);
						triggers.add(TriggerType.COMPENSATION);
					}
				} else {
					triggers.add(TriggerType.NONE);
					triggers.add(TriggerType.LINK);
				}
			}
		}
		if (this instanceof End) {
			triggers.add(TriggerType.NONE);
			triggers.add(TriggerType.ESCALATION);
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
			if (((Intermediate) this).getAttachedTo() != null) {
				return false;
			}

			switch (this.trigger) {
			case MESSAGE:
				if (! getOutgoingMsg().isEmpty()) {
					return true;
				}
				if (! getIncomingMsg().isEmpty()) {
					return false;
				}

			case SIGNAL:
				return this.isSignalThrown();
				
			default:
				//defaults to false, if event has no sequence flows at all
				return ! isStartingNode() && isEndingNode();
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * Check whether this event in in an evented subprocess.
	 * This check is most relevant for start events starting an evented
	 * subprocess, but for more generality we will only check whether this event
	 * is (directly) in an evented subprocess. The check, whether it is a start
	 * event, has to be done separately.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isInEventedSubprocess() {
		return (getAbstractProcess() instanceof Activity) &&
				((Activity) getAbstractProcess()).isEventedSubprocess();
	}

	/**
	 * <!-- begin-user-doc -->
	 * check whether this is an intermediate event on an activity's boundary
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isOnBoundary() {
		return (this instanceof Intermediate) && ((Intermediate) this).getAttachedTo() != null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.EVENT__TIME_EXPRESSION:
				return basicSetTimeExpression(null, msgs);
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
			case VsdtPackage.EVENT__NON_INTERRUPTING:
				return isNonInterrupting();
			case VsdtPackage.EVENT__TRIGGER:
				return getTrigger();
			case VsdtPackage.EVENT__IMPLEMENTATION:
				if (resolve) return getImplementation();
				return basicGetImplementation();
			case VsdtPackage.EVENT__TIME_EXPRESSION:
				return getTimeExpression();
			case VsdtPackage.EVENT__AS_DURATION:
				return isAsDuration();
			case VsdtPackage.EVENT__RULE_EXPRESSION:
				return getRuleExpression();
			case VsdtPackage.EVENT__ERROR_CODE:
				return getErrorCode();
			case VsdtPackage.EVENT__ACTIVITY:
				if (resolve) return getActivity();
				return basicGetActivity();
			case VsdtPackage.EVENT__SIGNAL:
				return getSignal();
			case VsdtPackage.EVENT__SIGNAL_THROWN:
				return isSignalThrown();
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
			case VsdtPackage.EVENT__NON_INTERRUPTING:
				setNonInterrupting((Boolean)newValue);
				return;
			case VsdtPackage.EVENT__TRIGGER:
				setTrigger((TriggerType)newValue);
				return;
			case VsdtPackage.EVENT__IMPLEMENTATION:
				setImplementation((Implementation)newValue);
				return;
			case VsdtPackage.EVENT__TIME_EXPRESSION:
				setTimeExpression((Expression)newValue);
				return;
			case VsdtPackage.EVENT__AS_DURATION:
				setAsDuration((Boolean)newValue);
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
			case VsdtPackage.EVENT__SIGNAL_THROWN:
				setSignalThrown((Boolean)newValue);
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
			case VsdtPackage.EVENT__NON_INTERRUPTING:
				setNonInterrupting(NON_INTERRUPTING_EDEFAULT);
				return;
			case VsdtPackage.EVENT__TRIGGER:
				setTrigger(TRIGGER_EDEFAULT);
				return;
			case VsdtPackage.EVENT__IMPLEMENTATION:
				setImplementation((Implementation)null);
				return;
			case VsdtPackage.EVENT__TIME_EXPRESSION:
				setTimeExpression((Expression)null);
				return;
			case VsdtPackage.EVENT__AS_DURATION:
				setAsDuration(AS_DURATION_EDEFAULT);
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
			case VsdtPackage.EVENT__SIGNAL_THROWN:
				setSignalThrown(SIGNAL_THROWN_EDEFAULT);
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
			case VsdtPackage.EVENT__NON_INTERRUPTING:
				return nonInterrupting != NON_INTERRUPTING_EDEFAULT;
			case VsdtPackage.EVENT__TRIGGER:
				return trigger != TRIGGER_EDEFAULT;
			case VsdtPackage.EVENT__IMPLEMENTATION:
				return implementation != null;
			case VsdtPackage.EVENT__TIME_EXPRESSION:
				return timeExpression != null;
			case VsdtPackage.EVENT__AS_DURATION:
				return asDuration != AS_DURATION_EDEFAULT;
			case VsdtPackage.EVENT__RULE_EXPRESSION:
				return ruleExpression != null;
			case VsdtPackage.EVENT__ERROR_CODE:
				return ERROR_CODE_EDEFAULT == null ? errorCode != null : !ERROR_CODE_EDEFAULT.equals(errorCode);
			case VsdtPackage.EVENT__ACTIVITY:
				return activity != null;
			case VsdtPackage.EVENT__SIGNAL:
				return SIGNAL_EDEFAULT == null ? signal != null : !SIGNAL_EDEFAULT.equals(signal);
			case VsdtPackage.EVENT__SIGNAL_THROWN:
				return signalThrown != SIGNAL_THROWN_EDEFAULT;
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
		result.append(" (nonInterrupting: ");
		result.append(nonInterrupting);
		result.append(", trigger: ");
		result.append(trigger);
		result.append(", asDuration: ");
		result.append(asDuration);
		result.append(", errorCode: ");
		result.append(errorCode);
		result.append(", signal: ");
		result.append(signal);
		result.append(", signalThrown: ");
		result.append(signalThrown);
		result.append(')');
		return result.toString();
	}

} //EventImpl
