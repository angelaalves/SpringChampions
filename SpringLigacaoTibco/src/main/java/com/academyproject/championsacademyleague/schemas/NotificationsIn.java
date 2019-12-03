//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.11.29 at 01:38:33 PM GMT
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
 *       &lt;attribute name="Description" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_Event_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_Guild_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_Notification" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_Player_Sender_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_Reward_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "NotificationsIn", namespace = "http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/Notifications/Schema.xsd")
public class NotificationsIn {

    @XmlAttribute(name = "Description")
    protected String description;
    @XmlAttribute(name = "ID_Event_FK")
    protected String idEventFK;
    @XmlAttribute(name = "ID_Guild_FK")
    protected String idGuildFK;
    @XmlAttribute(name = "ID_Notification")
    protected String idNotification;
    @XmlAttribute(name = "ID_Player_Sender_FK")
    protected String idPlayerSenderFK;
    @XmlAttribute(name = "ID_Reward_FK")
    protected String idRewardFK;

    public NotificationsIn(){}

    public NotificationsIn(String idEventFK, String idGuildFK, String idNotification, String idPlayerSenderFK, String idRewardFK, String description){
        this.idEventFK=idEventFK;
        this.idGuildFK=idGuildFK;
        this.idNotification=idNotification;
        this.idPlayerSenderFK=idPlayerSenderFK;
        this.idRewardFK=idRewardFK;
        this.description=description;
    }

    /**
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the idEventFK property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIDEventFK() {
        return idEventFK;
    }

    /**
     * Sets the value of the idEventFK property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIDEventFK(String value) {
        this.idEventFK = value;
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

    /**
     * Gets the value of the idNotification property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIDNotification() {
        return idNotification;
    }

    /**
     * Sets the value of the idNotification property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIDNotification(String value) {
        this.idNotification = value;
    }

    /**
     * Gets the value of the idPlayerSenderFK property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIDPlayerSenderFK() {
        return idPlayerSenderFK;
    }

    /**
     * Sets the value of the idPlayerSenderFK property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIDPlayerSenderFK(String value) {
        this.idPlayerSenderFK = value;
    }

    /**
     * Gets the value of the idRewardFK property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIDRewardFK() {
        return idRewardFK;
    }

    /**
     * Sets the value of the idRewardFK property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIDRewardFK(String value) {
        this.idRewardFK = value;
    }

}