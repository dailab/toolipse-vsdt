package de.dailab.vsdt.trafo.wizard;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
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

	/**
	 * vsdtd files now contain both the model and the diagram. return the model.
	 */
	@Override
	public Object getSouceObject(URI fileURI) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(fileURI, true);
		for (EObject content : resource.getContents()) {
			if (content instanceof BusinessProcessSystem) {
				EcoreUtil.resolveAll(content);
				return content;
			}
		}
		return null;
	}
	
	protected abstract BpmnExportWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection);
}
