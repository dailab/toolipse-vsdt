package de.dailab.vsdt.trafo.text.export.stages;

import java.util.Iterator;
import java.util.Random;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.image.ImageFileFormat;
import org.eclipse.gmf.runtime.diagram.ui.render.util.CopyToImageUtil;
import org.eclipse.gmf.runtime.notation.Diagram;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.BpmnProcess;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.MultiLoopAttSet;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.logger.TrafoLog;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;

/**
 * BPMN to Text visitor. This visitor is performing a top-down pass of the BPMN 
 * model.  This way it creates a textual representation for all the elements 
 * passed on the way.  The Text is structured according to the process structure
 * using the TextBuilders {@link TextBuilder#beginBlock()} methods.  How this
 * will then be realized is up to the TextBuilder, e.g. using indentation, or 
 * retractable boxes.  In other regards the transformation is not much different
 * from other transformation.
 * 
 * @author tkuester
 */
public class Bpmn2TextElementMapping extends MappingStage {

	public static final String FORMAT_PLAIN= "Plain Text";
	public static final String FORMAT_HTML= "HTML";
	public static final String FORMAT_LATEX= "Latex";
	
	/** text format to use, determining the {@link #builder}, and other options */
	public static String textFormat= FORMAT_HTML;
	public static boolean longDocumentation= true;
	public static boolean integrateScreenshot= true;
	
	/** random number generator for random selection of synonymous terms */
	private Random random;
	
	/** this is used for generating certain text building blocks */
	private TextBuilder builder;
	
	@Override
	public void initialize() {
		// initialize random number generator with fixed seed, so the numbers are random but the 
		// same each time the transformation is performed, so the results are easier to compare.
		random= new Random(0);
		if (FORMAT_PLAIN.equals(textFormat)) {
			builder= new TextBuilder();
		}
		if (FORMAT_HTML.equals(textFormat)) {
			builder= new HtmlBuilder();			
		}
		if (FORMAT_LATEX.equals(textFormat)) {
			builder= new LatexBuilder();			
		}
	}
	
	@Override
	protected boolean internalApply() {
		BusinessProcessSystem bps= (BusinessProcessSystem) wrapper.getSourceModel();
		builder.setName(bps.getName());
		wrapper.getTargetModels().add(builder);
		visitBusinessProcessSystem(bps);
		return true;
	}

	//////////////////////////////////////////////////////////
	// VISITOR LOGIC
	//////////////////////////////////////////////////////////

	/**
	 * Start the visitor's pass at the top-level business process system. Print 
	 * general information about the system and delegate to the several processes.
	 * This method should also handle supporting types (participants, services, etc.).
	 * 
	 * @param bps	The {@link BusinessProcessSystem} to be mapped
	 */
	protected void visitBusinessProcessSystem(BusinessProcessSystem bps) {
		builder.appendHeader(bps.getName());

		// Business Process Meta Information
		builder.appendTitle(bps.getName(), 0, null);
		builder.beginItemize();
		builder.appendItem("Author: " + bps.getAuthor());
		builder.appendItem("Version: " + bps.getVersion());
		builder.appendItem("Created: " + bps.getCreationDate());
		builder.appendItem("Modified: " + bps.getModificationDate());
		builder.endItemize();
		if (bps.getDocumentation() != null) {
			builder.append(bps.getDocumentation());
			builder.newLine();
		}

		// screen shot of meta diagram
		if (integrateScreenshot) {
			integrateScreenshot(bps);
		}
		
		// TODO short summary of Meta diagram: relation of participants and processes
		
		// Structured Text for individual BPMN Diagrams
		for (BusinessProcessDiagram bpd : bps.getBusinessProcesses()) {
			visitBusinessProcessDiagram(bpd);
		}
		
		// TODO Paragraphs for Supporting Types, e.g. Messages, Services
		
		builder.appendFooter();
	}
		
