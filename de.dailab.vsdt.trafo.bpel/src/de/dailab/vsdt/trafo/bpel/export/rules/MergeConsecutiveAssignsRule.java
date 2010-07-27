package de.dailab.vsdt.trafo.bpel.export.rules;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TAssign;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSequence;

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
	
	public static final int ASSIGN= 0;
	
	@Override
	protected void excecute(List<EObject> matches){
		TAssign _assign=   (TAssign)	matches.get(ASSIGN);
		
		TSequence sequence = (TSequence) _assign.eContainer();
		
		int index= sequence.getActivityIndex(_assign);
		TAssign assign2= (TAssign) sequence.getActivity().getValue(index+1);
		_assign.setName(_assign.getName() + "_and_" + assign2.getName());
		_assign.getCopy().addAll(assign2.getCopy());
		Util.deleteFromModel(assign2);
	}
	
	
	protected ProcessPackage bpel= ProcessPackage.eINSTANCE;
	
	@Override
	public void initLHSVariables() {
		addVariable(lhsVariables, bpel.getTAssign()); // ASSIGN
		
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