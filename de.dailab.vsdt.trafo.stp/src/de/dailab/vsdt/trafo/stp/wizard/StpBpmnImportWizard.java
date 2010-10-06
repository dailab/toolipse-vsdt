package de.dailab.vsdt.trafo.stp.wizard;

import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.stp.bpmn.BpmnDiagram;

import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.impl.BpmnResultSaver;
import de.dailab.vsdt.trafo.stp.imprt.StpBpmn2BpmnElementMapping;
import de.dailab.vsdt.trafo.wizard.BpmnImportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnImportWizardOptionsPage;

public class StpBpmnImportWizard extends BpmnImportWizard {

	@Override
	public String getTitle() {
		return "STP BPMN to BPMN Import Wizard";
	}
	
	@Override
	protected void initializeMappingStages() {
		mappingStages = new ArrayList<MappingStage>();
		mappingStages.add(new StpBpmn2BpmnElementMapping());
		
		resultSaver= new BpmnResultSaver();
	}
	
	@Override
	protected BpmnImportWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new StpBpmnImportWizardOptionsPage(title, selection);
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
