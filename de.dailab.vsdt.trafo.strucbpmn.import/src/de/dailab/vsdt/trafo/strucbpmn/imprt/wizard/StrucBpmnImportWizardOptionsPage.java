package de.dailab.vsdt.trafo.strucbpmn.imprt.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;

import de.dailab.vsdt.trafo.wizard.BpmnTrafoWizardOptionsPage;

public class StrucBpmnImportWizardOptionsPage extends BpmnTrafoWizardOptionsPage {
	
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
