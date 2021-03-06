
package com.advertisement.soap.code;

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
 *         &lt;element name="kilometers" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="termId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="advertisementId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "kilometers",
    "description",
    "termId",
    "advertisementId"
})
@XmlRootElement(name = "postReportRequest", namespace = "http://localhost:8084/advertisement")
public class PostReportRequest {

    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected int kilometers;
    @XmlElement(namespace = "http://localhost:8084/advertisement", required = true)
    protected String description;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected long termId;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected long advertisementId;

    /**
     * Gets the value of the kilometers property.
     * 
     */
    public int getKilometers() {
        return kilometers;
    }

    /**
     * Sets the value of the kilometers property.
     * 
     */
    public void setKilometers(int value) {
        this.kilometers = value;
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
     * Gets the value of the termId property.
     * 
     */
    public long getTermId() {
        return termId;
    }

    /**
     * Sets the value of the termId property.
     * 
     */
    public void setTermId(long value) {
        this.termId = value;
    }

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

}
