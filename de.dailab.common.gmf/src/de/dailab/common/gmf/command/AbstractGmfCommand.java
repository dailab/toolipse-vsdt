package de.dailab.common.gmf.command;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

public abstract class AbstractGmfCommand extends AbstractTransactionalCommand {
	
	protected final EObject modelElement;
	
	public AbstractGmfCommand(EObject modelElement, String commandName) {
	    super(TransactionUtil.getEditingDomain(modelElement), commandName, 
	    		Collections.singletonList(WorkspaceSynchronizer.getFile(modelElement.eResource())));
	    this.modelElement= modelElement;
	}
	
}
