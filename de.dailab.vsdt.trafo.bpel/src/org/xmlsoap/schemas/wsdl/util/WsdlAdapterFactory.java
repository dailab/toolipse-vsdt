/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.xmlsoap.schemas.wsdl.WsdlPackage
 * @generated
 */
public class WsdlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WsdlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WsdlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = WsdlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WsdlSwitch<Adapter> modelSwitch =
		new WsdlSwitch<Adapter>() {
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseTBinding(TBinding object) {
				return createTBindingAdapter();
			}
			@Override
			public Adapter caseTBindingOperation(TBindingOperation object) {
				return createTBindingOperationAdapter();
			}
			@Override
			public Adapter caseTBindingOperationFault(TBindingOperationFault object) {
				return createTBindingOperationFaultAdapter();
			}
			@Override
			public Adapter caseTBindingOperationMessage(TBindingOperationMessage object) {
				return createTBindingOperationMessageAdapter();
			}
			@Override
			public Adapter caseTDefinitions(TDefinitions object) {
				return createTDefinitionsAdapter();
			}
			@Override
			public Adapter caseTDocumentation(TDocumentation object) {
				return createTDocumentationAdapter();
			}
			@Override
			public Adapter caseTDocumented(TDocumented object) {
				return createTDocumentedAdapter();
			}
			@Override
			public Adapter caseTExtensibilityElement(TExtensibilityElement object) {
				return createTExtensibilityElementAdapter();
			}
			@Override
			public Adapter caseTExtensibleAttributesDocumented(TExtensibleAttributesDocumented object) {
				return createTExtensibleAttributesDocumentedAdapter();
			}
			@Override
			public Adapter caseTExtensibleDocumented(TExtensibleDocumented object) {
				return createTExtensibleDocumentedAdapter();
			}
			@Override
			public Adapter caseTFault(TFault object) {
				return createTFaultAdapter();
			}
			@Override
			public Adapter caseTImport(TImport object) {
				return createTImportAdapter();
			}
			@Override
			public Adapter caseTMessage(TMessage object) {
				return createTMessageAdapter();
			}
			@Override
			public Adapter caseTOperation(TOperation object) {
				return createTOperationAdapter();
			}
			@Override
			public Adapter caseTParam(TParam object) {
				return createTParamAdapter();
			}
			@Override
			public Adapter caseTPart(TPart object) {
				return createTPartAdapter();
			}
			@Override
			public Adapter caseTPort(TPort object) {
				return createTPortAdapter();
			}
			@Override
			public Adapter caseTPortType(TPortType object) {
				return createTPortTypeAdapter();
			}
			@Override
			public Adapter caseTService(TService object) {
				return createTServiceAdapter();
			}
			@Override
			public Adapter caseTTypes(TTypes object) {
				return createTTypesAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TBinding <em>TBinding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TBinding
	 * @generated
	 */
	public Adapter createTBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TBindingOperation <em>TBinding Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TBindingOperation
	 * @generated
	 */
	public Adapter createTBindingOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TBindingOperationFault <em>TBinding Operation Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TBindingOperationFault
	 * @generated
	 */
	public Adapter createTBindingOperationFaultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TBindingOperationMessage <em>TBinding Operation Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TBindingOperationMessage
	 * @generated
	 */
	public Adapter createTBindingOperationMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TDefinitions <em>TDefinitions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TDefinitions
	 * @generated
	 */
	public Adapter createTDefinitionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TDocumentation <em>TDocumentation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TDocumentation
	 * @generated
	 */
	public Adapter createTDocumentationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TDocumented <em>TDocumented</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TDocumented
	 * @generated
	 */
	public Adapter createTDocumentedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TExtensibilityElement <em>TExtensibility Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TExtensibilityElement
	 * @generated
	 */
	public Adapter createTExtensibilityElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TExtensibleAttributesDocumented <em>TExtensible Attributes Documented</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TExtensibleAttributesDocumented
	 * @generated
	 */
	public Adapter createTExtensibleAttributesDocumentedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TExtensibleDocumented <em>TExtensible Documented</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TExtensibleDocumented
	 * @generated
	 */
	public Adapter createTExtensibleDocumentedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TFault <em>TFault</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TFault
	 * @generated
	 */
	public Adapter createTFaultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TImport <em>TImport</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TImport
	 * @generated
	 */
	public Adapter createTImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TMessage <em>TMessage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TMessage
	 * @generated
	 */
	public Adapter createTMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TOperation <em>TOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TOperation
	 * @generated
	 */
	public Adapter createTOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TParam <em>TParam</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TParam
	 * @generated
	 */
	public Adapter createTParamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TPart <em>TPart</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TPart
	 * @generated
	 */
	public Adapter createTPartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TPort <em>TPort</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TPort
	 * @generated
	 */
	public Adapter createTPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TPortType <em>TPort Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TPortType
	 * @generated
	 */
	public Adapter createTPortTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TService <em>TService</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TService
	 * @generated
	 */
	public Adapter createTServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.wsdl.TTypes <em>TTypes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.wsdl.TTypes
	 * @generated
	 */
	public Adapter createTTypesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //WsdlAdapterFactory
