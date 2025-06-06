package de.dailab.vsdt.diagram.layout;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.MappingWrapper;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;
import de.dailab.vsdt.trafo.strucbpmn.export.Bpmn2StrucBpmnTransformation;

/**
 * Simple Layout Algorithm using the Structured Form of the Diagram for
 * calculating the positions of the nodes. The Structured Form is acquired by
 * using the same structuring algorithm that is used for the various
 * transformations. The down-side of this approach is, that the layout works only
 * if the process can be structured in the first place. Then again, processes
 * that can not be structured are not of too much interest anyway...
 * 
 * @author kuester
 */
public class StructureLayout extends AbstractLayout {

	public StructureLayout() {
		super("Structure-based Layout");
	}
	
	/**
	 * Structurize the given Process Diagram prior to calculating its layout.
	 * 
	 * @param bpd	Business Process Diagram
	 * @return		Structured copy of given Business Process Diagram
	 */
	protected BusinessProcessDiagram structurize(BusinessProcessDiagram bpd) {
		// create copy of Business Process Diagram
		BusinessProcessDiagram strucBpd= (BusinessProcessDiagram) EcoreUtil.copy(bpd);

		// apply structure mapping
		MappingStage stage= new Bpmn2StrucBpmnTransformation();
		stage.initialize();
		stage.setWrapper(new MappingWrapper(strucBpd));
		stage.apply();
		
		return strucBpd;
	}
	
	/**
	 * Pass through structured process tree and calculate each element's position.
	 * 
	 * @param strucBpd		Structured copy of Business Process Diagram
	 * @return				Map holding association of FlowObjects to Rectangles
	 */
	@Override
	protected Map<FlowObject, Rectangle> createLayoutMap(BusinessProcessDiagram bpd) {
		BusinessProcessDiagram strucBpd= structurize(bpd);
		Map<FlowObject, Rectangle> layoutMap= new HashMap<FlowObject, Rectangle>();
		for (Pool pool : strucBpd.getPools()) {
			Point hint= new Point(OFFSET, OFFSET);
			for (FlowObject flowObject : pool.getGraphicalElements()) {
				Rectangle r= calculatePosition(flowObject, hint, false, layoutMap);
				hint.x= r.x;
				hint.y= r.bottom();
			}
			// TODO layout pools
//			layoutMap.put(pool, ...);
		}
		return layoutMap;
	}
	
