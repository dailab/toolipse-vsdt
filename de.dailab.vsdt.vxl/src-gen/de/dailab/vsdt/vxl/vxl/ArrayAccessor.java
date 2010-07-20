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
 *   <li>{@link de.dailab.vsdt.vxl.vxl.ArrayAccessor#getIndex <em>Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getArrayAccessor()
 * @model
 * @generated
 */
public interface ArrayAccessor extends Accessor
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
   * @see #setIndex(Term)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getArrayAccessor_Index()
   * @model containment="true"
   * @generated
   */
  Term getIndex();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.ArrayAccessor#getIndex <em>Index</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Index</em>' containment reference.
   * @see #getIndex()
   * @generated
   */
  void setIndex(Term value);

} // ArrayAccessor
