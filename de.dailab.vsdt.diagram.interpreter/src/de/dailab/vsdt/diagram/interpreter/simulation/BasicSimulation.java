package de.dailab.vsdt.diagram.interpreter.simulation;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.TriggerType;

/**
 * The Basic Simulation provides implementations for most of the abstract methods
 * of the Abstract Simulation, some of which are already very elaborate while
 * others are very simple (or even empty).
 * 
 * @author kuester
 */
public abstract class BasicSimulation extends AbstractSimulation {

	/*
	 * TODO
	 * - "real" event handling (signal, error, cancel, ...)
	 * - compensation activity
	 * - ad-hoc process: children always ready
	 * - independent subprocess: jump to diagram (and keep simulation status)
	 * - what to do if subprocess (or other) is ready again while still being active?
	 */

	@Override
	protected boolean calculateIsReady(FlowObject flowObject) {
		if (! isInState(flowObject, State.IDLE, State.READY, State.DONE, State.FAILED, null)) return false;
		// elements contained in activities can only be ready if the activity itself is active
		if (flowObject.eContainer() instanceof Activity) {
			if (! isInState(((Activity) flowObject.eContainer()), State.ACTIVE_READY, State.ACTIVE_WAITING)) {
				return false;
			}
		}
		// link intermediate is readied only by Link's other end
		if (flowObject instanceof Intermediate) {
			Intermediate i= (Intermediate) flowObject;
			if (! i.isThrowing() && (i.getTrigger() == TriggerType.LINK || 
					(i.getTrigger() == TriggerType.MULTIPLE && i.getLinkedTo() != null))) {
				return false;
			}
		}
		// check sequence flows; apart from AND gateway, one incoming sequence flow is enough
		boolean requiresAll= flowObject instanceof Gateway 
				&& ((Gateway)flowObject).getGatewayType() == GatewayType.AND;
		boolean seqOk= flowObject.getIncomingSeq().isEmpty() || requiresAll;
		for (SequenceFlow sequenceFlow : flowObject.getIncomingSeq()) {
			if (requiresAll) {
				seqOk&= tokenMap.get(sequenceFlow) > 0;	
			} else {
				seqOk|= tokenMap.get(sequenceFlow) > 0;
			}
		}
		return seqOk;
	}
	
	@Override
	protected boolean calculateCanFinish(FlowObject flowObject) {
		if (! isInState(flowObject, State.ACTIVE_WAITING)) return false;
		// check children
		if (flowObject instanceof Activity && ((Activity)flowObject).getActivityType() == ActivityType.EMBEDDED) {
			for (FlowObject child : ((Activity) flowObject).getGraphicalElements()) {
				if (isInState(child, State.READY, State.ACTIVE_WAITING, State.ACTIVE_READY)) {
					return false;
				}
			}
		}
		// check incoming messages
		boolean msgOk= true;
		for (MessageFlow messageFlow : flowObject.getIncomingMsg()) {
			if (messageFlow.getSource() instanceof FlowObject) {
				msgOk&= tokenMap.get(messageFlow) > 0;
			}
		}
		return msgOk;
	}
	
	@Override
	protected void executeBegin(FlowObject flowObject) {
		// place tokens on outgoing message flows
		for (MessageFlow msgFlow : flowObject.getOutgoingMsg()) {
			changeToken(msgFlow, +1);
			stepMap.put(msgFlow, step);
			if (msgFlow.getTarget() instanceof FlowObject) {
				updateState((FlowObject) msgFlow.getTarget());
			}
		}
	}
	
	@Override
	protected void executeEnd(FlowObject flowObject) {
		// consume tokens from incoming message flows
		for (MessageFlow msgFlow : flowObject.getIncomingMsg()) {
			changeToken(msgFlow, -1);
		}
	}

	@Override
	protected void setState(FlowObject flowObject, State state) {
		State lastState= getState(flowObject);
		stateMap.put(flowObject, state);
		
		if (flowObject instanceof Activity) {
			Activity activity = (Activity) flowObject;
			// set children to ready
			if (activity.getActivityType() == ActivityType.EMBEDDED) {
				if (activity.isEventedSubprocess()) {
					if (state == State.READY) {
						setState(activity, State.ACTIVE_WAITING);
					}
				}
				for (FlowObject child : activity.getGraphicalElements()) {
					if (state == State.ACTIVE_WAITING) {
						updateState(child);
					} else if (state == State.FAILED) {
						if (getState(child).isActiveState()) {
							setState(child, State.FAILED);
						}
					}
				}
				if (lastState == State.ACTIVE_WAITING && state != State.ACTIVE_WAITING) {
					// leaving state ACTIVE_WATING: remove tokens, READY states
					for (FlowObject child : activity.getGraphicalElements()) {
						if (isInState(child, State.READY)) {
							setState(child, State.IDLE);
						}
						for (SequenceFlow seqFlow : child.getOutgoingSeq()) {
							tokenMap.put(seqFlow, 0);
						}
					}
				}
			}
			for (FlowObject borderItem : activity.getBoundaryEvents()) {
				if (state == State.ACTIVE_WAITING) {
					setState(borderItem, State.READY);
				} else if (state == State.DONE || state == State.FAILED) {
					if (getState(borderItem) != State.DONE) {
						setState(borderItem, State.IDLE);
					}
				}
			}
		}
		
		if (flowObject instanceof Intermediate) {
			Intermediate intermediate= (Intermediate) flowObject;
			if (state == State.DONE) {
				// event handler: 
				if (intermediate.getAttachedTo() != null) {
					if (intermediate.isNonInterrupting()) {
						// non-interrupting: activate again
						setState(intermediate, State.READY);
					} else {
						// interrupting: set activity's state to failed
						setState(intermediate.getAttachedTo(), State.FAILED);
					}
				}
				// activate other end of Link event
				if ((intermediate.getTrigger() == TriggerType.LINK || 
						intermediate.getTrigger() == TriggerType.MULTIPLE) && intermediate.isThrowing()) {
					if (intermediate.getLinkedTo() != null) {
						setState(intermediate.getLinkedTo(), State.READY);
					}
				}
			}
		}
		
		if (flowObject instanceof Start) {
			Start start = (Start) flowObject;
			if (start.getParent() instanceof Activity && ((Activity) start.getParent()).isEventedSubprocess()) {
				Activity parent = (Activity) start.getParent();
				// start event in evented subprocess
				if (state == State.ACTIVE_WAITING) {
					if (! start.isNonInterrupting()) {
						// interrupt parent's parent activity and its children
						// this can not be done using setState, as this would also cancel the evented subprocess itself
						if (parent.getAbstractProcess() instanceof Activity) {
							Activity grandparent = (Activity) parent.getAbstractProcess();
							stateMap.put(grandparent, State.ACTIVE_WAITING);
							for (FlowObject child : grandparent.getGraphicalElements()) {
								if (child != parent) {
									setState(child, State.FAILED);
								}
							}
						}
					}
				}
			}
		}
	}
	
}
