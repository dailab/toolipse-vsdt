/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl.vxl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlTerm#getHead <em>Head</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlTerm#getTail <em>Tail</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlTerm()
 * @model
 * @generated
 */
public interface VxlTerm extends EObject
{
  /**
   * Returns the value of the '<em><b>Head</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Head</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Head</em>' containment reference.
   * @see #setHead(VxlHead)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlTerm_Head()
   * @model containment="true"
   * @generated
   */
  VxlHead getHead();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlTerm#getHead <em>Head</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Head</em>' containment reference.
   * @see #getHead()
   * @generated
   */
  void setHead(VxlHead value);

  /**
   * Returns the value of the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tail</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tail</em>' containment reference.
   * @see #setTail(VxlTail)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlTerm_Tail()
   * @model containment="true"
   * @generated
   */
  VxlTail getTail();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlTerm#getTail <em>Tail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tail</em>' containment reference.
   * @see #getTail()
   * @generated
   */
  void setTail(VxlTail value);

} // VxlTerm
