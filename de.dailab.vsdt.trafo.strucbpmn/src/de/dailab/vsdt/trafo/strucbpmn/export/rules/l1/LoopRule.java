package de.dailab.vsdt.trafo.strucbpmn.export.rules.l1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.StrucBpmnElementFactory;

/**
 * Loop Rule
 * 
 * PATTERN: two Gateways connected via a single (possibly complex) FlowObject in both directions, making up a loop.
 * The second gateway has to have a second sequence flow exiting the loop.
 * 
 * EFFECT: the gateways and flowObjects are combined to a BpmnLoopBlock. Sequence flows are redirected or deleted
 */
public class LoopRule extends AbstractVsdtRule {		
	
	public static final int	SEQFLOW11= 0,
							SEQFLOW12= 1,
							SEQFLOW21= 2,
							SEQFLOW22= 3,
							SEQFLOWQUIT= 4,
							FLOWOBJECT1= 5,
							FLOWOBJECT2= 6,
							GATEWAY1= 7,
							GATEWAY2= 8;

	/**
	 * - create loop block
	 * - put everything in the loop block
	 * - delete obsolete sequence flows
	 * - redirect sequence flows  
	 */
	@Override
	protected void excecute(List<EObject> matches){
		SequenceFlow _seqFlow11= 	(SequenceFlow)	matches.get(SEQFLOW11);
		SequenceFlow _seqFlow12= 	(SequenceFlow)	matches.get(SEQFLOW12);
		SequenceFlow _seqFlow21= 	(SequenceFlow)	matches.get(SEQFLOW21);
		SequenceFlow _seqFlow22= 	(SequenceFlow)	matches.get(SEQFLOW22);
		SequenceFlow _seqFlowQuit= 	(SequenceFlow)	matches.get(SEQFLOWQUIT);
		FlowObject _flowObject1=	(FlowObject)	matches.get(FLOWOBJECT1);
		FlowObject _flowObject2=	(FlowObject)	matches.get(FLOWOBJECT2);
		Gateway _gateway1= 			(Gateway)		matches.get(GATEWAY1);
		Gateway _gateway2= 			(Gateway)		matches.get(GATEWAY2);
		
		// create pseudo-branches encapsulating flow objects, conditions and gates
		BpmnBranch firstBranch= StrucBpmnElementFactory.createBranch(
				_flowObject1, 
				_seqFlow11.getConditionExpression(), 
				false);
		
		BpmnBranch secondBranch= StrucBpmnElementFactory.createBranch(
				_flowObject2, 
				_seqFlow21.getConditionExpression(), 
				_seqFlow21.getConditionType() == ConditionType.DEFAULT);
		
		BpmnBranch exitBranch= StrucBpmnElementFactory.createBranch(
				null, 
				_seqFlowQuit.getConditionExpression(), 
				_seqFlowQuit.getConditionType() == ConditionType.DEFAULT);
		
		//create loop block
		BpmnLoopBlock loop= StrucBpmnFactory.eINSTANCE.createBpmnLoopBlock();
		FlowObjectContainer container= _gateway1.getParent();
		container.getContainedFlowObjects().add(loop);
		loop.setFirstGateway(_gateway1);
		loop.setSecondGateway(_gateway2);
		loop.setFirstBranch(firstBranch);
		loop.setSecondBranch(secondBranch);
		loop.setExitBranch(exitBranch);
		
		//delete obsolete sequence flows
		//this is done first to facilitate the redirecting of the other sequence flows
		List<SequenceFlow> obsoleteSeqFlows= new ArrayList<SequenceFlow>();
		obsoleteSeqFlows.add(_seqFlow11);
		obsoleteSeqFlows.add(_seqFlow12);
		obsoleteSeqFlows.add(_seqFlow21);
		obsoleteSeqFlows.add(_seqFlow22);
		for (SequenceFlow sf : obsoleteSeqFlows) {
			deleteSequenceFlow(sf);
		}
		
		//redirect sequence flows
		loop.getIncomingSeq().addAll(_gateway1.getIncomingSeq());
		loop.getOutgoingSeq().addAll(_gateway2.getOutgoingSeq());
	}

	@Override
	public void initLHSVariables() {
	
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOW11 
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOW12 
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOW21 
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOW22
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOWQUIT
		addVariable(lhsVariables, bpmn.getFlowObject());	// SEQ1
		addVariable(lhsVariables, bpmn.getFlowObject());	// SEQ2
		addVariable(lhsVariables, bpmn.getGateway());		// MERGE
		addVariable(lhsVariables, bpmn.getGateway());		// FORK
		
		//queries
		addInjectivityConstraint(lhsVariables,SEQFLOW21,SEQFLOWQUIT);
		addInjectivityConstraint(lhsVariables,GATEWAY1,GATEWAY2);
		addInjectivityConstraint(lhsVariables,FLOWOBJECT1,FLOWOBJECT2);
		
		addBranchTargetQueries(lhsVariables, GATEWAY1, SEQFLOW11, FLOWOBJECT1, SEQFLOW12, GATEWAY2);
		addBranchTargetQueries(lhsVariables, GATEWAY2, SEQFLOW21, FLOWOBJECT2, SEQFLOW22, GATEWAY1);
		
		addReferenceConstraint(lhsVariables,SEQFLOWQUIT,GATEWAY2,bpmn.getSequenceFlow_Source());
		
		//reduce domains
		for (Iterator<EObject> iter = lhsVariables.get(GATEWAY1).getDomain().iterator(); iter.hasNext();) {
			boolean ok= true;
			Gateway gateway = (Gateway) iter.next();
			
			// filter gateway type?
			
			//two incoming sequences
			ok &= gateway.getIncomingSeq().size() == 2;
			
			if (!ok) {
				iter.remove();
			}
		}	
		//reduce fork
		for (Iterator<EObject> iter = lhsVariables.get(GATEWAY2).getDomain().iterator(); iter.hasNext();) {
			boolean ok= true;
			Gateway gateway = (Gateway) iter.next();
			
			//looping gateway must be of type XOR-Data
			//this check is omitted, since in this approach every implementer can decide for himself
			//whether to map the created strucBpmn loop structure to a loop or not in the visitor
//				ok&= gateway.getGatewayType() == GatewayType.XOR_DATA_LITERAL;
			
			//two outgoing sequences
			ok &= gateway.getOutgoingSeq().size() == 2;
			
			if (!ok) {
				iter.remove();
			}
		}
	}
	
	@Override
	protected void initNACVariables() {
	}
	
}