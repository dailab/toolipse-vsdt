package de.dailab.vsdt.trafo.strucbpmn.util;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Association;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.trafo.base.AbstractRule;


/**
 * This class extends the original AbstractRule class with a few useful methods,
 * e.g. for correctly removing some types of objects 
 * 
 * @author kuester
 */
public abstract class AbstractVsdtRule extends AbstractRule {
	
	public AbstractVsdtRule(EObject root, String title) {
		super(root, title);
	}
	
	/**
	 * Remove a SequenceFlow from the model. Also unsets its references.
	 * 
	 * @param seqFlow	Some SequenceFlow to be removed
	 */
	public static void deleteSequenceFlow(SequenceFlow seqFlow) {
		if (seqFlow != null) {
			seqFlow.setSource(null);
			seqFlow.setTarget(null);
			// FIXME maybe the gate reference could still be of use in the mapping.
			//       in that case, unset the source/target references
			//       but do not remove the sequence flow from its container 
//			seqFlow.setGate(null);
			deleteFromOwner(seqFlow);
		}
	}
	
	public static void deleteAssociation(Association association) {
		if (association != null) {
			association.setSource(null);
			association.setTarget(null);
			deleteFromOwner(association);
		}
	}

}
