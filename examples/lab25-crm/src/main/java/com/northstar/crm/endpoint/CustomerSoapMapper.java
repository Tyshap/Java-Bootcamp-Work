package com.northstar.crm.endpoint;

import com.northstar.crm.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerSoapMapper {

    public String customerIdFromGetRequest(Object request) {
        String ns = "http://northstar.com/crm/customers";
        try {
            org.w3c.dom.Element root = null;
            if (request instanceof org.w3c.dom.Element) {
                root = (org.w3c.dom.Element) request;
            } else if (request instanceof javax.xml.transform.dom.DOMSource) {
                java.lang.Object node = ((javax.xml.transform.dom.DOMSource) request).getNode();
                if (node instanceof org.w3c.dom.Element) root = (org.w3c.dom.Element) node;
            } else if (request instanceof org.w3c.dom.Node) {
                java.lang.Object node = request;
                if (node instanceof org.w3c.dom.Element) root = (org.w3c.dom.Element) node;
            }

            if (root != null) {
                org.w3c.dom.NodeList nl = root.getElementsByTagNameNS(ns, "customerId");
                if (nl != null && nl.getLength() > 0) return nl.item(0).getTextContent();
                nl = root.getElementsByTagName("customerId");
                if (nl != null && nl.getLength() > 0) return nl.item(0).getTextContent();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse GetCustomerRequest", e);
        }
        throw new IllegalArgumentException("customerId not found in request");
    }

    public Object toGetCustomerResponse(Customer customer) {
        try {
            javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = db.newDocument();
            String ns = "http://northstar.com/crm/customers";

            org.w3c.dom.Element resp = doc.createElementNS(ns, "GetCustomerResponse");

            org.w3c.dom.Element id = doc.createElementNS(ns, "customerId");
            id.setTextContent(customer.getId());
            org.w3c.dom.Element name = doc.createElementNS(ns, "name");
            name.setTextContent(customer.getName());
            org.w3c.dom.Element email = doc.createElementNS(ns, "email");
            email.setTextContent(customer.getEmail());
            org.w3c.dom.Element status = doc.createElementNS(ns, "status");
            status.setTextContent(customer.getStatus());

            resp.appendChild(id);
            resp.appendChild(name);
            resp.appendChild(email);
            resp.appendChild(status);

            return resp;
        } catch (Exception e) {
            throw new IllegalStateException("Failed to build GetCustomerResponse", e);
        }
    }
}