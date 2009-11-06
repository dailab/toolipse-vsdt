package de.dailab.vsdt.trafo.stp.imprt.wizard;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.stp.bpmn.BpmnDiagram;
import org.eclipse.stp.bpmn.util.BpmnResourceFactoryImpl;

import de.dailab.vsdt.trafo.impl.BpmnResultSaver;
import de.dailab.vsdt.trafo.stp.imprt.stages.StpBpmn2BpmnElementMapping;
import de.dailab.vsdt.trafo.wizard.BpmnImportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnTrafoWizardOptionsPage;

public class StpBpmnImportWizard extends BpmnImportWizard {

	@Override
	public String getTitle() {
		return "STP BPMN to BPMN Import Wizard";
	}
	
	@Override
	protected void initializeMappingStages() {
		mappingStages.add(new StpBpmn2BpmnElementMapping());
		
		resultSaver= new BpmnResultSaver();
		// not needed anymore, as VSDT files now have the extension '.vsdt'
//		((BpmnResultSaver) resultSaver).setSuffix("_vsdt");
	}
	
	@Override
	protected BpmnTrafoWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new StpBpmnImportWizardOptionsPage(title, selection);
	}
	
	@Override
	protected void applyOptions() {
	}
	
	@Override
	protected String getModelName(Object model) {
		if (model instanceof BpmnDiagram) {
			String name= ((BpmnDiagram) model).getName();
			if (name != null && name.length() > 0) {
				return name;
			}
		}
		return super.getModelName(model);
	}
	
	@Override
	protected Object getSouceObject(URI fileURI) {
		// TODO Auto-generated method stub
//		
//		ResourceSet resourceSet = new ResourceSetImpl();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("bpmn", new BpmnResourceFactoryImpl());
//		
//		Resource resource= resourceSet.createResource(fileURI);
////		Resource resource = resourceSet.getResource(fileURI, true);
//		try {
//			resource.load(null);
//
//			EObject source= resource.getContents().get(0);
//			EcoreUtil.resolveAll(source);
//			
//			return source;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
		return super.getSouceObject(fileURI);
	}

}
