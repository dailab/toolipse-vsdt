package de.dailab.vsdt.diagram.interpreter.view;

import static de.dailab.vsdt.diagram.interpreter.view.DecorationHelper.clearDecorators;
import static de.dailab.vsdt.diagram.interpreter.view.DecorationHelper.decorateEdge;
import static de.dailab.vsdt.diagram.interpreter.view.DecorationHelper.decorateNode;
import static de.dailab.vsdt.diagram.interpreter.view.DecorationHelper.getFigure;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.interpreter.ISimulationObserver;
import de.dailab.vsdt.interpreter.State;

/**
 * This class encapsulates all the stuff needed to link the VSDT interpreter
 * to the VSDT Eclipse editor.
 * 
 * @author kuester
 */
public class EclipseInterpreterObserver implements ISimulationObserver {

	/** the viewer */
	protected final Viewer viewer;
	
	/** the diagram edit part */
	protected final BusinessProcessDiagramEditPart diagramEditPart;
	
	public EclipseInterpreterObserver(Viewer viewer, BusinessProcessDiagramEditPart diagramEditPart) {
		this.viewer = viewer;
		this.diagramEditPart = diagramEditPart;
	}

	@Override
	public int hashCode() {
		return this.getClass().hashCode() + this.viewer.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof EclipseInterpreterObserver) {
			EclipseInterpreterObserver other = (EclipseInterpreterObserver) obj;
			return other.viewer.equals(this.viewer);
		}
		return super.equals(obj);
	}
	
	/**
	 * - refresh the viewer
	 * - refresh figures
	 */
	@Override
	public void refresh(int step, Map<EObject,Integer> stepMap, Map<FlowObject,State> stateMap) {
		// refresh tree viewer
		if (viewer != null) {
			viewer.refresh();
		}
		// refresh diagram view
		if (diagramEditPart != null) {
			for (Entry<FlowObject, State> entry : stateMap.entrySet()) {
				decorateNode(getFigure(diagramEditPart, entry.getKey()), entry.getValue());
			}
			for (Entry<EObject, Integer> entry : stepMap.entrySet()) {
				decorateEdge(getFigure(diagramEditPart, entry.getKey()), entry.getValue(), step);
			}
		}
	}
	
	/**
	 * Remove all decorations and refresh the viewer
	 */
	@Override
	public void clear() {
		// remove decorations
		if (diagramEditPart != null) {
			clearDecorators(diagramEditPart);
		}
		// refresh viewer
		if (viewer != null) {
			viewer.refresh();
		}
	}

	@Override
	public void logMessage(LogLevel level, String title, String message) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		if (level == LogLevel.INFO) {
			MessageDialog.openInformation(shell, title, message.toString());
		}
		if (level == LogLevel.WARN) {
			MessageDialog.openWarning(shell, title, message.toString());
		}
		if (level == LogLevel.ERROR) {
			MessageDialog.openError(shell, title, message.toString());
		}
	}
	
}
