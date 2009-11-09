/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivity;
import org.xmlsoap.schemas.ws._2003._03.business.process.TAssign;
import org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFlow;
import org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke;
import org.xmlsoap.schemas.ws._2003._03.business.process.TLinks;
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
 * An implementation of the model object '<em><b>TFlow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getEmpty <em>Empty</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getInvoke <em>Invoke</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getReceive <em>Receive</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getReply <em>Reply</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getAssign <em>Assign</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getWait <em>Wait</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getThrow <em>Throw</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getTerminate <em>Terminate</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getFlow <em>Flow</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getWhile <em>While</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getPick <em>Pick</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl#getScope <em>Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TFlowImpl extends TActivityImpl implements TFlow {
	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected TLinks links;

	/**
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap activity;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TFLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TLinks getLinks() {
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLinks(TLinks newLinks, NotificationChain msgs) {
		TLinks oldLinks = links;
		links = newLinks;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TFLOW__LINKS, oldLinks, newLinks);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinks(TLinks newLinks) {
		if (newLinks != links) {
			NotificationChain msgs = null;
			if (links != null)
				msgs = ((InternalEObject)links).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TFLOW__LINKS, null, msgs);
			if (newLinks != null)
				msgs = ((InternalEObject)newLinks).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TFLOW__LINKS, null, msgs);
			msgs = basicSetLinks(newLinks, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TFLOW__LINKS, newLinks, newLinks));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getActivity() {
		if (activity == null) {
			activity = new BasicFeatureMap(this, ProcessPackage.TFLOW__ACTIVITY);
		}
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TEmpty> getEmpty() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__EMPTY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TInvoke> getInvoke() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__INVOKE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TReceive> getReceive() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__RECEIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TReply> getReply() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__REPLY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TAssign> getAssign() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__ASSIGN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TWait> getWait() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__WAIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TThrow> getThrow() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__THROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TTerminate> getTerminate() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__TERMINATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TFlow> getFlow() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__FLOW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TSwitch> getSwitch() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__SWITCH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TWhile> getWhile() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__WHILE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TSequence> getSequence() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__SEQUENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TPick> getPick() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__PICK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TScope> getScope() {
		return getActivity().list(ProcessPackage.Literals.TFLOW__SCOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.TFLOW__LINKS:
				return basicSetLinks(null, msgs);
			case ProcessPackage.TFLOW__ACTIVITY:
				return ((InternalEList<?>)getActivity()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__EMPTY:
				return ((InternalEList<?>)getEmpty()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__INVOKE:
				return ((InternalEList<?>)getInvoke()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__RECEIVE:
				return ((InternalEList<?>)getReceive()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__REPLY:
				return ((InternalEList<?>)getReply()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__ASSIGN:
				return ((InternalEList<?>)getAssign()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__WAIT:
				return ((InternalEList<?>)getWait()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__THROW:
				return ((InternalEList<?>)getThrow()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__TERMINATE:
				return ((InternalEList<?>)getTerminate()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__FLOW:
				return ((InternalEList<?>)getFlow()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__SWITCH:
				return ((InternalEList<?>)getSwitch()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__WHILE:
				return ((InternalEList<?>)getWhile()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__SEQUENCE:
				return ((InternalEList<?>)getSequence()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__PICK:
				return ((InternalEList<?>)getPick()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TFLOW__SCOPE:
				return ((InternalEList<?>)getScope()).basicRemove(otherEnd, msgs);
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
			case ProcessPackage.TFLOW__LINKS:
				return getLinks();
			case ProcessPackage.TFLOW__ACTIVITY:
				if (coreType) return getActivity();
				return ((FeatureMap.Internal)getActivity()).getWrapper();
			case ProcessPackage.TFLOW__EMPTY:
				return getEmpty();
			case ProcessPackage.TFLOW__INVOKE:
				return getInvoke();
			case ProcessPackage.TFLOW__RECEIVE:
				return getReceive();
			case ProcessPackage.TFLOW__REPLY:
				return getReply();
			case ProcessPackage.TFLOW__ASSIGN:
				return getAssign();
			case ProcessPackage.TFLOW__WAIT:
				return getWait();
			case ProcessPackage.TFLOW__THROW:
				return getThrow();
			case ProcessPackage.TFLOW__TERMINATE:
				return getTerminate();
			case ProcessPackage.TFLOW__FLOW:
				return getFlow();
			case ProcessPackage.TFLOW__SWITCH:
				return getSwitch();
			case ProcessPackage.TFLOW__WHILE:
				return getWhile();
			case ProcessPackage.TFLOW__SEQUENCE:
				return getSequence();
			case ProcessPackage.TFLOW__PICK:
				return getPick();
			case ProcessPackage.TFLOW__SCOPE:
				return getScope();
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
			case ProcessPackage.TFLOW__LINKS:
				setLinks((TLinks)newValue);
				return;
			case ProcessPackage.TFLOW__ACTIVITY:
				((FeatureMap.Internal)getActivity()).set(newValue);
				return;
			case ProcessPackage.TFLOW__EMPTY:
				getEmpty().clear();
				getEmpty().addAll((Collection<? extends TEmpty>)newValue);
				return;
			case ProcessPackage.TFLOW__INVOKE:
				getInvoke().clear();
				getInvoke().addAll((Collection<? extends TInvoke>)newValue);
				return;
			case ProcessPackage.TFLOW__RECEIVE:
				getReceive().clear();
				getReceive().addAll((Collection<? extends TReceive>)newValue);
				return;
			case ProcessPackage.TFLOW__REPLY:
				getReply().clear();
				getReply().addAll((Collection<? extends TReply>)newValue);
				return;
			case ProcessPackage.TFLOW__ASSIGN:
				getAssign().clear();
				getAssign().addAll((Collection<? extends TAssign>)newValue);
				return;
			case ProcessPackage.TFLOW__WAIT:
				getWait().clear();
				getWait().addAll((Collection<? extends TWait>)newValue);
				return;
			case ProcessPackage.TFLOW__THROW:
				getThrow().clear();
				getThrow().addAll((Collection<? extends TThrow>)newValue);
				return;
			case ProcessPackage.TFLOW__TERMINATE:
				getTerminate().clear();
				getTerminate().addAll((Collection<? extends TTerminate>)newValue);
				return;
			case ProcessPackage.TFLOW__FLOW:
				getFlow().clear();
				getFlow().addAll((Collection<? extends TFlow>)newValue);
				return;
			case ProcessPackage.TFLOW__SWITCH:
				getSwitch().clear();
				getSwitch().addAll((Collection<? extends TSwitch>)newValue);
				return;
			case ProcessPackage.TFLOW__WHILE:
				getWhile().clear();
				getWhile().addAll((Collection<? extends TWhile>)newValue);
				return;
			case ProcessPackage.TFLOW__SEQUENCE:
				getSequence().clear();
				getSequence().addAll((Collection<? extends TSequence>)newValue);
				return;
			case ProcessPackage.TFLOW__PICK:
				getPick().clear();
				getPick().addAll((Collection<? extends TPick>)newValue);
				return;
			case ProcessPackage.TFLOW__SCOPE:
				getScope().clear();
				getScope().addAll((Collection<? extends TScope>)newValue);
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
			case ProcessPackage.TFLOW__LINKS:
				setLinks((TLinks)null);
				return;
			case ProcessPackage.TFLOW__ACTIVITY:
				getActivity().clear();
				return;
			case ProcessPackage.TFLOW__EMPTY:
				getEmpty().clear();
				return;
			case ProcessPackage.TFLOW__INVOKE:
				getInvoke().clear();
				return;
			case ProcessPackage.TFLOW__RECEIVE:
				getReceive().clear();
				return;
			case ProcessPackage.TFLOW__REPLY:
				getReply().clear();
				return;
			case ProcessPackage.TFLOW__ASSIGN:
				getAssign().clear();
				return;
			case ProcessPackage.TFLOW__WAIT:
				getWait().clear();
				return;
			case ProcessPackage.TFLOW__THROW:
				getThrow().clear();
				return;
			case ProcessPackage.TFLOW__TERMINATE:
				getTerminate().clear();
				return;
			case ProcessPackage.TFLOW__FLOW:
				getFlow().clear();
				return;
			case ProcessPackage.TFLOW__SWITCH:
				getSwitch().clear();
				return;
			case ProcessPackage.TFLOW__WHILE:
				getWhile().clear();
				return;
			case ProcessPackage.TFLOW__SEQUENCE:
				getSequence().clear();
				return;
			case ProcessPackage.TFLOW__PICK:
				getPick().clear();
				return;
			case ProcessPackage.TFLOW__SCOPE:
				getScope().clear();
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
			case ProcessPackage.TFLOW__LINKS:
				return links != null;
			case ProcessPackage.TFLOW__ACTIVITY:
				return activity != null && !activity.isEmpty();
			case ProcessPackage.TFLOW__EMPTY:
				return !getEmpty().isEmpty();
			case ProcessPackage.TFLOW__INVOKE:
				return !getInvoke().isEmpty();
			case ProcessPackage.TFLOW__RECEIVE:
				return !getReceive().isEmpty();
			case ProcessPackage.TFLOW__REPLY:
				return !getReply().isEmpty();
			case ProcessPackage.TFLOW__ASSIGN:
				return !getAssign().isEmpty();
			case ProcessPackage.TFLOW__WAIT:
				return !getWait().isEmpty();
			case ProcessPackage.TFLOW__THROW:
				return !getThrow().isEmpty();
			case ProcessPackage.TFLOW__TERMINATE:
				return !getTerminate().isEmpty();
			case ProcessPackage.TFLOW__FLOW:
				return !getFlow().isEmpty();
			case ProcessPackage.TFLOW__SWITCH:
				return !getSwitch().isEmpty();
			case ProcessPackage.TFLOW__WHILE:
				return !getWhile().isEmpty();
			case ProcessPackage.TFLOW__SEQUENCE:
				return !getSequence().isEmpty();
			case ProcessPackage.TFLOW__PICK:
				return !getPick().isEmpty();
			case ProcessPackage.TFLOW__SCOPE:
				return !getScope().isEmpty();
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
		result.append(" (activity: ");
		result.append(activity);
		result.append(')');
		return result.toString();
	}

	/**
	 * @param tActivity	some concrete activity
	 * @return			the list for the given activity
	 * @generated NOT
	 */
	public List<? extends TActivity> getActivityList(TActivity tActivity) {
		if (tActivity instanceof TAssign) {
			return getAssign();
		}
		if (tActivity instanceof TEmpty) {
			return getEmpty();
		}
		if (tActivity instanceof TFlow) {
			return getFlow();
		}
		if (tActivity instanceof TInvoke) {
			return getInvoke();
		}
		if (tActivity instanceof TReceive) {
			return getReceive();
		}
		if (tActivity instanceof TReply) {
			return getReply();
		}
		if (tActivity instanceof TScope) {
			return getScope();
		}
		if (tActivity instanceof TSequence) {
			return getSequence();
		}
		if (tActivity instanceof TSwitch) {
			return getSwitch();
		}
		if (tActivity instanceof TTerminate) {
			return getTerminate();
		}
		if (tActivity instanceof TThrow) {
			return getThrow();
		}
		if (tActivity instanceof TWait) {
			return getWait();
		}
		if (tActivity instanceof TWhile) {
			return getWhile();
		}
		return null;
	}
	
	/**
	 * @param tActivity	some concrete activity
	 * @return			the list for the given activity
	 * @generated NOT
	 */
	public void addActivity(int index, TActivity tActivity) {
		EStructuralFeature feature= null;
		if (tActivity instanceof TAssign) {
			feature= ProcessPackage.eINSTANCE.getTFlow_Assign();
		}
		if (tActivity instanceof TEmpty) {
			feature= ProcessPackage.eINSTANCE.getTFlow_Empty();
		}
		if (tActivity instanceof TFlow) {
			feature= ProcessPackage.eINSTANCE.getTFlow_Flow();
		}
		if (tActivity instanceof TInvoke) {
			feature= ProcessPackage.eINSTANCE.getTFlow_Invoke();
		}
		if (tActivity instanceof TReceive) {
			feature= ProcessPackage.eINSTANCE.getTFlow_Receive();
		}
		if (tActivity instanceof TReply) {
			feature= ProcessPackage.eINSTANCE.getTFlow_Reply();
		}
		if (tActivity instanceof TScope) {
			feature= ProcessPackage.eINSTANCE.getTFlow_Scope();
		}
		if (tActivity instanceof TSequence) {
			feature= ProcessPackage.eINSTANCE.getTFlow_Sequence();
		}
		if (tActivity instanceof TSwitch) {
			feature= ProcessPackage.eINSTANCE.getTFlow_Switch();
		}
		if (tActivity instanceof TTerminate) {
			feature= ProcessPackage.eINSTANCE.getTFlow_Terminate();
		}
		if (tActivity instanceof TThrow) {
			feature= ProcessPackage.eINSTANCE.getTFlow_Throw();
		}
		if (tActivity instanceof TWait) {
			feature= ProcessPackage.eINSTANCE.getTFlow_Wait();
		}
		if (tActivity instanceof TWhile) {
			feature= ProcessPackage.eINSTANCE.getTFlow_While();
		}
		if (feature != null) {
			if (index < 0 || index > getActivity().size()) {
				getActivity().add(feature, tActivity);
			} else {
				getActivity().add(index, feature, tActivity);
			}
		}
	}

} //TFlowImpl