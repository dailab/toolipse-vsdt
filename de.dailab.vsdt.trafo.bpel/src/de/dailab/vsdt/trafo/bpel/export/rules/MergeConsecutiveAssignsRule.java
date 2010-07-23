package de.dailab.vsdt.trafo.bpel.export.rules;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TAssign;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSequence;

import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.base.util.Util;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

/**
 * Merge Consecutive Assigns Rule
 * 
 * PATTERN: Two consecutive Assigns in a sequence 
 * 
 * EFFECT: The copy-statements of the second assign are copied to the first assign
 *         and the second assign is removed.
 */
public class MergeConsecutiveAssignsRule extends AbstractVsdtRule {
	
	protected TAssign _assign= null;

	public static final int ASSIGN= 0;
	
	
//	@Override
//	protected void resetVars() {
//		_assign= null;
//	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new MergeConsecutiveAssignsRuleWrapper();
	}

	@Override
	protected void apply(List<EObject> matches){
		_assign=   (TAssign)	matches.get(ASSIGN);
		
		TSequence sequence = (TSequence) _assign.eContainer();
		
		int index= sequence.getActivityIndex(_assign);
		TAssign assign2= (TAssign) sequence.getActivity().getValue(index+1);
		_assign.setName(_assign.getName() + "_and_" + assign2.getName());
		_assign.getCopy().addAll(assign2.getCopy());
		Util.deleteFromOwner(assign2);
	}
	
//	@Override
//	protected void setWeightedLHS(List<EObject> matches){
//		_assign=   (TAssign)	matches.get(ASSIGN);
//	}
	
	/**
	 * wrapper for the rule
	 */
	class MergeConsecutiveAssignsRuleWrapper extends AbstractWrapper {
		
		protected ProcessPackage bpel= ProcessPackage.eINSTANCE;
		
		@Override
		public void initLHSVariables() {
			addVariableType(bpel.getTAssign(), lhsVariables); // ASSIGN
			
			//reduce domains
			for (Iterator<EObject> iter = lhsVariables.get(ASSIGN).getDomain().iterator(); iter.hasNext();) {
				TAssign assign= (TAssign) iter.next();
				boolean remove= false;

				if (assign.eContainer() instanceof TSequence) {
					TSequence sequence = (TSequence) assign.eContainer();
					int index= sequence.getActivityIndex(assign);
					if (index+1 >= sequence.getActivity().size() || 
							! (sequence.getActivity().getValue(index+1) instanceof TAssign)) {
						remove= true;
					}
				} else {
					remove= true;
				}
				
				if (remove) {
					iter.remove();
				}
			}
		}

		@Override
		protected void initNACVariables() {
		}
	}
	
}