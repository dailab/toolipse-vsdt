package de.dailab.vsdt.trafo.strucbpmn.util;

import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;

public class StrucBpmnElementFactory {

	public static final StrucBpmnFactory strucFac= StrucBpmnFactory.eINSTANCE;
	
	public static BpmnBranch createBranch(FlowObject element, Expression condition, boolean isDefault) {
		BpmnBranch branch= strucFac.createBpmnBranch();
		branch.setElement(element);
		branch.setCondition(condition);
		branch.setDefault(isDefault);
		return branch;
	}
	
	public static BpmnEventHandlerCase createEventHandlerCase(Intermediate intermediate, FlowObject flowObject, BpmnElementToSkip skip, Gateway gateway) {
		BpmnEventHandlerCase ehCase= strucFac.createBpmnEventHandlerCase();
		ehCase.setIntermediate(intermediate);
		ehCase.setCompensationElement(flowObject);
		ehCase.setElementToSkip(skip);
		ehCase.setGateway(gateway);
		return ehCase;
	}
}
