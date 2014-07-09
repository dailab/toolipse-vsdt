package de.dailab.vsdt.vsdtagents.sema;

import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;

/**
 * This bean will later be used to push services from the SeMa2 into the VSDT.
 * 
 * @author kuester
 */
public class SemaIntegrationAgentBean extends AbstractMethodExposingBean {
	
	public static final String BEAN_NAME = "de.dailab.vsdt.vsdtagents.sema#SemaIntegrationAgentBean";
	public static final String ACTION_PUSH_SERVICE = BEAN_NAME + "#PushServiceIntoVSDT";

	@Expose(name=ACTION_PUSH_SERVICE, scope=ActionScope.NODE)
	public Boolean pushServiceIntoVsdt(Object serviceDescription) throws Exception {
		// TODO implement this method
		throw new Exception("Not yet implemented");
	}
	
}
