package de.dailab.common.gmf.edit.part;

import org.eclipse.emf.ecore.EObject;

/**
 * This is just a marker interface, assuring that the edit part provides the very useful
 * getCastedModel method.
 * 
 * @author kuester
 */
public interface IModelCastingEditPart {

	/**
	 * Usually implemented as ((View) getModel).getElement()
	 * 
	 * @return the model, casted to its actual Type
	 */
	public EObject getCastedModel();
	
}
