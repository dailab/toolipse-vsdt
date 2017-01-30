package de.dailab.vsdt.diagram.clipboard;

import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

/**
 * VSDT copy command, just storing a reference to the selected elements
 * in a static variable.
 *
 * TODO use proper clip-board support instead?
 *
 * @author kuester
 */
public class VsdtEditorCopyCommand extends AbstractCommand {

	/** static reference to elements to be copied */
	protected static Map<EObject, EditPart> elementsToCopy;
	
	private final Map<EObject, EditPart> selectedElements;
	
	public VsdtEditorCopyCommand(Map<EObject, EditPart> selectedElements) {
		super("Copy");
		this.selectedElements = selectedElements;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		VsdtEditorCopyCommand.elementsToCopy = selectedElements;
		return CommandResult.newOKCommandResult();
	}
	
	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		return null;
	}

	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		return null;
	}
	
}
