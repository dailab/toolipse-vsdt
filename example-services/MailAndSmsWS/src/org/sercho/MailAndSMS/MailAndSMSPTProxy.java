package org.sercho.MailAndSMS;

public class MailAndSMSPTProxy implements org.sercho.MailAndSMS.MailAndSMSPT {
  private String _endpoint = null;
  private org.sercho.MailAndSMS.MailAndSMSPT mailAndSMSPT = null;
  
  public MailAndSMSPTProxy() {
    _initMailAndSMSPTProxy();
  }
  
  public MailAndSMSPTProxy(String endpoint) {
    _endpoint = endpoint;
    _initMailAndSMSPTProxy();
  }
  
  private void _initMailAndSMSPTProxy() {
    try {
      mailAndSMSPT = (new org.sercho.MailAndSMS.MailAndSMSServiceLocator()).getMailAndSMSServiceSOAP();
      if (mailAndSMSPT != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)mailAndSMSPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)mailAndSMSPT)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (mailAndSMSPT != null)
      ((javax.xml.rpc.Stub)mailAndSMSPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.sercho.MailAndSMS.MailAndSMSPT getMailAndSMSPT() {
    if (mailAndSMSPT == null)
      _initMailAndSMSPTProxy();
    return mailAndSMSPT;
  }
  
  public boolean sendMail(java.lang.String to, java.lang.String text) throws java.rmi.RemoteException{
    if (mailAndSMSPT == null)
      _initMailAndSMSPTProxy();
    return mailAndSMSPT.sendMail(to, text);
  }
  
  public boolean sendSMS(java.lang.String to, java.lang.String text) throws java.rmi.RemoteException{
    if (mailAndSMSPT == null)
      _initMailAndSMSPTProxy();
    return mailAndSMSPT.sendSMS(to, text);
  }
  
  
}