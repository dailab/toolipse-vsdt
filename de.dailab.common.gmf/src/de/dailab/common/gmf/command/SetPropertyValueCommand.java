package de.dailab.common.gmf.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

/**
 * This command can be used to set some feature of a given EObject to a given value.
 * The Feature to set has to be passed as a EStructuralFeature. Of course, the feature
 * has to be a feature of that EObject and the value has to match the feature's type.
 * 
 * @author kuester
 */
public class SetPropertyValueCommand extends AbstractGmfCommand {

	/** feature to set */
	private EStructuralFeature feature;
	
	/** value to assign to the feature (may be null) */
	private Object value;
	
	/**
	 * Create new SetPropertyValueCommand
	 * 
	 * @param modelElement		The model element owning the feature
	 * @param feature			The feature to set
	 * @param value				The value to assign to the feature
	 */
	public SetPropertyValueCommand(EObject modelElement, EStructuralFeature feature, Object value) {
		super(modelElement, "Set " + feature.getName());
		this.feature= feature;
		this.value= value;

		if (! modelElement.eClass().getEAllStructuralFeatures().contains(feature)) {
			throw new IllegalArgumentException("Feature must be a Feature of the EObject");
		}
		if (value != null && ! feature.getEType().isInstance(value)) {
			throw new IllegalArgumentException("Value must be an instance of the Type of Feature, or null");
		}
	}
	
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		try {
			modelElement.eSet(feature, value);
			return CommandResult.newOKCommandResult();
		} catch (Exception e) {
			return CommandResult.newErrorCommandResult(e);
		}
	}
		
}
