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
import java.util.HashMap;
import java.util.Map;

import jiacbeans.JiacbeansPackage;
import jiacbeans.Script;
import jiacbeans.TryCatch;

import org.eclipse.emf.common.notify.Notification;


import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Try Catch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jiacbeans.impl.TryCatchImpl#getTry <em>Try</em>}</li>
 *   <li>{@link jiacbeans.impl.TryCatchImpl#getCatches <em>Catches</em>}</li>
 *   <li>{@link jiacbeans.impl.TryCatchImpl#getFinally <em>Finally</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TryCatchImpl extends ScriptImpl implements TryCatch {
	/**
	 * The cached value of the '{@link #getTry() <em>Try</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTry()
	 * @generated
	 * @ordered
	 */
	protected Script try_;

	/**
	 * The cached value of the '{@link #getCatches() <em>Catches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatches()
	 * @ordered
	 */
	protected Map<String, Script> catches = new HashMap<String, Script>();

	/**
	 * The cached value of the '{@link #getFinally() <em>Finally</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinally()
	 * @generated
	 * @ordered
	 */
	protected Script finally_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TryCatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JiacbeansPackage.Literals.TRY_CATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script getTry() {
		if (try_ != null && try_.eIsProxy()) {
			InternalEObject oldTry = (InternalEObject)try_;
			try_ = (Script)eResolveProxy(oldTry);
			if (try_ != oldTry) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JiacbeansPackage.TRY_CATCH__TRY, oldTry, try_));
			}
		}
		return try_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script basicGetTry() {
		return try_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTry(Script newTry) {
		Script oldTry = try_;
		try_ = newTry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.TRY_CATCH__TRY, oldTry, try_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map<String, Script> getCatches() {
		return catches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCatches(Map<String, Script> newCatches) {
		Map<String, Script> oldCatches = catches;
		catches = newCatches;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.TRY_CATCH__CATCHES, oldCatches, catches));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script getFinally() {
		if (finally_ != null && finally_.eIsProxy()) {
			InternalEObject oldFinally = (InternalEObject)finally_;
			finally_ = (Script)eResolveProxy(oldFinally);
			if (finally_ != oldFinally) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JiacbeansPackage.TRY_CATCH__FINALLY, oldFinally, finally_));
			}
		}
		return finally_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script basicGetFinally() {
		return finally_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinally(Script newFinally) {
		Script oldFinally = finally_;
		finally_ = newFinally;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.TRY_CATCH__FINALLY, oldFinally, finally_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JiacbeansPackage.TRY_CATCH__TRY:
				if (resolve) return getTry();
				return basicGetTry();
			case JiacbeansPackage.TRY_CATCH__CATCHES:
				return getCatches();
			case JiacbeansPackage.TRY_CATCH__FINALLY:
				if (resolve) return getFinally();
				return basicGetFinally();
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
			case JiacbeansPackage.TRY_CATCH__TRY:
				setTry((Script)newValue);
				return;
			case JiacbeansPackage.TRY_CATCH__CATCHES:
				setCatches((Map<String, Script>)newValue);
				return;
			case JiacbeansPackage.TRY_CATCH__FINALLY:
				setFinally((Script)newValue);
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
			case JiacbeansPackage.TRY_CATCH__TRY:
				setTry((Script)null);
				return;
			case JiacbeansPackage.TRY_CATCH__CATCHES:
				setCatches((Map<String, Script>)null);
				return;
			case JiacbeansPackage.TRY_CATCH__FINALLY:
				setFinally((Script)null);
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
			case JiacbeansPackage.TRY_CATCH__TRY:
				return try_ != null;
			case JiacbeansPackage.TRY_CATCH__CATCHES:
				return catches != null;
			case JiacbeansPackage.TRY_CATCH__FINALLY:
				return finally_ != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String toJavaCode() {
		String result = "try {\n";
		if(try_!=null){
			BufferedReader reader = new BufferedReader(new StringReader(try_.toJavaCode()));
			try{
				String line = reader.readLine();
				while(line!=null){
					if(!line.equals("")) result += "\t"+line+"\n";
					line = reader.readLine();
				}
			}catch(IOException e){
				result += "\t//Error occured while reading try body\n";
			}
		}
		for (Map.Entry<String, Script> entry : catches.entrySet()) {
			result+="} catch("+entry.getKey()+" e) {\n";
			Script content = entry.getValue();
			if(content!= null){
				BufferedReader reader = new BufferedReader(new StringReader(content.toJavaCode()));
				try{
					String line = reader.readLine();
					while(line!=null){
						if(!line.equals("")) result += "\t"+line+"\n";
						line = reader.readLine();
					}
				}catch(IOException e){
					result += "\t//Error occured while reading catch body\n";
				}
			}
		}
		result+="}";
		if(finally_!=null){
			result+="finally {\n";
			BufferedReader reader = new BufferedReader(new StringReader(finally_.toJavaCode()));
			try{
				String line = reader.readLine();
				while(line!=null){
					if(!line.equals("")) result += "\t"+line+"\n";
					line = reader.readLine();
				}
			}catch(IOException e){
				result += "\t//Error occured while reading finally\n";
			}
			result+="}";
		}
		return result;
	}

} //TryCatchImpl
