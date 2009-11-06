/*
 * $Id: CommLink.java,v 1.1.2.1 2008/02/18 14:25:44 bogart Exp $
 * Created Winter 2004/2005 by Philipp Berndt <philipp.berndt@ivistar.de>
 *
 * Code (c) Ivistar AG, Berlin, Germany
 */

package com.ivistar.vroomctrl.net;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Comparator for comparing InetSocketAddresses.
 * We need this to put InetSocketAddresses in a TreeMap.
 *
 * @author Philipp Berndt <philipp.berndt@ivistar.de>
 */
class InetSocketAddressComparator implements Comparator, Serializable {

    /** signum function */
    static int sgn(int i) {
        return i < 0 ? -1 : i>0 ? 1 : 0;
    }

    /**
     * Compares its two InetSocketAddresses for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     *
     * @see Comparator.compare
     */
    public int compare(Object o1, Object o2) {
        InetSocketAddress isa1 = (InetSocketAddress)(o1); // May throw ClassCastException,
        InetSocketAddress isa2 = (InetSocketAddress)(o2); // that's ok.
        byte[] b1 = isa1.getAddress().getAddress();
        byte[] b2 = isa2.getAddress().getAddress();
        int l = b1.length - b2.length;
        if (l != 0)
            return sgn(l);

        for (int i=0; i<b1.length; ++i) {
            int c = b1[i] - b2[i];
            if (c != 0)
                return sgn(c);
        }
        return sgn(isa1.getPort() - isa2.getPort());
    }
};

/******************************************************************************/




/**
 * A network transmitter/receiver for IP-based building-control-component models.
 *
 * @author Philipp Berndt <philipp.berndt@ivistar.de>
 */
public abstract class CommLink implements DatagramServer.Receiver {

    interface ComponentSendQueueIf {

        /**
         * Makes a note of a REGISTER message to be sent to our device/component.
         */
        void register(InetSocketAddress listener);

        /**
         * Makes a note of a SETVALUE message to be sent to our device.
         */
        void setValue(String value);

        /**
         * Makes a note of a UNREGISTER message to be sent to our device/component.
         */
        void unregister(InetSocketAddress listener);

        /**
         * Writes this queue's information into a send buffer.
         */
        int write(byte[] buffer, int offset, ComponentAddress c);
    };


    /**
     * Interface for classes that receive notifications from the CommHandler when
     * the value of a component changes.
     */
    public interface CommLinkListener extends EventListener {
        public void valueChanged(ComponentAddress c, String newValue);
        public void setEnabled(ComponentAddress c, boolean enabled);
    }

    protected final static Logger logger = Logger.getAnonymousLogger();

    protected Timer             timer; // thread-safe
    protected final InetSocketAddress myAddress;
    protected DatagramServer    socket; // thread-safe
    private long                sendDelay; // minimum ms Delay between sending two packets to
    // the same Device
    private boolean             autoflush; // whether messages are sent immediately
    private Map                 listeners; // <ComponentAddress, Set<CommLinkListener> >
    static {
        logger.setLevel(Level.ALL);
    }

    /** Creates a new instance of DeviceProxy */
    public CommLink(Timer timer, long sendDelay) throws SocketException {
        this.timer = timer;
        this.sendDelay = sendDelay;
        autoflush = true;
        socket = new DatagramServer();
        listeners = Collections.synchronizedMap(new HashMap());
        socket.setReceiver(this);
        socket.bind(null);
        myAddress = socket.getLocalInetSocketAddress();
        logger.config("CommLink at "+myAddress+" sendDelay="+sendDelay);
    }

    /** Returns the ComponentSendQueue of component target. */
    abstract protected ComponentSendQueueIf getQueue(ComponentAddress target);

    /**
     * Makes a note of a REGISTER message with given listener to be sent to component target.
     */
    public void register(ComponentAddress target, InetSocketAddress listener) {
        getQueue(target).register(listener);
        if (autoflush)
            flush();
    }
    /**
     * Makes a note of a REGISTER message with given listener to be sent to component target.
     */
    public void register(ComponentAddress target) {
        register(target, AppletProxyProtocol.WILDCARD_ADDRESS);
    }

