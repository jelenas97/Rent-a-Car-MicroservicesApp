
package com.advertisement.soap.code;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for carModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="carModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carBrand" type="{http://localhost:8084/advertisement}carBrand" minOccurs="0"/>
 *         &lt;element name="car" type="{http://localhost:8084/advertisement}car" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carModel", namespace = "http://localhost:8084/advertisement", propOrder = {
    "carBrand",
    "car",
    "id",
    "name",
    "active"
})
public class CarModel {

    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected CarBrand carBrand;
    @XmlElement(namespace = "http://localhost:8084/advertisement", nillable = true)
    protected List<Car> car;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Long id;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected String name;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Boolean active;

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
     * Gets the value of the car property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the car property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCar().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Car }
     * 
     * 
     */
    public List<Car> getCar() {
        if (car == null) {
            car = new ArrayList<Car>();
        }
        return this.car;
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
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

}
