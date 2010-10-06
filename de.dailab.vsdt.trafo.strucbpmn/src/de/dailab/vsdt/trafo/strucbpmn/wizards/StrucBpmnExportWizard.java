package de.dailab.vsdt.trafo.strucbpmn.wizards;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredSelection;

import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.impl.DefaultBpmnValidation;
import de.dailab.vsdt.trafo.strucbpmn.export.Bpmn2StrucBpmnTransformation;
import de.dailab.vsdt.trafo.strucbpmn.export.StrucBpmnResultSaver;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizardOptionsPage;

public class StrucBpmnExportWizard extends BpmnExportWizard {

	@Override
	public String getTitle() {
		return "BPMN to StrucBPMN Export Wizard";
	}
	
	@Override
	protected void initializeMappingStages() {
		mappingStages = new ArrayList<MappingStage>();
		mappingStages.add(new DefaultBpmnValidation());
		mappingStages.add(new Bpmn2StrucBpmnTransformation());
		
		resultSaver= new StrucBpmnResultSaver();
	}
	
	@Override
	protected BpmnExportWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new BpmnExportWizardOptionsPage(title, selection);
	}
	
	@Override
	protected void applyOptions() {
	}
}
