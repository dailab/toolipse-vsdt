/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TWait</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWait#getFor <em>For</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWait#getUntil <em>Until</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTWait()
 * @model extendedMetaData="name='tWait' kind='elementOnly'"
 * @generated
 */
public interface TWait extends TActivity {
	/**
	 * Returns the value of the '<em><b>For</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>For</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For</em>' attribute.
	 * @see #setFor(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTWait_For()
	 * @model unique="false" dataType="org.xmlsoap.schemas.ws._2003._03.business.process.TDurationExpr"
	 *        extendedMetaData="kind='attribute' name='for'"
	 * @generated
	 */
	String getFor();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWait#getFor <em>For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For</em>' attribute.
	 * @see #getFor()
	 * @generated
	 */
	void setFor(String value);

	/**
	 * Returns the value of the '<em><b>Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Until</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Until</em>' attribute.
	 * @see #setUntil(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTWait_Until()
	 * @model unique="false" dataType="org.xmlsoap.schemas.ws._2003._03.business.process.TDeadlineExpr"
	 *        extendedMetaData="kind='attribute' name='until'"
	 * @generated
	 */
	String getUntil();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWait#getUntil <em>Until</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Until</em>' attribute.
	 * @see #getUntil()
	 * @generated
	 */
	void setUntil(String value);

} // TWait