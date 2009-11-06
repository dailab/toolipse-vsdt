package de.dailab.vsdt.trafo.base.queries;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.Variable;


/**
 * Class : TypeQuery <br/>
 * Package : rules <br/>
 * Project : RuleProject <br/>
 * Created On : 15.01.2006 <br/>
 * Description : Query class for the Matchfinder.
 *  
 * Ensures that NAC objects have the correct subtype of their LHS type.
 * 
 * @author Enrico Biermann <br>
 * @author Guenter Kuhns <br>
 */
public class TypeQuery extends Query{
	
	/**NAC subtype*/
	private EClass type;
	
	/**
	 * Default constructor.
	 *  
	 * @param target	instantiated and evaluated variable
	 * @param type		NAC subtype
	 */
	public TypeQuery(Variable target, EClass type){
		super(target,target);
		this.type = type;
	}
	
	/**
	 * Checks if current instance value of variable has the correct subtype.
	 */
	public boolean eval(){
		EObject sourceValue = creator.getInstanceValue();	
		if (sourceValue.eClass() == type) {	
			return true;
		} else {
			return false;	
		}
	}
	
}