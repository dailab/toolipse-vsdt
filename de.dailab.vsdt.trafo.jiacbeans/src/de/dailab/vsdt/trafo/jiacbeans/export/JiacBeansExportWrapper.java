package de.dailab.vsdt.trafo.jiacbeans.export;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.trafo.impl.BpmnExportWrapper;

/**
 * Maintains a mapping from resulting models back to the original pools.
 * 
 * @author kuester
 */
public class JiacBeansExportWrapper extends BpmnExportWrapper {

	public JiacBeansExportWrapper(BusinessProcessSystem bps) {
		super(bps);
	}


}
