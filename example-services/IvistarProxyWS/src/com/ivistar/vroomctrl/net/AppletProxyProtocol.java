/*
 * $Id: AppletProxyProtocol.java,v 1.1.2.1 2008/02/18 14:25:44 bogart Exp $
 * Created Winter 2004/2005 by Philipp Berndt <philipp.berndt@ivistar.de>
 *
 * Code (c) Ivistar AG, Berlin, Germany
 */

package com.ivistar.vroomctrl.net;

import java.net.InetSocketAddress;

/**
 * Das VroomCtrl Java Applet kommuniziert mit den IP-Devices über den 
 * VroomCtrlProxy unter Benutzung eines speziellen UDP-Protokolls.
 * 
 * Jedes Paket kann aus mehreren so genannten "Chunks" bestehen, die 
 * unterschiedliche Informationen enthalten bzw. Aktionen auslösen.
 * Das erste UWORD enthält den Chunk type (s. u.), das zweite die Länge des 
 * Chunks (ohne Chunk type und Chunk size), dann folgt ? je nach Chunk type ? 
 * die eigentliche Payload und schließlich noch ein Padding, damit der nächste 
 * Chunk wieder an einer geraden Byteadresse beginnt.
 *
 * Die Chunk-IDs sind in 
 * vroomctrl/jdnc_markup/src/java/com/ivistar/vroomctrl/net/AppletProxyProtocol.java
 * zu finden.
 * EBNF:
 *
 * Applet2ProxyPacket= Header A2PPayload
 * A2PPayload        = Authorization TargetList
 * Authorization     = ID_AUTHORIZATION ChunkSize AuthString
 * ChunkSize         = UWORD
 * AuthString        = PString
 * PString           = StringLength CHARDATA
 * StringLength      = UBYTE
 * TargetList        = ID_TARGETLIST    ChunkSize TargetCount  { CommandList }
 * TargetCount       = UWORD
 * CommandList       = ID_COMMANDLIST   ChunkSize TargetIp CommandCount { 
 * Command }
 * TargetIp          = InetSocketAddress
 * CommandCount      = UWORD
 * Command           = Read | Control | Register | Unregister
 * Read              = ID_READ          ChunkSize LineId # not used
 * Control           = ID_CONTROL       ChunkSize LineId NewValue
 * Register          = ID_REGISTER      ChunkSize OwnAddress ComponentAddress
 * Unregister        = ID_UNREGISTER    ChunkSize OwnAddress ComponentAddress
 * LineId            = UWORD
 * NewValue          = PString
 * OwnAddress        = InetSocketAddress
 * InetSocketAddress = AF_INET Port IPAddress
 * ComponentAddress  = InetSocketAddress LineId
 * 
 * Proxy2AppletPacket= Header P2APayload
 * P2APayload        = { Event }
 * Event             = ValueChanged | Forbidden | Unauthorized | SessionExpired
 * ValueChanged      = ID_VALUECHANGED    ChunkSize ComponentAddress NewValue 
 * Forbidden         = ID_FORBIDDEN       ChunkSize 
 * Unauthorized      = ID_UNAUTHORIZED    ChunkSize 
 * SessionExpired    = ID_SESSION_EXPIRED ChunkSize 
*/

/**
 * For encoding vroomctrl specific (complex) types into a byte buffer.
 *
 * @see #BufferWriter
 * @author Philipp Berndt <philipp.berndt@ivistar.de>
 */
public class AppletProxyProtocol {
    public static final short ID_READ            = 0;
    public static final short ID_VALUECHANGED    = 1;
    public static final short ID_CONTROL         = 2;
    public static final short ID_REGISTER        = 104;
    public static final short ID_UNREGISTER      = 103;
    public static final short ID_AUTHORIZATION   = 100;
    public static final short ID_TARGETLIST      = 101;
    public static final short ID_COMMANDLIST     = 102;
    public static final short ID_SESSION_EXPIRED = 499;
    public static final short ID_UNAUTHORIZED    = 401;
    public static final short ID_FORBIDDEN       = 403;
    public static final InetSocketAddress WILDCARD_ADDRESS = new InetSocketAddress(0);

    public static int writeAuthorization(byte buffer[], int offset, String auth) {
        int end = offset;
        end = BufferWriter.writeUWORD(buffer, end, ID_AUTHORIZATION);
        end += 2; // chunksize is written later
        end = BufferWriter.writePString(buffer, end, auth);
        BufferWriter.writeUWORD(buffer, offset+2, end-(offset+4));
        return end;
    }
    
    public static int writeGetValue(byte buffer[], int offset, ComponentAddress c) {
        int end = offset;
        end = BufferWriter.writeUWORD(buffer, end, ID_READ);
        end += 2; // chunksize is written later
        end = BufferWriter.writeUWORD(buffer, end, c.getLine());
        BufferWriter.writeUWORD(buffer, offset+2, end-(offset+4));
        return end;
    }
    public static int writeSetValue(byte buffer[], int offset, ComponentAddress c, String value) {
        int end = offset;
        end = BufferWriter.writeUWORD(buffer, end, ID_CONTROL);
        end += 2; // chunksize is written later
        end = BufferWriter.writeUWORD(buffer, end, c.getLine());
        end = BufferWriter.writePString(buffer, end, value);
        if ((value.length()&1) == 0)
            end = BufferWriter.writeUBYTE(buffer, end, 0);
        BufferWriter.writeUWORD(buffer, offset+2, end-(offset+4));
        return end;
    }
    
    public static int writeRegister(byte buffer[], int offset, InetSocketAddress localAddress, ComponentAddress c) {
        int end = offset;
        end = BufferWriter.writeUWORD(buffer, end, ID_REGISTER);
        end += 2; // chunksize is written later
        end = BufferWriter.writeInetSocketAddress(buffer, end, localAddress);
        end = BufferWriter.writeComponentAddress(buffer, end, c);
        BufferWriter.writeUWORD(buffer, offset+2, end-(offset+4));
        return end;
    }
    
    public static int writeUnregister(byte buffer[], int offset, InetSocketAddress localAddress, ComponentAddress c) {
        int end = offset;
        end = BufferWriter.writeUWORD(buffer, end, ID_UNREGISTER);
        end += 2; // chunksize is written later
        end = BufferWriter.writeInetSocketAddress(buffer, end, localAddress);
        end = BufferWriter.writeComponentAddress(buffer, end, c);
        BufferWriter.writeUWORD(buffer, offset+2, end-(offset+4));
        return end;
    }
    
    
    public static int writeError(byte buffer[], int offset, short errorid) {
        int end = offset;
        end = BufferWriter.writeUWORD(buffer, end, errorid);
        end +=2; // chunksize is written later
        BufferWriter.writeUWORD(buffer, offset+2, end-(offset+4));
        return end;
    }
    
    public static int writeValueChanged(byte buffer[], int offset, ComponentAddress c, String value) {
        int end = offset;
        end = BufferWriter.writeUWORD(buffer, end, ID_VALUECHANGED);
        end +=2; // chunksize is written later
        end = BufferWriter.writeComponentAddress(buffer, end, c);
        end = BufferWriter.writePString(buffer, end, value);
        BufferWriter.writeUWORD(buffer, offset+2, end-(offset+4));
        return end;
    }
}
