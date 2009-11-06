/*
 * $Id: BufferWriter.java,v 1.1.2.1 2008/02/18 14:25:44 bogart Exp $
 * Created Winter 2004/2005 by Philipp Berndt <philipp.berndt@ivistar.de>
 *
 * Code (c) Ivistar AG, Berlin, Germany
 */

package com.ivistar.vroomctrl.net;

import java.net.InetSocketAddress;


/**
 * For encoding (more or less) elemental types into a byte buffer.
 *
 * @author Philipp Berndt <philipp.berndt@ivistar.de>
 */
public class BufferWriter {
    public static final short AF_INET  =  2;
    public static final short AF_INET6 = 10;
    
    public static int writeUWORD(byte buffer[], int offset, int value) {
        if (value < 0 || value > 0x0000ffff)
            throw new IllegalArgumentException("Value out of range(UWORD):"+value);
        buffer[offset] = (byte)((value & 0x0000ff00)>>8);
        buffer[offset+1] = (byte)(value & 0x000000ff);
        return offset+2;
    }
    
    public static int writeUBYTE(byte buffer[], int offset, int value) {
        if (value < 0 || value > 0x000000ff)
            throw new IllegalArgumentException("Value out of range(UBYTE):"+value);
        buffer[offset] = (byte)(value & 0x000000ff);
        return offset+1;
    }
    
    public static int writeBytes(byte buffer[], int offset, byte[] sbuf, int soff, int len) {
        System.arraycopy(sbuf, soff, buffer, offset, len);
        return offset+len;
    }
    
    public static int writeBytes(byte buffer[], int offset, byte[] sbuf) {
        System.arraycopy(sbuf, 0, buffer, offset, sbuf.length);
        return offset+sbuf.length;
    }
    
    public static int writePString(byte buffer[], int offset, String s) {
        int end = offset;
        int length = s.length();
        if (length > 255)
            throw new IllegalArgumentException("String too long");
        end = writeUBYTE(buffer, end, length);
        end = writeBytes(buffer, end, s.getBytes());
        return end;
    }
    
    public static int writeInetSocketAddress(byte buffer[], int offset, InetSocketAddress isa) {
        int end = offset;
        end = writeUWORD(buffer, end, AF_INET);
        end = writeUWORD(buffer, end, isa.getPort());
        byte[] ipaddr = isa.getAddress().getAddress();
        end = writeBytes(buffer, end, ipaddr);
        return end;
    }
    
    public static int writeComponentAddress(byte buffer[], int offset, ComponentAddress ca) {
        int end = offset;
        end = writeInetSocketAddress(buffer, end, ca.getSocketAddress()) ;
        end = writeUWORD(buffer, end, ca.getLine());
        return end;
    }
}
