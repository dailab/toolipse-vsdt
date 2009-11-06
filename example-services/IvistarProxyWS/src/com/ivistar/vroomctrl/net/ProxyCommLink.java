/*
 * $Id: ProxyCommLink.java,v 1.1.2.1 2008/02/18 14:25:44 bogart Exp $
 * Created Winter 2004/2005 by Philipp Berndt <philipp.berndt@ivistar.de>
 *
 * Code (c) Ivistar AG, Berlin, Germany
 */

package com.ivistar.vroomctrl.net;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TreeMap;

import com.ivistar.vroomctrl.net.CommLink.ComponentSendQueueIf;



/**
 * Accumulates information to be sent to one Component.
 *
 * This class is thread-safe.
 *
 * @author Philipp Berndt <philipp.berndt@ivistar.de>
 */
class PCLComponentSendQueue implements CommLink.ComponentSendQueueIf {
    private Set    registrations;
    private Set    unregistrations;
    private String value;

    /**
     * Makes a note of a REGISTER message to be sent to our device/component.
     */
    public synchronized void register(InetSocketAddress listener) {
        if (unregistrations != null && unregistrations.contains(listener))
            unregistrations.remove(listener);
        if (registrations == null)
            registrations = new HashSet();
        registrations.add(listener); // register in any case to be sure
    }

    /**
     * Makes a note of a UNREGISTER message to be sent to our device/component.
     */
    public synchronized void unregister(InetSocketAddress listener) {
        if (registrations != null && registrations.contains(listener))
            registrations.remove(listener);
        if (unregistrations == null)
            unregistrations = new HashSet();
        unregistrations.add(listener); // unregister in any case to be sure
    }

    /**
     * Makes a note of a SETVALUE message to be sent to our device.
     */
    public synchronized void setValue(String value) {
        this.value = value;
    }

    /**
     * Writes this queue's information into a send buffer.
     */
    public synchronized int write(byte buffer[], int offset, ComponentAddress c) {
        int end = offset;
        if
        (
        	(
        		registrations != null &&
        		registrations.size() > 0
        	) || (
        		unregistrations != null &&
        		unregistrations.size() > 0
        	) || (
        		value != null
        	)
        )
        {
	        end = BufferWriter.writeUWORD(buffer, end, AppletProxyProtocol.ID_COMMANDLIST);
	        end +=2; // chunksize is written later
	        end = BufferWriter.writeInetSocketAddress(buffer, end, c.getSocketAddress());
	
	        int ncommands_ptr = end;
	        end +=2; // number of commands is written later
	
	        int ncommands = 0;

	        if (registrations != null) {
	            for (Iterator i=registrations.iterator(); i.hasNext();) {
	                end = AppletProxyProtocol.writeRegister(buffer, end, (InetSocketAddress)(i.next()), c);
	                ++ncommands;
	            }
	            registrations.clear();
	
	        }

	        if (unregistrations != null) {
	            for (Iterator i=unregistrations.iterator(); i.hasNext();) {
	                end = AppletProxyProtocol.writeUnregister(buffer, end, (InetSocketAddress)(i.next()), c);
	                ++ncommands;
	            }
	            unregistrations.clear();
	        }
	
	        if (value != null) {
	            end = AppletProxyProtocol.writeSetValue(buffer, end, c, value);
	            ++ncommands;
	            value = null;
	        }
	
	        BufferWriter.writeUWORD(buffer, ncommands_ptr, ncommands);
	        BufferWriter.writeUWORD(buffer, offset+2, end-(offset+4));
        }
        return end;
    }
}

/******************************************************************************/


/**
 * Accumulates information to be sent to the vroomctrl proxy.
 */
class PCLProxySendQueue extends SendQueue {
    private final String authorization;   // sent with each message
    private Map          componentQueues; // <ComponentAddress, ComponentSendQueue>, all access must synchronize

    public PCLProxySendQueue(DatagramServer socket, InetSocketAddress destination, String authorization, java.util.Timer timer, long sendLimit) {
        super(socket, destination, timer, sendLimit);
        this.authorization = authorization;
        componentQueues = new TreeMap();
    }

    /** Returns the ComponentSendQueue of component target. */
    public ComponentSendQueueIf get(ComponentAddress key) {
        synchronized (componentQueues) {
            return (ComponentSendQueueIf)(componentQueues.get(key));
        }
    }

