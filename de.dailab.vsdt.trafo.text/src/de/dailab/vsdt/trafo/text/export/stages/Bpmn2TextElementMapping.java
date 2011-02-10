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
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.MultiLoopAttSet;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;
import de.dailab.vsdt.trafo.strucbpmn.export.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.FinalGatewayRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InitialGatewayRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InsertEmptyRule;

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
				if (next instanceof Activity && shallBeVisited((Activity) next)) {
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
//					if (activity.getInMessage() != null) {
//						builder.appendTableLine("Sending Message:", activity.getInMessage().getName());
//					}
//					if (activity.getOutMessage() != null) {
//						builder.appendTableLine("Receiving Message:", activity.getOutMessage().getName());
//					}
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
		
		builder.append("The Process is" + (pool.isAdHoc() ? 
				" ad-hoc and is" : "") + " of type " + type(pool.getProcessType()) + ".");
		/*
		 * process properties and assignments
		 */
		if (! pool.getGraphicalElements().isEmpty()) {
			String beginning= " In this Process, ";
			for (FlowObject flowObject : pool.getGraphicalElements()) {
				if (visitFlowObject(flowObject, beginning, false)) {
					beginning= getRandomParallelTerm();
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
	 * Before delegating to the specialized methods, this method will determine
	 * whether the FlowObject should be visited at all. For example, generated
	 * Gateways and No-Op-Activities are not visited. In this case, the beginning
	 * of the sentence is dismissed.
	 * 
	 * Currently, the FlowObjects Assignments are not described, but this may 
	 * be an option for the future.
	 * 
	 * @param flowObject		Some {@link FlowObject}
	 * @param beginning			the beginning of the sentence
	 * @param partialSentence	whether the description of the flow object is part 
	 *                          of a longer sentence or a sentence on its own
	 */
	private boolean visitFlowObject(FlowObject flowObject, String beginning, boolean partialSentence) {
		if (flowObject == null) return false;
		
		// check whether FlowObject shall be visited
		if (shallBeVisited(flowObject)) {
			if (beginning != null) {
				builder.append(beginning);
			}

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
//				BpmnDerivedProcess bpmnDerivedProcess = (BpmnDerivedProcess) flowObject;
//				script= visitBpmnDerivedProcess(bpmnDerivedProcess);
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
			return true;
		} else {
			// dismiss / close sentence
			if (partialSentence) {
				builder.append(". ");
			}
			return false;
		}
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
			builder.append("in Event '" + name(event.getName()) + "' ");
		}
		
		TriggerType trigger= multiType != null ? multiType : event.getTrigger();
		switch (trigger) {
		case NONE:
			builder.append("nothing special happens");
			break;
		case MESSAGE:
			Implementation impl= event.getImplementation();
			builder.append(getMessageString(impl, event.getPool().getParticipant(), ! throwing));
			builder.append(" is " + (throwing ? "sent" : "received"));
			break;
		case TIMER:
			String time= event.getTimeExpression() == null? "an unspecified time"
					: code(event.getTimeExpression().getExpression()); 
			if (! boundary) {
				builder.append("the Process waits " + (event.isAsDuration() ? "for ":"until "));
			}
			builder.append(time);
			if (boundary) {
				builder.append(event.isAsDuration() ? "elapsed" : "is reached");
			}
			break;
		case LINK:
			if (throwing && event.getLinkedTo() != null) {
				String linkEnd = event.getLinkedTo().getName() != null ? "Event " + name(event.getLinkedTo().getName())
						                                               : "the other end of the link";
				builder.append("the Process continues at " + linkEnd);
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
			builder.append("the Process terminates");
			break;
		case RULE:
			// append rule expression for more details?
			String rule= null; // event.getRuleExpression().getExpression();
			if (! boundary) {
				builder.append("the Process waits until ");
			}
			builder.append((rule != null ? "the Rule " + code(rule) : "a Rule") + " applies");
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
			if (event.getImplementation() != null) {
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
			if (event.getTimeExpression() != null && event.getTimeExpression().getExpression() != null) {
				if (isNotFirst) builder.append(" and ");
				isNotFirst= true;
				visitEvent(event, TriggerType.TIMER, boundary);
			}
			if (event.getRuleExpression() != null && event.getRuleExpression().getExpression() != null) {
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
		if (type == ActivityType.EMBEDDED) {
			actType= type(type) + " Subprocess";
			if (activity.getTransaction() != null) {
				actType= "Transaction";
			}
		}
		String actName = longDocumentation ? ref(name(activity.getName()), activity.getId())
		                                   :     name(activity.getName()); 
		builder.append("the " + (activity.isAdHoc()?"ad-hoc ":"")+ actType + 
				" '" + actName + "' is " + getRandomExecutedTerm());
		if (activity.getAdHocCompletionCondition() != null) {
			builder.append(" until the completion condition '" + 
					code(activity.getAdHocCompletionCondition().getExpression()) + "' applies");
		}
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
			Service service = activity.getImplementation() instanceof Service ?
					(Service) activity.getImplementation() : null; 
			builder.append(", invoking " + getString(service));
//			if (activity.getInMessage() != null || activity.getOutMessage() != null) {
//				builder.append(" with ");
//				if (activity.getInMessage() != null) {
//					builder.append("the input Message " + name(activity.getInMessage().getName()));
//					builder.append(activity.getOutMessage() != null ? " and " : "");
//				}
//				if (activity.getOutMessage() != null) {
//					builder.append("the output Message " + name(activity.getOutMessage().getName()));
//				}
//			}
			builder.append(". ");
			break;
		case SEND:
		case RECEIVE:
			boolean incoming = type == ActivityType.RECEIVE;
			builder.append(", " + (incoming ? "receiving" : "sending") + " ");
			builder.append(getMessageString(activity.getImplementation(), activity.getPool().getParticipant(), incoming));
			builder.append(". ");
			break;
		case CALL:
			String calledElement = "another Process Element";
			if (activity.getCalledElement() instanceof Activity) {
				Activity other = (Activity) activity.getCalledElement();
				calledElement = "the Activity " + other.getName();
			} else if (activity.getCalledElement() instanceof Pool) {
				Pool other = (Pool) activity.getCalledElement();
				calledElement = "the Pool " + other.getName() + " in the Process Diagram " + other.getParent().getName();
			}
			builder.append(", which references " + calledElement + ".");
			break;
//		case INDEPENDENT:
//			String processRef= activity.getProcessRef() != null 
//					? "Process '" + name(activity.getProcessRef().getName()) + "'" 
//					: "another Process";
//			if (activity.getDiagramRef() == activity.getPool().getParent()) {
//				processRef += activity.getDiagramRef() != null 
//						? " in Diagram '" + name(activity.getDiagramRef().getName()) + "'" 
//						: " in another Business Process Diagram";
//			}
//			builder.append(", which references to " + processRef + ". ");
//			// for more details: Input- and OutputPropertyMaps
//			break;
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
			String beginning= "In its course, ";
			for (FlowObject flowObject : activity.getGraphicalElements()) {
				if (visitFlowObject(flowObject, beginning, false)) {
					beginning= getRandomParallelTerm();
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
				String beginning= "First, ";
				for (FlowObject flowObject : bpmnSequence.getElements()) {
					if (visitFlowObject(flowObject, beginning, false)) {
						beginning= getRandomSequentialTerm();
					}
					builder.newLine();
				}
				builder.endBlock();
			} else {
				visitFlowObject(bpmnSequence.getElements().get(0), null, false);
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
		if (fork.getName() != null && shallBeVisited(fork)) {
			builder.append("starting at the Gateway '" + name(fork.getName()) + "', ");
		}
		String beginning;
		switch (fork.getGatewayType()) {
		case AND:
			builder.append("a number of branches will be " + getRandomParallelTerm() + " in parallel: ");
			builder.beginBlock();
			beginning= "First, ";
			for (BpmnBranch branch : bpmnBlock.getElements()) {
				if (visitFlowObject(branch.getElement(), beginning, false)) {
					beginning= getRandomParallelTerm();
				}
				builder.newLine();
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
				if (! visitFlowObject(branch.getElement(), null, false)) {
					builder.append("nothing happens. ");
				}
				builder.newLine();
			}
			if (bpmnBlock.getDefaultElement() != null) {
				builder.append("If no condition applies, by default ");
				if (! visitFlowObject(bpmnBlock.getDefaultElement(), null, false)) {
					builder.append("nothing happens. ");
				}
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
				visitFlowObject(first, null, false);
				if (rest != null) {
					visitFlowObject(rest, "In this case, ", false);
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
			beginning= "First, ";
			for (BpmnBranch branch : bpmnBlock.getElements()) {
				if (visitFlowObject(branch.getElement(), beginning, false)) {
					beginning= getRandomParallelTerm();
				}
				builder.newLine();
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
		
		if (bpmnLoopBlock.getFirstGateway().getName() != null && shallBeVisited(bpmnLoopBlock.getFirstGateway())) {
			builder.append("starting at the Gateway '" + name(bpmnLoopBlock.getFirstGateway().getName()) + "', ");	
		}
		builder.append("a part of the Process will be " + getRandomExecutedTerm() + " in a loop. ");
		builder.beginBlock();
		String beginning= "At first, ";
		if (visitFlowObject(bpmnLoopBlock.getFirstBranch().getElement(), beginning, false)) {
			beginning= getRandomSequentialTerm() + "the loop condition will be tested.";
		}
		builder.append(beginning);
		builder.append((isUntil ? " Until" : " While" ) + " the condition " + 
				code(condition) + " holds true, the loop will continue");
		visitFlowObject(bpmnLoopBlock.getSecondBranch().getElement(), " and ", true);
		builder.endBlock();
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
		visitFlowObject(block.getActivity(), "Here, ", false);
		
		builder.append("This section can be interrupted if ");
		for (Iterator<BpmnEventHandlerCase> iter = block.getEventHandlerCases().iterator(); iter.hasNext();) {
			BpmnEventHandlerCase eventHandlerCase= iter.next();
			visitEvent(eventHandlerCase.getIntermediate(), null, true);
			if (eventHandlerCase.getCompensationElement() != null) {
				visitFlowObject(eventHandlerCase.getCompensationElement(), "In this case, ", false);
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
		visitFlowObject(element.getElement(), null, false);
		builder.append("This part will only be " + getRandomExecutedTerm() + 
				" if the " + type(intm.getTrigger()) + " Event "+
				(intm.getName() != null? "'" + name(intm.getName())+ 
				"' " : "") + "has not been triggered. ");
	}
	

	/*
	 * ///////////////////
	 * // HELPER METHODS  
	 * ///////////////////
	 */
	
	private String getMessageString(Implementation implementation, Participant self, boolean incoming) {
		if (implementation instanceof Service) {
			Service service = (Service) implementation;
			boolean isRequest = isRequest(service, self, incoming);
			return "a " + (isRequest ? "request" : "response") + " for " + getString(service);
		} else
		if (implementation instanceof MessageChannel) {
			MessageChannel channel = (MessageChannel) implementation;
			return getString(channel);
		} else {
			return "some message";
		}
	}
	
	/**
	 * Check whether the given service is being requested, or if a response to
	 * the service is sent. Assuming that requester and provider are not the
	 * same participant.
	 */
	private boolean isRequest(Service service, Participant self, boolean incoming) {
		boolean isSameParticipant = service.getParticipant() == self;
		return incoming == isSameParticipant;
	}

	/**
	 * Shortcut for getting a uniformly formatted representation for an
	 * Implementation, or null, in which case just "a Service" will be returned.
	 */
	private String getString(Service service) {
		if (service != null) {
			return "the Service '" + name(service.getInterface() + "." + 
					service.getOperation()) + "'";
		} else {
			return "a Service";
		}
	}
	
	/**
	 * Shortcut for getting a uniformly formatted representation for an
	 * Message, or null, in which case just "a Message" will be returned.
	 */
	private String getString(MessageChannel channel) {
		if (channel != null && channel.getChannel() != null) {
			return "the MessageChannel '" + name(channel.getChannel().getExpression()) + "'";
		} else {
			return "a MessageChannel";
		}
	}

	/**
	 * @return	Some random term stating that something is done sequentially, 
	 * 			e.g. "Afterwards", "Next", etc.
	 */
	private String getRandomSequentialTerm() {
		String[] terms = new String[] {
				"Afterwards, ",
				"Thereafter, ",
				"After that, ",
				"Hereupon, ",
				"Hereafter, ",
				"Following that, ",
				"Next, "
		};
		return terms[random.nextInt(terms.length)];
	}
	
	/**
	 * @return	Some random term stating that something is done in parallel, 
	 * 			e.g. "Besides", "Furthermore", etc.
	 */
	private String getRandomParallelTerm() {
		String[] terms = new String[] {
				"Besides, ",
				"Further, ",
				"Aside from that, ",
				"More over, ",
				"Alongside, ",
				"Furthermore, ",
				"In addition, "
		};
		return terms[random.nextInt(terms.length)];
	}
	
	/**
	 * @return	Some random term stating that something is executed, 
	 * 			e.g. "executed", "performed", etc.
	 */
	private String getRandomExecutedTerm() {
		String[] terms = new String[] {
				"executed",
				"accomplished",
				"carried out", 
				"processed",
				"conducted",
				"performed"
		};
		return terms[random.nextInt(terms.length)];
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
	private String type(Enum<?> e) {
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
	
	/**
	 * Determine whether the given FlowObject shall be visited. Examples for FlowObjects,
	 * which shall not be visited, are:
	 * - No-Op Activity inserted during Structure Mapping
	 * - additional Gateways inserted during Structure Mapping
	 * - Events w/o name and documentation and with trigger type None
	 * - container types (e.g. ElementToSkip) if the contained element is not to be visited
	 * 
	 * @param flowObject	some flow object
	 * @return				whether the flow object shall be visited
	 */
	private boolean shallBeVisited(FlowObject flowObject) {
		if (flowObject == null) return false;
		
		// Activity: No-Op Activities inserted in Structure Mapping shall not be visited 
		if (flowObject instanceof Activity) {
			Activity activity = (Activity) flowObject;
			return activity.getName() != InsertEmptyRule.EMPTY_NAME;
		}

		// Events: do not visit completely unlabeled Events with trigger type None 
		if (flowObject instanceof Event) {
			Event event = (Event) flowObject;
			return ! (event.getName() == null && event.getDocumentation() == null &&
					event.getTrigger() == TriggerType.NONE);
		}
		
		// Gateways: Additional Gateways inserted in Structure Mapping shall not be visited
		if (flowObject instanceof Gateway) {
			String name= ((Gateway) flowObject).getName();
			return name != FinalGatewayRule.FINAL_GATEWAY &&
			       name != InitialGatewayRule.INITIAL_GATEWAY &&
			       ! (name != null && (name.endsWith(AbstractVsdtRule.SUFFIX_FORK) || 
			                           name.endsWith(AbstractVsdtRule.SUFFIX_MERGE)));
		}
		
		// Sequence: if the sequence has only one element, check this element
		if (flowObject instanceof BpmnSequence) {
			BpmnSequence sequence = (BpmnSequence) flowObject;
			if (sequence.getElements().size() == 1) {
				return shallBeVisited(sequence.getElements().get(0));
			}
		}

		// Element-To-Skip-Container: check whether the contained FloObject shall be visited
		if (flowObject instanceof BpmnElementToSkip) {
			return shallBeVisited(((BpmnElementToSkip) flowObject).getElement());
		}
		
		return true;
	}
}
