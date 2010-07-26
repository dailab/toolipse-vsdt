package de.dailab.vsdt.trafo.strucbpmn.export;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.TransformationRule;
import de.dailab.vsdt.trafo.base.Transformation;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.ConnectLinkRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.FinalGatewayRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InitialGatewayRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InsertEmptyRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InsertEmptyRule2;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InsertGatewayRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.SplitGatewayRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l1.BlockRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l1.BoundaryEventBlockRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l1.BoundaryEventCompRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l1.BoundaryEventLoopRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l1.BoundaryEventSkipRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l1.LoopRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l1.OverlappedBlockRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l1.SequenceRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l2.RemoveEmptyRule;

/**
 */
public class Bpmn2StrucBpmnTransformation extends MappingStage {
	
	@Override
	public void initialize() {
	}
	
	@Override
	protected boolean internalApply() {
		Transformation transformation= new InternalTransformation();
		transformation.transform((EObject) wrapper.getSourceModel());
		return true;
	}

	
	class InternalTransformation extends Transformation {

		@Override
		protected List<List<TransformationRule>> initRules() {
			List<List<TransformationRule>> layers= new ArrayList<List<TransformationRule>>();
			
			/*
			 * The ordering of the structuring rules is of great importance, as 
			 * it can have effects on whether and how a rule is applied in a 
			 * certain situation. E.g., the block rule will be applied as soon 
			 * as there are two gateways connected with two branches, even if 
			 * there are other branches that belong to these two gateways but 
			 * are not yet connected. Thus the block rule should be tried last, 
			 * after e.g. the loop rule and the event handler rules. 
			 */
			
			//normalization
			List<TransformationRule> layer0= new ArrayList<TransformationRule>();
			layer0.add(new ConnectLinkRule());
			layer0.add(new InsertEmptyRule());
			layer0.add(new InsertEmptyRule2());
			layer0.add(new InsertGatewayRule());
			layer0.add(new SplitGatewayRule());
			layer0.add(new InitialGatewayRule());
			layer0.add(new FinalGatewayRule());
			layers.add(layer0);
			
			//structure mapping
			List<TransformationRule> layer1= new ArrayList<TransformationRule>();
			layer1.add(new SequenceRule());
			layer1.add(new LoopRule());
			layer1.add(new BoundaryEventBlockRule());
			layer1.add(new BoundaryEventCompRule());
			layer1.add(new BoundaryEventSkipRule());
			layer1.add(new BoundaryEventLoopRule());
			layer1.add(new BlockRule());
			layer1.add(new OverlappedBlockRule());
			layers.add(layer1);
			
			//clean up
			List<TransformationRule> layer2= new ArrayList<TransformationRule>();
			layer2.add(new RemoveEmptyRule());
			layers.add(layer2);
			
			return layers;
		}
	}
}