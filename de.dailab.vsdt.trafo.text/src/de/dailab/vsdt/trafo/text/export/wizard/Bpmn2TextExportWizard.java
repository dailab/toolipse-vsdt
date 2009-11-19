package de.dailab.vsdt.trafo.text.export.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;

import de.dailab.vsdt.trafo.strucbpmn.export.Bpmn2StrucBpmnTransformation;
import de.dailab.vsdt.trafo.text.export.stages.Bpmn2TextElementMapping;
import de.dailab.vsdt.trafo.text.export.stages.TextResultSaver;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizardOptionsPage;

public class Bpmn2TextExportWizard extends BpmnExportWizard {

	@Override
	public String getTitle() {
		return "BPMN to Text Export Wizard";
	}

	@Override
	protected void initializeMappingStages() {
		mappingStages.add(new Bpmn2StrucBpmnTransformation());
		mappingStages.add(new Bpmn2TextElementMapping());
		
		resultSaver= new TextResultSaver();
	}
	

	@Override
	protected BpmnExportWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new Bpmn2TextExportWizardOptionsPage(title, selection);
	}
	
	@Override
	protected void applyOptions() {
		if (optionsPage instanceof Bpmn2TextExportWizardOptionsPage) {
			Bpmn2TextElementMapping.textFormat= ((Bpmn2TextExportWizardOptionsPage) optionsPage).getSelectedFormat();
		}
	}
}
