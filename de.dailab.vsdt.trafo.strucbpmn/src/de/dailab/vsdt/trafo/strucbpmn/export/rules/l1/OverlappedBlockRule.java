package de.dailab.vsdt.trafo.strucbpmn.export.rules.l1;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

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
	
	/**
	 * - duplicate FlowObject D
	 * - insert duplicate after FlowObject A
	 * - reroute Sequence Flows over duplicate to Gateway 4
	 */
	@Override
	protected void apply(List<EObject> matches){
		SequenceFlow _seqFlowA1=	(SequenceFlow)	matches.get(SEQFLOWA1);
		SequenceFlow _seqFlowA2=	(SequenceFlow)	matches.get(SEQFLOWA2);
//		SequenceFlow _seqFlowB1=	(SequenceFlow)	matches.get(SEQFLOWB1);
//		SequenceFlow _seqFlowB2=	(SequenceFlow)	matches.get(SEQFLOWB2);
//		SequenceFlow _seqFlowC1=	(SequenceFlow)	matches.get(SEQFLOWC1);
//		SequenceFlow _seqFlowC2=	(SequenceFlow)	matches.get(SEQFLOWC2);
//		SequenceFlow _seqFlowD1=	(SequenceFlow)	matches.get(SEQFLOWD1);
//		SequenceFlow _seqFlowD2=	(SequenceFlow)	matches.get(SEQFLOWD2);
//		SequenceFlow _seqFlowE1=	(SequenceFlow)	matches.get(SEQFLOWE1);
//		SequenceFlow _seqFlowE2=	(SequenceFlow)	matches.get(SEQFLOWE2);
//		FlowObject _flowobjectA=	(FlowObject)	matches.get(FLOWOBJECTA);
//		FlowObject _flowobjectB=	(FlowObject)	matches.get(FLOWOBJECTB);
//		FlowObject _flowobjectC=	(FlowObject)	matches.get(FLOWOBJECTC);
		FlowObject _flowobjectD=	(FlowObject)	matches.get(FLOWOBJECTD);
//		FlowObject _flowobjectE=	(FlowObject)	matches.get(FLOWOBJECTE);
//		Gateway _gateway1=			(Gateway)		matches.get(GATEWAY1);
//		Gateway _gateway2=			(Gateway)		matches.get(GATEWAY2);
//		Gateway _gateway3=			(Gateway)		matches.get(GATEWAY3);
		Gateway _gateway4=			(Gateway)		matches.get(GATEWAY4);
		
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

	
	protected VsdtPackage bpmn= VsdtPackage.eINSTANCE;
	
	@Override
	public void initLHSVariables() {
		
		addVariable(lhsVariables, bpmn.getSequenceFlow(), 10); // SEQFLOWs
		addVariable(lhsVariables, bpmn.getFlowObject(), 5);	   // FLOWOBJECTs
		addVariable(lhsVariables, bpmn.getGateway(), 4);	   // GATEWAYs
		
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