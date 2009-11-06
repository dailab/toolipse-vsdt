/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl;

import java.util.List;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TOperation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TOperation#getInput <em>Input</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TOperation#getOutput <em>Output</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TOperation#getFault <em>Fault</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TOperation#getOutput1 <em>Output1</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TOperation#getInput1 <em>Input1</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TOperation#getFault1 <em>Fault1</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TOperation#getName <em>Name</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TOperation#getParameterOrder <em>Parameter Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTOperation()
 * @model extendedMetaData="name='tOperation' kind='elementOnly'"
 * @generated
 */
public interface TOperation extends TExtensibleDocumented {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' containment reference.
	 * @see #setInput(TParam)
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTOperation_Input()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='input' namespace='##targetNamespace'"
	 * @generated
	 */
	TParam getInput();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TOperation#getInput <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' containment reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(TParam value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference.
	 * @see #setOutput(TParam)
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTOperation_Output()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='output' namespace='##targetNamespace'"
	 * @generated
	 */
	TParam getOutput();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TOperation#getOutput <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' containment reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(TParam value);

	/**
	 * Returns the value of the '<em><b>Fault</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.wsdl.TFault}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault</em>' containment reference list.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTOperation_Fault()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='fault' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TFault> getFault();

	/**
	 * Returns the value of the '<em><b>Output1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output1</em>' containment reference.
	 * @see #setOutput1(TParam)
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTOperation_Output1()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='output' namespace='##targetNamespace'"
	 * @generated
	 */
	TParam getOutput1();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TOperation#getOutput1 <em>Output1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output1</em>' containment reference.
	 * @see #getOutput1()
	 * @generated
	 */
	void setOutput1(TParam value);

	/**
	 * Returns the value of the '<em><b>Input1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input1</em>' containment reference.
	 * @see #setInput1(TParam)
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTOperation_Input1()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='input' namespace='##targetNamespace'"
	 * @generated
	 */
	TParam getInput1();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TOperation#getInput1 <em>Input1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input1</em>' containment reference.
	 * @see #getInput1()
	 * @generated
	 */
	void setInput1(TParam value);

	/**
	 * Returns the value of the '<em><b>Fault1</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.wsdl.TFault}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault1</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault1</em>' containment reference list.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTOperation_Fault1()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='fault' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TFault> getFault1();

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
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTOperation_Name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TOperation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parameter Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Order</em>' attribute.
	 * @see #setParameterOrder(List)
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTOperation_ParameterOrder()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NMTOKENS" many="false"
	 *        extendedMetaData="kind='attribute' name='parameterOrder'"
	 * @generated
	 */
	List<String> getParameterOrder();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TOperation#getParameterOrder <em>Parameter Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Order</em>' attribute.
	 * @see #getParameterOrder()
	 * @generated
	 */
	void setParameterOrder(List<String> value);

} // TOperation