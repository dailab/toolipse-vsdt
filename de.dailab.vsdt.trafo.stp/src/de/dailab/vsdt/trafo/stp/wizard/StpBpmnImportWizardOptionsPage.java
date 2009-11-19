package de.dailab.vsdt.trafo.stp.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;

import de.dailab.vsdt.trafo.wizard.BpmnImportWizardOptionsPage;

public class StpBpmnImportWizardOptionsPage extends BpmnImportWizardOptionsPage {
	
	public StpBpmnImportWizardOptionsPage(String pageName, 
			IStructuredSelection selection) {
		super(pageName, selection);
	}
	
	@Override
	public String getDescription() {
		return "Select the STP BPMN model file to be imported to BPMN";
	}
	
	@Override
	public String getExtension() {
		return "bpmn";
	}
	
}
