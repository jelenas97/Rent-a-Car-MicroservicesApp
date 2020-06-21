
package com.rent.soap.code;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RentRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RentRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="startDateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDateString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDateString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rentRequestStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cars" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advertisementId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="senderId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numberOfUnseen" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RentRequest", namespace = "http://localhost:8095/microservices/rent", propOrder = {
    "id",
    "startDateTime",
    "endDateTime",
    "startDateString",
    "endDateString",
    "rentRequestStatus",
    "cars",
    "advertisementId",
    "senderId",
    "numberOfUnseen"
})
public class RentRequest {

    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected Long id;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected String startDateTime;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected String endDateTime;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected String startDateString;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected String endDateString;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected String rentRequestStatus;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected String cars;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected Long advertisementId;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected Long senderId;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected int numberOfUnseen;

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
     * Gets the value of the startDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDateTime() {
        return startDateTime;
    }

    /**
     * Sets the value of the startDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDateTime(String value) {
        this.startDateTime = value;
    }

    /**
     * Gets the value of the endDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDateTime() {
        return endDateTime;
    }

    /**
     * Sets the value of the endDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDateTime(String value) {
        this.endDateTime = value;
    }

    /**
     * Gets the value of the startDateString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDateString() {
        return startDateString;
    }

    /**
     * Sets the value of the startDateString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDateString(String value) {
        this.startDateString = value;
    }

    /**
     * Gets the value of the endDateString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDateString() {
        return endDateString;
    }

    /**
     * Sets the value of the endDateString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDateString(String value) {
        this.endDateString = value;
    }

    /**
     * Gets the value of the rentRequestStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRentRequestStatus() {
        return rentRequestStatus;
    }

    /**
     * Sets the value of the rentRequestStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRentRequestStatus(String value) {
        this.rentRequestStatus = value;
    }

    /**
     * Gets the value of the cars property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCars() {
        return cars;
    }

    /**
     * Sets the value of the cars property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCars(String value) {
        this.cars = value;
    }

    /**
     * Gets the value of the advertisementId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdvertisementId() {
        return advertisementId;
    }

    /**
     * Sets the value of the advertisementId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdvertisementId(Long value) {
        this.advertisementId = value;
    }

    /**
     * Gets the value of the senderId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSenderId() {
        return senderId;
    }

    /**
     * Sets the value of the senderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSenderId(Long value) {
        this.senderId = value;
    }

    /**
     * Gets the value of the numberOfUnseen property.
     * 
     */
    public int getNumberOfUnseen() {
        return numberOfUnseen;
    }

    /**
     * Sets the value of the numberOfUnseen property.
     * 
     */
    public void setNumberOfUnseen(int value) {
        this.numberOfUnseen = value;
    }

}
