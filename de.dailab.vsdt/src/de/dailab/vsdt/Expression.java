/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.Expression#getExpression <em>Expression</em>}</li>
 *   <li>{@link de.dailab.vsdt.Expression#getLanguage <em>Language</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.VsdtPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see de.dailab.vsdt.VsdtPackage#getExpression_Expression()
	 * @model required="true"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Expression#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see #setLanguage(String)
	 * @see de.dailab.vsdt.VsdtPackage#getExpression_Language()
	 * @model
	 * @generated
	 */
	String getLanguage();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Expression#getLanguage <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(String value);

	/**
	 * <!-- begin-user-doc -->
	 * Returns the Expression language set in the Parent Diagram, if any.
	 * The Global Expression Language is assumed if no Language is set for this Expression
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getGlobalExpressionLanguage();

	/**
	 * <!-- begin-user-doc -->
	 * This method returns the expression language to be used by this specific expression.
	 * If the language attribute is set and not empty, then that language will be returned,
	 * otherwise the global expression language will be used. In any case, the result
	 * will be null if the language is an empty string.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getExpressionLanguageToBeUsed();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean validate();

} // Expression
