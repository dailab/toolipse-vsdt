//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.2-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.02.18 at 01:00:24 PM CET 
//


package com.ivistar.glt.ipproxy.gen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ivistar.vistaroom.util.configuration.vroom package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _VroomControl_QNAME = new QName("", "vroomControl");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ivistar.vistaroom.util.configuration.vroom
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AnalogControl }
     * 
     */
    public AnalogControl createAnalogControl() {
        return new AnalogControl();
    }

    /**
     * Create an instance of {@link AnalogIpComponent }
     * 
     */
    public AnalogIpComponent createAnalogIpComponent() {
        return new AnalogIpComponent();
    }

    /**
     * Create an instance of {@link VroomControl }
     * 
     */
    public VroomControl createVroomControl() {
        return new VroomControl();
    }

    /**
     * Create an instance of {@link ControlGroup }
     * 
     */
    public ControlGroup createControlGroup() {
        return new ControlGroup();
    }

    /**
     * Create an instance of {@link DigitalControl }
     * 
     */
    public DigitalControl createDigitalControl() {
        return new DigitalControl();
    }

    /**
     * Create an instance of {@link DigitalIpComponent }
     * 
     */
    public DigitalIpComponent createDigitalIpComponent() {
        return new DigitalIpComponent();
    }

    /**
     * Create an instance of {@link SceneSelector }
     * 
     */
    public SceneSelector createSceneSelector() {
        return new SceneSelector();
    }

    /**
     * Create an instance of {@link CommHandler }
     * 
     */
    public CommHandler createCommHandler() {
        return new CommHandler();
    }

    /**
     * Create an instance of {@link Title }
     * 
     */
    public Title createTitle() {
        return new Title();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VroomControl }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "vroomControl")
    public JAXBElement<VroomControl> createVroomControl(VroomControl value) {
        return new JAXBElement<VroomControl>(_VroomControl_QNAME, VroomControl.class, null, value);
    }

}
