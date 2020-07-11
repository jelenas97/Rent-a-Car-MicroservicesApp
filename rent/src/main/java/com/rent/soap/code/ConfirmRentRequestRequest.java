
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
 *         &lt;element name="request" type="{http://localhost:8095/microservices/rent}RentRequest" minOccurs="0"/>
 *         &lt;element name="confirm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "request",
    "confirm"
})
@XmlRootElement(name = "confirmRentRequestRequest", namespace = "http://localhost:8095/microservices/rent")
public class ConfirmRentRequestRequest {

    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected RentRequest request;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected String confirm;

    /**
     * Gets the value of the request property.
     * 
     * @return
     *     possible object is
     *     {@link RentRequest }
     *     
     */
    public RentRequest getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *     allowed object is
     *     {@link RentRequest }
     *     
     */
    public void setRequest(RentRequest value) {
        this.request = value;
    }

    /**
     * Gets the value of the confirm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirm() {
        return confirm;
    }

    /**
     * Sets the value of the confirm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirm(String value) {
        this.confirm = value;
    }

}
