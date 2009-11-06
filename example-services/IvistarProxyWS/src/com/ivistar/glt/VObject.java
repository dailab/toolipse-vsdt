package com.ivistar.glt;


import static com.ivistar.glt.VObject.Property.Value;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Logger;

public class VObject {

	private String actuelValue;
	
    final Logger logger = Logger.getLogger (VObject.class.getName());

    //*************************************************************************
	//*** instance
	//***

	public enum Property {
		/* general*/ Name, Label, Value, Resource, InetAddress, Line,
		/* calced */ UID, IP
	};

	public VObject() {
	}

	//*************************************************************************
	//*** getter/setter
	//***

	final Hashtable<Property, Object> properties = new Hashtable<Property, Object>();

	Object _get (final Property key)
	{
		return properties.get (key);
	}

	void _set (final Property key, final Object value)
	{
		if (value == null)
			properties.remove (key);
		else
			properties.put (key, value);
	}

	public String getString (final Property key)
	{
		final Object result = get (key);

		if (result == null)
			return "<undefined>";
		else
		if (result instanceof String)
			return (String) result;
		
		return String.valueOf (result);
	}


	public Object get (final Property key, final Object _default)
	{
		final Object value = get (key);

		if (value == null)
			return _default;

		return value;
	}

	public Object get (final Property key)
	{
		if (key == Property.IP)
			return ((InetAddress) _get (Property.InetAddress)).getHostAddress();
		else
			return _get (key);
	}

	public void set (final Property key, final Object value)
	{
		if (key == Property.Name)
			setName (String.valueOf (value));
		else
//		if (key == Property.Label)
//			setLabel (String.valueOf (value));
//		else
		if (key == Property.Value)
			setValue ((String) value);
		else
			_set (key, value);
	}

	/**
	 * @param object the object to copy from
	 */
	public void set (final VObject object) {
		properties.putAll (object.properties);
	}

	/**
	 * @param value the name to set
	 */
	private void setName (String value) {
		if (value == null)
			return;

		value = value.replace ('_', ' ').trim().replace (' ', '_');

		_set (Property.Name, value);
	}

	/**
	 * @param value the value to set
	 */
	public synchronized void setValue (final String value) {
		setValue (value, true);
		actuelValue=value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue (final String newValue, final boolean sendEvent) {
		final String value = (String) get (Property.Value);
		if (value != newValue) {
			final String oldValue = value;
			_set (Property.Value, newValue);

			if (sendEvent)
				fireEvent (Value, oldValue, newValue);
		}
	}
	

	//*************************************************************************
	//*** eventing
	//***

	final Vector<PropertyChangeListener> listeners = new Vector<PropertyChangeListener>();  

	public void addListener (final PropertyChangeListener listener) {
		if (listener == null)
			new RuntimeException ("addListener: argument must not be null");

		synchronized (listeners) {
			listeners.add (listener);
		}
	}

	public void removeListener (final PropertyChangeListener listener) {
		if (listener == null)
			new RuntimeException ("removeListener: argument must not be null");

		synchronized (listeners) {
			listeners.remove (listener);
		}
	}

	synchronized public void fireEvent (final Property propertyName, final Object oldValue, final Object value) {
		fireEvent (propertyName.toString(), oldValue, value);
	}

	synchronized public void fireEvent (final String name, final Object oldValue, final Object value) {
		final PropertyChangeEvent event = new PropertyChangeEvent (this, name, null, value);

		synchronized (listeners) {
			for (final PropertyChangeListener listener:listeners) {
				listener.propertyChange (event);
			}
		}
	}
	public String getValue(){
		return actuelValue;
	}
	public void setActualValue(String value){
		this.actuelValue= value;
	}
}
