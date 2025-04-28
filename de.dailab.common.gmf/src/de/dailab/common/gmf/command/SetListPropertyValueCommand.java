package de.dailab.common.gmf.command;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

/**
 * This Command is good to append items to a list feature of a given model
 * element. At this, null-list are not supported. You have to make sure that
 * the given list is initialized. Otherwise an exception is thrown
 * 
 * @author luetze
 */
public class SetListPropertyValueCommand extends AbstractGmfCommand {

	/** feature to set */
	private EStructuralFeature feature;
	
	/** value to assign to the feature (may be null) */
	private Object value;
	
	/** remove value from list? */
	private boolean remove = false;
	
	
	/**
	 * Constructor of this command. 
	 * 
	 * @param 	modelElement	The model element which contains the list which is about to
	 * 							be extended.
	 * @param 	feature			The feature which represents the list.
	 * @param 	value			The value by which the given list is to be extended.
	 * @param	remove			remove value from list?
	 */
	public SetListPropertyValueCommand(EObject modelElement, EStructuralFeature feature, Object value, boolean remove) {
		super(modelElement, "Set " + feature.getName());
		
		this.feature= feature;
		this.value= value;
		this.remove = remove;

		if (!feature.isMany()) {
			throw new IllegalArgumentException("The Feature has to be of a List type");
		}
		if (! modelElement.eClass().getEAllStructuralFeatures().contains(feature)) {
			throw new IllegalArgumentException("Feature must be a Feature of the EObject");
		}
		if (modelElement.eGet(feature) == null) {
			throw new IllegalArgumentException("Uninitialised lists are not supported");
		}
		if (value != null && ! feature.getEType().isInstance(value)) {
			throw new IllegalArgumentException("Value must be an instance of the Type of Feature, or null");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		try {
			List<Object> list = (List<Object>) modelElement.eGet(feature);
			if (list == null) {
				list = new BasicEList<Object>();
			}
			if (value != null) {
				if (remove) {
					list.remove(value);
				} else {
					list.add(value);
				}
			} else
				list.clear();
			return CommandResult.newOKCommandResult();
		} catch (Exception e) {
			return CommandResult.newErrorCommandResult(e);
		}
	}
}
