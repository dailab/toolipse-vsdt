package de.dailab.vsdt.meta.diagram.providers;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;

import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessSystemEditPart;
import de.dailab.vsdt.meta.diagram.part.ValidateAction;
import de.dailab.vsdt.meta.diagram.part.VsdtMetaDiagramEditorPlugin;
import de.dailab.vsdt.meta.diagram.part.VsdtVisualIDRegistry;

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
				VsdtMetaDiagramEditorPlugin.getInstance().logError(
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
					&& BusinessProcessSystemEditPart.MODEL_ID
							.equals(VsdtVisualIDRegistry
									.getModelID((View) object));
		}
		return true;
	}

}
