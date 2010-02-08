/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Negation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.Negation#getHead <em>Head</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.VxlPackage#getNegation()
 * @model
 * @generated
 */
public interface Negation extends Head
{
  /**
   * Returns the value of the '<em><b>Head</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Head</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Head</em>' containment reference.
   * @see #setHead(Head)
   * @see de.dailab.vsdt.vxl.VxlPackage#getNegation_Head()
   * @model containment="true"
   * @generated
   */
  Head getHead();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.Negation#getHead <em>Head</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Head</em>' containment reference.
   * @see #getHead()
   * @generated
   */
  void setHead(Head value);

} // Negation
