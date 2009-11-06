package de.dailab.vsdt.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.providers.LeftRightProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNode;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.ILayoutNodeOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * from the GMF tutorial, part 3
 */
public class VsdtLayoutProvider extends LeftRightProvider {
    
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
	}

}
