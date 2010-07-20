package de.dailab.vsdt.diagram.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.jface.action.Action;

import de.dailab.common.gmf.Util;
import de.dailab.common.gmf.edit.part.AbstractGmfConnectionEditPart;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.Node;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.diagram.edit.parts.PoolEditPart;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * This Action toggles a Pool's visibility by (de)activating it and en/disabling edit mode.
 * 
 * TODO do not display connections if the pool on the other end is still hidden
 * 
 * @author kuester
 */
public class SetPoolVisibilityAction extends Action {

	public static final String TEXT= "Toggle Visibility";
	public static final String TOOLTIP= "Toggle a Pool's Visibility";

	public static final int MODE_SHOW= 0;
	public static final int MODE_HIDE= 1;
	public static final int MODE_TOGGLE= 2;
	
	private final PoolEditPart poolEditPart;
	private final int mode;
	
	/**
	 * @param pool		Pool to toggle the visibility	
	 * @param mode		new visibility mode (one of MODE_SHOW, MODE_HIDE, MODE_TOGGLE)
	 */
	public SetPoolVisibilityAction(PoolEditPart poolEditPart, int mode) {
		this.poolEditPart= poolEditPart;
		this.mode= mode;
		this.setText(TEXT);
		this.setToolTipText(TOOLTIP);
//		this.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
	}
	
	@Override
	public void run() {
		if (poolEditPart != null) {
			DiagramEditPart diagramEditPart= Util.getDiagramEditPart(poolEditPart);
			Pool pool= poolEditPart.getCastedModel();
			
			// what to do?
			boolean newState;
			if (poolEditPart.isActive()) {
				if (mode == MODE_SHOW) {
					return;
				} else {
					newState= false;
				}
			} else {
				if (mode == MODE_HIDE) {
					return;
				} else {
					newState= true;
				}
			}
			
			// set Pool's visibility
			Util.setVisible(poolEditPart, newState);
	
			// set Connections' visibility
			for (ConnectingObject connection : pool.getParent().getConnections()) {
				boolean relevant= false;
				EObject source= VsdtHelper.getSource(connection);
				if (source instanceof Node) {
					relevant|= ((Node) source).getPool() == pool;
				}
				EObject target= VsdtHelper.getTarget(connection);
				if (target instanceof Node) {
					relevant|= ((Node) target).getPool() == pool;
				}
				if (relevant) {
					AbstractGmfConnectionEditPart editPart = (AbstractGmfConnectionEditPart) 
							Util.findFirstEditPart(connection, diagramEditPart, AbstractGmfConnectionEditPart.class);
					if (editPart != null && editPart.resolveSemanticElement() == connection) {
						Util.setVisible(editPart, newState);
					}
				}
			}
		}
	}
	
}
