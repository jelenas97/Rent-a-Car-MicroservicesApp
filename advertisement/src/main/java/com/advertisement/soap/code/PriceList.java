
package com.advertisement.soap.code;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for priceList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="priceList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="creatorId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="pricePerDay" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="pricePerKm" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="cdw" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="advertisement" type="{http://localhost:8084/advertisement}Advertisement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "priceList", namespace = "http://localhost:8084/advertisement", propOrder = {
    "id",
    "creatorId",
    "pricePerDay",
    "pricePerKm",
    "cdw",
    "advertisement"
})
public class PriceList {

    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Long id;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Long creatorId;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Double pricePerDay;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Double pricePerKm;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Double cdw;
    @XmlElement(namespace = "http://localhost:8084/advertisement", nillable = true)
    protected List<Advertisement> advertisement;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the creatorId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * Sets the value of the creatorId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreatorId(Long value) {
        this.creatorId = value;
    }

    /**
     * Gets the value of the pricePerDay property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPricePerDay() {
        return pricePerDay;
    }

    /**
     * Sets the value of the pricePerDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPricePerDay(Double value) {
        this.pricePerDay = value;
    }

    /**
     * Gets the value of the pricePerKm property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPricePerKm() {
        return pricePerKm;
    }

    /**
     * Sets the value of the pricePerKm property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPricePerKm(Double value) {
        this.pricePerKm = value;
    }

    /**
     * Gets the value of the cdw property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCdw() {
        return cdw;
    }

    /**
     * Sets the value of the cdw property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCdw(Double value) {
        this.cdw = value;
    }

    /**
     * Gets the value of the advertisement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the advertisement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdvertisement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Advertisement }
     * 
     * 
     */
    public List<Advertisement> getAdvertisement() {
        if (advertisement == null) {
            advertisement = new ArrayList<Advertisement>();
        }
        return this.advertisement;
    }

}
