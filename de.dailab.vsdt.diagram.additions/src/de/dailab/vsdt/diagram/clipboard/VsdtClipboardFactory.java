package de.dailab.vsdt.diagram.clipboard;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupport;
import org.eclipse.gmf.runtime.emf.clipboard.core.IClipboardSupportFactory;

/**
 * Factory for creating a specialized clip-board support for this editor.
 * However, copy-paste still does not work, so these classes are left 
 * just in case we are trying to fix is later again.
 * 
 * @author kuester
 */
public class VsdtClipboardFactory implements IClipboardSupportFactory {

    public IClipboardSupport newClipboardSupport(EPackage package1) {
    	return new VsdtClipboardSupport();
//    	return DefaultClipboardSupport.getInstance(); 
    }
    
}
