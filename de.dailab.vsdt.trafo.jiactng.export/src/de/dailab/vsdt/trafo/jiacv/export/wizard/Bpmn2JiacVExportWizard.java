package de.dailab.vsdt.trafo.jiacv.export.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.trafo.MappingWrapper;
import de.dailab.vsdt.trafo.jiacv.export.stages.Bpmn2JiacVCleanUp;
import de.dailab.vsdt.trafo.jiacv.export.stages.Bpmn2JiacVElementMapping;
import de.dailab.vsdt.trafo.jiacv.export.stages.Bpmn2JiacVValidation;
import de.dailab.vsdt.trafo.jiacv.export.stages.JiacVExportWrapper;
import de.dailab.vsdt.trafo.jiacv.export.stages.JiacVResultSaver;
import de.dailab.vsdt.trafo.strucbpmn.export.stages.Bpmn2StrucBpmnTransformation;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnTrafoWizardOptionsPage;

public class Bpmn2JiacVExportWizard extends BpmnExportWizard {

	@Override
	public String getTitle() {
		return "BPMN to JIAC V Export Wizard";
	}

	@Override
	protected void initializeMappingStages() {
		mappingStages.add(new Bpmn2JiacVValidation());
		mappingStages.add(new Bpmn2StrucBpmnTransformation());
		mappingStages.add(new Bpmn2JiacVElementMapping());
		mappingStages.add(new Bpmn2JiacVCleanUp());
		
		resultSaver= new JiacVResultSaver();
	}
	
	@Override
	protected MappingWrapper createMappingWrapper(Object source) {
		if (source instanceof BusinessProcessSystem) {
			return new JiacVExportWrapper((BusinessProcessSystem) source);
		} else {
			throw new IllegalArgumentException("Source must be of type BusinessProcessSystem");
		}
	}

	@Override
	protected BpmnTrafoWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new Bpmn2JiacVExportWizardOptionsPage(title, selection);
	}
	
	@Override
	protected void applyOptions() {
		if (optionsPage instanceof Bpmn2JiacVExportWizardOptionsPage) {
			Bpmn2JiacVExportWizardOptionsPage specificOptPage = (Bpmn2JiacVExportWizardOptionsPage) optionsPage;
			Bpmn2JiacVElementMapping.useMAMSspecials= specificOptPage.isUseMAMSSpecials();
			JiacVResultSaver.groupByUsecase= specificOptPage.isGroupByUsecase();
//			Bpmn2JadlElementMapping.oneFilePerPool= specificOptPage.isOneFileForAll();
		}
	}
}
