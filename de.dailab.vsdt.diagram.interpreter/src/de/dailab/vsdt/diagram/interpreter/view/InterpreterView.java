package de.dailab.vsdt.diagram.interpreter.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import de.dailab.common.gmf.Util;
import de.dailab.common.swt.views.AbstractStructuredViewerView;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.interpreter.VsdtInterpreterPlugin;
import de.dailab.vsdt.diagram.interpreter.simulation.EclipseInterpretingSimulation;
import de.dailab.vsdt.diagram.interpreter.simulation.ManualSimulation;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;
import de.dailab.vsdt.interpreter.AbstractSimulation;
import de.dailab.vsdt.interpreter.ISimulation;
import de.dailab.vsdt.interpreter.State;

/**
 * This class provides an Interpreter View, with which the Business Process
 * Diagram currently loaded in the editor can be interpreted step by step.
 * The view provides buttons for starting and stopping the interpretation and
 * for stepping into, out of, and over a selected flow object, given that it is
 * ready.  Which flow objects are ready and what happens when stepping is
 * determined by the {@link ISimulation} used by this view.
 * 
 * @author kuester
 */
public class InterpreterView extends AbstractStructuredViewerView {

	/*
	 * TODO
	 * - stop simulation, when switching to another process (sometimes works, sometimes not)
	 * - lock / unlock editor
	 */

	public static List<AbstractSimulation> simulations = new ArrayList<AbstractSimulation>();
	static {
		simulations.add(new ManualSimulation());
		simulations.add(new EclipseInterpretingSimulation());
	}
	
	private Action startAction;
	private Action stopAction;
	private Action stepOverAction;
	private Action stepIntoAction;
	private Action stepOutAction;
	
	private Map<Action, AbstractSimulation> simulationTypeActions;
	
	private SimulationViewer viewer;
	
