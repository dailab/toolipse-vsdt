package de.dailab.vsdt.diagram.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;

/**
 * Derived from VSDT Meta Diagram Editor's Open Diagram Edit Policy, for opening
 * Independent Subprocesses in a new Editor.
 * 
 * @generated NOT
 */
public class OpenDiagramEditPolicy extends OpenEditPolicy {

	protected Command getOpenCommand(Request request) {
		EditPart targetEditPart = getTargetEditPart(request);
		if (false == targetEditPart.getModel() instanceof View) {
			return null;
		}
		View view = (View) targetEditPart.getModel();
		EObject element= view.getElement();
		if (element instanceof Activity) {
			Activity activity= (Activity) element;
			if (activity.getActivityType() == ActivityType.INDEPENDENT) {
				if (activity.getDiagramRef() != null) {
					return new ICommandProxy(new OpenBusinessProcessDiagramCommand(activity.getDiagramRef()));
				}
			}
		}
		return new ICommandProxy(UnexecutableCommand.INSTANCE);
	}

}
