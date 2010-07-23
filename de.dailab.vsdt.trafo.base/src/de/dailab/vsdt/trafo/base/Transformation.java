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
 * The Transformation class encapsulates a number of Rule Layers, that is a List
 * of Lists of Rules, and provides a Method for applying these rules to a given
 * EObject graph. The Rule Layers are executed consecutively to all EObjects
 * related to the EObject given as root node.
 */
public abstract class Transformation {
	
	/** List containing one List of Rules for each layer */
	protected List<List<AbstractRule>> rules= null;
	
	/**
	 * Fill Layers List with one List of Rules for each layer.
	 * 
	 * Example:
	 * List<List<AbstractRule>> layers= new ArrayList<List<AbstractRule>>();
	 * List<AbstractRule> layer1= new ArrayList<AbstractRule>();
	 * layer1.add(new SplitGatewayRule());
	 * layer1.add(new InsertGatewayRule());
	 * layer1.add(new InsertEmptyRule());
	 * layers.add(layer1);
	 * return layers;
	 */
	protected abstract List<List<AbstractRule>> initRules();
	

	/**
	 * Transform functionality. Iterate over the layers. Rules inside the given
	 * layer are applied with match. Continues with next layer once no more rule
	 * in the current layer is applicable.
	 */
	public final void transform(EObject eObject) {
		if (rules == null) {
			rules = initRules();
		}

		Map<EClass,List<EObject>> typeToDomain = Util.createTypeMap(eObject); 

		for (List<AbstractRule> layer : rules) {
			
			Queue<AbstractRule> applicableRules= new LinkedList<AbstractRule>();
			applicableRules.addAll(layer);
			
			long oldTime;
			long newTime= System.currentTimeMillis();
			
			try {
				//as long as there are applicable rules...
				while (! applicableRules.isEmpty()) {
					
					AbstractRule rule = applicableRules.remove();
					
					boolean executed= rule.execute(eObject, typeToDomain);
					
					oldTime= newTime;
					newTime= System.currentTimeMillis();

					// logging
					StringBuffer buff= new StringBuffer();
					buff.append(executed ? "executing " : "skipping ");
					buff.append(rule.getClass().getSimpleName());
					buff.append(" (").append(newTime-oldTime).append(" ms)");
					if (executed) {
						TrafoLog.debug(buff.toString());
					} else {
						TrafoLog.trace(buff.toString());
					}
					
					//application successful: re-insert all rules in the list and try again; else: continue with next rule, if any
					if (executed) {
						applicableRules.clear();
						applicableRules.addAll(layer);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}