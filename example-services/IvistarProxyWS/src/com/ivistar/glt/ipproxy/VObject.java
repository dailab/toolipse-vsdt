package com.ivistar.glt.ipproxy;

import static com.ivistar.glt.VObject.Property.InetAddress;
import static com.ivistar.glt.VObject.Property.Line;
import static com.ivistar.glt.VObject.Property.UID;

import java.net.URISyntaxException;
import java.util.logging.Logger;

import com.ivistar.vroomctrl.net.ComponentAddress;
import com.ivistar.vroomctrl.net.CommLink.CommLinkListener;

public class VObject extends com.ivistar.glt.VObject {

    final Logger logger = Logger.getLogger (VObject.class.getName());

    final CommLinkListener listener;

	IPProxy proxy;
	ComponentAddress componentAddress;

	public VObject() {
		listener = new CommLinkListener() {
			public void setEnabled (final ComponentAddress c, final boolean enabled) {
				logger.fine ("CommLinkListener.setEnabled (" + c + ", " + enabled + ')');
			}
			public void valueChanged (final ComponentAddress c, final String newValue) {
				logger.fine ("ipproxy-event " + getString (UID) + " = " + newValue);
				VObject.super.setValue (newValue);
			}
		};
	}

	public void setProxy (final IPProxy value) {
		this.proxy = value;
	}

	public void setUri (final String value) throws URISyntaxException {
		this.componentAddress = new ComponentAddress (value);
		set (InetAddress, componentAddress.getSocketAddress().getAddress());
		set (Line, String.valueOf (componentAddress.getLine()));
	}

	public void setValue (final String value) {
		if (proxy != null)
			proxy.writeValue (componentAddress, value);

		super.setValue (value, false);
	}

	public ComponentAddress getComponentAddress() {
		return componentAddress;
	}

	public void init() {
		proxy.addListener (componentAddress, listener);
	}

	public void exit() {
		proxy.removeListener (componentAddress, listener);
	}
	
	
}
