package de.dailab.vsdt.trafo.jiacbeans.export;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.TransformationRule;
import de.dailab.vsdt.trafo.base.Transformation;

/**
 * Transformation of JIAC V models to improve readability.
 * 
 * @author kuester
 */
public class Bpmn2JiacBeansCleanUp extends MappingStage {
	
	@Override
	public void initialize() {
	}
	
	@Override
	protected boolean internalApply() {
		List<List<TransformationRule>> rules= new ArrayList<List<TransformationRule>>();
		
		//clean up
		List<TransformationRule> layer0= new ArrayList<TransformationRule>();
//		layer0.add(new FlattenSequenceRule(root));
		rules.add(layer0);
		
		for (Object o : wrapper.getTargetModels()) {
			if (o instanceof EObject) {
				Transformation.transform((EObject) o, rules);
			}
		}
		return true;
	}
	
}