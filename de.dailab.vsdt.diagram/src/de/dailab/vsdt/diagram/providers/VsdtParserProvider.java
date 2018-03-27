package de.dailab.vsdt.diagram.providers;

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
import de.dailab.vsdt.diagram.edit.parts.ActivityNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.AssociationNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.DataObjectNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.EndNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.GatewayNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.IntermediateNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.LaneNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.MessageFlowNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.PoolNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.SequenceFlowNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.StartNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.TextAnnotationDocumentationEditPart;
import de.dailab.vsdt.diagram.parsers.MessageFormatParser;
import de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry;

/**
 * @generated
 */
@SuppressWarnings("rawtypes")
public class VsdtParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser textAnnotationDocumentation_4001Parser;

	/**
	 * @generated
	 */
	private IParser getTextAnnotationDocumentation_4001Parser() {
		if (textAnnotationDocumentation_4001Parser == null) {
			textAnnotationDocumentation_4001Parser = createTextAnnotationDocumentation_4001Parser();
		}
		return textAnnotationDocumentation_4001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createTextAnnotationDocumentation_4001Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Documentation(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser dataObjectName_4002Parser;

	/**
	 * @generated
	 */
	private IParser getDataObjectName_4002Parser() {
		if (dataObjectName_4002Parser == null) {
			dataObjectName_4002Parser = createDataObjectName_4002Parser();
		}
		return dataObjectName_4002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createDataObjectName_4002Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser poolName_4009Parser;

	/**
	 * @generated
	 */
	private IParser getPoolName_4009Parser() {
		if (poolName_4009Parser == null) {
			poolName_4009Parser = createPoolName_4009Parser();
		}
		return poolName_4009Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createPoolName_4009Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAgentName_4010Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	protected IParser createServiceName_4011Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser laneName_4008Parser;

	/**
	 * @generated
	 */
	private IParser getLaneName_4008Parser() {
		if (laneName_4008Parser == null) {
			laneName_4008Parser = createLaneName_4008Parser();
		}
		return laneName_4008Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createLaneName_4008Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser startName_4003Parser;

	/**
	 * @generated
	 */
	private IParser getStartName_4003Parser() {
		if (startName_4003Parser == null) {
			startName_4003Parser = createStartName_4003Parser();
		}
		return startName_4003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createStartName_4003Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser intermediateName_4004Parser;

	/**
	 * @generated
	 */
	private IParser getIntermediateName_4004Parser() {
		if (intermediateName_4004Parser == null) {
			intermediateName_4004Parser = createIntermediateName_4004Parser();
		}
		return intermediateName_4004Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createIntermediateName_4004Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser endName_4005Parser;

	/**
	 * @generated
	 */
	private IParser getEndName_4005Parser() {
		if (endName_4005Parser == null) {
			endName_4005Parser = createEndName_4005Parser();
		}
		return endName_4005Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createEndName_4005Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser activityName_4007Parser;

	/**
	 * @generated
	 */
	private IParser getActivityName_4007Parser() {
		if (activityName_4007Parser == null) {
			activityName_4007Parser = createActivityName_4007Parser();
		}
		return activityName_4007Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createActivityName_4007Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser gatewayName_4006Parser;

	/**
	 * @generated
	 */
	private IParser getGatewayName_4006Parser() {
		if (gatewayName_4006Parser == null) {
			gatewayName_4006Parser = createGatewayName_4006Parser();
		}
		return gatewayName_4006Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createGatewayName_4006Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser sequenceFlowName_4012Parser;

	/**
	 * @generated
	 */
	private IParser getSequenceFlowName_4012Parser() {
		if (sequenceFlowName_4012Parser == null) {
			sequenceFlowName_4012Parser = createSequenceFlowName_4012Parser();
		}
		return sequenceFlowName_4012Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createSequenceFlowName_4012Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser messageFlowName_4013Parser;

	/**
	 * @generated
	 */
	private IParser getMessageFlowName_4013Parser() {
		if (messageFlowName_4013Parser == null) {
			messageFlowName_4013Parser = createMessageFlowName_4013Parser();
		}
		return messageFlowName_4013Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createMessageFlowName_4013Parser() {
		EAttribute[] features = new EAttribute[] { VsdtPackage.eINSTANCE
				.getIdObject_Name(), };
		MessageFormatParser parser = new MessageFormatParser(features);
		return parser;
	}

	/**
	 * @generated
	 */
	private IParser associationName_4014Parser;

	/**
	 * @generated
	 */
	private IParser getAssociationName_4014Parser() {
		if (associationName_4014Parser == null) {
			associationName_4014Parser = createAssociationName_4014Parser();
		}
		return associationName_4014Parser;
	}

	/**
	 * @generated
	 */
	protected IParser createAssociationName_4014Parser() {
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
		case TextAnnotationDocumentationEditPart.VISUAL_ID:
			return getTextAnnotationDocumentation_4001Parser();
		case DataObjectNameEditPart.VISUAL_ID:
			return getDataObjectName_4002Parser();
		case PoolNameEditPart.VISUAL_ID:
			return getPoolName_4009Parser();
		case LaneNameEditPart.VISUAL_ID:
			return getLaneName_4008Parser();
		case StartNameEditPart.VISUAL_ID:
			return getStartName_4003Parser();
		case IntermediateNameEditPart.VISUAL_ID:
			return getIntermediateName_4004Parser();
		case EndNameEditPart.VISUAL_ID:
			return getEndName_4005Parser();
		case ActivityNameEditPart.VISUAL_ID:
			return getActivityName_4007Parser();
		case GatewayNameEditPart.VISUAL_ID:
			return getGatewayName_4006Parser();
		case SequenceFlowNameEditPart.VISUAL_ID:
			return getSequenceFlowName_4012Parser();
		case MessageFlowNameEditPart.VISUAL_ID:
			return getMessageFlowName_4013Parser();
		case AssociationNameEditPart.VISUAL_ID:
			return getAssociationName_4014Parser();
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
