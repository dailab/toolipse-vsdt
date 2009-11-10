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
 * A representation of the model object '<em><b>Beans</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.jiaciv.agentrole.Beans#getBean <em>Bean</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getBeans()
 * @model extendedMetaData="name='Beans' kind='elementOnly'"
 * @generated
 */
public interface Beans extends EObject {
	/**
	 * Returns the value of the '<em><b>Bean</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.jiaciv.agentrole.BeanType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bean</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bean</em>' containment reference list.
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getBeans_Bean()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Bean' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<BeanType> getBean();

} // Beans
