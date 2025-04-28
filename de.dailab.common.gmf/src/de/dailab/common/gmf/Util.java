package de.dailab.common.gmf;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.graphics.Color;

/**
 * Pure utility class holding a number of useful, frequently needed static helper methods.
 * Feel free to contribute! 
 * 
 * @author kuester
 */
public class Util {

	/**
	 * Retrieves the edit part for the given EObject.  Also works if the EObject
	 * is a copy of the original EObject if an identifying feature can be given.
	 * If no such feature is given, the equals method is used. 
	 * 
	 * @param eObject	Some EObject
	 * @param editor	Editor to search the EditPart in
	 * @param feature	name of identifying feature, or null.
	 * @return			Edit Part of an EObject with the same ID
	 */
	@SuppressWarnings("unchecked")
	public static IGraphicalEditPart getEditPart(EObject eObject, DiagramEditor editor, String feature) {
		if (eObject == null || editor == null) {
			throw new IllegalArgumentException("Argument mustnot be null");
		}
		EStructuralFeature eFeature= null;
		if (feature != null) {
			eFeature= eObject.eClass().getEStructuralFeature(feature);
			if (eFeature == null) {
				throw new IllegalArgumentException("Unknown Feature: " + feature);
			}
		}
		Queue<?> queue= new LinkedList<>(editor.getDiagramEditPart().getChildren());
		while (! queue.isEmpty()) {
			Object element= queue.remove();
			if (element instanceof IGraphicalEditPart) {
				IGraphicalEditPart editPart= (IGraphicalEditPart) element;
				if (editPart.getModel() instanceof View) {
					View view = (View) editPart.getModel();
					EObject modelElement= view.getElement();
					if (modelElement != null) {
						if (feature != null) {
							// test element by identifying feature
							if (modelElement.eGet(eFeature) != null && 
									modelElement.eGet(eFeature).equals(eObject.eGet(eFeature))) {
								return editPart;
							} 
						} else {
							// test element for equality
							if (modelElement.equals(eObject)) {
								return editPart;
							}
						}
					}
				}
			}
			if (element instanceof EditPart) {
				queue.addAll(((EditPart) element).getChildren());
			}
			if (element instanceof AbstractGraphicalEditPart) {
				// this seems to be the only way to get connection edit parts...
				// parent of connections is the diagram root edit parts, but they are not its children
				queue.addAll(((AbstractGraphicalEditPart) element).getSourceConnections());
				queue.addAll(((AbstractGraphicalEditPart) element).getTargetConnections());
			}
		}
		return null;
	}
	
	/**
	 * Highlight the given edit part in the given active editor.  Highlighting
	 * is done by (1) centering the graphical editor around the figure, and
	 * (2) flashing the figure with a colored border a few times.  Flashing is 
	 * done threaded, so multiple figures can be flashed (nearly) simultaneously.  
	 * 
	 * @param editPart	Some graphical edit part to be highlighted
	 * @param editor	Editor the edit part is located in
	 */
	public static void highlight(IGraphicalEditPart editPart, DiagramEditor editor, final int flashNum) {
		// center view on figure
		editor.getDiagramGraphicalViewer().reveal(editPart);
		// highlight figure
		final IFigure figure= editPart.getFigure();
		new Thread(new Runnable() {
			public void run() {
				try {
					synchronized (figure) {
						Border border= figure.getBorder();
						Border hlBorder= new LineBorder(new Color(null, 196, 40, 40), 2);
						for (int i=0; i< flashNum*2; i++) {
							figure.setBorder( i%2==0 ? hlBorder : border);
							Thread.sleep(400);
						}	
					}
				} catch (InterruptedException e) {}
			}
		}).start();
	}
	
	public static void highlight(IGraphicalEditPart editPart, DiagramEditor editor) {
		highlight(editPart, editor, 2);
	}
	
	
	/**
	 * Retrieve a list of Edit Parts corresponding to a given EObject.
	 * 
	 * @param eObject			The EObject for which the edit parts shall be retrieved
	 * @param currentEditPart	Some other EditPart in the same hierarchy
	 * @param editPartClass		The class of the desired edit parts
	 * @return					List of matching Edit Parts.
	 */
	@SuppressWarnings("rawtypes")
	public static List findEditParts(EObject eObject, EditPart currentEditPart, Class<?> editPartClass) {
		if (eObject == null || currentEditPart == null || editPartClass == null) {
			throw new IllegalArgumentException("Argumemts must not be null");
		}
		DiagramEditPart diagramEditPart= getDiagramEditPart(currentEditPart);
		if (diagramEditPart != null) {
			IDiagramGraphicalViewer viewer= (IDiagramGraphicalViewer) diagramEditPart.getViewer();
			return viewer.findEditPartsForElement(EMFCoreUtil.getProxyID(eObject), editPartClass);
		}
		return null;
	}
	
