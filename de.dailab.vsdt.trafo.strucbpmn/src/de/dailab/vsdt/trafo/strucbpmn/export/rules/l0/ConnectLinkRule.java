package de.dailab.vsdt.trafo.strucbpmn.export.rules.l0;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Event;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

/**
 * Connect Link Rule
 * 
 * PATTERN: two link events, being linked together.
 * 
 * EFFECT: a sequence flow is drawn from the the throwing link event to the catching link event
 * and both link references are removed.
 */
public class ConnectLinkRule extends AbstractVsdtRule {

	public static final int LINK1= 0,
							LINK2= 1;
	
	/**
	 * - If one of the flowObjects is a bpmnSeq, use this, otherwise create a new one
	 * - Insert the bpmnSequence in the flowObjects container
	 * - Put the flowObjects in the bpmnSequence
	 * - Redirect incoming and outgoing sequence flows to point to the sequence instead of the flowObjects
	 * - remove the sequence flow in between the flowObjects
	 */
	@Override
	protected void excecute(List<EObject> matches) {
		Event link1= (Event) matches.get(LINK1);
		Event link2= (Event) matches.get(LINK2);
		
		// create connection
		SequenceFlow sequenceFlow= VsdtFactory.eINSTANCE.createSequenceFlow();
		sequenceFlow.setSource(link1);
		sequenceFlow.setTarget(link2);
		link1.getPool().getParent().getConnections().add(sequenceFlow);
		// remove link references
		link1.setLinkedTo(null);
		link2.setLinkedTo(null);
	}
	

	@Override
	public void initLHSVariables() {
		 
		addVariable(lhsVariables, bpmn.getEvent());	// LINK1
		addVariable(lhsVariables, bpmn.getEvent());	// LINK2

		//queries
		addReferenceConstraint(lhsVariables, LINK1, LINK2, bpmn.getEvent_LinkedTo());
		addInjectivityConstraint(lhsVariables, LINK1, LINK2);

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