/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.xmlsoap.schemas.wsdl.DocumentRoot;
import org.xmlsoap.schemas.wsdl.TBinding;
import org.xmlsoap.schemas.wsdl.TBindingOperation;
import org.xmlsoap.schemas.wsdl.TBindingOperationFault;
import org.xmlsoap.schemas.wsdl.TBindingOperationMessage;
import org.xmlsoap.schemas.wsdl.TDefinitions;
import org.xmlsoap.schemas.wsdl.TDocumentation;
import org.xmlsoap.schemas.wsdl.TDocumented;
import org.xmlsoap.schemas.wsdl.TFault;
import org.xmlsoap.schemas.wsdl.TImport;
import org.xmlsoap.schemas.wsdl.TMessage;
import org.xmlsoap.schemas.wsdl.TOperation;
import org.xmlsoap.schemas.wsdl.TParam;
import org.xmlsoap.schemas.wsdl.TPart;
import org.xmlsoap.schemas.wsdl.TPort;
import org.xmlsoap.schemas.wsdl.TPortType;
import org.xmlsoap.schemas.wsdl.TService;
import org.xmlsoap.schemas.wsdl.TTypes;
import org.xmlsoap.schemas.wsdl.WsdlFactory;
import org.xmlsoap.schemas.wsdl.WsdlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WsdlFactoryImpl extends EFactoryImpl implements WsdlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WsdlFactory init() {
		try {
			WsdlFactory theWsdlFactory = (WsdlFactory)EPackage.Registry.INSTANCE.getEFactory("http://schemas.xmlsoap.org/wsdl/"); 
			if (theWsdlFactory != null) {
				return theWsdlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WsdlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WsdlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WsdlPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case WsdlPackage.TBINDING: return createTBinding();
			case WsdlPackage.TBINDING_OPERATION: return createTBindingOperation();
			case WsdlPackage.TBINDING_OPERATION_FAULT: return createTBindingOperationFault();
			case WsdlPackage.TBINDING_OPERATION_MESSAGE: return createTBindingOperationMessage();
			case WsdlPackage.TDEFINITIONS: return createTDefinitions();
			case WsdlPackage.TDOCUMENTATION: return createTDocumentation();
			case WsdlPackage.TDOCUMENTED: return createTDocumented();
			case WsdlPackage.TFAULT: return createTFault();
			case WsdlPackage.TIMPORT: return createTImport();
			case WsdlPackage.TMESSAGE: return createTMessage();
			case WsdlPackage.TOPERATION: return createTOperation();
			case WsdlPackage.TPARAM: return createTParam();
			case WsdlPackage.TPART: return createTPart();
			case WsdlPackage.TPORT: return createTPort();
			case WsdlPackage.TPORT_TYPE: return createTPortType();
			case WsdlPackage.TSERVICE: return createTService();
			case WsdlPackage.TTYPES: return createTTypes();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBinding createTBinding() {
		TBindingImpl tBinding = new TBindingImpl();
		return tBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBindingOperation createTBindingOperation() {
		TBindingOperationImpl tBindingOperation = new TBindingOperationImpl();
		return tBindingOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBindingOperationFault createTBindingOperationFault() {
		TBindingOperationFaultImpl tBindingOperationFault = new TBindingOperationFaultImpl();
		return tBindingOperationFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBindingOperationMessage createTBindingOperationMessage() {
		TBindingOperationMessageImpl tBindingOperationMessage = new TBindingOperationMessageImpl();
		return tBindingOperationMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDefinitions createTDefinitions() {
		TDefinitionsImpl tDefinitions = new TDefinitionsImpl();
		return tDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDocumentation createTDocumentation() {
		TDocumentationImpl tDocumentation = new TDocumentationImpl();
		return tDocumentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDocumented createTDocumented() {
		TDocumentedImpl tDocumented = new TDocumentedImpl();
		return tDocumented;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TFault createTFault() {
		TFaultImpl tFault = new TFaultImpl();
		return tFault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TImport createTImport() {
		TImportImpl tImport = new TImportImpl();
		return tImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TMessage createTMessage() {
		TMessageImpl tMessage = new TMessageImpl();
		return tMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TOperation createTOperation() {
		TOperationImpl tOperation = new TOperationImpl();
		return tOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TParam createTParam() {
		TParamImpl tParam = new TParamImpl();
		return tParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPart createTPart() {
		TPartImpl tPart = new TPartImpl();
		return tPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPort createTPort() {
		TPortImpl tPort = new TPortImpl();
		return tPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TPortType createTPortType() {
		TPortTypeImpl tPortType = new TPortTypeImpl();
		return tPortType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TService createTService() {
		TServiceImpl tService = new TServiceImpl();
		return tService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TTypes createTTypes() {
		TTypesImpl tTypes = new TTypesImpl();
		return tTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WsdlPackage getWsdlPackage() {
		return (WsdlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static WsdlPackage getPackage() {
		return WsdlPackage.eINSTANCE;
	}

} //WsdlFactoryImpl
