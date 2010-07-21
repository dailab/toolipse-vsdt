package de.dailab.vsdt.trafo.base;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.logger.TrafoLog;

/**
 * User class for executing a transformation sequence.
 * 
 * this class as well as the whole package has been
 * edited and improved by holger endert and tobias küster
 * 
 * @author Enrico Biermann <br>
 * @author Guenter Kuhns <br>
 */
public abstract class Transformation {
	
	/**this list is containing one List for each layer, holding this layer's rules*/
	protected List<List<AbstractRule>> rules= null;
	
	/**
	 * fill rules list with one list for each layer, holding that layer's rules.
	 * 
	 * Example:
	 * List<List<AbstractRule>> layers= new ArrayList<List<AbstractRule>>();
	 * List<AbstractRule> layer1= new ArrayList<AbstractRule>();
	 * layer1.add(new SplitGatewayRule(root));
	 * layer1.add(new InsertGatewayRule(root));
	 * layer1.add(new InsertEmptyRule(root));
	 * layers.add(layer1);
	 * return layers;
	 */
	protected abstract List<List<AbstractRule>> initRules();
	

	/**
	 * Transform functionality. Iterate over the layers. Rules inside the given
	 * layer are applied with match. Continues with next layer once no more rule
	 * in the current layer is applicable.
	 */
	public final void transform(EObject root) {
		if (rules == null) {
			rules = initRules();
		}
		for (List<AbstractRule> layer : rules) {
			
			Queue<AbstractRule> applicableRules= new LinkedList<AbstractRule>();
			applicableRules.addAll(layer);
			
			long oldTime;
			long newTime= System.currentTimeMillis();
			
			try {
				//as long as there are applicable rules...
				while (! applicableRules.isEmpty()) {
					
					AbstractRule rule = applicableRules.remove();
					
					boolean executed= rule.execute(root);
					
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