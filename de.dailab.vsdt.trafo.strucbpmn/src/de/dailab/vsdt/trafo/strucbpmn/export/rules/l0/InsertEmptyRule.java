package de.dailab.vsdt.trafo.strucbpmn.export.rules.l0;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

/**
 * Insert Empty Rule
 * 
 * With this rule two gateways OR an activity with boundary event and a gateway
 * OR an intermediate event on a boundary and a gateway that are directly 
 * connected by a sequence flow are separated by an activity with task type 
 * None. The activity will be mapped to an empty activity in the target language
 * which can be removed in the Clean Up layer. This rule is necessary to
 * facilitate the Block Rule and Loop Rule. After the application of this rule
 * there will be no directly connected gateways anymore.
 * 
 * PATTERN: a gateway directly after another gateway / an activity with boundary
 * event / a boundary event
 * 
 * EFFECT: a placeholder-activity is inserted between the two flow objects. the 
 * activity is given a special name that can be used in later rules to remove 
 * the activity again when it is no longer needed.
 */
public class InsertEmptyRule extends AbstractVsdtRule {
	
	public static final int SEQFLOW= 0,
	FLOWOBJECT= 1,
	GATEWAY= 2;
	
	@Override
	protected void apply(List<EObject> matches){
		SequenceFlow _seqFlow=	(SequenceFlow)	matches.get(SEQFLOW);
//		FlowObject _flowObject=	(FlowObject)	matches.get(FLOWOBJECT);
		Gateway _gateway=		(Gateway)		matches.get(GATEWAY);
		
		//create none activity
		FlowObjectContainer container= _gateway.getParent();
		Activity activity= VsdtFactory.eINSTANCE.createActivity();
		activity.setParent(container);
		
		activity.setName(EMPTY_NAME);
		
		//create sequence flow
		BusinessProcessDiagram bpd= _gateway.getPool().getParent();
		SequenceFlow seqFlow2= VsdtFactory.eINSTANCE.createSequenceFlow();
		bpd.getConnections().add(seqFlow2);
		_seqFlow.setName(_seqFlow.getName() != null ? _seqFlow.getName() + "_2" : null);
		
		//connect gateways via activity
		_seqFlow.setTarget(activity);
		seqFlow2.setSource(activity);
		seqFlow2.setTarget(_gateway);
	}

	@Override
	public void initLHSVariables() {
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOW
		addVariable(lhsVariables, bpmn.getFlowObject());	// FLOWOBJECT
		addVariable(lhsVariables, bpmn.getGateway());		// GATEWAY
		
		//queries
		addTargetConstraint(lhsVariables, SEQFLOW, FLOWOBJECT, bpmn.getSequenceFlow_Source());
		addTargetConstraint(lhsVariables, SEQFLOW, GATEWAY, bpmn.getSequenceFlow_Target());
		
		//reduce domains
		for (Iterator<EObject> iter = lhsVariables.get(FLOWOBJECT).getDomain().iterator(); iter.hasNext();) {
			FlowObject flowObject= (FlowObject) iter.next();
			boolean ok=false;
			
			//flow object may be a gateway...
			if (flowObject instanceof Gateway) {
				ok= true;
			}
			
			//...or an activity with boundary event...
			if (flowObject instanceof Activity) {
				Activity activity = (Activity) flowObject;
				if (! activity.getBoundaryEvents().isEmpty()) {
					ok= true;
				}
					
			}
			
			//...or a boundary event
			if (flowObject instanceof Intermediate) {
				Intermediate intermediate = (Intermediate) flowObject;
				if (intermediate.getAttachedTo() != null) {
					ok= true;
				}
			}
			
			if (! ok) {
				iter.remove();
			}
		}
	}
	
	@Override
	protected void initNACVariables() {
	}
	
}