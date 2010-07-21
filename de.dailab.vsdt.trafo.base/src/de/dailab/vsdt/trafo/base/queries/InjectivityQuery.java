package de.dailab.vsdt.trafo.base.queries;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * Class : InjectivityQuery <br/>
 * Package : rules <br/>
 * Project : RuleProject <br/>
 * Created On : 10.01.2006 <br/>
 * Description : Query class for the Matchfinder. 
 * Ensures that the match morphism is injective. 
 * 
 * @author Enrico Biermann <br>
 * @author Guenter Kuhns <br>
 */
public class InjectivityQuery extends Query {
	
	/**
	 * Default constructor. 
	 * @param creator instantiated variable
	 * @param target other variable of same type
	 */
	public InjectivityQuery(Variable creator, Variable target) {
		super(creator, target);
	}
	
	/**
	 * Checks if an injective match is possible and ensures that other variable
	 * can't be instantiated with the current value of the evaluated one.
	 */
	public boolean eval() {
		if (creator.isInstanciated()) {
			init();
			values.addAll(this.preDynamic);
			values.remove(creator.getInstanceValue());
			if (values.size() > 0) {
				target.setDynamicDomain(values);
				return true;
			} else {
				return false;	
			}
		}
		return false;
	}
	
}
