
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
 *         &lt;element name="reportId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="termId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="advertisementId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "reportId",
    "termId",
    "advertisementId"
})
@XmlRootElement(name = "postReportResponse", namespace = "http://localhost:8084/advertisement")
public class PostReportResponse {

    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected long reportId;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected long termId;
    @XmlElement(namespace = "http://localhost:8084/advertisement")
    protected long advertisementId;

    /**
     * Gets the value of the reportId property.
     * 
     */
    public long getReportId() {
        return reportId;
    }

    /**
     * Sets the value of the reportId property.
     * 
     */
    public void setReportId(long value) {
        this.reportId = value;
    }

    /**
     * Gets the value of the termId property.
     * 
     */
    public long getTermId() {
        return termId;
    }

    /**
     * Sets the value of the termId property.
     * 
     */
    public void setTermId(long value) {
        this.termId = value;
    }

    /**
     * Gets the value of the advertisementId property.
     * 
     */
    public long getAdvertisementId() {
        return advertisementId;
    }

    /**
     * Sets the value of the advertisementId property.
     * 
     */
    public void setAdvertisementId(long value) {
        this.advertisementId = value;
    }

}