	private AbstractSimulation simulation;
	
	
	public InterpreterView() {
		simulationTypeActions = new HashMap<Action, AbstractSimulation>();
	}
	
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	@Override
	public void createPartControl(Composite composite) {
		IWorkbenchPage input= getViewSite().getWorkbenchWindow().getActivePage();
		viewer= new SimulationViewer(this, composite);
		viewer.setInput(input);
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				updateActionEnablement();
			}
		});
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				performDoubleClick();
			}
		});
		makeActions();
	}

	protected void makeActions() {
		startAction= new Action("Start", VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_START)) {
			public void run() { start(); }
		};
		stopAction= new Action("Stop", VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_STOP)) {
			public void run() { stop(); }
		};
		stepOverAction= new Action("Step Over", VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_STEP_OVER)) {
			public void run() { stepOver(); }
		};
		stepIntoAction= new Action("Step Into", VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_STEP_INTO)) {
			public void run() { stepInto(); }
		};
		stepOutAction= new Action("Step Out", VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_STEP_OUT)) {
			public void run() { stepOut(); 	}
		};
		contributeToToolBar(startAction, stopAction,  
				stepIntoAction, stepOverAction, stepOutAction);
		hookContextMenu(viewer, stepIntoAction, stepOverAction, stepOutAction);
		updateActionEnablement();
		
		// select simulator menu
		for (AbstractSimulation simulation : simulations) {
			addSimulationType(simulation);
		}
	}

	protected void updateActionEnablement() {
		// by default, de-activate everything
		startAction.setEnabled(false);
		stopAction.setEnabled(false);
		stepOverAction.setEnabled(false);
		stepIntoAction.setEnabled(false);
		stepOutAction.setEnabled(false);
		// interpreter type selection actions only enabled when not running
		for (Action selectAction : simulationTypeActions.keySet()) {
			selectAction.setEnabled(! isRunning());
		}
		if (isVsdtDiagram()) {
			startAction.setEnabled(! isRunning());
			stopAction.setEnabled(isRunning());
			if (isRunning()) {
				Object selected= getSelectedElement(viewer);
				if (selected instanceof FlowObject) {
					FlowObject flowObject = (FlowObject) selected;
					boolean active = getState(flowObject).isActiveState();
					boolean ready = getState(flowObject).isReadyState();
					stepOverAction.setEnabled(ready && ! active);
					stepIntoAction.setEnabled(ready && ! active);
					stepOutAction.setEnabled(ready && active);
				}
			}
		}
	}
	
	protected void performDoubleClick() {
		Object selected= getSelectedElement(viewer);
		if (selected instanceof FlowObject) {
			FlowObject flowObject= (FlowObject) selected;

			// center on selected element
			IEditorPart editor= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			if (editor instanceof DiagramEditor) {
				DiagramEditor diagramEditor = (DiagramEditor) editor;
				EditPart editPart= Util.getEditPart(flowObject, diagramEditor, null);
				if (editPart != null) {
					diagramEditor.getDiagramGraphicalViewer().reveal(editPart);
				}
			}
			
			if (! getState(flowObject).isReadyState()) {
				return;
			}
			if (selected instanceof Activity && ! ((Activity) selected).getBoundaryEvents().isEmpty()) {
				if (getState(flowObject) == State.ACTIVE_READY) {
					stepOut();
				} else {
					stepInto();
					((TreeViewer) viewer).setExpandedState(selected, true);
				}
			} else {
				stepOver();	
			}
		}
		if (selected instanceof Pool) {
			TreeViewer tree= (TreeViewer) viewer;
			tree.setExpandedState(selected, ! tree.getExpandedState(selected));
		}
		if (selected instanceof Property && simulation instanceof EclipseInterpretingSimulation) {
			((EclipseInterpretingSimulation) simulation).openEditPropertyDialog((Property) selected);
			viewer.refresh();
		}
	}
	
	/**
	 * Create action for selecting a Simulation type and add it to the menu.
	 * The first action will also be initially selected.
	 * 
	 * @param simulation		instance of some of the AbstractSimulation classes
	 */
	protected void addSimulationType(AbstractSimulation simulation) {
		if (simulation != null) {
			Action selectAction= new Action(simulation.getName(), IAction.AS_RADIO_BUTTON) {};
			selectAction.setChecked(simulationTypeActions.isEmpty());
			simulationTypeActions.put(selectAction, simulation);
			getViewSite().getActionBars().getMenuManager().add(selectAction);
		}
	}
	
	/**
	 * @see ISimulation#start(BusinessProcessDiagramEditPart)
	 */
	public void start() {
		if (isVsdtDiagram()) {
			IEditorPart editor= ((IWorkbenchPage) viewer.getInput()).getActiveEditor();
			BusinessProcessDiagramEditPart editPart = (BusinessProcessDiagramEditPart) ((VsdtDiagramEditor) editor).getDiagramEditPart();
			BusinessProcessDiagram bpd = editPart.getCastedModel();
			
			// get selected simulation type
			simulation = null;
			for (Entry<Action, AbstractSimulation> entry : simulationTypeActions.entrySet()) {
				if (entry.getKey().isChecked()) {
					AbstractSimulation selectedSimulation = entry.getValue();
					
					// check applicability
					try {
						if (selectedSimulation.isApplicable(bpd)) {
							simulation = selectedSimulation;
						}
					} catch (Exception e) {
						MessageDialog.openInformation(viewer.getControl().getShell(),
								"Simulation not Applicable", e.getMessage());
					}
					break;
				}
			} // end for

			// link simulation with viewer, start simulation
			if (simulation != null) {
				simulation.addObserver(new EclipseInterpreterObserver(viewer, editPart));
				List<FlowObject> result= simulation.start(bpd);
				setSelection(result);
				updateActionEnablement();
			}
		}
	}
	
	/**
	 * @see ISimulation#stop()
	 */
	public void stop() {
		if (simulation != null) {
			simulation.stop();
			simulation= null;
			updateActionEnablement();
		}
	}

	/**
	 * @see ISimulation#stepOver(FlowObject)
	 */
	public void stepOver() {
		if (simulation != null && getSelectedElement(viewer) instanceof FlowObject) {
			List<FlowObject> result= simulation.stepOver((FlowObject) getSelectedElement(viewer));
			setSelection(result);
			updateActionEnablement();
		}
	}
	
	/**
	 * @see ISimulation#stepInto(FlowObject)
	 */
	public void stepInto() {
		if (simulation != null && getSelectedElement(viewer) instanceof FlowObject) {
			List<FlowObject> result= simulation.stepInto((FlowObject) getSelectedElement(viewer));
			setSelection(result);
			updateActionEnablement();
		}
	}
	
	/**
	 * @see ISimulation#stepOut(FlowObject)
	 */
	public void stepOut() {
		if (simulation != null && getSelectedElement(viewer) instanceof FlowObject) {
			List<FlowObject> result= simulation.stepOut((FlowObject) getSelectedElement(viewer));
			setSelection(result);
			updateActionEnablement();
		}
	}
	
	/**
	 * @see ISimulation#isRunning()
	 */
	public boolean isRunning() {
		if (simulation != null) {
			return simulation.isRunning();
		}
		return false;
	}
	
	/**
	 * @see ISimulation#getState(FlowObject)
	 */
	public State getState(FlowObject flowObject) {
		if (simulation != null) {
			return simulation.getState(flowObject);
		}
		return State.IDLE;
	}
	
	/**
	 * @return		The simulation instance
	 */
	public AbstractSimulation getSimulation() {
		return simulation;
	}
	
	private boolean isVsdtDiagram() {
		if (viewer != null && viewer.getInput() instanceof IWorkbenchPage) {
			return ((IWorkbenchPage) viewer.getInput()).getActiveEditor() instanceof VsdtDiagramEditor;
		} else {
			return false;
		}
	}
	
	/**
	 * Set the new selection in the viewer, based on the results of the previous
	 * step.  Making a breadth-first search
	 * Following this methods invocation the actions should get updated.
	 * 
	 * @param flowObjects	List of FlowObjects being readied in the last step
	 */
	private void setSelection(List<FlowObject> flowObjects) {
		if (flowObjects != null && ! flowObjects.isEmpty()) {
			FlowObject flowObject= flowObjects.get(0);
			Tree tree= ((TreeViewer) viewer).getTree();
			Queue<TreeItem> queue= new LinkedList<TreeItem>();
			queue.addAll(Arrays.asList(tree.getItems()));
			while (! queue.isEmpty()) {
				TreeItem item= queue.remove();
				if (item.getData() == flowObject) {
					tree.setSelection(item);
					return;
				} 
				queue.addAll(Arrays.asList(item.getItems()));
			}
		}
	}

}