package de.dailab.vsdt.diagram.actions.structuring;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * This Action can be used for sequentially two or more existing Flow Objects.
 * The Flow Objects are connected in the order they were selected. Therefore,
 * they should be selected one by one, not using 'margin selection'. Flow 
 * Objects that belong to different processes and are not connected; Flow
 * Objects that are connected already are not connected with a second Sequence 
 * Flow. 
 * 
 * @author kuester
 */
public class ConnectToSequenceAction implements IActionDelegate {

	/** Flow Object Edit Parts to connect */
	protected List<ShapeNodeEditPart> flowObjectEditParts;
	
	/** Adapter for the new node of the Pattern, needed for connecting a Sequence Flow */
	protected IAdaptable adapterForSequenceFlow;

	/**
	 * @return		The Name of the CompoundCommand to execute
	 */
	public String getCommandName() {
		return "Connect to Sequence";
	}
	
	public void selectionChanged(IAction action, ISelection selection) {
		flowObjectEditParts= new Vector<ShapeNodeEditPart>();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			
			for (Iterator iter= structuredSelection.iterator(); iter.hasNext(); ) {
				Object next= iter.next();
				if (next instanceof ShapeNodeEditPart) {
					ShapeNodeEditPart editPart= (ShapeNodeEditPart) next;
					EObject element= ((View) editPart.getModel()).getElement();
					if (element instanceof FlowObject) {
						flowObjectEditParts.add(editPart);
					}
				}
			}
		}
	}
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}
	
	public void run(IAction action) {
		//this compound command will hold the various partial commands
		CompoundCommand cc= new CompoundCommand(getCommandName());
		
		Iterator<ShapeNodeEditPart> iter= flowObjectEditParts.iterator();
		if (iter.hasNext()) {
			ShapeNodeEditPart last= iter.next();
			ShapeNodeEditPart next= null;
			
			while (iter.hasNext()) {
				next= iter.next();

				// do some tests
				boolean testsPassed= true;
				final FlowObject f1= (FlowObject) ((View) last.getModel()).getElement();
				final FlowObject f2= (FlowObject) ((View) next.getModel()).getElement();
				// are in same compartment?
				testsPassed &= f1.getAbstractProcess() == f2.getAbstractProcess();
				// sequence flow already exists?
				for (SequenceFlow sf : f1.getOutgoingSeq()) {
					testsPassed &= sf.getTarget() != f2;
				}
				
				if (testsPassed) {
					// Create Sequence Flow Command
					CreateConnectionViewAndElementRequest seqFlowRequest= new CreateConnectionViewAndElementRequest(
							VsdtElementTypes.SequenceFlow_3001,
							((IHintedType) VsdtElementTypes.SequenceFlow_3001).getSemanticHint(),
							last.getDiagramPreferencesHint());
					ICommand createSequenceFlowCmd = new DeferredCreateConnectionViewAndElementCommand(
							seqFlowRequest,
							new EObjectAdapter((EObject) last.getModel()),
							new EObjectAdapter((EObject) next.getModel()),
							last.getViewer());
					cc.add(new ICommandProxy(createSequenceFlowCmd));
				}
				
				last= next;
			}

			// execute commands
			last.getDiagramEditDomain().getDiagramCommandStack().execute(cc);
		}
	}
	
}
