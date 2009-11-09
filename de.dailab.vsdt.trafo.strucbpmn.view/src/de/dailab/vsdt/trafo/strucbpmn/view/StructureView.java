package de.dailab.vsdt.trafo.strucbpmn.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import de.dailab.common.gmf.Util;
import de.dailab.common.gmf.ui.views.AbstractStructuredViewerView;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;
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
import de.dailab.vsdt.trafo.strucbpmn.VsdtStructureViewPlugin;
import de.dailab.vsdt.trafo.strucbpmn.export.Bpmn2StrucBpmnTransformation;
import de.dailab.vsdt.trafo.strucbpmn.layout.StructureLayout;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * This view allows to apply the Structure Mapping, displaying the results in a
 * tree.  By clicking on an element, the corresponding node in the diagram is
 * highlighted.  Further, the user is notified if there seem to be structural
 * conflicts in the process (determining this from the number of left-over
 * Sequence Flows).  This view should prove highly useful for validating the
 * structure of processes prior to transformation to executable code.
 * 
 * @author kuester
 */
public class StructureView extends AbstractStructuredViewerView implements ISelectionListener{

	private Action structurizeAction;
	private Action expandAllAction;
	private Action collapseAllAction;
	
	@Override
	public void createPartControl(Composite composite) {
		viewer= new StructureViewer(composite);
		super.createPartControl(composite);
	}
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		updateActionEnablement();
	}

	@Override
	protected void makeActions() {
		structurizeAction= new Action("Structurize", VsdtStructureViewPlugin.getImageDescriptor(VsdtStructureViewPlugin.IMAGE_STRUCTURIZE)) {
			public void run() {
				structurize();
			}
		};
		expandAllAction= new Action("Expand All", VsdtStructureViewPlugin.getImageDescriptor(VsdtStructureViewPlugin.IMAGE_EXPANDALL)) {
			public void run() {
				((TreeViewer) viewer).expandAll();
			}
		};
		collapseAllAction= new Action("Collapse All", VsdtStructureViewPlugin.getImageDescriptor(VsdtStructureViewPlugin.IMAGE_COLLAPSEALL)) {
			public void run() {
				((TreeViewer) viewer).collapseAll();
			}
		};
		contributeToToolBar(structurizeAction, expandAllAction, collapseAllAction);
		updateActionEnablement();
		
		contributeToMenu(new Action("Structure Based Layout (Experimental)", null) {
			@Override
			public void run() {
				if (isVsdtDiagram()) {
					IWorkbenchPage workbenchPage= getViewSite().getWorkbenchWindow().getActivePage();
					VsdtDiagramEditor editor= (VsdtDiagramEditor) workbenchPage.getActiveEditor();
					StructureLayout layout= new StructureLayout();
					Map<FlowObject, Rectangle> layoutMap= layout.createLayoutMap(editor);
					Command cmd= layout.getLayoutCommand(editor.getDiagramEditPart().getChildren(), true, layoutMap);
					editor.getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
				}
			}
		});
	}

	@Override
	protected void updateActionEnablement() {
		structurizeAction.setEnabled(isVsdtDiagram());
	}
	
	/**
	 * On Double-Click, the clicked element will be highlighted in the Editor.
	 * In case a Structured Element is clicked, all of it's constituting parts
	 * are highlighted.
	 */
	@Override
	protected void performDoubleClick() {
		// highlight selected element
		if (isVsdtDiagram()) {
			VsdtDiagramEditor editor= (VsdtDiagramEditor) getWorkbenchPage().getActiveEditor();
			Object selected= getSelectedElement();
			if (selected instanceof EObject) {
				selectInEditor((EObject) selected, editor);	
			}	
		}
	}
	
	/**
	 * The main functionality of this view: Retrieves the currently displayed
	 * BusinessProcessDiagram, creates a copy (!) and performs the Structure 
	 * Mapping on the copy.  The BPD is then set as input to the actual Viewer
	 * and a dialog warns the user if there are any Sequence Flows left.
	 * 
	 * @see Bpmn2StrucBpmnTransformation
	 */
	public void structurize() {
		if (isVsdtDiagram()) {
			IWorkbenchPage workbenchPage= getViewSite().getWorkbenchWindow().getActivePage();
			VsdtDiagramEditor editor= (VsdtDiagramEditor) workbenchPage.getActiveEditor();

			// create copy of Business Process Diagram
			BusinessProcessDiagram bpd= ((BusinessProcessDiagramEditPart) editor.getDiagramEditPart()).getCastedModel();
			bpd= (BusinessProcessDiagram) EcoreUtil.copy(bpd);

			// apply structure mapping
			MappingStage stage= new Bpmn2StrucBpmnTransformation();
			stage.initialize();
			stage.setWrapper(new MappingWrapper(bpd));
			stage.apply();

			// set viewer input
			viewer.setInput(bpd);
			
			// count sequence flows
			List<SequenceFlow> seqFlows= new ArrayList<SequenceFlow>();
			for (ConnectingObject connection : bpd.getConnections()) {
				if (connection instanceof SequenceFlow) {
					seqFlows.add((SequenceFlow) connection);
				}
			}
			if (! seqFlows.isEmpty()) {
				Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				String title= "Sequence Flows Left";
				StringBuffer message= new StringBuffer("There are Sequence Flows " +
						"left.  This may indicate structural conflicts in the " +
						"Process, as usually all Sequence Flows should get " +
						"detached during Structure Mapping.");
				message.append("\r\n");
				for (SequenceFlow seqFlow : seqFlows) {
					message.append("\r\n");
					message.append("- from ").append(VsdtHelper.getDescriptiveName(seqFlow.getSource()));
					message.append(" to ").append(VsdtHelper.getDescriptiveName(seqFlow.getTarget()));
				}
				MessageDialog.openWarning(shell, title, message.toString());
			}
		}
	}
	
	/**
	 * This method is called when an element in the tree view is double-clicked.
	 * The edit part corresponding to the given EObject is retrieved and high-
	 * lighted in the editor using the respective methods.  In case of a structured
	 * element, not the element itself (which has no edit part) will be highlighted,
	 * but it's constituting parts, in which case the method will be called
	 * recursively.
	 * 
	 * @see #getEditPart(EObject, DiagramEditor)
	 * @see #highlight(AbstractGraphicalEditPart, DiagramEditor)
	 * 
	 * @param eObject	Some EObject
	 * @param editor	Diagram Editor in which the EObject shall be highlighted
	 */
	protected void selectInEditor(EObject eObject, DiagramEditor editor) {
		if (eObject instanceof Pool || eObject instanceof FlowObject) {
			AbstractGraphicalEditPart editPart= Util.getEditPart(eObject, editor, "id");
			if (editPart != null) {
				Util.highlight(editPart, editor);
			}
		}
		if (eObject instanceof BpmnSequence) {
			BpmnSequence seq = (BpmnSequence) eObject;
			for (FlowObject flowObject : seq.getElements()) {
				selectInEditor(flowObject, editor);
			}
		}
		if (eObject instanceof BpmnBlock) {
			BpmnBlock block = (BpmnBlock) eObject;
			selectInEditor(block.getFirstGateway(), editor);
			selectInEditor(block.getSecondGateway(), editor);
			for (FlowObject flowObject : block.getElements()) {
				selectInEditor(flowObject, editor);
			}
		}
		if (eObject instanceof BpmnBranch) {
			BpmnBranch branch = (BpmnBranch) eObject;
			selectInEditor(branch.getElement(), editor);
		}
		if (eObject instanceof BpmnLoopBlock) {
			BpmnLoopBlock loop = (BpmnLoopBlock) eObject;
			selectInEditor(loop.getFirstGateway(), editor);
			selectInEditor(loop.getFirstBranch(), editor);
			selectInEditor(loop.getSecondBranch(), editor);
			selectInEditor(loop.getSecondGateway(), editor);
		}
		if (eObject instanceof BpmnEventHandlerBlock) {
			BpmnEventHandlerBlock ehBlock = (BpmnEventHandlerBlock) eObject;
			selectInEditor(ehBlock.getActivity(), editor);
			for (BpmnEventHandlerCase ehCase : ehBlock.getEventHandlerCases()) {
				selectInEditor(ehCase, editor);
			}
		}
		if (eObject instanceof BpmnEventHandlerCase) {
			BpmnEventHandlerCase ehCase = (BpmnEventHandlerCase) eObject;
			selectInEditor(ehCase.getIntermediate(), editor);
			if (ehCase.getCompensationElement() != null) {
				selectInEditor(ehCase.getCompensationElement(), editor);
			}
			if (ehCase.getElementToSkip() != null) {
				selectInEditor(ehCase.getElementToSkip(), editor);
			}
		}
		if (eObject instanceof BpmnElementToSkip) {
			BpmnElementToSkip skip= (BpmnElementToSkip) eObject;
			selectInEditor(skip.getElement(), editor);
		}
		if (eObject instanceof BpmnDerivedProcess) {
			BpmnDerivedProcess derived = (BpmnDerivedProcess) eObject;
			selectInEditor(derived.getElement(), editor);
		}
	}
	
	/**
	 * @return		Check whether the active editor is a {@link VsdtDiagramEditor}
	 */
	protected boolean isVsdtDiagram() {
		IWorkbenchPage wp= getWorkbenchPage();
		return wp != null && wp.getActiveEditor() instanceof VsdtDiagramEditor;
	}
	
	/**
	 * Retrieves the WorkbenchPage, adds this view as a listener to it (if not
	 * already happened) and returns the WorkbenchPage.
	 * 
	 */
	protected IWorkbenchPage getWorkbenchPage() {
		IWorkbenchPage workbenchPage= getViewSite().getWorkbenchWindow().getActivePage();
		if (workbenchPage != null) {
			workbenchPage.addSelectionListener(this);
		}
		return workbenchPage;
	}

}