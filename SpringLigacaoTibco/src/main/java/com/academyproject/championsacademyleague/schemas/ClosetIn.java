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
 *       &lt;attribute name="ID_Skin_FK" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="id_player_fk" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
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
@XmlRootElement(name = "ClosetIn", namespace = "http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/Closet/Schema.xsd")
public class ClosetIn {

    @XmlAttribute(name = "ID_Skin_FK")
    protected String idSkinFK;
    @XmlAttribute(name = "ID_Player_FK")
    protected String idPlayerFk;
    @XmlAttribute(name = "status")
    protected String status;

    public ClosetIn(){}

    public ClosetIn(String idSkinFK, String idPlayerFk, String status){
        this.idSkinFK=idSkinFK;
        this.idPlayerFk=idPlayerFk;
        this.status=status;
    }

    /**
     * Gets the value of the idSkinFK property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDSkinFK() {
        return idSkinFK;
    }

    /**
     * Sets the value of the idSkinFK property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDSkinFK(String value) {
        this.idSkinFK = value;
    }

    /**
     * Gets the value of the idPlayerFk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPlayerFk() {
        return idPlayerFk;
    }

    /**
     * Sets the value of the idPlayerFk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPlayerFk(String value) {
        this.idPlayerFk = value;
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
