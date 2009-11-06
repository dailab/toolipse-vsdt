package de.dailab.vsdt.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.Agent;
import de.dailab.vsdt.Artifact;
import de.dailab.vsdt.Association;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.DataObject;
import de.dailab.vsdt.End;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GraphicalObject;
import de.dailab.vsdt.Group;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.Node;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.TextAnnotation;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.parts.ActivityEditPart;
import de.dailab.vsdt.diagram.edit.parts.ActivitySubprocessCompartmentEditPart;
import de.dailab.vsdt.diagram.edit.parts.AgentEditPart;
import de.dailab.vsdt.diagram.edit.parts.AssociationEditPart;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.edit.parts.DataObjectEditPart;
import de.dailab.vsdt.diagram.edit.parts.EndEditPart;
import de.dailab.vsdt.diagram.edit.parts.GatewayEditPart;
import de.dailab.vsdt.diagram.edit.parts.GroupEditPart;
import de.dailab.vsdt.diagram.edit.parts.Intermediate2EditPart;
import de.dailab.vsdt.diagram.edit.parts.IntermediateEditPart;
import de.dailab.vsdt.diagram.edit.parts.LaneEditPart;
import de.dailab.vsdt.diagram.edit.parts.LaneLaneCompartmentEditPart;
import de.dailab.vsdt.diagram.edit.parts.MessageFlowEditPart;
import de.dailab.vsdt.diagram.edit.parts.PoolEditPart;
import de.dailab.vsdt.diagram.edit.parts.PoolPoolCompartmentEditPart;
import de.dailab.vsdt.diagram.edit.parts.SequenceFlowEditPart;
import de.dailab.vsdt.diagram.edit.parts.ServiceEditPart;
import de.dailab.vsdt.diagram.edit.parts.StartEditPart;
import de.dailab.vsdt.diagram.edit.parts.TextAnnotationEditPart;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * @generated
 */
