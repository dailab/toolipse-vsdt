package de.dailab.vsdt.trafo.strucbpmn.export.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;

import de.dailab.vsdt.trafo.impl.DefaultBpmnValidation;
import de.dailab.vsdt.trafo.strucbpmn.export.stages.Bpmn2StrucBpmnTransformation;
import de.dailab.vsdt.trafo.strucbpmn.export.stages.StrucBpmnResultSaver;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizardOptionsPage;
import de.dailab.vsdt.trafo.wizard.BpmnTrafoWizardOptionsPage;

public class StrucBpmnExportWizard extends BpmnExportWizard {

	@Override
	public String getTitle() {
		return "BPMN to StrucBPMN Export Wizard";
	}
	
	@Override
	protected void initializeMappingStages() {
		mappingStages.add(new DefaultBpmnValidation());
		mappingStages.add(new Bpmn2StrucBpmnTransformation());
		
		resultSaver= new StrucBpmnResultSaver();
	}
	
	@Override
	protected BpmnTrafoWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new BpmnExportWizardOptionsPage(title, selection);
	}
	
	@Override
	protected void applyOptions() {
	}
}
