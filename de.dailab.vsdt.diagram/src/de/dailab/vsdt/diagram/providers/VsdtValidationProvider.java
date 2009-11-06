package de.dailab.vsdt.diagram.providers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;

import de.dailab.vsdt.AbstractProcess;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.End;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.diagram.custom.MyJavaAudits;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.part.ValidateAction;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;
import de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry;

/**
 * @generated
 */
public class VsdtValidationProvider extends AbstractContributionItemProvider {

	/**
	 * @generated
	 */
	private static boolean constraintsActive = false;

	/**
	 * @generated
	 */
	public static boolean shouldConstraintsBePrivate() {
		return false;
	}

	/**
	 * @generated
	 */
	public static void runWithConstraints(
			TransactionalEditingDomain editingDomain, Runnable operation) {
		final Runnable op = operation;
		Runnable task = new Runnable() {
			public void run() {
				try {
					constraintsActive = true;
					op.run();
				} finally {
					constraintsActive = false;
				}
			}
		};
		if (editingDomain != null) {
			try {
				editingDomain.runExclusive(task);
			} catch (Exception e) {
				VsdtDiagramEditorPlugin.getInstance().logError(
						"Validation failed", e); //$NON-NLS-1$
			}
		} else {
			task.run();
		}
	}

	/**
	 * @generated
	 */
	protected IAction createAction(String actionId,
			IWorkbenchPartDescriptor partDescriptor) {
		if (ValidateAction.VALIDATE_ACTION_KEY.equals(actionId)) {
			return new ValidateAction(partDescriptor);
		}
		return super.createAction(actionId, partDescriptor);
	}

	/**
	 * @generated
	 */
	static boolean isInDefaultEditorContext(Object object) {
		if (shouldConstraintsBePrivate() && !constraintsActive) {
			return false;
		}
		if (object instanceof View) {
			return constraintsActive
					&& BusinessProcessDiagramEditPart.MODEL_ID
							.equals(VsdtVisualIDRegistry
									.getModelID((View) object));
		}
		return true;
	}

	/**
	 * @generated
	 */
	public static class DefaultCtx implements IClientSelector {

