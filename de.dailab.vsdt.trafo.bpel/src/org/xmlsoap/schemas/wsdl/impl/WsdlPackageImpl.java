/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl;
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
import org.xmlsoap.schemas.wsdl.WsdlFactory;
import org.xmlsoap.schemas.wsdl.WsdlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WsdlPackageImpl extends EPackageImpl implements WsdlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tBindingOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tBindingOperationFaultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tBindingOperationMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDefinitionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDocumentationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDocumentedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExtensibilityElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExtensibleAttributesDocumentedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExtensibleDocumentedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tFaultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tParamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPortTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tTypesEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WsdlPackageImpl() {
		super(eNS_URI, WsdlFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WsdlPackage init() {
		if (isInited) return (WsdlPackage)EPackage.Registry.INSTANCE.getEPackage(WsdlPackage.eNS_URI);

		// Obtain or create and register package
		WsdlPackageImpl theWsdlPackage = (WsdlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof WsdlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new WsdlPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ProcessPackageImpl theProcessPackage = (ProcessPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI) instanceof ProcessPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI) : ProcessPackage.eINSTANCE);

		// Create package meta-data objects
		theWsdlPackage.createPackageContents();
		theProcessPackage.createPackageContents();

		// Initialize created meta-data
		theWsdlPackage.initializePackageContents();
		theProcessPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWsdlPackage.freeze();

		return theWsdlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Definitions() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_ArrayType() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Required() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTBinding() {
		return tBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBinding_Operation() {
		return (EReference)tBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTBinding_Name() {
		return (EAttribute)tBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTBinding_Type() {
		return (EAttribute)tBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTBindingOperation() {
		return tBindingOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBindingOperation_Input() {
		return (EReference)tBindingOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBindingOperation_Output() {
		return (EReference)tBindingOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBindingOperation_Fault() {
		return (EReference)tBindingOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTBindingOperation_Name() {
		return (EAttribute)tBindingOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTBindingOperationFault() {
		return tBindingOperationFaultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTBindingOperationFault_Name() {
		return (EAttribute)tBindingOperationFaultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTBindingOperationMessage() {
		return tBindingOperationMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTBindingOperationMessage_Name() {
		return (EAttribute)tBindingOperationMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDefinitions() {
		return tDefinitionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDefinitions_AnyTopLevelOptionalElement() {
		return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_Import() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_Types() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_Message() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_PortType() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_Binding() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDefinitions_Service() {
		return (EReference)tDefinitionsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDefinitions_Name() {
		return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDefinitions_TargetNamespace() {
		return (EAttribute)tDefinitionsEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDocumentation() {
		return tDocumentationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDocumentation_Mixed() {
		return (EAttribute)tDocumentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTDocumentation_Any() {
		return (EAttribute)tDocumentationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDocumented() {
		return tDocumentedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDocumented_Documentation() {
		return (EReference)tDocumentedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExtensibilityElement() {
		return tExtensibilityElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtensibilityElement_Required() {
		return (EAttribute)tExtensibilityElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExtensibleAttributesDocumented() {
		return tExtensibleAttributesDocumentedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtensibleAttributesDocumented_AnyAttribute() {
		return (EAttribute)tExtensibleAttributesDocumentedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExtensibleDocumented() {
		return tExtensibleDocumentedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtensibleDocumented_Any() {
		return (EAttribute)tExtensibleDocumentedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTFault() {
		return tFaultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFault_Message() {
		return (EAttribute)tFaultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFault_Name() {
		return (EAttribute)tFaultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTImport() {
		return tImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTImport_Location() {
		return (EAttribute)tImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTImport_Namespace() {
		return (EAttribute)tImportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTMessage() {
		return tMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTMessage_Part() {
		return (EReference)tMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTMessage_Name() {
		return (EAttribute)tMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTOperation() {
		return tOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOperation_Input() {
		return (EReference)tOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOperation_Output() {
		return (EReference)tOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOperation_Fault() {
		return (EReference)tOperationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOperation_Output1() {
		return (EReference)tOperationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOperation_Input1() {
		return (EReference)tOperationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOperation_Fault1() {
		return (EReference)tOperationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTOperation_Name() {
		return (EAttribute)tOperationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTOperation_ParameterOrder() {
		return (EAttribute)tOperationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTParam() {
		return tParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTParam_Message() {
		return (EAttribute)tParamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTParam_Name() {
		return (EAttribute)tParamEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPart() {
		return tPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPart_Element() {
		return (EAttribute)tPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPart_Name() {
		return (EAttribute)tPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPart_Type() {
		return (EAttribute)tPartEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPort() {
		return tPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPort_Binding() {
		return (EAttribute)tPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPort_Name() {
		return (EAttribute)tPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPortType() {
		return tPortTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPortType_Operation() {
		return (EReference)tPortTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPortType_Name() {
		return (EAttribute)tPortTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTService() {
		return tServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTService_Port() {
		return (EReference)tServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTService_Name() {
		return (EAttribute)tServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTTypes() {
		return tTypesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WsdlFactory getWsdlFactory() {
		return (WsdlFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DEFINITIONS);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__ARRAY_TYPE);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__REQUIRED);

		tBindingEClass = createEClass(TBINDING);
		createEReference(tBindingEClass, TBINDING__OPERATION);
		createEAttribute(tBindingEClass, TBINDING__NAME);
		createEAttribute(tBindingEClass, TBINDING__TYPE);

		tBindingOperationEClass = createEClass(TBINDING_OPERATION);
		createEReference(tBindingOperationEClass, TBINDING_OPERATION__INPUT);
		createEReference(tBindingOperationEClass, TBINDING_OPERATION__OUTPUT);
		createEReference(tBindingOperationEClass, TBINDING_OPERATION__FAULT);
		createEAttribute(tBindingOperationEClass, TBINDING_OPERATION__NAME);

		tBindingOperationFaultEClass = createEClass(TBINDING_OPERATION_FAULT);
		createEAttribute(tBindingOperationFaultEClass, TBINDING_OPERATION_FAULT__NAME);

		tBindingOperationMessageEClass = createEClass(TBINDING_OPERATION_MESSAGE);
		createEAttribute(tBindingOperationMessageEClass, TBINDING_OPERATION_MESSAGE__NAME);

		tDefinitionsEClass = createEClass(TDEFINITIONS);
		createEAttribute(tDefinitionsEClass, TDEFINITIONS__ANY_TOP_LEVEL_OPTIONAL_ELEMENT);
		createEReference(tDefinitionsEClass, TDEFINITIONS__IMPORT);
		createEReference(tDefinitionsEClass, TDEFINITIONS__TYPES);
		createEReference(tDefinitionsEClass, TDEFINITIONS__MESSAGE);
		createEReference(tDefinitionsEClass, TDEFINITIONS__PORT_TYPE);
		createEReference(tDefinitionsEClass, TDEFINITIONS__BINDING);
		createEReference(tDefinitionsEClass, TDEFINITIONS__SERVICE);
		createEAttribute(tDefinitionsEClass, TDEFINITIONS__NAME);
		createEAttribute(tDefinitionsEClass, TDEFINITIONS__TARGET_NAMESPACE);

		tDocumentationEClass = createEClass(TDOCUMENTATION);
		createEAttribute(tDocumentationEClass, TDOCUMENTATION__MIXED);
		createEAttribute(tDocumentationEClass, TDOCUMENTATION__ANY);

		tDocumentedEClass = createEClass(TDOCUMENTED);
		createEReference(tDocumentedEClass, TDOCUMENTED__DOCUMENTATION);

		tExtensibilityElementEClass = createEClass(TEXTENSIBILITY_ELEMENT);
		createEAttribute(tExtensibilityElementEClass, TEXTENSIBILITY_ELEMENT__REQUIRED);

		tExtensibleAttributesDocumentedEClass = createEClass(TEXTENSIBLE_ATTRIBUTES_DOCUMENTED);
		createEAttribute(tExtensibleAttributesDocumentedEClass, TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__ANY_ATTRIBUTE);

		tExtensibleDocumentedEClass = createEClass(TEXTENSIBLE_DOCUMENTED);
		createEAttribute(tExtensibleDocumentedEClass, TEXTENSIBLE_DOCUMENTED__ANY);

		tFaultEClass = createEClass(TFAULT);
		createEAttribute(tFaultEClass, TFAULT__MESSAGE);
		createEAttribute(tFaultEClass, TFAULT__NAME);

		tImportEClass = createEClass(TIMPORT);
		createEAttribute(tImportEClass, TIMPORT__LOCATION);
		createEAttribute(tImportEClass, TIMPORT__NAMESPACE);

		tMessageEClass = createEClass(TMESSAGE);
		createEReference(tMessageEClass, TMESSAGE__PART);
		createEAttribute(tMessageEClass, TMESSAGE__NAME);

		tOperationEClass = createEClass(TOPERATION);
		createEReference(tOperationEClass, TOPERATION__INPUT);
		createEReference(tOperationEClass, TOPERATION__OUTPUT);
		createEReference(tOperationEClass, TOPERATION__FAULT);
		createEReference(tOperationEClass, TOPERATION__OUTPUT1);
		createEReference(tOperationEClass, TOPERATION__INPUT1);
		createEReference(tOperationEClass, TOPERATION__FAULT1);
		createEAttribute(tOperationEClass, TOPERATION__NAME);
		createEAttribute(tOperationEClass, TOPERATION__PARAMETER_ORDER);

		tParamEClass = createEClass(TPARAM);
		createEAttribute(tParamEClass, TPARAM__MESSAGE);
		createEAttribute(tParamEClass, TPARAM__NAME);

		tPartEClass = createEClass(TPART);
		createEAttribute(tPartEClass, TPART__ELEMENT);
		createEAttribute(tPartEClass, TPART__NAME);
		createEAttribute(tPartEClass, TPART__TYPE);

		tPortEClass = createEClass(TPORT);
		createEAttribute(tPortEClass, TPORT__BINDING);
		createEAttribute(tPortEClass, TPORT__NAME);

		tPortTypeEClass = createEClass(TPORT_TYPE);
		createEReference(tPortTypeEClass, TPORT_TYPE__OPERATION);
		createEAttribute(tPortTypeEClass, TPORT_TYPE__NAME);

		tServiceEClass = createEClass(TSERVICE);
		createEReference(tServiceEClass, TSERVICE__PORT);
		createEAttribute(tServiceEClass, TSERVICE__NAME);

		tTypesEClass = createEClass(TTYPES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tBindingEClass.getESuperTypes().add(this.getTExtensibleDocumented());
		tBindingOperationEClass.getESuperTypes().add(this.getTExtensibleDocumented());
		tBindingOperationFaultEClass.getESuperTypes().add(this.getTExtensibleDocumented());
		tBindingOperationMessageEClass.getESuperTypes().add(this.getTExtensibleDocumented());
		tDefinitionsEClass.getESuperTypes().add(this.getTExtensibleDocumented());
		tExtensibleAttributesDocumentedEClass.getESuperTypes().add(this.getTDocumented());
		tExtensibleDocumentedEClass.getESuperTypes().add(this.getTDocumented());
		tFaultEClass.getESuperTypes().add(this.getTExtensibleAttributesDocumented());
		tImportEClass.getESuperTypes().add(this.getTExtensibleAttributesDocumented());
		tMessageEClass.getESuperTypes().add(this.getTExtensibleDocumented());
		tOperationEClass.getESuperTypes().add(this.getTExtensibleDocumented());
		tParamEClass.getESuperTypes().add(this.getTExtensibleAttributesDocumented());
		tPartEClass.getESuperTypes().add(this.getTExtensibleAttributesDocumented());
		tPortEClass.getESuperTypes().add(this.getTExtensibleDocumented());
		tPortTypeEClass.getESuperTypes().add(this.getTExtensibleAttributesDocumented());
		tServiceEClass.getESuperTypes().add(this.getTExtensibleDocumented());
		tTypesEClass.getESuperTypes().add(this.getTExtensibleDocumented());

		// Initialize classes and features; add operations and parameters
		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Definitions(), this.getTDefinitions(), null, "definitions", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_ArrayType(), theXMLTypePackage.getString(), "arrayType", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDocumentRoot_Required(), theXMLTypePackage.getBoolean(), "required", null, 0, 1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tBindingEClass, TBinding.class, "TBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTBinding_Operation(), this.getTBindingOperation(), null, "operation", null, 0, -1, TBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTBinding_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTBinding_Type(), theXMLTypePackage.getQName(), "type", null, 1, 1, TBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tBindingOperationEClass, TBindingOperation.class, "TBindingOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTBindingOperation_Input(), this.getTBindingOperationMessage(), null, "input", null, 0, 1, TBindingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTBindingOperation_Output(), this.getTBindingOperationMessage(), null, "output", null, 0, 1, TBindingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTBindingOperation_Fault(), this.getTBindingOperationFault(), null, "fault", null, 0, -1, TBindingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTBindingOperation_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TBindingOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tBindingOperationFaultEClass, TBindingOperationFault.class, "TBindingOperationFault", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTBindingOperationFault_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TBindingOperationFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tBindingOperationMessageEClass, TBindingOperationMessage.class, "TBindingOperationMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTBindingOperationMessage_Name(), theXMLTypePackage.getNCName(), "name", null, 0, 1, TBindingOperationMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tDefinitionsEClass, TDefinitions.class, "TDefinitions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTDefinitions_AnyTopLevelOptionalElement(), ecorePackage.getEFeatureMapEntry(), "anyTopLevelOptionalElement", null, 0, -1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_Import(), this.getTImport(), null, "import", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_Types(), this.getTTypes(), null, "types", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_Message(), this.getTMessage(), null, "message", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_PortType(), this.getTPortType(), null, "portType", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_Binding(), this.getTBinding(), null, "binding", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTDefinitions_Service(), this.getTService(), null, "service", null, 0, -1, TDefinitions.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDefinitions_Name(), theXMLTypePackage.getNCName(), "name", null, 0, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDefinitions_TargetNamespace(), theXMLTypePackage.getAnyURI(), "targetNamespace", null, 0, 1, TDefinitions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tDocumentationEClass, TDocumentation.class, "TDocumentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTDocumentation_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, TDocumentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTDocumentation_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TDocumentation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(tDocumentedEClass, TDocumented.class, "TDocumented", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTDocumented_Documentation(), this.getTDocumentation(), null, "documentation", null, 0, 1, TDocumented.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExtensibilityElementEClass, TExtensibilityElement.class, "TExtensibilityElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTExtensibilityElement_Required(), theXMLTypePackage.getBoolean(), "required", null, 0, 1, TExtensibilityElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExtensibleAttributesDocumentedEClass, TExtensibleAttributesDocumented.class, "TExtensibleAttributesDocumented", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTExtensibleAttributesDocumented_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, TExtensibleAttributesDocumented.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExtensibleDocumentedEClass, TExtensibleDocumented.class, "TExtensibleDocumented", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTExtensibleDocumented_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TExtensibleDocumented.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tFaultEClass, TFault.class, "TFault", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTFault_Message(), theXMLTypePackage.getQName(), "message", null, 1, 1, TFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTFault_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TFault.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tImportEClass, TImport.class, "TImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTImport_Location(), theXMLTypePackage.getAnyURI(), "location", null, 1, 1, TImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTImport_Namespace(), theXMLTypePackage.getAnyURI(), "namespace", null, 1, 1, TImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tMessageEClass, TMessage.class, "TMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTMessage_Part(), this.getTPart(), null, "part", null, 0, -1, TMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTMessage_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tOperationEClass, TOperation.class, "TOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTOperation_Input(), this.getTParam(), null, "input", null, 0, 1, TOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOperation_Output(), this.getTParam(), null, "output", null, 0, 1, TOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOperation_Fault(), this.getTFault(), null, "fault", null, 0, -1, TOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOperation_Output1(), this.getTParam(), null, "output1", null, 0, 1, TOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOperation_Input1(), this.getTParam(), null, "input1", null, 0, 1, TOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOperation_Fault1(), this.getTFault(), null, "fault1", null, 0, -1, TOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTOperation_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTOperation_ParameterOrder(), theXMLTypePackage.getNMTOKENS(), "parameterOrder", null, 0, 1, TOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tParamEClass, TParam.class, "TParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTParam_Message(), theXMLTypePackage.getQName(), "message", null, 1, 1, TParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTParam_Name(), theXMLTypePackage.getNCName(), "name", null, 0, 1, TParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPartEClass, TPart.class, "TPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTPart_Element(), theXMLTypePackage.getQName(), "element", null, 0, 1, TPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPart_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPart_Type(), theXMLTypePackage.getQName(), "type", null, 0, 1, TPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPortEClass, TPort.class, "TPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTPort_Binding(), theXMLTypePackage.getQName(), "binding", null, 1, 1, TPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPort_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPortTypeEClass, TPortType.class, "TPortType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTPortType_Operation(), this.getTOperation(), null, "operation", null, 0, -1, TPortType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPortType_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TPortType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tServiceEClass, TService.class, "TService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTService_Port(), this.getTPort(), null, "port", null, 0, -1, TService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTService_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tTypesEClass, TTypes.class, "TTypes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_Definitions(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "definitions",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_ArrayType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "arrayType",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Required(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "required",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tBindingEClass, 
		   source, 
		   new String[] {
			 "name", "tBinding",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTBinding_Operation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTBinding_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getTBinding_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });		
		addAnnotation
		  (tBindingOperationEClass, 
		   source, 
		   new String[] {
			 "name", "tBindingOperation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTBindingOperation_Input(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "input",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTBindingOperation_Output(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "output",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTBindingOperation_Fault(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fault",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTBindingOperation_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tBindingOperationFaultEClass, 
		   source, 
		   new String[] {
			 "name", "tBindingOperationFault",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTBindingOperationFault_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tBindingOperationMessageEClass, 
		   source, 
		   new String[] {
			 "name", "tBindingOperationMessage",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTBindingOperationMessage_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tDefinitionsEClass, 
		   source, 
		   new String[] {
			 "name", "tDefinitions",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTDefinitions_AnyTopLevelOptionalElement(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "AnyTopLevelOptionalElement:2"
		   });		
		addAnnotation
		  (getTDefinitions_Import(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "import",
			 "namespace", "##targetNamespace",
			 "group", "#AnyTopLevelOptionalElement:2"
		   });		
		addAnnotation
		  (getTDefinitions_Types(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "types",
			 "namespace", "##targetNamespace",
			 "group", "#AnyTopLevelOptionalElement:2"
		   });		
		addAnnotation
		  (getTDefinitions_Message(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "message",
			 "namespace", "##targetNamespace",
			 "group", "#AnyTopLevelOptionalElement:2"
		   });		
		addAnnotation
		  (getTDefinitions_PortType(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "portType",
			 "namespace", "##targetNamespace",
			 "group", "#AnyTopLevelOptionalElement:2"
		   });		
		addAnnotation
		  (getTDefinitions_Binding(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "binding",
			 "namespace", "##targetNamespace",
			 "group", "#AnyTopLevelOptionalElement:2"
		   });		
		addAnnotation
		  (getTDefinitions_Service(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "service",
			 "namespace", "##targetNamespace",
			 "group", "#AnyTopLevelOptionalElement:2"
		   });		
		addAnnotation
		  (getTDefinitions_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getTDefinitions_TargetNamespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetNamespace"
		   });		
		addAnnotation
		  (tDocumentationEClass, 
		   source, 
		   new String[] {
			 "name", "tDocumentation",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getTDocumentation_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getTDocumentation_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##any",
			 "name", ":1",
			 "processing", "lax"
		   });			
		addAnnotation
		  (tDocumentedEClass, 
		   source, 
		   new String[] {
			 "name", "tDocumented",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTDocumented_Documentation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "documentation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tExtensibilityElementEClass, 
		   source, 
		   new String[] {
			 "name", "tExtensibilityElement",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getTExtensibilityElement_Required(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "required",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (tExtensibleAttributesDocumentedEClass, 
		   source, 
		   new String[] {
			 "name", "tExtensibleAttributesDocumented",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTExtensibleAttributesDocumented_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });			
		addAnnotation
		  (tExtensibleDocumentedEClass, 
		   source, 
		   new String[] {
			 "name", "tExtensibleDocumented",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTExtensibleDocumented_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });		
		addAnnotation
		  (tFaultEClass, 
		   source, 
		   new String[] {
			 "name", "tFault",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTFault_Message(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "message"
		   });		
		addAnnotation
		  (getTFault_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tImportEClass, 
		   source, 
		   new String[] {
			 "name", "tImport",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTImport_Location(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "location"
		   });		
		addAnnotation
		  (getTImport_Namespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "namespace"
		   });		
		addAnnotation
		  (tMessageEClass, 
		   source, 
		   new String[] {
			 "name", "tMessage",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTMessage_Part(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "part",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTMessage_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tOperationEClass, 
		   source, 
		   new String[] {
			 "name", "tOperation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTOperation_Input(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "input",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOperation_Output(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "output",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOperation_Fault(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fault",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOperation_Output1(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "output",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOperation_Input1(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "input",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOperation_Fault1(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "fault",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOperation_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getTOperation_ParameterOrder(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "parameterOrder"
		   });		
		addAnnotation
		  (tParamEClass, 
		   source, 
		   new String[] {
			 "name", "tParam",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTParam_Message(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "message"
		   });		
		addAnnotation
		  (getTParam_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tPartEClass, 
		   source, 
		   new String[] {
			 "name", "tPart",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTPart_Element(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "element"
		   });		
		addAnnotation
		  (getTPart_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getTPart_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });		
		addAnnotation
		  (tPortEClass, 
		   source, 
		   new String[] {
			 "name", "tPort",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTPort_Binding(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "binding"
		   });		
		addAnnotation
		  (getTPort_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tPortTypeEClass, 
		   source, 
		   new String[] {
			 "name", "tPortType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTPortType_Operation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "operation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTPortType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tServiceEClass, 
		   source, 
		   new String[] {
			 "name", "tService",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTService_Port(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "port",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTService_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tTypesEClass, 
		   source, 
		   new String[] {
			 "name", "tTypes",
			 "kind", "elementOnly"
		   });
	}

} //WsdlPackageImpl
