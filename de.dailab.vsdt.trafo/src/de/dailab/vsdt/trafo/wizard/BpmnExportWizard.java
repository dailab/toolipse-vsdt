package de.dailab.vsdt.trafo.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;

import de.dailab.vsdt.BusinessProcessSystem;


public abstract class BpmnExportWizard extends BpmnTrafoWizard implements IExportWizard {
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		/*
		 * TODO improve auto-selection of model file, filters, etc.
		 */
//		if (selection.getFirstElement() instanceof IGraphicalEditPart) {
//			EObject object= ((View) ((IGraphicalEditPart) selection.getFirstElement()).getModel()).getElement();
//			Resource resource= (XMIResource) object.eResource();
//			URI uri= resource.getResourceSet().getURIConverter().normalize(resource.getURI());
//			String[] segments= new String[uri.segmentCount() - 1];
//			for (int i=0; i<uri.segmentCount()-1; i++) {
//				segments[i]= uri.segment(i+1);
//			}
//			TreePath path= new TreePath(segments);
//			int i= 0;
//		}
//		if (selection instanceof StructuredSelection) {
//			StructuredSelection strucSelection = (StructuredSelection) selection;
////			Object[] o= new Object[2];
////			new TreePath(o);
////			new TreeSelection();
//			this.selection= selection;
//		}
	}
	
	@Override
	protected String getModelName(Object model) {
		if (model instanceof BusinessProcessSystem) {
			return ((BusinessProcessSystem) model).getNameOrId();
		}
		return super.getModelName(model);
	}

	
}
