package de.dailab.vsdt.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.Group;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.diagram.edit.parts.ActivityEditPart;
import de.dailab.vsdt.diagram.edit.parts.ActivityNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.AssociationEditPart;
import de.dailab.vsdt.diagram.edit.parts.AssociationNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.edit.parts.DataObjectEditPart;
import de.dailab.vsdt.diagram.edit.parts.DataObjectNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.EndEditPart;
import de.dailab.vsdt.diagram.edit.parts.EndNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.GatewayEditPart;
import de.dailab.vsdt.diagram.edit.parts.GatewayNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.GroupEditPart;
import de.dailab.vsdt.diagram.edit.parts.Intermediate2EditPart;
import de.dailab.vsdt.diagram.edit.parts.IntermediateEditPart;
import de.dailab.vsdt.diagram.edit.parts.IntermediateNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.LaneEditPart;
import de.dailab.vsdt.diagram.edit.parts.LaneNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.MessageFlowEditPart;
import de.dailab.vsdt.diagram.edit.parts.MessageFlowNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.PoolEditPart;
import de.dailab.vsdt.diagram.edit.parts.PoolNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.SequenceFlowEditPart;
import de.dailab.vsdt.diagram.edit.parts.SequenceFlowNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.StartEditPart;
import de.dailab.vsdt.diagram.edit.parts.StartNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.TextAnnotationDocumentationEditPart;
import de.dailab.vsdt.diagram.edit.parts.TextAnnotationEditPart;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;
import de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;
import de.dailab.vsdt.diagram.providers.VsdtParserProvider;

/**
 * @generated
 */
