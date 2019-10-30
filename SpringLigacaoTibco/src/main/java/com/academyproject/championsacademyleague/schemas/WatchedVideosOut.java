//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.10.25 at 05:33:08 PM BST 
//


package com.academyproject.championsacademyleague.schemas;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="ID_Player_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_Video_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "WatchedVideosOut", namespace = "http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/WatchedVideos/Schema.xsd")
public class WatchedVideosOut {

    @XmlAttribute(name = "ID_Player_FK")
    protected String idPlayerFK;
    @XmlAttribute(name = "ID_Video_FK")
    protected String idVideoFK;

    public WatchedVideosOut() {

    }

    public WatchedVideosOut(String idVideoFK, String idPlayerFK) {
        this.idPlayerFK = idPlayerFK;
        this.idVideoFK = idVideoFK;
    }

    /**
     * Gets the value of the idPlayerFK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDPlayerFK() {
        return idPlayerFK;
    }

    /**
     * Sets the value of the idPlayerFK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDPlayerFK(String value) {
        this.idPlayerFK = value;
    }

    /**
     * Gets the value of the idVideoFK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDVideoFK() {
        return idVideoFK;
    }

    /**
     * Sets the value of the idVideoFK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDVideoFK(String value) {
        this.idVideoFK = value;
    }

}
