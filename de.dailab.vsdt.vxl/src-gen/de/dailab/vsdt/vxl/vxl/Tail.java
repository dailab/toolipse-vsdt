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
 *   <li>{@link de.dailab.vsdt.vxl.vxl.Tail#getOperator <em>Operator</em>}</li>
 *   <li>{@link de.dailab.vsdt.vxl.vxl.Tail#getTerm <em>Term</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getTail()
 * @model
 * @generated
 */
public interface Tail extends EObject
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link de.dailab.vsdt.vxl.vxl.Operator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see de.dailab.vsdt.vxl.vxl.Operator
   * @see #setOperator(Operator)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getTail_Operator()
   * @model
   * @generated
   */
  Operator getOperator();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.Tail#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see de.dailab.vsdt.vxl.vxl.Operator
   * @see #getOperator()
   * @generated
   */
  void setOperator(Operator value);

  /**
   * Returns the value of the '<em><b>Term</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Term</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Term</em>' containment reference.
   * @see #setTerm(Term)
   * @see de.dailab.vsdt.vxl.vxl.VxlPackage#getTail_Term()
   * @model containment="true"
   * @generated
   */
  Term getTerm();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.vxl.Tail#getTerm <em>Term</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Term</em>' containment reference.
   * @see #getTerm()
   * @generated
   */
  void setTerm(Term value);

} // Tail
