package de.dailab.vsdt.trafo.jiacv.export.stages;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.AbstractRule;
import de.dailab.vsdt.trafo.base.Transformation;

public class Bpmn2JiacVCleanUp extends MappingStage {
	
	@Override
	public void initialize() {
	}
	
	@Override
	protected boolean internalApply() {
		Transformation transformation= new InternalTransformation();
		for (Object o : wrapper.getTargetModels()) {
			if (o instanceof EObject) {
				EObject eObject = (EObject) o;
				transformation.initialize(eObject);
				transformation.transform();
			}
		}
		return true;
	}
	
	class InternalTransformation extends Transformation {
		
		@Override
		protected List<List<AbstractRule>> initRules() {
			List<List<AbstractRule>> layers= new ArrayList<List<AbstractRule>>();
			
			//clean up
			List<AbstractRule> layer0= new ArrayList<AbstractRule>();
//			layer0.add(new FlattenSequenceRule(root));
	
			layers.add(layer0);
			return layers;
		}
	}
}