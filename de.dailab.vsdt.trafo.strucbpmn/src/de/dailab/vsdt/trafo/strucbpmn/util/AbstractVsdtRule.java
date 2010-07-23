package de.dailab.vsdt.trafo.strucbpmn.util;

import de.dailab.vsdt.Association;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.trafo.base.AbstractRule;
import de.dailab.vsdt.trafo.base.util.Util;


/**
 * This class extends the original AbstractRule class with a few useful methods,
 * e.g. for correctly removing some types of objects 
 * 
 * @author kuester
 */
public abstract class AbstractVsdtRule extends AbstractRule {
	
	public static final String SUFFIX_SPLIT = "__SPLIT__";
	
	public static final String SUFFIX_FORK= "__FORK__";
	public static final String SUFFIX_MERGE= "__MERGE__";

	public static final String SUFFIX_BRANCH = "__BRANCH__";
	
	public static final String INITIAL_GATEWAY= "__INITIAL_GATEWAY__";

	public static final String FINAL_GATEWAY= "__FINAL_GATEWAY__";
	/**
	 * the name for the empty activity. later these activities can be removed.
	 */
	public final static String EMPTY_NAME= "__DO_NOTHING__";
	
	
	/**
	 * Remove a SequenceFlow from the model. Also unsets its references.
	 * 
	 * @param seqFlow	Some SequenceFlow to be removed
	 */
	public static void deleteSequenceFlow(SequenceFlow seqFlow) {
		if (seqFlow != null) {
			seqFlow.setSource(null);
			seqFlow.setTarget(null);
			Util.deleteFromOwner(seqFlow);
		}
	}
	
	public static void deleteAssociation(Association association) {
		if (association != null) {
			association.setSource(null);
			association.setTarget(null);
			Util.deleteFromOwner(association);
		}
	}

}
