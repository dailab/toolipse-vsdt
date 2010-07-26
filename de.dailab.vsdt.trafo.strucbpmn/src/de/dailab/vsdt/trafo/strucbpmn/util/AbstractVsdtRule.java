package de.dailab.vsdt.trafo.strucbpmn.util;

import java.util.List;

import de.dailab.vsdt.Association;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.trafo.base.TransformationRule;
import de.dailab.vsdt.trafo.base.Variable;
import de.dailab.vsdt.trafo.base.util.Util;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage;


/**
 * This class extends the original AbstractRule class with a few useful methods,
 * e.g. for correctly removing some types of objects 
 * 
 * @author kuester
 */
public abstract class AbstractVsdtRule extends TransformationRule {
	
	/** suffix used for gateway automatically split in two */
	public static final String SUFFIX_SPLIT = "__SPLIT__";
	
	/** suffix used for an automatically inserted forking gateway */
	public static final String SUFFIX_FORK= "__FORK__";
	
	/** suffix used for an automatically inserted merging gateway */
	public static final String SUFFIX_MERGE= "__MERGE__";

	/** suffix used for a branch */
	public static final String SUFFIX_BRANCH = "__BRANCH__";
	
	/** name for a gateway forking the flows to multiple starting points */
	public static final String INITIAL_GATEWAY= "__INITIAL_GATEWAY__";

	/** name used for a gateway merging the flows from multiple end points */
	public static final String FINAL_GATEWAY= "__FINAL_GATEWAY__";
	
	/** name for the empty activity. later these activities can be removed. */
	public final static String EMPTY_NAME= "__DO_NOTHING__";

	protected VsdtPackage bpmn= VsdtPackage.eINSTANCE;

	protected StrucBpmnPackage struc= StrucBpmnPackage.eINSTANCE;

	/**
	 * Remove SequenceFlow from the model.
	 * 
	 * @param seqFlow	Some SequenceFlow to be removed
	 */
	public static void deleteSequenceFlow(SequenceFlow seqFlow) {
		if (seqFlow != null) {
			seqFlow.setSource(null);
			seqFlow.setTarget(null);
			Util.deleteFromOwner(seqFlow);
		}
	}
	
	/**
	 * Remove Association from the model.
	 * 
	 * @param seqFlow	Some Association to be removed
	 */
	public static void deleteAssociation(Association association) {
		if (association != null) {
			association.setSource(null);
			association.setTarget(null);
			Util.deleteFromOwner(association);
		}
	}

	/**
	 * Add Target Constraint for Sequence Flow
	 * 
	 * @param variables		variables set
	 * @param seqFlow		number of variable for the sequence flow
	 * @param source		number of variable for the sequence flow's source
	 * @param target		number of variable for the sequence flow's target
	 */
	protected void addSeqFlowTargetQueries(List<Variable> variables, int seqFlow, int source, int target) {
		addReferenceConstraint(variables, seqFlow, source, bpmn.getSequenceFlow_Source());
		addReferenceConstraint(variables, seqFlow, target, bpmn.getSequenceFlow_Target());
	}
	
	/**
	 * Add Target Constraint for a branch
	 * 
	 * @param variables		variables set
	 * @param source		number of variable for the source object
	 * @param seqFlow1		number of variable for the incoming sequence flow
	 * @param intermediate	number of variable for the branch's body
	 * @param seqFlow2		number of variable for the outgoing sequence flow
	 * @param target		number of variable for the target object
	 */
	protected void addBranchTargetQueries(List<Variable> variables, int source, int seqFlow1, int intermediate, int seqFlow2, int target) {
		addSeqFlowTargetQueries(variables, seqFlow1, source, intermediate);
		addSeqFlowTargetQueries(variables, seqFlow2, intermediate, target);
	}
}
