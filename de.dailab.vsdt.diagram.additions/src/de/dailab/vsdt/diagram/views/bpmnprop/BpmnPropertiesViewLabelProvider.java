package de.dailab.vsdt.diagram.views.bpmnprop;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.diagram.providers.VsdtAdditionsPlugin;

/**
 * This class is used to provide the Labels used in the BPMN Properties View
 * 
 * @author kuester
 */
public class BpmnPropertiesViewLabelProvider extends LabelProvider implements ITableLabelProvider {
	
	public String getColumnText(Object obj, int index) {
		String label= "";
		if (obj instanceof Property) {
			Property bpmnProperty= (Property) obj;
			if (BpmnPropertiesView.NAME_COLUMN == BpmnPropertiesView.COLUMN_NAMES[index]) {
				label= bpmnProperty.getName(); 
			}
			if (BpmnPropertiesView.TYPE_COLUMN == BpmnPropertiesView.COLUMN_NAMES[index]) {
				label= bpmnProperty.getType();
			}
			if (BpmnPropertiesView.OWNER_COLUMN == BpmnPropertiesView.COLUMN_NAMES[index]) {
				if (bpmnProperty.eContainer() instanceof Message) {
					Message message = (Message) bpmnProperty.eContainer();
					label= message.getName();
				}
				if (bpmnProperty.eContainer() instanceof IdObject) {
					IdObject idObject = (IdObject) bpmnProperty.eContainer();
					label= idObject.getName();
				}
				label+= " (" + bpmnProperty.eContainer().getClass().getSimpleName() + ")";
			}
		}
		return label;
	}

	public Image getColumnImage(Object obj, int index) {
		if (index == 0) {
			return VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_PROPERTY).createImage();
		} else {
			return null;
		}
	}

}