package de.dailab.vsdt.vsdtagents.sema;

import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.vsdtagents.Util;

/**
 * This bean will later be used to push services from the SeMa2 into the VSDT.
 * 
 * TODO
 * 
 * nochmal im web service import view angucken, wie ich das da gemacht habe...
 * 
 * zwei faelle: template oder komplette action -> 
 * zwei actions oder unterscheidung in der action?
 * 
 * nochmal sicherstellen, wann (und ob) der agent startet
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
	@Expose(name=ACTION_PUSH_SERVICE, scope=ActionScope.NODE)
	public void pushServiceIntoVsdt(Object object) throws Exception {
		
		System.err.println("ACTION CALLED!");
		
		Action action = (Action) object;
		
		// get BPS, thus check whether current editor is VSDT editor
		BusinessProcessSystem bps = Util.getVsdtModel();
		if (bps != null) {
			
			// create VSDT Service object corresponding to ServiceDescription
			Service impl = VsdtFactory.eINSTANCE.createService();
			
			// set service attributes; this should be compatible to how the mapping maps services to JIAC actions
			impl.setDescription(null);
			impl.setInterface(action.getProviderBean().getBeanName());
			impl.setLocation(null);
			impl.setOperation(action.getName());
			impl.setParticipant(null);
			impl.setType("JIAC Action");

			// set input and output
			for (int i = 0; i < action.getInputTypeNames().size(); i++) {
				Property input = VsdtFactory.eINSTANCE.createProperty();
				input.setName(String.format("arg%d", i));
				input.setType(action.getInputTypeNames().get(i));
				impl.getInput().add(input);
			}
			for (int i = 0; i < action.getResultTypeNames().size(); i++) {
				Property output = VsdtFactory.eINSTANCE.createProperty();
				output.setName(String.format("res%d", i));
				output.setType(action.getResultTypeNames().get(i));
				impl.getOutput().add(output);
			}

			// TODO add data types

//			if (action instanceof ServiceDescription) {
//				ServiceDescription service = (ServiceDescription) action;
//				
//				// TODO add semantic description attributes
//			}
			
			// add service object to business process system
			bps.getServices().add(impl);
			
		} else {
			throw new Exception("Could not get Business Process System from active Editor. "
					+ "Make sure the active editor is a VSDT process diagram editor.");
		}
	}
	
}
