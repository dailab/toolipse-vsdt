package de.dailab.vsdt.trafo.bpel.export;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.AbstractRule;
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
		protected List<List<AbstractRule>> initRules() {
			List<List<AbstractRule>> layers= new ArrayList<List<AbstractRule>>();
			
			//clean up
			List<AbstractRule> layer0= new ArrayList<AbstractRule>();
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