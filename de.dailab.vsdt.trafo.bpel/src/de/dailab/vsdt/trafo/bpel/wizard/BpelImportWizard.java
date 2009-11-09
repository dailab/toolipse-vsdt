package de.dailab.vsdt.trafo.bpel.wizard;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot;
import org.xmlsoap.schemas.ws._2003._03.business.process.util.ProcessResourceFactoryImpl;

import de.dailab.vsdt.trafo.bpel.imprt.Bpel2BpmnElementMapping;
import de.dailab.vsdt.trafo.impl.BpmnResultSaver;
import de.dailab.vsdt.trafo.strucbpmn.imprt.StrucBpmn2BpmnStructureMapping;
import de.dailab.vsdt.trafo.wizard.BpmnImportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnTrafoWizardOptionsPage;

public class BpelImportWizard extends BpmnImportWizard {

	private Bpel2BpmnElementMapping elementMapping;
	
	@Override
	public String getTitle() {
		return "BPEL to BPMN Import Wizard";
	}
	
	@Override
	protected void initializeMappingStages() {
		mappingStages.add(elementMapping= new Bpel2BpmnElementMapping());
		mappingStages.add(new StrucBpmn2BpmnStructureMapping());
		
		resultSaver= new BpmnResultSaver();
	}
	
	@Override
	protected BpmnTrafoWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new BpelImportWizardOptionsPage(title, selection);
	}
	
	@Override
	protected void applyOptions() {
		if (optionsPage instanceof BpelImportWizardOptionsPage) {
			BpelImportWizardOptionsPage page= (BpelImportWizardOptionsPage) optionsPage;
			elementMapping.setIgnoreEmpty(page.isIgnoreEmpty());
		}
	}
	
	@Override
	protected String getModelName(Object model) {
		if (model instanceof DocumentRoot) {
			String name= ((DocumentRoot) model).getProcess().getName();
			if (name != null && name.length() > 0) {
				return name;
			}
		}
		return super.getModelName(model);
	}
	
	@Override
	protected Object getSouceObject(URI fileURI) {

		ResourceSet resourceSet= new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("bpel", new ProcessResourceFactoryImpl());
		
		Resource resource= resourceSet.createResource(fileURI);
		try {
			resource.load(null);

			EObject source= resource.getContents().get(0);
			EcoreUtil.resolveAll(source);
			
			return source;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
