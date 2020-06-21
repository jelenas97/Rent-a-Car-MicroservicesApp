
package com.rent.soap.code;

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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="advertisementId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="holderId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "advertisementId",
    "holderId"
})
@XmlRootElement(name = "physicalRentResponse", namespace = "http://localhost:8095/microservices/rent")
public class PhysicalRentResponse {

    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected long advertisementId;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected long holderId;

    /**
     * Gets the value of the advertisementId property.
     * 
     */
    public long getAdvertisementId() {
        return advertisementId;
    }

    /**
     * Sets the value of the advertisementId property.
     * 
     */
    public void setAdvertisementId(long value) {
        this.advertisementId = value;
    }

    /**
     * Gets the value of the holderId property.
     * 
     */
    public long getHolderId() {
        return holderId;
    }

    /**
     * Sets the value of the holderId property.
     * 
     */
    public void setHolderId(long value) {
        this.holderId = value;
    }

}
