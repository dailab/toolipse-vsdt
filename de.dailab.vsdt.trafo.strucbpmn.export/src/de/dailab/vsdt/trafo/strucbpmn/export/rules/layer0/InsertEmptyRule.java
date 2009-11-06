package de.dailab.vsdt.trafo.strucbpmn.export.rules.layer0;

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
import de.dailab.vsdt.trafo.base.AbstractRule;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.AbstractVsdtWrapper;

/**
 * Insert Empty Rule
 * 
 * 
 * With this rule two gateways OR an activity with boundary event and a gateway OR
 * an intermediate event on a boundary and a gateway that are directly connected by a sequence flow 
 * are separated by an activity with task type None. The activity will be mapped 
 * to an empty activity in the target language which can be removed in the Clean Up 
 * layer. This rule is necessary to facilitate the Block Rule and Loop Rule. 
 * After the application of this rule there will be no directly connected gateways anymore.
 * 
 * PATTERN: a gateway directly after another gateway / an activity with boundary event / a boundary event
 * 
 * EFFECT: a placeholder-activity is inserted between the two flow objects. the activity is given a special name
 * that can be used in later rules to remove the activity again when it is no longer needed.
 */
public class InsertEmptyRule extends AbstractRule {
	
	protected SequenceFlow _seqFlow= null;
	protected FlowObject _flowObject= null;
	protected Gateway _gateway= null;
	
	/**
	 * the name for the empty activity. later these activities can be removed.
	 */
	public final static String EMPTY_NAME= "_DO_NOTHING_";
	
	/**
	 * Default constructor.
	 */
	public InsertEmptyRule(EObject root) {
		super(root,"Insert Empty Rule");
	}
	
	@Override
	protected void resetVars() {
		_seqFlow= null;
		_flowObject= null;
		_gateway= null;
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}

	
	@Override
	protected void apply() {
		
		//create none activity
		FlowObjectContainer container= _gateway.getFlowObjectContainer();
		Activity activity= VsdtFactory.eINSTANCE.createActivity();
		activity.setFlowObjectContainer(container);
		
		activity.setName(EMPTY_NAME);
		
		//create sequence flow
		BusinessProcessDiagram bpd= _gateway.getPool().getParentDiagram();
		SequenceFlow seqFlow2= VsdtFactory.eINSTANCE.createSequenceFlow();
		bpd.getConnections().add(seqFlow2);
		_seqFlow.setName(_seqFlow.getName() != null ? _seqFlow.getName() + "_2" : null);
		
		//connect gateways via activity
		_seqFlow.setTarget(activity);
		seqFlow2.setSource(activity);
		seqFlow2.setTarget(_gateway);
	}
	
	@Override
	protected void setWeightedLHS(List<EObject> matches){
		_seqFlow=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOW);
		_flowObject=	(FlowObject)	matches.get(RuleWrapper.FLOWOBJECT);
		_gateway=		(Gateway)		matches.get(RuleWrapper.GATEWAY);
	}
	
	
	/**
	 * wrapper for the rule
	 */
	class RuleWrapper extends AbstractVsdtWrapper {
		
		public static final int SEQFLOW= 0,
								FLOWOBJECT= 1,
								GATEWAY= 2;
		
		@Override
		public void initLHSVariables() {
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOW
			addVariableType(bpmn.getFlowObject(), lhsVariables);	// FLOWOBJECT
			addVariableType(bpmn.getGateway(), lhsVariables);		// GATEWAY
			
			//queries
			addTargetQuery(lhsVariables, SEQFLOW, FLOWOBJECT, bpmn.getSequenceFlow_Source());
			addTargetQuery(lhsVariables, SEQFLOW, GATEWAY, bpmn.getSequenceFlow_Target());
			
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
	
}