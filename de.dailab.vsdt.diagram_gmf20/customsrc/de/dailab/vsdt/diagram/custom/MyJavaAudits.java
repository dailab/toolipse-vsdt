package de.dailab.vsdt.diagram.custom;

import java.util.Iterator;

import de.dailab.vsdt.AbstractProcess;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.End;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.IntermediateEventTriggerType;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.StartEventTriggerType;
import de.dailab.vsdt.TriggerType;

/**
 * this class encapsulates all java audits for the VSDT BPMN diagram editor plug-in. by this the risk of overriding and the
 * necessary effort for regenerating the editor is minimized. has to be extended by the nested class of same name in the 
 * diagram.providers.VsdtValidationProvider class
 */
public class MyJavaAudits {
	
//	/**
//	 * a message flow may be created only if both ends are (in) different pool, and it can not connect to lanes
//	 */
//	public static Boolean messageFlowConstraint(Node self,
//			Node oppositeEnd) {
//		Pool pool1= null;
//		if (self instanceof Pool) {
//			pool1= (Pool) self;
//		}
//		if (self instanceof FlowObject) {
//			pool1 = ((FlowObject) self).getPool();
//		}
//		Pool pool2= null;
//		if (oppositeEnd instanceof Pool) {
//			pool2= (Pool) oppositeEnd;
//		}
//		if (oppositeEnd instanceof FlowObject) {
//			pool2 = ((FlowObject) oppositeEnd).getPool();
//		}
//		return pool1!=null && pool2!=null && pool1!=pool2;
//	}

//	/**
//	 * When a FlowObject's Pool has more than one Lane, a Lane must be specified
//	 */
//	public static Boolean flow1LaneSpecified(FlowObject self) {
//		if (self.getPool() != null && self.getPool().getLanes().size() > 1) {
//			return !self.getLanes().isEmpty();
//		}
//		return true;
//	}

//	/**
//	 * A Flow Object's Lanes must be in the same Pool as the Flow Object itself
//	 */
//	public static Boolean flow2LaneInSamePool(FlowObject self) {
//		for (Iterator<Lane> iter = self.getLanes().iterator(); iter.hasNext();) {
//			Lane lane = iter.next();
//			if (lane.getParentPool() != self.getPool()) {
//				return false;
//			}
//		}
//		return true;
//	}

	/**
	 * Only one Pool may have an invisible boundary
	 */
	public static Boolean bpd1max1PoolInvisible(BusinessProcessDiagram self) {
		boolean foundInvisible = false;
		for (Iterator<Pool> iter = self.getPools().iterator(); iter.hasNext();) {
			Pool pool = iter.next();
			if (!pool.isBoundaryVisible()) {
				if (foundInvisible) {
					return false;
				} else {
					foundInvisible = true;
				}
			}
		}
		return true;
	}

	/**
	 * Events may not have outgoing conditional Sequence Flows
	 */
	public static Boolean event1outgoingAreUnconditioned(Event self) {
		for (Iterator<SequenceFlow> iter = self.getOutgoingSeq().iterator(); iter
				.hasNext();) {
			SequenceFlow seq = iter.next();
			if (seq.getConditionType() != ConditionType.NONE) {
				return false;
			}
		}
		return true;
	}
//
//	/**
//	 * Multiple Event Triggers must not contain further Multiple Event Triggers
//	 */
//	public static Boolean multi1isNotEmbedded(MultipleTriggerAttSet self) {
//		if (self.getParentTrigger() != null) {
//			return false;
//		}
//		return true;
//	}

	/**
	 * A Start Event must have at least one outgoing Sequence Flow
	 */
	public static Boolean start1hasOutgoingSequenceFlows(Start self) {
		return !self.getOutgoingSeq().isEmpty();
	}

	/**
	 * A Start Event must not have Incoming Sequence Flows
	 */
	public static Boolean start2hasNoIncomingSequenceFlows(Start self) {
		return self.getIncomingSeq().isEmpty();
	}

	/**
	 * A Start Event must not have outgoing Message Flows
	 */
	public static Boolean start3hasNoOutgoingMessageFlows(Start self) {
		return self.getOutgoingMsg().isEmpty();
	}


