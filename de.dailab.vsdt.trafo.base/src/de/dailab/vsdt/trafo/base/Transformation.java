package de.dailab.vsdt.trafo.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.trafo.base.util.Util;

/**
 * This class provides the functionality to take an EObject and some rules, or
 * more specifically, layers of rules, and to apply the rules to the EObject's
 * instance graph, layer by layer, until no more rules can be executed.
 */
public abstract class Transformation {
	
	/**
	 * Transform functionality. The EObject is used to access the entire model,
	 * i.e., from this EObject the Algorithm will go up to the root and then
	 * down in every leaf of the containment hierarchy, so it finds every object
	 * in the graph. Then, the Lists of TransformationRules are applied, one by
	 * one. Whenever a rule can be executed, all the other rules of that layer
	 * are considered again, and the object graph is recalculated, too. If none
	 * of the rules of one layer could be executed, the next layer is tried. The
	 * process ends after the last rule layer has been tried.
	 * 
	 * @param eObject	some EObject of the instance graph
	 * @param rules		List of Rule Layers
	 * @return			true, if any of the rules have been successfully executed
	 */
	public static final boolean transform(EObject eObject, List<List<TransformationRule>> rules) {
		if (eObject == null || rules == null)
			throw new IllegalArgumentException("Argument must not be null");
		
		Map<EClass,List<EObject>> instancesMap = Util.createInstancesMap(eObject); 

		boolean executedAnyRules = false;
		for (List<TransformationRule> layer : rules) {
			
			Queue<TransformationRule> applicableRules= new LinkedList<TransformationRule>();
			applicableRules.addAll(layer);
			
			//as long as there are applicable rules...
			while (! applicableRules.isEmpty()) {

				// apply next Transformation Rule
				TransformationRule rule = applicableRules.remove();
				if (rule.apply(instancesMap)) {
					//application successful	
					TrafoLog.debug("Executed " + rule.getClass().getSimpleName());
					executedAnyRules = true;
					
					// re-insert all rules in the list and try again
					applicableRules.clear();
					applicableRules.addAll(layer);
					instancesMap = Util.createInstancesMap(eObject);

				} else {
					// continue with next rule, if any
					TrafoLog.trace("Skipped " + rule.getClass().getSimpleName());
				}
			}
		}
		return executedAnyRules;
	}
	
}