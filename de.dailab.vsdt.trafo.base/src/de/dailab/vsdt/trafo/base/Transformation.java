package de.dailab.vsdt.trafo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
	
	/**the instance root*/
	protected EObject root = null;
	
	/**apply rules in random order?*/
	protected boolean random= false;
	
	/**
	 * initialize the Rules with the given root object
	 * @param root	the root object, transitively containing all other elements
	 */
	public void initialize(EObject root) {
		this.root= root;
		this.rules= initRules();
	}
	
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
	 * Transform functionality. Iterate over the layers and call transform(layer) for each
	 */
	public void transform(){
		for (Iterator<List<AbstractRule>> iter = rules.iterator(); iter.hasNext();) {
			List<AbstractRule> layer = iter.next();
			transform(layer);
		}
	}
	

	/**
	 * Transform functionality. Arbitrary rule inside the given layer is applied with 
	 * arbitrary match. Continues until no more rule in this layer is applicable.
	 * 
	 * @param layer		list holding all the rules of the current layer
	 */
	private void transform(List<AbstractRule> layer){
		
		List<AbstractRule> applicableRules= new ArrayList<AbstractRule>();
		applicableRules.addAll(layer);
		
		Random rand = new Random();
		
		Long oldTime;
		Long newTime= System.currentTimeMillis();
		
		try {
			//as long as there are applicable rules...
			while(applicableRules.size() > 0){
				
				AbstractRule rule= null;
				if (random) {
					rule= applicableRules.get(rand.nextInt(applicableRules.size()));
				} else {
					rule= applicableRules.get(0);
				} 
				rule.setInstanceSymbol(root);
				boolean executed= rule.execute();
				rule.reset();
				
				oldTime= newTime;
				newTime= System.currentTimeMillis();
				StringBuffer buff= new StringBuffer();
				buff.append(executed ? "executing " : "skipping ");
				buff.append(rule.getName());
				buff.append(" (").append(newTime-oldTime).append(" ms)");
				if (executed) {
					TrafoLog.debug(buff.toString());
				} else {
					TrafoLog.trace(buff.toString());
				}
				
				//application successful: re-insert all rules in the list and try again; else: continue with next rule, if any
				if(executed){
					applicableRules.clear();
					applicableRules.addAll(layer);
				} else{
					applicableRules.remove(rule);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}