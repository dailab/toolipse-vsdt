/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process.impl;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.CaseType;
import org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot;
import org.xmlsoap.schemas.ws._2003._03.business.process.PartnerLinkType;
import org.xmlsoap.schemas.ws._2003._03.business.process.PatternType;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessFactory;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivity;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer;
import org.xmlsoap.schemas.ws._2003._03.business.process.TAssign;
import org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCatch;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCompensate;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCompensationHandler;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCopy;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSets;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationWithPattern;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelations;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationsWithPattern;
import org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty;
import org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers;
import org.xmlsoap.schemas.ws._2003._03.business.process.TExtensibleElements;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFlow;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFrom;
import org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke;
import org.xmlsoap.schemas.ws._2003._03.business.process.TLink;
import org.xmlsoap.schemas.ws._2003._03.business.process.TLinks;
import org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm;
import org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TPartner;
import org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink;
import org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLinks;
import org.xmlsoap.schemas.ws._2003._03.business.process.TPartners;
import org.xmlsoap.schemas.ws._2003._03.business.process.TPick;
import org.xmlsoap.schemas.ws._2003._03.business.process.TProcess;
import org.xmlsoap.schemas.ws._2003._03.business.process.TReceive;
import org.xmlsoap.schemas.ws._2003._03.business.process.TReply;
import org.xmlsoap.schemas.ws._2003._03.business.process.TRoles;
import org.xmlsoap.schemas.ws._2003._03.business.process.TScope;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSequence;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSource;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch;
import org.xmlsoap.schemas.ws._2003._03.business.process.TTarget;
import org.xmlsoap.schemas.ws._2003._03.business.process.TTerminate;
import org.xmlsoap.schemas.ws._2003._03.business.process.TThrow;
import org.xmlsoap.schemas.ws._2003._03.business.process.TVariable;
import org.xmlsoap.schemas.ws._2003._03.business.process.TVariables;
import org.xmlsoap.schemas.ws._2003._03.business.process.TWait;
import org.xmlsoap.schemas.ws._2003._03.business.process.TWhile;
import org.xmlsoap.schemas.ws._2003._03.business.process.ToType;
import org.xmlsoap.schemas.ws._2003._03.business.process.util.ProcessValidator;
import org.xmlsoap.schemas.wsdl.WsdlPackage;
import org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProcessPackageImpl extends EPackageImpl implements ProcessPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseTypeEClass = null;

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
	private EClass partnerLinkTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tActivityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tActivityContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tActivityOrCompensateContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tAssignEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCompensateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCompensationHandlerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCopyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCorrelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCorrelationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCorrelationSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCorrelationSetsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCorrelationsWithPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tCorrelationWithPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tEmptyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tEventHandlersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tExtensibleElementsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tFaultHandlersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tFromEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tLinksEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tOnAlarmEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tOnMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPartnerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPartnerLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPartnerLinksEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPartnersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tPickEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tReceiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tReplyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tScopeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tSwitchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tTargetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tTerminateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tThrowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tVariablesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tWaitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tWhileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum patternTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tBooleanEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum tRolesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType patternTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType propertiesTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tBooleanExprEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tBooleanObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tDeadlineExprEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tDurationExprEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType tRolesObjectEDataType = null;

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
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ProcessPackageImpl() {
		super(eNS_URI, ProcessFactory.eINSTANCE);
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
	public static ProcessPackage init() {
		if (isInited) return (ProcessPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessPackage.eNS_URI);

		// Obtain or create and register package
		ProcessPackageImpl theProcessPackage = (ProcessPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ProcessPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ProcessPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		WsdlPackageImpl theWsdlPackage = (WsdlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(WsdlPackage.eNS_URI) instanceof WsdlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(WsdlPackage.eNS_URI) : WsdlPackage.eINSTANCE);

		// Create package meta-data objects
		theProcessPackage.createPackageContents();
		theWsdlPackage.createPackageContents();

		// Initialize created meta-data
		theProcessPackage.initializePackageContents();
		theWsdlPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theProcessPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ProcessValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theProcessPackage.freeze();

		return theProcessPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaseType() {
		return caseTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCaseType_Condition() {
		return (EAttribute)caseTypeEClass.getEStructuralFeatures().get(0);
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
	public EReference getDocumentRoot_From() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Process() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_To() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartnerLinkType() {
		return partnerLinkTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartnerLinkType_Name() {
		return (EAttribute)partnerLinkTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTActivity() {
		return tActivityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivity_Target() {
		return (EReference)tActivityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivity_Source() {
		return (EReference)tActivityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTActivity_JoinCondition() {
		return (EAttribute)tActivityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTActivity_Name() {
		return (EAttribute)tActivityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTActivity_SuppressJoinFailure() {
		return (EAttribute)tActivityEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTActivityContainer() {
		return tActivityContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_Empty() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_Invoke() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_Receive() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_Reply() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_Assign() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_Wait() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_Throw() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_Terminate() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_Flow() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_Switch() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_While() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_Sequence() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_Pick() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityContainer_Scope() {
		return (EReference)tActivityContainerEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTActivityOrCompensateContainer() {
		return tActivityOrCompensateContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Empty() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Invoke() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Receive() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Reply() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Assign() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Wait() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Throw() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Terminate() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Flow() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Switch() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_While() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Sequence() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Pick() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Scope() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTActivityOrCompensateContainer_Compensate() {
		return (EReference)tActivityOrCompensateContainerEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTAssign() {
		return tAssignEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTAssign_Copy() {
		return (EReference)tAssignEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCatch() {
		return tCatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCatch_FaultName() {
		return (EAttribute)tCatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCatch_FaultVariable() {
		return (EAttribute)tCatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCompensate() {
		return tCompensateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCompensate_Scope() {
		return (EAttribute)tCompensateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCompensationHandler() {
		return tCompensationHandlerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCopy() {
		return tCopyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCopy_From() {
		return (EReference)tCopyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCopy_To() {
		return (EReference)tCopyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCorrelation() {
		return tCorrelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCorrelation_Initiate() {
		return (EAttribute)tCorrelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCorrelation_Set() {
		return (EAttribute)tCorrelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCorrelations() {
		return tCorrelationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCorrelations_Correlation() {
		return (EReference)tCorrelationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCorrelationSet() {
		return tCorrelationSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCorrelationSet_Name() {
		return (EAttribute)tCorrelationSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCorrelationSet_Properties() {
		return (EAttribute)tCorrelationSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCorrelationSets() {
		return tCorrelationSetsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCorrelationSets_CorrelationSet() {
		return (EReference)tCorrelationSetsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCorrelationsWithPattern() {
		return tCorrelationsWithPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTCorrelationsWithPattern_Correlation() {
		return (EReference)tCorrelationsWithPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTCorrelationWithPattern() {
		return tCorrelationWithPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTCorrelationWithPattern_Pattern() {
		return (EAttribute)tCorrelationWithPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTEmpty() {
		return tEmptyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTEventHandlers() {
		return tEventHandlersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTEventHandlers_OnMessage() {
		return (EReference)tEventHandlersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTEventHandlers_OnAlarm() {
		return (EReference)tEventHandlersEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTExtensibleElements() {
		return tExtensibleElementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtensibleElements_Any() {
		return (EAttribute)tExtensibleElementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTExtensibleElements_AnyAttribute() {
		return (EAttribute)tExtensibleElementsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTFaultHandlers() {
		return tFaultHandlersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFaultHandlers_Catch() {
		return (EReference)tFaultHandlersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFaultHandlers_CatchAll() {
		return (EReference)tFaultHandlersEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTFlow() {
		return tFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Links() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFlow_Activity() {
		return (EAttribute)tFlowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Empty() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Invoke() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Receive() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Reply() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Assign() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Wait() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Throw() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Terminate() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Flow() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Switch() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_While() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Sequence() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Pick() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTFlow_Scope() {
		return (EReference)tFlowEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTFrom() {
		return tFromEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFrom_EndpointReference() {
		return (EAttribute)tFromEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFrom_Expression() {
		return (EAttribute)tFromEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFrom_Opaque() {
		return (EAttribute)tFromEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFrom_Part() {
		return (EAttribute)tFromEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFrom_PartnerLink() {
		return (EAttribute)tFromEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFrom_Property() {
		return (EAttribute)tFromEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFrom_Query() {
		return (EAttribute)tFromEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTFrom_Variable() {
		return (EAttribute)tFromEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTInvoke() {
		return tInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInvoke_Correlations() {
		return (EReference)tInvokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInvoke_Catch() {
		return (EReference)tInvokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInvoke_CatchAll() {
		return (EReference)tInvokeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInvoke_CompensationHandler() {
		return (EReference)tInvokeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTInvoke_InputVariable() {
		return (EAttribute)tInvokeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTInvoke_Operation() {
		return (EAttribute)tInvokeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTInvoke_OutputVariable() {
		return (EAttribute)tInvokeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTInvoke_PartnerLink() {
		return (EAttribute)tInvokeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTInvoke_PortType() {
		return (EAttribute)tInvokeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTLink() {
		return tLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTLink_Name() {
		return (EAttribute)tLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTLinks() {
		return tLinksEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTLinks_Link() {
		return (EReference)tLinksEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTOnAlarm() {
		return tOnAlarmEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTOnAlarm_For() {
		return (EAttribute)tOnAlarmEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTOnAlarm_Until() {
		return (EAttribute)tOnAlarmEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTOnMessage() {
		return tOnMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Correlations() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Empty() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Invoke() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Receive() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Reply() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Assign() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Wait() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Throw() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Terminate() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Flow() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Switch() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_While() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Sequence() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Pick() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTOnMessage_Scope() {
		return (EReference)tOnMessageEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTOnMessage_Operation() {
		return (EAttribute)tOnMessageEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTOnMessage_PartnerLink() {
		return (EAttribute)tOnMessageEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTOnMessage_PortType() {
		return (EAttribute)tOnMessageEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTOnMessage_Variable() {
		return (EAttribute)tOnMessageEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToType() {
		return toTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPartner() {
		return tPartnerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPartner_PartnerLink() {
		return (EReference)tPartnerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPartner_Name() {
		return (EAttribute)tPartnerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPartnerLink() {
		return tPartnerLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPartnerLink_MyRole() {
		return (EAttribute)tPartnerLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPartnerLink_Name() {
		return (EAttribute)tPartnerLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPartnerLink_PartnerLinkType() {
		return (EAttribute)tPartnerLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPartnerLink_PartnerRole() {
		return (EAttribute)tPartnerLinkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPartnerLinks() {
		return tPartnerLinksEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPartnerLinks_PartnerLink() {
		return (EReference)tPartnerLinksEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPartners() {
		return tPartnersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPartners_Partner() {
		return (EReference)tPartnersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTPick() {
		return tPickEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPick_OnMessage() {
		return (EReference)tPickEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTPick_OnAlarm() {
		return (EReference)tPickEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTPick_CreateInstance() {
		return (EAttribute)tPickEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTProcess() {
		return tProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_PartnerLinks() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Partners() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Variables() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_CorrelationSets() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_FaultHandlers() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_CompensationHandler() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_EventHandlers() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Empty() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Invoke() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Receive() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Reply() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Assign() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Wait() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Throw() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Terminate() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Flow() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Switch() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_While() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Sequence() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Pick() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcess_Scope() {
		return (EReference)tProcessEClass.getEStructuralFeatures().get(20);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTProcess_AbstractProcess() {
		return (EAttribute)tProcessEClass.getEStructuralFeatures().get(21);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTProcess_EnableInstanceCompensation() {
		return (EAttribute)tProcessEClass.getEStructuralFeatures().get(22);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTProcess_ExpressionLanguage() {
		return (EAttribute)tProcessEClass.getEStructuralFeatures().get(23);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTProcess_Name() {
		return (EAttribute)tProcessEClass.getEStructuralFeatures().get(24);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTProcess_QueryLanguage() {
		return (EAttribute)tProcessEClass.getEStructuralFeatures().get(25);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTProcess_SuppressJoinFailure() {
		return (EAttribute)tProcessEClass.getEStructuralFeatures().get(26);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTProcess_TargetNamespace() {
		return (EAttribute)tProcessEClass.getEStructuralFeatures().get(27);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTReceive() {
		return tReceiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTReceive_Correlations() {
		return (EReference)tReceiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTReceive_CreateInstance() {
		return (EAttribute)tReceiveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTReceive_Operation() {
		return (EAttribute)tReceiveEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTReceive_PartnerLink() {
		return (EAttribute)tReceiveEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTReceive_PortType() {
		return (EAttribute)tReceiveEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTReceive_Variable() {
		return (EAttribute)tReceiveEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTReply() {
		return tReplyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTReply_Correlations() {
		return (EReference)tReplyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTReply_FaultName() {
		return (EAttribute)tReplyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTReply_Operation() {
		return (EAttribute)tReplyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTReply_PartnerLink() {
		return (EAttribute)tReplyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTReply_PortType() {
		return (EAttribute)tReplyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTReply_Variable() {
		return (EAttribute)tReplyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTScope() {
		return tScopeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Variables() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_CorrelationSets() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_FaultHandlers() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_CompensationHandler() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_EventHandlers() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Empty() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Invoke() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Receive() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Reply() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Assign() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Wait() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Throw() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Terminate() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Flow() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Switch() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_While() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Sequence() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Pick() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTScope_Scope() {
		return (EReference)tScopeEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTScope_VariableAccessSerializable() {
		return (EAttribute)tScopeEClass.getEStructuralFeatures().get(19);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTSequence() {
		return tSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTSequence_Activity() {
		return (EAttribute)tSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_Empty() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_Invoke() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_Receive() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_Reply() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_Assign() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_Wait() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_Throw() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_Terminate() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_Flow() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_Switch() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_While() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_Sequence() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_Pick() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSequence_Scope() {
		return (EReference)tSequenceEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTSource() {
		return tSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTSource_LinkName() {
		return (EAttribute)tSourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTSource_TransitionCondition() {
		return (EAttribute)tSourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTSwitch() {
		return tSwitchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSwitch_Case() {
		return (EReference)tSwitchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTSwitch_Otherwise() {
		return (EReference)tSwitchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTTarget() {
		return tTargetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTTarget_LinkName() {
		return (EAttribute)tTargetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTTerminate() {
		return tTerminateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTThrow() {
		return tThrowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTThrow_FaultName() {
		return (EAttribute)tThrowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTThrow_FaultVariable() {
		return (EAttribute)tThrowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTVariable() {
		return tVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTVariable_Element() {
		return (EAttribute)tVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTVariable_MessageType() {
		return (EAttribute)tVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTVariable_Name() {
		return (EAttribute)tVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTVariable_Type() {
		return (EAttribute)tVariableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTVariable_AnyAttribute() {
		return (EAttribute)tVariableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTVariables() {
		return tVariablesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTVariables_Variable() {
		return (EReference)tVariablesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTWait() {
		return tWaitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTWait_For() {
		return (EAttribute)tWaitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTWait_Until() {
		return (EAttribute)tWaitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTWhile() {
		return tWhileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_Empty() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_Invoke() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_Receive() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_Reply() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_Assign() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_Wait() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_Throw() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_Terminate() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_Flow() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_Switch() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_While() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_Sequence() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_Pick() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTWhile_Scope() {
		return (EReference)tWhileEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTWhile_Condition() {
		return (EAttribute)tWhileEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPatternType() {
		return patternTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTBoolean() {
		return tBooleanEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTRoles() {
		return tRolesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPatternTypeObject() {
		return patternTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPropertiesType() {
		return propertiesTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTBooleanExpr() {
		return tBooleanExprEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTBooleanObject() {
		return tBooleanObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTDeadlineExpr() {
		return tDeadlineExprEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTDurationExpr() {
		return tDurationExprEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTRolesObject() {
		return tRolesObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessFactory getProcessFactory() {
		return (ProcessFactory)getEFactoryInstance();
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
		caseTypeEClass = createEClass(CASE_TYPE);
		createEAttribute(caseTypeEClass, CASE_TYPE__CONDITION);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__FROM);
		createEReference(documentRootEClass, DOCUMENT_ROOT__PROCESS);
		createEReference(documentRootEClass, DOCUMENT_ROOT__TO);

		partnerLinkTypeEClass = createEClass(PARTNER_LINK_TYPE);
		createEAttribute(partnerLinkTypeEClass, PARTNER_LINK_TYPE__NAME);

		tActivityEClass = createEClass(TACTIVITY);
		createEReference(tActivityEClass, TACTIVITY__TARGET);
		createEReference(tActivityEClass, TACTIVITY__SOURCE);
		createEAttribute(tActivityEClass, TACTIVITY__JOIN_CONDITION);
		createEAttribute(tActivityEClass, TACTIVITY__NAME);
		createEAttribute(tActivityEClass, TACTIVITY__SUPPRESS_JOIN_FAILURE);

		tActivityContainerEClass = createEClass(TACTIVITY_CONTAINER);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__EMPTY);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__INVOKE);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__RECEIVE);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__REPLY);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__ASSIGN);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__WAIT);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__THROW);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__TERMINATE);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__FLOW);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__SWITCH);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__WHILE);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__SEQUENCE);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__PICK);
		createEReference(tActivityContainerEClass, TACTIVITY_CONTAINER__SCOPE);

		tActivityOrCompensateContainerEClass = createEClass(TACTIVITY_OR_COMPENSATE_CONTAINER);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__EMPTY);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__INVOKE);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__RECEIVE);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__REPLY);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__ASSIGN);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__WAIT);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__THROW);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__TERMINATE);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__FLOW);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__SWITCH);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__WHILE);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__SEQUENCE);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__PICK);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__SCOPE);
		createEReference(tActivityOrCompensateContainerEClass, TACTIVITY_OR_COMPENSATE_CONTAINER__COMPENSATE);

		tAssignEClass = createEClass(TASSIGN);
		createEReference(tAssignEClass, TASSIGN__COPY);

		tCatchEClass = createEClass(TCATCH);
		createEAttribute(tCatchEClass, TCATCH__FAULT_NAME);
		createEAttribute(tCatchEClass, TCATCH__FAULT_VARIABLE);

		tCompensateEClass = createEClass(TCOMPENSATE);
		createEAttribute(tCompensateEClass, TCOMPENSATE__SCOPE);

		tCompensationHandlerEClass = createEClass(TCOMPENSATION_HANDLER);

		tCopyEClass = createEClass(TCOPY);
		createEReference(tCopyEClass, TCOPY__FROM);
		createEReference(tCopyEClass, TCOPY__TO);

		tCorrelationEClass = createEClass(TCORRELATION);
		createEAttribute(tCorrelationEClass, TCORRELATION__INITIATE);
		createEAttribute(tCorrelationEClass, TCORRELATION__SET);

		tCorrelationsEClass = createEClass(TCORRELATIONS);
		createEReference(tCorrelationsEClass, TCORRELATIONS__CORRELATION);

		tCorrelationSetEClass = createEClass(TCORRELATION_SET);
		createEAttribute(tCorrelationSetEClass, TCORRELATION_SET__NAME);
		createEAttribute(tCorrelationSetEClass, TCORRELATION_SET__PROPERTIES);

		tCorrelationSetsEClass = createEClass(TCORRELATION_SETS);
		createEReference(tCorrelationSetsEClass, TCORRELATION_SETS__CORRELATION_SET);

		tCorrelationsWithPatternEClass = createEClass(TCORRELATIONS_WITH_PATTERN);
		createEReference(tCorrelationsWithPatternEClass, TCORRELATIONS_WITH_PATTERN__CORRELATION);

		tCorrelationWithPatternEClass = createEClass(TCORRELATION_WITH_PATTERN);
		createEAttribute(tCorrelationWithPatternEClass, TCORRELATION_WITH_PATTERN__PATTERN);

		tEmptyEClass = createEClass(TEMPTY);

		tEventHandlersEClass = createEClass(TEVENT_HANDLERS);
		createEReference(tEventHandlersEClass, TEVENT_HANDLERS__ON_MESSAGE);
		createEReference(tEventHandlersEClass, TEVENT_HANDLERS__ON_ALARM);

		tExtensibleElementsEClass = createEClass(TEXTENSIBLE_ELEMENTS);
		createEAttribute(tExtensibleElementsEClass, TEXTENSIBLE_ELEMENTS__ANY);
		createEAttribute(tExtensibleElementsEClass, TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE);

		tFaultHandlersEClass = createEClass(TFAULT_HANDLERS);
		createEReference(tFaultHandlersEClass, TFAULT_HANDLERS__CATCH);
		createEReference(tFaultHandlersEClass, TFAULT_HANDLERS__CATCH_ALL);

		tFlowEClass = createEClass(TFLOW);
		createEReference(tFlowEClass, TFLOW__LINKS);
		createEAttribute(tFlowEClass, TFLOW__ACTIVITY);
		createEReference(tFlowEClass, TFLOW__EMPTY);
		createEReference(tFlowEClass, TFLOW__INVOKE);
		createEReference(tFlowEClass, TFLOW__RECEIVE);
		createEReference(tFlowEClass, TFLOW__REPLY);
		createEReference(tFlowEClass, TFLOW__ASSIGN);
		createEReference(tFlowEClass, TFLOW__WAIT);
		createEReference(tFlowEClass, TFLOW__THROW);
		createEReference(tFlowEClass, TFLOW__TERMINATE);
		createEReference(tFlowEClass, TFLOW__FLOW);
		createEReference(tFlowEClass, TFLOW__SWITCH);
		createEReference(tFlowEClass, TFLOW__WHILE);
		createEReference(tFlowEClass, TFLOW__SEQUENCE);
		createEReference(tFlowEClass, TFLOW__PICK);
		createEReference(tFlowEClass, TFLOW__SCOPE);

		tFromEClass = createEClass(TFROM);
		createEAttribute(tFromEClass, TFROM__ENDPOINT_REFERENCE);
		createEAttribute(tFromEClass, TFROM__EXPRESSION);
		createEAttribute(tFromEClass, TFROM__OPAQUE);
		createEAttribute(tFromEClass, TFROM__PART);
		createEAttribute(tFromEClass, TFROM__PARTNER_LINK);
		createEAttribute(tFromEClass, TFROM__PROPERTY);
		createEAttribute(tFromEClass, TFROM__QUERY);
		createEAttribute(tFromEClass, TFROM__VARIABLE);

		tInvokeEClass = createEClass(TINVOKE);
		createEReference(tInvokeEClass, TINVOKE__CORRELATIONS);
		createEReference(tInvokeEClass, TINVOKE__CATCH);
		createEReference(tInvokeEClass, TINVOKE__CATCH_ALL);
		createEReference(tInvokeEClass, TINVOKE__COMPENSATION_HANDLER);
		createEAttribute(tInvokeEClass, TINVOKE__INPUT_VARIABLE);
		createEAttribute(tInvokeEClass, TINVOKE__OPERATION);
		createEAttribute(tInvokeEClass, TINVOKE__OUTPUT_VARIABLE);
		createEAttribute(tInvokeEClass, TINVOKE__PARTNER_LINK);
		createEAttribute(tInvokeEClass, TINVOKE__PORT_TYPE);

		tLinkEClass = createEClass(TLINK);
		createEAttribute(tLinkEClass, TLINK__NAME);

		tLinksEClass = createEClass(TLINKS);
		createEReference(tLinksEClass, TLINKS__LINK);

		tOnAlarmEClass = createEClass(TON_ALARM);
		createEAttribute(tOnAlarmEClass, TON_ALARM__FOR);
		createEAttribute(tOnAlarmEClass, TON_ALARM__UNTIL);

		tOnMessageEClass = createEClass(TON_MESSAGE);
		createEReference(tOnMessageEClass, TON_MESSAGE__CORRELATIONS);
		createEReference(tOnMessageEClass, TON_MESSAGE__EMPTY);
		createEReference(tOnMessageEClass, TON_MESSAGE__INVOKE);
		createEReference(tOnMessageEClass, TON_MESSAGE__RECEIVE);
		createEReference(tOnMessageEClass, TON_MESSAGE__REPLY);
		createEReference(tOnMessageEClass, TON_MESSAGE__ASSIGN);
		createEReference(tOnMessageEClass, TON_MESSAGE__WAIT);
		createEReference(tOnMessageEClass, TON_MESSAGE__THROW);
		createEReference(tOnMessageEClass, TON_MESSAGE__TERMINATE);
		createEReference(tOnMessageEClass, TON_MESSAGE__FLOW);
		createEReference(tOnMessageEClass, TON_MESSAGE__SWITCH);
		createEReference(tOnMessageEClass, TON_MESSAGE__WHILE);
		createEReference(tOnMessageEClass, TON_MESSAGE__SEQUENCE);
		createEReference(tOnMessageEClass, TON_MESSAGE__PICK);
		createEReference(tOnMessageEClass, TON_MESSAGE__SCOPE);
		createEAttribute(tOnMessageEClass, TON_MESSAGE__OPERATION);
		createEAttribute(tOnMessageEClass, TON_MESSAGE__PARTNER_LINK);
		createEAttribute(tOnMessageEClass, TON_MESSAGE__PORT_TYPE);
		createEAttribute(tOnMessageEClass, TON_MESSAGE__VARIABLE);

		toTypeEClass = createEClass(TO_TYPE);

		tPartnerEClass = createEClass(TPARTNER);
		createEReference(tPartnerEClass, TPARTNER__PARTNER_LINK);
		createEAttribute(tPartnerEClass, TPARTNER__NAME);

		tPartnerLinkEClass = createEClass(TPARTNER_LINK);
		createEAttribute(tPartnerLinkEClass, TPARTNER_LINK__MY_ROLE);
		createEAttribute(tPartnerLinkEClass, TPARTNER_LINK__NAME);
		createEAttribute(tPartnerLinkEClass, TPARTNER_LINK__PARTNER_LINK_TYPE);
		createEAttribute(tPartnerLinkEClass, TPARTNER_LINK__PARTNER_ROLE);

		tPartnerLinksEClass = createEClass(TPARTNER_LINKS);
		createEReference(tPartnerLinksEClass, TPARTNER_LINKS__PARTNER_LINK);

		tPartnersEClass = createEClass(TPARTNERS);
		createEReference(tPartnersEClass, TPARTNERS__PARTNER);

		tPickEClass = createEClass(TPICK);
		createEReference(tPickEClass, TPICK__ON_MESSAGE);
		createEReference(tPickEClass, TPICK__ON_ALARM);
		createEAttribute(tPickEClass, TPICK__CREATE_INSTANCE);

		tProcessEClass = createEClass(TPROCESS);
		createEReference(tProcessEClass, TPROCESS__PARTNER_LINKS);
		createEReference(tProcessEClass, TPROCESS__PARTNERS);
		createEReference(tProcessEClass, TPROCESS__VARIABLES);
		createEReference(tProcessEClass, TPROCESS__CORRELATION_SETS);
		createEReference(tProcessEClass, TPROCESS__FAULT_HANDLERS);
		createEReference(tProcessEClass, TPROCESS__COMPENSATION_HANDLER);
		createEReference(tProcessEClass, TPROCESS__EVENT_HANDLERS);
		createEReference(tProcessEClass, TPROCESS__EMPTY);
		createEReference(tProcessEClass, TPROCESS__INVOKE);
		createEReference(tProcessEClass, TPROCESS__RECEIVE);
		createEReference(tProcessEClass, TPROCESS__REPLY);
		createEReference(tProcessEClass, TPROCESS__ASSIGN);
		createEReference(tProcessEClass, TPROCESS__WAIT);
		createEReference(tProcessEClass, TPROCESS__THROW);
		createEReference(tProcessEClass, TPROCESS__TERMINATE);
		createEReference(tProcessEClass, TPROCESS__FLOW);
		createEReference(tProcessEClass, TPROCESS__SWITCH);
		createEReference(tProcessEClass, TPROCESS__WHILE);
		createEReference(tProcessEClass, TPROCESS__SEQUENCE);
		createEReference(tProcessEClass, TPROCESS__PICK);
		createEReference(tProcessEClass, TPROCESS__SCOPE);
		createEAttribute(tProcessEClass, TPROCESS__ABSTRACT_PROCESS);
		createEAttribute(tProcessEClass, TPROCESS__ENABLE_INSTANCE_COMPENSATION);
		createEAttribute(tProcessEClass, TPROCESS__EXPRESSION_LANGUAGE);
		createEAttribute(tProcessEClass, TPROCESS__NAME);
		createEAttribute(tProcessEClass, TPROCESS__QUERY_LANGUAGE);
		createEAttribute(tProcessEClass, TPROCESS__SUPPRESS_JOIN_FAILURE);
		createEAttribute(tProcessEClass, TPROCESS__TARGET_NAMESPACE);

		tReceiveEClass = createEClass(TRECEIVE);
		createEReference(tReceiveEClass, TRECEIVE__CORRELATIONS);
		createEAttribute(tReceiveEClass, TRECEIVE__CREATE_INSTANCE);
		createEAttribute(tReceiveEClass, TRECEIVE__OPERATION);
		createEAttribute(tReceiveEClass, TRECEIVE__PARTNER_LINK);
		createEAttribute(tReceiveEClass, TRECEIVE__PORT_TYPE);
		createEAttribute(tReceiveEClass, TRECEIVE__VARIABLE);

		tReplyEClass = createEClass(TREPLY);
		createEReference(tReplyEClass, TREPLY__CORRELATIONS);
		createEAttribute(tReplyEClass, TREPLY__FAULT_NAME);
		createEAttribute(tReplyEClass, TREPLY__OPERATION);
		createEAttribute(tReplyEClass, TREPLY__PARTNER_LINK);
		createEAttribute(tReplyEClass, TREPLY__PORT_TYPE);
		createEAttribute(tReplyEClass, TREPLY__VARIABLE);

		tScopeEClass = createEClass(TSCOPE);
		createEReference(tScopeEClass, TSCOPE__VARIABLES);
		createEReference(tScopeEClass, TSCOPE__CORRELATION_SETS);
		createEReference(tScopeEClass, TSCOPE__FAULT_HANDLERS);
		createEReference(tScopeEClass, TSCOPE__COMPENSATION_HANDLER);
		createEReference(tScopeEClass, TSCOPE__EVENT_HANDLERS);
		createEReference(tScopeEClass, TSCOPE__EMPTY);
		createEReference(tScopeEClass, TSCOPE__INVOKE);
		createEReference(tScopeEClass, TSCOPE__RECEIVE);
		createEReference(tScopeEClass, TSCOPE__REPLY);
		createEReference(tScopeEClass, TSCOPE__ASSIGN);
		createEReference(tScopeEClass, TSCOPE__WAIT);
		createEReference(tScopeEClass, TSCOPE__THROW);
		createEReference(tScopeEClass, TSCOPE__TERMINATE);
		createEReference(tScopeEClass, TSCOPE__FLOW);
		createEReference(tScopeEClass, TSCOPE__SWITCH);
		createEReference(tScopeEClass, TSCOPE__WHILE);
		createEReference(tScopeEClass, TSCOPE__SEQUENCE);
		createEReference(tScopeEClass, TSCOPE__PICK);
		createEReference(tScopeEClass, TSCOPE__SCOPE);
		createEAttribute(tScopeEClass, TSCOPE__VARIABLE_ACCESS_SERIALIZABLE);

		tSequenceEClass = createEClass(TSEQUENCE);
		createEAttribute(tSequenceEClass, TSEQUENCE__ACTIVITY);
		createEReference(tSequenceEClass, TSEQUENCE__EMPTY);
		createEReference(tSequenceEClass, TSEQUENCE__INVOKE);
		createEReference(tSequenceEClass, TSEQUENCE__RECEIVE);
		createEReference(tSequenceEClass, TSEQUENCE__REPLY);
		createEReference(tSequenceEClass, TSEQUENCE__ASSIGN);
		createEReference(tSequenceEClass, TSEQUENCE__WAIT);
		createEReference(tSequenceEClass, TSEQUENCE__THROW);
		createEReference(tSequenceEClass, TSEQUENCE__TERMINATE);
		createEReference(tSequenceEClass, TSEQUENCE__FLOW);
		createEReference(tSequenceEClass, TSEQUENCE__SWITCH);
		createEReference(tSequenceEClass, TSEQUENCE__WHILE);
		createEReference(tSequenceEClass, TSEQUENCE__SEQUENCE);
		createEReference(tSequenceEClass, TSEQUENCE__PICK);
		createEReference(tSequenceEClass, TSEQUENCE__SCOPE);

		tSourceEClass = createEClass(TSOURCE);
		createEAttribute(tSourceEClass, TSOURCE__LINK_NAME);
		createEAttribute(tSourceEClass, TSOURCE__TRANSITION_CONDITION);

		tSwitchEClass = createEClass(TSWITCH);
		createEReference(tSwitchEClass, TSWITCH__CASE);
		createEReference(tSwitchEClass, TSWITCH__OTHERWISE);

		tTargetEClass = createEClass(TTARGET);
		createEAttribute(tTargetEClass, TTARGET__LINK_NAME);

		tTerminateEClass = createEClass(TTERMINATE);

		tThrowEClass = createEClass(TTHROW);
		createEAttribute(tThrowEClass, TTHROW__FAULT_NAME);
		createEAttribute(tThrowEClass, TTHROW__FAULT_VARIABLE);

		tVariableEClass = createEClass(TVARIABLE);
		createEAttribute(tVariableEClass, TVARIABLE__ELEMENT);
		createEAttribute(tVariableEClass, TVARIABLE__MESSAGE_TYPE);
		createEAttribute(tVariableEClass, TVARIABLE__NAME);
		createEAttribute(tVariableEClass, TVARIABLE__TYPE);
		createEAttribute(tVariableEClass, TVARIABLE__ANY_ATTRIBUTE);

		tVariablesEClass = createEClass(TVARIABLES);
		createEReference(tVariablesEClass, TVARIABLES__VARIABLE);

		tWaitEClass = createEClass(TWAIT);
		createEAttribute(tWaitEClass, TWAIT__FOR);
		createEAttribute(tWaitEClass, TWAIT__UNTIL);

		tWhileEClass = createEClass(TWHILE);
		createEReference(tWhileEClass, TWHILE__EMPTY);
		createEReference(tWhileEClass, TWHILE__INVOKE);
		createEReference(tWhileEClass, TWHILE__RECEIVE);
		createEReference(tWhileEClass, TWHILE__REPLY);
		createEReference(tWhileEClass, TWHILE__ASSIGN);
		createEReference(tWhileEClass, TWHILE__WAIT);
		createEReference(tWhileEClass, TWHILE__THROW);
		createEReference(tWhileEClass, TWHILE__TERMINATE);
		createEReference(tWhileEClass, TWHILE__FLOW);
		createEReference(tWhileEClass, TWHILE__SWITCH);
		createEReference(tWhileEClass, TWHILE__WHILE);
		createEReference(tWhileEClass, TWHILE__SEQUENCE);
		createEReference(tWhileEClass, TWHILE__PICK);
		createEReference(tWhileEClass, TWHILE__SCOPE);
		createEAttribute(tWhileEClass, TWHILE__CONDITION);

		// Create enums
		patternTypeEEnum = createEEnum(PATTERN_TYPE);
		tBooleanEEnum = createEEnum(TBOOLEAN);
		tRolesEEnum = createEEnum(TROLES);

		// Create data types
		patternTypeObjectEDataType = createEDataType(PATTERN_TYPE_OBJECT);
		propertiesTypeEDataType = createEDataType(PROPERTIES_TYPE);
		tBooleanExprEDataType = createEDataType(TBOOLEAN_EXPR);
		tBooleanObjectEDataType = createEDataType(TBOOLEAN_OBJECT);
		tDeadlineExprEDataType = createEDataType(TDEADLINE_EXPR);
		tDurationExprEDataType = createEDataType(TDURATION_EXPR);
		tRolesObjectEDataType = createEDataType(TROLES_OBJECT);
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
		caseTypeEClass.getESuperTypes().add(this.getTActivityContainer());
		partnerLinkTypeEClass.getESuperTypes().add(this.getTExtensibleElements());
		tActivityEClass.getESuperTypes().add(this.getTExtensibleElements());
		tActivityContainerEClass.getESuperTypes().add(this.getTExtensibleElements());
		tActivityOrCompensateContainerEClass.getESuperTypes().add(this.getTExtensibleElements());
		tAssignEClass.getESuperTypes().add(this.getTActivity());
		tCatchEClass.getESuperTypes().add(this.getTActivityOrCompensateContainer());
		tCompensateEClass.getESuperTypes().add(this.getTActivity());
		tCompensationHandlerEClass.getESuperTypes().add(this.getTActivityOrCompensateContainer());
		tCopyEClass.getESuperTypes().add(this.getTExtensibleElements());
		tCorrelationEClass.getESuperTypes().add(this.getTExtensibleElements());
		tCorrelationsEClass.getESuperTypes().add(this.getTExtensibleElements());
		tCorrelationSetEClass.getESuperTypes().add(this.getTExtensibleElements());
		tCorrelationSetsEClass.getESuperTypes().add(this.getTExtensibleElements());
		tCorrelationsWithPatternEClass.getESuperTypes().add(this.getTExtensibleElements());
		tCorrelationWithPatternEClass.getESuperTypes().add(this.getTCorrelation());
		tEmptyEClass.getESuperTypes().add(this.getTActivity());
		tEventHandlersEClass.getESuperTypes().add(this.getTExtensibleElements());
		tFaultHandlersEClass.getESuperTypes().add(this.getTExtensibleElements());
		tFlowEClass.getESuperTypes().add(this.getTActivity());
		tFromEClass.getESuperTypes().add(this.getTExtensibleElements());
		tInvokeEClass.getESuperTypes().add(this.getTActivity());
		tLinkEClass.getESuperTypes().add(this.getTExtensibleElements());
		tLinksEClass.getESuperTypes().add(this.getTExtensibleElements());
		tOnAlarmEClass.getESuperTypes().add(this.getTActivityContainer());
		tOnMessageEClass.getESuperTypes().add(this.getTExtensibleElements());
		toTypeEClass.getESuperTypes().add(this.getTFrom());
		tPartnerEClass.getESuperTypes().add(this.getTExtensibleElements());
		tPartnerLinkEClass.getESuperTypes().add(this.getTExtensibleElements());
		tPartnerLinksEClass.getESuperTypes().add(this.getTExtensibleElements());
		tPartnersEClass.getESuperTypes().add(this.getTExtensibleElements());
		tPickEClass.getESuperTypes().add(this.getTActivity());
		tProcessEClass.getESuperTypes().add(this.getTExtensibleElements());
		tReceiveEClass.getESuperTypes().add(this.getTActivity());
		tReplyEClass.getESuperTypes().add(this.getTActivity());
		tScopeEClass.getESuperTypes().add(this.getTActivity());
		tSequenceEClass.getESuperTypes().add(this.getTActivity());
		tSourceEClass.getESuperTypes().add(this.getTExtensibleElements());
		tSwitchEClass.getESuperTypes().add(this.getTActivity());
		tTargetEClass.getESuperTypes().add(this.getTExtensibleElements());
		tTerminateEClass.getESuperTypes().add(this.getTActivity());
		tThrowEClass.getESuperTypes().add(this.getTActivity());
		tVariablesEClass.getESuperTypes().add(this.getTExtensibleElements());
		tWaitEClass.getESuperTypes().add(this.getTActivity());
		tWhileEClass.getESuperTypes().add(this.getTActivity());

		// Initialize classes and features; add operations and parameters
		initEClass(caseTypeEClass, CaseType.class, "CaseType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCaseType_Condition(), this.getTBooleanExpr(), "condition", null, 1, 1, CaseType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_From(), this.getTFrom(), null, "from", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Process(), this.getTProcess(), null, "process", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_To(), this.getToType(), null, "to", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(partnerLinkTypeEClass, PartnerLinkType.class, "PartnerLinkType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPartnerLinkType_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, PartnerLinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tActivityEClass, TActivity.class, "TActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTActivity_Target(), this.getTTarget(), null, "target", null, 0, -1, TActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivity_Source(), this.getTSource(), null, "source", null, 0, -1, TActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTActivity_JoinCondition(), this.getTBooleanExpr(), "joinCondition", null, 0, 1, TActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTActivity_Name(), theXMLTypePackage.getNCName(), "name", null, 0, 1, TActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTActivity_SuppressJoinFailure(), this.getTBoolean(), "suppressJoinFailure", "no", 0, 1, TActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tActivityContainerEClass, TActivityContainer.class, "TActivityContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTActivityContainer_Empty(), this.getTEmpty(), null, "empty", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityContainer_Invoke(), this.getTInvoke(), null, "invoke", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityContainer_Receive(), this.getTReceive(), null, "receive", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityContainer_Reply(), this.getTReply(), null, "reply", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityContainer_Assign(), this.getTAssign(), null, "assign", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityContainer_Wait(), this.getTWait(), null, "wait", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityContainer_Throw(), this.getTThrow(), null, "throw", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityContainer_Terminate(), this.getTTerminate(), null, "terminate", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityContainer_Flow(), this.getTFlow(), null, "flow", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityContainer_Switch(), this.getTSwitch(), null, "switch", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityContainer_While(), this.getTWhile(), null, "while", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityContainer_Sequence(), this.getTSequence(), null, "sequence", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityContainer_Pick(), this.getTPick(), null, "pick", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityContainer_Scope(), this.getTScope(), null, "scope", null, 0, 1, TActivityContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tActivityOrCompensateContainerEClass, TActivityOrCompensateContainer.class, "TActivityOrCompensateContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTActivityOrCompensateContainer_Empty(), this.getTEmpty(), null, "empty", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_Invoke(), this.getTInvoke(), null, "invoke", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_Receive(), this.getTReceive(), null, "receive", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_Reply(), this.getTReply(), null, "reply", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_Assign(), this.getTAssign(), null, "assign", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_Wait(), this.getTWait(), null, "wait", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_Throw(), this.getTThrow(), null, "throw", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_Terminate(), this.getTTerminate(), null, "terminate", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_Flow(), this.getTFlow(), null, "flow", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_Switch(), this.getTSwitch(), null, "switch", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_While(), this.getTWhile(), null, "while", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_Sequence(), this.getTSequence(), null, "sequence", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_Pick(), this.getTPick(), null, "pick", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_Scope(), this.getTScope(), null, "scope", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTActivityOrCompensateContainer_Compensate(), this.getTCompensate(), null, "compensate", null, 0, 1, TActivityOrCompensateContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tAssignEClass, TAssign.class, "TAssign", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTAssign_Copy(), this.getTCopy(), null, "copy", null, 1, -1, TAssign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tCatchEClass, TCatch.class, "TCatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCatch_FaultName(), theXMLTypePackage.getQName(), "faultName", null, 0, 1, TCatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCatch_FaultVariable(), theXMLTypePackage.getNCName(), "faultVariable", null, 0, 1, TCatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tCompensateEClass, TCompensate.class, "TCompensate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCompensate_Scope(), theXMLTypePackage.getNCName(), "scope", null, 0, 1, TCompensate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tCompensationHandlerEClass, TCompensationHandler.class, "TCompensationHandler", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tCopyEClass, TCopy.class, "TCopy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCopy_From(), this.getTFrom(), null, "from", null, 1, 1, TCopy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTCopy_To(), this.getToType(), null, "to", null, 1, 1, TCopy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tCorrelationEClass, TCorrelation.class, "TCorrelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCorrelation_Initiate(), this.getTBoolean(), "initiate", "no", 0, 1, TCorrelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCorrelation_Set(), theXMLTypePackage.getNCName(), "set", null, 1, 1, TCorrelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tCorrelationsEClass, TCorrelations.class, "TCorrelations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCorrelations_Correlation(), this.getTCorrelation(), null, "correlation", null, 1, -1, TCorrelations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tCorrelationSetEClass, TCorrelationSet.class, "TCorrelationSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCorrelationSet_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TCorrelationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTCorrelationSet_Properties(), this.getPropertiesType(), "properties", null, 1, 1, TCorrelationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tCorrelationSetsEClass, TCorrelationSets.class, "TCorrelationSets", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCorrelationSets_CorrelationSet(), this.getTCorrelationSet(), null, "correlationSet", null, 1, -1, TCorrelationSets.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tCorrelationsWithPatternEClass, TCorrelationsWithPattern.class, "TCorrelationsWithPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTCorrelationsWithPattern_Correlation(), this.getTCorrelationWithPattern(), null, "correlation", null, 1, -1, TCorrelationsWithPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tCorrelationWithPatternEClass, TCorrelationWithPattern.class, "TCorrelationWithPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTCorrelationWithPattern_Pattern(), this.getPatternType(), "pattern", "in", 0, 1, TCorrelationWithPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tEmptyEClass, TEmpty.class, "TEmpty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tEventHandlersEClass, TEventHandlers.class, "TEventHandlers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTEventHandlers_OnMessage(), this.getTOnMessage(), null, "onMessage", null, 0, -1, TEventHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTEventHandlers_OnAlarm(), this.getTOnAlarm(), null, "onAlarm", null, 0, -1, TEventHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tExtensibleElementsEClass, TExtensibleElements.class, "TExtensibleElements", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTExtensibleElements_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TExtensibleElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTExtensibleElements_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, TExtensibleElements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tFaultHandlersEClass, TFaultHandlers.class, "TFaultHandlers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTFaultHandlers_Catch(), this.getTCatch(), null, "catch", null, 0, -1, TFaultHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTFaultHandlers_CatchAll(), this.getTActivityOrCompensateContainer(), null, "catchAll", null, 0, 1, TFaultHandlers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tFlowEClass, TFlow.class, "TFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTFlow_Links(), this.getTLinks(), null, "links", null, 0, 1, TFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTFlow_Activity(), ecorePackage.getEFeatureMapEntry(), "activity", null, 0, -1, TFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_Empty(), this.getTEmpty(), null, "empty", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_Invoke(), this.getTInvoke(), null, "invoke", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_Receive(), this.getTReceive(), null, "receive", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_Reply(), this.getTReply(), null, "reply", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_Assign(), this.getTAssign(), null, "assign", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_Wait(), this.getTWait(), null, "wait", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_Throw(), this.getTThrow(), null, "throw", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_Terminate(), this.getTTerminate(), null, "terminate", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_Flow(), this.getTFlow(), null, "flow", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_Switch(), this.getTSwitch(), null, "switch", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_While(), this.getTWhile(), null, "while", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_Sequence(), this.getTSequence(), null, "sequence", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_Pick(), this.getTPick(), null, "pick", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTFlow_Scope(), this.getTScope(), null, "scope", null, 0, -1, TFlow.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(tFromEClass, TFrom.class, "TFrom", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTFrom_EndpointReference(), this.getTRoles(), "endpointReference", "myRole", 0, 1, TFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTFrom_Expression(), theXMLTypePackage.getString(), "expression", null, 0, 1, TFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTFrom_Opaque(), this.getTBoolean(), "opaque", "yes", 0, 1, TFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTFrom_Part(), theXMLTypePackage.getNCName(), "part", null, 0, 1, TFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTFrom_PartnerLink(), theXMLTypePackage.getNCName(), "partnerLink", null, 0, 1, TFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTFrom_Property(), theXMLTypePackage.getQName(), "property", null, 0, 1, TFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTFrom_Query(), theXMLTypePackage.getString(), "query", null, 0, 1, TFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTFrom_Variable(), theXMLTypePackage.getNCName(), "variable", null, 0, 1, TFrom.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tInvokeEClass, TInvoke.class, "TInvoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTInvoke_Correlations(), this.getTCorrelationsWithPattern(), null, "correlations", null, 0, 1, TInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInvoke_Catch(), this.getTCatch(), null, "catch", null, 0, -1, TInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInvoke_CatchAll(), this.getTActivityOrCompensateContainer(), null, "catchAll", null, 0, 1, TInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInvoke_CompensationHandler(), this.getTCompensationHandler(), null, "compensationHandler", null, 0, 1, TInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTInvoke_InputVariable(), theXMLTypePackage.getNCName(), "inputVariable", null, 0, 1, TInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTInvoke_Operation(), theXMLTypePackage.getNCName(), "operation", null, 1, 1, TInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTInvoke_OutputVariable(), theXMLTypePackage.getNCName(), "outputVariable", null, 0, 1, TInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTInvoke_PartnerLink(), theXMLTypePackage.getNCName(), "partnerLink", null, 1, 1, TInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTInvoke_PortType(), theXMLTypePackage.getQName(), "portType", null, 1, 1, TInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tLinkEClass, TLink.class, "TLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTLink_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tLinksEClass, TLinks.class, "TLinks", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTLinks_Link(), this.getTLink(), null, "link", null, 1, -1, TLinks.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tOnAlarmEClass, TOnAlarm.class, "TOnAlarm", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTOnAlarm_For(), this.getTDurationExpr(), "for", null, 0, 1, TOnAlarm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTOnAlarm_Until(), this.getTDeadlineExpr(), "until", null, 0, 1, TOnAlarm.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tOnMessageEClass, TOnMessage.class, "TOnMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTOnMessage_Correlations(), this.getTCorrelations(), null, "correlations", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_Empty(), this.getTEmpty(), null, "empty", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_Invoke(), this.getTInvoke(), null, "invoke", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_Receive(), this.getTReceive(), null, "receive", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_Reply(), this.getTReply(), null, "reply", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_Assign(), this.getTAssign(), null, "assign", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_Wait(), this.getTWait(), null, "wait", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_Throw(), this.getTThrow(), null, "throw", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_Terminate(), this.getTTerminate(), null, "terminate", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_Flow(), this.getTFlow(), null, "flow", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_Switch(), this.getTSwitch(), null, "switch", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_While(), this.getTWhile(), null, "while", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_Sequence(), this.getTSequence(), null, "sequence", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_Pick(), this.getTPick(), null, "pick", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTOnMessage_Scope(), this.getTScope(), null, "scope", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTOnMessage_Operation(), theXMLTypePackage.getNCName(), "operation", null, 1, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTOnMessage_PartnerLink(), theXMLTypePackage.getNCName(), "partnerLink", null, 1, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTOnMessage_PortType(), theXMLTypePackage.getQName(), "portType", null, 1, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTOnMessage_Variable(), theXMLTypePackage.getNCName(), "variable", null, 0, 1, TOnMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toTypeEClass, ToType.class, "ToType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tPartnerEClass, TPartner.class, "TPartner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTPartner_PartnerLink(), this.getPartnerLinkType(), null, "partnerLink", null, 1, -1, TPartner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPartner_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TPartner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPartnerLinkEClass, TPartnerLink.class, "TPartnerLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTPartnerLink_MyRole(), theXMLTypePackage.getNCName(), "myRole", null, 0, 1, TPartnerLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPartnerLink_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TPartnerLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPartnerLink_PartnerLinkType(), theXMLTypePackage.getQName(), "partnerLinkType", null, 1, 1, TPartnerLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPartnerLink_PartnerRole(), theXMLTypePackage.getNCName(), "partnerRole", null, 0, 1, TPartnerLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPartnerLinksEClass, TPartnerLinks.class, "TPartnerLinks", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTPartnerLinks_PartnerLink(), this.getTPartnerLink(), null, "partnerLink", null, 1, -1, TPartnerLinks.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPartnersEClass, TPartners.class, "TPartners", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTPartners_Partner(), this.getTPartner(), null, "partner", null, 1, -1, TPartners.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tPickEClass, TPick.class, "TPick", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTPick_OnMessage(), this.getTOnMessage(), null, "onMessage", null, 1, -1, TPick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTPick_OnAlarm(), this.getTOnAlarm(), null, "onAlarm", null, 0, -1, TPick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTPick_CreateInstance(), this.getTBoolean(), "createInstance", "no", 0, 1, TPick.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tProcessEClass, TProcess.class, "TProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTProcess_PartnerLinks(), this.getTPartnerLinks(), null, "partnerLinks", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Partners(), this.getTPartners(), null, "partners", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Variables(), this.getTVariables(), null, "variables", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_CorrelationSets(), this.getTCorrelationSets(), null, "correlationSets", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_FaultHandlers(), this.getTFaultHandlers(), null, "faultHandlers", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_CompensationHandler(), this.getTCompensationHandler(), null, "compensationHandler", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_EventHandlers(), this.getTEventHandlers(), null, "eventHandlers", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Empty(), this.getTEmpty(), null, "empty", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Invoke(), this.getTInvoke(), null, "invoke", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Receive(), this.getTReceive(), null, "receive", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Reply(), this.getTReply(), null, "reply", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Assign(), this.getTAssign(), null, "assign", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Wait(), this.getTWait(), null, "wait", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Throw(), this.getTThrow(), null, "throw", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Terminate(), this.getTTerminate(), null, "terminate", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Flow(), this.getTFlow(), null, "flow", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Switch(), this.getTSwitch(), null, "switch", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_While(), this.getTWhile(), null, "while", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Sequence(), this.getTSequence(), null, "sequence", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Pick(), this.getTPick(), null, "pick", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTProcess_Scope(), this.getTScope(), null, "scope", null, 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTProcess_AbstractProcess(), this.getTBoolean(), "abstractProcess", "no", 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTProcess_EnableInstanceCompensation(), this.getTBoolean(), "enableInstanceCompensation", "no", 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTProcess_ExpressionLanguage(), theXMLTypePackage.getAnyURI(), "expressionLanguage", "http://www.w3.org/TR/1999/REC-xpath-19991116", 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTProcess_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTProcess_QueryLanguage(), theXMLTypePackage.getAnyURI(), "queryLanguage", "http://www.w3.org/TR/1999/REC-xpath-19991116", 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTProcess_SuppressJoinFailure(), this.getTBoolean(), "suppressJoinFailure", "no", 0, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTProcess_TargetNamespace(), theXMLTypePackage.getAnyURI(), "targetNamespace", null, 1, 1, TProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tReceiveEClass, TReceive.class, "TReceive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTReceive_Correlations(), this.getTCorrelations(), null, "correlations", null, 0, 1, TReceive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTReceive_CreateInstance(), this.getTBoolean(), "createInstance", "no", 0, 1, TReceive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTReceive_Operation(), theXMLTypePackage.getNCName(), "operation", null, 1, 1, TReceive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTReceive_PartnerLink(), theXMLTypePackage.getNCName(), "partnerLink", null, 1, 1, TReceive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTReceive_PortType(), theXMLTypePackage.getQName(), "portType", null, 1, 1, TReceive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTReceive_Variable(), theXMLTypePackage.getNCName(), "variable", null, 0, 1, TReceive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tReplyEClass, TReply.class, "TReply", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTReply_Correlations(), this.getTCorrelations(), null, "correlations", null, 0, 1, TReply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTReply_FaultName(), theXMLTypePackage.getQName(), "faultName", null, 0, 1, TReply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTReply_Operation(), theXMLTypePackage.getNCName(), "operation", null, 1, 1, TReply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTReply_PartnerLink(), theXMLTypePackage.getNCName(), "partnerLink", null, 1, 1, TReply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTReply_PortType(), theXMLTypePackage.getQName(), "portType", null, 1, 1, TReply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTReply_Variable(), theXMLTypePackage.getNCName(), "variable", null, 0, 1, TReply.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tScopeEClass, TScope.class, "TScope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTScope_Variables(), this.getTVariables(), null, "variables", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_CorrelationSets(), this.getTCorrelationSets(), null, "correlationSets", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_FaultHandlers(), this.getTFaultHandlers(), null, "faultHandlers", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_CompensationHandler(), this.getTCompensationHandler(), null, "compensationHandler", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_EventHandlers(), this.getTEventHandlers(), null, "eventHandlers", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_Empty(), this.getTEmpty(), null, "empty", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_Invoke(), this.getTInvoke(), null, "invoke", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_Receive(), this.getTReceive(), null, "receive", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_Reply(), this.getTReply(), null, "reply", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_Assign(), this.getTAssign(), null, "assign", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_Wait(), this.getTWait(), null, "wait", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_Throw(), this.getTThrow(), null, "throw", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_Terminate(), this.getTTerminate(), null, "terminate", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_Flow(), this.getTFlow(), null, "flow", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_Switch(), this.getTSwitch(), null, "switch", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_While(), this.getTWhile(), null, "while", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_Sequence(), this.getTSequence(), null, "sequence", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_Pick(), this.getTPick(), null, "pick", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTScope_Scope(), this.getTScope(), null, "scope", null, 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTScope_VariableAccessSerializable(), this.getTBoolean(), "variableAccessSerializable", "no", 0, 1, TScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(tScopeEClass, null, "setActivity", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTActivity(), "activity", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(tSequenceEClass, TSequence.class, "TSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTSequence_Activity(), ecorePackage.getEFeatureMapEntry(), "activity", null, 0, -1, TSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_Empty(), this.getTEmpty(), null, "empty", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_Invoke(), this.getTInvoke(), null, "invoke", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_Receive(), this.getTReceive(), null, "receive", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_Reply(), this.getTReply(), null, "reply", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_Assign(), this.getTAssign(), null, "assign", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_Wait(), this.getTWait(), null, "wait", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_Throw(), this.getTThrow(), null, "throw", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_Terminate(), this.getTTerminate(), null, "terminate", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_Flow(), this.getTFlow(), null, "flow", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_Switch(), this.getTSwitch(), null, "switch", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_While(), this.getTWhile(), null, "while", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_Sequence(), this.getTSequence(), null, "sequence", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_Pick(), this.getTPick(), null, "pick", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getTSequence_Scope(), this.getTScope(), null, "scope", null, 0, -1, TSequence.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(tSourceEClass, TSource.class, "TSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTSource_LinkName(), theXMLTypePackage.getNCName(), "linkName", null, 1, 1, TSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTSource_TransitionCondition(), this.getTBooleanExpr(), "transitionCondition", null, 0, 1, TSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tSwitchEClass, TSwitch.class, "TSwitch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTSwitch_Case(), this.getCaseType(), null, "case", null, 1, -1, TSwitch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTSwitch_Otherwise(), this.getTActivityContainer(), null, "otherwise", null, 0, 1, TSwitch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tTargetEClass, TTarget.class, "TTarget", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTTarget_LinkName(), theXMLTypePackage.getNCName(), "linkName", null, 1, 1, TTarget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tTerminateEClass, TTerminate.class, "TTerminate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tThrowEClass, TThrow.class, "TThrow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTThrow_FaultName(), theXMLTypePackage.getQName(), "faultName", null, 1, 1, TThrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTThrow_FaultVariable(), theXMLTypePackage.getNCName(), "faultVariable", null, 0, 1, TThrow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tVariableEClass, TVariable.class, "TVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTVariable_Element(), theXMLTypePackage.getQName(), "element", null, 0, 1, TVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTVariable_MessageType(), theXMLTypePackage.getQName(), "messageType", null, 0, 1, TVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTVariable_Name(), theXMLTypePackage.getNCName(), "name", null, 1, 1, TVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTVariable_Type(), theXMLTypePackage.getQName(), "type", null, 0, 1, TVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTVariable_AnyAttribute(), ecorePackage.getEFeatureMapEntry(), "anyAttribute", null, 0, -1, TVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tVariablesEClass, TVariables.class, "TVariables", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTVariables_Variable(), this.getTVariable(), null, "variable", null, 1, -1, TVariables.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tWaitEClass, TWait.class, "TWait", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTWait_For(), this.getTDurationExpr(), "for", null, 0, 1, TWait.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTWait_Until(), this.getTDeadlineExpr(), "until", null, 0, 1, TWait.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tWhileEClass, TWhile.class, "TWhile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTWhile_Empty(), this.getTEmpty(), null, "empty", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTWhile_Invoke(), this.getTInvoke(), null, "invoke", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTWhile_Receive(), this.getTReceive(), null, "receive", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTWhile_Reply(), this.getTReply(), null, "reply", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTWhile_Assign(), this.getTAssign(), null, "assign", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTWhile_Wait(), this.getTWait(), null, "wait", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTWhile_Throw(), this.getTThrow(), null, "throw", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTWhile_Terminate(), this.getTTerminate(), null, "terminate", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTWhile_Flow(), this.getTFlow(), null, "flow", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTWhile_Switch(), this.getTSwitch(), null, "switch", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTWhile_While(), this.getTWhile(), null, "while", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTWhile_Sequence(), this.getTSequence(), null, "sequence", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTWhile_Pick(), this.getTPick(), null, "pick", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTWhile_Scope(), this.getTScope(), null, "scope", null, 0, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTWhile_Condition(), this.getTBooleanExpr(), "condition", null, 1, 1, TWhile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(patternTypeEEnum, PatternType.class, "PatternType");
		addEEnumLiteral(patternTypeEEnum, PatternType.IN);
		addEEnumLiteral(patternTypeEEnum, PatternType.OUT);
		addEEnumLiteral(patternTypeEEnum, PatternType.OUT_IN);

		initEEnum(tBooleanEEnum, TBoolean.class, "TBoolean");
		addEEnumLiteral(tBooleanEEnum, TBoolean.YES);
		addEEnumLiteral(tBooleanEEnum, TBoolean.NO);

		initEEnum(tRolesEEnum, TRoles.class, "TRoles");
		addEEnumLiteral(tRolesEEnum, TRoles.MY_ROLE);
		addEEnumLiteral(tRolesEEnum, TRoles.PARTNER_ROLE);

		// Initialize data types
		initEDataType(patternTypeObjectEDataType, PatternType.class, "PatternTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(propertiesTypeEDataType, List.class, "PropertiesType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tBooleanExprEDataType, String.class, "TBooleanExpr", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tBooleanObjectEDataType, TBoolean.class, "TBooleanObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tDeadlineExprEDataType, String.class, "TDeadlineExpr", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tDurationExprEDataType, String.class, "TDurationExpr", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(tRolesObjectEDataType, TRoles.class, "TRolesObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

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
		  (caseTypeEClass, 
		   source, 
		   new String[] {
			 "name", "case_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getCaseType_Condition(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "condition"
		   });		
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
		  (getDocumentRoot_From(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "from",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_Process(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "process",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDocumentRoot_To(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "to",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (partnerLinkTypeEClass, 
		   source, 
		   new String[] {
			 "name", "partnerLink_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPartnerLinkType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (patternTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "pattern_._type"
		   });		
		addAnnotation
		  (patternTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "pattern_._type:Object",
			 "baseType", "pattern_._type"
		   });		
		addAnnotation
		  (propertiesTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "properties_._type",
			 "itemType", "http://www.eclipse.org/emf/2003/XMLType#QName"
		   });		
		addAnnotation
		  (tActivityEClass, 
		   source, 
		   new String[] {
			 "name", "tActivity",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTActivity_Target(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "target",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivity_Source(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "source",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivity_JoinCondition(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "joinCondition"
		   });		
		addAnnotation
		  (getTActivity_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getTActivity_SuppressJoinFailure(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "suppressJoinFailure"
		   });		
		addAnnotation
		  (tActivityContainerEClass, 
		   source, 
		   new String[] {
			 "name", "tActivityContainer",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTActivityContainer_Empty(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "empty",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityContainer_Invoke(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "invoke",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityContainer_Receive(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "receive",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityContainer_Reply(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "reply",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityContainer_Assign(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "assign",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityContainer_Wait(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "wait",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityContainer_Throw(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "throw",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityContainer_Terminate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "terminate",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityContainer_Flow(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flow",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityContainer_Switch(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "switch",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityContainer_While(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "while",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityContainer_Sequence(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "sequence",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityContainer_Pick(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "pick",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityContainer_Scope(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "scope",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tActivityOrCompensateContainerEClass, 
		   source, 
		   new String[] {
			 "name", "tActivityOrCompensateContainer",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Empty(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "empty",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Invoke(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "invoke",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Receive(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "receive",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Reply(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "reply",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Assign(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "assign",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Wait(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "wait",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Throw(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "throw",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Terminate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "terminate",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Flow(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flow",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Switch(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "switch",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_While(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "while",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Sequence(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "sequence",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Pick(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "pick",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Scope(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "scope",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTActivityOrCompensateContainer_Compensate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "compensate",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tAssignEClass, 
		   source, 
		   new String[] {
			 "name", "tAssign",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTAssign_Copy(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "copy",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tBooleanEEnum, 
		   source, 
		   new String[] {
			 "name", "tBoolean"
		   });		
		addAnnotation
		  (tBooleanExprEDataType, 
		   source, 
		   new String[] {
			 "name", "tBoolean-expr",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string"
		   });		
		addAnnotation
		  (tBooleanObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "tBoolean:Object",
			 "baseType", "tBoolean"
		   });		
		addAnnotation
		  (tCatchEClass, 
		   source, 
		   new String[] {
			 "name", "tCatch",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTCatch_FaultName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "faultName"
		   });		
		addAnnotation
		  (getTCatch_FaultVariable(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "faultVariable"
		   });		
		addAnnotation
		  (tCompensateEClass, 
		   source, 
		   new String[] {
			 "name", "tCompensate",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTCompensate_Scope(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "scope"
		   });		
		addAnnotation
		  (tCompensationHandlerEClass, 
		   source, 
		   new String[] {
			 "name", "tCompensationHandler",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (tCopyEClass, 
		   source, 
		   new String[] {
			 "name", "tCopy",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTCopy_From(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "from",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTCopy_To(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "to",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tCorrelationEClass, 
		   source, 
		   new String[] {
			 "name", "tCorrelation",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTCorrelation_Initiate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "initiate"
		   });		
		addAnnotation
		  (getTCorrelation_Set(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "set"
		   });		
		addAnnotation
		  (tCorrelationsEClass, 
		   source, 
		   new String[] {
			 "name", "tCorrelations",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTCorrelations_Correlation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tCorrelationSetEClass, 
		   source, 
		   new String[] {
			 "name", "tCorrelationSet",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTCorrelationSet_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getTCorrelationSet_Properties(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "properties"
		   });		
		addAnnotation
		  (tCorrelationSetsEClass, 
		   source, 
		   new String[] {
			 "name", "tCorrelationSets",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTCorrelationSets_CorrelationSet(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationSet",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tCorrelationsWithPatternEClass, 
		   source, 
		   new String[] {
			 "name", "tCorrelationsWithPattern",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTCorrelationsWithPattern_Correlation(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlation",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tCorrelationWithPatternEClass, 
		   source, 
		   new String[] {
			 "name", "tCorrelationWithPattern",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTCorrelationWithPattern_Pattern(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "pattern"
		   });		
		addAnnotation
		  (tDeadlineExprEDataType, 
		   source, 
		   new String[] {
			 "name", "tDeadline-expr",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string"
		   });		
		addAnnotation
		  (tDurationExprEDataType, 
		   source, 
		   new String[] {
			 "name", "tDuration-expr",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string"
		   });		
		addAnnotation
		  (tEmptyEClass, 
		   source, 
		   new String[] {
			 "name", "tEmpty",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (tEventHandlersEClass, 
		   source, 
		   new String[] {
			 "name", "tEventHandlers",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTEventHandlers_OnMessage(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "onMessage",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTEventHandlers_OnAlarm(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "onAlarm",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (tExtensibleElementsEClass, 
		   source, 
		   new String[] {
			 "name", "tExtensibleElements",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTExtensibleElements_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":0",
			 "processing", "lax"
		   });		
		addAnnotation
		  (getTExtensibleElements_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":1",
			 "processing", "lax"
		   });		
		addAnnotation
		  (tFaultHandlersEClass, 
		   source, 
		   new String[] {
			 "name", "tFaultHandlers",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTFaultHandlers_Catch(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "catch",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTFaultHandlers_CatchAll(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "catchAll",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tFlowEClass, 
		   source, 
		   new String[] {
			 "name", "tFlow",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTFlow_Links(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "links",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTFlow_Activity(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "Activity:8"
		   });		
		addAnnotation
		  (getTFlow_Empty(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "empty",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (getTFlow_Invoke(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "invoke",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (getTFlow_Receive(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "receive",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (getTFlow_Reply(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "reply",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (getTFlow_Assign(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "assign",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (getTFlow_Wait(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "wait",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (getTFlow_Throw(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "throw",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (getTFlow_Terminate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "terminate",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (getTFlow_Flow(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flow",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (getTFlow_Switch(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "switch",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (getTFlow_While(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "while",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (getTFlow_Sequence(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "sequence",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (getTFlow_Pick(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "pick",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (getTFlow_Scope(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "scope",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:8"
		   });		
		addAnnotation
		  (tFromEClass, 
		   source, 
		   new String[] {
			 "name", "tFrom",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTFrom_EndpointReference(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "endpointReference"
		   });		
		addAnnotation
		  (getTFrom_Expression(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "expression"
		   });		
		addAnnotation
		  (getTFrom_Opaque(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "opaque"
		   });		
		addAnnotation
		  (getTFrom_Part(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "part"
		   });		
		addAnnotation
		  (getTFrom_PartnerLink(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "partnerLink"
		   });		
		addAnnotation
		  (getTFrom_Property(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "property"
		   });		
		addAnnotation
		  (getTFrom_Query(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "query"
		   });		
		addAnnotation
		  (getTFrom_Variable(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "variable"
		   });		
		addAnnotation
		  (tInvokeEClass, 
		   source, 
		   new String[] {
			 "name", "tInvoke",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTInvoke_Correlations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlations",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTInvoke_Catch(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "catch",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTInvoke_CatchAll(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "catchAll",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTInvoke_CompensationHandler(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "compensationHandler",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTInvoke_InputVariable(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "inputVariable"
		   });		
		addAnnotation
		  (getTInvoke_Operation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operation"
		   });		
		addAnnotation
		  (getTInvoke_OutputVariable(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "outputVariable"
		   });		
		addAnnotation
		  (getTInvoke_PartnerLink(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "partnerLink"
		   });		
		addAnnotation
		  (getTInvoke_PortType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "portType"
		   });		
		addAnnotation
		  (tLinkEClass, 
		   source, 
		   new String[] {
			 "name", "tLink",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTLink_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tLinksEClass, 
		   source, 
		   new String[] {
			 "name", "tLinks",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTLinks_Link(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "link",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tOnAlarmEClass, 
		   source, 
		   new String[] {
			 "name", "tOnAlarm",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTOnAlarm_For(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "for"
		   });		
		addAnnotation
		  (getTOnAlarm_Until(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "until"
		   });		
		addAnnotation
		  (tOnMessageEClass, 
		   source, 
		   new String[] {
			 "name", "tOnMessage",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTOnMessage_Correlations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlations",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Empty(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "empty",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Invoke(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "invoke",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Receive(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "receive",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Reply(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "reply",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Assign(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "assign",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Wait(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "wait",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Throw(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "throw",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Terminate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "terminate",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Flow(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flow",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Switch(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "switch",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_While(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "while",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Sequence(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "sequence",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Pick(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "pick",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Scope(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "scope",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTOnMessage_Operation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operation"
		   });		
		addAnnotation
		  (getTOnMessage_PartnerLink(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "partnerLink"
		   });		
		addAnnotation
		  (getTOnMessage_PortType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "portType"
		   });		
		addAnnotation
		  (getTOnMessage_Variable(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "variable"
		   });		
		addAnnotation
		  (toTypeEClass, 
		   source, 
		   new String[] {
			 "name", "to_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (tPartnerEClass, 
		   source, 
		   new String[] {
			 "name", "tPartner",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTPartner_PartnerLink(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "partnerLink",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTPartner_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tPartnerLinkEClass, 
		   source, 
		   new String[] {
			 "name", "tPartnerLink",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTPartnerLink_MyRole(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "myRole"
		   });		
		addAnnotation
		  (getTPartnerLink_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getTPartnerLink_PartnerLinkType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "partnerLinkType"
		   });		
		addAnnotation
		  (getTPartnerLink_PartnerRole(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "partnerRole"
		   });		
		addAnnotation
		  (tPartnerLinksEClass, 
		   source, 
		   new String[] {
			 "name", "tPartnerLinks",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTPartnerLinks_PartnerLink(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "partnerLink",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tPartnersEClass, 
		   source, 
		   new String[] {
			 "name", "tPartners",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTPartners_Partner(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "partner",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tPickEClass, 
		   source, 
		   new String[] {
			 "name", "tPick",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTPick_OnMessage(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "onMessage",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTPick_OnAlarm(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "onAlarm",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTPick_CreateInstance(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "createInstance"
		   });		
		addAnnotation
		  (tProcessEClass, 
		   source, 
		   new String[] {
			 "name", "tProcess",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTProcess_PartnerLinks(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "partnerLinks",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Partners(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "partners",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Variables(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "variables",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_CorrelationSets(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationSets",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_FaultHandlers(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "faultHandlers",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_CompensationHandler(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "compensationHandler",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_EventHandlers(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "eventHandlers",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Empty(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "empty",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Invoke(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "invoke",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Receive(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "receive",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Reply(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "reply",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Assign(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "assign",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Wait(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "wait",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Throw(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "throw",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Terminate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "terminate",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Flow(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flow",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Switch(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "switch",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_While(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "while",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Sequence(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "sequence",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Pick(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "pick",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_Scope(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "scope",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcess_AbstractProcess(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "abstractProcess"
		   });		
		addAnnotation
		  (getTProcess_EnableInstanceCompensation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "enableInstanceCompensation"
		   });		
		addAnnotation
		  (getTProcess_ExpressionLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "expressionLanguage"
		   });		
		addAnnotation
		  (getTProcess_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getTProcess_QueryLanguage(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "queryLanguage"
		   });		
		addAnnotation
		  (getTProcess_SuppressJoinFailure(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "suppressJoinFailure"
		   });		
		addAnnotation
		  (getTProcess_TargetNamespace(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "targetNamespace"
		   });		
		addAnnotation
		  (tReceiveEClass, 
		   source, 
		   new String[] {
			 "name", "tReceive",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTReceive_Correlations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlations",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTReceive_CreateInstance(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "createInstance"
		   });		
		addAnnotation
		  (getTReceive_Operation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operation"
		   });		
		addAnnotation
		  (getTReceive_PartnerLink(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "partnerLink"
		   });		
		addAnnotation
		  (getTReceive_PortType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "portType"
		   });		
		addAnnotation
		  (getTReceive_Variable(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "variable"
		   });		
		addAnnotation
		  (tReplyEClass, 
		   source, 
		   new String[] {
			 "name", "tReply",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTReply_Correlations(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlations",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTReply_FaultName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "faultName"
		   });		
		addAnnotation
		  (getTReply_Operation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "operation"
		   });		
		addAnnotation
		  (getTReply_PartnerLink(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "partnerLink"
		   });		
		addAnnotation
		  (getTReply_PortType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "portType"
		   });		
		addAnnotation
		  (getTReply_Variable(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "variable"
		   });		
		addAnnotation
		  (tRolesEEnum, 
		   source, 
		   new String[] {
			 "name", "tRoles"
		   });		
		addAnnotation
		  (tRolesObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "tRoles:Object",
			 "baseType", "tRoles"
		   });		
		addAnnotation
		  (tScopeEClass, 
		   source, 
		   new String[] {
			 "name", "tScope",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTScope_Variables(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "variables",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_CorrelationSets(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "correlationSets",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_FaultHandlers(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "faultHandlers",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_CompensationHandler(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "compensationHandler",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_EventHandlers(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "eventHandlers",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_Empty(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "empty",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_Invoke(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "invoke",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_Receive(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "receive",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_Reply(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "reply",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_Assign(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "assign",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_Wait(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "wait",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_Throw(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "throw",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_Terminate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "terminate",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_Flow(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flow",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_Switch(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "switch",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_While(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "while",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_Sequence(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "sequence",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_Pick(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "pick",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_Scope(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "scope",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTScope_VariableAccessSerializable(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "variableAccessSerializable"
		   });		
		addAnnotation
		  (tSequenceEClass, 
		   source, 
		   new String[] {
			 "name", "tSequence",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTSequence_Activity(), 
		   source, 
		   new String[] {
			 "kind", "group",
			 "name", "Activity:7"
		   });		
		addAnnotation
		  (getTSequence_Empty(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "empty",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (getTSequence_Invoke(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "invoke",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (getTSequence_Receive(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "receive",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (getTSequence_Reply(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "reply",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (getTSequence_Assign(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "assign",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (getTSequence_Wait(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "wait",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (getTSequence_Throw(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "throw",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (getTSequence_Terminate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "terminate",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (getTSequence_Flow(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flow",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (getTSequence_Switch(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "switch",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (getTSequence_While(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "while",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (getTSequence_Sequence(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "sequence",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (getTSequence_Pick(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "pick",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (getTSequence_Scope(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "scope",
			 "namespace", "##targetNamespace",
			 "group", "#Activity:7"
		   });		
		addAnnotation
		  (tSourceEClass, 
		   source, 
		   new String[] {
			 "name", "tSource",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTSource_LinkName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "linkName"
		   });		
		addAnnotation
		  (getTSource_TransitionCondition(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "transitionCondition"
		   });		
		addAnnotation
		  (tSwitchEClass, 
		   source, 
		   new String[] {
			 "name", "tSwitch",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTSwitch_Case(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "case",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTSwitch_Otherwise(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "otherwise",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tTargetEClass, 
		   source, 
		   new String[] {
			 "name", "tTarget",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTTarget_LinkName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "linkName"
		   });		
		addAnnotation
		  (tTerminateEClass, 
		   source, 
		   new String[] {
			 "name", "tTerminate",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (tThrowEClass, 
		   source, 
		   new String[] {
			 "name", "tThrow",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTThrow_FaultName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "faultName"
		   });		
		addAnnotation
		  (getTThrow_FaultVariable(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "faultVariable"
		   });		
		addAnnotation
		  (tVariableEClass, 
		   source, 
		   new String[] {
			 "name", "tVariable",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getTVariable_Element(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "element"
		   });		
		addAnnotation
		  (getTVariable_MessageType(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "messageType"
		   });		
		addAnnotation
		  (getTVariable_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getTVariable_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type"
		   });		
		addAnnotation
		  (getTVariable_AnyAttribute(), 
		   source, 
		   new String[] {
			 "kind", "attributeWildcard",
			 "wildcards", "##other",
			 "name", ":4",
			 "processing", "lax"
		   });		
		addAnnotation
		  (tVariablesEClass, 
		   source, 
		   new String[] {
			 "name", "tVariables",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTVariables_Variable(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "variable",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tWaitEClass, 
		   source, 
		   new String[] {
			 "name", "tWait",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTWait_For(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "for"
		   });		
		addAnnotation
		  (getTWait_Until(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "until"
		   });		
		addAnnotation
		  (tWhileEClass, 
		   source, 
		   new String[] {
			 "name", "tWhile",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTWhile_Empty(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "empty",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_Invoke(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "invoke",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_Receive(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "receive",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_Reply(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "reply",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_Assign(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "assign",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_Wait(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "wait",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_Throw(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "throw",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_Terminate(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "terminate",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_Flow(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "flow",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_Switch(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "switch",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_While(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "while",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_Sequence(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "sequence",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_Pick(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "pick",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_Scope(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "scope",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTWhile_Condition(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "condition"
		   });
	}

} //ProcessPackageImpl
