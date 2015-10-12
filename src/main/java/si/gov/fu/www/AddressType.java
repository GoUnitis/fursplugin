/**
 * AddressType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:18:31 BST)
 */
package si.gov.fu.www;


/**
 *  AddressType bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class AddressType implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = AddressType
       Namespace URI = http://www.fu.gov.si/
       Namespace Prefix = ns2
     */

    /**
     * field for Street
     */
    protected si.gov.fu.www.Street_type1 localStreet;

    /**
     * field for HouseNumber
     */
    protected si.gov.fu.www.HouseNumber_type1 localHouseNumber;

    /**
     * field for HouseNumberAdditional
     */
    protected si.gov.fu.www.HouseNumberAdditional_type1 localHouseNumberAdditional;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localHouseNumberAdditionalTracker = false;

    /**
     * field for Community
     */
    protected si.gov.fu.www.Community_type1 localCommunity;

    /**
     * field for City
     */
    protected si.gov.fu.www.City_type1 localCity;

    /**
     * field for PostalCode
     */
    protected si.gov.fu.www.PostalCode_type1 localPostalCode;

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.Street_type1
     */
    public si.gov.fu.www.Street_type1 getStreet() {
        return localStreet;
    }

    /**
     * Auto generated setter method
     * @param param Street
     */
    public void setStreet(si.gov.fu.www.Street_type1 param) {
        this.localStreet = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.HouseNumber_type1
     */
    public si.gov.fu.www.HouseNumber_type1 getHouseNumber() {
        return localHouseNumber;
    }

    /**
     * Auto generated setter method
     * @param param HouseNumber
     */
    public void setHouseNumber(si.gov.fu.www.HouseNumber_type1 param) {
        this.localHouseNumber = param;
    }

    public boolean isHouseNumberAdditionalSpecified() {
        return localHouseNumberAdditionalTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.HouseNumberAdditional_type1
     */
    public si.gov.fu.www.HouseNumberAdditional_type1 getHouseNumberAdditional() {
        return localHouseNumberAdditional;
    }

    /**
     * Auto generated setter method
     * @param param HouseNumberAdditional
     */
    public void setHouseNumberAdditional(
        si.gov.fu.www.HouseNumberAdditional_type1 param) {
        localHouseNumberAdditionalTracker = param != null;

        this.localHouseNumberAdditional = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.Community_type1
     */
    public si.gov.fu.www.Community_type1 getCommunity() {
        return localCommunity;
    }

    /**
     * Auto generated setter method
     * @param param Community
     */
    public void setCommunity(si.gov.fu.www.Community_type1 param) {
        this.localCommunity = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.City_type1
     */
    public si.gov.fu.www.City_type1 getCity() {
        return localCity;
    }

    /**
     * Auto generated setter method
     * @param param City
     */
    public void setCity(si.gov.fu.www.City_type1 param) {
        this.localCity = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.PostalCode_type1
     */
    public si.gov.fu.www.PostalCode_type1 getPostalCode() {
        return localPostalCode;
    }

    /**
     * Auto generated setter method
     * @param param PostalCode
     */
    public void setPostalCode(si.gov.fu.www.PostalCode_type1 param) {
        this.localPostalCode = param;
    }

    /**
     *
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory)
        throws org.apache.axis2.databinding.ADBException {
        org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
                parentQName);

        return factory.createOMElement(dataSource, parentQName);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException,
            org.apache.axis2.databinding.ADBException {
        serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException,
            org.apache.axis2.databinding.ADBException {
        java.lang.String prefix = null;
        java.lang.String namespace = null;

        prefix = parentQName.getPrefix();
        namespace = parentQName.getNamespaceURI();
        writeStartElement(prefix, namespace, parentQName.getLocalPart(),
            xmlWriter);

        if (serializeType) {
            java.lang.String namespacePrefix = registerPrefix(xmlWriter,
                    "http://www.fu.gov.si/");

            if ((namespacePrefix != null) &&
                    (namespacePrefix.trim().length() > 0)) {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    namespacePrefix + ":AddressType", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "AddressType", xmlWriter);
            }
        }

        if (localStreet == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "Street cannot be null!!");
        }

        localStreet.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "Street"), xmlWriter);

        if (localHouseNumber == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "HouseNumber cannot be null!!");
        }

        localHouseNumber.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "HouseNumber"), xmlWriter);

        if (localHouseNumberAdditionalTracker) {
            if (localHouseNumberAdditional == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "HouseNumberAdditional cannot be null!!");
            }

            localHouseNumberAdditional.serialize(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "HouseNumberAdditional"), xmlWriter);
        }

        if (localCommunity == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "Community cannot be null!!");
        }

        localCommunity.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "Community"), xmlWriter);

        if (localCity == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "City cannot be null!!");
        }

        localCity.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "City"), xmlWriter);

        if (localPostalCode == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "PostalCode cannot be null!!");
        }

        localPostalCode.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "PostalCode"), xmlWriter);

        xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
        if (namespace.equals("http://www.fu.gov.si/")) {
            return "ns2";
        }

        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix,
        java.lang.String namespace, java.lang.String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);

        if (writerPrefix != null) {
            xmlWriter.writeStartElement(namespace, localPart);
        } else {
            if (namespace.length() == 0) {
                prefix = "";
            } else if (prefix == null) {
                prefix = generatePrefix(namespace);
            }

            xmlWriter.writeStartElement(prefix, localPart, namespace);
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix,
        java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        if (xmlWriter.getPrefix(namespace) == null) {
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }

        xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(java.lang.String namespace,
        java.lang.String attName, javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String attributeNamespace = qname.getNamespaceURI();
        java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);

        if (attributePrefix == null) {
            attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
        }

        java.lang.String attributeValue;

        if (attributePrefix.trim().length() > 0) {
            attributeValue = attributePrefix + ":" + qname.getLocalPart();
        } else {
            attributeValue = qname.getLocalPart();
        }

        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attributeValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attributeValue);
        }
    }

    /**
     *  method to handle Qnames
     */
    private void writeQName(javax.xml.namespace.QName qname,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String namespaceURI = qname.getNamespaceURI();

        if (namespaceURI != null) {
            java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);

            if (prefix == null) {
                prefix = generatePrefix(namespaceURI);
                xmlWriter.writeNamespace(prefix, namespaceURI);
                xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
                xmlWriter.writeCharacters(prefix + ":" +
                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            } else {
                // i.e this is the default namespace
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        qname));
            }
        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    qname));
        }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
        if (qnames != null) {
            // we have to store this data until last moment since it is not possible to write any
            // namespace data after writing the charactor data
            java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
            java.lang.String namespaceURI = null;
            java.lang.String prefix = null;

            for (int i = 0; i < qnames.length; i++) {
                if (i > 0) {
                    stringToWrite.append(" ");
                }

                namespaceURI = qnames[i].getNamespaceURI();

                if (namespaceURI != null) {
                    prefix = xmlWriter.getPrefix(namespaceURI);

                    if ((prefix == null) || (prefix.length() == 0)) {
                        prefix = generatePrefix(namespaceURI);
                        xmlWriter.writeNamespace(prefix, namespaceURI);
                        xmlWriter.setPrefix(prefix, namespaceURI);
                    }

                    if (prefix.trim().length() > 0) {
                        stringToWrite.append(prefix).append(":")
                                     .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                                qnames[i]));
                    }
                } else {
                    stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                            qnames[i]));
                }
            }

            xmlWriter.writeCharacters(stringToWrite.toString());
        }
    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace)
        throws javax.xml.stream.XMLStreamException {
        java.lang.String prefix = xmlWriter.getPrefix(namespace);

        if (prefix == null) {
            prefix = generatePrefix(namespace);

            javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();

            while (true) {
                java.lang.String uri = nsContext.getNamespaceURI(prefix);

                if ((uri == null) || (uri.length() == 0)) {
                    break;
                }

                prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
            }

            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }

        return prefix;
    }

    /**
     * databinding method to get an XML representation of this object
     *
     */
    public javax.xml.stream.XMLStreamReader getPullParser(
        javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException {
        java.util.ArrayList elementList = new java.util.ArrayList();
        java.util.ArrayList attribList = new java.util.ArrayList();

        elementList.add(new javax.xml.namespace.QName("http://www.fu.gov.si/",
                "Street"));

        if (localStreet == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "Street cannot be null!!");
        }

        elementList.add(localStreet);

        elementList.add(new javax.xml.namespace.QName("http://www.fu.gov.si/",
                "HouseNumber"));

        if (localHouseNumber == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "HouseNumber cannot be null!!");
        }

        elementList.add(localHouseNumber);

        if (localHouseNumberAdditionalTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "HouseNumberAdditional"));

            if (localHouseNumberAdditional == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "HouseNumberAdditional cannot be null!!");
            }

            elementList.add(localHouseNumberAdditional);
        }

        elementList.add(new javax.xml.namespace.QName("http://www.fu.gov.si/",
                "Community"));

        if (localCommunity == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "Community cannot be null!!");
        }

        elementList.add(localCommunity);

        elementList.add(new javax.xml.namespace.QName("http://www.fu.gov.si/",
                "City"));

        if (localCity == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "City cannot be null!!");
        }

        elementList.add(localCity);

        elementList.add(new javax.xml.namespace.QName("http://www.fu.gov.si/",
                "PostalCode"));

        if (localPostalCode == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "PostalCode cannot be null!!");
        }

        elementList.add(localPostalCode);

        return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
            elementList.toArray(), attribList.toArray());
    }

    /**
     *  Factory class that keeps the parse method
     */
    public static class Factory {
        /**
         * static method to create the object
         * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
         *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
         * Postcondition: If this object is an element, the reader is positioned at its end element
         *                If this object is a complex type, the reader is positioned at the end element of its outer element
         */
        public static AddressType parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            AddressType object = new AddressType();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix = "";
            java.lang.String namespaceuri = "";

            try {
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.getAttributeValue(
                            "http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                    java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "type");

                    if (fullTypeName != null) {
                        java.lang.String nsPrefix = null;

                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0,
                                    fullTypeName.indexOf(":"));
                        }

                        nsPrefix = (nsPrefix == null) ? "" : nsPrefix;

                        java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(
                                    ":") + 1);

                        if (!"AddressType".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (AddressType) si.gov.fu.www.v1.cash_registers.ExtensionMapper.getTypeObject(nsUri,
                                type, reader);
                        }
                    }
                }

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                reader.next();

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "Street").equals(reader.getName())) {
                    object.setStreet(si.gov.fu.www.Street_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "HouseNumber").equals(reader.getName())) {
                    object.setHouseNumber(si.gov.fu.www.HouseNumber_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "HouseNumberAdditional").equals(reader.getName())) {
                    object.setHouseNumberAdditional(si.gov.fu.www.HouseNumberAdditional_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "Community").equals(reader.getName())) {
                    object.setCommunity(si.gov.fu.www.Community_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "City").equals(reader.getName())) {
                    object.setCity(si.gov.fu.www.City_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "PostalCode").equals(reader.getName())) {
                    object.setPostalCode(si.gov.fu.www.PostalCode_type1.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getName());
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement()) {
                    // A start element we are not expecting indicates a trailing invalid property
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getName());
                }
            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }
    } //end of factory class
}
