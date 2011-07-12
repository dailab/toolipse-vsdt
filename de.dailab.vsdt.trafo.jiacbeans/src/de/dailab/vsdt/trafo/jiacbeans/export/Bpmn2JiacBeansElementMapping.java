package de.dailab.vsdt.trafo.jiacbeans.export;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.trafo.impl.BpmnElementMapping;
import de.dailab.vsdt.trafo.jiacbeans.export.generated.ElementMappingTemplate;

/**
 * BPMN to JIAC TNG JADL visitor. This visitor is performing a top-down pass of 
 * the BPMN model. This way it creates the element mapping for all the elements 
 * passed on the way.
 * 
 * @author tkuester
 */
public class Bpmn2JiacBeansElementMapping extends BpmnElementMapping {

	@Override
	protected void visitBusinessProcessSystem(BusinessProcessSystem bps) {
		// TODO Auto-generated method stub
		ElementMappingTemplate emt = new ElementMappingTemplate();
		System.out.println(emt.generate(bps));
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

}
