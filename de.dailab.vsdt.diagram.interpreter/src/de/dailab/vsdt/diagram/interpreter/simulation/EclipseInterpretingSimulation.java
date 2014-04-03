package de.dailab.vsdt.diagram.interpreter.simulation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.dailab.vsdt.Property;
import de.dailab.vsdt.diagram.dialogs.EditExpressionDialog;
import de.dailab.vsdt.diagram.interpreter.dialogs.MessageParameterDialog;
import de.dailab.vsdt.interpreter.AbstractInterpretingSimulation;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * This Simulation requires fewer interaction with the user than the Manual
 * Simulation, as it keeps track of the Property value, evaluating the several
 * expression in Assignments, Loops and branching conditions.
 * 
 * Note: This works only for expressions using the VSDT Expression Language (VXL)
 * 
 * @author kuester
 */
public class EclipseInterpretingSimulation extends AbstractInterpretingSimulation {

	@Override
	public String getName() {
		return "Interpreting Simulation";
	}
	
	/**
	 * Opens an EditExpressionDialog for editing the given property's value in 
	 * the context of this Simulation.  If the dialog is finished with 'ok', the
	 * new value is written into the {@link #propertyValueMap}.
	 *   
	 * @see EditExpressionDialog
	 * @param property		Some Property in this Simulation
	 */
	public void openEditPropertyDialog(Property property) {
		Object value= getPropertyValue(property);
		String expression= value instanceof String ? "\"" + value + "\"" : String.valueOf(value);

		List<Property> properties= VsdtHelper.getVisibleProperties(property.eContainer());
		
		Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		EditExpressionDialog dialog= new EditExpressionDialog(shell, expression, true);
		dialog.setProperties(properties);
		
		if (dialog.open() == EditExpressionDialog.OK) {
			String newExpression= dialog.getExpression();
			Map<String, Serializable> context= createContext(property.eContainer());
			Serializable newValue= evaluateTerm(parseExpression(newExpression), context);
			setPropertyValue(property, newValue);
		}
	}

	/**
	 * Open a MessageParameterDialog for editing the given FlowObject's incoming 
	 * or outgoing Message's Properties' values in the course of this simulation.
	 * If the dialog is finished with 'ok', the new value is written into the
	 * {@link #propertyValueMap}.
	 * 
	 * Note: Here, "Incoming" means the Message incoming to the Flow Object, 
	 * not the Input Message of the Service.
	 * 
	 * @param flowObject	Some FlowObject in this Simulation with Messages
	 * @param incoming		Select Incoming or Outgoing message?
	 */
	public void handleMessageProperties(List<Property> properties, boolean incoming) {
		if (properties != null) {
			Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			Map<Property, Object> valueMap= new HashMap<Property, Object>();
			for (Property property : properties) {
				valueMap.put(property, propertyValueMap.get(property));
			}
			MessageParameterDialog dialog= new MessageParameterDialog(shell, properties, incoming, propertyValueMap);
			if (dialog.open() == Dialog.OK) {
				for (Property property : properties) {
					setPropertyValue(property, dialog.getNewPropertyValue(property));
				}
			}
		}
	}

}
