package de.dailab.vsdt.diagram.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import de.dailab.common.gmf.edit.policy.ConnectionHandleEditPolicyEx;
import de.dailab.vsdt.diagram.custom.VsdtConnectionHandleEx;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * Derived from org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandlerEditPolicy
 * and from the respective class in the STP BPMN plugin.
 * 
 * @author kuester
 * 
 * @generated NOT
 */
public class VsdtConnectionHandleEditPolicyEx extends ConnectionHandleEditPolicyEx {

	/**
	 * Gets the two connection handle figures to be added to this shape if they support user gestures.
	 * 
	 * @param borderSide	the border from which the cursor is the nearest.
	 * @return				a list of <code>ConnectionHandle</code> objects
	 */
	@Override
	protected List<ConnectionHandle> getHandleFigures(int borderSide, List<IElementType> srcEltTypes, List<IElementType> tgtEltTypes) {
		List<ConnectionHandle> list = new ArrayList<ConnectionHandle>();
		switch (borderSide) {
		case PositionConstants.SOUTH:
		case PositionConstants.NORTH:
			// add message flow handles
			addConnectionHandle(tgtEltTypes, list, true, VsdtElementTypes.MessageFlow_3002);
			addConnectionHandle(srcEltTypes, list, false, VsdtElementTypes.MessageFlow_3002);
			break;
		case PositionConstants.WEST:
			// add incoming sequence flow and association handles
			addConnectionHandle(tgtEltTypes, list, true, VsdtElementTypes.SequenceFlow_3001);
			addConnectionHandle(tgtEltTypes, list, true, VsdtElementTypes.Association_3003);
			break;
		case PositionConstants.EAST:
			// add outgoing sequence flow and association handles
			addConnectionHandle(srcEltTypes, list, false, VsdtElementTypes.SequenceFlow_3001);
			addConnectionHandle(srcEltTypes, list, false, VsdtElementTypes.Association_3003);
			break;
		default:
			break;
		}
		return list;
	}

	/**
	 * create new ConnectionHandle
	 * @param types			list of allowed types
	 * @param handles		list of connection handles 
	 * @param incoming		true: incoming, false: outgoing
	 * @param type			element type
	 */
	private void addConnectionHandle(List<IElementType> types, List<ConnectionHandle> handles, boolean incoming, IElementType type) {
		if (types != null && handles != null && types.contains(type)) {
			handles.add(new VsdtConnectionHandleEx((IGraphicalEditPart) getHost(), incoming, type));
		}
	}
}
