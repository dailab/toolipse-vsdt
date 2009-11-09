/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn;

import org.eclipse.emf.common.util.EList;

import de.dailab.vsdt.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Disjunctive Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression#getExpressions <em>Expressions</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getDisjunctiveExpression()
 * @model
 * @generated
 */
public interface DisjunctiveExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' attribute list.
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getDisjunctiveExpression_Expressions()
	 * @model
	 * @generated
	 */
	EList<String> getExpressions();

} // DisjunctiveExpression
