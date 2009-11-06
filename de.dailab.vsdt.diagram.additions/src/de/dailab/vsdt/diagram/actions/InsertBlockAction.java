package de.dailab.vsdt.diagram.actions;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * This Action can be used to insert a new (parallel or concurrent) Block on 
 * an existing Sequence Flow edge.
 * 
 * @author kuester
 */
public class InsertBlockAction extends InsertPatternAction {

	public String getCommandName() {
		return "Insert Block";
	}
	
	@Override
	public boolean addCreationCommands(CompoundCommand cc) {
		Rectangle b= seqFlowEditPart.getFigure().getBounds();
		Point p= b.getCenter().translate(-30,-40);
		compEditPart.getFigure().translateToAbsolute(p);
		
		// Create First Gateway Command
		CreateViewRequest gateway1Request = CreateViewRequestFactory.getCreateShapeRequest(
				VsdtElementTypes.Gateway_2006,
				compEditPart.getDiagramPreferencesHint());
		gateway1Request.setLocation(p.getCopy().translate(- b.width/4, 0));
		cc.add(compEditPart.getCommand(gateway1Request));
		adapterForFirstNode = (IAdaptable) ((List) gateway1Request.getNewObject()).get(0);
		
		// Create Second Gateway Command
		CreateViewRequest gateway2Request = CreateViewRequestFactory.getCreateShapeRequest(
				VsdtElementTypes.Gateway_2006,
				compEditPart.getDiagramPreferencesHint());
		gateway2Request.setLocation(p.getCopy().translate(b.width/4, 0));
		cc.add(compEditPart.getCommand(gateway2Request));
		adapterForLastNode = (IAdaptable) ((List) gateway2Request.getNewObject()).get(0);
		
		// Create first Sequence Flow
		CreateConnectionViewAndElementRequest seqFlowRequest= new CreateConnectionViewAndElementRequest(
				VsdtElementTypes.SequenceFlow_3001,
				((IHintedType) VsdtElementTypes.SequenceFlow_3001).getSemanticHint(),
				seqFlowEditPart.getDiagramPreferencesHint());
		ICommand createSequenceFlowCmd = new DeferredCreateConnectionViewAndElementCommand(
				seqFlowRequest,
				adapterForFirstNode,
				adapterForLastNode,
				seqFlowEditPart.getViewer());
		cc.add(new ICommandProxy(createSequenceFlowCmd));

		// Create second Sequence Flow
		seqFlowRequest= new CreateConnectionViewAndElementRequest(
				VsdtElementTypes.SequenceFlow_3001,
				((IHintedType) VsdtElementTypes.SequenceFlow_3001).getSemanticHint(),
				seqFlowEditPart.getDiagramPreferencesHint());
		createSequenceFlowCmd = new DeferredCreateConnectionViewAndElementCommand(
				seqFlowRequest,
				isCreateLoop() ? adapterForLastNode : adapterForFirstNode,
				isCreateLoop() ? adapterForFirstNode : adapterForLastNode,
				seqFlowEditPart.getViewer());
		cc.add(new ICommandProxy(createSequenceFlowCmd));

		return true;
	}
	
	protected boolean isCreateLoop() {
		return false;
	}
	
}
