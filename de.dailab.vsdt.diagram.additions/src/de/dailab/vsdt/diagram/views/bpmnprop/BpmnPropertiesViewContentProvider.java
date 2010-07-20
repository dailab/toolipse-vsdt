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
import de.dailab.vsdt.Property;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;
import de.dailab.vsdt.util.VsdtHelper;

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
					return VsdtHelper.getVisibleProperties(eObject);
				}
			}
		}
		return new ArrayList<Property>();
	}
}