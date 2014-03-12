package de.dailab.vsdt.trafo.impl;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.trafo.MappingWrapper;

/**
 * Special Export Wrapper for all BPMN exports. This does not do much,
 * but at least it automatically casts the source model to BPS.
 * 
 * @author kuester
 */
public class BpmnExportWrapper extends MappingWrapper {

	public BpmnExportWrapper(BusinessProcessSystem bps) {
		super(bps);
	}
	
	@Override
	public BusinessProcessSystem getSourceModel() {
		return (BusinessProcessSystem) super.getSourceModel();
	}
	
}
