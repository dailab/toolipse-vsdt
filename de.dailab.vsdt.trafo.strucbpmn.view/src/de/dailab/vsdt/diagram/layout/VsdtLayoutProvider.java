package de.dailab.vsdt.diagram.layout;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.AbstractLayoutEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNode;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNodeOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;

/**
 */
public class VsdtLayoutProvider extends AbstractLayoutEditPartProvider {
    
	public static String DEFAULT_LAYOUT = "Default";
	
	/**
	 * this layout shall only be provided for the 'Vsdt' editor and not override layouts defined for other editors
	 */
	public boolean provides(IOperation operation) {
	    if (operation instanceof ILayoutNodeOperation) {
	    	ILayoutNodeOperation layoutNodeOperation= (ILayoutNodeOperation) operation;
    		for (Object object : layoutNodeOperation.getLayoutNodes()) {
    			View node = ((ILayoutNode) object).getNode();
	            Diagram container = node.getDiagram();
	            if (container == null || !(container.getType().equals("Vsdt"))) {//$NON-NLS-1$
	                return false;	
	            }
	    	}
	    } else {
	        return false;
	    }
	    IAdaptable layoutHint = ((ILayoutNodeOperation) operation)
	        .getLayoutHint();
	    String layoutType = (String) layoutHint.getAdapter(String.class);
	    return LayoutType.DEFAULT.equals(layoutType);
//	    return false;
	}

	@Override
	public Command layoutEditParts(GraphicalEditPart containerEditPart,
			IAdaptable layoutHint) {
		List<EditPart> editParts= containerEditPart.getChildren();
		return layoutEditParts(editParts, layoutHint);
	}
	
	@Override
	public Command layoutEditParts(List selectedObjects, IAdaptable layoutHint) {
    	// calculate new Layout
    	IWorkbenchPage workbenchPage= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    	
    	StructureLayout layout= new StructureLayout();
		Map<FlowObject, Rectangle> layoutMap= layout.createLayoutMap((VsdtDiagramEditor) workbenchPage.getActiveEditor());
		return layout.getLayoutCommand(selectedObjects, false, layoutMap);
	}
	
}
