/*
 * $Id: DatagramServer.java,v 1.1.2.1 2008/02/18 14:25:44 bogart Exp $
 * Created Winter 2004/2005 by Philipp Berndt <philipp.berndt@ivistar.de>
 *
 * Code (c) Ivistar AG, Berlin, Germany
 */

package com.ivistar.vroomctrl.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PortUnreachableException;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Abstract base class of a server that receives DatagramPackets.
 *
 * This class is thread-safe.
 *
 * @author Philipp Berndt
 */
public class DatagramServer extends DatagramSocket {

    public interface Receiver {

        /**
         * This method is called everytime a DatagramPacket arrives.
         */
        public abstract void packetReceived(DatagramPacket p);
    }

    private class ReceiverThread extends Thread {
        public ReceiverThread() {
            setName(this.getClass().getName());
        }

        public void run() {
            byte[] buf = new byte[2048];
            DatagramPacket p = new DatagramPacket(buf, buf.length);

            try {
                while (receiverThread == currentThread()) {
                    receive(p); // blocks
                    if (receiverThread != currentThread()) // check again
                        break;
                    try {
                        Receiver r = receiver;  // get thread-safe copy
                        if (r != null)
                            r.packetReceived(p);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } catch(PortUnreachableException ex) {
                logger.warning("receive():remote port unreachable!");
            } catch(SocketException ex) {
                logger.warning("receive(): SocketException"+ex.toString());
            } catch(IOException ex) {
                ex.printStackTrace();
            }
            logger.info("ReceiverThread terminating");
            shutdownComplete = true;
        }
    };

    private volatile ReceiverThread receiverThread;
    private final Object receiverThreadLock = new Object(); // can't synchronize on receiverThread directly
    private volatile boolean shutdownComplete = false;
    private volatile Receiver receiver;
    protected static final Logger logger = Logger.getAnonymousLogger();
    static {
        logger.setLevel(Level.ALL);
    }

    /** Creates a new instance of AbstractDatagramServer */
    public DatagramServer() throws SocketException {
        super((SocketAddress)(null)); // create unbound socket
        logger.entering("DatagramServer","DatagramServer()");
        logger.exiting("DatagramServer","DatagramServer()");
    }


    /**
     * Starts the daemon thread that waits for DatagramPackets.
     */
    public void startReceiverThread() {
        synchronized (receiverThreadLock) {
            if (receiverThread != null)
                throw new IllegalThreadStateException("Receiver thread already running!");
            receiverThread = new ReceiverThread();
            receiverThread.setDaemon(true);
            receiverThread.start();
        }
    }

    /**
     * Stops the daemon thread that waits for DatagramPackets.
     */
    public void stopReceiverThread() {
        synchronized (receiverThreadLock) {
            if (receiverThread != null) {
                receiverThread = null;
                logger.fine("socket closing");
                close();
                logger.fine("socket closed");

                if (isConnected()) {
                    logger.fine("socket disconnecting");
                    disconnect();
                    logger.fine("socket disconnected");
                }
            } else return;
        }
        while (!shutdownComplete) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException ex) {
            }
        }
        logger.fine("receiver thread shutdown complete");
    }

    /**
     * Getter for property receiver.
     * @return Value of property receiver.
     */
    public Receiver getReceiver() {
        return receiver; // receiver is volatile, operation atomic => no need to lock
    }

    /**
     * Setter for property receiver.
     * @param receiver New value of property receiver.
     */
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver; // receiver is volatile, operation atomic => no need to lock
    }

    /**
     * Returns the address of the endpoint this socket is bound to, or
     * <code>null</code> if it is not bound yet.
     *
     * @return a <code>SocketAddress</code> representing the local endpoint of this
     * 	       socket, or <code>null</code> if it is not bound yet.
     * @see #getLocalSocketAddress()
     * @see #getLocalAddress()
     * @see #getLocalPort()
     * @see #bind(SocketAddress)
     */
    public InetSocketAddress getLocalInetSocketAddress() {
        InetAddress ip = getLocalAddress();
        return (ip != null) ? new InetSocketAddress(ip, getLocalPort()) : null;
    }
}
