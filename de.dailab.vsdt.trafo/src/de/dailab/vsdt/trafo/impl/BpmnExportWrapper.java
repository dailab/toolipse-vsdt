package de.dailab.vsdt.trafo.impl;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.trafo.MappingWrapper;

public class BpmnExportWrapper extends MappingWrapper {

	public BpmnExportWrapper(BusinessProcessSystem bps) {
		super(bps);
	}
	
	@Override
	public BusinessProcessSystem getSourceModel() {
		return (BusinessProcessSystem) super.getSourceModel();
	}
	
}
