package de.dailab.vsdt.diagram.interpreter.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

import de.dailab.common.swt.views.AbstractLabelProvider;
import de.dailab.common.swt.views.AbstractTreeContentProvider;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.diagram.edit.parts.PoolEditPart;
import de.dailab.vsdt.diagram.interpreter.SimulationDecoratorProvider;
import de.dailab.vsdt.diagram.interpreter.VsdtInterpreterPlugin;
import de.dailab.vsdt.diagram.interpreter.simulation.EclipseInterpretingSimulation;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;
import de.dailab.vsdt.interpreter.State;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * This viewer is the main component of the InterpreterView.  Besides the actual
 * viewer, this class also contains the Label and Content Provider Classes used
 * for this viewer.
 * 
 * @author kuester
 */
public class SimulationViewer extends TreeViewer {
	
	private InterpreterView view;
	
	public SimulationViewer(InterpreterView view, Composite parent) {
		super(parent);
		this.view= view;
		setContentProvider(new SimulationViewerContentProvider());
		setLabelProvider(new SimulationViewerLabelProvider());
	}

	/**
	 * This class provides the content for the Interpreter view (D'oh!)
	 * 
	 * @author kuester
	 */
	public class SimulationViewerContentProvider extends AbstractTreeContentProvider implements ITreeContentProvider, ISelectionListener {

//		private VsdtDiagramEditor lastDiagramEditor= null;
		
		@Override
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			// stop simulation when switching the diagram
//			if (lastDiagramEditor != null && lastDiagramEditor != part) {
//				view.stop();
//				view.updateActionEnablement();
//			}
//			if (part instanceof VsdtDiagramEditor) {
//				lastDiagramEditor= (VsdtDiagramEditor) part;
//			}
			view.updateActionEnablement();
			super.selectionChanged(part, selection);
		}

		@Override
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
//			if (view.isRunning()) {
//				view.stop();
//				view.updateActionEnablement();
//			}
			super.inputChanged(v, oldInput, newInput);
		}
		
		public Object[] getElements(Object parent) {
			List<Object> elements= new ArrayList<Object>();
			if (view.isRunning()) {
				if (parent instanceof IWorkbenchPage) {
					IEditorPart editor= ((IWorkbenchPage) parent).getActiveEditor();
					if (editor instanceof VsdtDiagramEditor) {
						DiagramEditPart dep = ((VsdtDiagramEditor)editor).getDiagramEditPart();
						for (Object o : dep.getChildren()) {
							if (o instanceof PoolEditPart) {
								elements.add(((PoolEditPart)o).getCastedModel());
							}
						}
					}
				}
			}
			return elements.toArray();
		}

		public Object[] getChildren(Object parentElement) {
			// collect actual children
			List<FlowObject> children= new ArrayList<FlowObject>();
			if (parentElement instanceof Pool) {
				children.addAll(((Pool) parentElement).getGraphicalElements());
			}
			if (parentElement instanceof Activity) {
				children.addAll(((Activity) parentElement).getGraphicalElements());
				children.addAll(((Activity)parentElement).getBoundaryEvents());
			}
			List<EObject> displayedChildren= new ArrayList<EObject>();
			for (FlowObject flowObject : children) {
				State state= view.getState(flowObject);
				if (state != null && (state.isActiveState() || state.isReadyState())) {
					displayedChildren.add(flowObject);
				}
			}
			// collect property values
			if (view.getSimulation() instanceof EclipseInterpretingSimulation) {
				if (parentElement instanceof Pool) {
					displayedChildren.addAll(((Pool) parentElement).getProperties());
				}
				if (parentElement instanceof Activity) {
					displayedChildren.addAll(((Activity) parentElement).getProperties());
				}
			}
			return displayedChildren.toArray();
		}
		
	}

	/**
	 * This class is used to provide the Labels used in the Interpreter View
	 * 
	 * @author kuester
	 */
	public class SimulationViewerLabelProvider extends AbstractLabelProvider {
		
		protected ImageDescriptor getImageDescriptor(Object element) {
			EObject eObject= (EObject) element;
			if (eObject instanceof Pool) {
			   return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_POOL);
			} else if (eObject instanceof FlowObject) {
				// use another color for intermediate boundary events to prevent accidentally killing the activity
				if (eObject instanceof Intermediate && ((Intermediate)eObject).getAttachedTo() != null) {
					return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_INTER);
				}
				return SimulationDecoratorProvider.getImageForState(view.getState((FlowObject) eObject));
			} else if (eObject instanceof Property) {
				return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_PROPERTY);
			}
			return null;
		}
		
		@Override
		public String getText(Object element) {
			if (element instanceof Pool || element instanceof FlowObject) {
				return VsdtHelper.getDescriptiveName((EObject) element);	
			}
			if (element instanceof Property) {
				Property property= (Property) element;
				if (view.getSimulation() instanceof EclipseInterpretingSimulation) {
					EclipseInterpretingSimulation simulation = (EclipseInterpretingSimulation) view.getSimulation();
					String valString = "";
					if (simulation.getProperties().contains(property)) {
						Object value = simulation.getPropertyValue(property);
						valString= value instanceof String ? "\""+(String)value+"\"":String.valueOf(value);
					}
					String name= property.getName();
					String type= property.getType();
					if (type.indexOf('.') != -1) {
						type = type.substring(type.lastIndexOf('.') + 1);
					}
					return type + " " + name + " = " + valString;
				}
			}
			return null;
		}
		
	}
	
}
