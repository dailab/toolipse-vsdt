package de.dailab.common.swt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * Utility class providing various EMF helper methods, e.g. for loading EMF
 * resources.
 * 
 * @author kuester
 */
public class EmfUtils {
	
	/**
	 * Generic method for loading stuff form EMF resource
	 * 
	 * @param <T>			class of the model to load
	 * @param clazz			class of the model to load
	 * @param pkg			EMF Package instance
	 * @param fileName		path to EMF resource
	 * @return				model from resource
	 */
	@SuppressWarnings("unchecked")
	public static <T> T loadFromResource(Class<T> clazz, EPackage pkg, String fileName) {
		// create resource set
		ResourceSet resourceSet = new ResourceSetImpl();
	    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
	        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	    resourceSet.getPackageRegistry().put(pkg.getNsURI(), pkg);

	    // load resource
	    Resource resource = resourceSet.createResource(URI.createURI(fileName));
		try {
			InputStream is = new FileInputStream(new File(fileName));
			resource.load(is, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (clazz.isInstance(resource.getContents().get(0))) {
			return (T) resource.getContents().get(0);
		}
		return null;
	}
	
}
