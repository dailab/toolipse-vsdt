package de.dailab.vsdt.diagram.interpreter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;

import de.dailab.common.swt.ImageLoader;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;
import de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry;
import de.dailab.vsdt.interpreter.AbstractSimulation;
import de.dailab.vsdt.interpreter.State;

/**
 * This class could be used for decorating the flow objects in a more elegant
 * and more as-should-be way instead of the proprietary solution being currently 
 * used.  However, since it can no be used for decorating the connections in the
 * desired way we will stick with our own solution for now...
 * 
 * @author kuester
 */
public class SimulationDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

	private static final String KEY = "simulationStatus"; //$NON-NLS-1$

	private static Map<EObject, IDecorator> allDecorators = new HashMap<EObject, IDecorator>();

	private static transient AbstractSimulation simulation;
	
	/**
	 * 
	 */
	public void createDecorators(IDecoratorTarget decoratorTarget) {
		EditPart editPart = (EditPart) decoratorTarget.getAdapter(EditPart.class);
		if (editPart instanceof GraphicalEditPart || editPart instanceof AbstractConnectionEditPart) {
			Object model = editPart.getModel();
			if ((model instanceof View)) {
				View view = (View) model;
				if (!(view instanceof Edge) && !view.isSetElement()) {
					return;
				}
			}
			EditDomain ed = editPart.getViewer().getEditDomain();
			if (!(ed instanceof DiagramEditDomain)) {
				return;
			}
			if (((DiagramEditDomain) ed).getEditorPart() instanceof VsdtDiagramEditor) {
				decoratorTarget.installDecorator(KEY, new SimulatorDecorator(decoratorTarget));
			}
		}
	}

	/**
	 * 
	 */
	public boolean provides(IOperation operation) {
		if (!(operation instanceof CreateDecoratorsOperation)) {
			return false;
		}
		IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation).getDecoratorTarget();
		View view = (View) decoratorTarget.getAdapter(View.class);
		return view != null && BusinessProcessDiagramEditPart.MODEL_ID.equals(VsdtVisualIDRegistry.getModelID(view));
	}

	/**
	 * 
	 */
	public static void refreshDecorators(AbstractSimulation simulation, Diagram diagram) {
		SimulationDecoratorProvider.simulation= simulation;
		if (allDecorators == null || allDecorators.isEmpty() || diagram == null) {
			return;
		}
		final Diagram fdiagram = diagram;
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			public void run() {
				try {
					TransactionUtil.getEditingDomain(fdiagram).runExclusive(new Runnable() {
						public void run() {
							for (IDecorator decorator : allDecorators.values()) {
								decorator.refresh();
							}
						}
					});
				} catch (Exception e) {
					VsdtDiagramEditorPlugin.getInstance().logError("Decorator refresh failure", e); //$NON-NLS-1$
				}
			}
		});
	}


	/**
	 * Get an Icon representing the given state. This icon can be used both as an
	 * icon for a menu item, e.g. in the InterpreterView, or for the figure in
	 * the diagram itself (although here scalable graphics would be better). 
	 * 
	 * @param state		some state
	 * @return			Small Icon according to this State
	 */
	public static ImageDescriptor getImageForState(State state) {
		switch (state) {
		case READY:
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_READY);
		case ACTIVE_WAITING:
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_ACTIVE_WAITING);
		case ACTIVE_READY:
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_ACTIVE_READY);
		case DONE: 
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_DONE);
		case FAILED:
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_FAILED);
		case LOOPING_READY:
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_READY);
		default:
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_IDLE);
		}
	}
	
	/**
	 * 
	 */
	public static class SimulatorDecorator extends AbstractDecorator {

		EObject element;
		
		/**
		 * 
		 */
		public SimulatorDecorator(IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
			// get element from decorator target
			EditPart editPart = (EditPart) decoratorTarget.getAdapter(EditPart.class);
			if (editPart.getModel() instanceof View) {
				this.element= ((View) editPart.getModel()).getElement();
			}
		}

		/**
		 * 
		 */
		public void refresh() {
			removeDecoration();
			if (simulation == null) return;
			// get state from simulator
			if (element instanceof FlowObject) {
				FlowObject flowObject = (FlowObject) element;
				State state= simulation.getState(flowObject);

				if (state != null && state != State.IDLE) {
					// add decoration
					Image image= ImageLoader.getInstance().getImage(getImageForState(state));
					EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
					int margin = -1;
					if (editPart instanceof org.eclipse.gef.GraphicalEditPart) {
						margin = MapModeUtil.getMapMode( ((org.eclipse.gef.GraphicalEditPart) editPart).getFigure()).DPtoLP(margin);
					}
					setDecoration(getDecoratorTarget().addShapeDecoration(image,IDecoratorTarget.Direction.NORTH_WEST,margin, true));
				}
			}
		}

		/**
		 * 
		 */
		public void activate() {
			// add self to global decorators registry
			if (element != null) {
				allDecorators.put(element, this);
			}
		}

		/**
		 * 
		 */
		public void deactivate() {
			// remove self from global decorators registry
			if (element == null) {
				allDecorators.remove(element);
			}
			super.deactivate();
		}
	}

}
