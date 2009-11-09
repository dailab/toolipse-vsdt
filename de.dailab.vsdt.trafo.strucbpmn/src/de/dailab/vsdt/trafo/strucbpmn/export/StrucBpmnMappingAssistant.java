package de.dailab.vsdt.trafo.strucbpmn.export;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;

/**
 * Another class providing some helpful methods that are still independent of the target language but require
 * the Structured BPMN model, e.g. for providing an alternative method for determining whether a node is a starting
 * node when the Sequence Flows have been stripped from the diagram.
 * 
 * @author tkuester
 */
public class StrucBpmnMappingAssistant {
	

	/**
	 * check whether the given flow object is a starting or ending node of the work flow
	 * 
	 * @param flowObject	the flow object to check
	 * @param checkIsEnding	if set, check for ending node, else for starting node
	 * @return				whether the given node is a starting node of the work flow
	 */
	public static boolean isStartingOrEndingNode(FlowObject flowObject, boolean checkIsEnding) {
		EObject container= flowObject.eContainer();
		if (container instanceof Lane) {
			//the flow object is directly contained in the lane and thus is a (the) starting/ending node
			return true;
		}
		if (container instanceof BpmnSequence) {
			BpmnSequence parentSeq= (BpmnSequence) container;
			//check for the position of the node
			if (parentSeq.getElements().indexOf(flowObject) == (checkIsEnding ? parentSeq.getElements().size()-1 : 0)) {
				//it is a starting node if the container is a starting node
				return isStartingOrEndingNode(parentSeq,checkIsEnding);
			} else {
				return false;
			}
		}
		if (container instanceof BpmnEventHandlerCase) {
			BpmnEventHandlerCase eventHandlerCase= (BpmnEventHandlerCase) container;
			if (eventHandlerCase.getCompensationElement() == flowObject && 
					eventHandlerCase.getIntermediate().getTrigger() == TriggerType.COMPENSATION) {
				//compensation activities are not seen as starting or ending nodes
				return false;
			}
		}
		if (container instanceof FlowObject) {
			//the flow object is directly contained in another flow object
			//thus it is a starting node if the container is a starting/ending node
			return isStartingOrEndingNode((FlowObject) container,checkIsEnding);
		}
		//else...
		return false;
	}
	

}
