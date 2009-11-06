package de.dailab.vsdt.diagram.actions.structuring;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * An Action for inserting a new Gateway Node an an existing Sequence Flow.
 * 
 * @author kuester
 */
public class InsertGatewayAction extends InsertNodeAction {

	@Override
	public IElementType getElementType() {
		return VsdtElementTypes.Gateway_2006;
	}
	
}
