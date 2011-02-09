package de.dailab.vsdt.diagram.ui;

import org.eclipse.swt.widgets.Combo;

import de.dailab.common.swt.FeatureCombo;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.util.VsdtHelper;

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
			result= ((MessageChannel) o).getChannel().getExpression();
		}
		if (o instanceof IdObject) {
			result=  ((IdObject)o).getNameOrId();
		}
		if (o instanceof Service) {
			result=  ((Service) o).getInterface() + "." + ((Service) o).getOperation();
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
