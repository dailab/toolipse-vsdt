package de.dailab.vsdt.trafo.bpel.export.stages;

import java.util.HashMap;
import java.util.Map;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.trafo.impl.BpmnMappingHelper;
import de.dailab.vsdt.trafo.impl.DefaultBpmnValidation;
import de.dailab.vsdt.vxl.util.Util;

public class Bpmn2BpelValidation extends DefaultBpmnValidation {
	
	private static Map<String, String> basicDataTypeMap;
	
	static {
		basicDataTypeMap= new HashMap<String, String>();
		basicDataTypeMap.put(Util.TYPE_INTEGER, "xsd:integer");
		basicDataTypeMap.put(Util.TYPE_BOOLEAN, "xsd:boolean");
		basicDataTypeMap.put(Util.TYPE_STRING, "xsd:string");
		basicDataTypeMap.put(Util.TYPE_FLOAT, "xsd:float");
		basicDataTypeMap.put(Util.TYPE_DOUBLE, "xsd:double");
		basicDataTypeMap.put(Util.TYPE_LONG, "xsd:long");
	}
	
	//OVERRIDDEN METHODS
	
	/**
	 * replace white space, but do not replace special characters
	 */
	@Override
	protected String replaceIllegalChars(String s, int type) {
		return s.replaceAll("\\s","").replaceAll("[\\?!.]","");
	}

	/**
	 * when transforming to BPEL, each Implementation has to be a WebService
	 */
	@Override
	protected boolean visitImplementation(Implementation implementation) {
		boolean isOK= super.visitImplementation(implementation);

		isOK&= test(implementation.getType().equalsIgnoreCase("webservice"),"Implementation must by of type 'WebService'");
		isOK&= test(implementation.getInterface() != null,"Each Web Service must provide an Interface");			
		isOK&= test(implementation.getOperation() != null,"Each Web Service must provide an Operation");
		isOK&= test(implementation.getParticipant() != null,"Each Web Service must provide a Participant");
		
		return isOK;
	}
	
	@Override
	protected boolean visitActivity(
			Activity activity) {
		boolean ok= super.visitActivity(activity);
		
		if (activity.getActivityType() == ActivityType.TASKREFERENCE ||
				activity.getActivityType() == ActivityType.SUBPROCESSREFERENCE) {
			ok&= test(! BpmnMappingHelper.isParentOrEqual(activity.getActivityRef(),activity),
					"An Activity may not reference a (transitive) parent of itself.");
		}
		return ok;
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
	
}
