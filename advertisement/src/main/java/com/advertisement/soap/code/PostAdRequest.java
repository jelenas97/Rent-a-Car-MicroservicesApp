
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
 *         &lt;element name="ownerId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="limitKm" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cdw" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="priceList" type="{http://localhost:8084/advertisement}priceList"/>
 *         &lt;element name="car" type="{http://localhost:8084/advertisement}car"/>
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
    "ownerId",
    "startDate",
    "endDate",
    "limitKm",
    "cdw",
    "location",
    "priceList",
    "car"
})
@XmlRootElement(name = "postAdRequest", namespace = "http://localhost:8084/advertisement")
public class PostAdRequest {

    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected long ownerId;
    @XmlElement(namespace = "http://localhost:8084/advertisement", required = true)
    protected String startDate;
    @XmlElement(namespace = "http://localhost:8084/advertisement", required = true)
    protected String endDate;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected int limitKm;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected boolean cdw;
    @XmlElement(namespace = "http://localhost:8084/advertisement", required = true)
    protected String location;
    @XmlElement(namespace = "http://localhost:8084/advertisement", required = true)
    protected PriceList priceList;
    @XmlElement(namespace = "http://localhost:8084/advertisement", required = true)
    protected Car car;

    /**
     * Gets the value of the ownerId property.
     * 
     */
    public long getOwnerId() {
        return ownerId;
    }

    /**
     * Sets the value of the ownerId property.
     * 
     */
    public void setOwnerId(long value) {
        this.ownerId = value;
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
     * Gets the value of the limitKm property.
     * 
     */
    public int getLimitKm() {
        return limitKm;
    }

    /**
     * Sets the value of the limitKm property.
     * 
     */
    public void setLimitKm(int value) {
        this.limitKm = value;
    }

    /**
     * Gets the value of the cdw property.
     * 
     */
    public boolean isCdw() {
        return cdw;
    }

    /**
     * Sets the value of the cdw property.
     * 
     */
    public void setCdw(boolean value) {
        this.cdw = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the priceList property.
     * 
     * @return
     *     possible object is
     *     {@link PriceList }
     *     
     */
    public PriceList getPriceList() {
        return priceList;
    }

    /**
     * Sets the value of the priceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceList }
     *     
     */
    public void setPriceList(PriceList value) {
        this.priceList = value;
    }

    /**
     * Gets the value of the car property.
     * 
     * @return
     *     possible object is
     *     {@link Car }
     *     
     */
    public Car getCar() {
        return car;
    }

    /**
     * Sets the value of the car property.
     * 
     * @param value
     *     allowed object is
     *     {@link Car }
     *     
     */
    public void setCar(Car value) {
        this.car = value;
    }

}
