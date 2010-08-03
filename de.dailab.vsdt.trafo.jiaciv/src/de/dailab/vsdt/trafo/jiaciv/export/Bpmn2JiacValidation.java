package de.dailab.vsdt.trafo.jiaciv.export;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.trafo.impl.DefaultBpmnValidation;


public class Bpmn2JiacValidation extends DefaultBpmnValidation {

	/**
	 * Check whether the BPS to be exported is Executable
	 */
	@Override
	protected boolean visitBusinessProcessSystem(BusinessProcessSystem bps) {
		boolean isOk = super.visitBusinessProcessSystem(bps);
		isOk &= test(bps.isExecutable(), "Business Process System must be Executable");
		return isOk;
	}
	
//	/**
//	 * delegate to new artifact types
//	 */
//	@Override
//	protected boolean visitArtifact(Artifact artifact) {
//		boolean isOK= super.visitArtifact(artifact);
//		
//		//delegate
//		if (artifact instanceof Agent) {
//			Agent agent = (Agent) artifact;
//			isOK&= visitAgent(agent);
//		}
//		if (artifact instanceof Service) {
//			Service service = (Service) artifact;
//			isOK&= visitService(service);
//		}
//		return isOK;
//	}
//	
//	/**
//	 * normalize name
//	 * associations to other agents and pools are set via associations and can not be tested here
//	 */
//	protected boolean visitAgent(Agent agent) {
//		if (testIsNull(agent)) return false;
//		boolean isOK=true;
//		
//		agent.setName(normUnique(agent.getName(), NORM_NAME_ELEMENT, agent));
//		
//		return isOK;
//	}
//	
//	/**
//	 * provider not null (note: user may be null)
//	 */
//	protected boolean visitService(Service service) {
//		if (testIsNull(service)) return false;
//		boolean isOK=true;
//		
//		isOK&= test(service.getProvider() != null, "Provider must not be null");
//		
//		return isOK;
//	}

}
