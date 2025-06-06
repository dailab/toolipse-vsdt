package de.dailab.vsdt.diagram.imprt;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import de.dailab.common.gmf.imprt.DiagramImporter;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;

/**
 * Specialized version of DiagramImporter with overwritten canMerge test to
 * support supporting elements which do not have an ID attribute on their own.
 * 
 * @author kuester
 */
public class VsdtDiagramImporter extends DiagramImporter {
	
	/**
	 * See super constructor. diagramRoot is set to "Vsdt_meta".
	 */
	public VsdtDiagramImporter(List<Resource> from, Resource to, boolean backup, 
			boolean layout, boolean merge, boolean strict) {
		super(from, to, backup, layout, merge, strict, "Vsdt_meta");
	}
	
	/**
	 * Determine whether the two EObjects can be merged, which is determined by
	 * some special attribute, like 'name' or 'id'.
	 * 
	 * @param first		First Object
	 * @param second	Second Object
	 * @param reference the Reference
	 * @return			can be merged?
	 */
	@Override
	protected boolean canMerge(EObject first, EObject second, EReference reference) {
		if (first == null || second == null) return false;
		if (first.eClass() != second.eClass()) return false;
	
		// VSDT specific tests
		if (first instanceof IdObject) {
			IdObject idObject1= (IdObject) first;
			IdObject idObject2= (IdObject) second;
			if (strict) {
				return testEquals(idObject1.getId(), idObject2.getId());
			} else {
				return testEquals(idObject1.getName(), idObject2.getName());
			}
		}
		if (first instanceof MessageChannel) {
			MessageChannel msg1 = (MessageChannel) first;
			MessageChannel msg2 = (MessageChannel) second;
			return testEquals(msg1.getChannel(), msg2.getChannel()) &&
			       testEquals(msg1.getPayload(), msg2.getPayload());
		}
		if (first instanceof Service) {
			Service impl1 = (Service) first;
			Service impl2 = (Service) second;
			return testEquals(impl1.getInterface(), impl2.getInterface()) &&
			       testEquals(impl1.getOperation(), impl2.getOperation());
		}
		if (first instanceof Assignment) {
			Assignment assign1 = (Assignment) first;
			Assignment assign2 = (Assignment) second;
			return testEquals(assign1.getTo(), assign2.getTo()) &&
			       testEqualsOrNull(assign1.getToQuery(), assign2.getToQuery());
		}
		if (first instanceof Property) {
			Property prop1 = (Property) first;
			Property prop2 = (Property) second;
			return testEquals(prop1.getName(), prop2.getName());
		}
		if (first instanceof Expression) {
			// no possibility to distinguish; just merge
			return true;
		}
		
		return super.canMerge(first, second, reference);
	}
	
}
