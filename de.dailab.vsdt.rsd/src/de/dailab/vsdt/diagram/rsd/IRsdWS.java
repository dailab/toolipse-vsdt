package de.dailab.vsdt.diagram.rsd;

import java.util.Calendar;

import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Message;
 
/**
 * this interface works as a bridge to the various framework- and client specific
 * webservice data object, e.g. Axis2ServiceDescription. Since this interface is
 * independent of the client used to access the RSD, it can be integrated in the 
 * view while the actual client is fully transparent to the view.
 * 
 * The interface provides methods to all the attributes of the service descriptions
 * (or at least those relevant to the RSD view). Clients have to implement this interface
 * to provide a webservice representation usable by the RSD View
 *   
 * @author kuester
 */
public interface IRsdWS {

	String getName();
	
	String getProviderAdress();
	
	String getId();
	
	String[] getKeywords();
	
	String getQoSRating();

	Calendar getExpireDate();
	
	String getPrecondition();
	
	String getPostcondition();
	
	IRsdParam[] getInputParams();
	
	IRsdParam[] getOutputParams();
	
	String getWsdlUrl();
	
	String getWsdl();
	
	Object getDefinition();

	Implementation getWebService();
	
	Message getInputMessage();
	
	Message getOutputMessage();
	
}
