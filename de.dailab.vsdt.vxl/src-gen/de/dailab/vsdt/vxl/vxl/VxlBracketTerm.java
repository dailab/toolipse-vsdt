/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl.vxl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bracket Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlBracketTerm#getTerm <em>Term</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlBracketTerm()
 * @model
 * @generated
 */
public interface VxlBracketTerm extends VxlHead
{
  /**
   * Returns the value of the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Term</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Term</em>' containment reference.
   * @see #setTerm(VxlTerm)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlBracketTerm_Term()
   * @model containment="true"
   * @generated
   */
  VxlTerm getTerm();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlBracketTerm#getTerm <em>Term</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Term</em>' containment reference.
   * @see #getTerm()
   * @generated
   */
  void setTerm(VxlTerm value);

} // VxlBracketTerm
