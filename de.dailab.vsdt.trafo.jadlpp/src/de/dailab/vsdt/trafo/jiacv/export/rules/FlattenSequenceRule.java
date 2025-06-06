package de.dailab.vsdt.trafo.jiacv.export.rules;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.jiactng.jadl.JadlPackage;
import de.dailab.jiactng.jadl.Seq;
import de.dailab.vsdt.trafo.strucbpmn.export.AbstractVsdtRule;

/**
 * Flatten Sequence Rule
 * 
 * PATTERN: A Sequence directly containing another sequence
 * 
 * EFFECT: The sequences will be flattened
 */
public class FlattenSequenceRule extends AbstractVsdtRule {

	protected JadlPackage jadl= JadlPackage.eINSTANCE;
	
	public static final int SEQUENCE= 0;
	
	@Override
	protected void excecute(List<EObject> matches){
		Seq _sequence=	(Seq)	matches.get(SEQUENCE);
		
		Seq childSeq= null;
		for (Object child : _sequence.getScripts()) {
			if (child instanceof Seq) {
				childSeq= (Seq) child;
				break;
			}
		}
		if (childSeq != null) {
			int index= _sequence.getScripts().indexOf(childSeq);
			_sequence.getScripts().remove(childSeq);
			_sequence.getScripts().addAll(index,childSeq.getScripts());
		}
	}
	
	@Override
	public void initLHSVariables() {
		addVariable(lhsVariables, jadl.getSeq()); // SEQUENCE
		
		//reduce domains
		for (Iterator<EObject> iter = lhsVariables.get(SEQUENCE).getDomain().iterator(); iter.hasNext();) {
			Seq sequence= (Seq) iter.next();
			
			// this could be done more graphically with another object in the pattern
			// but this way it should be somewhat faster...
			boolean hasSeq= false;;
			for (Object script : sequence.getScripts()) {
				if (script instanceof Seq) {
					hasSeq= true;
				}
			}
			if (! hasSeq) {
				// has no other sequences as direct children
				iter.remove();
			}
		}
	}

	@Override
	protected void initNACVariables() {
	}
	
}