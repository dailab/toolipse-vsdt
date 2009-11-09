package de.dailab.vsdt.trafo.strucbpmn.util;

import java.util.List;

import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.base.Variable;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage;

/**
 * This class extends the AbstractWrapper for rule patterns and
 * extends it with some additional methods
 * 
 * @author kuester
 */
public abstract class AbstractVsdtWrapper extends AbstractWrapper {
	
	protected VsdtPackage bpmn= VsdtPackage.eINSTANCE;
	protected StrucBpmnPackage struc= StrucBpmnPackage.eINSTANCE;
	
	protected void addSeqFlowTargetQueries(List<Variable> variables, int seqFlow, int source, int target) {
		addTargetQuery(variables, seqFlow, source, bpmn.getSequenceFlow_Source());
		addTargetQuery(variables, seqFlow, target, bpmn.getSequenceFlow_Target());
	}
	
	protected void addBranchTargetQueries(List<Variable> variables, int source, int seqFlow1, int intermediate, int seqFlow2, int target) {
		addSeqFlowTargetQueries(variables, seqFlow1, source, intermediate);
		addSeqFlowTargetQueries(variables, seqFlow2, intermediate, target);
	}

}
