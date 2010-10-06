package de.dailab.vsdt.trafo.jiaciv.wizard;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredSelection;

import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.jiaciv.export.Bpmn2JiacElementMapping;
import de.dailab.vsdt.trafo.jiaciv.export.Bpmn2JiacValidation;
import de.dailab.vsdt.trafo.jiaciv.export.JiacResultSaver;
import de.dailab.vsdt.trafo.strucbpmn.export.Bpmn2StrucBpmnTransformation;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizardOptionsPage;

public class Bpmn2JiacExportWizard extends BpmnExportWizard {

	@Override
	public String getTitle() {
		return "BPMN to JIAC IV Export Wizard";
	}
	
	@Override
	protected void initializeMappingStages() {
		mappingStages = new ArrayList<MappingStage>();
		mappingStages.add(new Bpmn2JiacValidation());
		mappingStages.add(new Bpmn2StrucBpmnTransformation());
		mappingStages.add(new Bpmn2JiacElementMapping());
		
		resultSaver= new JiacResultSaver();
	}
	
	@Override
	protected void applyOptions() {
	}

	@Override
	protected BpmnExportWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new BpmnExportWizardOptionsPage(title, selection);
	}

}
