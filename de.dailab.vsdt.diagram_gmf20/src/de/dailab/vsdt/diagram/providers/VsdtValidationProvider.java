package de.dailab.vsdt.diagram.providers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ITraversalStrategy;
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
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.custom.MyJavaAudits;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.expressions.VsdtAbstractExpression;
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
	public static void runWithConstraints(View view, Runnable op) {
		final Runnable fop = op;
		Runnable task = new Runnable() {

			public void run() {
				try {
					constraintsActive = true;
					fop.run();
				} finally {
					constraintsActive = false;
				}
			}
		};
		TransactionalEditingDomain txDomain = TransactionUtil
				.getEditingDomain(view);
		if (txDomain != null) {
			try {
				txDomain.runExclusive(task);
			} catch (Exception e) {
				VsdtDiagramEditorPlugin.getInstance().logError(
						"Validation action failed", e); //$NON-NLS-1$
			}
		} else {
			task.run();
		}
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
	static final Map semanticCtxIdMap = new HashMap();

	/**
	 * @generated
	 */
	public static class DefaultCtx1 implements IClientSelector {

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
	public static class DefaultCtx2 implements IClientSelector {

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
	public static class DefaultCtx3 implements IClientSelector {

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
	public static class DefaultCtx4 implements IClientSelector {

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
	public static class DefaultCtx5 implements IClientSelector {

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
	public static class DefaultCtx6 implements IClientSelector {

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
	public static class DefaultCtx7 implements IClientSelector {

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
	public static class DefaultCtx8 implements IClientSelector {

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
	public static class DefaultCtx9 implements IClientSelector {

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
	public static class DefaultCtx10 implements IClientSelector {

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
	public static class DefaultCtx11 implements IClientSelector {

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
	public static class DefaultCtx12 implements IClientSelector {

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
	public static class DefaultCtx13 implements IClientSelector {

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
	public static class DefaultCtx14 implements IClientSelector {

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
	public static class DefaultCtx15 implements IClientSelector {

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
	public static class DefaultCtx16 implements IClientSelector {

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
	public static class DefaultCtx17 implements IClientSelector {

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
	public static class DefaultCtx18 implements IClientSelector {

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
	public static class DefaultCtx19 implements IClientSelector {

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
	public static class DefaultCtx20 implements IClientSelector {

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
	public static class DefaultCtx21 implements IClientSelector {

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
	public static class DefaultCtx22 implements IClientSelector {

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
	public static class DefaultCtx23 implements IClientSelector {

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
	public static class DefaultCtx24 implements IClientSelector {

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
	public static class DefaultCtx25 implements IClientSelector {

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
	public static class DefaultCtx26 implements IClientSelector {

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
	public static class DefaultCtx27 implements IClientSelector {

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
	public static class DefaultCtx28 implements IClientSelector {

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
	public static class DefaultCtx29 implements IClientSelector {

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
	public static class DefaultCtx30 implements IClientSelector {

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
	public static class DefaultCtx31 implements IClientSelector {

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
	public static class DefaultCtx32 implements IClientSelector {

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
	public static class DefaultCtx33 implements IClientSelector {

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
	public static class DefaultCtx34 implements IClientSelector {

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
	public static class DefaultCtx35 implements IClientSelector {

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
	public static class DefaultCtx36 implements IClientSelector {

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
	public static class DefaultCtx37 implements IClientSelector {

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
	public static class DefaultCtx38 implements IClientSelector {

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
	public static class DefaultCtx39 implements IClientSelector {

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
	public static class DefaultCtx40 implements IClientSelector {

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
	public static class DefaultCtx41 implements IClientSelector {

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
	public static class DefaultCtx42 implements IClientSelector {

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
	public static class DefaultCtx43 implements IClientSelector {

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
	public static class DefaultCtx44 implements IClientSelector {

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
	public static class DefaultCtx45 implements IClientSelector {

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
	public static class DefaultCtx46 implements IClientSelector {

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
	public static class DefaultCtx47 implements IClientSelector {

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
	public static class DefaultCtx48 implements IClientSelector {

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
	public static class DefaultCtx49 implements IClientSelector {

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
	public static ITraversalStrategy getNotationTraversalStrategy(
			IBatchValidator validator) {
		return new CtxSwitchStrategy(validator);
	}

	/**
	 * @generated
	 */
	private static class CtxSwitchStrategy implements ITraversalStrategy {

		/**
		 * @generated
		 */
		private ITraversalStrategy defaultStrategy;

		/**
		 * @generated
		 */
		private String currentSemanticCtxId;

		/**
		 * @generated
		 */
		private boolean ctxChanged = true;

		/**
		 * @generated
		 */
		private EObject currentTarget;

		/**
		 * @generated
		 */
		private EObject preFetchedNextTarget;

		/**
		 * @generated
		 */
		CtxSwitchStrategy(IBatchValidator validator) {
			this.defaultStrategy = validator.getDefaultTraversalStrategy();
		}

		/**
		 * @generated
		 */
		public void elementValidated(EObject element, IStatus status) {
			defaultStrategy.elementValidated(element, status);
		}

		/**
		 * @generated
		 */
		public boolean hasNext() {
			return defaultStrategy.hasNext();
		}

		/**
		 * @generated
		 */
		public boolean isClientContextChanged() {
			if (preFetchedNextTarget == null) {
				preFetchedNextTarget = next();
				prepareNextClientContext(preFetchedNextTarget);
			}
			return ctxChanged;
		}

		/**
		 * @generated
		 */
		public EObject next() {
			EObject nextTarget = preFetchedNextTarget;
			if (nextTarget == null) {
				nextTarget = defaultStrategy.next();
			}
			this.preFetchedNextTarget = null;
			return this.currentTarget = nextTarget;
		}

		/**
		 * @generated
		 */
		public void startTraversal(Collection traversalRoots,
				IProgressMonitor monitor) {
			defaultStrategy.startTraversal(traversalRoots, monitor);
		}

		/**
		 * @generated
		 */
		private void prepareNextClientContext(EObject nextTarget) {
			if (nextTarget != null && currentTarget != null) {
				if (nextTarget instanceof View) {
					String id = ((View) nextTarget).getType();
					String nextSemanticId = id != null
							&& semanticCtxIdMap.containsKey(id) ? id : null;
					if ((currentSemanticCtxId != null && !currentSemanticCtxId
							.equals(nextSemanticId))
							|| (nextSemanticId != null && !nextSemanticId
									.equals(currentSemanticCtxId))) {
						this.ctxChanged = true;
					}
					currentSemanticCtxId = nextSemanticId;
				} else {
					// context of domain model
					this.ctxChanged = currentSemanticCtxId != null;
					currentSemanticCtxId = null;
				}
			} else {
				this.ctxChanged = false;
			}
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter1 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter1() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getBusinessProcessDiagram()) {

				protected Object doEvaluate(Object context, Map env) {
					BusinessProcessDiagram self = (BusinessProcessDiagram) context;
					return JavaAudits.bpd1max1PoolInvisible(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter2 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter2() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getEvent()) {

				protected Object doEvaluate(Object context, Map env) {
					Event self = (Event) context;
					return JavaAudits.event1outgoingAreUnconditioned(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter3 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter3() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getEvent()) {

				protected Object doEvaluate(Object context, Map env) {
					Event self = (Event) context;
					return JavaAudits.eventType(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter4 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter4() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getActivity()) {

				protected Object doEvaluate(Object context, Map env) {
					Activity self = (Activity) context;
					return JavaAudits.act1IsAtomicOrEmbedded(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter5 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter5() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getActivity()) {

				protected Object doEvaluate(Object context, Map env) {
					Activity self = (Activity) context;
					return JavaAudits.act2TaskSingleMessage(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter6 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter6() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getActivity()) {

				protected Object doEvaluate(Object context, Map env) {
					Activity self = (Activity) context;
					return JavaAudits.act3CompensationNoOutgoingSeq(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter7 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter7() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getActivity()) {

				protected Object doEvaluate(Object context, Map env) {
					Activity self = (Activity) context;
					return JavaAudits.act4startQuantityNotLowerThanOne(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter8 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter8() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getActivity()) {

				protected Object doEvaluate(Object context, Map env) {
					Activity self = (Activity) context;
					return JavaAudits.activityType(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter9 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter9() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getAbstractProcess()) {

				protected Object doEvaluate(Object context, Map env) {
					AbstractProcess self = (AbstractProcess) context;
					return JavaAudits.proc1startAndEnd(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter10 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter10() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getAbstractProcess()) {

				protected Object doEvaluate(Object context, Map env) {
					AbstractProcess self = (AbstractProcess) context;
					return JavaAudits.proc2noPseudoStarts(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter11 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter11() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getAbstractProcess()) {

				protected Object doEvaluate(Object context, Map env) {
					AbstractProcess self = (AbstractProcess) context;
					return JavaAudits.proc3NoPseudoEnds(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter12 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter12() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getAbstractProcess()) {

				protected Object doEvaluate(Object context, Map env) {
					AbstractProcess self = (AbstractProcess) context;
					return JavaAudits.absProcAdHoc(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter13 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter13() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getGateway()) {

				protected Object doEvaluate(Object context, Map env) {
					Gateway self = (Gateway) context;
					return JavaAudits.gate1noMessageFlows(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter14 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter14() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getGateway()) {

				protected Object doEvaluate(Object context, Map env) {
					Gateway self = (Gateway) context;
					return JavaAudits.gate2AndNoOutgoingConditional(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter15 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter15() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getGateway()) {

				protected Object doEvaluate(Object context, Map env) {
					Gateway self = (Gateway) context;
					return JavaAudits.gate3XOREventOutgoingConditonNone(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter16 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter16() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getGateway()) {

				protected Object doEvaluate(Object context, Map env) {
					Gateway self = (Gateway) context;
					return JavaAudits
							.gate4XOREventOutgoingTargetRecMsgTimerRuleLink(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter17 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter17() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getGateway()) {

				protected Object doEvaluate(Object context, Map env) {
					Gateway self = (Gateway) context;
					return JavaAudits
							.gate5XOREventNotBothRecTaskAndMsgEvent(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter18 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter18() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getGateway()) {

				protected Object doEvaluate(Object context, Map env) {
					Gateway self = (Gateway) context;
					return JavaAudits.gate6complexInputCond(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter19 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter19() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getGateway()) {

				protected Object doEvaluate(Object context, Map env) {
					Gateway self = (Gateway) context;
					return JavaAudits.gate7complexOutgoingCond(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter20 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter20() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getGateway()) {

				protected Object doEvaluate(Object context, Map env) {
					Gateway self = (Gateway) context;
					return JavaAudits.gatewayType(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter21 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter21() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getStart()) {

				protected Object doEvaluate(Object context, Map env) {
					Start self = (Start) context;
					return JavaAudits.start1hasOutgoingSequenceFlows(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter22 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter22() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getStart()) {

				protected Object doEvaluate(Object context, Map env) {
					Start self = (Start) context;
					return JavaAudits.start2hasNoIncomingSequenceFlows(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter23 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter23() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getStart()) {

				protected Object doEvaluate(Object context, Map env) {
					Start self = (Start) context;
					return JavaAudits.start3hasNoOutgoingMessageFlows(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter24 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter24() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getStart()) {

				protected Object doEvaluate(Object context, Map env) {
					Start self = (Start) context;
					return JavaAudits.start4messageFlowHasMessageTrigger(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter25 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter25() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits
							.intermediate1hasNoOutgoingMessageFlows(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter26 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter26() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits
							.intermediate2activitySetNotNoneOrLink(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter27 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter27() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits
							.intermediate3cancelOnTransactionOnly(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter28 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter28() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits.intermediate4activityNoIncoming(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter29 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter29() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits.intermediate5compensationNoOutgoing(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter30 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter30() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits
							.intermediate6normalFlowNotCancelMultiple(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter31 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter31() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits
							.intermediate7normalFlowNoneErrorCompOneIncoming(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter32 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter32() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits.intermediate8incomingMaxOne(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter33 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter33() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits
							.intermediate9oneOutgoingIfNotLinkOrComp(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter34 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter34() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits
							.intermediate10linkOneIncomingOrOutgoing(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter35 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter35() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits
							.intermediate11sourceLinkMustHaveTarget(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter36 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter36() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits
							.intermediate12messageMaxOneIncomingMsg(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter37 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter37() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits
							.intermediate13doNotUseIntLinkIfTargetInSamePool(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter38 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter38() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getIntermediate()) {

				protected Object doEvaluate(Object context, Map env) {
					Intermediate self = (Intermediate) context;
					return JavaAudits
							.intermediate14errorCodeInNormalFlowGiven(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter39 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter39() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getEnd()) {

				protected Object doEvaluate(Object context, Map env) {
					End self = (End) context;
					return JavaAudits.end1hasIncomingSequenceFlows(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter40 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter40() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getEnd()) {

				protected Object doEvaluate(Object context, Map env) {
					End self = (End) context;
					return JavaAudits.end2hasNoOutgoingSequenceFlows(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter41 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter41() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getEnd()) {

				protected Object doEvaluate(Object context, Map env) {
					End self = (End) context;
					return JavaAudits.end3hasNoIncomingMessageFlows(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter42 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter42() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getSequenceFlow()) {

				protected Object doEvaluate(Object context, Map env) {
					SequenceFlow self = (SequenceFlow) context;
					return JavaAudits.seq1isSameProcess(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter43 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter43() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getSequenceFlow()) {

				protected Object doEvaluate(Object context, Map env) {
					SequenceFlow self = (SequenceFlow) context;
					return JavaAudits.seq2notNonewhenXORorOR(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter44 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter44() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getSequenceFlow()) {

				protected Object doEvaluate(Object context, Map env) {
					SequenceFlow self = (SequenceFlow) context;
					return JavaAudits.seq3noSingleConditionals(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter45 extends AbstractModelConstraint {
		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter45() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getSequenceFlow()) {

				protected Object doEvaluate(Object context, Map env) {
					SequenceFlow self = (SequenceFlow) context;
					return JavaAudits.seq4noneConditionType(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter46 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter46() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getSequenceFlow()) {

				protected Object doEvaluate(Object context, Map env) {
					SequenceFlow self = (SequenceFlow) context;
					return JavaAudits.seq5defaultAllowed(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter47 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter47() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getSequenceFlow()) {

				protected Object doEvaluate(Object context, Map env) {
					SequenceFlow self = (SequenceFlow) context;
					return JavaAudits.seq6quantityAtLeastOne(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter48 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter48() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getMessageFlow()) {

				protected Object doEvaluate(Object context, Map env) {
					MessageFlow self = (MessageFlow) context;
					return JavaAudits.msg1notSamePool(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	public static class Adapter49 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		private VsdtAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter49() {
			expression = new VsdtAbstractExpression(VsdtPackage.eINSTANCE
					.getMessageFlow()) {

				protected Object doEvaluate(Object context, Map env) {
					MessageFlow self = (MessageFlow) context;
					return JavaAudits.msg2NotGatewayLaneArtifact(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil
					.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated NOT
	 */
	static class JavaAudits extends MyJavaAudits {

	} //JavaAudits
} //VsdtValidationProvider
