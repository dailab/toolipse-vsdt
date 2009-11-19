package de.dailab.vsdt.trafo.strucbpmn.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;

import de.dailab.vsdt.trafo.wizard.BpmnImportWizardOptionsPage;

public class StrucBpmnImportWizardOptionsPage extends BpmnImportWizardOptionsPage {
	
	public StrucBpmnImportWizardOptionsPage(String pageName, 
			IStructuredSelection selection) {
		super(pageName, selection);
	}
	
	@Override
	public String getDescription() {
		return "Select the StrucBPMN model file to be imported to BPMN";
	}
	
	@Override
	public String getExtension() {
		return "strucbpmn";
	}

}