	/**
	 * An Intermediate Event must not have outgoing Message Flows
	 */
	public static Boolean intermediate1hasNoOutgoingMessageFlows(
			Intermediate self) {
		return self.getOutgoingMsg().isEmpty();
	}

	/**
	 * An End Event must have at least one incoming Sequence Flow
	 */
	public static Boolean end1hasIncomingSequenceFlows(End self) {
		return ! self.getIncomingSeq().isEmpty();
	}

	/**
	 * An End Event must not have Outgoing Sequence Flows
	 */
	public static Boolean end2hasNoOutgoingSequenceFlows(End self) {
		return self.getOutgoingSeq().isEmpty();
	}

	/**
	 * An End Event must not have incoming Message Flows
	 */
	public static Boolean end3hasNoIncomingMessageFlows(End self) {
		return self.getIncomingMsg().isEmpty();
	}

	/**
	 * Sequence Flows can not cross process boundaries
	 */
	public static Boolean seq1isSameProcess(SequenceFlow self) {
		return self.getSource().getAbstractProcess() == self.getTarget().getAbstractProcess();
	}

	/**
	 * There must be no single conditional outgoing Sequence Flows
	 */
	public static Boolean seq3noSingleConditionals(SequenceFlow self) {
		if (self.getConditionType() != ConditionType.NONE) {
			return self.getSource().getOutgoingSeq().size() > 1 || self.getSource() instanceof Gateway;
		}
		return true;
	}

	/**
	 * Message Flows can only connects different pools
	 */
	public static Boolean msg1notSamePool(MessageFlow self) {
		Pool pool1 = null;
		if (self.getSource() instanceof FlowObject) {
			pool1 = ((FlowObject) self.getSource()).getPool();
		}
		if (self.getSource() instanceof Pool) {
			pool1 = (Pool) self.getSource();
		}
		Pool pool2 = null;
		if (self.getTarget() instanceof FlowObject) {
			pool2 = ((FlowObject) self.getTarget()).getPool();
		}
		if (self.getTarget() instanceof Pool) {
			pool2 = (Pool) self.getTarget();
		}
		return pool1 != pool2;
	}

	/**
	 * Message Flows may not connect to Lanes, Gateways or Artifacts
	 */
	public static Boolean msg2NotGatewayLaneArtifact(MessageFlow self) {
		return (self.getSource() instanceof Pool || (self.getSource() instanceof FlowObject && !(self
				.getSource() instanceof Gateway)))
				&& (self.getTarget() instanceof Pool || (self.getTarget() instanceof FlowObject && !(self
						.getTarget() instanceof Gateway)));
	}

	/**
	 * Only Activities of Type Embedded may hold other Flow Objects
	 */
	public static Boolean act1IsAtomicOrEmbedded(Activity self) {
		return self.getContainedFlowObjects().isEmpty()
				|| self.getActivityType() == ActivityType.EMBEDDED;
	}

	/**
	 * Tasks must not have more than one incoming or Outgoing Message Flow
	 */
	public static Boolean act2TaskSingleMessage(Activity self) {
		if (self.getActivityType() != ActivityType.EMBEDDED
				&& self.getActivityType() != ActivityType.INDEPENDENT) {
			return self.getOutgoingMsg().size() < 2
					&& self.getIncomingMsg().size() < 2;
		}
		return true;
	}

	/**
	 * When there is a Start Event there has to be an End Event and vice versa
	 */
	public static Boolean proc1startAndEnd(AbstractProcess self) {
		boolean hasStart= false;
		boolean hasEnd= false;
		
		for (Iterator<FlowObject> iter = self.getGraphicalElements().iterator(); iter.hasNext();) {
			FlowObject flowObject = iter.next();
			if (flowObject instanceof Start) {
				hasStart= true;
			}
			if (flowObject instanceof End) {
				hasEnd= true;
			}
		}
		return hasStart == hasEnd;
	}

	/**
	 * Gateways must not have incoming or outgoing Message Flows
	 */
	public static Boolean gate1noMessageFlows(Gateway self) {
		return self.getOutgoingMsg().isEmpty() && self.getIncomingMsg().isEmpty();
	}

