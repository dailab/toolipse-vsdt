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

import jiacbeans.JiacbeansPackage;
import jiacbeans.Script;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Runnable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jiacbeans.impl.RunnableImpl#getRunContent <em>Run Content</em>}</li>
 *   <li>{@link jiacbeans.impl.RunnableImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RunnableImpl extends ScriptImpl implements jiacbeans.Runnable {
	/**
	 * The cached value of the '{@link #getRunContent() <em>Run Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunContent()
	 * @generated
	 * @ordered
	 */
	protected Script runContent;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RunnableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JiacbeansPackage.Literals.RUNNABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script getRunContent() {
		if (runContent != null && runContent.eIsProxy()) {
			InternalEObject oldRunContent = (InternalEObject)runContent;
			runContent = (Script)eResolveProxy(oldRunContent);
			if (runContent != oldRunContent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JiacbeansPackage.RUNNABLE__RUN_CONTENT, oldRunContent, runContent));
			}
		}
		return runContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Script basicGetRunContent() {
		return runContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunContent(Script newRunContent) {
		Script oldRunContent = runContent;
		runContent = newRunContent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.RUNNABLE__RUN_CONTENT, oldRunContent, runContent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.RUNNABLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JiacbeansPackage.RUNNABLE__RUN_CONTENT:
				if (resolve) return getRunContent();
				return basicGetRunContent();
			case JiacbeansPackage.RUNNABLE__NAME:
				return getName();
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
			case JiacbeansPackage.RUNNABLE__RUN_CONTENT:
				setRunContent((Script)newValue);
				return;
			case JiacbeansPackage.RUNNABLE__NAME:
				setName((String)newValue);
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
			case JiacbeansPackage.RUNNABLE__RUN_CONTENT:
				setRunContent((Script)null);
				return;
			case JiacbeansPackage.RUNNABLE__NAME:
				setName(NAME_EDEFAULT);
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
			case JiacbeansPackage.RUNNABLE__RUN_CONTENT:
				return runContent != null;
			case JiacbeansPackage.RUNNABLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public String toJavaCode() {
		String content ="";
		if(runContent!=null){
			BufferedReader reader = new BufferedReader(new StringReader(runContent.toJavaCode()));
			try{
				String line = reader.readLine();
				while(line!=null){
					if(!line.equals("")) content += "\t\t"+line+"\n";
					line = reader.readLine();
				}
			}catch(IOException e){
				content += "\t//Error occured while reading run content\n";
			}
		}
		String result = "Thread "+getName()+" = new Thread(new Runnable(){\n" +
						"\tpublic void run(){\n"+
						content+
						"\t}\n"+//close run Method
						"});"//Close Runnable and Constructor
						;
		return result;
	}

} //RunnableImpl
