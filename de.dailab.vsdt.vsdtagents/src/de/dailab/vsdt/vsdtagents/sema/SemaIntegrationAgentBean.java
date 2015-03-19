package de.dailab.vsdt.vsdtagents.sema;

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
 * TODO
 * zwei faelle: template oder komplette action -> 
 * zwei actions oder unterscheidung in der action?
 *
 * @author kuester
 */
public class SemaIntegrationAgentBean extends AbstractMethodExposingBean {
	
	public static final String BEAN_NAME = "de.dailab.vsdt.vsdtagents.sema#SemaIntegrationAgentBean";
	public static final String ACTION_PUSH_SERVICE = BEAN_NAME + "#PushServiceIntoVSDT";

	/**
	 * TODO javadoc
	 * 
	 * @param action		the Action or ServiceDescription to add a corresponding VSDT service for
	 * @throws Exception	exception in case anything goes wrong
	 */
	//FIXME if this uses 'ServiceDescription' as parameter, then it hangs, while using 'Action 'works
	@Expose(name=ACTION_PUSH_SERVICE, scope=ActionScope.NODE)
	public void pushServiceIntoVsdt(Action action) throws Exception {
		
		System.err.println("ACTION CALLED!");
		
		// get BPS, thus check whether current editor is VSDT editor
		IWorkbenchWindow[] wbws = PlatformUI.getWorkbench().getWorkbenchWindows();
		IEditorPart editor = wbws[0].getActivePage().getActiveEditor();
		BusinessProcessSystem bps = Util.getVsdtModel(editor);

		if (bps != null) {

			// create VSDT Service object corresponding to ServiceDescription
			Service service = null;
			if (action instanceof ServiceDescription) {
				service = createService((ServiceDescription) action);
			} else {
				service = createService(action);
			}
			
			/*
			 * FIXME
			 * java.lang.IllegalStateException: Cannot modify resource set without a write transaction
			 */
			bps.getServices().add(service);
			
		} else {
			throw new Exception("Could not get Business Process System from active Editor. "
					+ "Make sure the active editor is a VSDT process diagram editor.");
		}
	}
	
	
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
