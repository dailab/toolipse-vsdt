/**
 */
package de.dailab.vsdt.vxl.vxl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlVariable#getName <em>Name</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlVariable#getAccessor <em>Accessor</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlVariable()
 * @model
 * @generated
 */
public interface VxlVariable extends VxlElement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlVariable_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlVariable#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Accessor</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Accessor</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Accessor</em>' containment reference.
   * @see #setAccessor(VxlAccessor)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlVariable_Accessor()
   * @model containment="true"
   * @generated
   */
  VxlAccessor getAccessor();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlVariable#getAccessor <em>Accessor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Accessor</em>' containment reference.
   * @see #getAccessor()
   * @generated
   */
  void setAccessor(VxlAccessor value);

} // VxlVariable
