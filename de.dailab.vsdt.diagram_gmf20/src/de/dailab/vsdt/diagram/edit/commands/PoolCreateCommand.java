package de.dailab.vsdt.diagram.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.BpmnProcess;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;

/**
 * @generated
 */
public class PoolCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public PoolCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest())
				.getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return VsdtPackage.eINSTANCE.getBusinessProcessDiagram();
	}

	/**
	 * Create Process, Lane and Participant, initialize name
	 * 
	 * @generated NOT
	 */
	protected EObject doDefaultElementCreation() {
		Pool newElement = (Pool) super.doDefaultElementCreation();
		if (newElement != null) {

			Lane lane = VsdtFactory.eINSTANCE.createLane();
			lane.setName("Default Lane");
			lane.setBoundaryVisible(false);
			newElement.getLanes().add(lane);

			BpmnProcess process = VsdtFactory.eINSTANCE.createBpmnProcess();
			newElement.setProcess(process);

			newElement.initializeParticipant();

			newElement.setName("Pool");
		}
		return newElement;
	}
}