public class VsdtNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		VsdtDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		VsdtDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof VsdtNavigatorItem
				&& !isOwnView(((VsdtNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof VsdtNavigatorGroup) {
			VsdtNavigatorGroup group = (VsdtNavigatorGroup) element;
			return VsdtDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof VsdtNavigatorItem) {
			VsdtNavigatorItem navigatorItem = (VsdtNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (VsdtVisualIDRegistry.getVisualID(view)) {
		case BusinessProcessDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://de.dailab.vsdt?BusinessProcessDiagram", VsdtElementTypes.BusinessProcessDiagram_79); //$NON-NLS-1$
		case GroupEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://de.dailab.vsdt?Group", VsdtElementTypes.Group_1001); //$NON-NLS-1$
		case TextAnnotationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://de.dailab.vsdt?TextAnnotation", VsdtElementTypes.TextAnnotation_1002); //$NON-NLS-1$
		case DataObjectEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://de.dailab.vsdt?DataObject", VsdtElementTypes.DataObject_1003); //$NON-NLS-1$
		case PoolEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://de.dailab.vsdt?Pool", VsdtElementTypes.Pool_1004); //$NON-NLS-1$
		case LaneEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://de.dailab.vsdt?Lane", VsdtElementTypes.Lane_2001); //$NON-NLS-1$
		case StartEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://de.dailab.vsdt?Start", VsdtElementTypes.Start_2002); //$NON-NLS-1$
		case IntermediateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://de.dailab.vsdt?Intermediate", VsdtElementTypes.Intermediate_2003); //$NON-NLS-1$
		case EndEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://de.dailab.vsdt?End", VsdtElementTypes.End_2004); //$NON-NLS-1$
		case ActivityEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://de.dailab.vsdt?Activity", VsdtElementTypes.Activity_2005); //$NON-NLS-1$
		case GatewayEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://de.dailab.vsdt?Gateway", VsdtElementTypes.Gateway_2006); //$NON-NLS-1$
		case Intermediate2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?http://de.dailab.vsdt?Intermediate", VsdtElementTypes.Intermediate_2007); //$NON-NLS-1$
		case SequenceFlowEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://de.dailab.vsdt?SequenceFlow", VsdtElementTypes.SequenceFlow_3001); //$NON-NLS-1$
		case MessageFlowEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://de.dailab.vsdt?MessageFlow", VsdtElementTypes.MessageFlow_3002); //$NON-NLS-1$
		case AssociationEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://de.dailab.vsdt?Association", VsdtElementTypes.Association_3003); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = VsdtDiagramEditorPlugin.getInstance()
				.getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& VsdtElementTypes.isKnownElementType(elementType)) {
			image = VsdtElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof VsdtNavigatorGroup) {
			VsdtNavigatorGroup group = (VsdtNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof VsdtNavigatorItem) {
			VsdtNavigatorItem navigatorItem = (VsdtNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (VsdtVisualIDRegistry.getVisualID(view)) {
		case BusinessProcessDiagramEditPart.VISUAL_ID:
			return getBusinessProcessDiagram_79Text(view);
		case GroupEditPart.VISUAL_ID:
			return getGroup_1001Text(view);
		case TextAnnotationEditPart.VISUAL_ID:
			return getTextAnnotation_1002Text(view);
		case DataObjectEditPart.VISUAL_ID:
			return getDataObject_1003Text(view);
		case PoolEditPart.VISUAL_ID:
			return getPool_1004Text(view);
		case LaneEditPart.VISUAL_ID:
			return getLane_2001Text(view);
		case StartEditPart.VISUAL_ID:
			return getStart_2002Text(view);
		case IntermediateEditPart.VISUAL_ID:
			return getIntermediate_2003Text(view);
		case EndEditPart.VISUAL_ID:
			return getEnd_2004Text(view);
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2005Text(view);
		case GatewayEditPart.VISUAL_ID:
			return getGateway_2006Text(view);
		case Intermediate2EditPart.VISUAL_ID:
			return getIntermediate_2007Text(view);
		case SequenceFlowEditPart.VISUAL_ID:
			return getSequenceFlow_3001Text(view);
		case MessageFlowEditPart.VISUAL_ID:
			return getMessageFlow_3002Text(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_3003Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getBusinessProcessDiagram_79Text(View view) {
		BusinessProcessDiagram domainModelElement = (BusinessProcessDiagram) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 79); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getGroup_1001Text(View view) {
		Group domainModelElement = (Group) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTextAnnotation_1002Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.TextAnnotation_1002,
				(view.getElement() != null ? view.getElement() : view),
				VsdtVisualIDRegistry
						.getType(TextAnnotationDocumentationEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getDataObject_1003Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.DataObject_1003,
				(view.getElement() != null ? view.getElement() : view),
				VsdtVisualIDRegistry.getType(DataObjectNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getPool_1004Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.Pool_1004, (view.getElement() != null ? view
						.getElement() : view), VsdtVisualIDRegistry
						.getType(PoolNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4009); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getLane_2001Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.Lane_2001, (view.getElement() != null ? view
						.getElement() : view), VsdtVisualIDRegistry
						.getType(LaneNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getStart_2002Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.Start_2002, (view.getElement() != null ? view
						.getElement() : view), VsdtVisualIDRegistry
						.getType(StartNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getIntermediate_2003Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.Intermediate_2003,
				(view.getElement() != null ? view.getElement() : view),
				VsdtVisualIDRegistry
						.getType(IntermediateNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getEnd_2004Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.End_2004, (view.getElement() != null ? view
						.getElement() : view), VsdtVisualIDRegistry
						.getType(EndNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getActivity_2005Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.Activity_2005,
				(view.getElement() != null ? view.getElement() : view),
				VsdtVisualIDRegistry.getType(ActivityNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getGateway_2006Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.Gateway_2006,
				(view.getElement() != null ? view.getElement() : view),
				VsdtVisualIDRegistry.getType(GatewayNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getIntermediate_2007Text(View view) {
		Intermediate domainModelElement = (Intermediate) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 2007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSequenceFlow_3001Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.SequenceFlow_3001,
				(view.getElement() != null ? view.getElement() : view),
				VsdtVisualIDRegistry
						.getType(SequenceFlowNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4010); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getMessageFlow_3002Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.MessageFlow_3002,
				(view.getElement() != null ? view.getElement() : view),
				VsdtVisualIDRegistry.getType(MessageFlowNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4011); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getAssociation_3003Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.Association_3003,
				(view.getElement() != null ? view.getElement() : view),
				VsdtVisualIDRegistry.getType(AssociationNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4012); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return BusinessProcessDiagramEditPart.MODEL_ID
				.equals(VsdtVisualIDRegistry.getModelID(view));
	}

}
