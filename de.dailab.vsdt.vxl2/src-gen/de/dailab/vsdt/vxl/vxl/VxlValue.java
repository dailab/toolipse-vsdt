/**
 */
package de.dailab.vsdt.vxl.vxl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlValue#getConst <em>Const</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlValue()
 * @model
 * @generated
 */
public interface VxlValue extends VxlElement
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
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlValue_Const()
   * @model
   * @generated
   */
  String getConst();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlValue#getConst <em>Const</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Const</em>' attribute.
   * @see #getConst()
   * @generated
   */
  void setConst(String value);

} // VxlValue
