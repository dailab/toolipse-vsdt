package de.dailab.vsdt.trafo.impl;

import java.util.ArrayList;
import java.util.List;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;

/**
 * This class provides a number of static, target-language independent methods
 * for validating a given BPMN model with respect to some given constraints.
 * It also provides some other commonly used helper methods. 
 * 
 * @author tkuester
 */
public class BpmnMappingHelper {
	
	/**
	 * This method is needed for preventing infinite loops when mapping reference
	 * activities. It checks whether the referenced activity is a parent of the
	 * referencing activity. Doing so it also gets cases in which the reference
	 * task is referencing a subprocess, holding another reference task,
	 * referencing the subprocess holding the original reference task.
	 * 
	 * @param parent	the potential parent (the referenced task)
	 * @param child		the potential child (the referencing task)
	 * @return			true, if the parent IS a parent of child (w.r.t. further references, too)
	 */
	public static boolean isParentOrEqual(FlowObject parent, FlowObject child) {
		// going from parent to children. normally, subprocess hierarchies won't
		// be very deep, so this should not be a problem
		if (parent != null && parent.equals(child)) {
			return true;
		} else {
			List<FlowObject> children= new ArrayList<FlowObject>();
			if (parent instanceof FlowObjectContainer) {
				FlowObjectContainer foc = (FlowObjectContainer) parent;
				children.addAll(foc.getContainedFlowObjects());
			}
			if (parent instanceof Activity) {
				Activity act = (Activity) parent;
				if (act.getCalledElement() instanceof Activity) {
					children.add((Activity) act.getCalledElement());
				}
			}
			for (FlowObject fo : children) {
				if (isParentOrEqual(fo, child)) {
					return true;
				}
			}
			return false;
		}
		// alternative version: going bottom-up is fast, but it does not get
		// cross references (a1<>-r1, a2<>-r2, r1->a2, r2->a1)
//		if (parent.equals(child)) {
//			return true;
//		} else {
//			if (child.eContainer() instanceof FlowObject) {
//				return isParentOrEqual(parent, (FlowObject) child.eContainer()); 
//			} else {
//				return false;
//			}
//		}
	}

}
