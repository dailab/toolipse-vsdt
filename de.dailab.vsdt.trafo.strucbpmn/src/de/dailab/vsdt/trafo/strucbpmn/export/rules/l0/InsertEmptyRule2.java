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
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;

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
	
	protected SequenceFlow _seqFlow= null;
	protected Gateway _gateway= null;
	protected Activity _activity= null;
	
	@Override
	protected void resetVars() {
		_seqFlow= null;
		_activity= null;
		_gateway= null;
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}

	
	@Override
	protected void apply() {
		
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
	protected void setWeightedLHS(List<EObject> matches){
		_seqFlow=	(SequenceFlow)	matches.get(RuleWrapper.SEQFLOW);
		_activity=	(Activity)		matches.get(RuleWrapper.ACTIVITY);
		_gateway=	(Gateway)		matches.get(RuleWrapper.GATEWAY);
	}
	
	
	/**
	 * wrapper for the rule
	 */
	class RuleWrapper extends AbstractVsdtWrapper {
		
		public static final int SEQFLOW= 0,
								GATEWAY= 1,
								ACTIVITY= 2;
		
		@Override
		public void initLHSVariables() {
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOW
			addVariableType(bpmn.getGateway(), lhsVariables);		// GATEWAY
			addVariableType(bpmn.getActivity(), lhsVariables);	// ACTIVITY
			
			//queries
			addTargetQuery(lhsVariables, SEQFLOW, GATEWAY, bpmn.getSequenceFlow_Source());
			addTargetQuery(lhsVariables, SEQFLOW, ACTIVITY, bpmn.getSequenceFlow_Target());
			
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
	
}