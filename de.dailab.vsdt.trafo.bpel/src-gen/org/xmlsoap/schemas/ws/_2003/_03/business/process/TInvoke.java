/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TInvoke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCorrelations <em>Correlations</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCatch <em>Catch</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCatchAll <em>Catch All</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCompensationHandler <em>Compensation Handler</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getInputVariable <em>Input Variable</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getOutputVariable <em>Output Variable</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getPortType <em>Port Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTInvoke()
 * @model extendedMetaData="name='tInvoke' kind='elementOnly'"
 * @generated
 */
public interface TInvoke extends TActivity {
	/**
	 * Returns the value of the '<em><b>Correlations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlations</em>' containment reference.
	 * @see #setCorrelations(TCorrelationsWithPattern)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTInvoke_Correlations()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='correlations' namespace='##targetNamespace'"
	 * @generated
	 */
	TCorrelationsWithPattern getCorrelations();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCorrelations <em>Correlations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Correlations</em>' containment reference.
	 * @see #getCorrelations()
	 * @generated
	 */
	void setCorrelations(TCorrelationsWithPattern value);

	/**
	 * Returns the value of the '<em><b>Catch</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TCatch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catch</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catch</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTInvoke_Catch()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='catch' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TCatch> getCatch();

	/**
	 * Returns the value of the '<em><b>Catch All</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catch All</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catch All</em>' containment reference.
	 * @see #setCatchAll(TActivityOrCompensateContainer)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTInvoke_CatchAll()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='catchAll' namespace='##targetNamespace'"
	 * @generated
	 */
	TActivityOrCompensateContainer getCatchAll();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCatchAll <em>Catch All</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catch All</em>' containment reference.
	 * @see #getCatchAll()
	 * @generated
	 */
	void setCatchAll(TActivityOrCompensateContainer value);

	/**
	 * Returns the value of the '<em><b>Compensation Handler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compensation Handler</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compensation Handler</em>' containment reference.
	 * @see #setCompensationHandler(TCompensationHandler)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTInvoke_CompensationHandler()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='compensationHandler' namespace='##targetNamespace'"
	 * @generated
	 */
	TCompensationHandler getCompensationHandler();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCompensationHandler <em>Compensation Handler</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compensation Handler</em>' containment reference.
	 * @see #getCompensationHandler()
	 * @generated
	 */
	void setCompensationHandler(TCompensationHandler value);

	/**
	 * Returns the value of the '<em><b>Input Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Variable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Variable</em>' attribute.
	 * @see #setInputVariable(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTInvoke_InputVariable()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName"
	 *        extendedMetaData="kind='attribute' name='inputVariable'"
	 * @generated
	 */
	String getInputVariable();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getInputVariable <em>Input Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Variable</em>' attribute.
	 * @see #getInputVariable()
	 * @generated
	 */
	void setInputVariable(String value);

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see #setOperation(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTInvoke_Operation()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='operation'"
	 * @generated
	 */
	String getOperation();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(String value);

	/**
	 * Returns the value of the '<em><b>Output Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Variable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Variable</em>' attribute.
	 * @see #setOutputVariable(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTInvoke_OutputVariable()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName"
	 *        extendedMetaData="kind='attribute' name='outputVariable'"
	 * @generated
	 */
	String getOutputVariable();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getOutputVariable <em>Output Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Variable</em>' attribute.
	 * @see #getOutputVariable()
	 * @generated
	 */
	void setOutputVariable(String value);

	/**
	 * Returns the value of the '<em><b>Partner Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner Link</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner Link</em>' attribute.
	 * @see #setPartnerLink(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTInvoke_PartnerLink()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='partnerLink'"
	 * @generated
	 */
	String getPartnerLink();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getPartnerLink <em>Partner Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner Link</em>' attribute.
	 * @see #getPartnerLink()
	 * @generated
	 */
	void setPartnerLink(String value);

	/**
	 * Returns the value of the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Type</em>' attribute.
	 * @see #setPortType(QName)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTInvoke_PortType()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
	 *        extendedMetaData="kind='attribute' name='portType'"
	 * @generated
	 */
	QName getPortType();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getPortType <em>Port Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Type</em>' attribute.
	 * @see #getPortType()
	 * @generated
	 */
	void setPortType(QName value);

} // TInvoke