package de.dailab.vsdt.diagram.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;

import de.dailab.common.gmf.Util;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.diagram.actions.SetTypeAction;

public class SetTypeHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		try {
			FlowObject modelElement = Util.getModelElement(selection);
			if (modelElement != null && modelElement instanceof FlowObject) {
				new SetTypeAction().run(modelElement);
			}
		} catch (ClassCastException e) {
			System.out.println("Could not execute handler " + getClass().getSimpleName() + ": got unexpected model element.");
		}
		return null;
	}
}
