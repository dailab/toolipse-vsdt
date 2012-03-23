package de.dailab.vsdt.diagram.clipboard;

import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.clipboard.core.ObjectInfo;
import org.eclipse.gmf.runtime.emf.clipboard.core.OverridePasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PostPasteChildOperation;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.IdObject;

public class VsdtPositionalGeneralViewPasteOperation extends OverridePasteChildOperation {

    private boolean shouldPasteAlwaysCopyObject;

    public VsdtPositionalGeneralViewPasteOperation(
            PasteChildOperation overriddenChildPasteOperation,
            boolean shouldPasteAlwaysCopyObject) {
        super(overriddenChildPasteOperation);
        this.shouldPasteAlwaysCopyObject = shouldPasteAlwaysCopyObject;
    }

    public void paste() throws Exception {
        // delay unsetting of connector refs
    }

    protected boolean shouldPasteAlwaysCopyObject( ObjectInfo alwaysCopyObjectInfo) {
        return shouldPasteAlwaysCopyObject;
    }

    @Override
    public PasteChildOperation getPostPasteOperation() {
        return new MyPostPasteChildOperation(this, EMPTY_ARRAY);
    }
    
    

    
    class MyPostPasteChildOperation extends PostPasteChildOperation {

    	public MyPostPasteChildOperation(PasteChildOperation pasteChildOperation, PasteChildOperation[] pasteOperations) {
    		super(pasteChildOperation, pasteOperations);
		}
    	
    	@Override
        public void paste() throws Exception {
            Node view = (Node) getEObject();
            EObject pasted = view.getElement();
            if (pasted instanceof IdObject) {
                ((IdObject) pasted).setId(EcoreUtil.generateUUID());
            }
            if (pasted instanceof EObject) {
                TreeIterator<EObject> iter = ((EObject) pasted).eAllContents();
                while (iter.hasNext()) {
                    EObject next = iter.next();
                    if (next instanceof IdObject) {
                    	IdObject elt = (IdObject) next;
                        elt.setId(EcoreUtil.generateUUID());
                    }
                }
            }
            //now paste view
            EObject pastedElement = doPasteInto(getParentEObject());
            //did we succeed?
            if (pastedElement != null) {
                setPastedElement(pastedElement);
                addPastedElement(pastedElement);
            } else {
                addPasteFailuresObject(getEObject());
            }
        }

    	@Override
        protected boolean shouldPasteAlwaysCopyObject(ObjectInfo alwaysCopyObjectInfo) {
            return VsdtPositionalGeneralViewPasteOperation.this.shouldPasteAlwaysCopyObject(alwaysCopyObjectInfo);
        }

    	@SuppressWarnings("restriction")
    	@Override
        protected PasteChildOperation makeAuxiliaryChildPasteProcess(ObjectInfo auxiliaryChildEObjectInfo) {             
            EObject semanticPasteTarget = getSemanticPasteTarget((View) getPastedElement());
            if (semanticPasteTarget == null) {
                return null;
            }
            return new PasteChildOperation(getParentPasteProcess().clone(semanticPasteTarget), auxiliaryChildEObjectInfo);
        }

    	@Override
        public PasteChildOperation getPostPasteOperation() {
            List<?> operations = getAlwaysCopyObjectPasteOperations();
            return new PostPasteChildOperation(this, operations);
        }

    	private EObject getSemanticPasteTarget(View view) {
    		return ((View) view.eContainer()).getElement();
    	}
    }

}