	/**
	 * Retrieve a list of Edit Parts corresponding to a given EObject.
	 * 
	 * @param eObject			The EObject for which the edit parts shall be retrieved
	 * @param currentEditPart	Some other EditPart in the same hierarchy
	 * @param editPartClass		The class of the desired edit parts
	 * @return					List of matching Edit Parts.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EditPart> List<T> findEditParts(EObject eObject, T currentEditPart) {
		if (eObject == null || currentEditPart == null) {
			throw new IllegalArgumentException("Argumemts must not be null");
		}
		DiagramEditPart diagramEditPart= getDiagramEditPart(currentEditPart);
		if (diagramEditPart != null) {
			IDiagramGraphicalViewer viewer= (IDiagramGraphicalViewer) diagramEditPart.getViewer();
			return viewer.findEditPartsForElement(EMFCoreUtil.getProxyID(eObject), currentEditPart.getClass());
		}
		return null;
	}
	
	/**
	 * The "I'm feeling lucky" version of findEditParts().
	 * 
	 * @param eObject			The EObject for which the edit parts shall be retrieved
	 * @param currentEditPart	Some other EditPart in the same hierarchy
	 * @param editPartClass		The class of the desired edit parts
	 * @return					First element of the list of matching Edit Parts.
	 */
	public static EditPart findFirstEditPart(EObject eObject, EditPart currentEditPart, Class<?> editPartClass) {
		List<?> editParts= findEditParts(eObject, currentEditPart, editPartClass);
		if (editParts != null && ! editParts.isEmpty()) {
			return (EditPart) editParts.get(0);
		}
		return null;
	}
	
	/**
	 * Return the diagram edit part for a given edit part transitively contained in this
	 * diagram edit part.
	 * 
	 * @param editPart		Some edit part contained in a diagram edit part
	 * @return				the edit part's diagram edit part, or null
	 */
	public static DiagramEditPart getDiagramEditPart(EditPart editPart) {
		EditPart parent= editPart;
		while (parent != null) {
			if (parent instanceof DiagramEditPart) {
				return (DiagramEditPart) parent;
			}
			parent= parent.getParent();
		}
		return null;
	}
	
	/**
	 * Toggle the visibility of the given graphical edit part on or off, by
	 * activating or deactivating it, showing or hiding its figure, and enabling
	 * or disabling edit mode.
	 * 
	 * @param editPart	Some graphical edit part
	 * @param newState	new visibility state
	 */
	public static void setVisible(AbstractGraphicalEditPart editPart, boolean newState) {
		if (editPart == null) {
			throw new IllegalArgumentException("Argument must not be null");
		}
		editPart.getFigure().setVisible(newState);
		if (newState) {
			editPart.activate();
			if (editPart instanceof ConnectionEditPart) {
				((ConnectionEditPart) editPart).enableEditMode();
			}
			if (editPart instanceof GraphicalEditPart) {
				((GraphicalEditPart) editPart).enableEditMode();
			}
		} else {
			editPart.deactivate();
			if (editPart instanceof ConnectionEditPart) {
				((ConnectionEditPart) editPart).disableEditMode();
			}
			if (editPart instanceof GraphicalEditPart) {
				((GraphicalEditPart) editPart).disableEditMode();
			}
		}
	}
	
	/**
     * little helper method for initializing text fields, which may not have a null value,
     * with the values from the model, which might be null
     * 
     * @param s		some string
     * @return		the given string, or "" if the string is null
     */
    public static String nonNull(String s) {
    	return s == null ? "" : s;
    }
    
    /**
     * another little helper method for returning values from the text fields, returning null if the text field is empty
     * 
     * @param s		some string
     * @return		the string, or null if the string is empty
     */
    public static String nullIfEmpty(String s) {
    	if (s != null) {
    		String s2= s.trim();
    		return s2.isEmpty() ? null : s2;
    	} else {
    		return null;
    	}
    }
	
    /**
     * Get model element from GMF edit part. Automatically cast to expected type.
     * 
     * @param editPart	some GMF edit part
     * @return			underlying model element
     */
    @SuppressWarnings("unchecked")
	public static <E extends EObject> E getModelElement(IGraphicalEditPart editPart) {
		return (E) ((View) editPart.getModel()).getElement();
    }

    /**
     * Get model element from selection. Assuming that this is a structured
     * selection holding a graphical edit part; otherwise returns null
     * 
     * @param selection		selection in GMF editor
     * @return				underlying model element of first selected edit part
     */
    public static <E extends EObject> E getModelElement(ISelection selection) {

    	if (selection instanceof StructuredSelection) {
			StructuredSelection structured = (StructuredSelection) selection;
			Object first = structured.getFirstElement();
			if (first instanceof IGraphicalEditPart) {
				IGraphicalEditPart editPart = (IGraphicalEditPart) first;
				return getModelElement(editPart);
			}
		}
    	return null;
    }
}
