/**
 * WSRichServiceDirectoryPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.dailab.jiactng.rsd.ws;

public interface WSRichServiceDirectoryPortType extends java.rmi.Remote {
    public java.lang.Boolean deregisterService(de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription description) throws java.rmi.RemoteException;
    public java.lang.String[] findServiceByNameSimple(java.lang.String regex) throws java.rmi.RemoteException;
    public de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription[] findServiceByKeyword(java.lang.String[] keywords) throws java.rmi.RemoteException;
    public de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription[] getAllServices() throws java.rmi.RemoteException;
    public java.lang.String registerWebServiceAndKeywordsSimple(java.lang.String wsdlUrl, java.lang.String[] keywords) throws java.rmi.RemoteException;
    public java.lang.Boolean updateService(de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription description) throws java.rmi.RemoteException;
    public java.lang.Boolean deregisterServiceSimple(java.lang.String wsdlUrl) throws java.rmi.RemoteException;
    public java.lang.String[] findServiceByKeywordsSimple(java.lang.String[] keywords) throws java.rmi.RemoteException;
    public java.lang.String updateWebServiceSimple(java.lang.String wsdlUrl, java.lang.String[] keywords) throws java.rmi.RemoteException;
    public de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription[] registerWebService(java.lang.String wsdlUrl) throws java.rmi.RemoteException;
    public de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription[] findServiceByName(java.lang.String regex) throws java.rmi.RemoteException;
    public de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription[] registerWebServiceAndKeywords(java.lang.String wsdlUrl, java.lang.String[] keywords) throws java.rmi.RemoteException;
}
