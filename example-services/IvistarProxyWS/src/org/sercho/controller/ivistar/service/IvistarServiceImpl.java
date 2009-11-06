package org.sercho.controller.ivistar.service;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ivistar.glt.Constants;
import com.ivistar.glt.VObject;
import com.ivistar.glt.VObject.Property;
import com.ivistar.glt.ipproxy.IPProxy;

/**
 * <code>IvistarServiceImpl</code> TODO comment
 * @todo add missing JavaDoc
 *
 * @author Serge Bedime
 */
public class IvistarServiceImpl implements IvistarService {
	
	/**number of rooms*/
	private static int NUM= 4;
	
	static final Properties[] settings= new Properties[NUM];

	/*
	 * proxy correspond to the name of the Room in the Showroom
	 * e.g Office, Kitchen and Living room
	 */
	private static IPProxy[] proxys= new IPProxy[NUM];
	/**
	 * static named rooms
	 */
	private static final String[] rooms={"Living Room","Kitchen","Office", "Studio"};
	
	final transient Log logger = LogFactory.getLog(this.getClass());
	
	/**
	 * <code>IvistarServiceImpl</code> constructor.
	 */
	public IvistarServiceImpl() {
		super();
		this.logger.info("Initiating room proxies...");
		try {
		for (int i=0; i<NUM; i++) {
			settings[i]= new Properties();
			proxys[i]= new IPProxy();
			proxys[i].setUrl(settings[i].getProperty (Constants.TAG_URL, Constants.VALUE_URL), Constants.RID[i]); // room with id 10
				proxys[i].sync();
		}
		}
		catch(RuntimeException e) {
			this.logger.error("Failed to initiate room proxies: " + e.getMessage());
			e.printStackTrace();
		}
		this.logger.info("Room proxies initiated");

	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getWindowShade(String room) {
		List<String> results = new LinkedList<String>();
		for (int i=0; i<rooms.length; i++) {
			if (room.equals(rooms[i])) {
				Vector<VObject> objects = proxys[i].getObjects();
				if (objects != null) {
					registerObject(objects);
					for (VObject object : objects) {
						if (((String)object.get(VObject.Property.Name)).startsWith("Jalousie")) {
							results.add((String)object.get(VObject.Property.Line));
//							object.setValue("100"); // wegen referenzpunkt evtl. wichtig
						}
					}
				}
			}	
		}
		return results;
		
	}

	/**
	 * {@inheritDoc}
	 */
	public String[] getRooms() {
		return rooms;
	}

	/**
	 * 
	 */
	interface MyObjectChangeListener extends PropertyChangeListener {
		public void setObject(VObject object);
	}
	
	private void registerObject(Collection<VObject> objects) {
		for (VObject object : objects) {
			this.logger.info("Register: " + object);
			final MyObjectChangeListener listener = new MyObjectChangeListener() {
				private VObject object = null;
				public void propertyChange (PropertyChangeEvent event) {
                       IvistarServiceImpl.this.logger.trace("propertyChange " + event);
                       System.out.println (object.get(VObject.Property.Name) + ": " 
                       					+ Enum.valueOf (Property.class, event.getPropertyName())
                       					+ " " + event.getNewValue());
                       object.setActualValue(event.getNewValue().toString());
                       
                }
				public void setObject(VObject object) {
					this.object = object;
				}
	        };
	        ((com.ivistar.glt.ipproxy.VObject)object).init();
	        listener.setObject(object);
			object.addListener(listener);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String getValue(String room, String line) {
		for (int i = 0; i < rooms.length; i++) {
			if (room.equals(rooms[i])) {
				Vector<VObject> objects = proxys[i].getObjects();
				for (VObject object : objects) {
					if (((String)object.get(VObject.Property.Line)).equals(line)) {
						return object.getValue();					
					}
				}
			}
		}
		return null;
	}

	
	/**
	 * {@inheritDoc}
	 */
	public void setValue(String room, String line, String newValue) {
		int k= line.indexOf(".");
		System.out.println(k);
		String id= line;
		int index= -1;
		if (k != -1) {
			id= line.substring(0,k);
			index= Integer.parseInt(line.substring(k+1));
		} 
		int n= 1;
		for (int i = 0; i < rooms.length; i++) {
			if (room.equals(rooms[i])) {
				Vector<VObject> objects = proxys[i].getObjects();
				for (VObject object : objects) {
					if (((String)object.get(VObject.Property.Line)).equals(id)) {
						if (index == -1) {
							System.out.println("setting " + line + " to " + newValue);
							object.setValue(newValue);
						}
						if (index == n) {
							System.out.println("setting " + line + " to " + newValue);
							object.setValue(newValue);
							break;
						} else {
							n++;
						}
					}
				}
			}	
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<String> getLights(String room) {
		List<String> results = new LinkedList<String>();
		for (int i = 0; i < rooms.length; i++) {
			if (room.equals(rooms[i])) {
				Vector<VObject> objects = proxys[i].getObjects();
				registerObject(objects);
				for (VObject object : objects) {
					String name= (String) object.get(VObject.Property.Name);
					if (name.contains("licht") || name.contains("Wand")) {
						results.add((String)object.get(VObject.Property.Line));
//						object.setValue("50");
					}
				}
			}	
		}
		return results;
	}
}