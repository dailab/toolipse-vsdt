package com.ivistar.glt.ipproxy;

import static com.ivistar.glt.VObject.Property.Name;
import static com.ivistar.glt.VObject.Property.UID;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.ivistar.glt.ipproxy.gen.AnalogControl;
import com.ivistar.glt.ipproxy.gen.ControlGroup;
import com.ivistar.glt.ipproxy.gen.DigitalControl;
import com.ivistar.glt.ipproxy.gen.VroomControl;
import com.ivistar.vroomctrl.net.ComponentAddress;
import com.ivistar.vroomctrl.net.ProxyCommLink;
import com.ivistar.vroomctrl.net.CommLink.CommLinkListener;

public class IPProxy {

    final Logger logger = Logger.getLogger (IPProxy.class.getName());


	//*************************************************************************
	//*** instance
	//***

	URL url;
	ProxyCommLink proxyCommLink;

	final Vector<VObject> objects = new Vector<VObject>();

	public IPProxy() {
		Runtime.getRuntime().addShutdownHook (new Thread ("ipproxy_shutdown") {
			public void run() {
				logger.info ("cleanup ipproxy");

				for (VObject object:objects)
					object.exit();

				logger.info ("ipproxy cleaned");
			}
		});
	}

	public void setUrl (final String value, final String rid) {
		try {
			this.url = new URL (value + "&rid=" + rid);
			url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//*************************************************************************
	//*** singeleton
	//***

	public synchronized void sync() {
//		Debug.println ("initialize update list ...");


		synchronized (objects) {
			logger.fine ("cleanup list ...");

			for (final com.ivistar.glt.VObject label:objects)
				((VObject) label).exit();
			objects.removeAllElements();


			logger.fine ("url = <" + url + "> ...");
			logger.info ("connecting to " + url.getHost() + ':' + url.getPort() + " ...");

			final URLConnection connection;
			try {
				connection = url.openConnection();
			} catch (IOException e) {
				e.printStackTrace();
				logger.warning ("error: can't connect to " + url.getHost() + ':' + url.getPort());
				throw new RuntimeException ("Can't parse vistaroom ip/port", e);
			}

			final InputStream in;
			try {
				in = connection.getInputStream();
			} catch (IOException e) {
				e.printStackTrace();
				logger.warning ("error: can't read from " + url.getHost() + ':' + url.getPort());
				throw new RuntimeException ("Can't connect to vistaroom server", e);
			}

			logger.info ("loading items ...");

			try {
				System.out.println("RESPONSE " + in.toString());
				
				final JAXBContext context = JAXBContext.newInstance ("com.ivistar.glt.ipproxy.gen");
				final Unmarshaller unmarshaller = context.createUnmarshaller();
				final VroomControl control = (VroomControl) ((JAXBElement) unmarshaller.unmarshal (in)).getValue();

				final String proxy = control.getCommHandler().getProxy();
				if (proxy == null)
					throw new RuntimeException ("Invalid server response - tag <proxy> not found!");

				final String[] _proxy = proxy.split (":");
				final String host = _proxy[0];
				int port = 80;
				try { port = Integer.parseInt (_proxy[1]); } catch (Exception _) {}
//				System.out.print ("." + host+':'+port);
				logger.fine ("ip-proxy = " + host + ':' + port);

				final String authorization = String.valueOf (control.getCommHandler().getAuthorization());
//				System.out.print ("." + authorization);
				logger.fine ("authorization = " + authorization);
				final int delay = control.getCommHandler().getSendDelay();
//				System.out.println ("." + delay);
				logger.fine ("delay = " + delay + " ms");

				proxyCommLink = new ProxyCommLink (new InetSocketAddress (host, port), authorization, new java.util.Timer(), delay);
//				try { Thread.sleep (5000); } catch (InterruptedException _) {}

				int max = 0;
				final List<ControlGroup> controlGroups = control.getControlGroup();
				for (ControlGroup controlGroup:controlGroups)
					max +=
						controlGroup.getAnalogControl().size() +
						controlGroup.getDigitalControl().size();

				for (ControlGroup controlGroup:controlGroups)
				{
					logger.finer ("[" + controlGroup.getTitle() + ']');

					logger.finest ("    analog devices");
					for (final AnalogControl analogControl:controlGroup.getAnalogControl()) {
						add (
							/*name*/ analogControl.getTitle(),
						//	/*label*/ analogControl.getAnalogIpComponent().getLabel(),
							/*uri*/ analogControl.getAnalogIpComponent().getId()
						//	/*ressource*/ analogControl.getResource()
						);
					}

					logger.finest ("    digital devices");
					for (final DigitalControl digitalControl:controlGroup.getDigitalControl()) {
						add (
							/*name*/ digitalControl.getTitle(),
						//	/*label*/ digitalControl.getDigitalIpComponent().getLabel(),
							/*uri*/ digitalControl.getDigitalIpComponent().getId()
						//	/*ressource*/ digitalControl.getResource()
						);
					}
				}

				logger.info ("... " + objects.size() + " items loaded");
			} catch (JAXBException e) {
				e.printStackTrace();
				logger.warning ("... parsing failed - " + e);
				throw new RuntimeException ("Can't parse server response", e);
			} catch (SocketException e) {
				e.printStackTrace();
				logger.warning ("... loading failed - " + e);
				throw new RuntimeException ("Can't read server response", e);
			}
		}
	}

	//public void add (final String name, final String label, final String uri, final String ressource) {
	public void add (final String name, final String uri) {
		if (uri == null || uri.length() == 0)
			return;

//		if (label == null || label.length() == 0)
//			return;

		try {
			final VObject object = new VObject();

			object.setProxy (this);
			object.setUri (uri);

			object.set (Name, name);
//			object.set (Label, label);

			objects.add (object);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

//		Debug.println ("");
	}

	public void exit() {
		for (VObject object:objects)
			object.exit();
	}
	//*************************************************************************
	//*** public interface
	//***

	public Vector<com.ivistar.glt.VObject> getObjects() {
		return new Vector<com.ivistar.glt.VObject> (objects);
	}

	public com.ivistar.glt.VObject get (final String uid) {
		for (com.ivistar.glt.VObject object:objects) {
			if (object.get (UID).equals (uid))
				return object;
		}

		return null;
	}

	public void addListener (final ComponentAddress address, final CommLinkListener listener) {
		proxyCommLink.addListener (address, listener);
	}

	public void removeListener (final ComponentAddress address, final CommLinkListener listener) {
		proxyCommLink.removeListener (address, listener);
	}

	public void writeValue (final ComponentAddress address, final String value) {
		logger.finer ("writeValue " + address + " = " + value);
		proxyCommLink.setValue (address, value);
	}
}
