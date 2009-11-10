package de.dailab.vsdt.trafo.jiaciv.export.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;

import de.dailab.vsdt.trafo.jiaciv.export.stages.Bpmn2JiacElementMapping;
import de.dailab.vsdt.trafo.jiaciv.export.stages.Bpmn2JiacValidation;
import de.dailab.vsdt.trafo.jiaciv.export.stages.JiacResultSaver;
import de.dailab.vsdt.trafo.strucbpmn.export.Bpmn2StrucBpmnTransformation;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizardOptionsPage;
import de.dailab.vsdt.trafo.wizard.BpmnTrafoWizardOptionsPage;

public class Bpmn2JiacExportWizard extends BpmnExportWizard {

	@Override
	public String getTitle() {
		return "BPMN to JIAC IV Export Wizard";
	}
	
	@Override
	protected void initializeMappingStages() {
		mappingStages.add(new Bpmn2JiacValidation());
		mappingStages.add(new Bpmn2StrucBpmnTransformation());
		mappingStages.add(new Bpmn2JiacElementMapping());
		
		resultSaver= new JiacResultSaver();
	}
	
	@Override
	protected void applyOptions() {
	}

	@Override
	protected BpmnTrafoWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new BpmnExportWizardOptionsPage(title, selection);
	}

}
