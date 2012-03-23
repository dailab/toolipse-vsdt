package de.dailab.vsdt.trafo.jiacv.export;

import java.util.HashMap;
import java.util.Map;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.trafo.impl.DefaultBpmnValidation;
import de.dailab.vsdt.vxl.util.Util;

public class Bpmn2JiacVValidation extends DefaultBpmnValidation {
	
	//OVERRIDDEN METHODS
	
	private static Map<String, String> basicDataTypeMap;
	
	static {
		basicDataTypeMap= new HashMap<String, String>();
		basicDataTypeMap.put(Util.TYPE_INTEGER, "int");
		basicDataTypeMap.put(Util.TYPE_BOOLEAN, "bool");
		basicDataTypeMap.put(Util.TYPE_STRING, "string");
		basicDataTypeMap.put(Util.TYPE_FLOAT, "float");
		basicDataTypeMap.put(Util.TYPE_DOUBLE, "double");
		basicDataTypeMap.put(Util.TYPE_LONG, "int");
	}
	
	/**
	 * replace white space, but do not replace special characters
	 */
	@Override
	protected String replaceIllegalChars(String s, int type) {
		String ret= s.replaceAll("\\s","").replaceAll("[\\?!.]","");
		// variable names have to start with a lower case letter
		return ret;
	}
	
	/**
	 * Check whether the BPS to be exported is Executable
	 */
	@Override
	protected boolean visitBusinessProcessSystem(BusinessProcessSystem bps) {
		boolean isOk= super.visitBusinessProcessSystem(bps);
		isOk &= test(bps.isExecutable(), "Business Process System must be Executable");
		return isOk;
	}

	@Override
	protected boolean visitDataType(DataType dataType) {
		boolean isOk= super.visitDataType(dataType);
		isOk &= test("java".equalsIgnoreCase(dataType.getLanguage()), "Data Types must be Java classes");
		return isOk;
	}
	
	/**
	 * substitute basic data types
	 */
	@Override
	protected boolean visitProperty(Property property) {
		boolean ok= super.visitProperty(property);
		if (ok) {
			String substitute= basicDataTypeMap.get(property.getType());
			if (substitute != null) {
				property.setType(substitute);
			}
		}
		return ok;
	}

	@Override
	protected boolean visitEvent(Event event) {
		boolean ok= super.visitEvent(event);
		
		switch (event.getTrigger()) {
		case MESSAGE:
			if (event instanceof Intermediate) {
				ok &= test(event.getImplementation() instanceof MessageChannel, 
						"For an Intermediate Message Event, the Implementation must be a MessageChannel");
			}
			break;
		}
		
		return ok;
	}

	
	@Override
	protected boolean visitActivity(Activity activity) {
		boolean ok= super.visitActivity(activity);
		
		switch (activity.getActivityType()) {
		case SERVICE:
		case USER:
			ok &= test(activity.getImplementation() instanceof Service, 
					"Implementation must be Service for Service or User Task.");
			break;
		case SEND:
		case RECEIVE:
			ok &= test(activity.getImplementation() instanceof MessageChannel, 
					"Implementation must be MessageChannel for Send and Receive Task");
			break;
		}
		
//		if (activity.getActivityType() == ActivityType.REFERENCE) {
//			ok&= test(! BpmnMappingHelper.isParentOrEqual(activity.getActivityRef(),activity),
//					"An Activity may not reference a (transitive) parent of itself.");
//		}
		return ok;
	}
	
	@Override
	protected boolean visitMessageChannel(MessageChannel messageChannel) {
		boolean ok= super.visitMessageChannel(messageChannel);
		
		return ok;
	}

}