	/**
	 * Print the title and description of the process, then delegate to the Pools.
	 * 
	 * @param bpd	The {@link BusinessProcessDiagram} to be mapped 	
	 */
	private void visitBusinessProcessDiagram(BusinessProcessDiagram bpd) {
		builder.appendTitle(bpd.getName(), 1, bpd.getId());
		
		if (bpd.getDocumentation() != null) {
			builder.append( doc(bpd.getDocumentation()) );
			builder.newLine();
		}

		// screen shot of BPMN diagram
		if (integrateScreenshot) {
			integrateScreenshot(bpd);
		}

		// create Structured Text for each Pool
		for (Pool pool : bpd.getPools()) {
			visitPool(pool);
		}

		// Paragraphs for Individual Activities
		if (longDocumentation) {
			builder.appendTitle("Activity Descriptions", 2, null);
			
			for (Iterator<EObject> iter= bpd.eAllContents(); iter.hasNext(); ) {
				EObject next= iter.next();
				if (next instanceof Activity) {
					Activity activity = (Activity) next;
					
					// activity name and documentation
					builder.appendTitle(activity.getName(), 3, activity.getId());
					if (activity.getDocumentation() != null) {
						builder.append(activity.getDocumentation());
					}

					// details table
					builder.beginTable();
					if (activity.getPool().getParticipant() != null) {
						builder.appendTableLine("Participant:", activity.getPool().getParticipant().getName());
					}
					if (activity.getInMessage() != null) {
						builder.appendTableLine("Sending Message:", activity.getInMessage().getName());
					}
					if (activity.getOutMessage() != null) {
						builder.appendTableLine("Receiving Message:", activity.getOutMessage().getName());
					}
					// TODO input, output
					builder.endTable();
				}
			}
		}
	}
	
	/**
	 * Print general information about the Pool, its Participant and Process
	 * and delegate to the FlowObjects contained in that Process, if any.
	 * 
	 * Currently, the Pool's Process's Properties and Assignments are not 
	 * described, but this may be an option for the future.
	 * 
	 * @param pool		Some {@link Pool}
	 */
	public void visitPool(Pool pool) {
		builder.appendTitle(pool.getName(), 2, pool.getId());
		
		if (pool.getParticipant() != null) {
			builder.append("The Pool '" + name(pool.getName()) + "' belongs to " +
					"Participant '" + name(pool.getParticipant().getName()) + "'. ");
		}
		if (pool.getDocumentation() != null) {
			builder.append( doc(pool.getDocumentation()) );
			builder.newLine();
		}
		if (pool.getLanes().size() > 1) {
			builder.append("This Pool is made up of " + pool.getLanes().size() + 
					" Lanes:");
			builder.beginItemize();
			for (Lane lane : pool.getLanes()) {
				builder.appendItem(name(lane.getName()) + 
						(lane.getDocumentation() != null? ": " + doc(lane.getDocumentation()) : ""));
			}
			builder.endItemize();
		}
		
		if (pool.getProcess() != null) {
			BpmnProcess proc= pool.getProcess();
			builder.append("The Pool's Process is" + (proc.isAdHoc() ? 
					" ad-hoc and is" : "") + " of type " + type(proc.getProcessType()) + ".");
			/*
			 * process properties and assignments
			 */
			if (! proc.getGraphicalElements().isEmpty()) {
				builder.append(" In that Process, ");
				for (Iterator<FlowObject> iter= proc.getGraphicalElements().iterator(); iter.hasNext();) {
					visitFlowObject(iter.next());
					if (iter.hasNext()) {
						builder.append(getRandomParallelTerm());
					}
				}
			}
		}
		builder.newLine();
	}
	
