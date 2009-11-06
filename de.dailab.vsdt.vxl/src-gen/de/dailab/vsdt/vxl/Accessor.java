/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accessor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.Accessor#getAccessor <em>Accessor</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.VXLPackage#getAccessor()
 * @model
 * @generated
 */
public interface Accessor extends EObject
{
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
   * @see de.dailab.vsdt.vxl.VXLPackage#getAccessor_Accessor()
   * @model containment="true"
   * @generated
   */
  Accessor getAccessor();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.Accessor#getAccessor <em>Accessor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Accessor</em>' containment reference.
   * @see #getAccessor()
   * @generated
   */
  void setAccessor(Accessor value);

} // Accessor
