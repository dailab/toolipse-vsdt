package de.dailab.vsdt.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import de.dailab.vsdt.End;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GraphicalObject;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Node;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.diagram.edit.parts.ActivityEditPart;
import de.dailab.vsdt.diagram.edit.parts.ActivitySubprocessCompartmentEditPart;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.edit.parts.LaneLaneCompartmentEditPart;
import de.dailab.vsdt.diagram.edit.parts.PoolPoolCompartmentEditPart;
import de.dailab.vsdt.diagram.part.Messages;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;

/**
 * @generated
 */
public class VsdtModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * changed insertion order
	 * 
	 * @generated NOT
	 */
	@Override
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		List<IElementType> types = new ArrayList<IElementType>();
		if (editPart instanceof ActivityEditPart) {
			types.add(VsdtElementTypes.Intermediate_2007);
			return types;
		}
		if (editPart instanceof PoolPoolCompartmentEditPart) {
			types.add(VsdtElementTypes.Lane_2001);
			return types;
		}
		if (editPart instanceof LaneLaneCompartmentEditPart) {
			types.add(VsdtElementTypes.Start_2002);
			types.add(VsdtElementTypes.Intermediate_2003);
			types.add(VsdtElementTypes.End_2004);
			types.add(VsdtElementTypes.Activity_2005);
			types.add(VsdtElementTypes.Gateway_2006);
			return types;
		}
		if (editPart instanceof ActivitySubprocessCompartmentEditPart) {
			types.add(VsdtElementTypes.Start_2002);
			types.add(VsdtElementTypes.Intermediate_2003);
			types.add(VsdtElementTypes.End_2004);
			types.add(VsdtElementTypes.Activity_2005);
			types.add(VsdtElementTypes.Gateway_2006);
			return types;
		}
		if (editPart instanceof BusinessProcessDiagramEditPart) {
			types.add(VsdtElementTypes.Pool_1004);
			types.add(VsdtElementTypes.DataObject_1003);
			types.add(VsdtElementTypes.TextAnnotation_1002);
//			types.add(VsdtElementTypes.Group_1001);
//			types.add(VsdtElementTypes.Agent_1005);
//			types.add(VsdtElementTypes.Service_1006);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated NOT
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		return getRelTypes(source, true);
	}

	/**
	 * @generated NOT
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		return getRelTypes(target, false);
	}

	/**
	 * @generated NOT
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		List<IElementType> elements = getRelTypes(source, true);
		elements.retainAll(getRelTypes(target, false));
		return elements;
	}

	/**
	 * @generated NOT
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		return getElementTypesForRel(relationshipType);
	}

	/**
	 * @generated NOT
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		return getElementTypesForRel(relationshipType);
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target,
				relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source,
				relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				VsdtDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(Messages.VsdtModelingAssistantProviderMessage);
		dialog.setTitle(Messages.VsdtModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}

	/**
	 * generate a list and add different connection types, depending on the model element
	 * @generated NOT
	 */
	private List<IElementType> getRelTypes(IAdaptable element, boolean isSource) {
		List<IElementType> list = new ArrayList<IElementType>();
		EObject sourceModel = null;
		if (element instanceof ShapeNodeEditPart) {
			sourceModel = ((View) ((ShapeNodeEditPart) element).getModel())
					.getElement();
		}
		if (sourceModel instanceof FlowObject) {
			boolean ok= true;
			ok&= ! (sourceModel instanceof Start) ||  isSource;
			ok&= ! (sourceModel instanceof End)   || !isSource;
			ok&= ! (sourceModel instanceof Intermediate) || isSource || ((Intermediate)sourceModel).getTarget()==null;
			if (ok) {
				list.add(VsdtElementTypes.SequenceFlow_3001);
			}
		}
		if (sourceModel instanceof Node) {
			boolean ok= true;
			ok&= ! (sourceModel instanceof Start)        || !isSource;
			ok&= ! (sourceModel instanceof Intermediate) || !isSource;
			ok&= ! (sourceModel instanceof End)          || isSource;
			ok&= ! (sourceModel instanceof Gateway);
			if (ok) {
				list.add(VsdtElementTypes.MessageFlow_3002);
			}
		}
		if (sourceModel instanceof GraphicalObject) {
			list.add(VsdtElementTypes.Association_3003);
		}
		return list;
	}

	/**
	 * return a list with all element types available for the given relationship type
	 * @param relationshipType	the relationship type
	 * @return					
	 * @generated NOT
	 */
	private List<IElementType> getElementTypesForRel(
			IElementType relationshipType) {
		List<IElementType> list = new ArrayList<IElementType>();
		int type = 0;
		if (relationshipType == VsdtElementTypes.SequenceFlow_3001) {
			type = 1;
		}
		if (relationshipType == VsdtElementTypes.MessageFlow_3002) {
			type = 2;
		}
		if (relationshipType == VsdtElementTypes.Association_3003) {
			type = 3;
		}
		if (type >= 3) {
			list.add(VsdtElementTypes.DataObject_1003);
			list.add(VsdtElementTypes.TextAnnotation_1002);
			list.add(VsdtElementTypes.Group_1001);
//			list.add(VsdtElementTypes.Agent_1005);
//			list.add(VsdtElementTypes.Service_1006);
		}
		if (type >= 2) {
			list.add(VsdtElementTypes.Pool_1004);
		}
		if (type >= 1) {
			list.add(VsdtElementTypes.Activity_2005);
			list.add(VsdtElementTypes.Start_2002);
			list.add(VsdtElementTypes.Intermediate_2003);
			list.add(VsdtElementTypes.End_2004);
			list.add(VsdtElementTypes.Gateway_2006);
		}
		return list;
	}
}
