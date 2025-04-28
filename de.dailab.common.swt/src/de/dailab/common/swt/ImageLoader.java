package de.dailab.common.swt;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

public class ImageLoader {

	private static ImageLoader instance;
	
	private Map<ImageDescriptor, Image> imageCache= new HashMap<ImageDescriptor, Image>();

	private ImageLoader() {
	}
	
	public static ImageLoader getInstance() {
		if (instance == null) {
			instance= new ImageLoader();
		}
		return instance;
	}
	
	public Image getImage(ImageDescriptor descriptor) {
		if (descriptor == null) {
			return null;
		}
		//obtain the cached image corresponding to the descriptor
	   Image image = (Image)imageCache.get(descriptor);
	   if (image == null) {
	       image = descriptor.createImage();
	       imageCache.put(descriptor, image);
	   }
	   return image;
	}

}
