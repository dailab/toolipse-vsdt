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
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.Assignment#getTo <em>To</em>}</li>
 *   <li>{@link de.dailab.vsdt.Assignment#getFrom <em>From</em>}</li>
 *   <li>{@link de.dailab.vsdt.Assignment#getAssignTime <em>Assign Time</em>}</li>
 *   <li>{@link de.dailab.vsdt.Assignment#getToQuery <em>To Query</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.VsdtPackage#getAssignment()
 * @model
 * @generated
 */
public interface Assignment extends EObject {
	/**
	 * Returns the value of the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' reference.
	 * @see #setTo(Property)
	 * @see de.dailab.vsdt.VsdtPackage#getAssignment_To()
	 * @model resolveProxies="false" required="true"
	 * @generated
	 */
	Property getTo();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Assignment#getTo <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' reference.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(Property value);

	/**
	 * Returns the value of the '<em><b>From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' containment reference.
	 * @see #setFrom(Expression)
	 * @see de.dailab.vsdt.VsdtPackage#getAssignment_From()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getFrom();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Assignment#getFrom <em>From</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' containment reference.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(Expression value);

	/**
	 * Returns the value of the '<em><b>Assign Time</b></em>' attribute.
	 * The literals are from the enumeration {@link de.dailab.vsdt.AssignTimeType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assign Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assign Time</em>' attribute.
	 * @see de.dailab.vsdt.AssignTimeType
	 * @see #setAssignTime(AssignTimeType)
	 * @see de.dailab.vsdt.VsdtPackage#getAssignment_AssignTime()
	 * @model
	 * @generated
	 */
	AssignTimeType getAssignTime();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Assignment#getAssignTime <em>Assign Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assign Time</em>' attribute.
	 * @see de.dailab.vsdt.AssignTimeType
	 * @see #getAssignTime()
	 * @generated
	 */
	void setAssignTime(AssignTimeType value);

	/**
	 * Returns the value of the '<em><b>To Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Query</em>' attribute.
	 * @see #setToQuery(String)
	 * @see de.dailab.vsdt.VsdtPackage#getAssignment_ToQuery()
	 * @model
	 * @generated
	 */
	String getToQuery();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Assignment#getToQuery <em>To Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Query</em>' attribute.
	 * @see #getToQuery()
	 * @generated
	 */
	void setToQuery(String value);

} // Assignment