		/**
		 * @generated
		 */
		public boolean selects(Object object) {
			return isInDefaultEditorContext(object);
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter1 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			BusinessProcessDiagram context = (BusinessProcessDiagram) ctx
					.getTarget();
			if (MyJavaAudits.bpd1max1PoolInvisible(context)) {
				return ctx.createSuccessStatus();
			} else {
				/*
				 * XXX maybe change this to 
				 * ctx.createFailureStatus(new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true) });
				 * or
				 * ctx.createFailureStatus(null);
				 * for backward-compatibility with Eclipse 3.3
				 */
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter2 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Event context = (Event) ctx.getTarget();
			if (MyJavaAudits.event1outgoingAreUnconditioned(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter3 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Event context = (Event) ctx.getTarget();
			if (MyJavaAudits.eventTriggerAttributes(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}
	
	/**
	 * @generated
	 */
	public static class Adapter4 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Event context = (Event) ctx.getTarget();
			if (MyJavaAudits.eventTriggerAllowed(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter5 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Activity context = (Activity) ctx.getTarget();
			if (MyJavaAudits.act1IsAtomicOrEmbedded(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter6 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Activity context = (Activity) ctx.getTarget();
			if (MyJavaAudits.act2TaskSingleMessage(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter7 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Activity context = (Activity) ctx.getTarget();
			if (MyJavaAudits.act3CompensationNoOutgoingSeq(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter8 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Activity context = (Activity) ctx.getTarget();
			if (MyJavaAudits.act4startQuantityNotLowerThanOne(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter9 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Activity context = (Activity) ctx.getTarget();
			if (MyJavaAudits.activityType(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter10 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			AbstractProcess context = (AbstractProcess) ctx.getTarget();
			if (MyJavaAudits.proc1startAndEnd(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter11 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			AbstractProcess context = (AbstractProcess) ctx.getTarget();
			if (MyJavaAudits.proc2noPseudoStarts(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter12 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			AbstractProcess context = (AbstractProcess) ctx.getTarget();
			if (MyJavaAudits.proc3NoPseudoEnds(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter13 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			AbstractProcess context = (AbstractProcess) ctx.getTarget();
			if (MyJavaAudits.absProcAdHoc(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter14 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Gateway context = (Gateway) ctx.getTarget();
			if (MyJavaAudits.gate1noMessageFlows(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter15 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Gateway context = (Gateway) ctx.getTarget();
			if (MyJavaAudits.gate2AndNoOutgoingConditional(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter16 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Gateway context = (Gateway) ctx.getTarget();
			if (MyJavaAudits.gate3XOREventOutgoingConditonNone(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter17 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Gateway context = (Gateway) ctx.getTarget();
			if (MyJavaAudits
					.gate4XOREventOutgoingTargetRecMsgTimerRuleLink(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter18 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Gateway context = (Gateway) ctx.getTarget();
			if (MyJavaAudits.gate5XOREventNotBothRecTaskAndMsgEvent(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter19 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Gateway context = (Gateway) ctx.getTarget();
			if (MyJavaAudits.gate6complexInputCond(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter20 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Gateway context = (Gateway) ctx.getTarget();
			if (MyJavaAudits.gate7complexOutgoingCond(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter21 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Gateway context = (Gateway) ctx.getTarget();
			if (MyJavaAudits.gatewayType(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter22 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Start context = (Start) ctx.getTarget();
			if (MyJavaAudits.start1hasOutgoingSequenceFlows(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter23 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Start context = (Start) ctx.getTarget();
			if (MyJavaAudits.start2hasNoIncomingSequenceFlows(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter24 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Start context = (Start) ctx.getTarget();
			if (MyJavaAudits.start3hasNoOutgoingMessageFlows(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter25 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Start context = (Start) ctx.getTarget();
			if (MyJavaAudits.start4messageFlowHasMessageTrigger(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter26 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits.intermediate1hasNoOutgoingMessageFlows(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter27 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits.intermediate2activitySetNotNoneOrLink(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter28 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits.intermediate3cancelOnTransactionOnly(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter29 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits.intermediate4activityNoIncoming(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter30 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits.intermediate5compensationNoOutgoing(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter31 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits.intermediate6normalFlowNotCancelMultiple(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter32 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits
					.intermediate7normalFlowNoneErrorCompOneIncoming(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter33 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits.intermediate8incomingMaxOne(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter34 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits.intermediate9oneOutgoingIfNotLinkOrComp(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter35 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits.intermediate10linkOneIncomingOrOutgoing(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter36 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits.intermediate11sourceLinkMustHaveTarget(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter37 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits.intermediate12messageMaxOneIncomingMsg(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter38 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits
					.intermediate13doNotUseIntLinkIfTargetInSamePool(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter39 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			Intermediate context = (Intermediate) ctx.getTarget();
			if (MyJavaAudits.intermediate14errorCodeInNormalFlowGiven(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter40 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			End context = (End) ctx.getTarget();
			if (MyJavaAudits.end1hasIncomingSequenceFlows(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter41 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			End context = (End) ctx.getTarget();
			if (MyJavaAudits.end2hasNoOutgoingSequenceFlows(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter42 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			End context = (End) ctx.getTarget();
			if (MyJavaAudits.end3hasNoIncomingMessageFlows(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter43 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			SequenceFlow context = (SequenceFlow) ctx.getTarget();
			if (MyJavaAudits.seq1isSameProcess(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter44 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			SequenceFlow context = (SequenceFlow) ctx.getTarget();
			if (MyJavaAudits.seq2notNonewhenXORorOR(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter45 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			SequenceFlow context = (SequenceFlow) ctx.getTarget();
			if (MyJavaAudits.seq3noSingleConditionals(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter46 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			SequenceFlow context = (SequenceFlow) ctx.getTarget();
			if (MyJavaAudits.seq4noneConditionType(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter47 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			SequenceFlow context = (SequenceFlow) ctx.getTarget();
			if (MyJavaAudits.seq5defaultAllowed(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter48 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			SequenceFlow context = (SequenceFlow) ctx.getTarget();
			if (MyJavaAudits.seq6quantityAtLeastOne(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter49 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			MessageFlow context = (MessageFlow) ctx.getTarget();
			if (MyJavaAudits.msg1notSamePool(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter50 extends AbstractModelConstraint {

		/**
		 * @generated NOT
		 */
		public IStatus validate(IValidationContext ctx) {
			MessageFlow context = (MessageFlow) ctx.getTarget();
			if (MyJavaAudits.msg2NotGatewayLaneArtifact(context)) {
				return ctx.createSuccessStatus();
			} else {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil
						.getQualifiedName(ctx.getTarget(), true) });
			}
		}
	}

	/**
	 * @generated
	 */
	static String formatElement(EObject object) {
		return EMFCoreUtil.getQualifiedName(object, true);
	}

}
