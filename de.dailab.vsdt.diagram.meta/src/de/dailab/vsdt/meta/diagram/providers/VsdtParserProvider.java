package de.dailab.vsdt.meta.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessDiagramNameEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.ParticipantNameEditPart;
import de.dailab.vsdt.meta.diagram.parsers.MessageFormatParser;
import de.dailab.vsdt.meta.diagram.part.VsdtVisualIDRegistry;

/**
 * @generated
 */
public class VsdtParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser participantName_4001Parser;

	/**
	 * @generated
	 */
	private IParser getParticipantName_4001Parser() {
		if (participantName_4001Parser == null) {
			participantName_4001Parser = createParticipantName_4001Parser();
		}
		return participantName_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createParticipantName_4001Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser businessProcessDiagramName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getBusinessProcessDiagramName_4002Parser() {
		if (businessProcessDiagramName_4002Parser == null) {
			businessProcessDiagramName_4002Parser = createBusinessProcessDiagramName_4002Parser();
		}
		return businessProcessDiagramName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createBusinessProcessDiagramName_4002Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ParticipantNameEditPart.VISUAL_ID:
			return getParticipantName_4001Parser();
		case BusinessProcessDiagramNameEditPart.VISUAL_ID:
			return getBusinessProcessDiagramName_4002Parser();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(VsdtVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(VsdtVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (VsdtElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
