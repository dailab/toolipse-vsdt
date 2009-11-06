/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.Transaction#getTransactionId <em>Transaction Id</em>}</li>
 *   <li>{@link de.dailab.vsdt.Transaction#getTransactionProtocol <em>Transaction Protocol</em>}</li>
 *   <li>{@link de.dailab.vsdt.Transaction#getTransactionMethod <em>Transaction Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getTransaction()
 * @model
 * @generated
 */
public interface Transaction extends EObject {
	/**
	 * Returns the value of the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transaction Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transaction Id</em>' attribute.
	 * @see #setTransactionId(String)
	 * @see de.dailab.vsdt.VsdtPackage#getTransaction_TransactionId()
	 * @model required="true"
	 * @generated
	 */
	String getTransactionId();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Transaction#getTransactionId <em>Transaction Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction Id</em>' attribute.
	 * @see #getTransactionId()
	 * @generated
	 */
	void setTransactionId(String value);

	/**
	 * Returns the value of the '<em><b>Transaction Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transaction Protocol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transaction Protocol</em>' attribute.
	 * @see #setTransactionProtocol(String)
	 * @see de.dailab.vsdt.VsdtPackage#getTransaction_TransactionProtocol()
	 * @model required="true"
	 * @generated
	 */
	String getTransactionProtocol();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Transaction#getTransactionProtocol <em>Transaction Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction Protocol</em>' attribute.
	 * @see #getTransactionProtocol()
	 * @generated
	 */
	void setTransactionProtocol(String value);

	/**
	 * Returns the value of the '<em><b>Transaction Method</b></em>' attribute.
	 * The literals are from the enumeration {@link de.dailab.vsdt.TransactionMethodType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transaction Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transaction Method</em>' attribute.
	 * @see de.dailab.vsdt.TransactionMethodType
	 * @see #setTransactionMethod(TransactionMethodType)
	 * @see de.dailab.vsdt.VsdtPackage#getTransaction_TransactionMethod()
	 * @model required="true"
	 * @generated
	 */
	TransactionMethodType getTransactionMethod();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Transaction#getTransactionMethod <em>Transaction Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction Method</em>' attribute.
	 * @see de.dailab.vsdt.TransactionMethodType
	 * @see #getTransactionMethod()
	 * @generated
	 */
	void setTransactionMethod(TransactionMethodType value);

} // Transaction
