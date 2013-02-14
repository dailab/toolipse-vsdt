package de.dailab.vsdt.trafo.jiacbeans.export;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.impl.DefaultBpmnValidation;
import de.dailab.vsdt.vxl.util.Util;

public class Bpmn2JiacBeansValidation extends DefaultBpmnValidation {
	
	private static Map<String, String> basicDataTypeMap;
	
	static {
		basicDataTypeMap= new HashMap<String, String>();
		basicDataTypeMap.put(Util.TYPE_INTEGER, "Integer");
		basicDataTypeMap.put(Util.TYPE_BOOLEAN, "Boolean");
		basicDataTypeMap.put(Util.TYPE_STRING, "String");
		basicDataTypeMap.put(Util.TYPE_FLOAT, "Float");
		basicDataTypeMap.put(Util.TYPE_DOUBLE, "Double");
		basicDataTypeMap.put(Util.TYPE_LONG, "Long");
	}
	
	/** the currently visited BPS */
	private BusinessProcessSystem currentBps;
	
	/** data types of the currently visited BPS */
	private Set<String> definedDataTypes;
	
	/**
	 * replace white space and special characters and make title case, so the 
	 * names can be used as Java method and variable names.
	 */
	@Override
	protected String replaceIllegalChars(String s, int type) {
		return de.dailab.vsdt.trafo.jiacbeans.Util.toJavaName(s, false);
	}
	
	/**
	 * Check whether the BPS to be exported is Executable
	 */
	@Override
	protected boolean visitBusinessProcessSystem(BusinessProcessSystem bps) {
		this.currentBps = bps;
		this.definedDataTypes = new HashSet<String>();
		for (DataType type : bps.getDataTypes()) {
			String full = type.getPackage() + "." + type.getName();
			this.definedDataTypes.add(full);
		}
		boolean isOk= super.visitBusinessProcessSystem(bps);
		isOk &= test(bps.isExecutable(), "Business Process System must be Executable. " +
				"Please check the corresponding Checkbox in the VSDT Meta Diagram Properties View.");
		return isOk;
	}

	/**
	 * check data type implementation
	 */
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
			// substitute basic data types. Use Class types, for use in services
			String substitute= basicDataTypeMap.get(property.getType());
			if (substitute != null) {
				property.setType(substitute);
			}
			// all other (complex) types: be sure that the type is in DataTypes,
			// then remove the package part, if any
			String type = property.getType();
			int point = type.lastIndexOf(".");
			if (point != -1) {

				String pkg = type.substring(0, point);
				String name = type.substring(point + 1);
				if (! definedDataTypes.contains(type)) {
					DataType dataType = VsdtFactory.eINSTANCE.createDataType();
					dataType.setPackage(pkg);
					dataType.setName(name);
					dataType.setLanguage("Java");
					currentBps.getDataTypes().add(dataType);
				}
				property.setType(name);
			}
		}
		return ok;
	}

//	@Override
//	protected boolean visitEvent(Event event) {
//		boolean ok= super.visitEvent(event);
//		
//		switch (event.getTrigger()) {
//		case MESSAGE:
//			if (event instanceof Intermediate) {
//				ok &= test(event.getImplementation() instanceof MessageChannel, 
//						"For an Intermediate Message Event, the Implementation must be a MessageChannel");
//			}
//			break;
//		}
//		
//		return ok;
//	}
	
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
		default:
			break;
		}
		return ok;
	}
	
}
