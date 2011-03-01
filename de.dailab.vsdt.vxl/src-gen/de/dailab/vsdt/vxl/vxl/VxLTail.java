/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl.vxl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vx LTail</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxLTail#getOperator <em>Operator</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxLTail#getTail <em>Tail</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxLTail()
 * @model
 * @generated
 */
public interface VxLTail extends EObject
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link de.dailab.vsdt.vxl.vxl.VxlOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see de.dailab.vsdt.vxl.vxl.VxlOperator
   * @see #setOperator(VxlOperator)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxLTail_Operator()
   * @model
   * @generated
   */
  VxlOperator getOperator();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxLTail#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see de.dailab.vsdt.vxl.vxl.VxlOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(VxlOperator value);

  /**
   * Returns the value of the '<em><b>Tail</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tail</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tail</em>' containment reference.
   * @see #setTail(VxlTerm)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxLTail_Tail()
   * @model containment="true"
   * @generated
   */
  VxlTerm getTail();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxLTail#getTail <em>Tail</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tail</em>' containment reference.
   * @see #getTail()
   * @generated
   */
  void setTail(VxlTerm value);

} // VxLTail
