/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.xmlsoap.schemas.ws._2003._03.business.process.CaseType;
import org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot;
import org.xmlsoap.schemas.ws._2003._03.business.process.PartnerLinkType;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivity;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer;
import org.xmlsoap.schemas.ws._2003._03.business.process.TAssign;
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

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage
 * @generated
 */
public class ProcessAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProcessPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ProcessPackage.eINSTANCE;
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
	protected ProcessSwitch<Adapter> modelSwitch =
		new ProcessSwitch<Adapter>() {
			@Override
			public Adapter caseCaseType(CaseType object) {
				return createCaseTypeAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter casePartnerLinkType(PartnerLinkType object) {
				return createPartnerLinkTypeAdapter();
			}
			@Override
			public Adapter caseTActivity(TActivity object) {
				return createTActivityAdapter();
			}
			@Override
			public Adapter caseTActivityContainer(TActivityContainer object) {
				return createTActivityContainerAdapter();
			}
			@Override
			public Adapter caseTActivityOrCompensateContainer(TActivityOrCompensateContainer object) {
				return createTActivityOrCompensateContainerAdapter();
			}
			@Override
			public Adapter caseTAssign(TAssign object) {
				return createTAssignAdapter();
			}
			@Override
			public Adapter caseTCatch(TCatch object) {
				return createTCatchAdapter();
			}
			@Override
			public Adapter caseTCompensate(TCompensate object) {
				return createTCompensateAdapter();
			}
			@Override
			public Adapter caseTCompensationHandler(TCompensationHandler object) {
				return createTCompensationHandlerAdapter();
			}
			@Override
			public Adapter caseTCopy(TCopy object) {
				return createTCopyAdapter();
			}
			@Override
			public Adapter caseTCorrelation(TCorrelation object) {
				return createTCorrelationAdapter();
			}
			@Override
			public Adapter caseTCorrelations(TCorrelations object) {
				return createTCorrelationsAdapter();
			}
			@Override
			public Adapter caseTCorrelationSet(TCorrelationSet object) {
				return createTCorrelationSetAdapter();
			}
			@Override
			public Adapter caseTCorrelationSets(TCorrelationSets object) {
				return createTCorrelationSetsAdapter();
			}
			@Override
			public Adapter caseTCorrelationsWithPattern(TCorrelationsWithPattern object) {
				return createTCorrelationsWithPatternAdapter();
			}
			@Override
			public Adapter caseTCorrelationWithPattern(TCorrelationWithPattern object) {
				return createTCorrelationWithPatternAdapter();
			}
			@Override
			public Adapter caseTEmpty(TEmpty object) {
				return createTEmptyAdapter();
			}
			@Override
			public Adapter caseTEventHandlers(TEventHandlers object) {
				return createTEventHandlersAdapter();
			}
			@Override
			public Adapter caseTExtensibleElements(TExtensibleElements object) {
				return createTExtensibleElementsAdapter();
			}
			@Override
			public Adapter caseTFaultHandlers(TFaultHandlers object) {
				return createTFaultHandlersAdapter();
			}
			@Override
			public Adapter caseTFlow(TFlow object) {
				return createTFlowAdapter();
			}
			@Override
			public Adapter caseTFrom(TFrom object) {
				return createTFromAdapter();
			}
			@Override
			public Adapter caseTInvoke(TInvoke object) {
				return createTInvokeAdapter();
			}
			@Override
			public Adapter caseTLink(TLink object) {
				return createTLinkAdapter();
			}
			@Override
			public Adapter caseTLinks(TLinks object) {
				return createTLinksAdapter();
			}
			@Override
			public Adapter caseTOnAlarm(TOnAlarm object) {
				return createTOnAlarmAdapter();
			}
			@Override
			public Adapter caseTOnMessage(TOnMessage object) {
				return createTOnMessageAdapter();
			}
			@Override
			public Adapter caseToType(ToType object) {
				return createToTypeAdapter();
			}
			@Override
			public Adapter caseTPartner(TPartner object) {
				return createTPartnerAdapter();
			}
			@Override
			public Adapter caseTPartnerLink(TPartnerLink object) {
				return createTPartnerLinkAdapter();
			}
			@Override
			public Adapter caseTPartnerLinks(TPartnerLinks object) {
				return createTPartnerLinksAdapter();
			}
			@Override
			public Adapter caseTPartners(TPartners object) {
				return createTPartnersAdapter();
			}
			@Override
			public Adapter caseTPick(TPick object) {
				return createTPickAdapter();
			}
			@Override
			public Adapter caseTProcess(TProcess object) {
				return createTProcessAdapter();
			}
			@Override
			public Adapter caseTReceive(TReceive object) {
				return createTReceiveAdapter();
			}
			@Override
			public Adapter caseTReply(TReply object) {
				return createTReplyAdapter();
			}
			@Override
			public Adapter caseTScope(TScope object) {
				return createTScopeAdapter();
			}
			@Override
			public Adapter caseTSequence(TSequence object) {
				return createTSequenceAdapter();
			}
			@Override
			public Adapter caseTSource(TSource object) {
				return createTSourceAdapter();
			}
			@Override
			public Adapter caseTSwitch(TSwitch object) {
				return createTSwitchAdapter();
			}
			@Override
			public Adapter caseTTarget(TTarget object) {
				return createTTargetAdapter();
			}
			@Override
			public Adapter caseTTerminate(TTerminate object) {
				return createTTerminateAdapter();
			}
			@Override
			public Adapter caseTThrow(TThrow object) {
				return createTThrowAdapter();
			}
			@Override
			public Adapter caseTVariable(TVariable object) {
				return createTVariableAdapter();
			}
			@Override
			public Adapter caseTVariables(TVariables object) {
				return createTVariablesAdapter();
			}
			@Override
			public Adapter caseTWait(TWait object) {
				return createTWaitAdapter();
			}
			@Override
			public Adapter caseTWhile(TWhile object) {
				return createTWhileAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.CaseType <em>Case Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.CaseType
	 * @generated
	 */
	public Adapter createCaseTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.PartnerLinkType <em>Partner Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.PartnerLinkType
	 * @generated
	 */
	public Adapter createPartnerLinkTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity <em>TActivity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivity
	 * @generated
	 */
	public Adapter createTActivityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer <em>TActivity Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer
	 * @generated
	 */
	public Adapter createTActivityContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer <em>TActivity Or Compensate Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer
	 * @generated
	 */
	public Adapter createTActivityOrCompensateContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TAssign <em>TAssign</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TAssign
	 * @generated
	 */
	public Adapter createTAssignAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCatch <em>TCatch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCatch
	 * @generated
	 */
	public Adapter createTCatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCompensate <em>TCompensate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCompensate
	 * @generated
	 */
	public Adapter createTCompensateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCompensationHandler <em>TCompensation Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCompensationHandler
	 * @generated
	 */
	public Adapter createTCompensationHandlerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCopy <em>TCopy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCopy
	 * @generated
	 */
	public Adapter createTCopyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation <em>TCorrelation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation
	 * @generated
	 */
	public Adapter createTCorrelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelations <em>TCorrelations</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelations
	 * @generated
	 */
	public Adapter createTCorrelationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet <em>TCorrelation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet
	 * @generated
	 */
	public Adapter createTCorrelationSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSets <em>TCorrelation Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSets
	 * @generated
	 */
	public Adapter createTCorrelationSetsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationsWithPattern <em>TCorrelations With Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationsWithPattern
	 * @generated
	 */
	public Adapter createTCorrelationsWithPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationWithPattern <em>TCorrelation With Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationWithPattern
	 * @generated
	 */
	public Adapter createTCorrelationWithPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty <em>TEmpty</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty
	 * @generated
	 */
	public Adapter createTEmptyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers <em>TEvent Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers
	 * @generated
	 */
	public Adapter createTEventHandlersAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TExtensibleElements <em>TExtensible Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TExtensibleElements
	 * @generated
	 */
	public Adapter createTExtensibleElementsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers <em>TFault Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers
	 * @generated
	 */
	public Adapter createTFaultHandlersAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow <em>TFlow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow
	 * @generated
	 */
	public Adapter createTFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom <em>TFrom</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFrom
	 * @generated
	 */
	public Adapter createTFromAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke <em>TInvoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke
	 * @generated
	 */
	public Adapter createTInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TLink <em>TLink</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TLink
	 * @generated
	 */
	public Adapter createTLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TLinks <em>TLinks</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TLinks
	 * @generated
	 */
	public Adapter createTLinksAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm <em>TOn Alarm</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm
	 * @generated
	 */
	public Adapter createTOnAlarmAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage <em>TOn Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage
	 * @generated
	 */
	public Adapter createTOnMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.ToType <em>To Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ToType
	 * @generated
	 */
	public Adapter createToTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartner <em>TPartner</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartner
	 * @generated
	 */
	public Adapter createTPartnerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink <em>TPartner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink
	 * @generated
	 */
	public Adapter createTPartnerLinkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLinks <em>TPartner Links</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLinks
	 * @generated
	 */
	public Adapter createTPartnerLinksAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartners <em>TPartners</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartners
	 * @generated
	 */
	public Adapter createTPartnersAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPick <em>TPick</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPick
	 * @generated
	 */
	public Adapter createTPickAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess <em>TProcess</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess
	 * @generated
	 */
	public Adapter createTProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReceive <em>TReceive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReceive
	 * @generated
	 */
	public Adapter createTReceiveAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReply <em>TReply</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReply
	 * @generated
	 */
	public Adapter createTReplyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope <em>TScope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope
	 * @generated
	 */
	public Adapter createTScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence <em>TSequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence
	 * @generated
	 */
	public Adapter createTSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSource <em>TSource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSource
	 * @generated
	 */
	public Adapter createTSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch <em>TSwitch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch
	 * @generated
	 */
	public Adapter createTSwitchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TTarget <em>TTarget</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TTarget
	 * @generated
	 */
	public Adapter createTTargetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TTerminate <em>TTerminate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TTerminate
	 * @generated
	 */
	public Adapter createTTerminateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TThrow <em>TThrow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TThrow
	 * @generated
	 */
	public Adapter createTThrowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TVariable <em>TVariable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TVariable
	 * @generated
	 */
	public Adapter createTVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TVariables <em>TVariables</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TVariables
	 * @generated
	 */
	public Adapter createTVariablesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWait <em>TWait</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWait
	 * @generated
	 */
	public Adapter createTWaitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile <em>TWhile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile
	 * @generated
	 */
	public Adapter createTWhileAdapter() {
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

} //ProcessAdapterFactory
