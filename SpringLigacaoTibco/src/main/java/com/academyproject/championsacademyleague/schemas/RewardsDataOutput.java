//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.10.30 at 02:37:15 PM GMT
//


package com.academyproject.championsacademyleague.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/Rewards/Schema.xsd}RewardsOut" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rewardsOut"
})
@XmlRootElement(name = "RewardsDataOutput", namespace = "http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/Rewards/Schema.xsd")
public class RewardsDataOutput {

    @XmlElement(name = "RewardsOut", namespace = "http://www.tibco.com/schemas/TheChampionsAcademyLeague/Service/Rewards/Schema.xsd")
    protected List<RewardsOut> rewardsOut;

    public RewardsDataOutput(){}

    public RewardsDataOutput(List<RewardsOut> rewardsOut) {
        this.rewardsOut = rewardsOut;
    }

    /**
     * Gets the value of the rewardsOut property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rewardsOut property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRewardsOut().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RewardsOut }
     *
     *
     */
    public List<RewardsOut> getRewardsOut() {
        if (rewardsOut == null) {
            rewardsOut = new ArrayList<RewardsOut>();
        }
        return this.rewardsOut;
    }

}
