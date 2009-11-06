/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.jiaciv.agentrole;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plans</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.jiaciv.agentrole.Plans#getPlan <em>Plan</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getPlans()
 * @model extendedMetaData="name='Plans' kind='elementOnly'"
 * @generated
 */
public interface Plans extends EObject {
	/**
	 * Returns the value of the '<em><b>Plan</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.jiaciv.agentrole.PlanType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plan</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plan</em>' containment reference list.
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getPlans_Plan()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Plan' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PlanType> getPlan();

} // Plans
