/**
 */
package de.dailab.vsdt.vxl.vxl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlMap#isEmpty <em>Empty</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlMap#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlMap()
 * @model
 * @generated
 */
public interface VxlMap extends VxlElement
{
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
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlMap_Empty()
   * @model
   * @generated
   */
  boolean isEmpty();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlMap#isEmpty <em>Empty</em>}' attribute.
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
   * @see #setBody(VxlMapElement)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlMap_Body()
   * @model containment="true"
   * @generated
   */
  VxlMapElement getBody();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlMap#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(VxlMapElement value);

} // VxlMap
