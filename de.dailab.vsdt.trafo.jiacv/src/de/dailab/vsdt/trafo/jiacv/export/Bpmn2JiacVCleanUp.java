package de.dailab.vsdt.trafo.jiacv.export;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.TransformationRule;
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
				transformation.transform(eObject);
			}
		}
		return true;
	}
	
	class InternalTransformation extends Transformation {
		
		@Override
		protected List<List<TransformationRule>> initRules() {
			List<List<TransformationRule>> layers= new ArrayList<List<TransformationRule>>();
			
			//clean up
			List<TransformationRule> layer0= new ArrayList<TransformationRule>();
//			layer0.add(new FlattenSequenceRule(root));
	
			layers.add(layer0);
			return layers;
		}
	}
}