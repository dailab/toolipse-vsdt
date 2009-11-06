/**
 * Notification.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.masp.notification;

public interface Notification extends javax.xml.rpc.Service {
    public java.lang.String getNotificationHttpPortAddress();

    public org.sercho.masp.notification.NotificationPortType getNotificationHttpPort() throws javax.xml.rpc.ServiceException;

    public org.sercho.masp.notification.NotificationPortType getNotificationHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
