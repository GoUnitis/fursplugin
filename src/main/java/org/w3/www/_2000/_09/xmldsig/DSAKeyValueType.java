/**
 * DSAKeyValueType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:18:31 BST)
 */
package org.w3.www._2000._09.xmldsig;


/**
 *  DSAKeyValueType bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class DSAKeyValueType implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = DSAKeyValueType
       Namespace URI = http://www.w3.org/2000/09/xmldsig#
       Namespace Prefix = ns1
     */

    /**
     * field for DSAKeyValueTypeSequence_type0
     */
    protected org.w3.www._2000._09.xmldsig.DSAKeyValueTypeSequence_type0 localDSAKeyValueTypeSequence_type0;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localDSAKeyValueTypeSequence_type0Tracker = false;

    /**
     * field for G
     */
    protected org.w3.www._2000._09.xmldsig.CryptoBinary localG;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localGTracker = false;

    /**
     * field for Y
     */
    protected org.w3.www._2000._09.xmldsig.CryptoBinary localY;

    /**
     * field for J
     */
    protected org.w3.www._2000._09.xmldsig.CryptoBinary localJ;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localJTracker = false;

    /**
     * field for DSAKeyValueTypeSequence_type1
     */
    protected org.w3.www._2000._09.xmldsig.DSAKeyValueTypeSequence_type1 localDSAKeyValueTypeSequence_type1;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localDSAKeyValueTypeSequence_type1Tracker = false;

    public boolean isDSAKeyValueTypeSequence_type0Specified() {
        return localDSAKeyValueTypeSequence_type0Tracker;
    }

    /**
     * Auto generated getter method
     * @return org.w3.www._2000._09.xmldsig.DSAKeyValueTypeSequence_type0
     */
    public org.w3.www._2000._09.xmldsig.DSAKeyValueTypeSequence_type0 getDSAKeyValueTypeSequence_type0() {
        return localDSAKeyValueTypeSequence_type0;
    }

    /**
     * Auto generated setter method
     * @param param DSAKeyValueTypeSequence_type0
     */
    public void setDSAKeyValueTypeSequence_type0(
        org.w3.www._2000._09.xmldsig.DSAKeyValueTypeSequence_type0 param) {
        localDSAKeyValueTypeSequence_type0Tracker = param != null;

        this.localDSAKeyValueTypeSequence_type0 = param;
    }

    public boolean isGSpecified() {
        return localGTracker;
    }

    /**
     * Auto generated getter method
     * @return org.w3.www._2000._09.xmldsig.CryptoBinary
     */
    public org.w3.www._2000._09.xmldsig.CryptoBinary getG() {
        return localG;
    }

    /**
     * Auto generated setter method
     * @param param G
     */
    public void setG(org.w3.www._2000._09.xmldsig.CryptoBinary param) {
        localGTracker = param != null;

        this.localG = param;
    }

    /**
     * Auto generated getter method
     * @return org.w3.www._2000._09.xmldsig.CryptoBinary
     */
    public org.w3.www._2000._09.xmldsig.CryptoBinary getY() {
        return localY;
    }

    /**
     * Auto generated setter method
     * @param param Y
     */
    public void setY(org.w3.www._2000._09.xmldsig.CryptoBinary param) {
        this.localY = param;
    }

    public boolean isJSpecified() {
        return localJTracker;
    }

    /**
     * Auto generated getter method
     * @return org.w3.www._2000._09.xmldsig.CryptoBinary
     */
    public org.w3.www._2000._09.xmldsig.CryptoBinary getJ() {
        return localJ;
    }

    /**
     * Auto generated setter method
     * @param param J
     */
    public void setJ(org.w3.www._2000._09.xmldsig.CryptoBinary param) {
        localJTracker = param != null;

        this.localJ = param;
    }

    public boolean isDSAKeyValueTypeSequence_type1Specified() {
        return localDSAKeyValueTypeSequence_type1Tracker;
    }

    /**
     * Auto generated getter method
     * @return org.w3.www._2000._09.xmldsig.DSAKeyValueTypeSequence_type1
     */
    public org.w3.www._2000._09.xmldsig.DSAKeyValueTypeSequence_type1 getDSAKeyValueTypeSequence_type1() {
        return localDSAKeyValueTypeSequence_type1;
    }

    /**
     * Auto generated setter method
     * @param param DSAKeyValueTypeSequence_type1
     */
    public void setDSAKeyValueTypeSequence_type1(
        org.w3.www._2000._09.xmldsig.DSAKeyValueTypeSequence_type1 param) {
        localDSAKeyValueTypeSequence_type1Tracker = param != null;

        this.localDSAKeyValueTypeSequence_type1 = param;
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
                    "http://www.w3.org/2000/09/xmldsig#");

            if ((namespacePrefix != null) &&
                    (namespacePrefix.trim().length() > 0)) {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    namespacePrefix + ":DSAKeyValueType", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "DSAKeyValueType", xmlWriter);
            }
        }

        if (localDSAKeyValueTypeSequence_type0Tracker) {
            if (localDSAKeyValueTypeSequence_type0 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "DSAKeyValueTypeSequence_type0 cannot be null!!");
            }

            localDSAKeyValueTypeSequence_type0.serialize(null, xmlWriter);
        }

        if (localGTracker) {
            if (localG == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "G cannot be null!!");
            }

            localG.serialize(new javax.xml.namespace.QName(
                    "http://www.w3.org/2000/09/xmldsig#", "G"), xmlWriter);
        }

        if (localY == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "Y cannot be null!!");
        }

        localY.serialize(new javax.xml.namespace.QName(
                "http://www.w3.org/2000/09/xmldsig#", "Y"), xmlWriter);

        if (localJTracker) {
            if (localJ == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "J cannot be null!!");
            }

            localJ.serialize(new javax.xml.namespace.QName(
                    "http://www.w3.org/2000/09/xmldsig#", "J"), xmlWriter);
        }

        if (localDSAKeyValueTypeSequence_type1Tracker) {
            if (localDSAKeyValueTypeSequence_type1 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "DSAKeyValueTypeSequence_type1 cannot be null!!");
            }

            localDSAKeyValueTypeSequence_type1.serialize(null, xmlWriter);
        }

        xmlWriter.writeEndElement();
    }

    private static java.lang.String generatePrefix(java.lang.String namespace) {
        if (namespace.equals("http://www.w3.org/2000/09/xmldsig#")) {
            return "ns1";
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

        if (localDSAKeyValueTypeSequence_type0Tracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.w3.org/2000/09/xmldsig#",
                    "DSAKeyValueTypeSequence_type0"));

            if (localDSAKeyValueTypeSequence_type0 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "DSAKeyValueTypeSequence_type0 cannot be null!!");
            }

            elementList.add(localDSAKeyValueTypeSequence_type0);
        }

        if (localGTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.w3.org/2000/09/xmldsig#", "G"));

            if (localG == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "G cannot be null!!");
            }

            elementList.add(localG);
        }

        elementList.add(new javax.xml.namespace.QName(
                "http://www.w3.org/2000/09/xmldsig#", "Y"));

        if (localY == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "Y cannot be null!!");
        }

        elementList.add(localY);

        if (localJTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.w3.org/2000/09/xmldsig#", "J"));

            if (localJ == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "J cannot be null!!");
            }

            elementList.add(localJ);
        }

        if (localDSAKeyValueTypeSequence_type1Tracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.w3.org/2000/09/xmldsig#",
                    "DSAKeyValueTypeSequence_type1"));

            if (localDSAKeyValueTypeSequence_type1 == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "DSAKeyValueTypeSequence_type1 cannot be null!!");
            }

            elementList.add(localDSAKeyValueTypeSequence_type1);
        }

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
        public static DSAKeyValueType parse(
            javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            DSAKeyValueType object = new DSAKeyValueType();

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

                        if (!"DSAKeyValueType".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (DSAKeyValueType) si.gov.fu.www.v1.cash_registers.ExtensionMapper.getTypeObject(nsUri,
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

                try {
                    if (reader.isStartElement()) {
                        object.setDSAKeyValueTypeSequence_type0(org.w3.www._2000._09.xmldsig.DSAKeyValueTypeSequence_type0.Factory.parse(
                                reader));
                    } // End of if for expected property start element

                    else {
                    }
                } catch (java.lang.Exception e) {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://www.w3.org/2000/09/xmldsig#", "G").equals(
                            reader.getName())) {
                    object.setG(org.w3.www._2000._09.xmldsig.CryptoBinary.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName(
                            "http://www.w3.org/2000/09/xmldsig#", "Y").equals(
                            reader.getName())) {
                    object.setY(org.w3.www._2000._09.xmldsig.CryptoBinary.Factory.parse(
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
                        new javax.xml.namespace.QName(
                            "http://www.w3.org/2000/09/xmldsig#", "J").equals(
                            reader.getName())) {
                    object.setJ(org.w3.www._2000._09.xmldsig.CryptoBinary.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                try {
                    if (reader.isStartElement()) {
                        object.setDSAKeyValueTypeSequence_type1(org.w3.www._2000._09.xmldsig.DSAKeyValueTypeSequence_type1.Factory.parse(
                                reader));
                    } // End of if for expected property start element

                    else {
                    }
                } catch (java.lang.Exception e) {
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
