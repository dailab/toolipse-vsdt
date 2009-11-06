/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TBinding Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TBindingOperation#getInput <em>Input</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TBindingOperation#getOutput <em>Output</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TBindingOperation#getFault <em>Fault</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TBindingOperation#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTBindingOperation()
 * @model extendedMetaData="name='tBindingOperation' kind='elementOnly'"
 * @generated
 */
public interface TBindingOperation extends TExtensibleDocumented {
	/**
	 * Returns the value of the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input</em>' containment reference.
	 * @see #setInput(TBindingOperationMessage)
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTBindingOperation_Input()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='input' namespace='##targetNamespace'"
	 * @generated
	 */
	TBindingOperationMessage getInput();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TBindingOperation#getInput <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' containment reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(TBindingOperationMessage value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference.
	 * @see #setOutput(TBindingOperationMessage)
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTBindingOperation_Output()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='output' namespace='##targetNamespace'"
	 * @generated
	 */
	TBindingOperationMessage getOutput();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TBindingOperation#getOutput <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' containment reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(TBindingOperationMessage value);

	/**
	 * Returns the value of the '<em><b>Fault</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.wsdl.TBindingOperationFault}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fault</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fault</em>' containment reference list.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTBindingOperation_Fault()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='fault' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TBindingOperationFault> getFault();

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
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTBindingOperation_Name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TBindingOperation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TBindingOperation