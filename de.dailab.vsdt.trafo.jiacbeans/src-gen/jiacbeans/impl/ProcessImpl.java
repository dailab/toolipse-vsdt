/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans.impl;

import java.util.Collection;

import jiacbeans.JiacbeansPackage;
import jiacbeans.Method;
import jiacbeans.SubProcess;
import jiacbeans.Variable;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jiacbeans.impl.ProcessImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link jiacbeans.impl.ProcessImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link jiacbeans.impl.ProcessImpl#getSubprocesses <em>Subprocesses</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessImpl extends NamedElementImpl implements jiacbeans.Process {
	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<Variable> variables;

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
	 * The cached value of the '{@link #getSubprocesses() <em>Subprocesses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubprocesses()
	 * @generated
	 * @ordered
	 */
	protected EList<SubProcess> subprocesses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JiacbeansPackage.Literals.PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Variable> getVariables() {
		if (variables == null) {
			variables = new EObjectResolvingEList<Variable>(Variable.class, this, JiacbeansPackage.PROCESS__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Method> getMethods() {
		if (methods == null) {
			methods = new EObjectResolvingEList<Method>(Method.class, this, JiacbeansPackage.PROCESS__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubProcess> getSubprocesses() {
		if (subprocesses == null) {
			subprocesses = new EObjectResolvingEList<SubProcess>(SubProcess.class, this, JiacbeansPackage.PROCESS__SUBPROCESSES);
		}
		return subprocesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JiacbeansPackage.PROCESS__VARIABLES:
				return getVariables();
			case JiacbeansPackage.PROCESS__METHODS:
				return getMethods();
			case JiacbeansPackage.PROCESS__SUBPROCESSES:
				return getSubprocesses();
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
			case JiacbeansPackage.PROCESS__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends Variable>)newValue);
				return;
			case JiacbeansPackage.PROCESS__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends Method>)newValue);
				return;
			case JiacbeansPackage.PROCESS__SUBPROCESSES:
				getSubprocesses().clear();
				getSubprocesses().addAll((Collection<? extends SubProcess>)newValue);
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
			case JiacbeansPackage.PROCESS__VARIABLES:
				getVariables().clear();
				return;
			case JiacbeansPackage.PROCESS__METHODS:
				getMethods().clear();
				return;
			case JiacbeansPackage.PROCESS__SUBPROCESSES:
				getSubprocesses().clear();
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
			case JiacbeansPackage.PROCESS__VARIABLES:
				return variables != null && !variables.isEmpty();
			case JiacbeansPackage.PROCESS__METHODS:
				return methods != null && !methods.isEmpty();
			case JiacbeansPackage.PROCESS__SUBPROCESSES:
				return subprocesses != null && !subprocesses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProcessImpl
