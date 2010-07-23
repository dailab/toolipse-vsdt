package de.dailab.vsdt.trafo.base.queries;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * Class : VariableQuery <br/>
 * Package : rules <br/>
 * Project : RuleProject <br/>
 * Created On : 15.01.2006 <br/>
 * Description : Query class for the Matchfinder. Ensures equality 
 * of attributes which is demanded by rule by using same variable. 
 * 
 * @author Enrico Biermann <br>
 * @author Guenter Kuhns <br>
 */
public class VariableQuery extends Query {
	
	/** compared attributes: source */
	private final EAttribute sourceAttribute;
	
	/** compared attributes: target */
	private final EAttribute targetAttribute;
	
	/**
	 * Default constructor.
	 * 
	 * @param creator			instantiated variable 
	 * @param target			second variable, has equal attribute value to creator
	 * @param sourceAttribute	compared attribute at creator
	 * @param targetAttribute	compared attribute at target
	 */
	public VariableQuery(Variable creator, Variable target, EAttribute sourceAttribute, EAttribute targetAttribute) {
		super(creator, target);
		this.sourceAttribute = sourceAttribute;
		this.targetAttribute = targetAttribute;
	}
	
	/**
	 * Evaluate query. Objects at target domain with different attribute value are removed.
	 */
	public boolean eval() {
		if(creator.isInstanciated()) {
			init();
			//get attribute values
			Object sourceValue = creator.getInstanceValue().eGet(sourceAttribute);
			
			if (target.isInstanciated()) {
				//target instantiated: return true if the values match
				Object targetValue= target.getInstanceValue().eGet(targetAttribute);
				return matches(sourceValue, targetValue);
			} else {
				//target not instantiated: retain matching targets
				for (EObject targetObject : preDynamic) {
					Object targetValue= targetObject.eGet(targetAttribute);
					if (matches(sourceValue, targetValue)) {
						values.add(targetObject);
					}
				}
				if (! values.isEmpty()) {
					target.setDynamicDomain(values);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * @param source	some object
	 * @param target	some other object
	 * @return			true, if both are null or equal
	 */
	private boolean matches(Object source, Object target) {
		if (source == null) {
			return target == null;
		} else {
			return source.equals(target);
		}
	}
}
