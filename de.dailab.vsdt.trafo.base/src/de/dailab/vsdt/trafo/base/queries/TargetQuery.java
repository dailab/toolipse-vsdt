package de.dailab.vsdt.trafo.base.queries;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.dailab.vsdt.trafo.base.Variable;


/**
 * Class : TargetQuery <br/>
 * Package : rules <br/>
 * Project : RuleProject <br/>
 * Created On : 10.01.2006 <br/>
 * Description : Query class for the Matchfinder. 
 * Ensures that references of instantiated variables have valid targets.
 * 
 * @author Enrico Biermann <br>
 * @author Guenter Kuhns <br>
 */
public class TargetQuery extends Query {
	
	/**the reference*/
	private EStructuralFeature ref= null;
	
	/**
	 * Default constructor.
	 *  
	 * @param creator	instantiated variable
	 * @param target	other variable, target of a link from creator
	 * @param ref		reference feature
	 */
	public TargetQuery (Variable creator, Variable target, EStructuralFeature ref) {
		super(creator,target);
		this.ref= ref;
	}
	
	/**
	 * Domain of the target variable is reduced to the elements which are referenced from
	 * the source value.
	 */
	public boolean eval() {
		if (creator.isInstanciated()) {
			init();
			EObject sourceValue= creator.getInstanceValue();
			
			//add values referenced by creator in values list, if in predynamic
			if (! ref.isMany()) {
				EObject targetValue= (EObject)sourceValue.eGet(ref); 
				if (preDynamic.contains(targetValue)) {
					values.add(targetValue);
				}
			} else {
				EList<EObject> targetValues = (EList) sourceValue.eGet(ref);
				for (Iterator<EObject> it = targetValues.iterator();it.hasNext();) {  
					EObject targetValue= it.next();	
					if (preDynamic.contains(targetValue)) {
						values.add(targetValue);
					}
				}
			}
			if (values.size() > 0) {
				//some values found for this query
				target.setDynamicDomain(values);
				return true;
			}
		}
		return false;
	}
	
}
