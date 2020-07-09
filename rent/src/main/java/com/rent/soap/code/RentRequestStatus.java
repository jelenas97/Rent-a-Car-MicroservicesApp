
package com.rent.soap.code;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rentRequestStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="rentRequestStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="RESERVED"/>
 *     &lt;enumeration value="PAID"/>
 *     &lt;enumeration value="CANCELED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "rentRequestStatus", namespace = "http://localhost:8095/microservices/rent")
@XmlEnum
public enum RentRequestStatus {

    PENDING,
    RESERVED,
    PAID,
    CANCELED;

    public String value() {
        return name();
    }

    public static RentRequestStatus fromValue(String v) {
        return valueOf(v);
    }

}