	/**
	 * Recursively calculate Position of given element and its children.
	 * 
	 * @param flowObject	Some FlowObject
	 * @param topLeft		Top left corner for that FlowObject's position
	 * @param reverse		Reverse mode? E.g. in second branch of a Loop.
	 * @param layoutMap		Current layout map to use (the result goes here, too)
	 * @return				Calculated Position of the given FlowObject
	 */
	protected Rectangle calculatePosition(FlowObject flowObject, Point topLeft, 
			boolean reverse, Map<FlowObject, Rectangle> layoutMap) {
		Rectangle result= null;
		
		// atomic BPMN elements
		if (flowObject instanceof Event || flowObject instanceof Gateway) {
			result= new Rectangle(topLeft, topLeft.getCopy().translate(SIZE_GATEWAY));
		}
		// activities, atomic and otherwise
		if (flowObject instanceof Activity) {
			Activity activity = (Activity) flowObject;
			result= new Rectangle(topLeft, topLeft.getCopy().translate(SIZE_ACTIVITY));		
			if (! activity.getContainedFlowObjects().isEmpty()) {
				Point hint= new Point(OFFSET, OFFSET);
				Rectangle r= null;
				int width= 0;
				for (FlowObject child : activity.getContainedFlowObjects()) {
					// TODO improve layout for contained flow objects
					r= calculatePosition(child, hint, reverse, layoutMap);
					hint.y += r.height + MARGIN_V;
					width= r.width > width ? r.width : width;
				}
				result= new Rectangle(topLeft, topLeft.getCopy().translate(width+40, r.y+r.height+40));
			}
			if (! activity.getBoundaryEvents().isEmpty()) {
				// TODO layout boundary events
			}
		}

		// Sequences
		if (flowObject instanceof BpmnSequence) {
			BpmnSequence seq = (BpmnSequence) flowObject;
			int newX= topLeft.x;
			int height= 0;
			Rectangle r= null;
			Point p= null;
			// pass through sequence (in reverted order if in reverse mode)
			for (int i= ! reverse ? 0 : seq.getElements().size()-1; i>=0 && i<seq.getElements().size(); i+= reverse ? -1 : +1) {
				p= new Point(newX, topLeft.y);
				r= calculatePosition(seq.getElements().get(i), p, reverse, layoutMap);
				newX= r.right() + MARGIN_H;
				height= r.height > height ? r.height : height;
			}
			result= new Rectangle(topLeft.x, topLeft.y, r.right()-topLeft.x, height);	
		}
		
		// Blocks
		if (flowObject instanceof BpmnBlock) {
			BpmnBlock block = (BpmnBlock) flowObject;
			Rectangle fg= calculatePosition(reverse ? block.getSecondGateway() : block.getFirstGateway(), topLeft, reverse, layoutMap);
			int newY= topLeft.y;
			int width= 0;
			Rectangle r= null;
			Point p= null;
			for (FlowObject child : block.getElements()) {
				p= new Point(fg.right()+MARGIN_H, newY);
				r= calculatePosition(child, p, reverse, layoutMap);
				newY= r.bottom() + MARGIN_V;
				width= r.width > width? r.width : width;
			}
			p= new Point(fg.right()+width+2*MARGIN_H, topLeft.y);
			Rectangle sg= calculatePosition(reverse ? block.getFirstGateway() : block.getSecondGateway(), p, reverse, layoutMap);
			result= new Rectangle(fg.x, fg.y, sg.right()-fg.x, r.bottom()-fg.y);
		}
		
		// Loops
		if (flowObject instanceof BpmnLoopBlock) {
			BpmnLoopBlock loop = (BpmnLoopBlock) flowObject;
			Rectangle fg= calculatePosition(reverse ? loop.getSecondGateway() : loop.getFirstGateway(), topLeft, reverse, layoutMap);
			
			// first branch
			Point p= new Point(fg.right()+MARGIN_H, topLeft.y);
			Rectangle r= calculatePosition(loop.getFirstBranch(), p, reverse, layoutMap);
			int width= r.width;
			
			// second branch
			p= p.getCopy().translate(0, r.height+MARGIN_V);
			r= calculatePosition(loop.getSecondBranch(), p, ! reverse, layoutMap);
			width= r.width > width? r.width : width;
			
			p= new Point(fg.right()+width+2*MARGIN_H, topLeft.y);
			Rectangle sg= calculatePosition(reverse ? loop.getFirstGateway() : loop.getSecondGateway(), p, reverse, layoutMap);
			result= new Rectangle(fg.x, fg.y, sg.right()-fg.x, r.bottom()-fg.y);
		}

		// Event Handler Blocks
		if (flowObject instanceof BpmnEventHandlerBlock) {
			BpmnEventHandlerBlock ehBlock= (BpmnEventHandlerBlock) flowObject;
			Rectangle act= calculatePosition(ehBlock.getActivity(), topLeft, reverse, layoutMap);
			int newY= act.bottom()+MARGIN_V;
			int width= 0;
			Rectangle r= null;
			Point p= null;
			for (BpmnEventHandlerCase ehCase : ehBlock.getEventHandlerCases()) {
				p= new Point(act.right(), newY);
				r= calculatePosition(ehCase, p, reverse, layoutMap);
				newY= r.bottom() + MARGIN_V;
				width= r.width > width ? r.width : width;
			}
			// TODO improve overlapping with elements to skip: width= comp.width-skip.width 
			result= new Rectangle(topLeft.x, topLeft.y, act.width+width , r.bottom()-topLeft.y);
		}
		
		// other: delegate to wrapped element
		if (flowObject instanceof BpmnBranch) {
			result= calculatePosition(((BpmnBranch) flowObject).getElement(), topLeft, reverse, layoutMap);
		}
		if (flowObject instanceof BpmnElementToSkip) {
			result= calculatePosition(((BpmnElementToSkip) flowObject).getElement(), topLeft, reverse, layoutMap);
		}
		if (flowObject instanceof BpmnEventHandlerCase) {
			result= calculatePosition(((BpmnEventHandlerCase) flowObject).getCompensationElement(), topLeft, reverse, layoutMap);
		}
		if (flowObject instanceof BpmnDerivedProcess) {
			result= calculatePosition(((BpmnDerivedProcess) flowObject).getElement(), topLeft, reverse, layoutMap);
		}
		
		// put result into layout map
		if (result != null) {
			if (layoutMap.get(flowObject) == null) {
				layoutMap.put(flowObject, result);
			}
		} else {
			System.err.println("Result is null for FlowObject " + flowObject);
			result= new Rectangle(topLeft, topLeft.getCopy().translate(SIZE_DEFAULT));
		}
		return result;
	}
	
}
