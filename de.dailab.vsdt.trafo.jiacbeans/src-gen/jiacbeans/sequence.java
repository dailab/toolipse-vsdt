/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jiacbeans.sequence#getScripts <em>Scripts</em>}</li>
 * </ul>
 * </p>
 *
 * @see jiacbeans.JiacbeansPackage#getsequence()
 * @model
 * @generated
 */
public interface sequence extends Script {
	/**
	 * Returns the value of the '<em><b>Scripts</b></em>' reference list.
	 * The list contents are of type {@link jiacbeans.Script}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scripts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scripts</em>' reference list.
	 * @see jiacbeans.JiacbeansPackage#getsequence_Scripts()
	 * @model
	 * @generated
	 */
	EList<Script> getScripts();

} // sequence