    /** Returns the ComponentSendQueue of component target. */
    public ComponentSendQueueIf getQueue(ComponentAddress target) {
        synchronized (componentQueues) {
            ComponentSendQueueIf q = get(target);
            if (q == null) {
                q = new PCLComponentSendQueue();
                put(target, q);
            }
            return q;
        }
    }

    public void put(ComponentAddress key, ComponentSendQueueIf value) {
        synchronized (componentQueues) {
            componentQueues.put(key, value);
        }
    }

    private int writeTargetList(byte buffer[], int offset) {
        int end = offset;
        end = BufferWriter.writeUWORD(buffer, end, AppletProxyProtocol.ID_TARGETLIST);
        end +=2; // chunksize is written later
        synchronized (componentQueues) {
//            end = BufferWriter.writeUWORD(buffer, end, componentQueues.size());
        	final int componentQueuesSizeOffset = end;
        	end+=2;
            int componentQueuesSize = 0;

            int end_old;
            for (Iterator i=componentQueues.entrySet().iterator(); i.hasNext();) {
                Map.Entry entry = (Map.Entry)(i.next());
                ComponentAddress ca = (ComponentAddress)(entry.getKey());
                ComponentSendQueueIf commands = (ComponentSendQueueIf)(entry.getValue());

                end_old = end;
                end = commands.write(buffer, end, ca);
                if (end != end_old)
                	componentQueuesSize++;
            }
            BufferWriter.writeUWORD(buffer, componentQueuesSizeOffset, componentQueuesSize);
            BufferWriter.writeUWORD(buffer, offset+2, end-(offset+4));
            return end;
        }
    }

    /**
     * Writes this queue's information into a send buffer.
     */
    public int write(byte buffer[], int offset) {
        int end = offset;
        if (authorization != null)
            end = AppletProxyProtocol.writeAuthorization(buffer, end, authorization);

        synchronized (componentQueues) {
            if (!componentQueues.isEmpty())
                end = writeTargetList(buffer, end);
        }

        return end;
    }
};

/******************************************************************************/

/**
 * A network transmitter/receiver for IP-based building-control-component models.
 * Uses a vroomctrl proxy to communicate with the IP-Device.
 *
 * @author Philipp Berndt <philipp.berndt@ivistar.de>
 */
public class ProxyCommLink extends CommLink {
//    protected final static Logger logger = Logger.getAnonymousLogger();
    private final PCLProxySendQueue     queue; // thread-safe


    /** Creates a new instance of ProxyCommLink */
    public ProxyCommLink(SocketAddress proxy, String authorization, Timer timer, long sendDelay) throws SocketException {
        super(timer, sendDelay);
        queue = new PCLProxySendQueue(socket, (InetSocketAddress)(proxy), authorization, timer, sendDelay);
        logger.finer("ProxyCommLink connecting");
        socket.connect(proxy);
//        myAddress = socket.getLocalInetSocketAddress();
        logger.fine("ProxyCommLink at "+myAddress);
        socket.startReceiverThread();
        logger.fine("ProxyCommLink connected");
    }

    /**
     * This method is called everytime a DatagramPacket arrives.
     */
    public void packetReceived(DatagramPacket p) {
        BufferReader b = new BufferReader(p.getData(), 0, p.getLength());

        while (!b.isAtEnd()) {
            int type      = b.readUWORD();
            int chunksize = b.readUWORD();
            int start     = b.tell();

            switch(type) {
                case AppletProxyProtocol.ID_VALUECHANGED:
                {
                    ComponentAddress ca = b.readComponentAddress();
                    String value = b.readPString();
                    logger.finest(ca.toString()+" : "+value);
                    onValueChanged(ca, value);
                    break;
                }
                case AppletProxyProtocol.ID_FORBIDDEN:
                    logger.info("Received FORBIDDEN");
                    onForbidden();
                    break;
                case AppletProxyProtocol.ID_UNAUTHORIZED:
                    logger.info("Received UNAUTHORIZED");
                    onUnauthorized();
                    break;
                case AppletProxyProtocol.ID_SESSION_EXPIRED:
                    logger.info("Received SESSION_EXPIRED");
                    onSessionExpired();
                    break;
                default:
                    logger.warning("Skipping unknown chunk "+type+" of size "+chunksize);
            } // switch(type)
            b.seek(start+chunksize, BufferReader.SEEK_SET);
        } // while
    }

    public void flush() {
        queue.flush();
    }

    /**
     * Returns the ComponentSendQueue of component target.
     */
    protected ComponentSendQueueIf getQueue(ComponentAddress target) {
        return queue.getQueue(target);
    }

}