	/**
	 * Delegate to specialized methods.  For all FlowObject printing methods,
	 * the beginning of the sentence is determined by the context, i.e. the 
	 * calling method, and can be for instance "Afterwards ", "In Parallel ", 
	 * or "The Process will be interrupted, if ".  Thus the sentences should 
	 * generally fit to this condition and start with a lower case letter.
	 * 
	 * Currently, the FlowObjects Assignments are not described, but this may 
	 * be an option for the future.
	 * 
	 * @param flowObject	Some {@link FlowObject}
	 */
	private void visitFlowObject(FlowObject flowObject) {
		if (flowObject == null) return;
		
		//delegate to specialized methods
		if (flowObject instanceof Event) {
			Event event= (Event) flowObject;
			visitEvent(event,null, false);
		}
		if (flowObject instanceof Activity) {
			Activity activity=(Activity) flowObject;
			visitActivity(activity);
		}
		if (flowObject instanceof Gateway) {
			Gateway gateway= (Gateway) flowObject;
			visitGateway(gateway);
		}
		//special structured BPMN elements
		if (flowObject instanceof BpmnSequence) {
			BpmnSequence bpmnSequence = (BpmnSequence) flowObject;
			visitBpmnSequence(bpmnSequence);
		}
		if (flowObject instanceof BpmnBlock) {
			BpmnBlock bpmnBlock = (BpmnBlock) flowObject;
			visitBpmnBlock(bpmnBlock);
		}
		if (flowObject instanceof BpmnLoopBlock) {
			BpmnLoopBlock bpmnLoopBlock = (BpmnLoopBlock) flowObject;
			visitBpmnLoopBlock(bpmnLoopBlock);
		}
		if (flowObject instanceof BpmnDerivedProcess) {
//			BpmnDerivedProcess bpmnDerivedProcess = (BpmnDerivedProcess) flowObject;
//			script= visitBpmnDerivedProcess(bpmnDerivedProcess);
		}
		if (flowObject instanceof BpmnEventHandlerBlock) {
			BpmnEventHandlerBlock eventHandlerBlock = (BpmnEventHandlerBlock) flowObject;
			visitBpmnEventHandlerBlock(eventHandlerBlock);
		}
		if (flowObject instanceof BpmnElementToSkip) {
			BpmnElementToSkip bpmnElementToSkip = (BpmnElementToSkip) flowObject;
			visitBpmnElementToSkip(bpmnElementToSkip);
		}
		/*
		 * assignments
		 */
	}
	
	/**
	 * Print what <em>happens</em> in this Event.  The sentences have the form
	 * "... in Event X this and this happens. [Documentation]".  This method 
	 * will be called for each Event and for each trigger component in a 
	 * multiple trigger Event.
	 * 
	 * @param event			Some {@link Event}
	 * @param multiType		null, or the trigger type to handle next for a 
	 * 						multiple trigger event
	 * @param boundary		attached to an activity boundary?
	 */
	private void visitEvent(Event event, TriggerType multiType, boolean boundary) {
		final boolean throwing= event.isThrowing();
		if (multiType == null && event.getName() != null) {
			// print this only the first time for a multi event
			builder.append("in Event '" + name(event.getName()) + "', ");
		}
		
		TriggerType trigger= multiType != null ? multiType : event.getTrigger();
		switch (trigger) {
		case NONE:
			builder.append("nothing special happens");
			break;
		case MESSAGE:
			Message msg= event.getMessage();
			Implementation impl= event.getImplementation();
			builder.append(getString(msg));
			if (event.getImplementation() != null) {
				builder.append(" of " + getString(impl));
			}
			builder.append(" is " + (throwing ? "sent" : "received"));
//			if (msg != null && msg.getFrom() != null && msg.getTo() != null) {
//				builder.append(" " + (throwing ? " to Participant " + highlight(msg.getTo().getName())
//						: " from Participant " + highlight(msg.getFrom().getName())));
//			}
			break;
		case TIMER:
			boolean cyclic= event.getTimeCycle() != null;
			Expression timeExpression= (cyclic ? event.getTimeCycle() : event.getTimeDate());
			String time= timeExpression != null? code(timeExpression.getExpression()) : " an unspecified time"; 
			if (event instanceof Intermediate) {
				if (boundary) {
					builder.append("the Activity is interrupted " + (cyclic?"after ":"at ")+time);
				} else {
					builder.append("the Process will wait " + (cyclic?"for ":"until ")+time);
				}
			} else {
				builder.append("the Process will start " + (cyclic?"regularly after ":"at ")+time);
			}
			break;
		case LINK:
			if (throwing && event.getLinkedTo() != null) {
				String linkEnd = event.getLinkedTo().getName() != null ? "Event " + name(event.getLinkedTo().getName())
						                                               : "the other end of the link";
				builder.append("the Process will continue at " + linkEnd);
			}
			break;
		case ERROR:
			builder.append("an error ");
			if (event.getErrorCode() != null) {
				builder.append("with error code '" + code(event.getErrorCode()) + "' ");
			}
			builder.append("is " + (event.isThrowing() ? "thrown" : "caught"));
			break;
		case TERMINATE:
			builder.append("the Process will terminate");
			break;
		case RULE:
			String ruleName= event.getRuleName();
			if (event instanceof Intermediate) {
				if (boundary) {
					builder.append("the Activity is interrupted when ");
				} else {
					builder.append("the Process will wait until ");
				}
			} else {
				builder.append("the Process will start when ");
			}
			builder.append((ruleName != null ? "the Rule " + name(ruleName) : "a Rule") + " applies");
			// append rule expression for more details?
			break;
		case SIGNAL:
			String s= event.getSignal();
			builder.append((s != null ? "a Signal" : "the Signal '" + name(s) + "'") + 
					" is " + (throwing ? "sent" : "received"));
			break;
		case CANCEL:
			builder.append("the Transaction is cancelled");
			break;
		case COMPENSATION:
			builder.append( (event.getActivity() != null ? "the Activity " + 
					name(event.getActivity().getName()) : "an Activity ") +  
					(throwing ? "is" : "will be") + " compensated");
		case MULTIPLE:
			boolean isNotFirst= false;
			if (event.getMessage() != null && event.getImplementation() != null) {
				if (isNotFirst) builder.append(" and ");
				isNotFirst= true;
				visitEvent(event, TriggerType.MESSAGE, boundary);
			}
			if (event.getErrorCode() != null) {
				if (isNotFirst) builder.append(" and ");
				isNotFirst= true;
				visitEvent(event, TriggerType.ERROR, boundary);
			}
			if (event.getActivity() != null) {
				if (isNotFirst) builder.append(" and ");
				isNotFirst= true;
				visitEvent(event, TriggerType.COMPENSATION, boundary);
			}
			if (event.getLinkedTo() != null) {
				if (isNotFirst) builder.append(" and ");
				isNotFirst= true;
				visitEvent(event, TriggerType.LINK, boundary);
			}
			if (event.getSignal() != null) {
				if (isNotFirst) builder.append(" and ");
				isNotFirst= true;
				visitEvent(event, TriggerType.SIGNAL, boundary);
			}
			if (event.getTimeCycle() != null || event.getTimeDate() != null) {
				if (isNotFirst) builder.append(" and ");
				isNotFirst= true;
				visitEvent(event, TriggerType.TIMER, boundary);
			}
			if (event.getRuleName() != null || (event.getRuleExpression() != null && event.getRuleExpression().getExpression() != null)) {
				if (isNotFirst) builder.append(" and ");
				isNotFirst= true;
				visitEvent(event, TriggerType.RULE, boundary);
			}
			break;
		}
		if (multiType == null) {
			builder.append(". ");
			// documentation
			if (event.getDocumentation() != null) {
				builder.append(doc(event.getDocumentation()) + " ");
			}
		}
	}
	
