
package com.advertisement.soap.code;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for car complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="car">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carClass" type="{http://localhost:8084/advertisement}carClass" minOccurs="0"/>
 *         &lt;element name="carBrand" type="{http://localhost:8084/advertisement}carBrand" minOccurs="0"/>
 *         &lt;element name="carModel" type="{http://localhost:8084/advertisement}carModel" minOccurs="0"/>
 *         &lt;element name="transmissionType" type="{http://localhost:8084/advertisement}transmissionType" minOccurs="0"/>
 *         &lt;element name="fuelType" type="{http://localhost:8084/advertisement}fuelType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="mileage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="kidSeats" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="availableTracking" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="imageGallery" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "car", namespace = "http://localhost:8084/advertisement", propOrder = {
    "carClass",
    "carBrand",
    "carModel",
    "transmissionType",
    "fuelType",
    "id",
    "name",
    "rate",
    "mileage",
    "kidSeats",
    "availableTracking",
    "imageGallery"
})
public class Car {

    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected CarClass carClass;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected CarBrand carBrand;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected CarModel carModel;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected TransmissionType transmissionType;
    @XmlElement(namespace = "http://localhost:8084/advertisement", nillable = true)
    protected List<FuelType> fuelType;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Long id;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected String name;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Double rate;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Integer mileage;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Integer kidSeats;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Boolean availableTracking;
    @XmlElement(namespace = "http://localhost:8084/advertisement", nillable = true)
    protected List<String> imageGallery;

    /**
     * Gets the value of the carClass property.
     * 
     * @return
     *     possible object is
     *     {@link CarClass }
     *     
     */
    public CarClass getCarClass() {
        return carClass;
    }

    /**
     * Sets the value of the carClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarClass }
     *     
     */
    public void setCarClass(CarClass value) {
        this.carClass = value;
    }

    /**
     * Gets the value of the carBrand property.
     * 
     * @return
     *     possible object is
     *     {@link CarBrand }
     *     
     */
    public CarBrand getCarBrand() {
        return carBrand;
    }

    /**
     * Sets the value of the carBrand property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarBrand }
     *     
     */
    public void setCarBrand(CarBrand value) {
        this.carBrand = value;
    }

    /**
     * Gets the value of the carModel property.
     * 
     * @return
     *     possible object is
     *     {@link CarModel }
     *     
     */
    public CarModel getCarModel() {
        return carModel;
    }

    /**
     * Sets the value of the carModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarModel }
     *     
     */
    public void setCarModel(CarModel value) {
        this.carModel = value;
    }

    /**
     * Gets the value of the transmissionType property.
     * 
     * @return
     *     possible object is
     *     {@link TransmissionType }
     *     
     */
    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    /**
     * Sets the value of the transmissionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransmissionType }
     *     
     */
    public void setTransmissionType(TransmissionType value) {
        this.transmissionType = value;
    }

    /**
     * Gets the value of the fuelType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fuelType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFuelType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FuelType }
     * 
     * 
     */
    public List<FuelType> getFuelType() {
        if (fuelType == null) {
            fuelType = new ArrayList<FuelType>();
        }
        return this.fuelType;
    }

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRate(Double value) {
        this.rate = value;
    }

    /**
     * Gets the value of the mileage property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMileage() {
        return mileage;
    }

    /**
     * Sets the value of the mileage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMileage(Integer value) {
        this.mileage = value;
    }

    /**
     * Gets the value of the kidSeats property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKidSeats() {
        return kidSeats;
    }

    /**
     * Sets the value of the kidSeats property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKidSeats(Integer value) {
        this.kidSeats = value;
    }

    /**
     * Gets the value of the availableTracking property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAvailableTracking() {
        return availableTracking;
    }

    /**
     * Sets the value of the availableTracking property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAvailableTracking(Boolean value) {
        this.availableTracking = value;
    }

    /**
     * Gets the value of the imageGallery property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the imageGallery property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImageGallery().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getImageGallery() {
        if (imageGallery == null) {
            imageGallery = new ArrayList<String>();
        }
        return this.imageGallery;
    }

}
