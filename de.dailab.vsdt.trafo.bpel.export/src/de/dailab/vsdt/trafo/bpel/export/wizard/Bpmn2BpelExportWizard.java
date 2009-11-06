package de.dailab.vsdt.trafo.bpel.export.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;

import de.dailab.vsdt.trafo.bpel.export.BpelStaticHelper;
import de.dailab.vsdt.trafo.bpel.export.stages.BpelResultSaver;
import de.dailab.vsdt.trafo.bpel.export.stages.Bpmn2BpelCleanUp;
import de.dailab.vsdt.trafo.bpel.export.stages.Bpmn2BpelElementMapping;
import de.dailab.vsdt.trafo.bpel.export.stages.Bpmn2BpelValidation;
import de.dailab.vsdt.trafo.strucbpmn.export.stages.Bpmn2StrucBpmnTransformation;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnTrafoWizardOptionsPage;

public class Bpmn2BpelExportWizard extends BpmnExportWizard {

	@Override
	public String getTitle() {
		return "BPMN to BPEL Export Wizard";
	}
	
	@Override
	protected void initializeMappingStages() {
		mappingStages.add(new Bpmn2BpelValidation());
		mappingStages.add(new Bpmn2StrucBpmnTransformation());
		mappingStages.add(new Bpmn2BpelElementMapping());
		mappingStages.add(new Bpmn2BpelCleanUp());
		
		resultSaver= new BpelResultSaver();
	}
	
	@Override
	protected BpmnTrafoWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new Bpmn2BpelExportWizardOptionsPage(title, selection);
	}
	
	@Override
	protected void applyOptions() {
		if (optionsPage instanceof Bpmn2BpelExportWizardOptionsPage) {
			Bpmn2BpelExportWizardOptionsPage specificOptPage = (Bpmn2BpelExportWizardOptionsPage) optionsPage;

			BpelStaticHelper.useSuffixes= specificOptPage.isUseSuffixes();
			Bpmn2BpelElementMapping.replaceVarNames= specificOptPage.isSubstitutePropertyGetters();
			Bpmn2BpelElementMapping.translateExpressions= specificOptPage.isTranslateExpressions();
		}
	}
}
