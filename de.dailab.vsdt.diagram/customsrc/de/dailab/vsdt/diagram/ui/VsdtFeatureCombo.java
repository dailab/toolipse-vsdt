package de.dailab.vsdt.diagram.ui;

import org.eclipse.swt.widgets.Combo;

import de.dailab.common.swt.FeatureCombo;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.util.VsdtHelper;
import de.dailab.vsdt.util.VsdtToStringHelper;

public class VsdtFeatureCombo<T extends Object> extends FeatureCombo<T> {

	protected final int maxLength;
	
	public VsdtFeatureCombo(Combo combo) {
		super(combo);
		this.maxLength= -1;
	}
	
	public VsdtFeatureCombo(Combo combo, int maxLength) {
		super(combo);
		this.maxLength= maxLength;
	}
	
	@Override
	protected String getLabel(T o) {
		String result= null;
		if (o instanceof MessageChannel) {
			result = VsdtToStringHelper.getString((MessageChannel) o);
		}
		if (o instanceof IdObject) {
			result=  ((IdObject)o).getNameOrId();
		}
		if (o instanceof Service) {
			result = VsdtToStringHelper.getString((Service) o);
		}
		if (o instanceof Participant) {
			result=  ((Participant)o).getName();
		}
		if (o instanceof Property) {
			result= VsdtHelper.getPropertyString((Property) o,  true);
		}
		if (result == null) {
			result= super.getLabel(o);
		}
		// trim result ?
		if (maxLength != -1 && result.length() > maxLength) {
			result= result.substring(0, maxLength) + "...";
		}
		return result;
	}
	
}
