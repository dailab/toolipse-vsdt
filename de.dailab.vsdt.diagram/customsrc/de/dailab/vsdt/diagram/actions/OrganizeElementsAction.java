package de.dailab.vsdt.diagram.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractDialogWrapperCommand;
import de.dailab.vsdt.diagram.dialogs.OrganizeAssignmentsDialog;
import de.dailab.vsdt.diagram.dialogs.OrganizeDataTypesDialog;
import de.dailab.vsdt.diagram.dialogs.OrganizeExpressionsDialog;
import de.dailab.vsdt.diagram.dialogs.OrganizeMessageChannelsDialog;
import de.dailab.vsdt.diagram.dialogs.OrganizeParametersDialog;
import de.dailab.vsdt.diagram.dialogs.OrganizePropertiesDialog;
import de.dailab.vsdt.diagram.dialogs.OrganizeServicesDialog;

/**
 * This action can be used for starting various organize elements dialogs
 * wrapped inside a transactional command.
 * 
 * @author kuester
 */
public class OrganizeElementsAction extends AbstractGmfAction {

	enum Type {
		ASSIGNMENTS, DATATYPES, SERVICES, MESSAGES, PARAMETERS, PROPERTIES, EXPRESSIONS;
	}
	
	public static OrganizeElementsAction getAssignmentsAction() {
		return new OrganizeElementsAction(Type.ASSIGNMENTS, -1);
	}
	
	public static OrganizeElementsAction getDataTypesAction() {
		return new OrganizeElementsAction(Type.DATATYPES, -1);
	}
	
	public static OrganizeElementsAction getServicesAction() {
		return new OrganizeElementsAction(Type.SERVICES, -1);
	}
	
	public static OrganizeElementsAction getMessageChannelAction() {
		return new OrganizeElementsAction(Type.MESSAGES, -1);
	}
	
	public static OrganizeElementsAction getParametersAction() {
		return new OrganizeElementsAction(Type.PARAMETERS, -1);
	}
	
	public static OrganizeElementsAction getPropertiesAction(int hint) {
		return new OrganizeElementsAction(Type.PROPERTIES, hint);
	}
	
	public static OrganizeElementsAction getExpressionsAction(int hint) {
		return new OrganizeElementsAction(Type.EXPRESSIONS, hint);
	}
	
	
	private final Type type;
	private final int hint;
	
	/**
	 * Create new Organize Elements Action.
	 * 
	 * @param type	type of dialog
	 * @param hint	some additional hint needed for some dialogs, e.g. properties
	 */
	public OrganizeElementsAction(Type type, int hint) {
		this.type = type;
		this.hint = hint;
	}
	
	@Override
	public AbstractTransactionalCommand getCommand() {
		return new OrganizeElementsCommand(eObject);
	}

	
	public class OrganizeElementsCommand extends AbstractDialogWrapperCommand {
		
		public OrganizeElementsCommand(EObject modelElement) {
		    super(modelElement, "Organize " + type);
		}
		
		@Override
		protected Dialog getDialog(Shell shell) {
			switch (type) {
			case ASSIGNMENTS:
				return new OrganizeAssignmentsDialog(shell, modelElement);
			case DATATYPES:
				return new OrganizeDataTypesDialog(shell, modelElement);
			case SERVICES:
				return new OrganizeServicesDialog(shell, modelElement);
			case MESSAGES:
				return new OrganizeMessageChannelsDialog(shell, modelElement);
			case PARAMETERS:			
				return new OrganizeParametersDialog(shell, modelElement);
			case PROPERTIES:
				return new OrganizePropertiesDialog(shell, modelElement, hint);
			case EXPRESSIONS:
				return new OrganizeExpressionsDialog(shell, modelElement, hint);
			default:
				return null;
			}
		}
		
	}
}
