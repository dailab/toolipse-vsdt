package de.dailab.vsdt.trafo.text.export.stages;

import java.util.HashMap;
import java.util.Map;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.trafo.impl.BpmnExportWrapper;

/**
 * Additionally to the basic export wrapper, this one also provides a Map
 * for storing image data together with the paths where to store the images.
 * 
 * @author kuester
 */
public class TextExportWrapper extends BpmnExportWrapper {

	/** Map holding generated images together with the intended file names */
	private final Map<String, byte[]> imageMap;
	
	public TextExportWrapper(BusinessProcessSystem bps) {
		super(bps);
		imageMap= new HashMap<String, byte[]>();
	}

	/**
	 * Add another image to the image map
	 * 
	 * @param fileName		name under which the image shall be saved
	 * @param imageData		image data
	 */
	public void addImage(String label, byte[] imageData) {
		imageMap.put(label, imageData);
	}
	
	/**
	 * @return		the images together with their intended file names
	 */
	public Map<String, byte[]> getImageMap() {
		return imageMap;
	}

}
