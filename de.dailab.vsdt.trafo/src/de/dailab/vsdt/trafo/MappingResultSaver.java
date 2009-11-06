package de.dailab.vsdt.trafo;

import java.io.File;
import java.io.IOException;

import de.dailab.vsdt.trafo.base.logger.TrafoLog;

/**
 * This class is used to provide a target language specific save method for the results
 * of the transformation. Actually, the behaviour of this class could also be realised
 * as an additional BpmnMappingStage object, but this way the method names are clearer.
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
	 * Saves the target models from the wrapper object to the directory given in the path field.
	 * Additionally, this method will provide some checks and logging stuff.
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

}
