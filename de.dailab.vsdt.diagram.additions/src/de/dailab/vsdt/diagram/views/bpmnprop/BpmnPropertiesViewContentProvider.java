package de.dailab.vsdt.diagram.views.bpmnprop;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.dailab.common.swt.views.AbstractContentProvider;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;

/**
 * Simple content provider class to be used with this view. This class is taken 
 * from the Eclipse View Plugin Example.
 * 
 * @author kuester
 */
public class BpmnPropertiesViewContentProvider extends AbstractContentProvider implements IStructuredContentProvider, ISelectionListener {

	public Object[] getElements(Object parent) {
		// Populate properties list
		List<Property> properties= getSelectedProperties();
		return properties.toArray();
	}
	
	/**
	 * @return	The visible properties of the currently selected Element in an opened VSDT BPMN editor
	 */
	private List<Property> getSelectedProperties() {
		// Get Active Editor
		IWorkbenchWindow window= PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IEditorPart editor= window.getActivePage().getActiveEditor();
		
		// Active Editor of Type BPMN Editor?
		if (editor instanceof VsdtDiagramEditor) {
			VsdtDiagramEditor diagramEditor= (VsdtDiagramEditor) editor;
			
			// Get Selected Activity
			ISelectionProvider selProvider= diagramEditor.getEditorSite().getSelectionProvider();
			if (selProvider.getSelection() instanceof IStructuredSelection) {
				IStructuredSelection selection= (IStructuredSelection) selProvider.getSelection();
				Object selected= selection.getFirstElement();
				if (selected instanceof IGraphicalEditPart) {
					IGraphicalEditPart editPart = (IGraphicalEditPart) selected;
					EObject eObject= ((View)editPart.getModel()).getElement();
					if (eObject instanceof Pool) {
						return ((Pool) eObject).getProcess().getVisibleProperties();
					}
					if (eObject instanceof Lane) {
						return ((Lane) eObject).getParentPool().getProcess().getVisibleProperties();
					}
					if (eObject instanceof FlowObject) {
						return ((FlowObject) eObject).getVisibleProperties();
					}
					if (eObject instanceof MessageFlow) {
						MessageFlow messageFlow = (MessageFlow) eObject;
						if (messageFlow.getMessage() != null) {
							return messageFlow.getMessage().getProperties();
						}
					}
					if (eObject instanceof SequenceFlow) {
						SequenceFlow sequenceFlow = (SequenceFlow) eObject;
						if (sequenceFlow.getSource() != null) {
							return sequenceFlow.getSource().getVisibleProperties();
						}
					}
				}
			}
		}
		return new ArrayList<Property>();
	}
}