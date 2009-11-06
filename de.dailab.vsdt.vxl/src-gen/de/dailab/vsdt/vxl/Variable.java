/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.Variable#getName <em>Name</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.Variable#getAccessor <em>Accessor</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.VXLPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends Atom
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
   * @see de.dailab.vsdt.vxl.VXLPackage#getVariable_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.Variable#getName <em>Name</em>}' attribute.
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
   * @see #setAccessor(Accessor)
   * @see de.dailab.vsdt.vxl.VXLPackage#getVariable_Accessor()
   * @model containment="true"
   * @generated
   */
  Accessor getAccessor();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.Variable#getAccessor <em>Accessor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Accessor</em>' containment reference.
   * @see #getAccessor()
   * @generated
   */
  void setAccessor(Accessor value);

} // Variable
