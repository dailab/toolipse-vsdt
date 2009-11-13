package de.dailab.vsdt.trafo.strucbpmn.export;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.AbstractRule;
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
		transformation.initialize((EObject) wrapper.getSourceModel());
		transformation.transform();
		return true;
	}

	
	class InternalTransformation extends Transformation {

		@Override
		protected List<List<AbstractRule>> initRules() {
			List<List<AbstractRule>> layers= new ArrayList<List<AbstractRule>>();
			
			/*
			 * The ordering of the structuring rules is of great importance, as it can
			 * have effects on whether and how a rule is applied in a certain situation.
			 * E.g., the block rule will be applied as soon as there are two gateways
			 * connected with two branches, even if there are other branches that belong
			 * to these two gateways but are not yet connected. Thus the block rule should
			 * be tried last, after e.g. the loop rule and the event handler rules. 
			 */
			
			//normalization
			List<AbstractRule> layer0= new ArrayList<AbstractRule>();
			layer0.add(new ConnectLinkRule(root));
			layer0.add(new InsertEmptyRule(root));
			layer0.add(new InsertEmptyRule2(root));
			layer0.add(new InsertGatewayRule(root));
			layer0.add(new SplitGatewayRule(root));
			layer0.add(new InitialGatewayRule(root));
			layer0.add(new FinalGatewayRule(root));
			layers.add(layer0);
			
			//structure mapping
			List<AbstractRule> layer1= new ArrayList<AbstractRule>();
			layer1.add(new SequenceRule(root));
//			layer1.add(new BlockRule(root));
			layer1.add(new LoopRule(root));
			layer1.add(new BoundaryEventBlockRule(root));
			layer1.add(new BoundaryEventCompRule(root));
			layer1.add(new BoundaryEventSkipRule(root));
			layer1.add(new BoundaryEventLoopRule(root));
			layer1.add(new BlockRule(root));
			layer1.add(new OverlappedBlockRule(root));
			layers.add(layer1);
			
			//clean up
			List<AbstractRule> layer2= new ArrayList<AbstractRule>();
			layer2.add(new RemoveEmptyRule(root));
			layers.add(layer2);
			
			return layers;
		}
	}
}