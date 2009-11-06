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
 * A representation of the model object '<em><b>Loop Attribute Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.LoopAttributeSet#getParentActivity <em>Parent Activity</em>}</li>
 *   <li>{@link de.dailab.vsdt.LoopAttributeSet#getLoopCounter <em>Loop Counter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getLoopAttributeSet()
 * @model abstract="true"
 * @generated
 */
public interface LoopAttributeSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent Activity</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Activity#getLoopAttributes <em>Loop Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Activity</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Activity</em>' container reference.
	 * @see #setParentActivity(Activity)
	 * @see de.dailab.vsdt.VsdtPackage#getLoopAttributeSet_ParentActivity()
	 * @see de.dailab.vsdt.Activity#getLoopAttributes
	 * @model opposite="loopAttributes" required="true" transient="false"
	 * @generated
	 */
	Activity getParentActivity();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.LoopAttributeSet#getParentActivity <em>Parent Activity</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Activity</em>' container reference.
	 * @see #getParentActivity()
	 * @generated
	 */
	void setParentActivity(Activity value);

	/**
	 * Returns the value of the '<em><b>Loop Counter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Counter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Counter</em>' attribute.
	 * @see #setLoopCounter(int)
	 * @see de.dailab.vsdt.VsdtPackage#getLoopAttributeSet_LoopCounter()
	 * @model required="true"
	 * @generated
	 */
	int getLoopCounter();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.LoopAttributeSet#getLoopCounter <em>Loop Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Counter</em>' attribute.
	 * @see #getLoopCounter()
	 * @generated
	 */
	void setLoopCounter(int value);

} // LoopAttributeSet
