package de.dailab.vsdt.diagram.custom;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;

import de.dailab.common.gmf.edit.policy.ConnectionHandleEx;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;

/**
 * Special ConnectionHandle holding the type of the (single) element to be created
 * and providing a special image for each element and each direction.
 * 
 * @author kuester
 * 
 * @generated NOT
 */
public class VsdtConnectionHandleEx extends ConnectionHandleEx {

	public static final String IMAGE_HANDLER_SEQ_RIGHT= "handles/seqRight.gif";
	public static final String IMAGE_HANDLER_SEQ_RIGHT_IN= "handles/seqRightIn.gif";
	public static final String IMAGE_HANDLER_SEQ_RIGHT_OUT= "handles/seqRightOut.gif";
	public static final String IMAGE_HANDLER_ASS_RIGHT= "handles/assRight.gif";
	public static final String IMAGE_HANDLER_ASS_RIGHT_IN= "handles/assRightIn.gif";
	public static final String IMAGE_HANDLER_ASS_RIGHT_OUT= "handles/assRightOut.gif";
	public static final String IMAGE_HANDLER_MSG_UP= "handles/msgUp.gif";
	public static final String IMAGE_HANDLER_MSG_UP_IN= "handles/msgUpIn.gif";
	public static final String IMAGE_HANDLER_MSG_UP_OUT= "handles/msgUpOut.gif";
	public static final String IMAGE_HANDLER_MSG_DOWN= "handles/msgDown.gif";
	public static final String IMAGE_HANDLER_MSG_DOWN_IN= "handles/msgDownIn.gif";
	public static final String IMAGE_HANDLER_MSG_DOWN_OUT= "handles/msgDownOut.gif";
	
	
	public VsdtConnectionHandleEx(IGraphicalEditPart ownerEditPart, boolean incoming, IElementType type) {
		super( ownerEditPart, incoming, type);
	}
	
//	@Override
//	protected Image getImage(int side) {
//		int borderSide= ((ConnectionHandleLocator) getLocator()).getBorderSide();
//		boolean in= isIncoming();
//		boolean up= borderSide == PositionConstants.NORTH ^ in;
//		String path= null;
//		if (type.getDisplayName().contains("Sequence")) {
//			path= in ? IMAGE_HANDLER_SEQ_RIGHT_IN : IMAGE_HANDLER_SEQ_RIGHT_OUT;
//		}
//		if (type.getDisplayName().contains("Message")) {
//			if (up) {
//				path= in ? IMAGE_HANDLER_MSG_UP_IN : IMAGE_HANDLER_MSG_UP_OUT;
//			} else {
//				path= in ? IMAGE_HANDLER_MSG_DOWN_IN : IMAGE_HANDLER_MSG_DOWN_OUT;
//			}
//		}
//		if (type.getDisplayName().contains("Association")) {
//			path= in ? IMAGE_HANDLER_ASS_RIGHT_IN : IMAGE_HANDLER_ASS_RIGHT_OUT;
//		}
//		ImageDescriptor descriptor= getDescriptor(path);
//		if (descriptor != null) {
//			return descriptor.createImage();
//		} else {
//			return super.getImage(side);
//		}
//	}
	
	@Override
	protected String getImagePath(String typeName, int side, boolean isIncoming) {
		boolean in= isIncoming();
		boolean up= side == PositionConstants.NORTH ^ in;
		String path= null;
		if (getType().getDisplayName().contains("Sequence")) {
			path= in ? IMAGE_HANDLER_SEQ_RIGHT_IN : IMAGE_HANDLER_SEQ_RIGHT_OUT;
		}
		if (getType().getDisplayName().contains("Message")) {
			if (up) {
				path= in ? IMAGE_HANDLER_MSG_UP_IN : IMAGE_HANDLER_MSG_UP_OUT;
			} else {
				path= in ? IMAGE_HANDLER_MSG_DOWN_IN : IMAGE_HANDLER_MSG_DOWN_OUT;
			}
		}
		if (getType().getDisplayName().contains("Association")) {
			path= in ? IMAGE_HANDLER_ASS_RIGHT_IN : IMAGE_HANDLER_ASS_RIGHT_OUT;
		}
		return path;
	}
	
	@Override
	protected ImageDescriptor getDescriptor(String path) {
		return path != null ? VsdtDiagramEditorPlugin.imageDescriptorFromPlugin(VsdtDiagramEditorPlugin.ID, "icons/" + path) : null ;
	}
	
}
