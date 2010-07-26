package de.dailab.vsdt.trafo.bpel.export;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.TransformationRule;
import de.dailab.vsdt.trafo.base.Transformation;
import de.dailab.vsdt.trafo.bpel.export.rules.FlattenSequenceRule;
import de.dailab.vsdt.trafo.bpel.export.rules.MergeConsecutiveAssignsRule;
import de.dailab.vsdt.trafo.bpel.export.rules.RemoveEmptyOtherwiseRule;
import de.dailab.vsdt.trafo.bpel.export.rules.SingletonSequenceRule;

public class Bpmn2BpelCleanUp extends MappingStage {
	
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
			layer0.add(new FlattenSequenceRule());
			layer0.add(new MergeConsecutiveAssignsRule());
			layer0.add(new SingletonSequenceRule());
//			layer0.add(new RemoveEmptyRule(root));
			layer0.add(new RemoveEmptyOtherwiseRule());
	
			layers.add(layer0);
			return layers;
		}
	}
}