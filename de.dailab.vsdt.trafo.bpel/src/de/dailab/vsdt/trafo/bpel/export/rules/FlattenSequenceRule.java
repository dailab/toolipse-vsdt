package de.dailab.vsdt.trafo.bpel.export.rules;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSequence;

import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

/**
 * Flatten Sequence Rule
 * 
 * PATTERN: A Sequence directly containing another sequence
 * 
 * EFFECT: The sequences will be flattened
 */
public class FlattenSequenceRule extends AbstractVsdtRule {
	
	public static final int SEQUENCE= 0;
	
	@Override
	protected void excecute(List<EObject> matches){
		TSequence _sequence=	(TSequence)	matches.get(SEQUENCE);
		/*
		 * memorize the sequences position
		 * remove sequence
		 * get sequences content
		 * insert content at that position
		 */
		TSequence child= _sequence.getSequence().get(0);
		int index= _sequence.getActivityIndex(child);
		_sequence.getActivity().remove(index);
		_sequence.getActivity().addAll(index, child.getActivity());
	}
	
	protected ProcessPackage bpel= ProcessPackage.eINSTANCE;
	
	@Override
	public void initLHSVariables() {
		addVariable(lhsVariables, bpel.getTSequence()); // SEQUENCE
		
		//reduce domains
		for (Iterator<EObject> iter = lhsVariables.get(SEQUENCE).getDomain().iterator(); iter.hasNext();) {
			TSequence sequence= (TSequence) iter.next();
			
			if (sequence.getSequence().isEmpty()) {
				// has no other sequences as direct children
				iter.remove();
			}
		}
	}

	@Override
	protected void initNACVariables() {
	}
	
}