/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Then Else</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jiacbeans.IfThenElse#getCondition <em>Condition</em>}</li>
 *   <li>{@link jiacbeans.IfThenElse#getThenBranch <em>Then Branch</em>}</li>
 *   <li>{@link jiacbeans.IfThenElse#getElseBranch <em>Else Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see jiacbeans.JiacbeansPackage#getIfThenElse()
 * @model
 * @generated
 */
public interface IfThenElse extends Script {
	/**
	 * Returns the value of the '<em><b>Then Branch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Branch</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Branch</em>' reference.
	 * @see #setThenBranch(Script)
	 * @see jiacbeans.JiacbeansPackage#getIfThenElse_ThenBranch()
	 * @model required="true"
	 * @generated
	 */
	Script getThenBranch();

	/**
	 * Sets the value of the '{@link jiacbeans.IfThenElse#getThenBranch <em>Then Branch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Branch</em>' reference.
	 * @see #getThenBranch()
	 * @generated
	 */
	void setThenBranch(Script value);

	/**
	 * Returns the value of the '<em><b>Else Branch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Branch</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Branch</em>' reference.
	 * @see #setElseBranch(Script)
	 * @see jiacbeans.JiacbeansPackage#getIfThenElse_ElseBranch()
	 * @model
	 * @generated
	 */
	Script getElseBranch();

	/**
	 * Sets the value of the '{@link jiacbeans.IfThenElse#getElseBranch <em>Else Branch</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Branch</em>' reference.
	 * @see #getElseBranch()
	 * @generated
	 */
	void setElseBranch(Script value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see jiacbeans.JiacbeansPackage#getIfThenElse_Condition()
	 * @model required="true"
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link jiacbeans.IfThenElse#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

} // IfThenElse
