/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans.impl;

import java.util.Collection;

import jiacbeans.JavaVariable;
import jiacbeans.JiacbeansPackage;
import jiacbeans.Method;
import jiacbeans.SubProcess;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jiacbeans.impl.SubProcessImpl#getSubprocesses <em>Subprocesses</em>}</li>
 *   <li>{@link jiacbeans.impl.SubProcessImpl#getName <em>Name</em>}</li>
 *   <li>{@link jiacbeans.impl.SubProcessImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link jiacbeans.impl.SubProcessImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubProcessImpl extends EObjectImpl implements SubProcess {
	/**
	 * The cached value of the '{@link #getSubprocesses() <em>Subprocesses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubprocesses()
	 * @generated
	 * @ordered
	 */
	protected EList<SubProcess> subprocesses;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<Method> methods;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<JavaVariable> attributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JiacbeansPackage.Literals.SUB_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubProcess> getSubprocesses() {
		if (subprocesses == null) {
			subprocesses = new EObjectResolvingEList<SubProcess>(SubProcess.class, this, JiacbeansPackage.SUB_PROCESS__SUBPROCESSES);
		}
		return subprocesses;
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
			eNotify(new ENotificationImpl(this, Notification.SET, JiacbeansPackage.SUB_PROCESS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Method> getMethods() {
		if (methods == null) {
			methods = new EObjectResolvingEList<Method>(Method.class, this, JiacbeansPackage.SUB_PROCESS__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JavaVariable> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectResolvingEList<JavaVariable>(JavaVariable.class, this, JiacbeansPackage.SUB_PROCESS__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JiacbeansPackage.SUB_PROCESS__SUBPROCESSES:
				return getSubprocesses();
			case JiacbeansPackage.SUB_PROCESS__NAME:
				return getName();
			case JiacbeansPackage.SUB_PROCESS__METHODS:
				return getMethods();
			case JiacbeansPackage.SUB_PROCESS__ATTRIBUTES:
				return getAttributes();
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
			case JiacbeansPackage.SUB_PROCESS__SUBPROCESSES:
				getSubprocesses().clear();
				getSubprocesses().addAll((Collection<? extends SubProcess>)newValue);
				return;
			case JiacbeansPackage.SUB_PROCESS__NAME:
				setName((String)newValue);
				return;
			case JiacbeansPackage.SUB_PROCESS__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends Method>)newValue);
				return;
			case JiacbeansPackage.SUB_PROCESS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends JavaVariable>)newValue);
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
			case JiacbeansPackage.SUB_PROCESS__SUBPROCESSES:
				getSubprocesses().clear();
				return;
			case JiacbeansPackage.SUB_PROCESS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JiacbeansPackage.SUB_PROCESS__METHODS:
				getMethods().clear();
				return;
			case JiacbeansPackage.SUB_PROCESS__ATTRIBUTES:
				getAttributes().clear();
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
			case JiacbeansPackage.SUB_PROCESS__SUBPROCESSES:
				return subprocesses != null && !subprocesses.isEmpty();
			case JiacbeansPackage.SUB_PROCESS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JiacbeansPackage.SUB_PROCESS__METHODS:
				return methods != null && !methods.isEmpty();
			case JiacbeansPackage.SUB_PROCESS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
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

} //SubProcessImpl
