package de.dailab.vsdt.trafo.jiacbeans.wizard;

import java.util.ArrayList;

import org.eclipse.jface.viewers.IStructuredSelection;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.MappingWrapper;
import de.dailab.vsdt.trafo.jiacbeans.export.Bpmn2JiacBeansElementMapping;
import de.dailab.vsdt.trafo.jiacbeans.export.Bpmn2JiacBeansValidation;
import de.dailab.vsdt.trafo.jiacbeans.export.JiacBeansExportWrapper;
import de.dailab.vsdt.trafo.jiacbeans.export.JiacBeansResultSaver;
import de.dailab.vsdt.trafo.strucbpmn.export.Bpmn2StrucBpmnTransformation;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizard;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizardOptionsPage;

public class Bpmn2JiacBeansExportWizard extends BpmnExportWizard {
	
	@Override
	public String getTitle() {
		return "BPMN to JIAC V AgentBeans Export Wizard";
	}

	@Override
	protected void initializeMappingStages() {
		mappingStages = new ArrayList<MappingStage>();
		mappingStages.add(new Bpmn2JiacBeansValidation());
		mappingStages.add(new Bpmn2StrucBpmnTransformation());
		mappingStages.add(new Bpmn2JiacBeansElementMapping());
		
		resultSaver= new JiacBeansResultSaver();
	}
	
	@Override
	protected MappingWrapper createMappingWrapper(Object source) {
		if (source instanceof BusinessProcessSystem) {
			return new JiacBeansExportWrapper((BusinessProcessSystem) source);
		} else {
			throw new IllegalArgumentException("Source must be of type BusinessProcessSystem");
		}
	}

	@Override
	protected BpmnExportWizardOptionsPage createOptionsPage(String title,
			IStructuredSelection selection) {
		return new BpmnExportWizardOptionsPage(title, selection);
	}
	
	@Override
	protected void applyOptions() {
	}
	
}
