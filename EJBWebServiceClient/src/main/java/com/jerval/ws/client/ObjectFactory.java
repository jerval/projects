
package com.jerval.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jerval.ws.client package. 
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

    private final static QName _FindOrdersResponse_QNAME = new QName("http://ws.jerval.com", "findOrdersResponse");
    private final static QName _FindOrderResponse_QNAME = new QName("http://ws.jerval.com", "findOrderResponse");
    private final static QName _FindOrder_QNAME = new QName("http://ws.jerval.com", "findOrder");
    private final static QName _FindUserName_QNAME = new QName("http://ws.jerval.com", "findUserName");
    private final static QName _FindOrders_QNAME = new QName("http://ws.jerval.com", "findOrders");
    private final static QName _FindUserNameResponse_QNAME = new QName("http://ws.jerval.com", "findUserNameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jerval.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindOrdersResponse }
     * 
     */
    public FindOrdersResponse createFindOrdersResponse() {
        return new FindOrdersResponse();
    }

    /**
     * Create an instance of {@link FindOrderResponse }
     * 
     */
    public FindOrderResponse createFindOrderResponse() {
        return new FindOrderResponse();
    }

    /**
     * Create an instance of {@link FindOrder }
     * 
     */
    public FindOrder createFindOrder() {
        return new FindOrder();
    }

    /**
     * Create an instance of {@link Order }
     * 
     */
    public Order createOrder() {
        return new Order();
    }

    /**
     * Create an instance of {@link FindUserNameResponse }
     * 
     */
    public FindUserNameResponse createFindUserNameResponse() {
        return new FindUserNameResponse();
    }

    /**
     * Create an instance of {@link FindOrders }
     * 
     */
    public FindOrders createFindOrders() {
        return new FindOrders();
    }

    /**
     * Create an instance of {@link FindUserName }
     * 
     */
    public FindUserName createFindUserName() {
        return new FindUserName();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOrdersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.jerval.com", name = "findOrdersResponse")
    public JAXBElement<FindOrdersResponse> createFindOrdersResponse(FindOrdersResponse value) {
        return new JAXBElement<FindOrdersResponse>(_FindOrdersResponse_QNAME, FindOrdersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.jerval.com", name = "findOrderResponse")
    public JAXBElement<FindOrderResponse> createFindOrderResponse(FindOrderResponse value) {
        return new JAXBElement<FindOrderResponse>(_FindOrderResponse_QNAME, FindOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.jerval.com", name = "findOrder")
    public JAXBElement<FindOrder> createFindOrder(FindOrder value) {
        return new JAXBElement<FindOrder>(_FindOrder_QNAME, FindOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.jerval.com", name = "findUserName")
    public JAXBElement<FindUserName> createFindUserName(FindUserName value) {
        return new JAXBElement<FindUserName>(_FindUserName_QNAME, FindUserName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOrders }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.jerval.com", name = "findOrders")
    public JAXBElement<FindOrders> createFindOrders(FindOrders value) {
        return new JAXBElement<FindOrders>(_FindOrders_QNAME, FindOrders.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindUserNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.jerval.com", name = "findUserNameResponse")
    public JAXBElement<FindUserNameResponse> createFindUserNameResponse(FindUserNameResponse value) {
        return new JAXBElement<FindUserNameResponse>(_FindUserNameResponse_QNAME, FindUserNameResponse.class, null, value);
    }

}
