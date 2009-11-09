/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
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
 * An implementation of the model object '<em><b>TSequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getEmpty <em>Empty</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getInvoke <em>Invoke</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getReceive <em>Receive</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getReply <em>Reply</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getAssign <em>Assign</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getWait <em>Wait</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getThrow <em>Throw</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getTerminate <em>Terminate</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getFlow <em>Flow</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getWhile <em>While</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getSequence <em>Sequence</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getPick <em>Pick</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl#getScope <em>Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TSequenceImpl extends TActivityImpl implements TSequence {
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
	protected TSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TSEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getActivity() {
		if (activity == null) {
			activity = new BasicFeatureMap(this, ProcessPackage.TSEQUENCE__ACTIVITY);
		}
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TEmpty> getEmpty() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__EMPTY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TInvoke> getInvoke() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__INVOKE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TReceive> getReceive() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__RECEIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TReply> getReply() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__REPLY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TAssign> getAssign() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__ASSIGN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TWait> getWait() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__WAIT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TThrow> getThrow() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__THROW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TTerminate> getTerminate() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__TERMINATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TFlow> getFlow() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__FLOW);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TSwitch> getSwitch() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__SWITCH);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TWhile> getWhile() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__WHILE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TSequence> getSequence() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__SEQUENCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TPick> getPick() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__PICK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TScope> getScope() {
		return getActivity().list(ProcessPackage.Literals.TSEQUENCE__SCOPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.TSEQUENCE__ACTIVITY:
				return ((InternalEList<?>)getActivity()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__EMPTY:
				return ((InternalEList<?>)getEmpty()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__INVOKE:
				return ((InternalEList<?>)getInvoke()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__RECEIVE:
				return ((InternalEList<?>)getReceive()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__REPLY:
				return ((InternalEList<?>)getReply()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__ASSIGN:
				return ((InternalEList<?>)getAssign()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__WAIT:
				return ((InternalEList<?>)getWait()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__THROW:
				return ((InternalEList<?>)getThrow()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__TERMINATE:
				return ((InternalEList<?>)getTerminate()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__FLOW:
				return ((InternalEList<?>)getFlow()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__SWITCH:
				return ((InternalEList<?>)getSwitch()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__WHILE:
				return ((InternalEList<?>)getWhile()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__SEQUENCE:
				return ((InternalEList<?>)getSequence()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__PICK:
				return ((InternalEList<?>)getPick()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSEQUENCE__SCOPE:
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
			case ProcessPackage.TSEQUENCE__ACTIVITY:
				if (coreType) return getActivity();
				return ((FeatureMap.Internal)getActivity()).getWrapper();
			case ProcessPackage.TSEQUENCE__EMPTY:
				return getEmpty();
			case ProcessPackage.TSEQUENCE__INVOKE:
				return getInvoke();
			case ProcessPackage.TSEQUENCE__RECEIVE:
				return getReceive();
			case ProcessPackage.TSEQUENCE__REPLY:
				return getReply();
			case ProcessPackage.TSEQUENCE__ASSIGN:
				return getAssign();
			case ProcessPackage.TSEQUENCE__WAIT:
				return getWait();
			case ProcessPackage.TSEQUENCE__THROW:
				return getThrow();
			case ProcessPackage.TSEQUENCE__TERMINATE:
				return getTerminate();
			case ProcessPackage.TSEQUENCE__FLOW:
				return getFlow();
			case ProcessPackage.TSEQUENCE__SWITCH:
				return getSwitch();
			case ProcessPackage.TSEQUENCE__WHILE:
				return getWhile();
			case ProcessPackage.TSEQUENCE__SEQUENCE:
				return getSequence();
			case ProcessPackage.TSEQUENCE__PICK:
				return getPick();
			case ProcessPackage.TSEQUENCE__SCOPE:
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
			case ProcessPackage.TSEQUENCE__ACTIVITY:
				((FeatureMap.Internal)getActivity()).set(newValue);
				return;
			case ProcessPackage.TSEQUENCE__EMPTY:
				getEmpty().clear();
				getEmpty().addAll((Collection<? extends TEmpty>)newValue);
				return;
			case ProcessPackage.TSEQUENCE__INVOKE:
				getInvoke().clear();
				getInvoke().addAll((Collection<? extends TInvoke>)newValue);
				return;
			case ProcessPackage.TSEQUENCE__RECEIVE:
				getReceive().clear();
				getReceive().addAll((Collection<? extends TReceive>)newValue);
				return;
			case ProcessPackage.TSEQUENCE__REPLY:
				getReply().clear();
				getReply().addAll((Collection<? extends TReply>)newValue);
				return;
			case ProcessPackage.TSEQUENCE__ASSIGN:
				getAssign().clear();
				getAssign().addAll((Collection<? extends TAssign>)newValue);
				return;
			case ProcessPackage.TSEQUENCE__WAIT:
				getWait().clear();
				getWait().addAll((Collection<? extends TWait>)newValue);
				return;
			case ProcessPackage.TSEQUENCE__THROW:
				getThrow().clear();
				getThrow().addAll((Collection<? extends TThrow>)newValue);
				return;
			case ProcessPackage.TSEQUENCE__TERMINATE:
				getTerminate().clear();
				getTerminate().addAll((Collection<? extends TTerminate>)newValue);
				return;
			case ProcessPackage.TSEQUENCE__FLOW:
				getFlow().clear();
				getFlow().addAll((Collection<? extends TFlow>)newValue);
				return;
			case ProcessPackage.TSEQUENCE__SWITCH:
				getSwitch().clear();
				getSwitch().addAll((Collection<? extends TSwitch>)newValue);
				return;
			case ProcessPackage.TSEQUENCE__WHILE:
				getWhile().clear();
				getWhile().addAll((Collection<? extends TWhile>)newValue);
				return;
			case ProcessPackage.TSEQUENCE__SEQUENCE:
				getSequence().clear();
				getSequence().addAll((Collection<? extends TSequence>)newValue);
				return;
			case ProcessPackage.TSEQUENCE__PICK:
				getPick().clear();
				getPick().addAll((Collection<? extends TPick>)newValue);
				return;
			case ProcessPackage.TSEQUENCE__SCOPE:
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
			case ProcessPackage.TSEQUENCE__ACTIVITY:
				getActivity().clear();
				return;
			case ProcessPackage.TSEQUENCE__EMPTY:
				getEmpty().clear();
				return;
			case ProcessPackage.TSEQUENCE__INVOKE:
				getInvoke().clear();
				return;
			case ProcessPackage.TSEQUENCE__RECEIVE:
				getReceive().clear();
				return;
			case ProcessPackage.TSEQUENCE__REPLY:
				getReply().clear();
				return;
			case ProcessPackage.TSEQUENCE__ASSIGN:
				getAssign().clear();
				return;
			case ProcessPackage.TSEQUENCE__WAIT:
				getWait().clear();
				return;
			case ProcessPackage.TSEQUENCE__THROW:
				getThrow().clear();
				return;
			case ProcessPackage.TSEQUENCE__TERMINATE:
				getTerminate().clear();
				return;
			case ProcessPackage.TSEQUENCE__FLOW:
				getFlow().clear();
				return;
			case ProcessPackage.TSEQUENCE__SWITCH:
				getSwitch().clear();
				return;
			case ProcessPackage.TSEQUENCE__WHILE:
				getWhile().clear();
				return;
			case ProcessPackage.TSEQUENCE__SEQUENCE:
				getSequence().clear();
				return;
			case ProcessPackage.TSEQUENCE__PICK:
				getPick().clear();
				return;
			case ProcessPackage.TSEQUENCE__SCOPE:
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
			case ProcessPackage.TSEQUENCE__ACTIVITY:
				return activity != null && !activity.isEmpty();
			case ProcessPackage.TSEQUENCE__EMPTY:
				return !getEmpty().isEmpty();
			case ProcessPackage.TSEQUENCE__INVOKE:
				return !getInvoke().isEmpty();
			case ProcessPackage.TSEQUENCE__RECEIVE:
				return !getReceive().isEmpty();
			case ProcessPackage.TSEQUENCE__REPLY:
				return !getReply().isEmpty();
			case ProcessPackage.TSEQUENCE__ASSIGN:
				return !getAssign().isEmpty();
			case ProcessPackage.TSEQUENCE__WAIT:
				return !getWait().isEmpty();
			case ProcessPackage.TSEQUENCE__THROW:
				return !getThrow().isEmpty();
			case ProcessPackage.TSEQUENCE__TERMINATE:
				return !getTerminate().isEmpty();
			case ProcessPackage.TSEQUENCE__FLOW:
				return !getFlow().isEmpty();
			case ProcessPackage.TSEQUENCE__SWITCH:
				return !getSwitch().isEmpty();
			case ProcessPackage.TSEQUENCE__WHILE:
				return !getWhile().isEmpty();
			case ProcessPackage.TSEQUENCE__SEQUENCE:
				return !getSequence().isEmpty();
			case ProcessPackage.TSEQUENCE__PICK:
				return !getPick().isEmpty();
			case ProcessPackage.TSEQUENCE__SCOPE:
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
		if (tActivity instanceof TPick) {
			return getPick();
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
	 * Add Activity of any type to the respective list
	 * @param activity	
	 * @generated NOT
	 */
	public void addActivity(TActivity activity) {
		if (activity != null) {
			List list= getActivityList(activity);
			list.add(activity);
		}
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
			getActivity().add(index, feature, tActivity);
		}
	}

	public int getActivityIndex(TActivity activity) {
		for (int i=0; i<getActivity().size(); i++) {
			if (getActivity().getValue(i) == activity) {
				return i;
			}
		}
		return -1;
	}

} //TSequenceImpl