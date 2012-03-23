/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans;

import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Try Catch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jiacbeans.TryCatch#getTry <em>Try</em>}</li>
 *   <li>{@link jiacbeans.TryCatch#getCatches <em>Catches</em>}</li>
 *   <li>{@link jiacbeans.TryCatch#getFinally <em>Finally</em>}</li>
 * </ul>
 * </p>
 *
 * @see jiacbeans.JiacbeansPackage#getTryCatch()
 * @model
 * @generated
 */
public interface TryCatch extends Script {
	/**
	 * Returns the value of the '<em><b>Try</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Try</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Try</em>' reference.
	 * @see #setTry(Script)
	 * @see jiacbeans.JiacbeansPackage#getTryCatch_Try()
	 * @model required="true"
	 * @generated
	 */
	Script getTry();

	/**
	 * Sets the value of the '{@link jiacbeans.TryCatch#getTry <em>Try</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Try</em>' reference.
	 * @see #getTry()
	 * @generated
	 */
	void setTry(Script value);

	/**
	 * Returns the value of the '<em><b>Catches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catches</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catches</em>' attribute.
	 * @see #setCatches(Map)
	 * @see jiacbeans.JiacbeansPackage#getTryCatch_Catches()
	 * @model required="true" transient="true"
	 *        extendedMetaData="wildcards='' name=''"
	 * @generated
	 */
	Map<String, Script> getCatches();

	/**
	 * Sets the value of the '{@link jiacbeans.TryCatch#getCatches <em>Catches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catches</em>' attribute.
	 * @see #getCatches()
	 * @generated
	 */
	void setCatches(Map<String, Script> value);

	/**
	 * Returns the value of the '<em><b>Finally</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Finally</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Finally</em>' reference.
	 * @see #setFinally(Script)
	 * @see jiacbeans.JiacbeansPackage#getTryCatch_Finally()
	 * @model
	 * @generated
	 */
	Script getFinally();

	/**
	 * Sets the value of the '{@link jiacbeans.TryCatch#getFinally <em>Finally</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Finally</em>' reference.
	 * @see #getFinally()
	 * @generated
	 */
	void setFinally(Script value);

} // TryCatch
