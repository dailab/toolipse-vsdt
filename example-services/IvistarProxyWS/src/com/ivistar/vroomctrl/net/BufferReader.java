/*
 * $Id: BufferReader.java,v 1.1.2.1 2008/02/18 14:25:44 bogart Exp $
 * Created Winter 2004/2005 by Philipp Berndt <philipp.berndt@ivistar.de>
 *
 * Code (c) Ivistar AG, Berlin, Germany
 */

package com.ivistar.vroomctrl.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;


/**
 * For extracting (more or less) elemental types from a byte buffer.
 *
 * @author Philipp Berndt <philipp.berndt@ivistar.de>
 */
public class BufferReader {
    public static final int SEEK_SET = 0;
    public static final int SEEK_CUR = 1;
    public static final int SEEK_END = 2;
    
    public BufferReader(byte[] buffer) {
        this(buffer, 0, buffer.length);
    }
    public BufferReader(byte[] buffer, int offset) {
        this(buffer, offset, buffer.length-offset);
    }
    public BufferReader(byte[] buffer, int offset, int length) {
        this.buffer = buffer;
        this.idx = offset;
        this.end = offset+length;
    }
    
    private byte buffer[];
    private int idx;
    private int end;
    
    public boolean isAtEnd() {
        return idx >= end;
    }
    
    public void seek(int offset, int whence) {
        switch(whence) {
            case SEEK_SET:
                idx = offset;
                break;
            case SEEK_CUR:
                idx += offset;
                break;
            case SEEK_END:
                idx = end + offset;
                break;
            default:
                throw new IllegalArgumentException("seek(): The whence argument must be SEEK_SET, SEEK_END, or SEEK_CUR.");
        }
    }
    
    public int tell() {
        return idx;
    }
    
    public int readUBYTE() {
        if (isAtEnd())
            throw new ArrayIndexOutOfBoundsException(idx);
        int b = buffer[idx++];
        return (b < 0) ? b + 256 : b;
    }
    
    public int readUWORD() {
        return readUBYTE()*256 + readUBYTE();
    }
    
    public String readPString() {
        int len = readUBYTE();
        String res = new String(buffer, idx, len);
        idx += len;
        return res;
    }
    
    public InetSocketAddress readInetSocketAddress() {
        InetSocketAddress res = null;
        int family = readUWORD();
        int port = readUWORD();
        
        switch(family) {
            case BufferWriter.AF_INET: {
                byte[] tmp = new byte[4];
                System.arraycopy(buffer, idx, tmp, 0, 4);
                idx += 4;
                try {
                    InetAddress ipaddr = InetAddress.getByAddress(tmp);
                    res = new InetSocketAddress(ipaddr, port);
                } catch(UnknownHostException ex) {
                    ex.printStackTrace();
                    throw new Error(ex);
                }
                break;
            }
            case BufferWriter.AF_INET6: {
                idx += 4; // flow_info;
                byte[] tmp = new byte[16];
                System.arraycopy(buffer, idx, tmp, 0, 16);
                idx += 16;
                idx += 4; // scope_id
                try {
                    InetAddress ipaddr = InetAddress.getByAddress(tmp);
                    res = new InetSocketAddress(ipaddr, port);
                } catch(UnknownHostException ex) {
                    ex.printStackTrace();
                    throw new Error(ex);
                }
                break;
            }
            default:
                throw new IllegalArgumentException("Error parsing InetSocketAddress");
        }
        return res;
    }
    
    public ComponentAddress readComponentAddress() {
        InetSocketAddress isa = readInetSocketAddress();
        int line = readUWORD();
        return new ComponentAddress(isa, line);
    }
}