	/**
	 * Print a description of what is <em>done</em> in this activity.  The
	 * sentences will normally have the form "... activity X is executed, doing
	 * this and that. [It runs in a loop for so and so long.] [Documentation]".
	 * Further, other objects related to the activity have to be named, such as 
	 * Messages being sent. However, they should not be described to oblong,
	 * e.g. with all their properties and their context, as this may be printed
	 * over and over again and would disrupt the reading very much.
	 * 
	 * Currently, the Activity's Properties are not listed, but this may be an
	 * option for the future.
	 * 
	 * @param activity		Some {@link Activity}
	 */
	private void visitActivity(Activity activity) {
		final ActivityType type= activity.getActivityType();
		String actType= (type != ActivityType.NONE ? type(type) : "") + " Task";
		if (type == ActivityType.EMBEDDED || type == ActivityType.SUBPROCESSREFERENCE || type == ActivityType.INDEPENDENT) {
			actType= type(type) + " Subprocess";
			if (activity.getTransaction() != null) {
				actType= "Transaction";
			}
		}
		String actName = longDocumentation ? ref(name(activity.getName()), activity.getId())
		                                   :     name(activity.getName()); 
		builder.append("the " + (activity.isAdHoc()?"ad-hoc ":"")+ actType + 
				" '" + actName + "' is " + getRandomExecutedTerm());
		switch (type) {
		case NONE:
		case MANUAL:
		case EMBEDDED:
			// NONE and MANUAL require no special handling;
			// child elements of EMBEDDED subprocess are listed after the documentation
			builder.append(". ");
			break;
		case SCRIPT:
			builder.append(", running a script. ");
			// print script?
			break;
		case SERVICE:
		case USER:
			builder.append(", invoking " + getString(activity.getImplementation()));
			if (activity.getInMessage() != null || activity.getOutMessage() != null) {
				builder.append(" with ");
				if (activity.getInMessage() != null) {
					builder.append("the input Message " + name(activity.getInMessage().getName()));
					builder.append(activity.getOutMessage() != null ? " and " : "");
				}
				if (activity.getOutMessage() != null) {
					builder.append("the output Message " + name(activity.getOutMessage().getName()));
				}
			}
			builder.append(". ");
			break;
		case SEND:
		case RECEIVE:
			if (type == ActivityType.SEND) {
				builder.append(", sending " + getString(activity.getInMessage()));
			} else {
				builder.append(", receiving " + getString(activity.getOutMessage()));
			}
			if (activity.getImplementation() != null) {
				builder.append(" which belongs to " + getString(activity.getImplementation()));
			}
			builder.append(". ");
			break;
		case TASKREFERENCE:
		case SUBPROCESSREFERENCE:
			builder.append(", which references to " + (activity.getActivityRef() != null ? 
					name(activity.getActivityRef().getName()) : "another Activity") + ".");
			break;
		case INDEPENDENT:
			String processRef= activity.getProcessRef() != null 
					? "Process '" + name(activity.getProcessRef().getName()) + "'" 
					: "another Process";
			if (activity.getDiagramRef() == activity.getPool().getParentDiagram()) {
				processRef += activity.getDiagramRef() != null 
						? " in Diagram '" + name(activity.getDiagramRef().getName()) + "'" 
						: " in another Business Process Diagram";
			}
			builder.append(", which references to " + processRef + ". ");
			// for more details: Input- and OutputPropertyMaps
			break;
		}
		
		// performers (not participants)
		if (! longDocumentation && (type == ActivityType.USER || type == ActivityType.MANUAL)) {
			if (! activity.getPerformers().isEmpty()) {
				builder.append(" This Task is performed by ");
				for (Iterator<String> iter= activity.getPerformers().iterator(); iter.hasNext();) {
					builder.append(name(iter.next()) + (iter.hasNext() ? " and " : ". "));
				}
			}
		}
		
		// documentation
		if ((! longDocumentation) && activity.getDocumentation() != null) {
			builder.append(doc(activity.getDocumentation()) + " ");
		}
		
		if (activity.getActivityType() == ActivityType.EMBEDDED) {
			// child elements of the subprocess are listed after the documentation
			builder.append("In its course, ");
			for (Iterator<FlowObject> iter= activity.getGraphicalElements().iterator(); iter.hasNext();) {
				visitFlowObject(iter.next());
				if (iter.hasNext()) {
					builder.append(getRandomParallelTerm());
				}
			}
		}

		// looping
		if (activity.getLoopAttributes() != null) {
			builder.append(" The " + actType + " '" + name(activity.getName()) + 
					"' is " + getRandomExecutedTerm() + " in a loop");
			if (activity.getLoopAttributes() instanceof StandardLoopAttSet) {
				StandardLoopAttSet attSet = (StandardLoopAttSet) activity.getLoopAttributes();
				if (attSet.getLoopMaximum() > 0) {
					builder.append(" for " + attSet.getLoopMaximum() + " times");
					if (attSet.getLoopCondition() != null) {
						builder.append(" and");
					}
				}
				if (attSet.getLoopCondition() != null) {
					builder.append(" while the condition " + 
							code(attSet.getLoopCondition().getExpression()) + " holds true");
				}
				// when having more levels of detail: test time before/after
				builder.append(".");
			}
			if (activity.getLoopAttributes() instanceof MultiLoopAttSet) {
				MultiLoopAttSet attSet = (MultiLoopAttSet) activity.getLoopAttributes();
				builder.append(" for multiple instances " + (attSet.isSequential()? 
						"sequentially" : "in parallel") + ". ");
				builder.append(" The number of instances is determined by the expression" + 
						code(attSet.getMI_Condition().getExpression()) + ". ");
				// when having more levels of detail: flow condition, complex flow condition
			}
		}
	}
	
