package de.dailab.vsdt.diagram.actions.structuring;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;

import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * An Action for appending a new Activity Node after an existing Flow Object.
 * 
 * @author kuester
 */
public class AppendIntermediateAction extends AppendNodeAction {

	@Override
	public IElementType getElementType() {
		return VsdtElementTypes.Intermediate_2003;
	}
	
	public static class Handler extends AbstractHandler {
	
		@Override
		public Object execute(ExecutionEvent event) throws ExecutionException {
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			AppendIntermediateAction action = new AppendIntermediateAction();
			action.selectionChanged(null, selection);
			action.run(null);
			return null;
		}
	}
	
	
}
