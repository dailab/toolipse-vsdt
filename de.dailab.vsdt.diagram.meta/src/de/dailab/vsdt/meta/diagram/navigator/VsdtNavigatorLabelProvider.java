package de.dailab.vsdt.meta.diagram.navigator;

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

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessDiagramNameEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessSystemEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.ParticipantAssociatedProcessesEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.ParticipantEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.ParticipantNameEditPart;
import de.dailab.vsdt.meta.diagram.part.VsdtMetaDiagramEditorPlugin;
import de.dailab.vsdt.meta.diagram.part.VsdtVisualIDRegistry;
import de.dailab.vsdt.meta.diagram.providers.VsdtElementTypes;
import de.dailab.vsdt.meta.diagram.providers.VsdtParserProvider;

/**
 * @generated
 */
public class VsdtNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		VsdtMetaDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		VsdtMetaDiagramEditorPlugin
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
			return VsdtMetaDiagramEditorPlugin.getInstance().getBundledImage(
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
		case BusinessProcessSystemEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?http://de.dailab.vsdt?BusinessProcessSystem", VsdtElementTypes.BusinessProcessSystem_79); //$NON-NLS-1$
		case ParticipantEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://de.dailab.vsdt?Participant", VsdtElementTypes.Participant_1001); //$NON-NLS-1$
		case BusinessProcessDiagramEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?http://de.dailab.vsdt?BusinessProcessDiagram", VsdtElementTypes.BusinessProcessDiagram_1002); //$NON-NLS-1$
		case ParticipantAssociatedProcessesEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?http://de.dailab.vsdt?Participant?associatedProcesses", VsdtElementTypes.ParticipantAssociatedProcesses_3001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = VsdtMetaDiagramEditorPlugin.getInstance()
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
		case BusinessProcessSystemEditPart.VISUAL_ID:
			return getBusinessProcessSystem_79Text(view);
		case ParticipantEditPart.VISUAL_ID:
			return getParticipant_1001Text(view);
		case BusinessProcessDiagramEditPart.VISUAL_ID:
			return getBusinessProcessDiagram_1002Text(view);
		case ParticipantAssociatedProcessesEditPart.VISUAL_ID:
			return getParticipantAssociatedProcesses_3001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getBusinessProcessSystem_79Text(View view) {
		BusinessProcessSystem domainModelElement = (BusinessProcessSystem) view
				.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			VsdtMetaDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 79); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getParticipant_1001Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.Participant_1001,
				(view.getElement() != null ? view.getElement() : view),
				VsdtVisualIDRegistry.getType(ParticipantNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtMetaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getBusinessProcessDiagram_1002Text(View view) {
		IAdaptable hintAdapter = new VsdtParserProvider.HintAdapter(
				VsdtElementTypes.BusinessProcessDiagram_1002, (view
						.getElement() != null ? view.getElement() : view),
				VsdtVisualIDRegistry
						.getType(BusinessProcessDiagramNameEditPart.VISUAL_ID));
		IParser parser = ParserService.getInstance().getParser(hintAdapter);

		if (parser != null) {
			return parser.getPrintString(hintAdapter, ParserOptions.NONE
					.intValue());
		} else {
			VsdtMetaDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 4002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}

	}

	/**
	 * @generated
	 */
	private String getParticipantAssociatedProcesses_3001Text(View view) {
		return ""; //$NON-NLS-1$
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
		return BusinessProcessSystemEditPart.MODEL_ID
				.equals(VsdtVisualIDRegistry.getModelID(view));
	}

}
