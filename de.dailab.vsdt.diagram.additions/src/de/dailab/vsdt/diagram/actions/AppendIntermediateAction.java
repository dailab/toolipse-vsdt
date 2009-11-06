package de.dailab.vsdt.diagram.actions;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * An Action for appending a new Activity Node after an existing Flow Object.
 * 
 * @author kuester
 */
public class AppendIntermediateAction extends AppendNodeAction {

	@Override
	public IElementType getElementType() {
		return VsdtElementTypes.Intermediate_2003;
	}
	
}
