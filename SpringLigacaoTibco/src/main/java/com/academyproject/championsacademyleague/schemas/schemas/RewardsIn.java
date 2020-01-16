//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.14 at 12:21:10 PM GMT 
//


package schemas;

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
 *       &lt;attribute name="Approved" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ChampiesGiven" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="DateOfReward" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_PlayerGiver_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_PlayerReceiver_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_Reward" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Justification" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="TimeSpent" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "RewardsIn", namespace = "http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/Rewards/Schema.xsd")
public class RewardsIn {

    @XmlAttribute(name = "Approved")
    protected String approved;
    @XmlAttribute(name = "ChampiesGiven")
    protected String champiesGiven;
    @XmlAttribute(name = "DateOfReward")
    protected String dateOfReward;
    @XmlAttribute(name = "ID_PlayerGiver_FK")
    protected String idPlayerGiverFK;
    @XmlAttribute(name = "ID_PlayerReceiver_FK")
    protected String idPlayerReceiverFK;
    @XmlAttribute(name = "ID_Reward")
    protected String idReward;
    @XmlAttribute(name = "Justification")
    protected String justification;
    @XmlAttribute(name = "TimeSpent")
    protected String timeSpent;

    /**
     * Gets the value of the approved property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApproved() {
        return approved;
    }

    /**
     * Sets the value of the approved property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApproved(String value) {
        this.approved = value;
    }

    /**
     * Gets the value of the champiesGiven property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChampiesGiven() {
        return champiesGiven;
    }

    /**
     * Sets the value of the champiesGiven property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChampiesGiven(String value) {
        this.champiesGiven = value;
    }

    /**
     * Gets the value of the dateOfReward property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfReward() {
        return dateOfReward;
    }

    /**
     * Sets the value of the dateOfReward property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfReward(String value) {
        this.dateOfReward = value;
    }

    /**
     * Gets the value of the idPlayerGiverFK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDPlayerGiverFK() {
        return idPlayerGiverFK;
    }

    /**
     * Sets the value of the idPlayerGiverFK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDPlayerGiverFK(String value) {
        this.idPlayerGiverFK = value;
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
     * Gets the value of the idReward property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDReward() {
        return idReward;
    }

    /**
     * Sets the value of the idReward property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDReward(String value) {
        this.idReward = value;
    }

    /**
     * Gets the value of the justification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJustification() {
        return justification;
    }

    /**
     * Sets the value of the justification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJustification(String value) {
        this.justification = value;
    }

    /**
     * Gets the value of the timeSpent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeSpent() {
        return timeSpent;
    }

    /**
     * Sets the value of the timeSpent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeSpent(String value) {
        this.timeSpent = value;
    }

}