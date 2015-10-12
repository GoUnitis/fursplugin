/**
 * BusinessPremiseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:18:31 BST)
 */
package si.gov.fu.www;


/**
 *  BusinessPremiseType bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class BusinessPremiseType implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = BusinessPremiseType
       Namespace URI = http://www.fu.gov.si/
       Namespace Prefix = ns2
     */

    /**
     * field for TaxNumber
     */
    protected si.gov.fu.www.TaxNumberType localTaxNumber;

    /**
     * field for BusinessPremiseID
     */
    protected si.gov.fu.www.BusinessPremiseIDType localBusinessPremiseID;

    /**
     * field for BPIdentifier
     */
    protected si.gov.fu.www.BPIdentifierType localBPIdentifier;

    /**
     * field for ValidityDate
     */
    protected si.gov.fu.www.Date localValidityDate;

    /**
     * field for ClosingTag
     */
    protected si.gov.fu.www.ClosingTagType localClosingTag;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localClosingTagTracker = false;

    /**
     * field for SoftwareSupplier
     * This was an Array!
     */
    protected si.gov.fu.www.SoftwareSupplierType[] localSoftwareSupplier;

    /**
     * field for SpecialNotes
     */
    protected si.gov.fu.www.SpecialNotes_type5 localSpecialNotes;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSpecialNotesTracker = false;

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.TaxNumberType
     */
    public si.gov.fu.www.TaxNumberType getTaxNumber() {
        return localTaxNumber;
    }

    /**
     * Auto generated setter method
     * @param param TaxNumber
     */
    public void setTaxNumber(si.gov.fu.www.TaxNumberType param) {
        this.localTaxNumber = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.BusinessPremiseIDType
     */
    public si.gov.fu.www.BusinessPremiseIDType getBusinessPremiseID() {
        return localBusinessPremiseID;
    }

    /**
     * Auto generated setter method
     * @param param BusinessPremiseID
     */
    public void setBusinessPremiseID(si.gov.fu.www.BusinessPremiseIDType param) {
        this.localBusinessPremiseID = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.BPIdentifierType
     */
    public si.gov.fu.www.BPIdentifierType getBPIdentifier() {
        return localBPIdentifier;
    }

    /**
     * Auto generated setter method
     * @param param BPIdentifier
     */
    public void setBPIdentifier(si.gov.fu.www.BPIdentifierType param) {
        this.localBPIdentifier = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.Date
     */
    public si.gov.fu.www.Date getValidityDate() {
        return localValidityDate;
    }

    /**
     * Auto generated setter method
     * @param param ValidityDate
     */
    public void setValidityDate(si.gov.fu.www.Date param) {
        this.localValidityDate = param;
    }

    public boolean isClosingTagSpecified() {
        return localClosingTagTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.ClosingTagType
     */
    public si.gov.fu.www.ClosingTagType getClosingTag() {
        return localClosingTag;
    }

    /**
     * Auto generated setter method
     * @param param ClosingTag
     */
    public void setClosingTag(si.gov.fu.www.ClosingTagType param) {
        localClosingTagTracker = param != null;

        this.localClosingTag = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.SoftwareSupplierType[]
     */
    public si.gov.fu.www.SoftwareSupplierType[] getSoftwareSupplier() {
        return localSoftwareSupplier;
    }

    /**
     * validate the array for SoftwareSupplier
     */
    protected void validateSoftwareSupplier(
        si.gov.fu.www.SoftwareSupplierType[] param) {
        if ((param != null) && (param.length > 1000)) {
            throw new java.lang.RuntimeException(
                "Input values do not follow defined XSD restrictions");
        }

        if ((param != null) && (param.length < 1)) {
            throw new java.lang.RuntimeException(
                "Input values do not follow defined XSD restrictions");
        }
    }

    /**
     * Auto generated setter method
     * @param param SoftwareSupplier
     */
    public void setSoftwareSupplier(si.gov.fu.www.SoftwareSupplierType[] param) {
        validateSoftwareSupplier(param);

        this.localSoftwareSupplier = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * @param param si.gov.fu.www.SoftwareSupplierType
     */
    public void addSoftwareSupplier(si.gov.fu.www.SoftwareSupplierType param) {
        if (localSoftwareSupplier == null) {
            localSoftwareSupplier = new si.gov.fu.www.SoftwareSupplierType[] {  };
        }

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localSoftwareSupplier);
        list.add(param);
        this.localSoftwareSupplier = (si.gov.fu.www.SoftwareSupplierType[]) list.toArray(new si.gov.fu.www.SoftwareSupplierType[list.size()]);
    }

    public boolean isSpecialNotesSpecified() {
        return localSpecialNotesTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.SpecialNotes_type5
     */
    public si.gov.fu.www.SpecialNotes_type5 getSpecialNotes() {
        return localSpecialNotes;
    }

    /**
     * Auto generated setter method
     * @param param SpecialNotes
     */
    public void setSpecialNotes(si.gov.fu.www.SpecialNotes_type5 param) {
        localSpecialNotesTracker = param != null;

        this.localSpecialNotes = param;
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
                    namespacePrefix + ":BusinessPremiseType", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "BusinessPremiseType", xmlWriter);
            }
        }

        if (localTaxNumber == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "TaxNumber cannot be null!!");
        }

        localTaxNumber.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "TaxNumber"), xmlWriter);

        if (localBusinessPremiseID == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "BusinessPremiseID cannot be null!!");
        }

        localBusinessPremiseID.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "BusinessPremiseID"), xmlWriter);

        if (localBPIdentifier == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "BPIdentifier cannot be null!!");
        }

        localBPIdentifier.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "BPIdentifier"), xmlWriter);

        if (localValidityDate == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "ValidityDate cannot be null!!");
        }

        localValidityDate.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "ValidityDate"), xmlWriter);

        if (localClosingTagTracker) {
            if (localClosingTag == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ClosingTag cannot be null!!");
            }

            localClosingTag.serialize(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "ClosingTag"), xmlWriter);
        }

        if (localSoftwareSupplier != null) {
            for (int i = 0; i < localSoftwareSupplier.length; i++) {
                if (localSoftwareSupplier[i] != null) {
                    localSoftwareSupplier[i].serialize(new javax.xml.namespace.QName(
                            "http://www.fu.gov.si/", "SoftwareSupplier"),
                        xmlWriter);
                } else {
                    throw new org.apache.axis2.databinding.ADBException(
                        "SoftwareSupplier cannot be null!!");
                }
            }
        } else {
            throw new org.apache.axis2.databinding.ADBException(
                "SoftwareSupplier cannot be null!!");
        }

        if (localSpecialNotesTracker) {
            if (localSpecialNotes == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SpecialNotes cannot be null!!");
            }

            localSpecialNotes.serialize(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "SpecialNotes"), xmlWriter);
        }

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
                "TaxNumber"));

        if (localTaxNumber == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "TaxNumber cannot be null!!");
        }

        elementList.add(localTaxNumber);

        elementList.add(new javax.xml.namespace.QName("http://www.fu.gov.si/",
                "BusinessPremiseID"));

        if (localBusinessPremiseID == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "BusinessPremiseID cannot be null!!");
        }

        elementList.add(localBusinessPremiseID);

        elementList.add(new javax.xml.namespace.QName("http://www.fu.gov.si/",
                "BPIdentifier"));

        if (localBPIdentifier == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "BPIdentifier cannot be null!!");
        }

        elementList.add(localBPIdentifier);

        elementList.add(new javax.xml.namespace.QName("http://www.fu.gov.si/",
                "ValidityDate"));

        if (localValidityDate == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "ValidityDate cannot be null!!");
        }

        elementList.add(localValidityDate);

        if (localClosingTagTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "ClosingTag"));

            if (localClosingTag == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ClosingTag cannot be null!!");
            }

            elementList.add(localClosingTag);
        }

        if (localSoftwareSupplier != null) {
            for (int i = 0; i < localSoftwareSupplier.length; i++) {
                if (localSoftwareSupplier[i] != null) {
                    elementList.add(new javax.xml.namespace.QName(
                            "http://www.fu.gov.si/", "SoftwareSupplier"));
                    elementList.add(localSoftwareSupplier[i]);
                } else {
                    throw new org.apache.axis2.databinding.ADBException(
                        "SoftwareSupplier cannot be null !!");
                }
            }
        } else {
            throw new org.apache.axis2.databinding.ADBException(
                "SoftwareSupplier cannot be null!!");
        }

        if (localSpecialNotesTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "SpecialNotes"));

            if (localSpecialNotes == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SpecialNotes cannot be null!!");
            }

            elementList.add(localSpecialNotes);
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
        public static BusinessPremiseType parse(
            javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            BusinessPremiseType object = new BusinessPremiseType();

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

                        if (!"BusinessPremiseType".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (BusinessPremiseType) si.gov.fu.www.v1.cash_registers.ExtensionMapper.getTypeObject(nsUri,
                                type, reader);
                        }
                    }
                }

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                reader.next();

                java.util.ArrayList list6 = new java.util.ArrayList();

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "TaxNumber").equals(reader.getName())) {
                    object.setTaxNumber(si.gov.fu.www.TaxNumberType.Factory.parse(
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
                            "BusinessPremiseID").equals(reader.getName())) {
                    object.setBusinessPremiseID(si.gov.fu.www.BusinessPremiseIDType.Factory.parse(
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
                            "BPIdentifier").equals(reader.getName())) {
                    object.setBPIdentifier(si.gov.fu.www.BPIdentifierType.Factory.parse(
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
                            "ValidityDate").equals(reader.getName())) {
                    object.setValidityDate(si.gov.fu.www.Date.Factory.parse(
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
                            "ClosingTag").equals(reader.getName())) {
                    object.setClosingTag(si.gov.fu.www.ClosingTagType.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "SoftwareSupplier").equals(reader.getName())) {
                    // Process the array and step past its final element's end.
                    list6.add(si.gov.fu.www.SoftwareSupplierType.Factory.parse(
                            reader));

                    //loop until we find a start element that is not part of this array
                    boolean loopDone6 = false;

                    while (!loopDone6) {
                        // We should be at the end element, but make sure
                        while (!reader.isEndElement())
                            reader.next();

                        // Step out of this element
                        reader.next();

                        // Step to next element event.
                        while (!reader.isStartElement() &&
                                !reader.isEndElement())
                            reader.next();

                        if (reader.isEndElement()) {
                            //two continuous end elements means we are exiting the xml structure
                            loopDone6 = true;
                        } else {
                            if (new javax.xml.namespace.QName(
                                        "http://www.fu.gov.si/",
                                        "SoftwareSupplier").equals(
                                        reader.getName())) {
                                list6.add(si.gov.fu.www.SoftwareSupplierType.Factory.parse(
                                        reader));
                            } else {
                                loopDone6 = true;
                            }
                        }
                    }

                    // call the converter utility  to convert and set the array
                    object.setSoftwareSupplier((si.gov.fu.www.SoftwareSupplierType[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                            si.gov.fu.www.SoftwareSupplierType.class, list6));
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
                            "SpecialNotes").equals(reader.getName())) {
                    object.setSpecialNotes(si.gov.fu.www.SpecialNotes_type5.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
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