	/**
	 * If the process has been structured correctly, all remaining gateways
	 * will be used for merging normal- and exceptional flow.  Thus this is all
	 * that will be printed for a Gateway.
	 * 
	 * @param gateway	Some {@link Gateway}, most likely for merging exceptional flow
	 */
	private void visitGateway(Gateway gateway) {
		builder.append("the normal flow and the exceptional flow are merged");
		if (gateway.getName() != null) {
			builder.append(" in the Gateway '" + name(gateway.getName()) + "'");
		}
		builder.append(". ");
	}
	
	/*
	 * //////////////////////////////////////////////////////
	 * // VISITOR METHODS FOR SPECIAL STRUCTURED BPMN OBJECTS
	 * //////////////////////////////////////////////////////
	 */
	
	/**
	 * Print that a number of elements are executed in sequence and print the
	 * descriptions for these elements, separated with a random sequential term.
	 * The list of elements will be accented with a block.  If the sequence 
	 * contains only one element, just delegate to that element.
	 * 
	 * @param bpmnSequence		Some {@link BpmnSequence}
	 */
	private void visitBpmnSequence(BpmnSequence bpmnSequence) {
		if (! bpmnSequence.getElements().isEmpty()) {
			if (bpmnSequence.getElements().size() > 1) {
				builder.append("a number of elements are " +  getRandomExecutedTerm() + " in sequence. ");
				builder.beginBlock();
				builder.append("First, ");
				for (Iterator<FlowObject> iter = bpmnSequence.getElements().iterator(); iter.hasNext();) {
					visitFlowObject(iter.next());
					builder.newLine();
					if (iter.hasNext()) {
						builder.append(getRandomSequentialTerm());
					}
				}
				builder.endBlock();
			} else {
				visitFlowObject(bpmnSequence.getElements().get(0));
			}
		}
	}
	