    /**
     * Makes a note of an UNREGISTER message with given listener to be sent to component target.
     */
    public void unregister(ComponentAddress target, InetSocketAddress listener) {
        getQueue(target).unregister(listener);
        if (autoflush)
            flush();
    }

    /**
     * Makes a note of an UNREGISTER message with the DeviceProxy as listener to be sent to component target.
     */
    public void unregister(ComponentAddress target) {
        unregister(target, AppletProxyProtocol.WILDCARD_ADDRESS);
    }

    /**
     * Makes a note of an SETVALUE message to be sent to component target.
     */
    public void setValue(ComponentAddress target, String value) {
        logger.finest(target.toString()+" := "+value);

        getQueue(target).setValue(value);
        if (autoflush)
            flush();
    }

    /** Sends all pending messages to the devices. */
    public abstract void flush();

    public void onValueChanged(ComponentAddress ca, String newValue) {
        ArrayList threadsafeCopy=null; // <CommLinkListener>
        synchronized (listeners) {
            Set set = (Set)(listeners.get(ca));
            if (set != null)
                threadsafeCopy = new ArrayList(set);
        }

        // now notify all listeners outside synchronized
        if (threadsafeCopy != null) {
            for (Iterator i = threadsafeCopy.iterator(); i.hasNext(); ) {
                try {
                    CommLinkListener l = (CommLinkListener)(i.next());
                    l.valueChanged(ca, newValue);
                } catch (Exception ex) {
                    logger.warning(ex.toString());
                }
            }
        }
    }

    public void onForbidden() {
    }

    public void onUnauthorized() {
    }

    public void onSessionExpired() {
        Vector flatCopy = new Vector(); // <[ComponentAddress, CommLinkListener]>
        synchronized (listeners) {
            for (Iterator i1 = listeners.entrySet().iterator(); i1.hasNext(); ) {
                Map.Entry me = (Map.Entry)(i1.next());
                ComponentAddress ca = (ComponentAddress)(me.getKey());
                Set set = (Set)(me.getValue());
                if (set != null)
                    for(Iterator i2 = set.iterator(); i2.hasNext(); )
                        flatCopy.add(new Object[] {ca, i2.next()});
            }
        }

        // now notify all listeners outside synchronized
        for (Iterator i = flatCopy.iterator(); i.hasNext(); ) {
            try {
                Object[] o = (Object[])(i.next());
                ComponentAddress ca = (ComponentAddress)(o[0]);
                CommLinkListener l = (CommLinkListener)(o[1]);
                l.setEnabled(ca, false);
            } catch (Exception ex) {
                logger.warning(ex.toString());
            }
        }

    }

    public void addListener(ComponentAddress c, CommLinkListener l) {
        synchronized (listeners) {
            Set set = (Set)(listeners.get(c));
            if (set == null) {
                set = new HashSet();
                listeners.put(c, set);
                set.add(l);
                register(c);
            }
            set.add(l);
        }
    }

    public void removeListener(ComponentAddress c, CommLinkListener l) {
        synchronized (listeners) {
            Set set = (Set)(listeners.get(c));
            if (set == null)
                return;

            set.remove(l);
            if(set.isEmpty()) {
                listeners.remove(c);
                unregister(c);
            }
        }
    }

    public boolean isAutoflush() {
        return this.autoflush;
    }

    public void setAutoflush(boolean autoflush) {
        if(autoflush != this.autoflush) {
            this.autoflush = autoflush;
            if (autoflush)
                flush();
        }
    }

    public long getSendDelay() {
        return this.sendDelay;
    }

    public void setSendDelay(long sendDelay) {
        this.sendDelay = sendDelay;
    }

    public void destroy() {
        if (socket.isConnected()) {
            logger.fine("CommHandler disconnecting");
            socket.disconnect();
            logger.info("CommHandler disconnected");
        }
    }
}
