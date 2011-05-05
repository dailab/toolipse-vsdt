package de.dailab.vsdt.diagram.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractDialogWrapperCommand;
import de.dailab.vsdt.diagram.dialogs.OrganizeAssignmentsDialog;
import de.dailab.vsdt.diagram.dialogs.OrganizeDataTypesDialog;
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

	public static final String TYPE_ASSIGNMENTS = "Assignments";
	public static final String TYPE_DATATYPES= "Data Types";	
	public static final String TYPE_SERVICES = "Services";
	public static final String TYPE_MESSAGES = "Message Channels";
	public static final String TYPE_PARAMETERS = "Parameters";
	public static final String TYPE_PROPERTIES = "Properties";
	
	public static OrganizeElementsAction getAssignmentsAction() {
		return new OrganizeElementsAction(TYPE_ASSIGNMENTS, -1);
	}
	
	public static OrganizeElementsAction getDataTypesAction() {
		return new OrganizeElementsAction(TYPE_DATATYPES, -1);
	}
	
	public static OrganizeElementsAction getServicesAction() {
		return new OrganizeElementsAction(TYPE_SERVICES, -1);
	}
	
	public static OrganizeElementsAction getMessageChannelAction() {
		return new OrganizeElementsAction(TYPE_MESSAGES, -1);
	}
	
	public static OrganizeElementsAction getParametersAction() {
		return new OrganizeElementsAction(TYPE_PARAMETERS, -1);
	}
	
	public static OrganizeElementsAction getPropertiesAction(int hint) {
		return new OrganizeElementsAction(TYPE_PROPERTIES, hint);
	}
	
	
	private final String type;
	private final int hint;
	
	/**
	 * Create new Organize Elements Action.
	 * 
	 * @param type	type of dialog (one of the constants)
	 * @param hint	some additional hint needed for some dialogs, e.g. properties
	 */
	public OrganizeElementsAction(String type, int hint) {
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
			if (type == TYPE_ASSIGNMENTS) {
				return new OrganizeAssignmentsDialog(shell, modelElement);
			}
			if (type == TYPE_DATATYPES) {
				return new OrganizeDataTypesDialog(shell, modelElement);
			}
			if (type == TYPE_SERVICES) {
				return new OrganizeServicesDialog(shell, modelElement);
			}
			if (type == TYPE_MESSAGES) {
				return new OrganizeMessageChannelsDialog(shell, modelElement);
			}
			if (type == TYPE_PARAMETERS) {
				return new OrganizeParametersDialog(shell, modelElement);
			}
			if (type == TYPE_PROPERTIES) {
				return new OrganizePropertiesDialog(shell, modelElement, hint);
			}
			return null;
		}
		
	}
}