	/**
	 * Print a description for a block of parallel or alternative branches.
	 * Depending on the type of the first Gateway, an appropriate introduction
	 * to the block will be given, followed by descriptions for the several
	 * branches, each separated with an appropriate (possibly random) term.  
	 * The beginning and the end of the block as a whole will be highlighted.
	 * 
	 * @param bpmnBlock		Some {@link BpmnBlock}
	 */
	private void visitBpmnBlock(BpmnBlock bpmnBlock) {
		Gateway fork= bpmnBlock.getFirstGateway();
		if (fork.getName() != null) {
			builder.append("starting at the Gateway '" + name(fork.getName()) + "', ");
		}
		switch (fork.getGatewayType()) {
		case AND:
			builder.append("a number of branches will be " + getRandomParallelTerm() + " in parallel: ");
			builder.beginBlock();
			builder.append("First, ");
			for (Iterator<BpmnBranch> iter = bpmnBlock.getElements().iterator(); iter.hasNext();) {
				visitFlowObject(iter.next().getElement());
				builder.newLine();
				if (iter.hasNext()) {
					builder.append(getRandomParallelTerm());
				}
			}
			builder.endBlock();
			break;
		case OR:
		case XOR_DATA:
			builder.append("one " + (fork.getGatewayType() == GatewayType.OR ?
					"or more " : "" ) + "out of several branches will be " + 
					getRandomExecutedTerm()+ ": ");
			builder.beginBlock();
			for (BpmnBranch branch : bpmnBlock.getElements()) {
				if (bpmnBlock.getDefaultElement() == branch.getElement()) {
					continue;
				}
				builder.append("If the condition '" + code(branch.getCondition().getExpression()) + 
						"' holds true, ");
				visitFlowObject(branch.getElement());
				builder.newLine();
			}
			if (bpmnBlock.getDefaultElement() != null) {
				builder.append("If no condition applies, by default ");
				visitFlowObject(bpmnBlock.getDefaultElement());
				builder.newLine();
			}
			builder.endBlock();
			break;
		case XOR_EVENT:
			builder.append("the course of the Process will depend on which of " +
					"the alternative paths can be started first (a \"race condition\").");
			builder.beginBlock();
			builder.append("Firstly, ");
			for (Iterator<BpmnBranch> iter = bpmnBlock.getElements().iterator(); iter.hasNext();) {
				FlowObject first= iter.next().getElement();
				BpmnSequence rest= null;
				if (first instanceof BpmnSequence) {
					rest= (BpmnSequence) first;
					first= rest.getElements().get(0);
					rest.getElements().remove(first);
				}
				visitFlowObject(first);
				if (rest != null) {
					builder.append("In this case, ");
					visitFlowObject(rest);
				}
				builder.newLine();
				if (iter.hasNext()) {
					builder.append(getRandomParallelTerm());
				}
			}
			builder.endBlock();
			break;
		case COMPLEX:
			boolean b= fork.getIncomingCondition() != null;
			builder.append("one " + (fork.getGatewayType() == GatewayType.OR ?
					"or more " : "" ) + "out of several branches will be " + 
					getRandomExecutedTerm() + " depending on the evaluation of " +
					(b ? "the" : "a") + " complex condition " + 
					(b ? code(fork.getIncomingCondition().getExpression()) : "") + ".");
			builder.beginBlock();
			builder.append("First, ");
			for (Iterator<BpmnBranch> iter = bpmnBlock.getElements().iterator(); iter.hasNext();) {
				visitFlowObject(iter.next().getElement());
				builder.newLine();
				if (iter.hasNext()) {
					builder.append(getRandomParallelTerm());
				}
			}
			builder.endBlock();
			break;
		}
	}
	
