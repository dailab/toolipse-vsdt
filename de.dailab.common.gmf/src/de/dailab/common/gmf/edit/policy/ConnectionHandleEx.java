package de.dailab.common.gmf.edit.policy;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.DragTracker;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle;
import org.eclipse.gmf.runtime.diagram.ui.internal.tools.ConnectionHandleTool;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

/**
 * Special ConnectionHandle holding the type of the (single) element to be created
 * and providing a special image for each element and each direction.
 * 
 * @author kuester
 */
public abstract class ConnectionHandleEx extends ConnectionHandle {

	private IElementType type;

	public ConnectionHandleEx(IGraphicalEditPart ownerEditPart, boolean incoming, IElementType type) {
		super(
				ownerEditPart, 
				incoming ? HandleDirection.INCOMING : HandleDirection.OUTGOING,
				(incoming ? "Incoming " : "Outgoing ") + type.getDisplayName());
		this.type= type;
	}
	
	public IElementType getType() {
		return type;
	}

	@Override
	protected Image getImage(int side) {
		String path= getImagePath(type.getDisplayName(), side, isIncoming());
		ImageDescriptor descriptor= getDescriptor(path);
		if (descriptor != null) {
			return descriptor.createImage();
		} else {
			return super.getImage(side);
		}
	}
	
	/**
	 * Get the path to the image to be displayed for the given type and context. 
	 * 
	 * @param typeName		name of the element type to be created
	 * @param side			border side (one of PositionConstants.N|S|E|W
	 * @param isIncoming	Image for incoming flow?
	 * @return
	 */
	protected abstract String getImagePath(String typeName, int side, boolean isIncoming);
	
	/**
	 * Retrieves an ImageDescriptor for the given path.
	 * Example: return path != null ? VsdtDiagramEditorPlugin.imageDescriptorFromPlugin(VsdtDiagramEditorPlugin.ID, "icons/" + path) : null ;
	 * 
	 * @param path		Some path relative to the plugin project or a special folder within it
	 * @return			ImageDescriptor for the given Icon
	 */
	protected abstract ImageDescriptor getDescriptor(String path);
	
	@Override
	protected DragTracker createDragTracker() {
		return new ConnectionHandleToolEx(this);
	}
	
	/**
	 * This ConnectionHandleTool is taking the type of the element to be
	 * created into account.
	 * 
	 * @author kuester
	 */
	public static class ConnectionHandleToolEx extends ConnectionHandleTool {
		private ConnectionHandleEx handle;
		private ConnectionHandleToolEx(ConnectionHandleEx handle) {
			super(handle);
			this.handle= handle;
		}

	    protected Request createTargetRequest() {
	        List<IElementType> relTypes = new ArrayList<IElementType>();
	        relTypes.add(handle.getType());
	        CreateUnspecifiedTypeConnectionRequest request=	new CreateUnspecifiedTypeConnectionRequest(
	        		relTypes, 
	        		false, 
	        		getPreferencesHint());
            request.setDirectionReversed(handle.isIncoming());
            return request;
	    }
	}

}
