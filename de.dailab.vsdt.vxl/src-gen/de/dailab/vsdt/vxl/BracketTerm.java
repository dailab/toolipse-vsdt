/**
 * <copyright>
 * </copyright>
 *
 */
package de.dailab.vsdt.vxl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bracket Term</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.vxl.BracketTerm#getTerm <em>Term</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.vxl.VXLPackage#getBracketTerm()
 * @model
 * @generated
 */
public interface BracketTerm extends Head
{
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
   * @see de.dailab.vsdt.vxl.VXLPackage#getBracketTerm_Term()
   * @model containment="true"
   * @generated
   */
  Term getTerm();

  /**
   * Sets the value of the '{@link de.dailab.vsdt.vxl.BracketTerm#getTerm <em>Term</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Term</em>' containment reference.
   * @see #getTerm()
   * @generated
   */
  void setTerm(Term value);

} // BracketTerm
