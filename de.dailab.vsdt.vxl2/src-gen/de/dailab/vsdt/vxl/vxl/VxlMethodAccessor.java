/**
 */
package de.dailab.vsdt.vxl.vxl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Accessor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlMethodAccessor#getFunction <em>Function</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlMethodAccessor()
 * @model
 * @generated
 */
public interface VxlMethodAccessor extends VxlAccessor
{
  /**
   * Returns the value of the '<em><b>Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function</em>' containment reference.
   * @see #setFunction(VxlFunction)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlMethodAccessor_Function()
   * @model containment="true"
   * @generated
   */
  VxlFunction getFunction();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlMethodAccessor#getFunction <em>Function</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function</em>' containment reference.
   * @see #getFunction()
   * @generated
   */
  void setFunction(VxlFunction value);

} // VxlMethodAccessor
