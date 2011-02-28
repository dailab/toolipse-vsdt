/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl.vxl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tail</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlTail#getOperator <em>Operator</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.VxlTail#getTerm <em>Term</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlTail()
 * @model
 * @generated
 */
public interface VxlTail extends EObject
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
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlTail_Operator()
   * @model
   * @generated
   */
  VxlOperator getOperator();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlTail#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see de.dailab.vsdt.vxl.vxl.VxlOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(VxlOperator value);

  /**
   * Returns the value of the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Term</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Term</em>' containment reference.
   * @see #setTerm(VxlTerm)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getVxlTail_Term()
   * @model containment="true"
   * @generated
   */
  VxlTerm getTerm();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.VxlTail#getTerm <em>Term</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Term</em>' containment reference.
   * @see #getTerm()
   * @generated
   */
  void setTerm(VxlTerm value);

} // VxlTail
