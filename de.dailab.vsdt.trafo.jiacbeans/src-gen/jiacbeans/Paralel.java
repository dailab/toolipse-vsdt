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
 * A representation of the model object '<em><b>Paralel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jiacbeans.Paralel#getBranches <em>Branches</em>}</li>
 *   <li>{@link jiacbeans.Paralel#getSignIndex <em>Sign Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see jiacbeans.JiacbeansPackage#getParalel()
 * @model
 * @generated
 */
public interface Paralel extends Script {
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
	 * @see jiacbeans.JiacbeansPackage#getParalel_Branches()
	 * @model
	 * @generated
	 */
	EList<Script> getBranches();

	/**
	 * Returns the value of the '<em><b>Sign Index</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sign Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sign Index</em>' attribute.
	 * @see #setSignIndex(int)
	 * @see jiacbeans.JiacbeansPackage#getParalel_SignIndex()
	 * @model default="1"
	 * @generated
	 */
	int getSignIndex();

	/**
	 * Sets the value of the '{@link jiacbeans.Paralel#getSignIndex <em>Sign Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sign Index</em>' attribute.
	 * @see #getSignIndex()
	 * @generated
	 */
	void setSignIndex(int value);

} // Paralel
