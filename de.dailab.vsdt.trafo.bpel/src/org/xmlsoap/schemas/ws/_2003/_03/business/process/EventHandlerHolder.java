package org.xmlsoap.schemas.ws._2003._03.business.process;

import org.eclipse.emf.ecore.EObject;

/**
 * common superinterface for TProcess and TScope
 * 
 * @author kuester
 * @generated NOT
 */
public interface EventHandlerHolder extends EObject {

	TCompensationHandler getCompensationHandler();
	
	TEventHandlers getEventHandlers();
	
	TFaultHandlers getFaultHandlers();	
}
