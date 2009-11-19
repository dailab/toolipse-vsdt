package de.dailab.vsdt.trafo.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IImportWizard;

import de.dailab.vsdt.trafo.impl.BpmnResultSaver;

public abstract class BpmnImportWizard extends BpmnTrafoWizard implements IImportWizard {

	protected abstract BpmnImportWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection);
	
	@Override
	protected void applyOptions() {
		if (optionsPage instanceof BpmnImportWizardOptionsPage) {
			BpmnImportWizardOptionsPage specificOptPage = (BpmnImportWizardOptionsPage) optionsPage;
			BpmnResultSaver.createDiagramFile= specificOptPage.isCreateDiagramFile();
			BpmnResultSaver.createModelFile= ! specificOptPage.isCreateDiagramFile();
		}
	}
}
