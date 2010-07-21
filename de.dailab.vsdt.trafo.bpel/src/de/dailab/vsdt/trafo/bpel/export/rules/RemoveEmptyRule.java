package de.dailab.vsdt.trafo.bpel.export.rules;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty;

import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

/**
 * Remove Empty Rule
 * 
 * PATTERN: An Empty Activity with no attributes set (e.g. no name)
 * 
 * EFFECT: The empty Activity will be removed
 */
public class RemoveEmptyRule extends AbstractVsdtRule {
	
	protected TEmpty empty= null;

	public static final int EMPTY= 0;
	
	
	@Override
	protected void resetVars() {
		empty= null;
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}

	@Override
	protected void apply() {
		deleteFromOwner(empty);
	}
	
	@Override
	protected void setWeightedLHS(List<EObject> matches){
		empty=	(TEmpty)	matches.get(EMPTY);
	}
	
	/**
	 * wrapper for the rule
	 */
	class RuleWrapper extends AbstractWrapper {
		
		protected ProcessPackage bpel= ProcessPackage.eINSTANCE;
		
		@Override
		public void initLHSVariables() {
			addVariableType(bpel.getTEmpty(), lhsVariables); // EMPTY
			
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
	
}