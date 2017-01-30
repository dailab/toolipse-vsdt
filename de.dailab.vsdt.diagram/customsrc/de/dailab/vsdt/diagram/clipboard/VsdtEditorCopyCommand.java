package de.dailab.vsdt.diagram.clipboard;

import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

public class VsdtEditorCopyCommand extends AbstractCommand {

	protected static Map<EObject, EditPart> elementsToCopy;
	
	private final Map<EObject, EditPart> selectedElements;
	
	public VsdtEditorCopyCommand(Map<EObject, EditPart> selectedElements) {
		super("Copy");
		this.selectedElements = selectedElements;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		VsdtEditorCopyCommand.elementsToCopy = selectedElements;
		
		System.out.println("CALLING COPY EXECUTE WITH RESULT");
		
		// TODO filter and preprocess elements... here or in paste?
		// TODO what to do with edit parts?
		
		// TODO use proper clipboard?
		
		return CommandResult.newOKCommandResult();
	}
	
	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		System.out.println("CALLING COPY UNDO WITH RESULT");
		return null;
	}

	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		System.out.println("CALLING COPY REDO WITH RESULT");
		return null;
	}
	
}
