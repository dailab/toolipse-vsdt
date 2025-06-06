package de.dailab.vsdt.trafo.bpel.export.rules;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty;

import de.dailab.vsdt.trafo.base.util.Util;
import de.dailab.vsdt.trafo.strucbpmn.export.AbstractVsdtRule;

/**
 * Remove Empty Rule
 * 
 * PATTERN: An Empty Activity with no attributes set (e.g. no name)
 * 
 * EFFECT: The empty Activity will be removed
 */
public class RemoveEmptyRule extends AbstractVsdtRule {
	
	public static final int EMPTY= 0;
	
	@Override
	protected void excecute(List<EObject> matches){
		TEmpty empty=	(TEmpty)	matches.get(EMPTY);
		
		Util.deleteFromModel(empty);
	}
	
	
	protected ProcessPackage bpel= ProcessPackage.eINSTANCE;
	
	@Override
	public void initLHSVariables() {
		addVariable(lhsVariables, bpel.getTEmpty()); // EMPTY
		
		//reduce domains
		for (Iterator<EObject> iter = lhsVariables.get(EMPTY).getDomain().iterator(); iter.hasNext();) {
			TEmpty empty= (TEmpty) iter.next();
			
			// no attributes may be set
			boolean ok= true;
			ok&= empty.getName() == null;
			ok&= empty.getSource().isEmpty();
			ok&= empty.getTarget().isEmpty();
			ok&= empty.getJoinCondition() == null;
			
			if (! ok) {
				iter.remove();
			}
		}
	}

	@Override
	protected void initNACVariables() {
	}
	
}