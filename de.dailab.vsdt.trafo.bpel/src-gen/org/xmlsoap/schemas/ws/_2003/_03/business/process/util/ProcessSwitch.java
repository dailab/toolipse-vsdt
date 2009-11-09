/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage
 * @generated
 */
public class ProcessSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ProcessPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSwitch() {
		if (modelPackage == null) {
			modelPackage = ProcessPackage.eINSTANCE;
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
			case ProcessPackage.CASE_TYPE: {
				CaseType caseType = (CaseType)theEObject;
				T result = caseCaseType(caseType);
				if (result == null) result = caseTActivityContainer(caseType);
				if (result == null) result = caseTExtensibleElements(caseType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.PARTNER_LINK_TYPE: {
				PartnerLinkType partnerLinkType = (PartnerLinkType)theEObject;
				T result = casePartnerLinkType(partnerLinkType);
				if (result == null) result = caseTExtensibleElements(partnerLinkType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TACTIVITY: {
				TActivity tActivity = (TActivity)theEObject;
				T result = caseTActivity(tActivity);
				if (result == null) result = caseTExtensibleElements(tActivity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TACTIVITY_CONTAINER: {
				TActivityContainer tActivityContainer = (TActivityContainer)theEObject;
				T result = caseTActivityContainer(tActivityContainer);
				if (result == null) result = caseTExtensibleElements(tActivityContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TACTIVITY_OR_COMPENSATE_CONTAINER: {
				TActivityOrCompensateContainer tActivityOrCompensateContainer = (TActivityOrCompensateContainer)theEObject;
				T result = caseTActivityOrCompensateContainer(tActivityOrCompensateContainer);
				if (result == null) result = caseTExtensibleElements(tActivityOrCompensateContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TASSIGN: {
				TAssign tAssign = (TAssign)theEObject;
				T result = caseTAssign(tAssign);
				if (result == null) result = caseTActivity(tAssign);
				if (result == null) result = caseTExtensibleElements(tAssign);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TCATCH: {
				TCatch tCatch = (TCatch)theEObject;
				T result = caseTCatch(tCatch);
				if (result == null) result = caseTActivityOrCompensateContainer(tCatch);
				if (result == null) result = caseTExtensibleElements(tCatch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TCOMPENSATE: {
				TCompensate tCompensate = (TCompensate)theEObject;
				T result = caseTCompensate(tCompensate);
				if (result == null) result = caseTActivity(tCompensate);
				if (result == null) result = caseTExtensibleElements(tCompensate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TCOMPENSATION_HANDLER: {
				TCompensationHandler tCompensationHandler = (TCompensationHandler)theEObject;
				T result = caseTCompensationHandler(tCompensationHandler);
				if (result == null) result = caseTActivityOrCompensateContainer(tCompensationHandler);
				if (result == null) result = caseTExtensibleElements(tCompensationHandler);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TCOPY: {
				TCopy tCopy = (TCopy)theEObject;
				T result = caseTCopy(tCopy);
				if (result == null) result = caseTExtensibleElements(tCopy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TCORRELATION: {
				TCorrelation tCorrelation = (TCorrelation)theEObject;
				T result = caseTCorrelation(tCorrelation);
				if (result == null) result = caseTExtensibleElements(tCorrelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TCORRELATIONS: {
				TCorrelations tCorrelations = (TCorrelations)theEObject;
				T result = caseTCorrelations(tCorrelations);
				if (result == null) result = caseTExtensibleElements(tCorrelations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TCORRELATION_SET: {
				TCorrelationSet tCorrelationSet = (TCorrelationSet)theEObject;
				T result = caseTCorrelationSet(tCorrelationSet);
				if (result == null) result = caseTExtensibleElements(tCorrelationSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TCORRELATION_SETS: {
				TCorrelationSets tCorrelationSets = (TCorrelationSets)theEObject;
				T result = caseTCorrelationSets(tCorrelationSets);
				if (result == null) result = caseTExtensibleElements(tCorrelationSets);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TCORRELATIONS_WITH_PATTERN: {
				TCorrelationsWithPattern tCorrelationsWithPattern = (TCorrelationsWithPattern)theEObject;
				T result = caseTCorrelationsWithPattern(tCorrelationsWithPattern);
				if (result == null) result = caseTExtensibleElements(tCorrelationsWithPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TCORRELATION_WITH_PATTERN: {
				TCorrelationWithPattern tCorrelationWithPattern = (TCorrelationWithPattern)theEObject;
				T result = caseTCorrelationWithPattern(tCorrelationWithPattern);
				if (result == null) result = caseTCorrelation(tCorrelationWithPattern);
				if (result == null) result = caseTExtensibleElements(tCorrelationWithPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TEMPTY: {
				TEmpty tEmpty = (TEmpty)theEObject;
				T result = caseTEmpty(tEmpty);
				if (result == null) result = caseTActivity(tEmpty);
				if (result == null) result = caseTExtensibleElements(tEmpty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TEVENT_HANDLERS: {
				TEventHandlers tEventHandlers = (TEventHandlers)theEObject;
				T result = caseTEventHandlers(tEventHandlers);
				if (result == null) result = caseTExtensibleElements(tEventHandlers);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TEXTENSIBLE_ELEMENTS: {
				TExtensibleElements tExtensibleElements = (TExtensibleElements)theEObject;
				T result = caseTExtensibleElements(tExtensibleElements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TFAULT_HANDLERS: {
				TFaultHandlers tFaultHandlers = (TFaultHandlers)theEObject;
				T result = caseTFaultHandlers(tFaultHandlers);
				if (result == null) result = caseTExtensibleElements(tFaultHandlers);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TFLOW: {
				TFlow tFlow = (TFlow)theEObject;
				T result = caseTFlow(tFlow);
				if (result == null) result = caseTActivity(tFlow);
				if (result == null) result = caseTExtensibleElements(tFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TFROM: {
				TFrom tFrom = (TFrom)theEObject;
				T result = caseTFrom(tFrom);
				if (result == null) result = caseTExtensibleElements(tFrom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TINVOKE: {
				TInvoke tInvoke = (TInvoke)theEObject;
				T result = caseTInvoke(tInvoke);
				if (result == null) result = caseTActivity(tInvoke);
				if (result == null) result = caseTExtensibleElements(tInvoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TLINK: {
				TLink tLink = (TLink)theEObject;
				T result = caseTLink(tLink);
				if (result == null) result = caseTExtensibleElements(tLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TLINKS: {
				TLinks tLinks = (TLinks)theEObject;
				T result = caseTLinks(tLinks);
				if (result == null) result = caseTExtensibleElements(tLinks);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TON_ALARM: {
				TOnAlarm tOnAlarm = (TOnAlarm)theEObject;
				T result = caseTOnAlarm(tOnAlarm);
				if (result == null) result = caseTActivityContainer(tOnAlarm);
				if (result == null) result = caseTExtensibleElements(tOnAlarm);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TON_MESSAGE: {
				TOnMessage tOnMessage = (TOnMessage)theEObject;
				T result = caseTOnMessage(tOnMessage);
				if (result == null) result = caseTExtensibleElements(tOnMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TO_TYPE: {
				ToType toType = (ToType)theEObject;
				T result = caseToType(toType);
				if (result == null) result = caseTFrom(toType);
				if (result == null) result = caseTExtensibleElements(toType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TPARTNER: {
				TPartner tPartner = (TPartner)theEObject;
				T result = caseTPartner(tPartner);
				if (result == null) result = caseTExtensibleElements(tPartner);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TPARTNER_LINK: {
				TPartnerLink tPartnerLink = (TPartnerLink)theEObject;
				T result = caseTPartnerLink(tPartnerLink);
				if (result == null) result = caseTExtensibleElements(tPartnerLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TPARTNER_LINKS: {
				TPartnerLinks tPartnerLinks = (TPartnerLinks)theEObject;
				T result = caseTPartnerLinks(tPartnerLinks);
				if (result == null) result = caseTExtensibleElements(tPartnerLinks);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TPARTNERS: {
				TPartners tPartners = (TPartners)theEObject;
				T result = caseTPartners(tPartners);
				if (result == null) result = caseTExtensibleElements(tPartners);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TPICK: {
				TPick tPick = (TPick)theEObject;
				T result = caseTPick(tPick);
				if (result == null) result = caseTActivity(tPick);
				if (result == null) result = caseTExtensibleElements(tPick);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TPROCESS: {
				TProcess tProcess = (TProcess)theEObject;
				T result = caseTProcess(tProcess);
				if (result == null) result = caseTExtensibleElements(tProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TRECEIVE: {
				TReceive tReceive = (TReceive)theEObject;
				T result = caseTReceive(tReceive);
				if (result == null) result = caseTActivity(tReceive);
				if (result == null) result = caseTExtensibleElements(tReceive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TREPLY: {
				TReply tReply = (TReply)theEObject;
				T result = caseTReply(tReply);
				if (result == null) result = caseTActivity(tReply);
				if (result == null) result = caseTExtensibleElements(tReply);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TSCOPE: {
				TScope tScope = (TScope)theEObject;
				T result = caseTScope(tScope);
				if (result == null) result = caseTActivity(tScope);
				if (result == null) result = caseTExtensibleElements(tScope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TSEQUENCE: {
				TSequence tSequence = (TSequence)theEObject;
				T result = caseTSequence(tSequence);
				if (result == null) result = caseTActivity(tSequence);
				if (result == null) result = caseTExtensibleElements(tSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TSOURCE: {
				TSource tSource = (TSource)theEObject;
				T result = caseTSource(tSource);
				if (result == null) result = caseTExtensibleElements(tSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TSWITCH: {
				TSwitch tSwitch = (TSwitch)theEObject;
				T result = caseTSwitch(tSwitch);
				if (result == null) result = caseTActivity(tSwitch);
				if (result == null) result = caseTExtensibleElements(tSwitch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TTARGET: {
				TTarget tTarget = (TTarget)theEObject;
				T result = caseTTarget(tTarget);
				if (result == null) result = caseTExtensibleElements(tTarget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TTERMINATE: {
				TTerminate tTerminate = (TTerminate)theEObject;
				T result = caseTTerminate(tTerminate);
				if (result == null) result = caseTActivity(tTerminate);
				if (result == null) result = caseTExtensibleElements(tTerminate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TTHROW: {
				TThrow tThrow = (TThrow)theEObject;
				T result = caseTThrow(tThrow);
				if (result == null) result = caseTActivity(tThrow);
				if (result == null) result = caseTExtensibleElements(tThrow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TVARIABLE: {
				TVariable tVariable = (TVariable)theEObject;
				T result = caseTVariable(tVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TVARIABLES: {
				TVariables tVariables = (TVariables)theEObject;
				T result = caseTVariables(tVariables);
				if (result == null) result = caseTExtensibleElements(tVariables);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TWAIT: {
				TWait tWait = (TWait)theEObject;
				T result = caseTWait(tWait);
				if (result == null) result = caseTActivity(tWait);
				if (result == null) result = caseTExtensibleElements(tWait);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ProcessPackage.TWHILE: {
				TWhile tWhile = (TWhile)theEObject;
				T result = caseTWhile(tWhile);
				if (result == null) result = caseTActivity(tWhile);
				if (result == null) result = caseTExtensibleElements(tWhile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseType(CaseType object) {
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>Partner Link Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partner Link Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePartnerLinkType(PartnerLinkType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TActivity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TActivity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTActivity(TActivity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TActivity Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TActivity Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTActivityContainer(TActivityContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TActivity Or Compensate Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TActivity Or Compensate Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTActivityOrCompensateContainer(TActivityOrCompensateContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TAssign</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TAssign</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTAssign(TAssign object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCatch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCatch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCatch(TCatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCompensate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCompensate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCompensate(TCompensate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCompensation Handler</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCompensation Handler</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCompensationHandler(TCompensationHandler object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCopy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCopy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCopy(TCopy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCorrelation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCorrelation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCorrelation(TCorrelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCorrelations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCorrelations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCorrelations(TCorrelations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCorrelation Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCorrelation Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCorrelationSet(TCorrelationSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCorrelation Sets</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCorrelation Sets</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCorrelationSets(TCorrelationSets object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCorrelations With Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCorrelations With Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCorrelationsWithPattern(TCorrelationsWithPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TCorrelation With Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TCorrelation With Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTCorrelationWithPattern(TCorrelationWithPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TEmpty</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TEmpty</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTEmpty(TEmpty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TEvent Handlers</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TEvent Handlers</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTEventHandlers(TEventHandlers object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TExtensible Elements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TExtensible Elements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTExtensibleElements(TExtensibleElements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TFault Handlers</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TFault Handlers</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTFaultHandlers(TFaultHandlers object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TFlow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TFlow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTFlow(TFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TFrom</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TFrom</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTFrom(TFrom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TInvoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TInvoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTInvoke(TInvoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TLink</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TLink</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTLink(TLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TLinks</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TLinks</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTLinks(TLinks object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TOn Alarm</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TOn Alarm</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTOnAlarm(TOnAlarm object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TOn Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TOn Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTOnMessage(TOnMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>To Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToType(ToType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TPartner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TPartner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTPartner(TPartner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TPartner Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TPartner Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTPartnerLink(TPartnerLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TPartner Links</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TPartner Links</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTPartnerLinks(TPartnerLinks object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TPartners</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TPartners</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTPartners(TPartners object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TPick</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TPick</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTPick(TPick object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TProcess</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TProcess</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTProcess(TProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TReceive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TReceive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTReceive(TReceive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TReply</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TReply</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTReply(TReply object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TScope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TScope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTScope(TScope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TSequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TSequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTSequence(TSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TSource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TSource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTSource(TSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TSwitch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TSwitch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTSwitch(TSwitch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TTarget</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TTarget</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTTarget(TTarget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TTerminate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TTerminate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTTerminate(TTerminate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TThrow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TThrow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTThrow(TThrow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TVariable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TVariable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTVariable(TVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TVariables</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TVariables</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTVariables(TVariables object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TWait</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TWait</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTWait(TWait object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>TWhile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>TWhile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTWhile(TWhile object) {
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

} //ProcessSwitch
