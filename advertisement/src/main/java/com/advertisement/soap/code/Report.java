
package com.advertisement.soap.code;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Report complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Report">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="kilometers" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="term" type="{http://localhost:8084/advertisement}term" minOccurs="0"/>
 *         &lt;element name="advertisement" type="{http://localhost:8084/advertisement}Advertisement" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Report", namespace = "http://localhost:8084/advertisement", propOrder = {
    "id",
    "kilometers",
    "description",
    "term",
    "advertisement"
})
public class Report {

    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Long id;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Integer kilometers;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected String description;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Term term;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected Advertisement advertisement;

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
     * Gets the value of the kilometers property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKilometers() {
        return kilometers;
    }

    /**
     * Sets the value of the kilometers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKilometers(Integer value) {
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
     * Gets the value of the term property.
     * 
     * @return
     *     possible object is
     *     {@link Term }
     *     
     */
    public Term getTerm() {
        return term;
    }

    /**
     * Sets the value of the term property.
     * 
     * @param value
     *     allowed object is
     *     {@link Term }
     *     
     */
    public void setTerm(Term value) {
        this.term = value;
    }

    /**
     * Gets the value of the advertisement property.
     * 
     * @return
     *     possible object is
     *     {@link Advertisement }
     *     
     */
    public Advertisement getAdvertisement() {
        return advertisement;
    }

    /**
     * Sets the value of the advertisement property.
     * 
     * @param value
     *     allowed object is
     *     {@link Advertisement }
     *     
     */
    public void setAdvertisement(Advertisement value) {
        this.advertisement = value;
    }

}
