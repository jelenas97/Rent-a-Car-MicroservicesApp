
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
 *         &lt;element name="requestsHolder" type="{http://localhost:8095/microservices/rent}RequestsHolderDTO" minOccurs="0"/>
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
    "requestsHolder",
    "confirm"
})
@XmlRootElement(name = "confirmRequestHolderRequest", namespace = "http://localhost:8095/microservices/rent")
public class ConfirmRequestHolderRequest {

    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected RequestsHolderDTO requestsHolder;
    @XmlElement(namespace = "http://localhost:8095/microservices/rent")
    protected String confirm;

    /**
     * Gets the value of the requestsHolder property.
     * 
     * @return
     *     possible object is
     *     {@link RequestsHolderDTO }
     *     
     */
    public RequestsHolderDTO getRequestsHolder() {
        return requestsHolder;
    }

    /**
     * Sets the value of the requestsHolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestsHolderDTO }
     *     
     */
    public void setRequestsHolder(RequestsHolderDTO value) {
        this.requestsHolder = value;
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
