package de.dailab.vsdt.trafo.stp.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;

import de.dailab.vsdt.trafo.stp.export.Bpmn2StpBpmnElementMapping;
import de.dailab.vsdt.trafo.stp.export.StpBpmnResultSaver;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnTrafoWizardOptionsPage;

public class Bpmn2StpExportWizard extends BpmnExportWizard {

	@Override
	public String getTitle() {
		return "BPMN to STP BPMN Export Wizard";
	}
	
	@Override
	protected void initializeMappingStages() {
		mappingStages.add(new Bpmn2StpBpmnElementMapping());
		
		resultSaver= new StpBpmnResultSaver();
	}
	
	@Override
	protected BpmnTrafoWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new Bpmn2StpExportWizardOptionsPage(title, selection);
	}
	
	@Override
	protected void applyOptions() {
	}
}
