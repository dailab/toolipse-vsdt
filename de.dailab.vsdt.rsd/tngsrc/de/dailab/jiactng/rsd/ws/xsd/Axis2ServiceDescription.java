/**
 * Axis2ServiceDescription.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.dailab.jiactng.rsd.ws.xsd;

public class Axis2ServiceDescription  implements java.io.Serializable {
	
	private static final long serialVersionUID = 3546992841915131700L;

	private java.util.Calendar expireDate;

    private java.lang.String id;

    private de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter[] inputParams;

    private de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter inputWrapper;

    private java.lang.String[] keywords;

    private java.lang.String name;

    private de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter[] outputParams;

    private java.lang.String postCondition;

    private java.lang.String preCondition;

    private java.lang.String providerAddress;

    private java.lang.String qoSRating;

    private java.lang.String wsdl;

    private java.lang.String wsdlUrl;

    public Axis2ServiceDescription() {
    }

    public Axis2ServiceDescription(
           java.util.Calendar expireDate,
           java.lang.String id,
           de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter[] inputParams,
           de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter inputWrapper,
           java.lang.String[] keywords,
           java.lang.String name,
           de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter[] outputParams,
           java.lang.String postCondition,
           java.lang.String preCondition,
           java.lang.String providerAddress,
           java.lang.String qoSRating,
           java.lang.String wsdl,
           java.lang.String wsdlUrl) {
           this.expireDate = expireDate;
           this.id = id;
           this.inputParams = inputParams;
           this.inputWrapper = inputWrapper;
           this.keywords = keywords;
           this.name = name;
           this.outputParams = outputParams;
           this.postCondition = postCondition;
           this.preCondition = preCondition;
           this.providerAddress = providerAddress;
           this.qoSRating = qoSRating;
           this.wsdl = wsdl;
           this.wsdlUrl = wsdlUrl;
    }


    /**
     * Gets the expireDate value for this Axis2ServiceDescription.
     * 
     * @return expireDate
     */
    public java.util.Calendar getExpireDate() {
        return expireDate;
    }


    /**
     * Sets the expireDate value for this Axis2ServiceDescription.
     * 
     * @param expireDate
     */
    public void setExpireDate(java.util.Calendar expireDate) {
        this.expireDate = expireDate;
    }


    /**
     * Gets the id value for this Axis2ServiceDescription.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this Axis2ServiceDescription.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the inputParams value for this Axis2ServiceDescription.
     * 
     * @return inputParams
     */
    public de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter[] getInputParams() {
        return inputParams;
    }


    /**
     * Sets the inputParams value for this Axis2ServiceDescription.
     * 
     * @param inputParams
     */
    public void setInputParams(de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter[] inputParams) {
        this.inputParams = inputParams;
    }

    public de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter getInputParams(int i) {
        return this.inputParams[i];
    }

    public void setInputParams(int i, de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter _value) {
        this.inputParams[i] = _value;
    }


    /**
     * Gets the inputWrapper value for this Axis2ServiceDescription.
     * 
     * @return inputWrapper
     */
    public de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter getInputWrapper() {
        return inputWrapper;
    }


    /**
     * Sets the inputWrapper value for this Axis2ServiceDescription.
     * 
     * @param inputWrapper
     */
    public void setInputWrapper(de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter inputWrapper) {
        this.inputWrapper = inputWrapper;
    }


    /**
     * Gets the keywords value for this Axis2ServiceDescription.
     * 
     * @return keywords
     */
    public java.lang.String[] getKeywords() {
        return keywords;
    }


    /**
     * Sets the keywords value for this Axis2ServiceDescription.
     * 
     * @param keywords
     */
    public void setKeywords(java.lang.String[] keywords) {
        this.keywords = keywords;
    }

    public java.lang.String getKeywords(int i) {
        return this.keywords[i];
    }

    public void setKeywords(int i, java.lang.String _value) {
        this.keywords[i] = _value;
    }


    /**
     * Gets the name value for this Axis2ServiceDescription.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Axis2ServiceDescription.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the outputParams value for this Axis2ServiceDescription.
     * 
     * @return outputParams
     */
    public de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter[] getOutputParams() {
        return outputParams;
    }


    /**
     * Sets the outputParams value for this Axis2ServiceDescription.
     * 
     * @param outputParams
     */
    public void setOutputParams(de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter[] outputParams) {
        this.outputParams = outputParams;
    }

    public de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter getOutputParams(int i) {
        return this.outputParams[i];
    }

    public void setOutputParams(int i, de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter _value) {
        this.outputParams[i] = _value;
    }


    /**
     * Gets the postCondition value for this Axis2ServiceDescription.
     * 
     * @return postCondition
     */
    public java.lang.String getPostCondition() {
        return postCondition;
    }


    /**
     * Sets the postCondition value for this Axis2ServiceDescription.
     * 
     * @param postCondition
     */
    public void setPostCondition(java.lang.String postCondition) {
        this.postCondition = postCondition;
    }


    /**
     * Gets the preCondition value for this Axis2ServiceDescription.
     * 
     * @return preCondition
     */
    public java.lang.String getPreCondition() {
        return preCondition;
    }


    /**
     * Sets the preCondition value for this Axis2ServiceDescription.
     * 
     * @param preCondition
     */
    public void setPreCondition(java.lang.String preCondition) {
        this.preCondition = preCondition;
    }


    /**
     * Gets the providerAddress value for this Axis2ServiceDescription.
     * 
     * @return providerAddress
     */
    public java.lang.String getProviderAddress() {
        return providerAddress;
    }


    /**
     * Sets the providerAddress value for this Axis2ServiceDescription.
     * 
     * @param providerAddress
     */
    public void setProviderAddress(java.lang.String providerAddress) {
        this.providerAddress = providerAddress;
    }


    /**
     * Gets the qoSRating value for this Axis2ServiceDescription.
     * 
     * @return qoSRating
     */
    public java.lang.String getQoSRating() {
        return qoSRating;
    }


    /**
     * Sets the qoSRating value for this Axis2ServiceDescription.
     * 
     * @param qoSRating
     */
    public void setQoSRating(java.lang.String qoSRating) {
        this.qoSRating = qoSRating;
    }


    /**
     * Gets the wsdl value for this Axis2ServiceDescription.
     * 
     * @return wsdl
     */
    public java.lang.String getWsdl() {
        return wsdl;
    }


    /**
     * Sets the wsdl value for this Axis2ServiceDescription.
     * 
     * @param wsdl
     */
    public void setWsdl(java.lang.String wsdl) {
        this.wsdl = wsdl;
    }


    /**
     * Gets the wsdlUrl value for this Axis2ServiceDescription.
     * 
     * @return wsdlUrl
     */
    public java.lang.String getWsdlUrl() {
        return wsdlUrl;
    }


    /**
     * Sets the wsdlUrl value for this Axis2ServiceDescription.
     * 
     * @param wsdlUrl
     */
    public void setWsdlUrl(java.lang.String wsdlUrl) {
        this.wsdlUrl = wsdlUrl;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Axis2ServiceDescription)) return false;
        Axis2ServiceDescription other = (Axis2ServiceDescription) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.expireDate==null && other.getExpireDate()==null) || 
             (this.expireDate!=null &&
              this.expireDate.equals(other.getExpireDate()))) &&
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.inputParams==null && other.getInputParams()==null) || 
             (this.inputParams!=null &&
              java.util.Arrays.equals(this.inputParams, other.getInputParams()))) &&
            ((this.inputWrapper==null && other.getInputWrapper()==null) || 
             (this.inputWrapper!=null &&
              this.inputWrapper.equals(other.getInputWrapper()))) &&
            ((this.keywords==null && other.getKeywords()==null) || 
             (this.keywords!=null &&
              java.util.Arrays.equals(this.keywords, other.getKeywords()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.outputParams==null && other.getOutputParams()==null) || 
             (this.outputParams!=null &&
              java.util.Arrays.equals(this.outputParams, other.getOutputParams()))) &&
            ((this.postCondition==null && other.getPostCondition()==null) || 
             (this.postCondition!=null &&
              this.postCondition.equals(other.getPostCondition()))) &&
            ((this.preCondition==null && other.getPreCondition()==null) || 
             (this.preCondition!=null &&
              this.preCondition.equals(other.getPreCondition()))) &&
            ((this.providerAddress==null && other.getProviderAddress()==null) || 
             (this.providerAddress!=null &&
              this.providerAddress.equals(other.getProviderAddress()))) &&
            ((this.qoSRating==null && other.getQoSRating()==null) || 
             (this.qoSRating!=null &&
              this.qoSRating.equals(other.getQoSRating()))) &&
            ((this.wsdl==null && other.getWsdl()==null) || 
             (this.wsdl!=null &&
              this.wsdl.equals(other.getWsdl()))) &&
            ((this.wsdlUrl==null && other.getWsdlUrl()==null) || 
             (this.wsdlUrl!=null &&
              this.wsdlUrl.equals(other.getWsdlUrl())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getExpireDate() != null) {
            _hashCode += getExpireDate().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getInputParams() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInputParams());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInputParams(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInputWrapper() != null) {
            _hashCode += getInputWrapper().hashCode();
        }
        if (getKeywords() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getKeywords());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getKeywords(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getOutputParams() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOutputParams());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOutputParams(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPostCondition() != null) {
            _hashCode += getPostCondition().hashCode();
        }
        if (getPreCondition() != null) {
            _hashCode += getPreCondition().hashCode();
        }
        if (getProviderAddress() != null) {
            _hashCode += getProviderAddress().hashCode();
        }
        if (getQoSRating() != null) {
            _hashCode += getQoSRating().hashCode();
        }
        if (getWsdl() != null) {
            _hashCode += getWsdl().hashCode();
        }
        if (getWsdlUrl() != null) {
            _hashCode += getWsdlUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Axis2ServiceDescription.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "Axis2ServiceDescription"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expireDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "expireDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "inputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicediscovery.agentcore.jiactng.dailab.de/xsd", "ServiceParameter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inputWrapper");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "inputWrapper"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicediscovery.agentcore.jiactng.dailab.de/xsd", "ServiceParameter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keywords");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "keywords"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outputParams");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "outputParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servicediscovery.agentcore.jiactng.dailab.de/xsd", "ServiceParameter"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("postCondition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "postCondition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preCondition");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "preCondition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("providerAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "providerAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qoSRating");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "qoSRating"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wsdl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "wsdl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wsdlUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de/xsd", "wsdlUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
