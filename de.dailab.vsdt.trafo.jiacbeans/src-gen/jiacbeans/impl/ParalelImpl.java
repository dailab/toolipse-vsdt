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
import java.util.Collection;

import jiacbeans.JiacbeansPackage;
import jiacbeans.Paralel;
import jiacbeans.Script;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Paralel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jiacbeans.impl.ParalelImpl#getBranches <em>Branches</em>}</li>
 *   <li>{@link jiacbeans.impl.ParalelImpl#getSignIndex <em>Sign Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParalelImpl extends ScriptImpl implements Paralel {
	/**
	 * The cached value of the '{@link #getBranches() <em>Branches</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBranches()
	 * @generated
	 * @ordered
	 */
	protected EList<Script> branches;

	/**
	 * The default value of the '{@link #getSignIndex() <em>Sign Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int SIGN_INDEX_EDEFAULT = 1;
	/**
	 * The cached value of the '{@link #getSignIndex() <em>Sign Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignIndex()
	 * @generated
	 * @ordered
	 */
	protected int signIndex = SIGN_INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParalelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JiacbeansPackage.Literals.PARALEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Script> getBranches() {
		if (branches == null) {
			branches = new EObjectResolvingEList<Script>(Script.class, this, JiacbeansPackage.PARALEL__BRANCHES);
		}
		return branches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSignIndex() {
		return signIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignIndex(int newSignIndex) {
		int oldSignIndex = signIndex;
		signIndex = newSignIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.PARALEL__SIGN_INDEX, oldSignIndex, signIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JiacbeansPackage.PARALEL__BRANCHES:
				return getBranches();
			case JiacbeansPackage.PARALEL__SIGN_INDEX:
				return getSignIndex();
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
			case JiacbeansPackage.PARALEL__BRANCHES:
				getBranches().clear();
				getBranches().addAll((Collection<? extends Script>)newValue);
				return;
			case JiacbeansPackage.PARALEL__SIGN_INDEX:
				setSignIndex((Integer)newValue);
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
			case JiacbeansPackage.PARALEL__BRANCHES:
				getBranches().clear();
				return;
			case JiacbeansPackage.PARALEL__SIGN_INDEX:
				setSignIndex(SIGN_INDEX_EDEFAULT);
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
			case JiacbeansPackage.PARALEL__BRANCHES:
				return branches != null && !branches.isEmpty();
			case JiacbeansPackage.PARALEL__SIGN_INDEX:
				return signIndex != SIGN_INDEX_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
	
	public String toString(){
		int counter = 0;
		String result  = "";
		for (Script branch : branches) {
			counter++;
			result += "Thread t"+counter +" = new Thread() {\n";
			result += "\t public void run() {\n";
			if(branch!=null){
				BufferedReader reader = new BufferedReader(new StringReader(branch.toString()));
				try{
					String line = reader.readLine();
					while(line!=null){
						if(!line.equals("")) result += "\t\t"+line+"\n";
						line = reader.readLine();
					}
				}catch(IOException e){
					result += "\t//Error occured while reading branch body\n";
				}
			}
			result += "\t}\n";
			result += "};\n";
		}
		int started = 0;
		while(started < counter){
			started++;
			result+="t"+started+".start();\n";
		}
		started = 0;
		result+="try {\n";
		while(started < counter){
			started++;
			result+="\tt"+started+".join();\n";
		}
		result+="} catch(InterruptedException e) {}";
		return result;
	}

} //ParalelImpl
