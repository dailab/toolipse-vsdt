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
 * A representation of the model object '<em><b>Parallel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jiacbeans.Parallel#getBranches <em>Branches</em>}</li>
 *   <li>{@link jiacbeans.Parallel#getBranchPrefix <em>Branch Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @see jiacbeans.JiacbeansPackage#getParallel()
 * @model
 * @generated
 */
public interface Parallel extends Script {
	/**
	 * Returns the value of the '<em><b>Branches</b></em>' reference list.
	 * The list contents are of type {@link jiacbeans.Script}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branches</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branches</em>' reference list.
	 * @see jiacbeans.JiacbeansPackage#getParallel_Branches()
	 * @model
	 * @generated
	 */
	EList<Script> getBranches();

	/**
	 * Returns the value of the '<em><b>Branch Prefix</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Prefix</em>' attribute.
	 * @see #setBranchPrefix(String)
	 * @see jiacbeans.JiacbeansPackage#getParallel_BranchPrefix()
	 * @model default=""
	 * @generated
	 */
	String getBranchPrefix();

	/**
	 * Sets the value of the '{@link jiacbeans.Parallel#getBranchPrefix <em>Branch Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch Prefix</em>' attribute.
	 * @see #getBranchPrefix()
	 * @generated
	 */
	void setBranchPrefix(String value);

} // Parallel
