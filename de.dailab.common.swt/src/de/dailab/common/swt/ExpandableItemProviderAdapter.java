package de.dailab.common.swt;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

/**
 * this class is providing wrappers for all property descriptors for EObjects,
 * e.g. for the attribute sets, expressions, etc.. The benefit of extending this class
 * is that the properties view will not be a list, but a tree, so properties which 
 * are EObjects again an be expanded.
 * 
 * @author tkuester
 */
public class ExpandableItemProviderAdapter extends ItemProviderAdapter {
	
	/**
	 * default constructor
	 * @param adapterFactory
	 */
	public ExpandableItemProviderAdapter(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	/**
	 * create new item property descriptor.
	 * this method is used throughout the generated item providers for creating the item descriptors
	 * it is extended with overriding the item descriptor's createPropertyValueWrapper method,
	 * wrapping all EObjects
	 */
	@Override
	protected ItemPropertyDescriptor createItemPropertyDescriptor(
			AdapterFactory adapterFactory, 
			ResourceLocator resourceLocator, 
			String displayName, 
			String description, 
			EStructuralFeature feature, 
			boolean isSettable,
			boolean multiLine, 
			boolean sortChoices, 
			Object staticImage, 
			String category,
			String[] filterFlags) {
		
		return new ItemPropertyDescriptor(
				adapterFactory,
				resourceLocator,
				displayName,
				description,
				feature,
				isSettable,
				multiLine,
				sortChoices,
				staticImage,
				category,
				filterFlags) {
			
			@Override
			protected Object createPropertyValueWrapper(Object object, Object propertyValue) {
				if (propertyValue instanceof EObject) {
					return new PropertyValueWrapper(adapterFactory, object, propertyValue, propertyValue);
				}
				return super.createPropertyValueWrapper(object, propertyValue);
			}
			
		};
	}

}
