/*
 * $Id: SendQueue.java,v 1.1.2.1 2008/02/18 14:25:44 bogart Exp $
 * Created Winter 2004/2005 by Philipp Berndt <philipp.berndt@ivistar.de>
 *
 * Code (c) Ivistar AG, Berlin, Germany
 */

package com.ivistar.vroomctrl.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.util.TimerTask;
import java.util.logging.Logger;


/**
 * Accumulates information to be sent.
 *
 * This class is thread-safe.
 * @author Philipp Berndt <philipp.berndt@ivistar.de>
 */
public abstract class SendQueue {
    private DatagramSocket    socket; // thread-safe
    private byte              buffer[];
    private InetSocketAddress destination;
    private long              previousSend;
    private java.util.Timer   timer; // thread-safe
    private long              sendLimit;
    private TimerTask         sendTimerTask;
    protected static Logger logger = Logger.getAnonymousLogger();
   
    public SendQueue(DatagramSocket socket, InetSocketAddress destination, java.util.Timer timer, long sendLimit) {
        this.socket      = socket;
        this.destination = destination;
        this.timer       = timer;
        this.sendLimit   = sendLimit;
        this.buffer = new byte[1000000];
        
    }

    public SendQueue(DatagramSocket socket, InetSocketAddress destination) {
        this(socket, destination, null, 0);
    }

    /**
     * In this method you must write your SendQueue's content into the given buffer.
     */
    abstract protected int write(byte buffer[], int offset);

    /**
     * Orders the accumulated information to be sent.
     * Depending on the time of the last one, the transmission is either done
     * immediatly or scheduled for the near future (if needed).
     */
    public synchronized void flush() {
        if (sendTimerTask != null) {
            logger.finer("Not sending (scheduled already)");
            return; // flush in progress
        }
        long t = sendLimit - (System.currentTimeMillis()-previousSend);
        if (t <= 0) {
            logger.finer("Sending immediately");
            send();
        } else {
            logger.finer("Not sending (scheduling now)");
            sendTimerTask = new TimerTask() {
                public void run() {
                    send();
                }
            };
            timer.schedule(sendTimerTask, t);
        }
    }

    /** Sends a (filled) buffer to the SendQueues recipient. */
    private synchronized void send() {
        sendTimerTask = null; // in case we are called from sendTimerTask we
        // we need to do this within synchronized
        try {
            int end = 0;
            end = write(buffer, end);
            if (end != 0) {
                DatagramPacket p = new DatagramPacket(buffer, end, destination);
                logger.finer("Sending as scheduled");
                logger.finer("Proxy2Device: Sending " + buffer + " to " + destination);
                socket.send(p);
                previousSend = System.currentTimeMillis();
            }
        } catch(ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        } catch(PortUnreachableException ex) {
            logger.warning("Destination "+destination+" unreachable!");
        } catch(SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
