//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.10.30 at 02:37:15 PM GMT 
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
 *       &lt;attribute name="ID_Events_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_Guild_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "GuildEventsOut", namespace = "http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/GuildEvents/Schema.xsd")
public class GuildEventsOut {

    @XmlAttribute(name = "ID_Events_FK")
    protected String idEventsFK;
    @XmlAttribute(name = "ID_Guild_FK")
    protected String idGuildFK;

    public GuildEventsOut(){}

    public GuildEventsOut(String idGuildFK, String idEventsFK){
        this.idGuildFK=idGuildFK;
        this.idEventsFK=idEventsFK;
    }

    /**
     * Gets the value of the idEventsFK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDEventsFK() {
        return idEventsFK;
    }

    /**
     * Sets the value of the idEventsFK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDEventsFK(String value) {
        this.idEventsFK = value;
    }

    /**
     * Gets the value of the idGuildFK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDGuildFK() {
        return idGuildFK;
    }

    /**
     * Sets the value of the idGuildFK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDGuildFK(String value) {
        this.idGuildFK = value;
    }

}
