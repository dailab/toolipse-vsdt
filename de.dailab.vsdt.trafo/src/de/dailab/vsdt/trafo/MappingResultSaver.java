package de.dailab.vsdt.trafo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import de.dailab.vsdt.trafo.base.util.TrafoLog;

/**
 * This class is used to provide a target language specific save method for the 
 * results of the transformation. Actually, the behavior of this class could 
 * also be realized as an additional BpmnMappingStage object, but this way the 
 * method names are clearer.
 * 
 * @author kuester
 */
public abstract class MappingResultSaver {

	public static final String FILE_SEP= System.getProperty("file.separator");
	
	/**The wrapper, holding the source and target models*/
	protected MappingWrapper wrapper;
	
	/**Directory where to save the several files*/
	private File directory;
	
	/**
	 * @param wrapper	The wrapper object resulting from the transformation
	 */
	public void setWrapper(MappingWrapper wrapper) {
		this.wrapper = wrapper;
	}
	
	/**
	 * @param path	Absolute path where to save the several files
	 */
	public void setDirectory(File directory) {
		this.directory= directory;
	}
	
	/**
	 * Saves the target models from the wrapper object to the directory given in
	 * the path field. Additionally, this method will provide some checks and 
	 * logging stuff.
	 * 
	 * @return	saving successful?
	 */
	public final boolean save() {
		if (directory == null) {
			TrafoLog.error("No directory specified for saving the result");
			return false;
		}
		boolean ok= false;
		try {
			if (! directory.exists()) {
				directory.mkdirs();
			}
			ok= internalSave(directory);
		} catch (IOException e) {
			TrafoLog.error(e.getMessage());
		}
		if (ok) {
			TrafoLog.info("Results saved in " + directory.getAbsolutePath());
			return true;	
		} else {
			return false;
		}
	}
	
	/**
	 * @see save()
	 */
	protected abstract boolean internalSave(File baseDirectory) throws IOException;

	
	/**
	 * Save the given EObject using the default XML Resource.
	 * 
	 * @param file				File where to save the EObject
	 * @param eObject			the EObject to save
	 * @param options			save options (optional)
	 * @param resourceFactory	ResourceFactory (optional)
	 * @throws IOException
	 */
	protected void saveAsXmlResource(File file, EObject eObject, Map options, Factory resourceFactory) throws IOException {
		URI uri= URI.createFileURI(file.getAbsolutePath());
		Resource res= resourceFactory != null
				? resourceFactory.createResource(uri)
				: new XMLResourceImpl(uri);
		res.getContents().add(eObject);
		res.save(options);
	}
	
}
