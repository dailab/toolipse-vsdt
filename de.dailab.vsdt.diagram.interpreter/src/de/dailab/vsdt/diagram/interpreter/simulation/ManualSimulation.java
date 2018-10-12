package de.dailab.vsdt.diagram.interpreter.simulation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.diagram.interpreter.dialogs.SelectPathDialog;
import de.dailab.vsdt.interpreter.BasicSimulation;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * This class extends the BasicSimulation with some dialogs for manually
 * controlling the process.
 * 
 * @author kuester
 */
public class ManualSimulation extends BasicSimulation {
	
	@Override
	public String getName() {
		return "Manual Simulation";
	}
	
	/**
	 * manual simulation is always applicable
	 */
	@Override
	public boolean isApplicable(EObject object) throws Exception {
		return true;
	}
	
	/**
	 * manual simulation is always applicable
	 */
	@Override
	protected boolean checkDiagram(EObject object) {
		return true;
	}
	
	/**
	 * no initialization needed
	 */
	@Override
	protected void initialize(EObject object) {
		// do nothing
	}
	
	/**
	 * If the Activity has Loop attributes, simply show a dialogue to the user,
	 * asking whether to repeat the Activity, or not.
	 */
	@Override
	protected boolean isLooping(Activity activity) {
		if (activity != null && activity.getLoopAttributes() != null) {
			String title= "Activity Looping";
			StringBuffer message= new StringBuffer();
			message.append("The ").append(VsdtHelper.getDescriptiveName(activity));
			message.append(" can be executed in a ");
			message.append(activity.getLoopAttributes() instanceof StandardLoopAttSet
					? "Standard" : "Multi Instance").append(" Loop.");
			message.append("\r\n").append("Shall the Activity be repeated now?");
			Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			return MessageDialog.openQuestion(shell, title, message.toString());
		} else {
			return false;
		}
	}

	/**
	 * In the Manual Simulation, selecting the outgoing Sequence Flows is done
	 * by presenting a dialogue to the user, prompting him for his selection.
	 * If the dialogue is canceled, the method will return null.
	 */
	@Override
	protected List<SequenceFlow> selectOutgoingSequenceFlows(FlowObject flowObject) {
		Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		SelectPathDialog dialog= new SelectPathDialog(shell, flowObject);
		if (dialog.open() == SelectPathDialog.OK) {
			return dialog.getSelected();
		} else {
			return null;
		}
	}
	
	/**
	 * no assignments handling in manual simulation
	 */
	@Override
	protected boolean handleAssignments(EObject eObject, AssignTimeType assignTime) {
		// do nothing
		return true;
	}
	
}
