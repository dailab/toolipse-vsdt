package de.dailab.vsdt.diagram.actions.structuring;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * This Action can be used to insert a new Node on an existing Sequence Flow edge.
 * The existing sequence flow is split up, i.e. the existing sequence flow (possible
 * with conditions) is inserted before the new node and a new sequence flow is created
 * and inserted after the newly created node.
 * 
 * This abstract superclass provides all that is necessary for inserting any of the 
 * node subclasses. Implementations of this class only have to provide the element to
 * be inserted.
 * 
 * @author kuester
 */
public abstract class InsertNodeAction extends InsertPatternAction {

	public String getCommandName() {
		return "Insert " + getElementType().getDisplayName();
	}
	
	/**
	 * This is the only method that has to be overwritten to implement this class.
	 * It has to return the specific VsdtElementType to create with the action.
	 * Of course the element to be created should be some kind of node...
	 * 
	 * @return		IElementType to create.
	 */
	public abstract IElementType getElementType();
	
	
	@Override
	public boolean addCreationCommands(CompoundCommand cc) {
		// Create Node Command
		CreateViewRequest nodeRequest = CreateViewRequestFactory.getCreateShapeRequest(getElementType(), compEditPart.getDiagramPreferencesHint());
		Point p= seqFlowEditPart.getFigure().getBounds().getCenter();
		p.translate(-30, -40);
		compEditPart.getFigure().translateToAbsolute(p);
		nodeRequest.setLocation(p);

		Command creatNodeCmd = compEditPart.getCommand(nodeRequest);
		cc.add(creatNodeCmd);
		
		adapterForFirstNode = getCreatedObject(nodeRequest);
		adapterForLastNode = adapterForFirstNode;
		adapterForNodeToBeEdited= adapterForFirstNode;
		
		return true;
	}
	
}
