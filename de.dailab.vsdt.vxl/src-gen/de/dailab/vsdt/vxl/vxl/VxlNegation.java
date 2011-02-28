/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl.vxl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Negation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlNegation#getHead <em>Head</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlNegation()
 * @model
 * @generated
 */
public interface VxlNegation extends VxlHead
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
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlNegation_Head()
   * @model containment="true"
   * @generated
   */
  VxlHead getHead();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlNegation#getHead <em>Head</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Head</em>' containment reference.
   * @see #getHead()
   * @generated
   */
  void setHead(VxlHead value);

} // VxlNegation
