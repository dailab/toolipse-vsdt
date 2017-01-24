/**
 */
package de.dailab.vsdt.vxl.vxl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlMapElement#getKey <em>Key</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlMapElement#getValue <em>Value</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlMapElement#getRest <em>Rest</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlMapElement()
 * @model
 * @generated
 */
public interface VxlMapElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key</em>' containment reference.
   * @see #setKey(VxlTerm)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlMapElement_Key()
   * @model containment="true"
   * @generated
   */
  VxlTerm getKey();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlMapElement#getKey <em>Key</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Key</em>' containment reference.
   * @see #getKey()
   * @generated
   */
  void setKey(VxlTerm value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(VxlTerm)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlMapElement_Value()
   * @model containment="true"
   * @generated
   */
  VxlTerm getValue();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlMapElement#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(VxlTerm value);

  /**
   * Returns the value of the '<em><b>Rest</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rest</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rest</em>' containment reference.
   * @see #setRest(VxlMapElement)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlMapElement_Rest()
   * @model containment="true"
   * @generated
   */
  VxlMapElement getRest();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlMapElement#getRest <em>Rest</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rest</em>' containment reference.
   * @see #getRest()
   * @generated
   */
  void setRest(VxlMapElement value);

} // VxlMapElement
