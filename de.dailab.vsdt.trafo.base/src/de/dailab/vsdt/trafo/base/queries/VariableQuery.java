package de.dailab.vsdt.trafo.base.queries;

import java.util.Iterator;

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
public class VariableQuery extends Query{
	
	/**names of compared attributes: source*/
	private String sourceAttribute = null;
	
	/**names of compared attributes: target*/
	private String targetAttribute = null;
	
	/**
	 * Default constructor.
	 * 
	 * @param creator			instantiated variable 
	 * @param target			second variable, has equal attribute value to creator
	 * @param sourceAttribute	compared attribute at creator
	 * @param targetAttribute	compared attribute at target
	 */
	public VariableQuery(Variable creator,Variable target, String sourceAttribute, String targetAttribute){
		super(creator,target);
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
			
			if (target.isInstanciated()){
				//target instantiated: return true if the values are the same
				EObject targetObject = target.getInstanceValue();
				Object targetValue= targetObject.eGet(targetAtt);
				if (sourceValue == null) {
					if (targetValue == null) {
						return true;
					}
				} else { 
					if (sourceValue.equals(targetValue)) {
						return true;
					}
				}
			} else {
				//target not instantiated: retain possible targets in the values list
				for (Iterator<EObject> it = preDynamic.iterator();it.hasNext();) {
					EObject targetObject = it.next();
					Object targetValue= targetObject.eGet(targetAtt);
					if(sourceValue == null){
						if (targetValue == null) {
							values.add(targetObject);
						}
					} else { 
						if (sourceValue.equals(targetValue)) {
							values.add(targetObject);
						}
					}
				}
				if (values.size() > 0) {
					target.setDynamicDomain(values);
					return true;
				}
			}
		}
		return false;
	}
}
