package de.dailab.vsdt.vxl.util;

import org.eclipse.emf.ecore.EObject;

/**
 * Special kind of exception for VXL Evaluation errors
 *
 * @author kuester
 */
public class VxlEvalException extends Exception {
	
	private static final long serialVersionUID = 3879036947103961520L;

	Object context;
	
	public VxlEvalException(Object context, String message, Throwable cause) {
		super(message, cause);
		this.context = context;
	}
	
}
