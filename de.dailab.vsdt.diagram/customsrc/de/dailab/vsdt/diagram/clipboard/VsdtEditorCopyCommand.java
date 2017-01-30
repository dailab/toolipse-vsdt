package de.dailab.vsdt.diagram.clipboard;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

public class VsdtEditorCopyCommand extends AbstractCommand {

	protected static List<EObject> objectsToCopy = null;
	
	private final List<EObject> toCopyElements;
	private final List<EditPart> toCopyEditParts; 
	
	public VsdtEditorCopyCommand(List<EObject> toCopyElements, List<EditPart> toCopyEditParts) {
		super("Copy");
		 this.toCopyEditParts = toCopyEditParts;
		 this.toCopyElements = toCopyElements;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		objectsToCopy = new LinkedList<>(EcoreUtil.copyAll(toCopyElements));
		
		System.out.println("CALLING COPY EXECUTE WITH RESULT");
		
		// TODO filter and preprocess elements
		// TODO what to do with edit parts?
		
		// TODO use proper clipboard?
		
		return null;
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
