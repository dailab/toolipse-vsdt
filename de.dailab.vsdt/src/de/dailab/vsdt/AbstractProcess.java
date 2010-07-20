/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.AbstractProcess#isAdHoc <em>Ad Hoc</em>}</li>
 *   <li>{@link de.dailab.vsdt.AbstractProcess#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.AbstractProcess#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getAbstractProcess()
 * @model abstract="true"
 * @generated
 */
public interface AbstractProcess extends EObject {
	/**
	 * Returns the value of the '<em><b>Ad Hoc</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ad Hoc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ad Hoc</em>' attribute.
	 * @see #setAdHoc(boolean)
	 * @see de.dailab.vsdt.VsdtPackage#getAbstractProcess_AdHoc()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isAdHoc();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.AbstractProcess#isAdHoc <em>Ad Hoc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ad Hoc</em>' attribute.
	 * @see #isAdHoc()
	 * @generated
	 */
	void setAdHoc(boolean value);

	/**
	 * Returns the value of the '<em><b>Ad Hoc Completion Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ad Hoc Completion Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ad Hoc Completion Condition</em>' containment reference.
	 * @see #setAdHocCompletionCondition(Expression)
	 * @see de.dailab.vsdt.VsdtPackage#getAbstractProcess_AdHocCompletionCondition()
	 * @model containment="true"
	 * @generated
	 */
	Expression getAdHocCompletionCondition();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.AbstractProcess#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ad Hoc Completion Condition</em>' containment reference.
	 * @see #getAdHocCompletionCondition()
	 * @generated
	 */
	void setAdHocCompletionCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getAbstractProcess_Properties()
	 * @model containment="true"
	 * @generated
	 */
	EList<Property> getProperties();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
	EList<FlowObject> getGraphicalElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
//	EList<FlowObject> getTransitiveGraphicalElements();

} // AbstractProcess
