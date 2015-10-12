/**
 * InvoiceType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:18:31 BST)
 */
package si.gov.fu.www;


/**
 *  InvoiceType bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class InvoiceType implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = InvoiceType
       Namespace URI = http://www.fu.gov.si/
       Namespace Prefix = ns2
     */

    /**
     * field for TaxNumber
     */
    protected si.gov.fu.www.TaxNumberType localTaxNumber;

    /**
     * field for IssueDateTime
     */
    protected si.gov.fu.www.DateTime localIssueDateTime;

    /**
     * field for NumberingStructure
     */
    protected si.gov.fu.www.NumberingStructureType localNumberingStructure;

    /**
     * field for InvoiceIdentifier
     */
    protected si.gov.fu.www.IdentifierType localInvoiceIdentifier;

    /**
     * field for CustomerVATNumber
     */
    protected si.gov.fu.www.CustomerVATType localCustomerVATNumber;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localCustomerVATNumberTracker = false;

    /**
     * field for InvoiceAmount
     */
    protected si.gov.fu.www.AmountType localInvoiceAmount;

    /**
     * field for ReturnsAmount
     */
    protected si.gov.fu.www.AmountType localReturnsAmount;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localReturnsAmountTracker = false;

    /**
     * field for PaymentAmount
     */
    protected si.gov.fu.www.AmountType localPaymentAmount;

    /**
     * field for TaxesPerSeller
     * This was an Array!
     */
    protected si.gov.fu.www.TaxesPerSellerType[] localTaxesPerSeller;

    /**
     * field for OperatorTaxNumber
     */
    protected si.gov.fu.www.TaxNumberType localOperatorTaxNumber;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localOperatorTaxNumberTracker = false;

    /**
     * field for ForeignOperator
     */
    protected boolean localForeignOperator;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localForeignOperatorTracker = false;

    /**
     * field for ProtectedID
     */
    protected si.gov.fu.www.ProtectedID_type1 localProtectedID;

    /**
     * field for SubsequentSubmit
     */
    protected boolean localSubsequentSubmit;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSubsequentSubmitTracker = false;

    /**
     * field for ReferenceInvoice
     * This was an Array!
     */
    protected si.gov.fu.www.ReferenceInvoice_type0[] localReferenceInvoice;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localReferenceInvoiceTracker = false;

    /**
     * field for ReferenceSalesBook
     * This was an Array!
     */
    protected si.gov.fu.www.ReferenceSalesBook_type0[] localReferenceSalesBook;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localReferenceSalesBookTracker = false;

    /**
     * field for SpecialNotes
     */
    protected si.gov.fu.www.SpecialNotes_type1 localSpecialNotes;

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
     * @return si.gov.fu.www.DateTime
     */
    public si.gov.fu.www.DateTime getIssueDateTime() {
        return localIssueDateTime;
    }

    /**
     * Auto generated setter method
     * @param param IssueDateTime
     */
    public void setIssueDateTime(si.gov.fu.www.DateTime param) {
        this.localIssueDateTime = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.NumberingStructureType
     */
    public si.gov.fu.www.NumberingStructureType getNumberingStructure() {
        return localNumberingStructure;
    }

    /**
     * Auto generated setter method
     * @param param NumberingStructure
     */
    public void setNumberingStructure(
        si.gov.fu.www.NumberingStructureType param) {
        this.localNumberingStructure = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.IdentifierType
     */
    public si.gov.fu.www.IdentifierType getInvoiceIdentifier() {
        return localInvoiceIdentifier;
    }

    /**
     * Auto generated setter method
     * @param param InvoiceIdentifier
     */
    public void setInvoiceIdentifier(si.gov.fu.www.IdentifierType param) {
        this.localInvoiceIdentifier = param;
    }

    public boolean isCustomerVATNumberSpecified() {
        return localCustomerVATNumberTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.CustomerVATType
     */
    public si.gov.fu.www.CustomerVATType getCustomerVATNumber() {
        return localCustomerVATNumber;
    }

    /**
     * Auto generated setter method
     * @param param CustomerVATNumber
     */
    public void setCustomerVATNumber(si.gov.fu.www.CustomerVATType param) {
        localCustomerVATNumberTracker = param != null;

        this.localCustomerVATNumber = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.AmountType
     */
    public si.gov.fu.www.AmountType getInvoiceAmount() {
        return localInvoiceAmount;
    }

    /**
     * Auto generated setter method
     * @param param InvoiceAmount
     */
    public void setInvoiceAmount(si.gov.fu.www.AmountType param) {
        this.localInvoiceAmount = param;
    }

    public boolean isReturnsAmountSpecified() {
        return localReturnsAmountTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.AmountType
     */
    public si.gov.fu.www.AmountType getReturnsAmount() {
        return localReturnsAmount;
    }

    /**
     * Auto generated setter method
     * @param param ReturnsAmount
     */
    public void setReturnsAmount(si.gov.fu.www.AmountType param) {
        localReturnsAmountTracker = param != null;

        this.localReturnsAmount = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.AmountType
     */
    public si.gov.fu.www.AmountType getPaymentAmount() {
        return localPaymentAmount;
    }

    /**
     * Auto generated setter method
     * @param param PaymentAmount
     */
    public void setPaymentAmount(si.gov.fu.www.AmountType param) {
        this.localPaymentAmount = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.TaxesPerSellerType[]
     */
    public si.gov.fu.www.TaxesPerSellerType[] getTaxesPerSeller() {
        return localTaxesPerSeller;
    }

    /**
     * validate the array for TaxesPerSeller
     */
    protected void validateTaxesPerSeller(
        si.gov.fu.www.TaxesPerSellerType[] param) {
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
     * @param param TaxesPerSeller
     */
    public void setTaxesPerSeller(si.gov.fu.www.TaxesPerSellerType[] param) {
        validateTaxesPerSeller(param);

        this.localTaxesPerSeller = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * @param param si.gov.fu.www.TaxesPerSellerType
     */
    public void addTaxesPerSeller(si.gov.fu.www.TaxesPerSellerType param) {
        if (localTaxesPerSeller == null) {
            localTaxesPerSeller = new si.gov.fu.www.TaxesPerSellerType[] {  };
        }

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localTaxesPerSeller);
        list.add(param);
        this.localTaxesPerSeller = (si.gov.fu.www.TaxesPerSellerType[]) list.toArray(new si.gov.fu.www.TaxesPerSellerType[list.size()]);
    }

    public boolean isOperatorTaxNumberSpecified() {
        return localOperatorTaxNumberTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.TaxNumberType
     */
    public si.gov.fu.www.TaxNumberType getOperatorTaxNumber() {
        return localOperatorTaxNumber;
    }

    /**
     * Auto generated setter method
     * @param param OperatorTaxNumber
     */
    public void setOperatorTaxNumber(si.gov.fu.www.TaxNumberType param) {
        localOperatorTaxNumberTracker = param != null;

        this.localOperatorTaxNumber = param;
    }

    public boolean isForeignOperatorSpecified() {
        return localForeignOperatorTracker;
    }

    /**
     * Auto generated getter method
     * @return boolean
     */
    public boolean getForeignOperator() {
        return localForeignOperator;
    }

    /**
     * Auto generated setter method
     * @param param ForeignOperator
     */
    public void setForeignOperator(boolean param) {
        // setting primitive attribute tracker to true
        localForeignOperatorTracker = true;

        this.localForeignOperator = param;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.ProtectedID_type1
     */
    public si.gov.fu.www.ProtectedID_type1 getProtectedID() {
        return localProtectedID;
    }

    /**
     * Auto generated setter method
     * @param param ProtectedID
     */
    public void setProtectedID(si.gov.fu.www.ProtectedID_type1 param) {
        this.localProtectedID = param;
    }

    public boolean isSubsequentSubmitSpecified() {
        return localSubsequentSubmitTracker;
    }

    /**
     * Auto generated getter method
     * @return boolean
     */
    public boolean getSubsequentSubmit() {
        return localSubsequentSubmit;
    }

    /**
     * Auto generated setter method
     * @param param SubsequentSubmit
     */
    public void setSubsequentSubmit(boolean param) {
        // setting primitive attribute tracker to true
        localSubsequentSubmitTracker = true;

        this.localSubsequentSubmit = param;
    }

    public boolean isReferenceInvoiceSpecified() {
        return localReferenceInvoiceTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.ReferenceInvoice_type0[]
     */
    public si.gov.fu.www.ReferenceInvoice_type0[] getReferenceInvoice() {
        return localReferenceInvoice;
    }

    /**
     * validate the array for ReferenceInvoice
     */
    protected void validateReferenceInvoice(
        si.gov.fu.www.ReferenceInvoice_type0[] param) {
        if ((param != null) && (param.length > 1000)) {
            throw new java.lang.RuntimeException(
                "Input values do not follow defined XSD restrictions");
        }
    }

    /**
     * Auto generated setter method
     * @param param ReferenceInvoice
     */
    public void setReferenceInvoice(
        si.gov.fu.www.ReferenceInvoice_type0[] param) {
        validateReferenceInvoice(param);

        localReferenceInvoiceTracker = param != null;

        this.localReferenceInvoice = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * @param param si.gov.fu.www.ReferenceInvoice_type0
     */
    public void addReferenceInvoice(si.gov.fu.www.ReferenceInvoice_type0 param) {
        if (localReferenceInvoice == null) {
            localReferenceInvoice = new si.gov.fu.www.ReferenceInvoice_type0[] {  };
        }

        //update the setting tracker
        localReferenceInvoiceTracker = true;

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localReferenceInvoice);
        list.add(param);
        this.localReferenceInvoice = (si.gov.fu.www.ReferenceInvoice_type0[]) list.toArray(new si.gov.fu.www.ReferenceInvoice_type0[list.size()]);
    }

    public boolean isReferenceSalesBookSpecified() {
        return localReferenceSalesBookTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.ReferenceSalesBook_type0[]
     */
    public si.gov.fu.www.ReferenceSalesBook_type0[] getReferenceSalesBook() {
        return localReferenceSalesBook;
    }

    /**
     * validate the array for ReferenceSalesBook
     */
    protected void validateReferenceSalesBook(
        si.gov.fu.www.ReferenceSalesBook_type0[] param) {
        if ((param != null) && (param.length > 1000)) {
            throw new java.lang.RuntimeException(
                "Input values do not follow defined XSD restrictions");
        }
    }

    /**
     * Auto generated setter method
     * @param param ReferenceSalesBook
     */
    public void setReferenceSalesBook(
        si.gov.fu.www.ReferenceSalesBook_type0[] param) {
        validateReferenceSalesBook(param);

        localReferenceSalesBookTracker = param != null;

        this.localReferenceSalesBook = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * @param param si.gov.fu.www.ReferenceSalesBook_type0
     */
    public void addReferenceSalesBook(
        si.gov.fu.www.ReferenceSalesBook_type0 param) {
        if (localReferenceSalesBook == null) {
            localReferenceSalesBook = new si.gov.fu.www.ReferenceSalesBook_type0[] {
                    
                };
        }

        //update the setting tracker
        localReferenceSalesBookTracker = true;

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localReferenceSalesBook);
        list.add(param);
        this.localReferenceSalesBook = (si.gov.fu.www.ReferenceSalesBook_type0[]) list.toArray(new si.gov.fu.www.ReferenceSalesBook_type0[list.size()]);
    }

    public boolean isSpecialNotesSpecified() {
        return localSpecialNotesTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.SpecialNotes_type1
     */
    public si.gov.fu.www.SpecialNotes_type1 getSpecialNotes() {
        return localSpecialNotes;
    }

    /**
     * Auto generated setter method
     * @param param SpecialNotes
     */
    public void setSpecialNotes(si.gov.fu.www.SpecialNotes_type1 param) {
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
                    namespacePrefix + ":InvoiceType", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "InvoiceType", xmlWriter);
            }
        }

        if (localTaxNumber == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "TaxNumber cannot be null!!");
        }

        localTaxNumber.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "TaxNumber"), xmlWriter);

        if (localIssueDateTime == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "IssueDateTime cannot be null!!");
        }

        localIssueDateTime.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "IssueDateTime"), xmlWriter);

        if (localNumberingStructure == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "NumberingStructure cannot be null!!");
        }

        localNumberingStructure.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "NumberingStructure"), xmlWriter);

        if (localInvoiceIdentifier == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "InvoiceIdentifier cannot be null!!");
        }

        localInvoiceIdentifier.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "InvoiceIdentifier"), xmlWriter);

        if (localCustomerVATNumberTracker) {
            if (localCustomerVATNumber == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CustomerVATNumber cannot be null!!");
            }

            localCustomerVATNumber.serialize(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "CustomerVATNumber"), xmlWriter);
        }

        if (localInvoiceAmount == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "InvoiceAmount cannot be null!!");
        }

        localInvoiceAmount.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "InvoiceAmount"), xmlWriter);

        if (localReturnsAmountTracker) {
            if (localReturnsAmount == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ReturnsAmount cannot be null!!");
            }

            localReturnsAmount.serialize(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "ReturnsAmount"), xmlWriter);
        }

        if (localPaymentAmount == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "PaymentAmount cannot be null!!");
        }

        localPaymentAmount.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "PaymentAmount"), xmlWriter);

        if (localTaxesPerSeller != null) {
            for (int i = 0; i < localTaxesPerSeller.length; i++) {
                if (localTaxesPerSeller[i] != null) {
                    localTaxesPerSeller[i].serialize(new javax.xml.namespace.QName(
                            "http://www.fu.gov.si/", "TaxesPerSeller"),
                        xmlWriter);
                } else {
                    throw new org.apache.axis2.databinding.ADBException(
                        "TaxesPerSeller cannot be null!!");
                }
            }
        } else {
            throw new org.apache.axis2.databinding.ADBException(
                "TaxesPerSeller cannot be null!!");
        }

        if (localOperatorTaxNumberTracker) {
            if (localOperatorTaxNumber == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "OperatorTaxNumber cannot be null!!");
            }

            localOperatorTaxNumber.serialize(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "OperatorTaxNumber"), xmlWriter);
        }

        if (localForeignOperatorTracker) {
            namespace = "http://www.fu.gov.si/";
            writeStartElement(null, namespace, "ForeignOperator", xmlWriter);

            if (false) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ForeignOperator cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localForeignOperator));
            }

            xmlWriter.writeEndElement();
        }

        if (localProtectedID == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "ProtectedID cannot be null!!");
        }

        localProtectedID.serialize(new javax.xml.namespace.QName(
                "http://www.fu.gov.si/", "ProtectedID"), xmlWriter);

        if (localSubsequentSubmitTracker) {
            namespace = "http://www.fu.gov.si/";
            writeStartElement(null, namespace, "SubsequentSubmit", xmlWriter);

            if (false) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SubsequentSubmit cannot be null!!");
            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                        localSubsequentSubmit));
            }

            xmlWriter.writeEndElement();
        }

        if (localReferenceInvoiceTracker) {
            if (localReferenceInvoice != null) {
                for (int i = 0; i < localReferenceInvoice.length; i++) {
                    if (localReferenceInvoice[i] != null) {
                        localReferenceInvoice[i].serialize(new javax.xml.namespace.QName(
                                "http://www.fu.gov.si/", "ReferenceInvoice"),
                            xmlWriter);
                    } else {
                        // we don't have to do any thing since minOccures is zero
                    }
                }
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                    "ReferenceInvoice cannot be null!!");
            }
        }

        if (localReferenceSalesBookTracker) {
            if (localReferenceSalesBook != null) {
                for (int i = 0; i < localReferenceSalesBook.length; i++) {
                    if (localReferenceSalesBook[i] != null) {
                        localReferenceSalesBook[i].serialize(new javax.xml.namespace.QName(
                                "http://www.fu.gov.si/", "ReferenceSalesBook"),
                            xmlWriter);
                    } else {
                        // we don't have to do any thing since minOccures is zero
                    }
                }
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                    "ReferenceSalesBook cannot be null!!");
            }
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
                "IssueDateTime"));

        if (localIssueDateTime == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "IssueDateTime cannot be null!!");
        }

        elementList.add(localIssueDateTime);

        elementList.add(new javax.xml.namespace.QName("http://www.fu.gov.si/",
                "NumberingStructure"));

        if (localNumberingStructure == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "NumberingStructure cannot be null!!");
        }

        elementList.add(localNumberingStructure);

        elementList.add(new javax.xml.namespace.QName("http://www.fu.gov.si/",
                "InvoiceIdentifier"));

        if (localInvoiceIdentifier == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "InvoiceIdentifier cannot be null!!");
        }

        elementList.add(localInvoiceIdentifier);

        if (localCustomerVATNumberTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "CustomerVATNumber"));

            if (localCustomerVATNumber == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "CustomerVATNumber cannot be null!!");
            }

            elementList.add(localCustomerVATNumber);
        }

        elementList.add(new javax.xml.namespace.QName("http://www.fu.gov.si/",
                "InvoiceAmount"));

        if (localInvoiceAmount == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "InvoiceAmount cannot be null!!");
        }

        elementList.add(localInvoiceAmount);

        if (localReturnsAmountTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "ReturnsAmount"));

            if (localReturnsAmount == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ReturnsAmount cannot be null!!");
            }

            elementList.add(localReturnsAmount);
        }

        elementList.add(new javax.xml.namespace.QName("http://www.fu.gov.si/",
                "PaymentAmount"));

        if (localPaymentAmount == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "PaymentAmount cannot be null!!");
        }

        elementList.add(localPaymentAmount);

        if (localTaxesPerSeller != null) {
            for (int i = 0; i < localTaxesPerSeller.length; i++) {
                if (localTaxesPerSeller[i] != null) {
                    elementList.add(new javax.xml.namespace.QName(
                            "http://www.fu.gov.si/", "TaxesPerSeller"));
                    elementList.add(localTaxesPerSeller[i]);
                } else {
                    throw new org.apache.axis2.databinding.ADBException(
                        "TaxesPerSeller cannot be null !!");
                }
            }
        } else {
            throw new org.apache.axis2.databinding.ADBException(
                "TaxesPerSeller cannot be null!!");
        }

        if (localOperatorTaxNumberTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "OperatorTaxNumber"));

            if (localOperatorTaxNumber == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "OperatorTaxNumber cannot be null!!");
            }

            elementList.add(localOperatorTaxNumber);
        }

        if (localForeignOperatorTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "ForeignOperator"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localForeignOperator));
        }

        elementList.add(new javax.xml.namespace.QName("http://www.fu.gov.si/",
                "ProtectedID"));

        if (localProtectedID == null) {
            throw new org.apache.axis2.databinding.ADBException(
                "ProtectedID cannot be null!!");
        }

        elementList.add(localProtectedID);

        if (localSubsequentSubmitTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "SubsequentSubmit"));

            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(
                    localSubsequentSubmit));
        }

        if (localReferenceInvoiceTracker) {
            if (localReferenceInvoice != null) {
                for (int i = 0; i < localReferenceInvoice.length; i++) {
                    if (localReferenceInvoice[i] != null) {
                        elementList.add(new javax.xml.namespace.QName(
                                "http://www.fu.gov.si/", "ReferenceInvoice"));
                        elementList.add(localReferenceInvoice[i]);
                    } else {
                        // nothing to do
                    }
                }
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                    "ReferenceInvoice cannot be null!!");
            }
        }

        if (localReferenceSalesBookTracker) {
            if (localReferenceSalesBook != null) {
                for (int i = 0; i < localReferenceSalesBook.length; i++) {
                    if (localReferenceSalesBook[i] != null) {
                        elementList.add(new javax.xml.namespace.QName(
                                "http://www.fu.gov.si/", "ReferenceSalesBook"));
                        elementList.add(localReferenceSalesBook[i]);
                    } else {
                        // nothing to do
                    }
                }
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                    "ReferenceSalesBook cannot be null!!");
            }
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
        public static InvoiceType parse(javax.xml.stream.XMLStreamReader reader)
            throws java.lang.Exception {
            InvoiceType object = new InvoiceType();

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

                        if (!"InvoiceType".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (InvoiceType) si.gov.fu.www.v1.cash_registers.ExtensionMapper.getTypeObject(nsUri,
                                type, reader);
                        }
                    }
                }

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                reader.next();

                java.util.ArrayList list9 = new java.util.ArrayList();

                java.util.ArrayList list14 = new java.util.ArrayList();

                java.util.ArrayList list15 = new java.util.ArrayList();

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
                            "IssueDateTime").equals(reader.getName())) {
                    object.setIssueDateTime(si.gov.fu.www.DateTime.Factory.parse(
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
                            "NumberingStructure").equals(reader.getName())) {
                    object.setNumberingStructure(si.gov.fu.www.NumberingStructureType.Factory.parse(
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
                            "InvoiceIdentifier").equals(reader.getName())) {
                    object.setInvoiceIdentifier(si.gov.fu.www.IdentifierType.Factory.parse(
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
                            "CustomerVATNumber").equals(reader.getName())) {
                    object.setCustomerVATNumber(si.gov.fu.www.CustomerVATType.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "InvoiceAmount").equals(reader.getName())) {
                    object.setInvoiceAmount(si.gov.fu.www.AmountType.Factory.parse(
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
                            "ReturnsAmount").equals(reader.getName())) {
                    object.setReturnsAmount(si.gov.fu.www.AmountType.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "PaymentAmount").equals(reader.getName())) {
                    object.setPaymentAmount(si.gov.fu.www.AmountType.Factory.parse(
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
                            "TaxesPerSeller").equals(reader.getName())) {
                    // Process the array and step past its final element's end.
                    list9.add(si.gov.fu.www.TaxesPerSellerType.Factory.parse(
                            reader));

                    //loop until we find a start element that is not part of this array
                    boolean loopDone9 = false;

                    while (!loopDone9) {
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
                            loopDone9 = true;
                        } else {
                            if (new javax.xml.namespace.QName(
                                        "http://www.fu.gov.si/",
                                        "TaxesPerSeller").equals(
                                        reader.getName())) {
                                list9.add(si.gov.fu.www.TaxesPerSellerType.Factory.parse(
                                        reader));
                            } else {
                                loopDone9 = true;
                            }
                        }
                    }

                    // call the converter utility  to convert and set the array
                    object.setTaxesPerSeller((si.gov.fu.www.TaxesPerSellerType[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                            si.gov.fu.www.TaxesPerSellerType.class, list9));
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
                            "OperatorTaxNumber").equals(reader.getName())) {
                    object.setOperatorTaxNumber(si.gov.fu.www.TaxNumberType.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "ForeignOperator").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "ForeignOperator" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setForeignOperator(org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "ProtectedID").equals(reader.getName())) {
                    object.setProtectedID(si.gov.fu.www.ProtectedID_type1.Factory.parse(
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
                            "SubsequentSubmit").equals(reader.getName())) {
                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                            "nil");

                    if ("true".equals(nillableValue) ||
                            "1".equals(nillableValue)) {
                        throw new org.apache.axis2.databinding.ADBException(
                            "The element: " + "SubsequentSubmit" +
                            "  cannot be null");
                    }

                    java.lang.String content = reader.getElementText();

                    object.setSubsequentSubmit(org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(
                            content));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "ReferenceInvoice").equals(reader.getName())) {
                    // Process the array and step past its final element's end.
                    list14.add(si.gov.fu.www.ReferenceInvoice_type0.Factory.parse(
                            reader));

                    //loop until we find a start element that is not part of this array
                    boolean loopDone14 = false;

                    while (!loopDone14) {
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
                            loopDone14 = true;
                        } else {
                            if (new javax.xml.namespace.QName(
                                        "http://www.fu.gov.si/",
                                        "ReferenceInvoice").equals(
                                        reader.getName())) {
                                list14.add(si.gov.fu.www.ReferenceInvoice_type0.Factory.parse(
                                        reader));
                            } else {
                                loopDone14 = true;
                            }
                        }
                    }

                    // call the converter utility  to convert and set the array
                    object.setReferenceInvoice((si.gov.fu.www.ReferenceInvoice_type0[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                            si.gov.fu.www.ReferenceInvoice_type0.class, list14));
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "ReferenceSalesBook").equals(reader.getName())) {
                    // Process the array and step past its final element's end.
                    list15.add(si.gov.fu.www.ReferenceSalesBook_type0.Factory.parse(
                            reader));

                    //loop until we find a start element that is not part of this array
                    boolean loopDone15 = false;

                    while (!loopDone15) {
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
                            loopDone15 = true;
                        } else {
                            if (new javax.xml.namespace.QName(
                                        "http://www.fu.gov.si/",
                                        "ReferenceSalesBook").equals(
                                        reader.getName())) {
                                list15.add(si.gov.fu.www.ReferenceSalesBook_type0.Factory.parse(
                                        reader));
                            } else {
                                loopDone15 = true;
                            }
                        }
                    }

                    // call the converter utility  to convert and set the array
                    object.setReferenceSalesBook((si.gov.fu.www.ReferenceSalesBook_type0[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                            si.gov.fu.www.ReferenceSalesBook_type0.class, list15));
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "SpecialNotes").equals(reader.getName())) {
                    object.setSpecialNotes(si.gov.fu.www.SpecialNotes_type1.Factory.parse(
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
