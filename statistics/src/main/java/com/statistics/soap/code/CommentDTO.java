
package com.statistics.soap.code;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommentDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommentDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="advertisement_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="commenter_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="commenter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rent_request_id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommentDTO", namespace = "http://localhost:8090/microservices/statistics", propOrder = {
    "id",
    "date",
    "dateString",
    "content",
    "status",
    "advertisementId",
    "commenterId",
    "commenter",
    "rentRequestId"
})
public class CommentDTO {

    @XmlElement(namespace = "http://localhost:8090/microservices/statistics")
    protected Long id;
    @XmlElement(namespace = "http://localhost:8090/microservices/statistics")
    protected String date;
    @XmlElement(namespace = "http://localhost:8090/microservices/statistics")
    protected String dateString;
    @XmlElement(namespace = "http://localhost:8090/microservices/statistics")
    protected String content;
    @XmlElement(namespace = "http://localhost:8090/microservices/statistics")
    protected String status;
    @XmlElement(name = "advertisement_id", namespace = "http://localhost:8090/microservices/statistics")
    protected Long advertisementId;
    @XmlElement(name = "commenter_id", namespace = "http://localhost:8090/microservices/statistics")
    protected Long commenterId;
    @XmlElement(namespace = "http://localhost:8090/microservices/statistics")
    protected String commenter;
    @XmlElement(name = "rent_request_id", namespace = "http://localhost:8090/microservices/statistics")
    protected Long rentRequestId;

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
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the dateString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateString() {
        return dateString;
    }

    /**
     * Sets the value of the dateString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateString(String value) {
        this.dateString = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the advertisementId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAdvertisementId() {
        return advertisementId;
    }

    /**
     * Sets the value of the advertisementId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAdvertisementId(Long value) {
        this.advertisementId = value;
    }

    /**
     * Gets the value of the commenterId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCommenterId() {
        return commenterId;
    }

    /**
     * Sets the value of the commenterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCommenterId(Long value) {
        this.commenterId = value;
    }

    /**
     * Gets the value of the commenter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommenter() {
        return commenter;
    }

    /**
     * Sets the value of the commenter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommenter(String value) {
        this.commenter = value;
    }

    /**
     * Gets the value of the rentRequestId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRentRequestId() {
        return rentRequestId;
    }

    /**
     * Sets the value of the rentRequestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRentRequestId(Long value) {
        this.rentRequestId = value;
    }

}
