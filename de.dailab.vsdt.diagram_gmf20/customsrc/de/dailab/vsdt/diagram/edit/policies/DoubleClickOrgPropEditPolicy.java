package de.dailab.vsdt.diagram.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.diagram.commands.OrganizePropertiesCommand;

public class DoubleClickOrgPropEditPolicy extends OpenEditPolicy{

	/**
	 * Open OrganizePropertiesDialog
	 */
	@Override
	protected Command getOpenCommand(Request request) {
		
		if (getHost().getModel() instanceof View) {
			View view= (View) getHost().getModel();
			EObject element= view.getElement();
			if ((element instanceof FlowObject) || 
					(element instanceof MessageFlow) ||
					(element instanceof Pool) ) {
				return new ICommandProxy(new OrganizePropertiesCommand(element));
			}
		}
		return null;
	}

}
