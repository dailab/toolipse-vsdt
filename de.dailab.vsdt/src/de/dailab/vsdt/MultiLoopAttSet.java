/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Loop Att Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.MultiLoopAttSet#getMI_Condition <em>MI Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.MultiLoopAttSet#getMI_FlowCondition <em>MI Flow Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.MultiLoopAttSet#getComplexMI_FlowCondition <em>Complex MI Flow Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.MultiLoopAttSet#isSequential <em>Sequential</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.VsdtPackage#getMultiLoopAttSet()
 * @model
 * @generated
 */
public interface MultiLoopAttSet extends LoopAttributeSet {
	/**
	 * Returns the value of the '<em><b>MI Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MI Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MI Condition</em>' containment reference.
	 * @see #setMI_Condition(Expression)
	 * @see de.dailab.vsdt.VsdtPackage#getMultiLoopAttSet_MI_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getMI_Condition();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.MultiLoopAttSet#getMI_Condition <em>MI Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MI Condition</em>' containment reference.
	 * @see #getMI_Condition()
	 * @generated
	 */
	void setMI_Condition(Expression value);

	/**
	 * Returns the value of the '<em><b>MI Flow Condition</b></em>' attribute.
	 * The literals are from the enumeration {@link de.dailab.vsdt.FlowConditionTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>MI Flow Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>MI Flow Condition</em>' attribute.
	 * @see de.dailab.vsdt.FlowConditionTypes
	 * @see #setMI_FlowCondition(FlowConditionTypes)
	 * @see de.dailab.vsdt.VsdtPackage#getMultiLoopAttSet_MI_FlowCondition()
	 * @model required="true"
	 * @generated
	 */
	FlowConditionTypes getMI_FlowCondition();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.MultiLoopAttSet#getMI_FlowCondition <em>MI Flow Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>MI Flow Condition</em>' attribute.
	 * @see de.dailab.vsdt.FlowConditionTypes
	 * @see #getMI_FlowCondition()
	 * @generated
	 */
	void setMI_FlowCondition(FlowConditionTypes value);

	/**
	 * Returns the value of the '<em><b>Complex MI Flow Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Complex MI Flow Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Complex MI Flow Condition</em>' containment reference.
	 * @see #setComplexMI_FlowCondition(Expression)
	 * @see de.dailab.vsdt.VsdtPackage#getMultiLoopAttSet_ComplexMI_FlowCondition()
	 * @model containment="true"
	 * @generated
	 */
	Expression getComplexMI_FlowCondition();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.MultiLoopAttSet#getComplexMI_FlowCondition <em>Complex MI Flow Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Complex MI Flow Condition</em>' containment reference.
	 * @see #getComplexMI_FlowCondition()
	 * @generated
	 */
	void setComplexMI_FlowCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Sequential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequential</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequential</em>' attribute.
	 * @see #setSequential(boolean)
	 * @see de.dailab.vsdt.VsdtPackage#getMultiLoopAttSet_Sequential()
	 * @model
	 * @generated
	 */
	boolean isSequential();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.MultiLoopAttSet#isSequential <em>Sequential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequential</em>' attribute.
	 * @see #isSequential()
	 * @generated
	 */
	void setSequential(boolean value);

} // MultiLoopAttSet
