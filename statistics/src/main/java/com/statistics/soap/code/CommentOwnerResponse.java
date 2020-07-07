
package com.statistics.soap.code;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="commentId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "commentId"
})
@XmlRootElement(name = "commentOwnerResponse", namespace = "http://localhost:8090/microservices/statistics")
public class CommentOwnerResponse {

    @XmlElement(namespace = "http://localhost:8090/microservices/statistics")
    protected long commentId;

    /**
     * Gets the value of the commentId property.
     * 
     */
    public long getCommentId() {
        return commentId;
    }

    /**
     * Sets the value of the commentId property.
     * 
     */
    public void setCommentId(long value) {
        this.commentId = value;
    }

}
