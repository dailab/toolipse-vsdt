/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TActivity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getTarget <em>Target</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getSource <em>Source</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getJoinCondition <em>Join Condition</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getName <em>Name</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getSuppressJoinFailure <em>Suppress Join Failure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivity()
 * @model extendedMetaData="name='tActivity' kind='elementOnly'"
 * @generated
 */
public interface TActivity extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TTarget}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivity_Target()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='target' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TTarget> getTarget();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TSource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivity_Source()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='source' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TSource> getSource();

	/**
	 * Returns the value of the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Join Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Join Condition</em>' attribute.
	 * @see #setJoinCondition(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivity_JoinCondition()
	 * @model unique="false" dataType="org.xmlsoap.schemas.ws._2003._03.business.process.TBooleanExpr"
	 *        extendedMetaData="kind='attribute' name='joinCondition'"
	 * @generated
	 */
	String getJoinCondition();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getJoinCondition <em>Join Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Join Condition</em>' attribute.
	 * @see #getJoinCondition()
	 * @generated
	 */
	void setJoinCondition(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivity_Name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * The default value is <code>"no"</code>.
	 * The literals are from the enumeration {@link org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suppress Join Failure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suppress Join Failure</em>' attribute.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
	 * @see #isSetSuppressJoinFailure()
	 * @see #unsetSuppressJoinFailure()
	 * @see #setSuppressJoinFailure(TBoolean)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTActivity_SuppressJoinFailure()
	 * @model default="no" unique="false" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='suppressJoinFailure'"
	 * @generated
	 */
	TBoolean getSuppressJoinFailure();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getSuppressJoinFailure <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suppress Join Failure</em>' attribute.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
	 * @see #isSetSuppressJoinFailure()
	 * @see #unsetSuppressJoinFailure()
	 * @see #getSuppressJoinFailure()
	 * @generated
	 */
	void setSuppressJoinFailure(TBoolean value);

	/**
	 * Unsets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getSuppressJoinFailure <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSuppressJoinFailure()
	 * @see #getSuppressJoinFailure()
	 * @see #setSuppressJoinFailure(TBoolean)
	 * @generated
	 */
	void unsetSuppressJoinFailure();

	/**
	 * Returns whether the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getSuppressJoinFailure <em>Suppress Join Failure</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Suppress Join Failure</em>' attribute is set.
	 * @see #unsetSuppressJoinFailure()
	 * @see #getSuppressJoinFailure()
	 * @see #setSuppressJoinFailure(TBoolean)
	 * @generated
	 */
	boolean isSetSuppressJoinFailure();

} // TActivity