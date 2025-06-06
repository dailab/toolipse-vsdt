package de.dailab.vsdt.diagram.views.structure;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import de.dailab.common.swt.views.AbstractContentProvider;
import de.dailab.common.swt.views.AbstractLabelProvider;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.End;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.diagram.providers.VsdtAdditionsPlugin;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * This class encapsulates the Structure Viewer, which is mainly defined by two
 * embedded classes: its ContentProvider and its LabelProvider.
 * 
 * @author kuester
 */
public class StructureViewer extends TreeViewer {
	
	public StructureViewer(Composite parent) {
		super(parent);
		setContentProvider(new ContentProvider());
		setLabelProvider(new LabelProvider());
	}
	
	/**
	 * This class provides the content for the Interpreter view (D'oh!)
	 * The input used for this Viewer is a {@link BusinessProcessDiagram}, which
	 * can (and should) also contain Structured Elements from the package
	 * {@link StrucBpmnPackage}. 
	 * 
	 * @author kuester
	 */
	public static class ContentProvider extends AbstractContentProvider implements ITreeContentProvider {

		public Object getParent(Object element) {
			if (element instanceof EObject) {
				return ((EObject)element).eContainer();
			}
			return null;
		}
		
		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}
		
		public Object[] getElements(Object parent) {
			if (parent instanceof BusinessProcessDiagram) {
				return ((BusinessProcessDiagram)parent).getPools().toArray();
			} else {
				return new Object[] {};
			}
		}

		public Object[] getChildren(Object parentElement) {
			List<Object> children= new ArrayList<Object>();
			if (parentElement instanceof Pool) {
				Pool pool= (Pool) parentElement;
				children.addAll(pool.getGraphicalElements());
			}
			if (parentElement instanceof Activity) {
				Activity activity = (Activity) parentElement;
				children.addAll(activity.getBoundaryEvents());
				if (activity.getActivityType() == ActivityType.EMBEDDED) {
					children.addAll(activity.getContainedFlowObjects());
				}
			}
			if (parentElement instanceof BpmnSequence) {
				BpmnSequence seq = (BpmnSequence) parentElement;
				children.addAll(seq.getElements());
			}
			if (parentElement instanceof BpmnBlock) {
				BpmnBlock block = (BpmnBlock) parentElement;
				children.add(block.getFirstGateway());
				children.addAll(block.getElements());
				children.add(block.getSecondGateway());
			}
			if (parentElement instanceof BpmnBranch) {
				BpmnBranch branch = (BpmnBranch) parentElement;
				children.add(branch.getElement());
			}
			if (parentElement instanceof BpmnLoopBlock) {
				BpmnLoopBlock loop = (BpmnLoopBlock) parentElement;
				children.add(loop.getFirstGateway());
				children.add(loop.getFirstBranch());
				children.add(loop.getSecondBranch());
				children.add(loop.getSecondGateway());
			}
			if (parentElement instanceof BpmnEventHandlerBlock) {
				BpmnEventHandlerBlock ehBlock = (BpmnEventHandlerBlock) parentElement;
				children.add(ehBlock.getActivity());
				children.addAll(ehBlock.getEventHandlerCases());
			}
			if (parentElement instanceof BpmnEventHandlerCase) {
				BpmnEventHandlerCase ehCase = (BpmnEventHandlerCase) parentElement;
				children.add(ehCase.getIntermediate());
				if (ehCase.getCompensationElement() != null) {
					children.add(ehCase.getCompensationElement());
				}
			}
			if (parentElement instanceof BpmnElementToSkip) {
				BpmnElementToSkip skip= (BpmnElementToSkip) parentElement;
				children.add(skip.getElement());
			}
			if (parentElement instanceof BpmnDerivedProcess) {
				BpmnDerivedProcess derived = (BpmnDerivedProcess) parentElement;
				children.add(derived.getElement());
			}
			return children.toArray();
		}
		
	}

	/**
	 * This class is used to provide the Labels used in the Structure Viewer
	 * 
	 * Basically, this will use {@link VsdtHelper#getDescriptiveName(EObject)},
	 * and for some of the structured elements additional information, such
	 * as the condition, or the begin and the end, are given, too.
	 * 
	 * @author kuester
	 */
	public static class LabelProvider extends AbstractLabelProvider {
		
		protected ImageDescriptor getImageDescriptor(Object element) {
			if (element instanceof Pool) {
				return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_POOL);
			}
			if (element instanceof Activity) {
				if (((Activity) element).getActivityType() == ActivityType.EMBEDDED) {
					return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_EMBEDDED);
				} else {
					return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_ACTIVITY);
				}
			}
			if (element instanceof Start) {
				return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_START);
			}
			if (element instanceof Intermediate) {
				return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_INTERMEDIATE);
			}
			if (element instanceof End) {
				return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_END);
			}
			if (element instanceof Gateway) {
				return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_GATEWAY);
			}
			// structure elements
			if (element instanceof BpmnSequence) {
				return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_SEQUENCE);
			}
			if (element instanceof BpmnBlock) {
				return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_BLOCK);
			}
			if (element instanceof BpmnBranch) {
				return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_BRANCH);
			}
			if (element instanceof BpmnLoopBlock) {
				return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_LOOP);
			}
			if (element instanceof BpmnEventHandlerBlock) {
				return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_EHBLOCK);
			}
			if (element instanceof BpmnEventHandlerCase) {
				return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_EHCASE);
			}
			if (element instanceof BpmnElementToSkip) {
				return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_SKIP);
			}
			if (element instanceof BpmnDerivedProcess) {
				return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_DERIVED);
			}
			return null;
		}
		
		@Override
		public String getText(Object element) {
			if (element instanceof EObject) {
				EObject eObject = (EObject) element;
				String label= VsdtHelper.getDescriptiveName(eObject);
				if (label.startsWith("Bpmn")) {
					label= label.substring(4);
				}
				if (element instanceof BpmnBranch) {
					BpmnBranch branch= (BpmnBranch) element;
					if (branch.isDefault()) {
						label+= " (default)";
					} else if (branch.getCondition() != null) {
						label+= " (condition: " + branch.getCondition().getExpression() + ")";
					}
				}
				if (element instanceof BpmnElementToSkip) {
					BpmnElementToSkip skip = (BpmnElementToSkip) element;
					label+= " (skipped on Event " + VsdtHelper.getDescriptiveName(skip.getEventHandlerCase().getIntermediate()) + ")";
				}
				if (element instanceof BpmnSequence) {
					BpmnSequence seq= (BpmnSequence) element;
					label+= " (starting at '" + VsdtHelper.getDescriptiveName(seq.getElements().get(0)) + "')";
				}
				return label;
			}
			return null;
		}
		
	}
	
}