public class VsdtDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (VsdtVisualIDRegistry.getVisualID(view)) {
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2005SemanticChildren(view);
		case PoolPoolCompartmentEditPart.VISUAL_ID:
			return getPoolPoolCompartment_5001SemanticChildren(view);
		case LaneLaneCompartmentEditPart.VISUAL_ID:
			return getLaneLaneCompartment_5002SemanticChildren(view);
		case ActivitySubprocessCompartmentEditPart.VISUAL_ID:
			return getActivitySubprocessCompartment_5003SemanticChildren(view);
		case BusinessProcessDiagramEditPart.VISUAL_ID:
			return getBusinessProcessDiagram_79SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivity_2005SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getBoundaryEvents().iterator(); it
				.hasNext();) {
			Intermediate childElement = (Intermediate) it.next();
			int visualID = VsdtVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Intermediate2EditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPoolPoolCompartment_5001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Pool modelElement = (Pool) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getLanes().iterator(); it.hasNext();) {
			Lane childElement = (Lane) it.next();
			int visualID = VsdtVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == LaneEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getLaneLaneCompartment_5002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Lane modelElement = (Lane) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getContainedFlowObjects().iterator(); it
				.hasNext();) {
			FlowObject childElement = (FlowObject) it.next();
			int visualID = VsdtVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StartEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IntermediateEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EndEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ActivityEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == GatewayEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivitySubprocessCompartment_5003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Activity modelElement = (Activity) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getContainedFlowObjects().iterator(); it
				.hasNext();) {
			FlowObject childElement = (FlowObject) it.next();
			int visualID = VsdtVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ActivityEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == EndEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == GatewayEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == IntermediateEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == StartEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBusinessProcessDiagram_79SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		BusinessProcessDiagram modelElement = (BusinessProcessDiagram) view
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getArtifacts().iterator(); it.hasNext();) {
			Artifact childElement = (Artifact) it.next();
			int visualID = VsdtVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == GroupEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == TextAnnotationEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == DataObjectEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == AgentEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ServiceEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getPools().iterator(); it.hasNext();) {
			Pool childElement = (Pool) it.next();
			int visualID = VsdtVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PoolEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (VsdtVisualIDRegistry.getVisualID(view)) {
		case BusinessProcessDiagramEditPart.VISUAL_ID:
			return getBusinessProcessDiagram_79ContainedLinks(view);
		case GroupEditPart.VISUAL_ID:
			return getGroup_1001ContainedLinks(view);
		case TextAnnotationEditPart.VISUAL_ID:
			return getTextAnnotation_1002ContainedLinks(view);
		case DataObjectEditPart.VISUAL_ID:
			return getDataObject_1003ContainedLinks(view);
		case PoolEditPart.VISUAL_ID:
			return getPool_1004ContainedLinks(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_1005ContainedLinks(view);
		case ServiceEditPart.VISUAL_ID:
			return getService_1006ContainedLinks(view);
		case LaneEditPart.VISUAL_ID:
			return getLane_2001ContainedLinks(view);
		case StartEditPart.VISUAL_ID:
			return getStart_2002ContainedLinks(view);
		case IntermediateEditPart.VISUAL_ID:
			return getIntermediate_2003ContainedLinks(view);
		case EndEditPart.VISUAL_ID:
			return getEnd_2004ContainedLinks(view);
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2005ContainedLinks(view);
		case GatewayEditPart.VISUAL_ID:
			return getGateway_2006ContainedLinks(view);
		case Intermediate2EditPart.VISUAL_ID:
			return getIntermediate_2007ContainedLinks(view);
		case SequenceFlowEditPart.VISUAL_ID:
			return getSequenceFlow_3001ContainedLinks(view);
		case MessageFlowEditPart.VISUAL_ID:
			return getMessageFlow_3002ContainedLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_3003ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (VsdtVisualIDRegistry.getVisualID(view)) {
		case GroupEditPart.VISUAL_ID:
			return getGroup_1001IncomingLinks(view);
		case TextAnnotationEditPart.VISUAL_ID:
			return getTextAnnotation_1002IncomingLinks(view);
		case DataObjectEditPart.VISUAL_ID:
			return getDataObject_1003IncomingLinks(view);
		case PoolEditPart.VISUAL_ID:
			return getPool_1004IncomingLinks(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_1005IncomingLinks(view);
		case ServiceEditPart.VISUAL_ID:
			return getService_1006IncomingLinks(view);
		case LaneEditPart.VISUAL_ID:
			return getLane_2001IncomingLinks(view);
		case StartEditPart.VISUAL_ID:
			return getStart_2002IncomingLinks(view);
		case IntermediateEditPart.VISUAL_ID:
			return getIntermediate_2003IncomingLinks(view);
		case EndEditPart.VISUAL_ID:
			return getEnd_2004IncomingLinks(view);
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2005IncomingLinks(view);
		case GatewayEditPart.VISUAL_ID:
			return getGateway_2006IncomingLinks(view);
		case Intermediate2EditPart.VISUAL_ID:
			return getIntermediate_2007IncomingLinks(view);
		case SequenceFlowEditPart.VISUAL_ID:
			return getSequenceFlow_3001IncomingLinks(view);
		case MessageFlowEditPart.VISUAL_ID:
			return getMessageFlow_3002IncomingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_3003IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (VsdtVisualIDRegistry.getVisualID(view)) {
		case GroupEditPart.VISUAL_ID:
			return getGroup_1001OutgoingLinks(view);
		case TextAnnotationEditPart.VISUAL_ID:
			return getTextAnnotation_1002OutgoingLinks(view);
		case DataObjectEditPart.VISUAL_ID:
			return getDataObject_1003OutgoingLinks(view);
		case PoolEditPart.VISUAL_ID:
			return getPool_1004OutgoingLinks(view);
		case AgentEditPart.VISUAL_ID:
			return getAgent_1005OutgoingLinks(view);
		case ServiceEditPart.VISUAL_ID:
			return getService_1006OutgoingLinks(view);
		case LaneEditPart.VISUAL_ID:
			return getLane_2001OutgoingLinks(view);
		case StartEditPart.VISUAL_ID:
			return getStart_2002OutgoingLinks(view);
		case IntermediateEditPart.VISUAL_ID:
			return getIntermediate_2003OutgoingLinks(view);
		case EndEditPart.VISUAL_ID:
			return getEnd_2004OutgoingLinks(view);
		case ActivityEditPart.VISUAL_ID:
			return getActivity_2005OutgoingLinks(view);
		case GatewayEditPart.VISUAL_ID:
			return getGateway_2006OutgoingLinks(view);
		case Intermediate2EditPart.VISUAL_ID:
			return getIntermediate_2007OutgoingLinks(view);
		case SequenceFlowEditPart.VISUAL_ID:
			return getSequenceFlow_3001OutgoingLinks(view);
		case MessageFlowEditPart.VISUAL_ID:
			return getMessageFlow_3002OutgoingLinks(view);
		case AssociationEditPart.VISUAL_ID:
			return getAssociation_3003OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBusinessProcessDiagram_79ContainedLinks(View view) {
		BusinessProcessDiagram modelElement = (BusinessProcessDiagram) view
				.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_SequenceFlow_3001(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_MessageFlow_3002(modelElement));
		result
				.addAll(getContainedTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGroup_1001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTextAnnotation_1002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDataObject_1003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPool_1004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAgent_1005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getService_1006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getLane_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStart_2002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIntermediate_2003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getEnd_2004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getActivity_2005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGateway_2006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIntermediate_2007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSequenceFlow_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getMessageFlow_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getGroup_1001IncomingLinks(View view) {
		Group modelElement = (Group) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTextAnnotation_1002IncomingLinks(View view) {
		TextAnnotation modelElement = (TextAnnotation) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataObject_1003IncomingLinks(View view) {
		DataObject modelElement = (DataObject) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPool_1004IncomingLinks(View view) {
		Pool modelElement = (Pool) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_MessageFlow_3002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAgent_1005IncomingLinks(View view) {
		Agent modelElement = (Agent) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getService_1006IncomingLinks(View view) {
		Service modelElement = (Service) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getLane_2001IncomingLinks(View view) {
		Lane modelElement = (Lane) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStart_2002IncomingLinks(View view) {
		Start modelElement = (Start) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_SequenceFlow_3001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_MessageFlow_3002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIntermediate_2003IncomingLinks(View view) {
		Intermediate modelElement = (Intermediate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_SequenceFlow_3001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_MessageFlow_3002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnd_2004IncomingLinks(View view) {
		End modelElement = (End) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_SequenceFlow_3001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_MessageFlow_3002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivity_2005IncomingLinks(View view) {
		Activity modelElement = (Activity) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_SequenceFlow_3001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_MessageFlow_3002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGateway_2006IncomingLinks(View view) {
		Gateway modelElement = (Gateway) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_SequenceFlow_3001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_MessageFlow_3002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIntermediate_2007IncomingLinks(View view) {
		Intermediate modelElement = (Intermediate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_SequenceFlow_3001(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_MessageFlow_3002(
				modelElement, crossReferences));
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSequenceFlow_3001IncomingLinks(View view) {
		SequenceFlow modelElement = (SequenceFlow) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessageFlow_3002IncomingLinks(View view) {
		MessageFlow modelElement = (MessageFlow) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3003IncomingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Association_3003(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGroup_1001OutgoingLinks(View view) {
		Group modelElement = (Group) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTextAnnotation_1002OutgoingLinks(View view) {
		TextAnnotation modelElement = (TextAnnotation) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDataObject_1003OutgoingLinks(View view) {
		DataObject modelElement = (DataObject) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPool_1004OutgoingLinks(View view) {
		Pool modelElement = (Pool) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_MessageFlow_3002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAgent_1005OutgoingLinks(View view) {
		Agent modelElement = (Agent) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getService_1006OutgoingLinks(View view) {
		Service modelElement = (Service) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getLane_2001OutgoingLinks(View view) {
		Lane modelElement = (Lane) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStart_2002OutgoingLinks(View view) {
		Start modelElement = (Start) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_SequenceFlow_3001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_MessageFlow_3002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIntermediate_2003OutgoingLinks(View view) {
		Intermediate modelElement = (Intermediate) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_SequenceFlow_3001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_MessageFlow_3002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getEnd_2004OutgoingLinks(View view) {
		End modelElement = (End) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_SequenceFlow_3001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_MessageFlow_3002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getActivity_2005OutgoingLinks(View view) {
		Activity modelElement = (Activity) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_SequenceFlow_3001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_MessageFlow_3002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getGateway_2006OutgoingLinks(View view) {
		Gateway modelElement = (Gateway) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_SequenceFlow_3001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_MessageFlow_3002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getIntermediate_2007OutgoingLinks(View view) {
		Intermediate modelElement = (Intermediate) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_SequenceFlow_3001(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_MessageFlow_3002(modelElement));
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSequenceFlow_3001OutgoingLinks(View view) {
		SequenceFlow modelElement = (SequenceFlow) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getMessageFlow_3002OutgoingLinks(View view) {
		MessageFlow modelElement = (MessageFlow) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getAssociation_3003OutgoingLinks(View view) {
		Association modelElement = (Association) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Association_3003(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_SequenceFlow_3001(
			BusinessProcessDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnections().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof SequenceFlow) {
				continue;
			}
			SequenceFlow link = (SequenceFlow) linkObject;
			if (SequenceFlowEditPart.VISUAL_ID != VsdtVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FlowObject dst = link.getTarget();
			FlowObject src = link.getSource();
			result.add(new VsdtLinkDescriptor(src, dst, link,
					VsdtElementTypes.SequenceFlow_3001,
					SequenceFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_MessageFlow_3002(
			BusinessProcessDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnections().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof MessageFlow) {
				continue;
			}
			MessageFlow link = (MessageFlow) linkObject;
			if (MessageFlowEditPart.VISUAL_ID != VsdtVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTarget();
			Node src = link.getSource();
			result.add(new VsdtLinkDescriptor(src, dst, link,
					VsdtElementTypes.MessageFlow_3002,
					MessageFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Association_3003(
			BusinessProcessDiagram container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getConnections().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (AssociationEditPart.VISUAL_ID != VsdtVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			GraphicalObject dst = link.getTarget();
			GraphicalObject src = link.getSource();
			result.add(new VsdtLinkDescriptor(src, dst, link,
					VsdtElementTypes.Association_3003,
					AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_SequenceFlow_3001(
			FlowObject target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != VsdtPackage.eINSTANCE
					.getSequenceFlow_Target()
					|| false == setting.getEObject() instanceof SequenceFlow) {
				continue;
			}
			SequenceFlow link = (SequenceFlow) setting.getEObject();
			if (SequenceFlowEditPart.VISUAL_ID != VsdtVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FlowObject src = link.getSource();
			result.add(new VsdtLinkDescriptor(src, target, link,
					VsdtElementTypes.SequenceFlow_3001,
					SequenceFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_MessageFlow_3002(
			Node target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != VsdtPackage.eINSTANCE
					.getMessageFlow_Target()
					|| false == setting.getEObject() instanceof MessageFlow) {
				continue;
			}
			MessageFlow link = (MessageFlow) setting.getEObject();
			if (MessageFlowEditPart.VISUAL_ID != VsdtVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node src = link.getSource();
			result.add(new VsdtLinkDescriptor(src, target, link,
					VsdtElementTypes.MessageFlow_3002,
					MessageFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Association_3003(
			GraphicalObject target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != VsdtPackage.eINSTANCE
					.getAssociation_Target()
					|| false == setting.getEObject() instanceof Association) {
				continue;
			}
			Association link = (Association) setting.getEObject();
			if (AssociationEditPart.VISUAL_ID != VsdtVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			GraphicalObject src = link.getSource();
			result.add(new VsdtLinkDescriptor(src, target, link,
					VsdtElementTypes.Association_3003,
					AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_SequenceFlow_3001(
			FlowObject source) {
		BusinessProcessDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof BusinessProcessDiagram) {
				container = (BusinessProcessDiagram) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnections().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof SequenceFlow) {
				continue;
			}
			SequenceFlow link = (SequenceFlow) linkObject;
			if (SequenceFlowEditPart.VISUAL_ID != VsdtVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			FlowObject dst = link.getTarget();
			FlowObject src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new VsdtLinkDescriptor(src, dst, link,
					VsdtElementTypes.SequenceFlow_3001,
					SequenceFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_MessageFlow_3002(
			Node source) {
		BusinessProcessDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof BusinessProcessDiagram) {
				container = (BusinessProcessDiagram) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnections().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof MessageFlow) {
				continue;
			}
			MessageFlow link = (MessageFlow) linkObject;
			if (MessageFlowEditPart.VISUAL_ID != VsdtVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTarget();
			Node src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new VsdtLinkDescriptor(src, dst, link,
					VsdtElementTypes.MessageFlow_3002,
					MessageFlowEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Association_3003(
			GraphicalObject source) {
		BusinessProcessDiagram container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof BusinessProcessDiagram) {
				container = (BusinessProcessDiagram) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getConnections().iterator(); links
				.hasNext();) {
			Object linkObject = links.next();
			if (false == linkObject instanceof Association) {
				continue;
			}
			Association link = (Association) linkObject;
			if (AssociationEditPart.VISUAL_ID != VsdtVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			GraphicalObject dst = link.getTarget();
			GraphicalObject src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new VsdtLinkDescriptor(src, dst, link,
					VsdtElementTypes.Association_3003,
					AssociationEditPart.VISUAL_ID));
		}
		return result;
	}

}
