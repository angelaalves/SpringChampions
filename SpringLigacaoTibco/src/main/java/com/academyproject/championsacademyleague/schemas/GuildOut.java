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
 *       &lt;attribute name="EndDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="GuildFlag" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="GuildName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_Guild" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="StartDate" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "GuildOut", namespace = "http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/Guild/Schema.xsd")
public class GuildOut {

    @XmlAttribute(name = "EndDate")
    protected String endDate;
    @XmlAttribute(name = "GuildFlag")
    protected String guildFlag;
    @XmlAttribute(name = "GuildName")
    protected String guildName;
    @XmlAttribute(name = "ID_Guild")
    protected String idGuild;
    @XmlAttribute(name = "StartDate")
    protected String startDate;
    @XmlAttribute(name = "status")
    protected String status;

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the guildFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuildFlag() {
        return guildFlag;
    }

    /**
     * Sets the value of the guildFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuildFlag(String value) {
        this.guildFlag = value;
    }

    /**
     * Gets the value of the guildName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuildName() {
        return guildName;
    }

    /**
     * Sets the value of the guildName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuildName(String value) {
        this.guildName = value;
    }

    /**
     * Gets the value of the idGuild property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDGuild() {
        return idGuild;
    }

    /**
     * Sets the value of the idGuild property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDGuild(String value) {
        this.idGuild = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
