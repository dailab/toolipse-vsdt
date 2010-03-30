package de.dailab.vsdt.diagram.imprt;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.Property;

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
			boolean layout, boolean merge) {
		super(from, to, backup, layout, merge, "Vsdt_meta");
	}
	
	/**
	 * Determine whether the two EObjects can be merged, which is determined by
	 * some special attribute, like 'name' or 'id'.
	 * 
	 * @param first		First Object
	 * @param second	Second Object
	 * @return			can be merged?
	 */
	@Override
	protected boolean canMergeModel(EObject first, EObject second) {
		if (first == null || second == null) return false;
		if (first.eClass() != second.eClass()) return false;
	
		// VSDT specific tests
		if (first instanceof IdObject) {
			IdObject idObject1= (IdObject) first;
			IdObject idObject2= (IdObject) second;
			return testEquals(idObject1.getId(), idObject2.getId());
		}
		if (first instanceof Message) {
			Message msg1 = (Message) first;
			Message msg2 = (Message) second;
			return testEquals(msg1.getName(), msg2.getName());
		}
		if (first instanceof Implementation) {
			Implementation impl1 = (Implementation) first;
			Implementation impl2 = (Implementation) second;
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
		
		return super.canMergeModel(first, second);
	}
	
}
