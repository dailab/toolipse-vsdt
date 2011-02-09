package de.dailab.vsdt.trafo.strucbpmn.export.rules.l0;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.strucbpmn.export.AbstractVsdtRule;

/**
 * Insert Empty Rule 2
 * 
 * With this rule a gateway and an activity with boundary event that are directly 
 * connected by a sequence flow are separated by an activity with task type None. 
 * The activity will be mapped to an empty activity in the target language which 
 * can be removed in the Clean Up layer.
 * 
 * PATTERN: a gateway directly before an activity with attached intermediate event
 * 
 * EFFECT: a placeholder-activity is inserted between the two flow objects. the 
 * activity is given a special name that can be used in later rules to remove 
 * the activity again when it is no longer needed.
 */
public class InsertEmptyRule2 extends AbstractVsdtRule {
	
	public static final int SEQFLOW= 0,
							GATEWAY= 1,
							ACTIVITY= 2;
	
	@Override
	protected void excecute(List<EObject> matches){
		SequenceFlow _seqFlow=	(SequenceFlow)	matches.get(SEQFLOW);
		Activity _activity=		(Activity)		matches.get(ACTIVITY);
		Gateway _gateway=		(Gateway)		matches.get(GATEWAY);
		
		//create none activity
		FlowObjectContainer container= _gateway.getParent();
		Activity activity= VsdtFactory.eINSTANCE.createActivity();
		activity.setParent(container);
		
		activity.setName(InsertEmptyRule.EMPTY_NAME);
		
		//create sequence flow
		BusinessProcessDiagram bpd= _gateway.getPool().getParent();
		SequenceFlow seqFlow2= VsdtFactory.eINSTANCE.createSequenceFlow();
		bpd.getConnections().add(seqFlow2);
		_seqFlow.setName(_seqFlow.getName() != null ? _seqFlow.getName() + "_2" : null);
		
		//connect gateways via activity
		_seqFlow.setTarget(activity);
		seqFlow2.setSource(activity);
		seqFlow2.setTarget(_activity);
	}
	
	@Override
	public void initLHSVariables() {
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOW
		addVariable(lhsVariables, bpmn.getGateway());		// GATEWAY
		addVariable(lhsVariables, bpmn.getActivity());		// ACTIVITY
		
		//queries
		addReferenceConstraint(lhsVariables, SEQFLOW, GATEWAY, bpmn.getSequenceFlow_Source());
		addReferenceConstraint(lhsVariables, SEQFLOW, ACTIVITY, bpmn.getSequenceFlow_Target());
		
		//reduce domains
		for (Iterator<EObject> iter = lhsVariables.get(ACTIVITY).getDomain().iterator(); iter.hasNext();) {
			Activity activity= (Activity) iter.next();
			// activity with boundary event
			if (activity.getBoundaryEvents().isEmpty()) {
				iter.remove();
			}
		}
	}
	
	@Override
	protected void initNACVariables() {
	}
	
}