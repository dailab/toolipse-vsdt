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
	
	/**names of compared attributes: source*/
	private final String sourceAttribute;
	
	/**names of compared attributes: target*/
	private final String targetAttribute;
	
	/**
	 * Default constructor.
	 * 
	 * @param creator			instantiated variable 
	 * @param target			second variable, has equal attribute value to creator
	 * @param sourceAttribute	compared attribute at creator
	 * @param targetAttribute	compared attribute at target
	 */
	public VariableQuery(Variable creator, Variable target, String sourceAttribute, String targetAttribute) {
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
			EObject sourceObject = creator.getInstanceValue();
			EAttribute sourceAtt = (EAttribute)sourceObject.eClass().getEStructuralFeature(sourceAttribute);
			Object sourceValue = sourceObject.eGet(sourceAtt);
			EAttribute targetAtt = (EAttribute)target.getDomain().get(0).eClass().getEStructuralFeature(targetAttribute);
			
			if (target.isInstanciated()) {
				//target instantiated: return true if the values match
				Object targetValue= target.getInstanceValue().eGet(targetAtt);
				return matches(sourceValue, targetValue);
			} else {
				//target not instantiated: retain matching targets
				for (EObject targetObject : preDynamic) {
					Object targetValue= targetObject.eGet(targetAtt);
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
