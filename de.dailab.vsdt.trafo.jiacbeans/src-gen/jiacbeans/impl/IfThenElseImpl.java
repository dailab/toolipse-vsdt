/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import jiacbeans.IfThenElse;
import jiacbeans.JiacbeansPackage;
import jiacbeans.Script;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Then Else</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jiacbeans.impl.IfThenElseImpl#getThenBranch <em>Then Branch</em>}</li>
 *   <li>{@link jiacbeans.impl.IfThenElseImpl#getElseBranch <em>Else Branch</em>}</li>
 *   <li>{@link jiacbeans.impl.IfThenElseImpl#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfThenElseImpl extends ScriptImpl implements IfThenElse {
	/**
	 * The cached value of the '{@link #getThenBranch() <em>Then Branch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenBranch()
	 * @generated
	 * @ordered
	 */
	protected Script thenBranch;

	/**
	 * The cached value of the '{@link #getElseBranch() <em>Else Branch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseBranch()
	 * @generated
	 * @ordered
	 */
	protected Script elseBranch;

	/**
	 * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 */
	protected static final String CONDITION_EDEFAULT = "true";

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
	protected IfThenElseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JiacbeansPackage.Literals.IF_THEN_ELSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script getThenBranch() {
		if (thenBranch != null && thenBranch.eIsProxy()) {
			InternalEObject oldThenBranch = (InternalEObject)thenBranch;
			thenBranch = (Script)eResolveProxy(oldThenBranch);
			if (thenBranch != oldThenBranch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JiacbeansPackage.IF_THEN_ELSE__THEN_BRANCH, oldThenBranch, thenBranch));
			}
		}
		return thenBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script basicGetThenBranch() {
		return thenBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThenBranch(Script newThenBranch) {
		Script oldThenBranch = thenBranch;
		thenBranch = newThenBranch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.IF_THEN_ELSE__THEN_BRANCH, oldThenBranch, thenBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script getElseBranch() {
		if (elseBranch != null && elseBranch.eIsProxy()) {
			InternalEObject oldElseBranch = (InternalEObject)elseBranch;
			elseBranch = (Script)eResolveProxy(oldElseBranch);
			if (elseBranch != oldElseBranch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JiacbeansPackage.IF_THEN_ELSE__ELSE_BRANCH, oldElseBranch, elseBranch));
			}
		}
		return elseBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script basicGetElseBranch() {
		return elseBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseBranch(Script newElseBranch) {
		Script oldElseBranch = elseBranch;
		elseBranch = newElseBranch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.IF_THEN_ELSE__ELSE_BRANCH, oldElseBranch, elseBranch));
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
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.IF_THEN_ELSE__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JiacbeansPackage.IF_THEN_ELSE__THEN_BRANCH:
				if (resolve) return getThenBranch();
				return basicGetThenBranch();
			case JiacbeansPackage.IF_THEN_ELSE__ELSE_BRANCH:
				if (resolve) return getElseBranch();
				return basicGetElseBranch();
			case JiacbeansPackage.IF_THEN_ELSE__CONDITION:
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
			case JiacbeansPackage.IF_THEN_ELSE__THEN_BRANCH:
				setThenBranch((Script)newValue);
				return;
			case JiacbeansPackage.IF_THEN_ELSE__ELSE_BRANCH:
				setElseBranch((Script)newValue);
				return;
			case JiacbeansPackage.IF_THEN_ELSE__CONDITION:
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
			case JiacbeansPackage.IF_THEN_ELSE__THEN_BRANCH:
				setThenBranch((Script)null);
				return;
			case JiacbeansPackage.IF_THEN_ELSE__ELSE_BRANCH:
				setElseBranch((Script)null);
				return;
			case JiacbeansPackage.IF_THEN_ELSE__CONDITION:
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
			case JiacbeansPackage.IF_THEN_ELSE__THEN_BRANCH:
				return thenBranch != null;
			case JiacbeansPackage.IF_THEN_ELSE__ELSE_BRANCH:
				return elseBranch != null;
			case JiacbeansPackage.IF_THEN_ELSE__CONDITION:
				return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * prints itself as a Java Code
	 */
	@Override
	public String toString() {
		String code = "";
		code += "if("+condition+"){\n";
		if(thenBranch!=null){
			BufferedReader reader = new BufferedReader(new StringReader(thenBranch.toString()));
			try{
				String line = reader.readLine();
				while(line!=null){
					if(!line.equals("")) code += "\t"+line+"\n";
					line = reader.readLine();
				}
			}catch(IOException e){
				code += "\t//Error occured while reading loop body\n";
			}
		}
		code+="}";
		if(elseBranch!=null){
			code+="else{\n";
			BufferedReader reader = new BufferedReader(new StringReader(elseBranch.toString()));
			try{
				String line = reader.readLine();
				while(line!=null){
					if(!line.equals("")) code += "\t"+line+"\n";
					line = reader.readLine();
				}
			}catch(IOException e){
				code += "\t//Error occured while reading loop body\n";
			}
			code+="}";
		}
		return code;
	}

} //IfThenElseImpl
