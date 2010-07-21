package de.dailab.vsdt.trafo.strucbpmn.util;

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
	
	/**
	 * Remove a SequenceFlow from the model. Also unsets its references.
	 * 
	 * @param seqFlow	Some SequenceFlow to be removed
	 */
	public static void deleteSequenceFlow(SequenceFlow seqFlow) {
		if (seqFlow != null) {
			seqFlow.setSource(null);
			seqFlow.setTarget(null);
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
