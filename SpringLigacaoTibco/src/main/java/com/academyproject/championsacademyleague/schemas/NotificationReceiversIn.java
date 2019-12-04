//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.11.26 at 11:02:52 AM GMT 
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
 *       &lt;attribute name="ID_Guild_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_Notification_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_Notification_Receiver" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_Player_Receiver_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Notification_Seen" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "NotificationReceiversIn", namespace = "http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/NotificationReceivers/Schema.xsd")
public class NotificationReceiversIn {

    @XmlAttribute(name = "ID_Guild_FK")
    protected String idGuildFK;
    @XmlAttribute(name = "ID_Notification_FK")
    protected String idNotificationFK;
    @XmlAttribute(name = "ID_Notification_Receiver")
    protected String idNotificationReceiver;
    @XmlAttribute(name = "ID_Player_Receiver_FK")
    protected String idPlayerReceiverFK;
    @XmlAttribute(name = "Notification_Seen")
    protected String notificationSeen;

    public NotificationReceiversIn(){}

    public NotificationReceiversIn(String idGuildFK, String idNotificationFK, String idNotificationReceiver, String idPlayerReceiverFK, String notificationSeen){
        this.idGuildFK=idGuildFK;
        this.idNotificationFK=idNotificationFK;
        this.idNotificationReceiver=idNotificationReceiver;
        this.idPlayerReceiverFK=idPlayerReceiverFK;
        this.notificationSeen=notificationSeen;
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
     * Gets the value of the idNotificationFK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDNotificationFK() {
        return idNotificationFK;
    }

    /**
     * Sets the value of the idNotificationFK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDNotificationFK(String value) {
        this.idNotificationFK = value;
    }

    /**
     * Gets the value of the idNotificationReceiver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDNotificationReceiver() {
        return idNotificationReceiver;
    }

    /**
     * Sets the value of the idNotificationReceiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDNotificationReceiver(String value) {
        this.idNotificationReceiver = value;
    }

    /**
     * Gets the value of the idPlayerReceiverFK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDPlayerReceiverFK() {
        return idPlayerReceiverFK;
    }

    /**
     * Sets the value of the idPlayerReceiverFK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDPlayerReceiverFK(String value) {
        this.idPlayerReceiverFK = value;
    }

    /**
     * Gets the value of the notificationSeen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationSeen() {
        return notificationSeen;
    }

    /**
     * Sets the value of the notificationSeen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationSeen(String value) {
        this.notificationSeen = value;
    }

}
