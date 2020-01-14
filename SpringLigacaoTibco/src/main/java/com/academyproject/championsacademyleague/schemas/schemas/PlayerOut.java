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
 *       &lt;attribute name="ChampiesToGive" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Email" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="Gender" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="ID_Player" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="MyChampies" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="UserName" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="UserType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="XP" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="password" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
@XmlRootElement(name = "PlayerOut", namespace = "http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/Player/Schema.xsd")
public class PlayerOut {

    @XmlAttribute(name = "ChampiesToGive")
    protected String champiesToGive;
    @XmlAttribute(name = "Email")
    protected String email;
    @XmlAttribute(name = "Gender")
    protected String gender;
    @XmlAttribute(name = "ID_Player")
    protected String idPlayer;
    @XmlAttribute(name = "MyChampies")
    protected String myChampies;
    @XmlAttribute(name = "UserName")
    protected String userName;
    @XmlAttribute(name = "UserType")
    protected String userType;
    @XmlAttribute(name = "XP")
    protected String xp;
    @XmlAttribute(name = "password")
    protected String password;
    @XmlAttribute(name = "status")
    protected String status;

    /**
     * Gets the value of the champiesToGive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChampiesToGive() {
        return champiesToGive;
    }

    /**
     * Sets the value of the champiesToGive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChampiesToGive(String value) {
        this.champiesToGive = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the idPlayer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDPlayer() {
        return idPlayer;
    }

    /**
     * Sets the value of the idPlayer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDPlayer(String value) {
        this.idPlayer = value;
    }

    /**
     * Gets the value of the myChampies property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMyChampies() {
        return myChampies;
    }

    /**
     * Sets the value of the myChampies property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMyChampies(String value) {
        this.myChampies = value;
    }

    /**
     * Gets the value of the userName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of the userName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * Gets the value of the userType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the value of the userType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserType(String value) {
        this.userType = value;
    }

    /**
     * Gets the value of the xp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXP() {
        return xp;
    }

    /**
     * Sets the value of the xp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXP(String value) {
        this.xp = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
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