	/**
	 * AND-Gateways must not have outgoing conditional Sequence Flows
	 */
	public static Boolean gate2AndNoOutgoingConditional(
			Gateway self) {
		if (self.getGatewayType() == GatewayType.AND) {
			for (Iterator<SequenceFlow> iter = self.getOutgoingSeq().iterator(); iter.hasNext();) {
				SequenceFlow sequenceFlow = iter.next();
				if (sequenceFlow.getConditionType() != ConditionType.NONE) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * An Intermediate Event that is attached to an activity must not be of type None or Link
	 */
	public static Boolean intermediate2activitySetNotNoneOrLink(
			Intermediate self) {
		if (self.getTarget() != null) {
			if (self.getTrigger() == IntermediateEventTriggerType.NONE ||
					self.getTrigger() == IntermediateEventTriggerType.LINK) {
				return false;
			}
		}
		return true;
	}

	/**
	 * An Intermediate Event with a Cancel trigger must be attached to a Transaction Activity
	 */
	public static Boolean intermediate3cancelOnTransactionOnly(
			Intermediate self) {
		if (self.getTrigger()==IntermediateEventTriggerType.CANCEL) {
			if (self.getTarget() != null) {
				return self.getTarget().isIsTransaction();
			}
			return false;
		}
		return true;
	}

	/**
	 * An Intermediate Event bound to an Activity must not have incoming Sequence Flows
	 */
	public static Boolean intermediate4activityNoIncoming(Intermediate self) {
		if (self.getTarget() != null) {
			if (! self.getIncomingSeq().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * An Intermediate Event of type Compensation must not have outgoing Sequence Flows.
	 */
	public static Boolean intermediate5compensationNoOutgoing(
			Intermediate self) {
		if (self.getTrigger()==IntermediateEventTriggerType.COMPENSATION &&
				! self.getOutgoingSeq().isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * An Intermediate Event in normal flow must not be of type Cancel or Multiple
	 */
	public static Boolean intermediate6normalFlowNotCancelMultiple(
			Intermediate self) {
		if (self.getTarget() == null) {
			if (self.getTrigger()==IntermediateEventTriggerType.CANCEL ||
					self.getTrigger()==IntermediateEventTriggerType.MULTIPLE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * An Intermediate Event in normal flow with None, Error or Compensation trigger must have exactly one incoming Sequence Flow
	 */
	public static Boolean intermediate7normalFlowNoneErrorCompOneIncoming(
			Intermediate self) {
		if (self.getTarget() == null) {
			if (self.getTrigger()==IntermediateEventTriggerType.NONE ||
					self.getTrigger()==IntermediateEventTriggerType.ERROR ||
					self.getTrigger()==IntermediateEventTriggerType.COMPENSATION) {
				if (self.getIncomingSeq().size() != 1) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * An Intermediate Event in normal flow must not have more than one incoming Sequence Flows
	 */
	public static Boolean intermediate8incomingMaxOne(Intermediate self) {
		return self.getIncomingSeq().size() < 2;
	}

	/**
	 * An Intermediate Event must have exactly one outgoing Sequence Flow (exceptions: Link, Compensation)
	 */
	public static Boolean intermediate9oneOutgoingIfNotLinkOrComp(
			Intermediate self) {
		if (self.getTrigger()!=IntermediateEventTriggerType.LINK &&
				self.getTrigger()!=IntermediateEventTriggerType.COMPENSATION) {
			return self.getOutgoingSeq().size() == 1; 
		}
		return true;
	}

	/**
	 * An Intermediate Event of type Link must have exactly one incoming OR outgoing Sequence Flow
	 */
	public static Boolean intermediate10linkOneIncomingOrOutgoing(
			Intermediate self) {
		if (self.getTrigger()==IntermediateEventTriggerType.LINK) {
			return self.getIncomingSeq().size() + self.getOutgoingSeq().size() == 1; 
		}
		return true;
	}

	/**
	 * Only Intermediate Events of type Message may have exactly one incoming Message Flow
	 */
	public static Boolean intermediate12messageMaxOneIncomingMsg(
			Intermediate self) {
		if (self.getTrigger()==IntermediateEventTriggerType.MESSAGE) {
			return self.getIncomingMsg().size()<2;
		} else {
			return self.getIncomingMsg().isEmpty();
		}
	}
	
	/**
	 * An XOR-Event-Gateway's outgoing Sequence Flow's Condition must be set to None
	 */
	public static Boolean gate3XOREventOutgoingConditonNone(Gateway self) {
		if (self.getGatewayType() == GatewayType.XOR_EVENT) {
			for (Iterator<SequenceFlow> iter = self.getOutgoingSeq().iterator(); iter.hasNext();) {
				SequenceFlow seq= iter.next();
				if (seq.getConditionType()!=ConditionType.NONE) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * An XOR-Event-Gateway's outgoing Sequence Flow's target must be a Receive Task or an int. Event of Type Message, Trigger, Rule or Link
	 */
	public static Boolean gate4XOREventOutgoingTargetRecMsgTimerRuleLink(Gateway self) {
		if (self.getGatewayType() == GatewayType.XOR_EVENT) {
			for (Iterator<SequenceFlow> iter = self.getOutgoingSeq().iterator(); iter.hasNext();) {
				SequenceFlow seq= iter.next();
				if (seq.getTarget() instanceof Activity) {
					Activity activity = (Activity) seq.getTarget();
					if (activity.getActivityType()!=ActivityType.RECEIVE) {
						return false;
					}
					continue;
				}
				if (seq.getTarget() instanceof Intermediate) {
					Intermediate intermediate= (Intermediate) seq.getTarget();
					if (!(intermediate.getTrigger() == IntermediateEventTriggerType.MESSAGE) &&
							!(intermediate.getTrigger() == IntermediateEventTriggerType.TIMER) &&
							!(intermediate.getTrigger() == IntermediateEventTriggerType.RULE) &&
							!(intermediate.getTrigger() == IntermediateEventTriggerType.LINK)) {
						return false;
					}
					continue;
				}
				return false;
			}
		}
		return true;
	}

	/**
	 * An XOR-Event-Gateway's outgoing Sequence Flow's target must not be both Receive Tasks and Intermediate Message Events
	 */
	public static Boolean gate5XOREventNotBothRecTaskAndMsgEvent(Gateway self) {
		if (self.getGatewayType() == GatewayType.XOR_EVENT) {
			boolean recTask= false;
			boolean msgEvent= false;
			for (Iterator<SequenceFlow> iter = self.getOutgoingSeq().iterator(); iter.hasNext();) {
				SequenceFlow seq=  iter.next();
				if (seq.getTarget() instanceof Activity) {
					Activity activity = (Activity) seq.getTarget();
					if (activity.getActivityType()==ActivityType.RECEIVE) {
						if (msgEvent) {
							return false;
						}
						recTask= true;
					}
				}
				if (seq.getTarget() instanceof Intermediate) {
					Intermediate intermediate = (Intermediate) seq.getTarget();
					if (intermediate.getTrigger() == IntermediateEventTriggerType.MESSAGE) {
						if (recTask) {
							return false;
						}
						msgEvent= true;
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * A Start Event with incoming Message Flow must be of type Message
	 */
	public static Boolean start4messageFlowHasMessageTrigger(Start self) {
		if (!self.getIncomingMsg().isEmpty()) {
			if (self.getTrigger() == StartEventTriggerType.MESSAGE) {
				return true;
			}
			if (self.getTrigger() == StartEventTriggerType.MULTIPLE) {
				return self.getMessage() != null && self.getImplementation() != null;
			}
			return false;
		}
		return true;
	}

//	/**
//	 * A Start Event must have at least as many Message Triggers as incoming Message Flows
//	 */
//	public static Boolean start5messageFlowsHaveMultiTrigger(Start self) {
//		if (self.getIncomingMsg().size()>1) {
//			if (self.getTriggerAttributes() instanceof MultipleTriggerAttSet) {
//				int c= 0;
//				MultipleTriggerAttSet multiAttSet = (MultipleTriggerAttSet) self.getTriggerAttributes();
//				for (Iterator<TriggerAttributeSet> iter = multiAttSet.getTriggers().iterator(); iter
//						.hasNext();) {
//					if (iter.next() instanceof MessageTriggerAttSet) {
//						c++;
//					}
//				}
//				return c>= self.getIncomingMsg().size();
//			}
//			return false;
//		}
//		return true;
//	}

	/**
	 * Compensation Activities must not have outgoing Sequence Flows
	 */
	public static Boolean act3CompensationNoOutgoingSeq(Activity self) {
		if (self.isIsCompensation()) {
			return self.getOutgoingSeq().isEmpty();
		}
		return true;
	}

	/**
	 * When there is a Start Event there must not be any Flow Objects with no incoming Sequence Flow
	 */
	public static Boolean proc2noPseudoStarts(AbstractProcess self) {
		boolean hasStart= false;
		for (Iterator<FlowObject> iter = self.getGraphicalElements().iterator(); iter.hasNext();) {
			FlowObject flowObject = iter.next();
			if (flowObject instanceof Start) {
				hasStart= true;
			}
		}
		if (hasStart) {
			for (Iterator<FlowObject> iter = self.getGraphicalElements().iterator(); iter.hasNext();) {
				FlowObject flowObject = iter.next();
				if (!(flowObject instanceof Start) && flowObject.getIncomingSeq().isEmpty()) {
					if (flowObject instanceof Intermediate) {
						if (((Intermediate) flowObject).getTarget() != null) {
							continue;
						}
					}
					if (flowObject instanceof Activity) {
						if (((Activity)flowObject).isIsCompensation()) {
							continue;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * When there is an End Event there must not be any Flow Objects with no outgoing Sequence Flow
	 */
	public static Boolean proc3NoPseudoEnds(AbstractProcess self) {
		boolean hasEnd= false;
		for (Iterator<FlowObject> iter = self.getGraphicalElements().iterator(); iter.hasNext();) {
			FlowObject flowObject = iter.next();
			if (flowObject instanceof End) {
				hasEnd= true;
			}
		}
		if (hasEnd) {
			for (Iterator<FlowObject> iter = self.getGraphicalElements().iterator(); iter.hasNext();) {
				FlowObject flowObject = iter.next();
				if (!(flowObject instanceof End) && flowObject.getOutgoingSeq().isEmpty()) {
					if (flowObject instanceof Activity) {
						if (((Activity)flowObject).isIsCompensation()) {
							continue;
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * An Intermediate Event of type Link (source) must have exactly one target with the same link ID
	 */
	public static Boolean intermediate11sourceLinkMustHaveTarget(
			Intermediate self) {
		if (self.getTrigger()==IntermediateEventTriggerType.LINK) {
			if (self.getOutgoingSeq().isEmpty()) {
				//TODO look for target link ID
			}
		}
		return true;
	}

	/**
	 * When a Link Event's Target is in the same Pool then a Link End Event should be used
	 */
	public static Boolean intermediate13doNotUseIntLinkIfTargetInSamePool(
			Intermediate self) {
		if (self.getTrigger() == IntermediateEventTriggerType.LINK) {
			if (self.getProcessRef()==self.getPool().getProcess()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * An Intermediate Error Event in normal flow must provide an ErrorCode
	 */
	public static Boolean intermediate14errorCodeInNormalFlowGiven(
			Intermediate self) {
		if (self.getTarget() == null &&
				self.getTrigger() == IntermediateEventTriggerType.ERROR) {
			if (self.getErrorCode() == null
					|| self.getErrorCode().equals("")) {
				return false;
			}
		}
		return true;
	}

//	/**
//	 * A Lane's Child Lanes must be in the same Pool as the Lane itself
//	 */
//	public static Boolean lane1LanesInSamePool(Lane self) {
//		for (Iterator iter = self.getLanes().iterator(); iter.hasNext();) {
//			Lane lane = (Lane) iter.next();
//			if (lane == self ||
//					lane.getParentPool() != self.getParentPool()) {
//				return false;
//			}
//		}
//		return true;
//	}

//	/**
//	 * An Artifact's Lanes have to be in the same Pool as the Artifact
//	 */
//	public static Boolean artifact1lanesInPool(Artifact self) {
//		for (Iterator<Lane> iter = self.getLanes().iterator(); iter.hasNext();) {
//			Lane lane = iter.next();
//			if (lane.getParentPool() != self.getPool()) {
//				return false;
//			}
//		}
//		return true;
//	}

//	/**
//	 * When an Artifact's Pool has more than one Lane, a Lane must be specified
//	 */
//	public static Boolean artifact2laneSpecified(Artifact self) {
//		if (self.getPool() != null && self.getPool().getLanes().size() > 1) {
//			return !self.getLanes().isEmpty();
//		}
//		return true;
//	}

//	/**
//	 * Either a Time Date or a Time Cycle have to be entered.
//	 */
//	public static Boolean timer1oneOfBoth(Event self) {
//		boolean cycleSet = self.getTimeCycle() != null
//				&& self.getTimeCycle().length() > 0;
//		boolean dateSet = self.getTimeDate() != null;
//		return dateSet ^ cycleSet;
//	}
	
	/**
	 * A Sequence Flow's Condition Type may not be None if the source is a XOR Data or Inclusve OR Gateway
	 */
	public static Boolean seq2notNonewhenXORorOR(SequenceFlow self) {
		if (self.getSource() instanceof Gateway) {
			Gateway gateway = (Gateway) self.getSource();
			if (gateway.getOutgoingSeq().size() > 1 &&
			   (gateway.getGatewayType()==GatewayType.XOR_DATA ||
				gateway.getGatewayType()==GatewayType.OR)) {
				return self.getConditionType() != ConditionType.NONE;
			}
		}
		return true;
	}

	/**
	 * A Sequence Flow with a source of Type XOR Event, Complex or And Gateway or Event must have the Condition Type None
	 */
	public static Boolean seq4noneConditionType(SequenceFlow self) {
		if (self.getSource() instanceof Event) {
			return self.getConditionType()==ConditionType.NONE;
		}
		if (self.getSource() instanceof Gateway) {
			Gateway gateway = (Gateway) self.getSource();
			if (gateway.getGatewayType()==GatewayType.XOR_EVENT ||
					gateway.getGatewayType()==GatewayType.COMPLEX ||
					gateway.getGatewayType()==GatewayType.AND) {
				return self.getConditionType()==ConditionType.NONE;
			}
		}
		return true;
	}

	/**
	 * The Default Condition Type may be used only if the source is an 
	 * Activity or a Gateway with the Sequence Flow being set as default
	 */
	public static Boolean seq5defaultAllowed(SequenceFlow self) {
		if (self.getConditionType() == ConditionType.DEFAULT &&
				self.getSource() instanceof Gateway) {
			Gateway gateway = (Gateway) self.getSource();
			return (gateway.getGatewayType() == GatewayType.XOR_DATA 
					|| gateway.getGatewayType() == GatewayType.OR) 
					&& gateway.getDefaultGate() == self.getGate();
		}
		return true;
	}

	/**
	 * A Sequence Flow's Quantity may not be less than 1
	 */
	public static Boolean seq6quantityAtLeastOne(SequenceFlow self) {
		return self.getQuantity()>0;
	}

	/**
	 * An Activitiy' StartQuantity must be at least 1
	 */
	public static Boolean act4startQuantityNotLowerThanOne(Activity self) {
		return self.getStartQuantity()>0;
	}

	/**
	 * When a Complex Gateway has more than one incoming Sequence Flow the IncomingCondition must be given
	 */
	public static Boolean gate6complexInputCond(Gateway self) {
		if (self.getGatewayType() == GatewayType.COMPLEX) {
			if (self.getIncomingSeq().size()>1) {
				return self.getIncomingCondition() != null;
			}
		}
		return true;
	}

	/**
	 * When a Complex Gateway has more than one outgoing Sequence Flow the OutgoingCondition must be given
	 */
	public static Boolean gate7complexOutgoingCond(Gateway self) {
		if (self.getGatewayType() == GatewayType.COMPLEX) {
			if (self.getOutgoingSeq().size()>1) {
				return self.getOutgoingCondition() != null;
			}
		}
		return true;
	}

//	/**
//	 * The Default Gate's Outgoing Sequence Flow's Condition Type must be set to Default
//	 */
//	public static Boolean gate8defaultSet(Gateway self) {
//		if (self.getGatewayType() == GatewayType.XOR_DATA || self.getGatewayType() == GatewayType.OR) {
//			if (self.getDefaultGate() != null) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	/**
	 * Not all Attributes that are required for the given Event Type are set.
	 */
	public static Boolean eventType(Event self) {
		int type= 0;
		if (self instanceof Start)			type= ((Start)self).getTrigger().getValue();
		if (self instanceof End)			type= ((End)self).getTrigger().getValue();
		if (self instanceof Intermediate)	type= ((Intermediate)self).getTrigger().getValue();
		boolean ok= true;
		switch (type) {
		case TriggerType.MESSAGE_VALUE:
			// message, implementation
			ok&= self.getMessage() != null;
			ok&= self.getImplementation() != null;
			break;
		case TriggerType.TIMER_VALUE:
			//cycle or date
			ok&= self.getTimeCycle() != null ^ self.getTimeDate() != null;
			break;
		case TriggerType.ERROR_VALUE:
			//code (must in normal flow, may as event handler)
			ok&= self.getFlowObjectContainer() != null ? self.getErrorCode() != null : true;
			break;
		case TriggerType.LINK_VALUE:
			//link id, process reference
			ok&= self.getLinkId() != null;
			ok&= self.getProcessRef() != null;
			break;
		case TriggerType.COMPENSATION_VALUE:
			//activity (in normal flow)
			ok&= self.getFlowObjectContainer() != null ? self.getActivity() != null : true;
			break;
		case TriggerType.RULE_VALUE:
			// rule name and expression
			ok&= self.getRuleName() != null;
			ok&= self.getRuleExpression() != null && self.getRuleExpression().getExpression() != null;
			break;
		case TriggerType.MULTIPLE_VALUE:
			//no specific checks, possibly check for multiple, but how?
			break;
		case TriggerType.CANCEL_VALUE:
		case TriggerType.TERMINATE_VALUE:
			//none
			break;
		}
		return ok;
	}
	
	/**
	 * Not all Attributes that are required for the given Activity Type are set.
	 */
	public static Boolean activityType(Activity self) {
		boolean ok= true;
		switch (self.getActivityType().getValue()) {
		case ActivityType.EMBEDDED_VALUE:
			//none
			break;
		case ActivityType.INDEPENDENT_VALUE:
			//diagram reference, process reference
			ok&= self.getDiagramRef() != null;
			ok&= self.getProcessRef() != null;
			break;
		case ActivityType.SUBPROCESSREFERENCE_VALUE:
		case ActivityType.TASKREFERENCE_VALUE:
			//activity reference
			ok&= self.getActivityRef() != null;
			break;
		case ActivityType.SERVICE_VALUE:
		case ActivityType.USER_VALUE:
			//in message, out message, implementation, (performers *)
			ok&= self.getInMessage() != null;
			ok&= self.getOutMessage() != null;
			ok&= self.getImplementation() != null;
			break;
		case ActivityType.RECEIVE_VALUE:
			//out message, implementation, (instantiate)
			ok&= self.getOutMessage() != null;
			ok&= self.getImplementation() != null;
			break;
		case ActivityType.SEND_VALUE:
			//in message, implementation
			ok&= self.getInMessage() != null;
			ok&= self.getImplementation() != null;
			break;
		case ActivityType.SCRIPT_VALUE:
			//script
			ok&= self.getScript() != null;
			break;
		case ActivityType.MANUAL_VALUE:
			//none (performers*)
			break; 
		}
		return ok;
	}
	
	/**
	 * Not all Attributes that are required for the given Gateway Type are set.
	 */
	public static Boolean gatewayType(Gateway self) {
		boolean ok= true;
		switch (self.getGatewayType().getValue()) {
		case GatewayType.XOR_DATA_VALUE:
		case GatewayType.XOR_EVENT_VALUE:
			// (instantiate)
		case GatewayType.OR_VALUE:
		case GatewayType.AND_VALUE:
			//none
			break;
		case GatewayType.COMPLEX_VALUE:
			//incoming and outgoing condition
			ok&= self.getIncomingSeq().size() > 1 ? self.getIncomingCondition() != null : true;
			ok&= self.getOutgoingSeq().size() > 1 ? self.getOutgoingCondition() != null : true;
			break;
		}
		return ok;
	}
	
	/**
	 * If the AdHoc Flag is set the other AdHoc Attributes have to be specified, too.
	 */
	public static Boolean absProcAdHoc(AbstractProcess self) {
		if (self instanceof Activity) {
			//if not embedded subprocess ignore adHoc attribute
			if (((Activity) self).getActivityType() != ActivityType.EMBEDDED) {
				return true;
			}
		}
		if (self.isAdHoc()) {
			return self.getAdHocCompletionCondition() != null && self.getAdHocCompletionCondition().getExpression() != null;
		}
		return true;
	}
}
