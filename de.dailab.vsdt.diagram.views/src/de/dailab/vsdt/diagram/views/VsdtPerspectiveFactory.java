package de.dailab.vsdt.diagram.views;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * This class provides a default perspective for the Visual Service Design Tool.
 * The perspective features the Resource, Outline, Problem, Task and Property View.
 * 
 * @author kuester
 */
public class VsdtPerspectiveFactory implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		// Get the editor area.
		 String editorArea = layout.getEditorArea();
		 
		 // Top left: Resource Navigator
		 IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, 0.25f,editorArea);
		 topLeft.addView(IPageLayout.ID_RES_NAV);
		 
		 // Bottom left: Outline view
		 IFolderLayout bottomLeft = layout.createFolder("bottomLeft", IPageLayout.BOTTOM, 0.6f,"topLeft");
		 bottomLeft.addView(IPageLayout.ID_OUTLINE);
		  
		 // Bottom right: Problem View, Task List view, Property Sheet, RSD View
		 IFolderLayout bottomRight = layout.createFolder("bottomRight", IPageLayout.BOTTOM, 0.6f,editorArea);
		 bottomRight.addView(IPageLayout.ID_PROBLEM_VIEW);
		 bottomRight.addView(IPageLayout.ID_TASK_LIST);
		 bottomRight.addView(IPageLayout.ID_PROP_SHEET);
		 
	}

}
