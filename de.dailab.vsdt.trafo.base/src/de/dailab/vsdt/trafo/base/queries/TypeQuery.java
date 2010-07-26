package de.dailab.vsdt.trafo.base.queries;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.Variable;


/**
 * TODO javadoc
 */
public class TypeQuery extends Query{
	
	/**NAC sub-type*/
	private final EClass type;
	
	/**
	 * Default constructor.
	 *  
	 * @param target	instantiated and evaluated variable
	 * @param type		NAC sub-type
	 */
	public TypeQuery(Variable target, EClass type){
		super(target,target);
		this.type = type;
	}
	
	/**
	 * Checks if current instance value of variable has the correct sub-type.
	 */
	public boolean eval(){
		EObject sourceValue = creator.getInstanceValue();
		return sourceValue.eClass() == type;
	}
	
}