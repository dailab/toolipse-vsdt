/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.xmlsoap.schemas.wsdl.DocumentRoot;
import org.xmlsoap.schemas.wsdl.TBinding;
import org.xmlsoap.schemas.wsdl.TBindingOperation;
import org.xmlsoap.schemas.wsdl.TBindingOperationFault;
import org.xmlsoap.schemas.wsdl.TBindingOperationMessage;
import org.xmlsoap.schemas.wsdl.TDefinitions;
import org.xmlsoap.schemas.wsdl.TDocumentation;
import org.xmlsoap.schemas.wsdl.TDocumented;
import org.xmlsoap.schemas.wsdl.TExtensibilityElement;
import org.xmlsoap.schemas.wsdl.TExtensibleAttributesDocumented;
import org.xmlsoap.schemas.wsdl.TExtensibleDocumented;
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
import org.xmlsoap.schemas.wsdl.WsdlPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.xmlsoap.schemas.wsdl.WsdlPackage
 * @generated
 */
public class WsdlSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WsdlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WsdlSwitch() {
		if (modelPackage == null) {
			modelPackage = WsdlPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case WsdlPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TBINDING: {
				TBinding tBinding = (TBinding)theEObject;
				T result = caseTBinding(tBinding);
				if (result == null) result = caseTExtensibleDocumented(tBinding);
				if (result == null) result = caseTDocumented(tBinding);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TBINDING_OPERATION: {
				TBindingOperation tBindingOperation = (TBindingOperation)theEObject;
				T result = caseTBindingOperation(tBindingOperation);
				if (result == null) result = caseTExtensibleDocumented(tBindingOperation);
				if (result == null) result = caseTDocumented(tBindingOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TBINDING_OPERATION_FAULT: {
				TBindingOperationFault tBindingOperationFault = (TBindingOperationFault)theEObject;
				T result = caseTBindingOperationFault(tBindingOperationFault);
				if (result == null) result = caseTExtensibleDocumented(tBindingOperationFault);
				if (result == null) result = caseTDocumented(tBindingOperationFault);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TBINDING_OPERATION_MESSAGE: {
				TBindingOperationMessage tBindingOperationMessage = (TBindingOperationMessage)theEObject;
				T result = caseTBindingOperationMessage(tBindingOperationMessage);
				if (result == null) result = caseTExtensibleDocumented(tBindingOperationMessage);
				if (result == null) result = caseTDocumented(tBindingOperationMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TDEFINITIONS: {
				TDefinitions tDefinitions = (TDefinitions)theEObject;
				T result = caseTDefinitions(tDefinitions);
				if (result == null) result = caseTExtensibleDocumented(tDefinitions);
				if (result == null) result = caseTDocumented(tDefinitions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TDOCUMENTATION: {
				TDocumentation tDocumentation = (TDocumentation)theEObject;
				T result = caseTDocumentation(tDocumentation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TDOCUMENTED: {
				TDocumented tDocumented = (TDocumented)theEObject;
				T result = caseTDocumented(tDocumented);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TEXTENSIBILITY_ELEMENT: {
				TExtensibilityElement tExtensibilityElement = (TExtensibilityElement)theEObject;
				T result = caseTExtensibilityElement(tExtensibilityElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TEXTENSIBLE_ATTRIBUTES_DOCUMENTED: {
				TExtensibleAttributesDocumented tExtensibleAttributesDocumented = (TExtensibleAttributesDocumented)theEObject;
				T result = caseTExtensibleAttributesDocumented(tExtensibleAttributesDocumented);
				if (result == null) result = caseTDocumented(tExtensibleAttributesDocumented);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TEXTENSIBLE_DOCUMENTED: {
				TExtensibleDocumented tExtensibleDocumented = (TExtensibleDocumented)theEObject;
				T result = caseTExtensibleDocumented(tExtensibleDocumented);
				if (result == null) result = caseTDocumented(tExtensibleDocumented);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TFAULT: {
				TFault tFault = (TFault)theEObject;
				T result = caseTFault(tFault);
				if (result == null) result = caseTExtensibleAttributesDocumented(tFault);
				if (result == null) result = caseTDocumented(tFault);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TIMPORT: {
				TImport tImport = (TImport)theEObject;
				T result = caseTImport(tImport);
				if (result == null) result = caseTExtensibleAttributesDocumented(tImport);
				if (result == null) result = caseTDocumented(tImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TMESSAGE: {
				TMessage tMessage = (TMessage)theEObject;
				T result = caseTMessage(tMessage);
				if (result == null) result = caseTExtensibleDocumented(tMessage);
				if (result == null) result = caseTDocumented(tMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TOPERATION: {
				TOperation tOperation = (TOperation)theEObject;
				T result = caseTOperation(tOperation);
				if (result == null) result = caseTExtensibleDocumented(tOperation);
				if (result == null) result = caseTDocumented(tOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TPARAM: {
				TParam tParam = (TParam)theEObject;
				T result = caseTParam(tParam);
				if (result == null) result = caseTExtensibleAttributesDocumented(tParam);
				if (result == null) result = caseTDocumented(tParam);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TPART: {
				TPart tPart = (TPart)theEObject;
				T result = caseTPart(tPart);
				if (result == null) result = caseTExtensibleAttributesDocumented(tPart);
				if (result == null) result = caseTDocumented(tPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TPORT: {
				TPort tPort = (TPort)theEObject;
				T result = caseTPort(tPort);
				if (result == null) result = caseTExtensibleDocumented(tPort);
				if (result == null) result = caseTDocumented(tPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TPORT_TYPE: {
				TPortType tPortType = (TPortType)theEObject;
				T result = caseTPortType(tPortType);
				if (result == null) result = caseTExtensibleAttributesDocumented(tPortType);
				if (result == null) result = caseTDocumented(tPortType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TSERVICE: {
				TService tService = (TService)theEObject;
				T result = caseTService(tService);
				if (result == null) result = caseTExtensibleDocumented(tService);
				if (result == null) result = caseTDocumented(tService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WsdlPackage.TTYPES: {
				TTypes tTypes = (TTypes)theEObject;
				T result = caseTTypes(tTypes);
				if (result == null) result = caseTExtensibleDocumented(tTypes);
				if (result == null) result = caseTDocumented(tTypes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TBinding</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TBinding</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTBinding(TBinding object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TBinding Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TBinding Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTBindingOperation(TBindingOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TBinding Operation Fault</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TBinding Operation Fault</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTBindingOperationFault(TBindingOperationFault object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TBinding Operation Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TBinding Operation Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTBindingOperationMessage(TBindingOperationMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TDefinitions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TDefinitions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTDefinitions(TDefinitions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TDocumentation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TDocumentation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTDocumentation(TDocumentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TDocumented</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TDocumented</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTDocumented(TDocumented object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TExtensibility Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TExtensibility Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTExtensibilityElement(TExtensibilityElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TExtensible Attributes Documented</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TExtensible Attributes Documented</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTExtensibleAttributesDocumented(TExtensibleAttributesDocumented object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TExtensible Documented</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TExtensible Documented</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTExtensibleDocumented(TExtensibleDocumented object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TFault</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TFault</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTFault(TFault object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TImport</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TImport</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTImport(TImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TMessage</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TMessage</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTMessage(TMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TOperation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TOperation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTOperation(TOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TParam</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TParam</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTParam(TParam object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TPart</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TPart</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTPart(TPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TPort</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TPort</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTPort(TPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TPort Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TPort Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTPortType(TPortType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TService</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TService</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTService(TService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TTypes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TTypes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTTypes(TTypes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //WsdlSwitch
