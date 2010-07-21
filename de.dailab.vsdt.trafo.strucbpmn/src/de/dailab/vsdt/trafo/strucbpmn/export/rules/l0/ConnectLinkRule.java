package de.dailab.vsdt.trafo.strucbpmn.export.rules.l0;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Event;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;

/**
 * Connect Link Rule
 * 
 * FIXME: Currently this rule supports only 1:1 relations of link events. However, it
 * should be possible to support n:m relations. Therefore, instead of simply removing
 * the link-reference a better NAC has to be found.
 * 
 * PATTERN: two link events, being linked together.
 * 
 * EFFECT: a sequence flow is drawn from the the throwing link event to the catching link event
 * and both link references are removed.
 */
public class ConnectLinkRule extends AbstractVsdtRule {

	protected Event link1= null;
	protected Event link2= null;
	
	@Override
	protected void resetVars() {
		link1= null;
		link2= null;
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}

	@Override
	protected void setWeightedLHS(List<EObject> matches){
		link1=(Event)	matches.get(RuleWrapper.LINK1);
		link2=(Event)	matches.get(RuleWrapper.LINK2);
	}
	
	/**
	 * - If one of the flowObjects is a bpmnSeq, use this, otherwise create a new one
	 * - Insert the bpmnSequence in the flowObjects container
	 * - Put the flowObjects in the bpmnSequence
	 * - Redirect incoming and outgoing sequence flows to point to the sequence instead of the flowObjects
	 * - remove the sequence flow in between the flowObjects
	 */
	@Override
	protected void apply() {
		// create connection
		SequenceFlow sequenceFlow= VsdtFactory.eINSTANCE.createSequenceFlow();
		sequenceFlow.setSource(link1);
		sequenceFlow.setTarget(link2);
		link1.getPool().getParent().getConnections().add(sequenceFlow);
		// remove link references
		link1.setLinkedTo(null);
		link2.setLinkedTo(null);
	}
	
	/**
	 * wrapper class for this rule
	 * 
	 * @author tkuester
	 */
	class RuleWrapper extends AbstractVsdtWrapper {
		
		public static final int LINK1= 0,
								LINK2= 1;

		@Override
		public void initLHSVariables() {
			 
			addVariableType(bpmn.getEvent(), lhsVariables);	// LINK1
			addVariableType(bpmn.getEvent(), lhsVariables);	// LINK2

			//queries
			addTargetQuery(lhsVariables, LINK1, LINK2, bpmn.getEvent_LinkedTo());
			addInjectivityQuery(lhsVariables, LINK1, LINK2);

			//reduce link 1
			for (Iterator<EObject> iter = lhsVariables.get(LINK1).getDomain().iterator(); iter.hasNext();) {
				Event event= (Event) iter.next();
				if (! event.isThrowing() || 
						(event.getTrigger() != TriggerType.LINK
						&& event.getTrigger() != TriggerType.MULTIPLE)) {
					iter.remove();
				}
			}
			
			//reduce link 2
			for (Iterator<EObject> iter = lhsVariables.get(LINK2).getDomain().iterator(); iter.hasNext();) {
				Event event= (Event) iter.next();
				if (event.isThrowing() || 
						(event.getTrigger() != TriggerType.LINK
						&& event.getTrigger() != TriggerType.MULTIPLE)) {
					iter.remove();
				}
			}
		}
		
		@Override
		protected void initNACVariables() {
		}
		
	}
	
}