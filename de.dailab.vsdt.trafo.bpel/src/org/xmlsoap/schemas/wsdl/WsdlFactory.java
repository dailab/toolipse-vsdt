/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.xmlsoap.schemas.wsdl.WsdlPackage
 * @generated
 */
public interface WsdlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WsdlFactory eINSTANCE = org.xmlsoap.schemas.wsdl.impl.WsdlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>TBinding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TBinding</em>'.
	 * @generated
	 */
	TBinding createTBinding();

	/**
	 * Returns a new object of class '<em>TBinding Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TBinding Operation</em>'.
	 * @generated
	 */
	TBindingOperation createTBindingOperation();

	/**
	 * Returns a new object of class '<em>TBinding Operation Fault</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TBinding Operation Fault</em>'.
	 * @generated
	 */
	TBindingOperationFault createTBindingOperationFault();

	/**
	 * Returns a new object of class '<em>TBinding Operation Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TBinding Operation Message</em>'.
	 * @generated
	 */
	TBindingOperationMessage createTBindingOperationMessage();

	/**
	 * Returns a new object of class '<em>TDefinitions</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TDefinitions</em>'.
	 * @generated
	 */
	TDefinitions createTDefinitions();

	/**
	 * Returns a new object of class '<em>TDocumentation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TDocumentation</em>'.
	 * @generated
	 */
	TDocumentation createTDocumentation();

	/**
	 * Returns a new object of class '<em>TDocumented</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TDocumented</em>'.
	 * @generated
	 */
	TDocumented createTDocumented();

	/**
	 * Returns a new object of class '<em>TFault</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TFault</em>'.
	 * @generated
	 */
	TFault createTFault();

	/**
	 * Returns a new object of class '<em>TImport</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TImport</em>'.
	 * @generated
	 */
	TImport createTImport();

	/**
	 * Returns a new object of class '<em>TMessage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TMessage</em>'.
	 * @generated
	 */
	TMessage createTMessage();

	/**
	 * Returns a new object of class '<em>TOperation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TOperation</em>'.
	 * @generated
	 */
	TOperation createTOperation();

	/**
	 * Returns a new object of class '<em>TParam</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TParam</em>'.
	 * @generated
	 */
	TParam createTParam();

	/**
	 * Returns a new object of class '<em>TPart</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TPart</em>'.
	 * @generated
	 */
	TPart createTPart();

	/**
	 * Returns a new object of class '<em>TPort</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TPort</em>'.
	 * @generated
	 */
	TPort createTPort();

	/**
	 * Returns a new object of class '<em>TPort Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TPort Type</em>'.
	 * @generated
	 */
	TPortType createTPortType();

	/**
	 * Returns a new object of class '<em>TService</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TService</em>'.
	 * @generated
	 */
	TService createTService();

	/**
	 * Returns a new object of class '<em>TTypes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TTypes</em>'.
	 * @generated
	 */
	TTypes createTTypes();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WsdlPackage getWsdlPackage();

} //WsdlFactory
