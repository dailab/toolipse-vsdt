package de.dailab.vsdt.util;

import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;

/**
 * Provides some better "to-string" representations for different VSDT elements,
 * to be used in different places.
 *
 * @author kuester
 */
public class VsdtToStringHelper {

	public static String getString(MessageChannel message) {
		String nameString= message.getChannel() != null ? message.getChannel().getExpression() : "<unknown>";
		StringBuffer buffer= new StringBuffer();
		buffer.append(nameString != null ? nameString : "<null>"); //$NON-NLS-1$
		buffer.append("(");
		if (message.getPayload() != null) {
			buffer.append(message.getPayload().getName());
			buffer.append(": ");
			buffer.append(message.getPayload().getType());
		}
		buffer.append(")");
		return buffer.toString();
	}
	
	public static String getString(Property property) {
		StringBuffer buffer= new StringBuffer();
		buffer.append(property.getName());
		buffer.append(": "); //$NON-NLS-1$
		buffer.append(property.getType());
		return buffer.toString();
	}
	
	public static String getString(Assignment assignment) {
		Property to= assignment.getTo();
		Expression from= assignment.getFrom();
		StringBuffer buffer= new StringBuffer();
		buffer.append(assignment.getAssignTime() == AssignTimeType.START ? "S: " : "E: ");
		buffer.append(VsdtHelper.getPropertyString(to, true));
		if (assignment.getToQuery() != null) {
			buffer.append(" / "); //$NON-NLS-1$
			buffer.append(assignment.getToQuery());
		}
		buffer.append(" := ");//$NON-NLS-1$
		buffer.append(from != null ? (from.getExpression() != null ? from.getExpression() : "") : "<null>"); //$NON-NLS-1$
		return buffer.toString();
	}
	
	public static String getString(Service service) {
		String ifString= service.getInterface();
		String opString= service.getOperation();
		String typeString= service.getType();
		StringBuffer buffer= new StringBuffer();
		buffer.append(ifString != null ? ifString : "<unknown>"); //$NON-NLS-1$
		buffer.append(".");
		buffer.append(opString != null ? opString : "<unknown>"); //$NON-NLS-1$
		if (service.getParticipant() != null) {
			buffer.append(" @ "); //$NON-NLS-1$
			buffer.append(service.getParticipant().getName());
		}
		buffer.append(" (");
		buffer.append(typeString != null ? typeString : "unknown type"); //$NON-NLS-1$
		buffer.append(")");
		return buffer.toString();

	}
	
}