	/**
	 * Print a description for an upstream loop construct.  This part is a bit
	 * difficult, as this loop may consist of two parts; one being executed
	 * before testing the condition, and the other after testing the condition,
	 * starting over with the first part, which is a difficult to write.
	 * 
	 * For now this should do, but later on this is a candidate for a make over.
	 * 
	 * @param bpmnLoopBlock
	 */
	private void visitBpmnLoopBlock(BpmnLoopBlock bpmnLoopBlock) {
		boolean isUntil= bpmnLoopBlock.getSecondBranch().getCondition() == null;
		String condition= isUntil ? bpmnLoopBlock.getExitBranch().getCondition().getExpression()
				: bpmnLoopBlock.getSecondBranch().getCondition().getExpression();
		
		if (bpmnLoopBlock.getFirstGateway().getName() != null) {
			builder.append("starting at the Gateway '" + name(bpmnLoopBlock.getFirstGateway().getName()) + "', ");	
		}
		builder.append("a part of the Process will be " + getRandomExecutedTerm() + " in a loop. ");
		
		builder.append("At first, ");
		visitFlowObject(bpmnLoopBlock.getFirstBranch().getElement());
		builder.append(getRandomSequentialTerm() + "the loop condition will be tested.");
		builder.append((isUntil ? " Until" : " While" ) + " the condition " + 
				code(condition) + " holds true, the loop will continue and ");
		visitFlowObject(bpmnLoopBlock.getSecondBranch().getElement());
	}
	
	/**
	 * Print a description for an event handler block. Another part that is
	 * much easier when not generation actual code from it.  Firstly, the actual
	 * content of the event handler block is described, delegating that element,
	 * and then it is described in which ways it can be interrupted and what 
	 * will be done if this happens.
	 * 
	 * @param block		Some {@link BpmnEventHandlerBlock}
	 */
	private void visitBpmnEventHandlerBlock (BpmnEventHandlerBlock block) {
		builder.append("an interruptable region begins. ");
		builder.beginBlock();
		builder.append("Here, ");
		visitFlowObject(block.getActivity());
		builder.append("This section can be interrupted if ");
		
		for (Iterator<BpmnEventHandlerCase> iter = block.getEventHandlerCases().iterator(); iter.hasNext();) {
			BpmnEventHandlerCase eventHandlerCase= iter.next();
			visitEvent(eventHandlerCase.getIntermediate(), null, true);
			if (eventHandlerCase.getCompensationElement() != null) {
				builder.append("In this case, ");
				visitFlowObject(eventHandlerCase.getCompensationElement());
			}
			if (iter.hasNext()) {
				builder.append(getRandomParallelTerm() + "it can be interrupted if ");
			}
		}
		builder.endBlock();
	}
	
	/**
	 * Print a description for an element to skip, i.e. some part behind an 
	 * Activity with event handler before the compensation flow is merged back
	 * into the normal flow.  Basically this will delegate to the actual element
	 * and add a remark that this element will only be executed if the exception
	 * did not occur.
	 * 
	 * @param element		Some {@link BpmnElementToSkip}
	 */
	private void visitBpmnElementToSkip(BpmnElementToSkip element) {
		Intermediate intm= element.getEventHandlerCase().getIntermediate();
		visitFlowObject(element.getElement());
		builder.append("This part will only be " + getRandomExecutedTerm() + 
				" if the " + type(intm.getTrigger()) + " Event "+
				(intm.getName() != null? "'" + name(intm.getName())+ 
				"' " : "") + "has not been triggered");
	}
	

	/*
	 * ///////////////////
	 * // HELPER METHODS  
	 * ///////////////////
	 */

	/**
	 * Shortcut for getting a uniformly formatted representation for an
	 * Implementation, or null, in which case just "a Service" will be returned.
	 */
	private String getString(Implementation impl) {
		if (impl == null) {
			return "a Service";
		} else {
			return "the Service '" + name(impl.getInterface() + "." + 
					impl.getOperation()) + "'";
		}
	}
	
