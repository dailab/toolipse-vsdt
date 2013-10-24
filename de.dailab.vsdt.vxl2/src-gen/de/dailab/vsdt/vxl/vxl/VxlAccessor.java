/**
 */
package de.dailab.vsdt.vxl.vxl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accessor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlAccessor#getAccessor <em>Accessor</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlAccessor()
 * @model
 * @generated
 */
public interface VxlAccessor extends EObject
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
   * @see #setAccessor(VxlAccessor)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlAccessor_Accessor()
   * @model containment="true"
   * @generated
   */
  VxlAccessor getAccessor();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlAccessor#getAccessor <em>Accessor</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Accessor</em>' containment reference.
   * @see #getAccessor()
   * @generated
   */
  void setAccessor(VxlAccessor value);

} // VxlAccessor
