package de.dailab.vsdt.diagram.actions.structuring;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * An Action for inserting a new Intermediate Node an an existing Sequence Flow.
 * 
 * @author kuester
 */
public class InsertIntermediateAction extends InsertNodeAction {

	@Override
	public IElementType getElementType() {
		return VsdtElementTypes.Intermediate_2003;
	}
	
}
