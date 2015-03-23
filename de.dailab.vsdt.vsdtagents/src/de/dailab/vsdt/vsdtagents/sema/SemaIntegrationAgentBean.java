package de.dailab.vsdt.vsdtagents.sema;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.owlsdescription.ServiceDescription;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.vsdtagents.Util;

/**
 * This bean will later be used to push services from the SeMa2 into the VSDT.
 * 
 * TODO add another action (or action parameter) for service-templates?
 *
 * @author kuester
 */
public class SemaIntegrationAgentBean extends AbstractMethodExposingBean {
	
	public static final String BEAN_NAME = "de.dailab.vsdt.vsdtagents.sema#SemaIntegrationAgentBean";
	public static final String ACTION_PUSH_SERVICE = BEAN_NAME + "#PushServiceIntoVSDT";

	/**
	 * Create VSDT Service object from JIAC Action or ServiceDescription 
	 * and add it to the VSDT diagram opened in the active editor, if any.
	 * 
	 * @param action		the Action or ServiceDescription to add a corresponding VSDT service for
	 * @throws Exception	exception in case anything goes wrong
	 */
	@Expose(name=ACTION_PUSH_SERVICE, scope=ActionScope.NODE)
	public void pushServiceIntoVsdt(Action action) throws Exception {
		
		// get BPS from editor, thus checking whether current editor is VSDT editor
		final IWorkbenchWindow[] wbws = PlatformUI.getWorkbench().getWorkbenchWindows();
		final IEditorPart editor = wbws[0].getActivePage().getActiveEditor();
		final BusinessProcessSystem bps = Util.getVsdtModel(editor);
		
		if (bps != null) {

			// create VSDT Service object corresponding to ServiceDescription
			final Service service = (action instanceof ServiceDescription)
					? createService((ServiceDescription) action)
					: createService(action);

			// this JIAC agent is not running in the UI thread, so we have to asynch-exec this
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					// also, we have to put this inside a command
					ICommandProxy command = new ICommandProxy(new AbstractTransactionalCommand(
							TransactionUtil.getEditingDomain(bps), "Import Semantic Service", 
							Collections.singletonList(WorkspaceSynchronizer.getFile(bps.eResource()))) {
						@Override
						protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
							// finally, add the service to the BPS' list of services
							bps.getServices().add(service);
							return CommandResult.newOKCommandResult(bps);
						}
					});
					((DiagramEditor) editor).getDiagramEditDomain().getDiagramCommandStack().execute(command);
				}
			});
			
		} else {
			throw new Exception("Could not get Business Process System from active Editor. "
					+ "Make sure the active editor is a VSDT process diagram editor.");
		}
	}
	
	/**
	 * Create VSDT service object from given JIAC Action
	 * 
	 * TODO explain mapping
	 * 
	 * @param action	some JIAC actions
	 * @return			according VSDT Service
	 */
	private Service createService(Action action) {
		Service result = VsdtFactory.eINSTANCE.createService();

		// set service attributes; this should be compatible to how the mapping maps services to JIAC actions
		result.setOperation(action.getName());
		result.setType("JIAC Action");
		if (action.getProviderBean() != null) {
			result.setInterface(action.getProviderBean().getBeanName());
		}
//		impl.setLocation(null);
//		impl.setParticipant(null);
//		impl.setDescription(null);

		// set input and output
		for (int i = 0; i < action.getInputTypeNames().size(); i++) {
			Property input = VsdtFactory.eINSTANCE.createProperty();
			input.setName(String.format("arg%d", i));
			input.setType(action.getInputTypeNames().get(i));
			result.getInput().add(input);
		}
		for (int i = 0; i < action.getResultTypeNames().size(); i++) {
			Property output = VsdtFactory.eINSTANCE.createProperty();
			output.setName(String.format("res%d", i));
			output.setType(action.getResultTypeNames().get(i));
			result.getOutput().add(output);
		}

		// TODO add data types

		return result;
	}
	
	/**
	 * Create VSDT service object from given JIAC ServiceDescription
	 * 
	 * TODO explain mapping
	 * 
	 * @param action	some JIAC ServiceDescription
	 * @return			according VSDT Service
	 */
	private Service createService(ServiceDescription serviceDescription) {
		Service result = VsdtFactory.eINSTANCE.createService();
		
		// set service attributes; this should be compatible to how the mapping maps services to JIAC actions
		//XXX action.getName ist null bei service-description... soll das so sein???
//		result.setOperation(action.getName());
//		result.setType("JIAC Action");
//		if (action.getProviderBean() != null) {
//			result.setInterface(action.getProviderBean().getBeanName());
//		}
////					impl.setLocation(null);
////					impl.setParticipant(null);
////					impl.setDescription(null);
//
//		// set input and output
//		// FIXME service description erbt von action, aber hat keine inputs? WTF?
//		
//		for (int i = 0; i < action.getInputTypeNames().size(); i++) {
//			Property input = VsdtFactory.eINSTANCE.createProperty();
//			input.setName(String.format("arg%d", i));
//			input.setType(action.getInputTypeNames().get(i));
//			impl.getInput().add(input);
//		}
//		for (int i = 0; i < action.getResultTypeNames().size(); i++) {
//			Property output = VsdtFactory.eINSTANCE.createProperty();
//			output.setName(String.format("res%d", i));
//			output.setType(action.getResultTypeNames().get(i));
//			result.getOutput().add(output);
//		}

		// TODO add data types

		return result;
	}
	
}
