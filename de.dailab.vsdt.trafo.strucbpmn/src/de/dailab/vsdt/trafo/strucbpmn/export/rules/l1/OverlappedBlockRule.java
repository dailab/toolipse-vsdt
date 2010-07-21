package de.dailab.vsdt.trafo.strucbpmn.export.rules.l1;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;

/**
 * Create Block Rule
 * 
 * PATTERN: 
 * 
 *     ------FA------
 *    |              | 
 * --G1--FB--G2--FC--G3--FD--G4--
 *            |              |
 *             ------FE------
 * 
 * EFFECT: 
 *     ------FA----------FD--
 *    |                      |
 * --G1--FB--G2--FC--G3--FD--G4--
 *            |              |
 *             ------FE------
 * 
 */
public class OverlappedBlockRule extends AbstractVsdtRule {
	
	protected SequenceFlow	_seqFlowA1= null;
	protected SequenceFlow	_seqFlowA2= null;
	protected SequenceFlow	_seqFlowB1= null;
	protected SequenceFlow	_seqFlowB2= null;
	protected SequenceFlow	_seqFlowC1= null;
	protected SequenceFlow	_seqFlowC2= null;
	protected SequenceFlow	_seqFlowD1= null;
	protected SequenceFlow	_seqFlowD2= null;
	protected SequenceFlow	_seqFlowE1= null;
	protected SequenceFlow	_seqFlowE2= null;
	protected FlowObject	_flowobjectA= null;
	protected FlowObject	_flowobjectB= null;
	protected FlowObject	_flowobjectC= null;
	protected FlowObject	_flowobjectD= null;
	protected FlowObject	_flowobjectE= null;
	protected Gateway		_gateway1= null;
	protected Gateway		_gateway2= null;
	protected Gateway		_gateway3= null;
	protected Gateway		_gateway4= null;
	
	@Override
	protected void resetVars() {
		_seqFlowA1= null;
		_seqFlowA2= null;
		_seqFlowB1= null;
		_seqFlowB2= null;
		_seqFlowC1= null;
		_seqFlowC2= null;
		_seqFlowD1= null;
		_seqFlowD2= null;
		_seqFlowE1= null;
		_seqFlowE2= null;
		_flowobjectA= null;
		_flowobjectB= null;
		_flowobjectC= null;
		_flowobjectD= null;
		_flowobjectE= null;
		_gateway1= null;
		_gateway2= null;
		_gateway3= null;
		_gateway4= null;
	}
		
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}
	
	/**
	 * - duplicate FlowObject D
	 * - insert duplicate after FlowObject A
	 * - reroute Sequence Flows over duplicate to Gateway 4
	 */
	@Override
	protected void apply() {
		
		// create copy
		FlowObject copy= (FlowObject) EcoreUtil.copy(_flowobjectD);
		copy.setParent(_flowobjectD.getParent());
		
		//reroute sfA2 to copy
		_seqFlowA2.setTarget(copy);
		
		//create sf between copy and g4
		SequenceFlow seqFlow= VsdtFactory.eINSTANCE.createSequenceFlow();
		seqFlow.setParent(_seqFlowA1.getParent());
		seqFlow.setSource(copy);
		seqFlow.setTarget(_gateway4);
	}

	@Override
	protected void setWeightedLHS(List<EObject> matches){
		_seqFlowA1=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWA1);
		_seqFlowA2=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWA2);
		_seqFlowB1=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWB1);
		_seqFlowB2=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWB2);
		_seqFlowC1=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWC1);
		_seqFlowC2=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWC2);
		_seqFlowD1=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWD1);
		_seqFlowD2=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWD2);
		_seqFlowE1=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWE1);
		_seqFlowE2=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWE2);
		_flowobjectA=	(FlowObject)	matches.get(RuleWrapper.FLOWOBJECTA);
		_flowobjectB=	(FlowObject)	matches.get(RuleWrapper.FLOWOBJECTB);
		_flowobjectC=	(FlowObject)	matches.get(RuleWrapper.FLOWOBJECTC);
		_flowobjectD=	(FlowObject)	matches.get(RuleWrapper.FLOWOBJECTD);
		_flowobjectE=	(FlowObject)	matches.get(RuleWrapper.FLOWOBJECTE);
		_gateway1=		(Gateway)		matches.get(RuleWrapper.GATEWAY1);
		_gateway2=		(Gateway)		matches.get(RuleWrapper.GATEWAY2);
		_gateway3=		(Gateway)		matches.get(RuleWrapper.GATEWAY3);
		_gateway4=		(Gateway)		matches.get(RuleWrapper.GATEWAY4);
	}
	
	
	/**
	 * wrapper class for this rule
	 * 
	 * @author tkuester
	 */
	class RuleWrapper extends AbstractVsdtWrapper {
			
		public static final int SEQFLOWA1= 0,
								SEQFLOWA2= 1,
								SEQFLOWB1= 2,
								SEQFLOWB2= 3,
								SEQFLOWC2= 4,
								SEQFLOWC1= 5,
								SEQFLOWD1= 6,
								SEQFLOWD2= 7,
								SEQFLOWE1= 8,
								SEQFLOWE2= 9,
								FLOWOBJECTA= 10,
								FLOWOBJECTB= 11,
								FLOWOBJECTC= 12,
								FLOWOBJECTD= 13,
								FLOWOBJECTE= 14,
								GATEWAY1= 15,
								GATEWAY2= 16,
								GATEWAY3= 17,
								GATEWAY4= 18;
		
		protected VsdtPackage bpmn= VsdtPackage.eINSTANCE;
		
		@Override
		public void initLHSVariables() {
			
			addVariableType(bpmn.getSequenceFlow(), lhsVariables, 10); // SEQFLOWs
			addVariableType(bpmn.getFlowObject(), lhsVariables, 5);	   // FLOWOBJECTs
			addVariableType(bpmn.getGateway(), lhsVariables, 4);	   // GATEWAYs
			
			//queries
			createInjectivityQueries(lhsVariables);

			addBranchTargetQueries(lhsVariables, GATEWAY1, SEQFLOWA1, FLOWOBJECTA, SEQFLOWA2, GATEWAY3);
			addBranchTargetQueries(lhsVariables, GATEWAY1, SEQFLOWB1, FLOWOBJECTB, SEQFLOWB2, GATEWAY2);
			addBranchTargetQueries(lhsVariables, GATEWAY2, SEQFLOWC1, FLOWOBJECTC, SEQFLOWC2, GATEWAY3);
			addBranchTargetQueries(lhsVariables, GATEWAY3, SEQFLOWD1, FLOWOBJECTD, SEQFLOWD2, GATEWAY4);
			addBranchTargetQueries(lhsVariables, GATEWAY2, SEQFLOWE1, FLOWOBJECTE, SEQFLOWE2, GATEWAY4);
		}
		
		@Override
		protected void initNACVariables() {
		}
	}
}