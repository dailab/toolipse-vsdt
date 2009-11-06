package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.common.gmf.edit.part.AbstractGmfNodeEditPart;
import de.dailab.vsdt.Group;
import de.dailab.vsdt.diagram.figures.GroupFigure;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;
import de.dailab.vsdt.diagram.preferences.DiagramPreferenceInitializer;


/**
 * this abstract edit part shall be subclassed by the actual edit part used by GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractGroupEditPart extends AbstractGmfNodeEditPart implements IVsdtEditPart {
	
	/**
	 * the standard constructor
	 */
	public AbstractGroupEditPart(View view) {
		super(view);
	}

	/**
	 * @return the model, casted to its actual Type
	 */
	public Group getCastedModel() {
		return (Group) ((View) getModel()).getElement();
	}

	public abstract GroupFigure getPrimaryShape();
	
	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected IFigure initNodeShape() {
		boolean useColor=
			VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(
			DiagramPreferenceInitializer.PREF_USE_ADDITIONAL_COLORS);
		GroupFigure figure= new GroupFigure(useColor);
		return figure;
	}

}
