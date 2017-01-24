/**
 */
package de.dailab.vsdt.vxl.vxl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlListElement#getFirst <em>First</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlListElement#getRest <em>Rest</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlListElement()
 * @model
 * @generated
 */
public interface VxlListElement extends EObject
{
  /**
   * Returns the value of the '<em><b>First</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First</em>' containment reference.
   * @see #setFirst(VxlTerm)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlListElement_First()
   * @model containment="true"
   * @generated
   */
  VxlTerm getFirst();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlListElement#getFirst <em>First</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First</em>' containment reference.
   * @see #getFirst()
   * @generated
   */
  void setFirst(VxlTerm value);

  /**
   * Returns the value of the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rest</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rest</em>' containment reference.
   * @see #setRest(VxlListElement)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlListElement_Rest()
   * @model containment="true"
   * @generated
   */
  VxlListElement getRest();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlListElement#getRest <em>Rest</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rest</em>' containment reference.
   * @see #getRest()
   * @generated
   */
  void setRest(VxlListElement value);

} // VxlListElement
