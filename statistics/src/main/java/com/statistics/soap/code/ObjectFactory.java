
package com.statistics.soap.code;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soapkodenesto package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soapkodenesto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCommentRequest }
     * 
     */
    public GetCommentRequest createGetCommentRequest() {
        return new GetCommentRequest();
    }

    /**
     * Create an instance of {@link CommentRequest }
     * 
     */
    public CommentRequest createCommentRequest() {
        return new CommentRequest();
    }

    /**
     * Create an instance of {@link GetCommentResponse }
     * 
     */
    public GetCommentResponse createGetCommentResponse() {
        return new GetCommentResponse();
    }

    /**
     * Create an instance of {@link CommentDTO }
     * 
     */
    public CommentDTO createCommentDTO() {
        return new CommentDTO();
    }

    /**
     * Create an instance of {@link CommentResponse }
     * 
     */
    public CommentResponse createCommentResponse() {
        return new CommentResponse();
    }

}
