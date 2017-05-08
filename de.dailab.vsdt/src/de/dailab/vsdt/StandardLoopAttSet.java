/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Standard Loop Att Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.StandardLoopAttSet#getLoopCondition <em>Loop Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.StandardLoopAttSet#getLoopMaximum <em>Loop Maximum</em>}</li>
 *   <li>{@link de.dailab.vsdt.StandardLoopAttSet#isTestBefore <em>Test Before</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.VsdtPackage#getStandardLoopAttSet()
 * @model
 * @generated
 */
public interface StandardLoopAttSet extends LoopAttributeSet {
	/**
	 * Returns the value of the '<em><b>Loop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Condition</em>' containment reference.
	 * @see #setLoopCondition(Expression)
	 * @see de.dailab.vsdt.VsdtPackage#getStandardLoopAttSet_LoopCondition()
	 * @model containment="true"
	 * @generated
	 */
	Expression getLoopCondition();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.StandardLoopAttSet#getLoopCondition <em>Loop Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Condition</em>' containment reference.
	 * @see #getLoopCondition()
	 * @generated
	 */
	void setLoopCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Loop Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Maximum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Maximum</em>' attribute.
	 * @see #setLoopMaximum(int)
	 * @see de.dailab.vsdt.VsdtPackage#getStandardLoopAttSet_LoopMaximum()
	 * @model
	 * @generated
	 */
	int getLoopMaximum();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.StandardLoopAttSet#getLoopMaximum <em>Loop Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Maximum</em>' attribute.
	 * @see #getLoopMaximum()
	 * @generated
	 */
	void setLoopMaximum(int value);

	/**
	 * Returns the value of the '<em><b>Test Before</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Before</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Before</em>' attribute.
	 * @see #setTestBefore(boolean)
	 * @see de.dailab.vsdt.VsdtPackage#getStandardLoopAttSet_TestBefore()
	 * @model default="true"
	 * @generated
	 */
	boolean isTestBefore();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.StandardLoopAttSet#isTestBefore <em>Test Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Before</em>' attribute.
	 * @see #isTestBefore()
	 * @generated
	 */
	void setTestBefore(boolean value);

} // StandardLoopAttSet
