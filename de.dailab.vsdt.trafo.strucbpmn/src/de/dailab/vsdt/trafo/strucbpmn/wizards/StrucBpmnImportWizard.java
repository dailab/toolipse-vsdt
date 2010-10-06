package de.dailab.vsdt.trafo.strucbpmn.wizards;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredSelection;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.impl.BpmnResultSaver;
import de.dailab.vsdt.trafo.strucbpmn.imprt.StrucBpmn2BpmnStructureMapping;
import de.dailab.vsdt.trafo.wizard.BpmnImportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnImportWizardOptionsPage;

public class StrucBpmnImportWizard extends BpmnImportWizard {

	@Override
	public String getTitle() {
		return "StrucBPMN to BPMN Import Wizard";
	}
	
	@Override
	protected void initializeMappingStages() {
		mappingStages = new ArrayList<MappingStage>();
		mappingStages.add(new StrucBpmn2BpmnStructureMapping());
		
		resultSaver= new BpmnResultSaver();
	}
	
	@Override
	protected BpmnImportWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new StrucBpmnImportWizardOptionsPage(title, selection);
	}
	
	@Override
	protected String getModelName(Object model) {
		if (model instanceof BusinessProcessDiagram) {
			return ((BusinessProcessDiagram) model).getNameOrId();
		}
		return super.getModelName(model);
	}
}
