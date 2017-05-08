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
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.LoopAttributeSet#getParent <em>Parent</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.VsdtPackage#getLoopAttributeSet()
 * @model abstract="true"
 * @generated
 */
public interface LoopAttributeSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Activity#getLoopAttributes <em>Loop Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Activity)
	 * @see de.dailab.vsdt.VsdtPackage#getLoopAttributeSet_Parent()
	 * @see de.dailab.vsdt.Activity#getLoopAttributes
	 * @model opposite="loopAttributes" required="true" transient="false"
	 * @generated
	 */
	Activity getParent();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.LoopAttributeSet#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Activity value);

} // LoopAttributeSet
