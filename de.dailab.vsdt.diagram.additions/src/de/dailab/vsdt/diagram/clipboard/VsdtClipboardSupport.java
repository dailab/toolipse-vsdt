package de.dailab.vsdt.diagram.clipboard;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.emf.clipboard.core.OverridePasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteChildOperation;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;

/**
 * This is the minimal configuration for a clip-board support 
 * that worked (with some mistakes, but it worked) in the STP-BPMN-editor.
 * Here, however, it does not yet work.
 * 
 * TODO try again later
 * 
 * @author kuester
 */
public class VsdtClipboardSupport extends org.eclipse.gmf.runtime.emf.clipboard.core.AbstractClipboardSupport {

	/*
	 * without both these changes, the node's copy will refer to the original element
	 */
	
    public boolean isCopyAlways(EObject context, EReference eReference, Object value) {
    	// without this, only node and annotation will be copied, and 
    	// node will refer to the original activity
        if (eReference.equals(NotationPackage.eINSTANCE.getView_Element())) {
//            return true;
        }
        return super.isCopyAlways(context, eReference, value);
    }

    public boolean shouldOverrideChildPasteOperation(EObject parentElement, EObject childEObject) {
    	// without this, the reference to the copy of the element will 
    	// be overwritten with a reference to the original element 
    	if (childEObject.eClass().getEPackage() == NotationPackage.eINSTANCE) {
    		return true;
    	}
        return false;
    }

    public OverridePasteChildOperation getOverrideChildPasteOperation(PasteChildOperation overriddenChildPasteOperation) {
        EObject eObject = overriddenChildPasteOperation.getEObject();
        if (eObject instanceof Node) {
            return new VsdtPositionalGeneralViewPasteOperation(
            		overriddenChildPasteOperation,
            		((Node) eObject).getElement() != null);
        }
        return null;
    }
    
}
