package de.dailab.vsdt.diagram.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.VsdtPackage;

/**
 * @generated
 */
public class VsdtDomainModelElementTester extends PropertyTester {

	/**
	 * @generated
	 */
	public boolean test(Object receiver, String method, Object[] args,
			Object expectedValue) {
		if (false == receiver instanceof EObject) {
			return false;
		}
		EObject eObject = (EObject) receiver;
		EClass eClass = eObject.eClass();
		if (eClass == VsdtPackage.eINSTANCE.getIdObject()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getBusinessProcessSystem()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getBusinessProcessDiagram()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getAbstractProcess()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getBpmnProcess()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getFlowObjectContainer()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getGraphicalObject()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getNode()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getFlowObject()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getEvent()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getStart()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getIntermediate()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getEnd()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getActivity()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getLoopAttributeSet()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getStandardLoopAttSet()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getMultiLoopAttSet()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getInputSet()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getOutputSet()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getTransaction()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getGateway()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getPool()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getLane()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getArtifact()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getDataObject()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getTextAnnotation()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getGroup()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getConnectingObject()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getSequenceFlow()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getMessageFlow()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getAssociation()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getParticipant()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getMessage()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getImplementation()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getAssignment()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getProperty()) {
			return true;
		}
		if (eClass == VsdtPackage.eINSTANCE.getExpression()) {
			return true;
		}
		return false;
	}

}
