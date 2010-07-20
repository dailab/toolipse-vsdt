package de.dailab.vsdt.trafo.strucbpmn.imprt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.Association;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.logger.TrafoLog;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;
import de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression;

/**
 * Import a StrucBPMN model file. This can be used in other Import wizards, too,
 * especially those which also rely on the BPMN2StrucBPMN transformation in the
 * export. The main purpose of this import is to re-create the several Sequence Flows.
 * Similar to the separate Structure Mapping, this class can be used together with 
 * another transformation so the other transformation does not have to care about the
 * partially tricky (re-)mapping of control flow. However, it will not always be 
 * necessary to use this class: While it will be useful for importing blocks and loops,
 * it might sometimes be hard to recognize and recreate the event handlers as they were. 
 * Instead it will be more practicable to map event handlers straightforward from what
 * they were mapped to in the export. 
 * 
 * @author kuester
 */
public class StrucBpmn2BpmnStructureMapping extends MappingStage {

	/** the working model */
	private BusinessProcessSystem bps;
	
	/** currently processes Business Process Diagram */
	private BusinessProcessDiagram currentBPD;
	
	@Override
	public void initialize() {
		bps= null;
	}
	
	@Override
	protected boolean internalApply() {
		// find StrucBPMN model of type Business Process Diagram.
		if (wrapper.getSourceModel() instanceof BusinessProcessSystem) {
			bps = (BusinessProcessSystem) wrapper.getSourceModel();
			wrapper.getTargetModels().add(bps);
		} else {
			for (Object targetModel : wrapper.getTargetModels()) {
				if (targetModel instanceof BusinessProcessSystem) {
					bps = (BusinessProcessSystem) targetModel;
					break;
				}
			}
		}
		if (bps != null) {
			try {
				for (BusinessProcessDiagram bpd : bps.getBusinessProcesses()) {
					currentBPD= bpd;
					visitChildren(bpd);
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/*
	 * VISITOR LOGIC
	 */

	/**
	 * First translate the element itself,
	 * then translate children and integrate them into the new parent element.
	 * 
	 * @param root		Current element to be processed
	 * @return			Success?
	 * @throws Exception
	 */
	protected boolean visitChildren(EObject root) throws Exception {
		if (root == null) {
			return true;
		}
		List<EObject> children= root.eContents();
		// delegate to specialized methods
		if (root instanceof BpmnSequence) {
			children= visitSequence((BpmnSequence) root);
		}
		if (root instanceof BpmnBlock) {
			children= visitBlock((BpmnBlock) root);
		}
		if (root instanceof BpmnLoopBlock) {
			children= visitLoop((BpmnLoopBlock) root);
		}
		if (root instanceof BpmnEventHandlerBlock) {
			children= visitEHBlock((BpmnEventHandlerBlock) root);
		}
		if (root instanceof BpmnElementToSkip) {
			children= visitElementToSkip((BpmnElementToSkip) root);
		}
//		if (root instanceof BpmnDerivedProcess) {
//	    	// not yet supported in export
//			children= visitDerivedProcess((BpmnDerivedProcess) root);
//		}
		// now pass through the children, so they can be integrated into their new parent
		if (children != null) {
			boolean ok= true;
			for (EObject child : children) {
				ok&= visitChildren(child);
			}
			return ok;
		} else {
			return false;
		}
	}
	
	/**
	 * Create sequence flows in between consecutive flow objects.
	 * 
	 * @param sequence	StrucBPMN sequence element
	 * @return			Elements of the sequence
	 * @throws Exception
	 */
	protected List<EObject> visitSequence(BpmnSequence sequence) throws Exception {
		TrafoLog.trace("Visiting Sequence " + sequence.toString());
		List<FlowObject> children= new ArrayList<FlowObject>();
		FlowObject first= null;
		FlowObject last= null;
		
		// iterate over elements and create sequence flows
		for (FlowObject current : sequence.getElements()) {
			if (first == null) {
				first= current;
			}
			if (last != null) {
				// create Sequence Flow in between
				addSequenceFlow(last, current);
			}
			last= current;
			children.add(current);
		}
		
		substituteBlock(sequence, first, last, children);
		return new ArrayList<EObject>(children);
	}

	/**
	 * Create sequence flows in between forking and merging gateways and branches.
	 * Set sequence flows' conditions and gates.
	 * 
	 * @param block		StrucBPMN block element
	 * @return			Elements of the branches of the block
	 * @throws Exception
	 */
	protected List<EObject> visitBlock(BpmnBlock block) throws Exception {
		TrafoLog.trace("Visiting Block " + block.toString());
		List<FlowObject> children= new ArrayList<FlowObject>();
		Gateway first= block.getFirstGateway();
		Gateway last= block.getSecondGateway();
		
		// iterate over branches and create sequence flows
		for (BpmnBranch branch : block.getElements()) {
			integrateBranch(branch, first, last);
			if (branch.getElement() != null) {
				children.add(branch.getElement());
			}
		}
		
		substituteBlock(block, first, last, children);
		return new ArrayList<EObject>(children);
	}

	/**
	 * Create sequence flows from the first gateway over the do-until branch to the second
	 * gateway and back over the while-do branch to the first gateway. Sets the condition
	 * and the gate of the exiting sequence flow.
	 * 
	 * @param loop		StrucBPMN loop element
	 * @return			The loop's do-until and while-do branches
	 * @throws Exception
	 */
	protected List<EObject> visitLoop(BpmnLoopBlock loop) throws Exception {
		TrafoLog.trace("Visiting Loop " + loop.toString());
		List<FlowObject> children= new ArrayList<FlowObject>();
		Gateway g1= loop.getFirstGateway();
		Gateway g2= loop.getSecondGateway();
		
		// branch 1 ('do-until')
		BpmnBranch branch1= loop.getFirstBranch();
		integrateBranch(branch1, g1, g2);
		if (branch1 != null && branch1.getElement() != null) {
			children.add(branch1.getElement());
		}
		
		// branch 2 ('while-do')
		BpmnBranch branch2= loop.getSecondBranch();
		integrateBranch(branch2, g2, g1);
		if (branch2 != null && branch2.getElement() != null) {
			children.add(branch2.getElement());
		}
		
		// exit flow's condition and gate
		if (loop.getExitBranch() != null && loop.getOutgoingSeq().size() == 1) {
			SequenceFlow exitFlow= loop.getOutgoingSeq().get(0);
			setCondition(exitFlow, loop.getExitBranch().getCondition(), loop.getExitBranch().isDefault());
		}
		
		substituteBlock(loop, g1, g2, children);
		return new ArrayList<EObject>(children);
	}
	
	/**
	 * For each event handler case, the intermediate event is re-attached to the activity.
	 * Creates sequence flows connecting the compensation element to the intermediate 
	 * and to the gateway, if any. In case of a compensate intermediate event, an association 
	 * is created instead of the sequence flow.
	 * NOTE: The intermediate does not require any further processing, just like the gateway
	 * in the case of loops and blocks. The element-to-skip, if any, is processed separately,
	 * as it is not a child of this element.
	 * 
	 * @param ehBlock	StrucBPMN event handler block
	 * @return			Activity and several compensation elements
	 * @throws Exception
	 */
	protected List<EObject> visitEHBlock(BpmnEventHandlerBlock ehBlock) throws Exception {

		/*
		 * TODO Join non-compensating EHCase directly after activity, 
		 * 		if there is no joining gateway
		 */
		
		TrafoLog.trace("Visiting EH-Block " + ehBlock.toString());
		List<FlowObject> children= new ArrayList<FlowObject>();

		Activity activity= ehBlock.getActivity();
		children.add(activity);

		// iterate over event handler cases, attach intermediate and create sequence flows
		for (BpmnEventHandlerCase ehCase : ehBlock.getEventHandlerCases()) {
			Intermediate intermediate= ehCase.getIntermediate();
			intermediate.setAttachedTo(activity);
			if (intermediate.getTrigger() == TriggerType.COMPENSATION) {
				Association association= VsdtFactory.eINSTANCE.createAssociation();
				association.setParentDiagram(currentBPD);
				association.setSource(intermediate);
				association.setTarget(ehCase.getCompensationElement());
			} else {
				addSequenceFlow(intermediate, ehCase.getCompensationElement());
			}
			if (ehCase.getElementToSkip() != null && ehCase.getGateway() != null) {
				addSequenceFlow(ehCase.getCompensationElement(), ehCase.getGateway());
			}
			children.add(ehCase.getCompensationElement());
		}
		
		/*
		 * TODO
		 * if necessary, create gateway after the activity, which will be the last element.
		 */
		
		substituteBlock(ehBlock, activity, activity, children);
		return new ArrayList<EObject>(children);
	}
	
	/**
	 * This method does nothing special, just extracts the actual element-to-skip
	 * from its wrapper. The element-to-skip and the gateway are then handled
	 * like any other element in the visitSequence method.
	 * 
	 * @param skip		StrucBPMN wrapper for event handler element-to-skip
	 * @return			The wrapped element-to-skip
	 * @throws Exception
	 */
	protected List<EObject> visitElementToSkip(BpmnElementToSkip skip) throws Exception {
		TrafoLog.trace("Visiting Element-to-Skip " + skip.toString());
		List<FlowObject> children= new ArrayList<FlowObject>();
		
		FlowObject child= skip.getElement();
		children.add(skip.getElement());
		
		substituteBlock(skip, child, child, children);
		return new ArrayList<EObject>(children);
	}

	/*
	 * HELPER METHODS
	 */
	
	/**
	 * Removes the old block structure from its parent and reconnects its incoming 
	 * and outgoing sequence flows to the given new first and last elements.
	 * Further, the given child elements (to be collected beforehand) are inserted
	 * in the block structure's former parent element. 
	 * 
	 * @param oldBlock		Old block structure, e.g. a sequence
	 * @param newFirst		Will be target to the block's incoming seqFlows
	 * @param newLast		Will be source of the block's outgoing seqFlows
	 * @param children		The old block's children, which are put into its former container
	 */
	private void substituteBlock(FlowObject oldBlock, FlowObject newFirst, FlowObject newLast, List<FlowObject> children) {
		List<FlowObject> contained= oldBlock.getParent().getContainedFlowObjects();
		contained.remove(oldBlock);
		for (FlowObject child : children) {
			if (child != null) {
				contained.add(child);
			}
		}
		if (newFirst != null) {
			contained.add(newFirst);	
			newFirst.getIncomingSeq().addAll(oldBlock.getIncomingSeq());
		}
		if (newLast != null) {
			contained.add(newLast);	
			newLast.getOutgoingSeq().addAll(oldBlock.getOutgoingSeq());
		}
	}

	/**
	 * This method takes a Branch and two gateways and draws Sequence Flows in between them.
	 * Additionally, in case the branch is null or does not contain an actual element,
	 * the gateways are directly connected with a sequence flow.
	 * 
	 * @param branch	Some BPMN-Branch
	 * @param g1		The Gateway forking the Branch
	 * @param g2		The Gateway joining the Branch
	 */
	private void integrateBranch(BpmnBranch branch, Gateway g1, Gateway g2) {
		if (branch != null && branch.getElement() != null) {
			addSequenceFlow(g1, branch.getElement(), branch);
			addSequenceFlow(branch.getElement(), g2);
		} else {
			addSequenceFlow(g1, g2, branch);
		}
	}
	
	/**
	 * Create new Sequence Flow from source to target and add it to the BPD. In case
	 * the source is a gateway with a single gate, this gate is associated to the 
	 * sequence flow, too.
	 * 
	 * @param source	Source for sequence flow
	 * @param target	Target for sequence flow
	 * @return			Newly created sequence flow
	 */
	private SequenceFlow addSequenceFlow(FlowObject source, FlowObject target) {
		SequenceFlow seqFlow= VsdtFactory.eINSTANCE.createSequenceFlow();
		seqFlow.setParentDiagram(currentBPD);
		seqFlow.setSource(source);
		seqFlow.setTarget(target);
		return seqFlow;
	}
	
	/**
	 * Create new sequence flow from source to target, add it to the BPD
	 * and set its conditions and gate according to the given branch.
	 * 
	 * @param source	Source for sequence flow
	 * @param target	Target for sequence flow
	 * @param branch	Branch, providing conditions and gate
	 * @return			Newly created sequence flow
	 */
	private SequenceFlow addSequenceFlow(FlowObject source, FlowObject target, BpmnBranch branch) {
		SequenceFlow seqFlow= addSequenceFlow(source, target);
		if (branch != null) {
			setCondition(seqFlow, branch.getCondition(), branch.isDefault());
		}
		return seqFlow;
	}

	/**
	 * Sets the condition expression and type of the sequence flow according to the given values.
	 * 
	 * @param sequenceFlow	Sequence flow to change
	 * @param expression	Condition expression, or null, if no condition
	 * @param isDefault		Default?
	 */
	private void setCondition(SequenceFlow sequenceFlow, Expression expression, boolean isDefault) {
		if (expression != null) {
			sequenceFlow.setConditionExpression(normaliseExpression(expression));
			sequenceFlow.setConditionType(ConditionType.EXPRESSION);
		}
		if (isDefault) {
			sequenceFlow.setConditionType(ConditionType.DEFAULT);
		}
	}
	
	/**
	 * If the given expression is a disjunctive expression ("A or (B and C) or ..."),
	 * the several parts are connected using a fixed disjunction symbol and returned
	 * in form of a new expression. In case of a simple expression, the expression itself
	 * is returned.
	 * Actually, this method is not needed, as no disjunctive expressions will be created
	 * when importing e.g. from BPEL.
	 */
	private Expression normaliseExpression(Expression expression) {
		final String DISJUNCTION= " | ";
		
		if (expression instanceof DisjunctiveExpression) {
			DisjunctiveExpression disjunctive = (DisjunctiveExpression) expression;
			Expression exp = VsdtFactory.eINSTANCE.createExpression();
			StringBuffer buff= new StringBuffer();
			for (Iterator<String> i= disjunctive.getExpressions().iterator(); i.hasNext();) {
				buff.append(i.next());
				if (i.hasNext()) {
					buff.append(DISJUNCTION);
				}
			}
			exp.setExpression(buff.toString());
			return exp;
		} else {
			return expression;
		}
	}

}
