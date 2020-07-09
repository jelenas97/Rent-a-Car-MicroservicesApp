
package com.messages.soap.code;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="idMessage" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "idMessage"
})
@XmlRootElement(name = "postMessageResponse", namespace = "http://localhost:8087/microservices/messages")
public class PostMessageResponse {

    protected long idMessage;

    /**
     * Gets the value of the idMessage property.
     * 
     */
    public long getIdMessage() {
        return idMessage;
    }

    /**
     * Sets the value of the idMessage property.
     * 
     */
    public void setIdMessage(long value) {
        this.idMessage = value;
    }

}
