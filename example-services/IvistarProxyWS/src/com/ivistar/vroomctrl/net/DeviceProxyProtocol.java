/*
 * $Id: DeviceProxyProtocol.java,v 1.1.2.1 2008/02/18 14:25:44 bogart Exp $
 * Created Winter 2004/2005 by Philipp Berndt <philipp.berndt@ivistar.de>
 *
 * Code (c) Ivistar AG, Berlin, Germany
 */

package com.ivistar.vroomctrl.net;

import java.net.InetSocketAddress;

/**
 * For encoding vroomctrl specific (complex) types into a byte buffer.
 *
 * UDP-Kommunikation
 * Die UDP-Pakete werden per Unicast über Port xxxxx ausgetauscht. Jedes Paket
 * kann aus mehreren so genannten ?Chunks? bestehen, die unterschiedliche
 * Informationen enthalten bzw. Aktionen auslösen.
 * Das erste UWORD enthält den Chunk type (s. u.), das zweite die Länge des Chunks
 * (ohne Chunk type und Chunk size), dann folgt ? je nach Chunk type ? die
 * eigentliche Payload und schließlich noch ein Padding, damit der nächste Chunk
 * wieder an einer geraden Byteadresse beginnt.
 * Beispiel:
 *
 * {
 *   // chunk0
 *   UWORD #0x0002; // chunk type: write line value
 *   UWORD chunk_size0; // payload size (ohne chunk_type + chunk_size0)
 *      // sizeof(Zeilennummer0)+sizeof(valuelen0)+sizeof(value0)+sizeof(padding)
 *      // also z. B. 10 wenn valuelen == 6
 *   UWORD Zeilennummer0;
 *   UBYTE valuelen0;
 *   char[valuelen0] value0;
 *   char[0..1] padding; // to make next chunk word aligned
 *
 *  // chunk1
 *   UWORD #0x0002; // chunk type: write line value
 *   UWORD chunk_size1;
 *   UWORD Zeilennummer1;
 *   UBYTE valuelen1;
 *   char[valuelen1] value1;
 *   char[0..1] padding1;
 *   // ...
 * }
 *
 * {
 *   UWORD #0x0003; // register
 *   UWORD chunk_size;
 *   struct sockaddr_in listener;
 * }
 * {
 *   UWORD #0x0004; // unregister
 *   UWORD chunk_size;
 *   struct sockaddr_in listener;
 * }
 * Ferner gilt:
 * struct sockaddr_in {
 *   sa_family_t     sin_family; // address family: AF_INET
 *   u_int16_t       sin_port;     // port in network byte order
 *   struct in_addr sin_addr;      // internet address
 * };
 * struct in_addr {
 *   u_int32_t      s_addr;       // address in network byte order
 * };
 *
 * typedef unsigned short int sa_family_t;
 * Chunk type       Funktion
 * 0x0000           Anfrage: Zeile lesen (VR --> Kopf)
 *                  es folgt: UWORD Zeilennummer
 *                  Kopf antwortet mit Typ 0x0001
 * 0x0001           Antwort: Zeile lesen (Kopf --> VR)
 *                  es folgt: UWORD Zeilennummer,
 *                  UBYTE Laenge, char[Laenge] Wert
 * 0x0002           Zeile schreiben (VR --> Kopf)
 *                  es folgt: siehe 0x0001
 *                  Kopf antwortet mit Typ 0x0001
 * 0x0003           Registrieren (VR --> Kopf)
 *                  es folgt: sockaddr_in (IP-Adresse
 *                  und Port für Benachrichtigungen)
 *                  Bei Änderungen wird Typ 0x0001
 *                  geschickt
 * 0x0004           Deregistrieren (VR --> Kopf)
 *                  es folgt: sockaddr_in (IP-Adresse
 *                  und Port für Benachrichtigungen)
 *                  Änderungen werden nicht mehr an
 *                  das registrierende Gerät geschickt
 *
 * @see #BufferWriter
 * @author Philipp Berndt <philipp.berndt@ivistar.de>
 * @author Jochen Schoenfeld <jochen.schoenfeld@fokus.fraunhofer.de>
 */
public class DeviceProxyProtocol {
    public static final short ID_READ            = 0;
    public static final short ID_VALUECHANGED    = 1;
    public static final short ID_CONTROL         = 2;
    public static final short ID_REGISTER        = 3;
    public static final short ID_UNREGISTER      = 4;
    
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
}