	/**
	 * Shortcut for getting a uniformly formatted representation for an
	 * Message, or null, in which case just "a Message" will be returned.
	 */
	private String getString(Message msg) {
		if (msg == null) {
			return "a Message";
		} else {
			return "the Message '" + name(msg.getName()) + "'";
		}
	}

	/**
	 * @return	Some random term stating that something is done sequentially, 
	 * 			e.g. "Afterwards", "Next", etc.
	 */
	private String getRandomSequentialTerm() {
		switch (random.nextInt(7)) {
		case 0: return "Afterwards, ";
		case 1: return "Thereafter, ";
		case 2: return "After that, ";
		case 3: return "Hereupon, ";
		case 4: return "Hereafter, ";
		case 5: return "Following that, ";
		default: return "Next, ";
		}
	}
	
	/**
	 * @return	Some random term stating that something is done in parallel, 
	 * 			e.g. "Besides", "Furthermore", etc.
	 */
	private String getRandomParallelTerm() {
		switch (random.nextInt(7)) {
		case 0: return "Besides, ";
		case 1: return "Further, ";
		case 2: return "Aside from that, ";
		case 3: return "More over, ";
		case 4: return "Alongside, ";
		case 5: return "Furthermore, ";
		default: return "In addition, ";
		}
	}
	
	/**
	 * @return	Some random term stating that something is executed, 
	 * 			e.g. "executed", "performed", etc.
	 */
	private String getRandomExecutedTerm() {
		switch (random.nextInt(6)) {
		case 0: return "executed";
		case 1: return "accomplished";
		case 2: return "carried out";
		case 3: return "processed";
		case 4: return "conducted";
		default: return "performed";
		}
	}
	
	/**
	 * @see TextBuilder#name(String)
	 */
	private String name(String s) {
		return s != null && ! s.isEmpty() ? builder.name(s) : "";
	}
	
	/**
	 * @see TextBuilder#ref(String, String)
	 */
	private String ref(String s, String a) {
		return s != null && ! s.isEmpty() ? builder.ref(s, a) : ""; 
	}
	
	/**
	 * @see TextBuilder#doc(String)
	 */
	private String doc(String s) {
		return s != null && ! s.isEmpty() ? builder.doc(s) : "";
	}
	
	/**
	 * @see TextBuilder#type(Enum)
	 */
	private String type(Enum e) {
		return e != null ? builder.type(e) : "";
	}

	/**
	 * @see TextBuilder#code(String)
	 */
	private String code(String s) {
		return s != null && ! s.isEmpty() ? builder.code(s) : "";
	}
	
	/**
	 * Look up the Diagram for the given EObject, if any, create an image
	 * file for it and integrate the image file in the text output.
	 * This method will actually not create the image file, but only the
	 * image data, and pass it to the ExportWrapper, so the ResultSaver
	 * can then save the image to the appropriate path.
	 * 
	 * @param diagramElement	BusinessProcessDiagram or BusinessProcessSystem to make a picture from
	 * @return					creation of image successful?
	 */
	private boolean integrateScreenshot(IdObject diagramElement) {
		// get resource from EObject
		final Resource resource= diagramElement.eResource();
		if (resource != null) {
			// create diagrams from resource
			for (Object o : resource.getContents()) {
				if (o instanceof Diagram && ((Diagram) o).getElement() == diagramElement) {
					// generating the pictures can take some time, so we print a log info...
					TrafoLog.info("Generating picture for diagram " + diagramElement.getName());
					
					// create image from diagram
					ImageFileFormat format= ImageFileFormat.PNG;
					String path= diagramElement.getName() + "." + format.getName().toLowerCase();
					
					TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resource.getResourceSet());
					try {
						byte[] imageData= new CopyToImageUtil().copyToImageByteArray(
								(Diagram) o, -1, -1, format, new NullProgressMonitor(), 
								new PreferencesHint("de.dailab.vsdt.diagram"), true);
						((TextExportWrapper) Bpmn2TextElementMapping.this.wrapper).addImage(path, imageData);
					} catch (Exception e) {
						e.printStackTrace();
					}
					String label= diagramElement.eClass().getName() + " '" + diagramElement.getName() + "'";
					builder.appendImage(path, label);
					return true;
				}
			}
		}
		return false;
	}
	
}
