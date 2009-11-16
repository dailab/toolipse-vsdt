/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.Value#getConst <em>Const</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.VxlPackage#getValue()
 * @model
 * @generated
 */
public interface Value extends Atom
{
  /**
   * Returns the value of the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Const</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Const</em>' attribute.
   * @see #setConst(String)
   * @see de.dailab.vsdt.vxl.VxlPackage#getValue_Const()
   * @model
   * @generated
   */
  String getConst();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.Value#getConst <em>Const</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Const</em>' attribute.
   * @see #getConst()
   * @generated
   */
  void setConst(String value);

} // Value
