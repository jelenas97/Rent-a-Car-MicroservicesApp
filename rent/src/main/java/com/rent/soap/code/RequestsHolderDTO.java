
package com.rent.soap.code;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestsHolderDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestsHolderDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rentRequests" type="{http://localhost:8095/microservices/rent}RentRequest" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="bundle" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestsHolderDTO", namespace = "http://localhost:8095/microservices/rent", propOrder = {
    "rentRequests",
    "id",
    "bundle"
})
public class RequestsHolderDTO {

    @XmlElement(namespace = "http://localhost:8095/microservices/rent", nillable = true)
    protected List<RentRequest> rentRequests;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected Long id;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected Boolean bundle;

    /**
     * Gets the value of the rentRequests property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rentRequests property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRentRequests().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RentRequest }
     * 
     * 
     */
    public List<RentRequest> getRentRequests() {
        if (rentRequests == null) {
            rentRequests = new ArrayList<RentRequest>();
        }
        return this.rentRequests;
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
     * Gets the value of the bundle property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBundle() {
        return bundle;
    }

    /**
     * Sets the value of the bundle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBundle(Boolean value) {
        this.bundle = value;
    }

}
