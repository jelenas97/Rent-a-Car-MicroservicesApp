
package com.advertisement.soap.code;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statisticDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statisticDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="km" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="rate" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "statisticDTO", namespace = "http://localhost:8084/advertisement", propOrder = {
    "carName",
    "km",
    "rate",
    "comment"
})
public class StatisticDTO {

    @XmlElement(namespace = "http://localhost:8084/advertisement", required = true)
    protected String carName;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected long km;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected double rate;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected long comment;

    /**
     * Gets the value of the carName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarName() {
        return carName;
    }

    /**
     * Sets the value of the carName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarName(String value) {
        this.carName = value;
    }

    /**
     * Gets the value of the km property.
     * 
     */
    public long getKm() {
        return km;
    }

    /**
     * Sets the value of the km property.
     * 
     */
    public void setKm(long value) {
        this.km = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     */
    public double getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     */
    public void setRate(double value) {
        this.rate = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     */
    public long getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     */
    public void setComment(long value) {
        this.comment = value;
    }

}
