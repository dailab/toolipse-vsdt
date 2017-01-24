/**
 */
package de.dailab.vsdt.vxl.vxl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constructor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlConstructor#getName <em>Name</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlConstructor#isEmpty <em>Empty</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlConstructor#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlConstructor()
 * @model
 * @generated
 */
public interface VxlConstructor extends VxlElement
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
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlConstructor_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlConstructor#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Empty</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Empty</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Empty</em>' attribute.
   * @see #setEmpty(boolean)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlConstructor_Empty()
   * @model
   * @generated
   */
  boolean isEmpty();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlConstructor#isEmpty <em>Empty</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Empty</em>' attribute.
   * @see #isEmpty()
   * @generated
   */
  void setEmpty(boolean value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(VxlListElement)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlConstructor_Body()
   * @model containment="true"
   * @generated
   */
  VxlListElement getBody();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlConstructor#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(VxlListElement value);

} // VxlConstructor
