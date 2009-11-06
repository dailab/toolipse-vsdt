package de.dailab.vsdt.diagram.actions;


/**
 * This Action can be used to insert a new Upstream Loop on 
 * an existing Sequence Flow edge.
 * 
 * @author kuester
 */
public class InsertLoopAction extends InsertBlockAction {

	public String getCommandName() {
		return "Insert Loop";
	}

	@Override
	protected boolean isCreateLoop() {
		return true;
	}
	
}
