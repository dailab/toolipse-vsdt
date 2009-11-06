/*
 * $Id: DeviceCommLink.java,v 1.1.2.1 2008/02/18 14:25:44 bogart Exp $
 * Created Fall 2005 by Philipp Berndt <philipp.berndt@ivistar.de>
 *
 * Code (c) Ivistar AG, Berlin, Germany
 */

package com.ivistar.vroomctrl.net;

import java.net.DatagramPacket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TreeMap;
import java.util.logging.Level;

/**
 * Accumulates information to be sent to one Component.
 *
 * This class is thread-safe.
 *
 * @author Philipp Berndt <philipp.berndt@ivistar.de>
 */
class DCLComponentSendQueue implements CommLink.ComponentSendQueueIf {
    private Set<InetSocketAddress>    registrations;
    private Set<InetSocketAddress>    unregistrations;
    private String value;

    /**
     * Makes a note of a REGISTER message to be sent to our device/component.
     */
    public synchronized void register(InetSocketAddress listener) {
        if (unregistrations != null && unregistrations.contains(listener))
            unregistrations.remove(listener);
        if (registrations == null)
            registrations = new HashSet<InetSocketAddress>();
        registrations.add(listener); // register in any case to be sure
    }

    /**
     * Makes a note of a UNREGISTER message to be sent to our device/component.
     */
    public synchronized void unregister(InetSocketAddress listener) {
        if (registrations != null && registrations.contains(listener))
            registrations.remove(listener);
        if (unregistrations == null)
            unregistrations = new HashSet<InetSocketAddress>();
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

        if (registrations != null) {
            for (Iterator i=registrations.iterator(); i.hasNext();) {
                InetSocketAddress isa = (InetSocketAddress)(i.next());
                end = DeviceProxyProtocol.writeRegister(buffer, end, isa , c);
                end = DeviceProxyProtocol.writeGetValue(buffer, end, c);
            }
            registrations.clear();
        }

        if (unregistrations != null) {
            for (Iterator i=unregistrations.iterator(); i.hasNext();)
                end = DeviceProxyProtocol.writeUnregister(buffer, end, (InetSocketAddress)(i.next()), c);
            unregistrations.clear();
        }

        if (value != null) {
            end = DeviceProxyProtocol.writeSetValue(buffer, end, c, value);

            value = null;
        }

        return end;
    }
};
/******************************************************************************/

/**
 * Accumulates information to be sent to one IP-Device.
 * Messages for different Components behind the same IP-Head (Device)
 * are gathered in this class's ComponentQueues and sent in one UDP packet.
 *
 * @author Philipp Berndt <philipp.berndt@ivistar.de>
 */
class DCLDeviceSendQueue extends SendQueue {
    private Map<ComponentAddress, CommLink.ComponentSendQueueIf> componentQueues; // <ComponentAddress, ComponentQueue>, all access must synchronize!

    public DCLDeviceSendQueue(DatagramServer socket, InetSocketAddress destination, java.util.Timer timer, long sendLimit) {
        super(socket, destination, timer, sendLimit);
        componentQueues = new TreeMap<ComponentAddress, CommLink.ComponentSendQueueIf>();
    }

    public CommLink.ComponentSendQueueIf get(ComponentAddress key) {
        synchronized (componentQueues) {
            return componentQueues.get(key);
        }
    }

    public void put(ComponentAddress key, CommLink.ComponentSendQueueIf value) {
        synchronized (componentQueues) {
            componentQueues.put(key, value);
        }
    }

    public int write(byte buffer[], int offset) {
        int end = offset;
        synchronized (componentQueues) {

            for (Iterator i=componentQueues.entrySet().iterator(); i.hasNext(); ) {
                Map.Entry me = (Map.Entry)(i.next());
                ComponentAddress c = (ComponentAddress)(me.getKey());
                CommLink.ComponentSendQueueIf q = (CommLink.ComponentSendQueueIf)(me.getValue());
                end = q.write(buffer, end, c);
            }
            return end;
        }
    }
}


/******************************************************************************/




/**
 * A network transmitter/receiver for IP-based building-control-component models.
 * Uses direct UDP communication with the IP-Device.
 *
 * @author Philipp Berndt <philipp.berndt@ivistar.de>
 */
public class DeviceCommLink extends CommLink {
    private Map<InetSocketAddress,DCLDeviceSendQueue> queues; // <InetSocketAddress ComponentIP, Map<ComponentAddress,ComponentSendQueue> >, all access must synchronize!
    private final boolean sharedSocket;

    /** Creates a new instance of DeviceCommLink */
    public DeviceCommLink(Timer timer, long sendDelay, boolean sharedSocket) throws SocketException {
        super(timer, sendDelay);
        this.sharedSocket = sharedSocket;
        queues = new TreeMap<InetSocketAddress,DCLDeviceSendQueue>(new InetSocketAddressComparator());
        socket.startReceiverThread();
    }

    /** Returns the ComponentSendQueue of component target. */
    protected ComponentSendQueueIf getQueue(ComponentAddress target) {
        InetSocketAddress majorKey = target.getSocketAddress();
        synchronized (queues) {
            DCLDeviceSendQueue devq = queues.get(majorKey);
            if (devq == null) {
                DatagramServer sock = socket;
                if (!sharedSocket) {
                    try {
                        if (sock.isConnected()) {
                            logger.fine("Creating socket...");
                            sock = new DatagramServer();
                            logger.fine("Binding socket...");
                            sock.bind(null);
                        }
                        logger.fine("Connecting socket...");
                        sock.connect(majorKey);
//                        myAddress = socket.getLocalInetSocketAddress();
                        logger.info("DeviceCommLink at "+myAddress);
                    } catch (SocketException ex) {
                        logger.log(Level.WARNING, ex.getMessage(), ex);
                        sock = socket; // fall-back
                    }
                }
                devq = new DCLDeviceSendQueue(sock, majorKey, timer, getSendDelay());
                queues.put(majorKey, devq);
            }

            ComponentAddress minorKey = target;
            ComponentSendQueueIf q = devq.get(minorKey);
            if (q == null) {
                q = new DCLComponentSendQueue();
                devq.put(minorKey, q);
            }
            return q;
        }

    }

    public void packetReceived(DatagramPacket p) {
        BufferReader b = new BufferReader(p.getData(), 0, p.getLength());

        while (!b.isAtEnd()) {
            int type      = b.readUWORD();
            int chunksize = b.readUWORD();
            int start     = b.tell();

            switch(type) {
                case DeviceProxyProtocol.ID_VALUECHANGED:
                {
                    InetSocketAddress vc_isa  = (InetSocketAddress)(p.getSocketAddress());
                    int               vc_line = b.readUWORD();
                    String            vc_val  = b.readPString();
                    ComponentAddress  vc_ca   = new ComponentAddress(vc_isa, vc_line);
                    onValueChanged(vc_ca, vc_val);
                    break;
                }
                default:
                    logger.warning("Skipping unknown chunk "+type+" of size "+chunksize);
            } // switch(type)
            b.seek(start+chunksize, BufferReader.SEEK_SET);
        } // while
    }

    public void flush() {
        synchronized (queues) {
            for (Iterator i=queues.keySet().iterator(); i.hasNext(); ) {
                InetSocketAddress isa = (InetSocketAddress)(i.next());
                logger.fine("DeviceCommLink flushing "+isa);
                DCLDeviceSendQueue devq = (DCLDeviceSendQueue)(queues.get(isa));
                if (devq != null)
                    devq.flush();
            }
        }
    }

}
