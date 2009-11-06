package de.dailab.vsdt.diagram.rsd;

/**
 * This interface works as a bridge to the various framework- and client specific
 * web service data object, e.g. Axis2ServiceDescription. Since this interface is
 * independent of the client used to access the RSD, it can be integrated in the 
 * view while the actual client is fully transparent to the view.
 * 
 * This interface describes a input/output parameter with a name, a type and optionally
 * more data (e.g. an attached XML schema description)
 * 
 * @author kuester
 */
public interface IRsdParam {

	String getName();
	
	String getType();
	
	String getData();
	
}
