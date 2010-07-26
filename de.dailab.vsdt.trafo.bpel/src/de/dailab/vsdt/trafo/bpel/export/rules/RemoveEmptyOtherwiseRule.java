package de.dailab.vsdt.trafo.bpel.export.rules;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch;

import de.dailab.vsdt.trafo.base.util.Util;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

/**
 * Remove Empty Otherwise Rule
 * 
 * PATTERN: An Empty Otherwise Block 
 * 
 * EFFECT: The empty Otherwise Block will be removed
 */
public class RemoveEmptyOtherwiseRule extends AbstractVsdtRule {
	
	public static final int OTHERWISE= 0;
	
	@Override
	protected void apply(List<EObject> matches){
		TActivityContainer otherwise=	(TActivityContainer)	matches.get(OTHERWISE);
		
		Util.deleteFromOwner(otherwise);
	}
	
	
	protected ProcessPackage bpel= ProcessPackage.eINSTANCE;
	
	@Override
	public void initLHSVariables() {
		addVariable(lhsVariables, bpel.getTActivityContainer()); // OTHERWISE
		
		//reduce domains
		for (Iterator<EObject> iter = lhsVariables.get(OTHERWISE).getDomain().iterator(); iter.hasNext();) {
			TActivityContainer otherwise= (TActivityContainer) iter.next();
			
			boolean ok= false;
			// really is an otherwise
			if (otherwise.eContainer() instanceof TSwitch) {
				TSwitch tSwitch = (TSwitch) otherwise.eContainer();
				
				if (otherwise == tSwitch.getOtherwise()) {
					ok= otherwise.eContents().isEmpty();
				}
			}
			
			if (! ok) {
				// not an otherwise element or has children
				iter.remove();
			}
		}
	}

	@Override
	protected void initNACVariables() {
	}
	
}