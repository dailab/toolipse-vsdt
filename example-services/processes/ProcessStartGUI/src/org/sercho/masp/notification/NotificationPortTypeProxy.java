package org.sercho.masp.notification;

public class NotificationPortTypeProxy implements org.sercho.masp.notification.NotificationPortType {
  private String _endpoint = null;
  private org.sercho.masp.notification.NotificationPortType notificationPortType = null;
  
  public NotificationPortTypeProxy() {
    _initNotificationPortTypeProxy();
  }
  
  public NotificationPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initNotificationPortTypeProxy();
  }
  
  private void _initNotificationPortTypeProxy() {
    try {
      notificationPortType = (new org.sercho.masp.notification.NotificationLocator()).getNotificationHttpPort();
      if (notificationPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)notificationPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)notificationPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (notificationPortType != null)
      ((javax.xml.rpc.Stub)notificationPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.sercho.masp.notification.NotificationPortType getNotificationPortType() {
    if (notificationPortType == null)
      _initNotificationPortTypeProxy();
    return notificationPortType;
  }
  
  public java.lang.String[] getUserIDs() throws java.rmi.RemoteException{
    if (notificationPortType == null)
      _initNotificationPortTypeProxy();
    return notificationPortType.getUserIDs();
  }
  
  public void showMessage(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException{
    if (notificationPortType == null)
      _initNotificationPortTypeProxy();
    notificationPortType.showMessage(in0, in1);
  }
  
  
}