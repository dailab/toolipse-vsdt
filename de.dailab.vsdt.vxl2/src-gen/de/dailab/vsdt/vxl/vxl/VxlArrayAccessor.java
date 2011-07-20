/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl.vxl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Accessor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlArrayAccessor#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlArrayAccessor()
 * @model
 * @generated
 */
public interface VxlArrayAccessor extends VxlAccessor
{
  /**
   * Returns the value of the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Index</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Index</em>' containment reference.
   * @see #setIndex(VxlTerm)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlArrayAccessor_Index()
   * @model containment="true"
   * @generated
   */
  VxlTerm getIndex();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlArrayAccessor#getIndex <em>Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index</em>' containment reference.
   * @see #getIndex()
   * @generated
   */
  void setIndex(VxlTerm value);

} // VxlArrayAccessor
