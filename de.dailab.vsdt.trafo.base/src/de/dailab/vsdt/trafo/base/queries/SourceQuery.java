package de.dailab.vsdt.trafo.base.queries;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * Class : SourceQuery <br/>
 * Package : rules <br/>
 * Project : RuleProject <br/>
 * Created On : 10.01.2006 <br/>
 * Description : Query class for the Matchfinder. 
 * Ensures that references to instantiated variables have valid sources.
 * 
 * @author Enrico Biermann <br>
 * @author Guenter Kuhns <br>
 */
public class SourceQuery extends Query {
	
	/**reference name*/
	private final EStructuralFeature ref;
	
	/**
	 * Default constructor.
	 * 
	 * @param target	instantiated variable
	 * @param source	other variable, source of a link to target
	 * @param ref		reference feature
	 */
	public SourceQuery(Variable source, Variable target, EStructuralFeature ref) {
		super(target,source);
		this.ref= ref;
	}
	
	/**
	 * Checks for all elements in the domain of the source variable if there
	 * exists a reference with the given name to the target value.
	 */
	public boolean eval() {
		if (creator.isInstanciated()) {
			init();
			EObject targetValue = creator.getInstanceValue();

			//get possible source values
			List<EObject> sourceValues = this.preDynamic;
			if (sourceValues.isEmpty()) {
				return false;
			}

			//iterate over source values, keep those that have the requested reference on the target
			for (EObject source : sourceValues) {
				if (ref.isMany()) {
					List<EObject> targets = (List) source.eGet(ref);
					if (targets.contains(targetValue)) {
						values.add(source);
					}
				}
				else{
					Object targetVal= source.eGet(ref);
					if (targetVal != null && targetVal == targetValue) {
						values.add(source);
					}
				}
			}
			if (! values.isEmpty()) {
				target.setDynamicDomain(values);
				return true;
			}
		}
		return false;
	}
	
}
