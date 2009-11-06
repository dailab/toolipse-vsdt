package de.dailab.vsdt.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * @generated
 */
public class VsdtPaletteFactory {

	/**
	 * add Broom-Tool
	 * excluded agents and services from palette
	 * @generated NOT
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
//        for (Object o : paletteRoot.getChildren()) {
//        	PaletteEntry paletteEntry= (PaletteEntry) o;
//            if (paletteEntry.getId().equals(PaletteService.GROUP_STANDARD)) {
//                PaletteContainer standard = (PaletteContainer) paletteEntry;
//                ImageDescriptor smallImage = null;
//                ImageDescriptor largeImage = null;
//                ToolEntry result = new ToolEntry("Broom","Horizontally move a group of elements.",
//                		smallImage, largeImage, MultipleShapesMoveTool.class);
//                standard.add(result);
//
//                break;
//            }
//        }
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createConnections2Group());
//		paletteRoot.add(createCustom3Group());
	}
	
	/**
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Nodes1Group_title);
		paletteContainer.setDescription(Messages.Nodes1Group_desc);
		paletteContainer.add(createPool1CreationTool());
		paletteContainer.add(createLane2CreationTool());
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createEvent4CreationTool());
		paletteContainer.add(createGateway5CreationTool());
		paletteContainer.add(createActivity6CreationTool());
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createDataObject8CreationTool());
		paletteContainer.add(createTextAnnotation9CreationTool());
		paletteContainer.add(createGroup10CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Connections2Group_title);
		paletteContainer.setDescription(Messages.Connections2Group_desc);
		paletteContainer.add(createSequenceFlow1CreationTool());
		paletteContainer.add(createMessageFlow2CreationTool());
		paletteContainer.add(createAssociation3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Custom" palette tool group
	 * @generated
	 */
	private PaletteContainer createCustom3Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Custom3Group_title);
		paletteContainer.setDescription(Messages.Custom3Group_desc);
		paletteContainer.add(createAgent1CreationTool());
		paletteContainer.add(createService2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPool1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(VsdtElementTypes.Pool_1004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Pool1CreationTool_title,
				Messages.Pool1CreationTool_desc, types);
		entry.setSmallIcon(VsdtElementTypes
				.getImageDescriptor(VsdtElementTypes.Pool_1004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createLane2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(VsdtElementTypes.Lane_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Lane2CreationTool_title,
				Messages.Lane2CreationTool_desc, types);
		entry.setSmallIcon(VsdtElementTypes
				.getImageDescriptor(VsdtElementTypes.Lane_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEvent4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(4);
		types.add(VsdtElementTypes.Start_2002);
		types.add(VsdtElementTypes.Intermediate_2003);
		types.add(VsdtElementTypes.End_2004);
		types.add(VsdtElementTypes.Intermediate_2007);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Event4CreationTool_title,
				Messages.Event4CreationTool_desc, types);
		entry.setSmallIcon(VsdtElementTypes
				.getImageDescriptor(VsdtElementTypes.Start_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGateway5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(VsdtElementTypes.Gateway_2006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Gateway5CreationTool_title,
				Messages.Gateway5CreationTool_desc, types);
		entry.setSmallIcon(VsdtElementTypes
				.getImageDescriptor(VsdtElementTypes.Gateway_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActivity6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(VsdtElementTypes.Activity_2005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Activity6CreationTool_title,
				Messages.Activity6CreationTool_desc, types);
		entry.setSmallIcon(VsdtElementTypes
				.getImageDescriptor(VsdtElementTypes.Activity_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataObject8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(VsdtElementTypes.DataObject_1003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataObject8CreationTool_title,
				Messages.DataObject8CreationTool_desc, types);
		entry.setSmallIcon(VsdtElementTypes
				.getImageDescriptor(VsdtElementTypes.DataObject_1003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTextAnnotation9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(VsdtElementTypes.TextAnnotation_1002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.TextAnnotation9CreationTool_title,
				Messages.TextAnnotation9CreationTool_desc, types);
		entry.setSmallIcon(VsdtElementTypes
				.getImageDescriptor(VsdtElementTypes.TextAnnotation_1002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGroup10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(VsdtElementTypes.Group_1001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Group10CreationTool_title,
				Messages.Group10CreationTool_desc, types);
		entry.setSmallIcon(VsdtElementTypes
				.getImageDescriptor(VsdtElementTypes.Group_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSequenceFlow1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(VsdtElementTypes.SequenceFlow_3001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.SequenceFlow1CreationTool_title,
				Messages.SequenceFlow1CreationTool_desc, types);
		entry.setSmallIcon(VsdtElementTypes
				.getImageDescriptor(VsdtElementTypes.SequenceFlow_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMessageFlow2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(VsdtElementTypes.MessageFlow_3002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.MessageFlow2CreationTool_title,
				Messages.MessageFlow2CreationTool_desc, types);
		entry.setSmallIcon(VsdtElementTypes
				.getImageDescriptor(VsdtElementTypes.MessageFlow_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(VsdtElementTypes.Association_3003);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Association3CreationTool_title,
				Messages.Association3CreationTool_desc, types);
		entry.setSmallIcon(VsdtElementTypes
				.getImageDescriptor(VsdtElementTypes.Association_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAgent1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(VsdtElementTypes.Agent_1005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Agent1CreationTool_title,
				Messages.Agent1CreationTool_desc, types);
		entry.setSmallIcon(VsdtElementTypes
				.getImageDescriptor(VsdtElementTypes.Agent_1005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createService2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(VsdtElementTypes.Service_1006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Service2CreationTool_title,
				Messages.Service2CreationTool_desc, types);
		entry.setSmallIcon(VsdtElementTypes
				.getImageDescriptor(VsdtElementTypes.Service_1006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
