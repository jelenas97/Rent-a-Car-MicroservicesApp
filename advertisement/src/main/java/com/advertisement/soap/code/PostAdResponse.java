
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
 *         &lt;element name="idAd" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idCar" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="idPriceList" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "idAd",
    "idCar",
    "idPriceList"
})
@XmlRootElement(name = "postAdResponse", namespace = "http://localhost:8084/advertisement")
public class PostAdResponse {

    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected long idAd;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected long idCar;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected long idPriceList;

    /**
     * Gets the value of the idAd property.
     * 
     */
    public long getIdAd() {
        return idAd;
    }

    /**
     * Sets the value of the idAd property.
     * 
     */
    public void setIdAd(long value) {
        this.idAd = value;
    }

    /**
     * Gets the value of the idCar property.
     * 
     */
    public long getIdCar() {
        return idCar;
    }

    /**
     * Sets the value of the idCar property.
     * 
     */
    public void setIdCar(long value) {
        this.idCar = value;
    }

    /**
     * Gets the value of the idPriceList property.
     * 
     */
    public long getIdPriceList() {
        return idPriceList;
    }

    /**
     * Sets the value of the idPriceList property.
     * 
     */
    public void setIdPriceList(long value) {
        this.idPriceList = value;
    }

}
