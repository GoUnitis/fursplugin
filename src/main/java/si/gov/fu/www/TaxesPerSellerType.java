/**
 * TaxesPerSellerType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:18:31 BST)
 */
package si.gov.fu.www;


/**
 *  TaxesPerSellerType bean class
 */
@SuppressWarnings({"unchecked",
    "unused"
})
public class TaxesPerSellerType implements org.apache.axis2.databinding.ADBBean {
    /* This type was generated from the piece of schema that had
       name = TaxesPerSellerType
       Namespace URI = http://www.fu.gov.si/
       Namespace Prefix = ns2
     */

    /**
     * field for SellerTaxNumber
     */
    protected si.gov.fu.www.TaxNumberType localSellerTaxNumber;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSellerTaxNumberTracker = false;

    /**
     * field for VAT
     * This was an Array!
     */
    protected si.gov.fu.www.VATType[] localVAT;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localVATTracker = false;

    /**
     * field for FlatRateCompensation
     * This was an Array!
     */
    protected si.gov.fu.www.FlatRateCompensationType[] localFlatRateCompensation;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localFlatRateCompensationTracker = false;

    /**
     * field for OtherTaxesAmount
     */
    protected si.gov.fu.www.TaxAmountType localOtherTaxesAmount;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localOtherTaxesAmountTracker = false;

    /**
     * field for ExemptVATTaxableAmount
     */
    protected si.gov.fu.www.TaxableAmountType localExemptVATTaxableAmount;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localExemptVATTaxableAmountTracker = false;

    /**
     * field for ReverseVATTaxableAmount
     */
    protected si.gov.fu.www.TaxableAmountType localReverseVATTaxableAmount;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localReverseVATTaxableAmountTracker = false;

    /**
     * field for NontaxableAmount
     */
    protected si.gov.fu.www.TaxableAmountType localNontaxableAmount;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localNontaxableAmountTracker = false;

    /**
     * field for SpecialTaxRulesAmount
     */
    protected si.gov.fu.www.TaxableAmountType localSpecialTaxRulesAmount;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localSpecialTaxRulesAmountTracker = false;

    public boolean isSellerTaxNumberSpecified() {
        return localSellerTaxNumberTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.TaxNumberType
     */
    public si.gov.fu.www.TaxNumberType getSellerTaxNumber() {
        return localSellerTaxNumber;
    }

    /**
     * Auto generated setter method
     * @param param SellerTaxNumber
     */
    public void setSellerTaxNumber(si.gov.fu.www.TaxNumberType param) {
        localSellerTaxNumberTracker = param != null;

        this.localSellerTaxNumber = param;
    }

    public boolean isVATSpecified() {
        return localVATTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.VATType[]
     */
    public si.gov.fu.www.VATType[] getVAT() {
        return localVAT;
    }

    /**
     * validate the array for VAT
     */
    protected void validateVAT(si.gov.fu.www.VATType[] param) {
    }

    /**
     * Auto generated setter method
     * @param param VAT
     */
    public void setVAT(si.gov.fu.www.VATType[] param) {
        validateVAT(param);

        localVATTracker = param != null;

        this.localVAT = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * @param param si.gov.fu.www.VATType
     */
    public void addVAT(si.gov.fu.www.VATType param) {
        if (localVAT == null) {
            localVAT = new si.gov.fu.www.VATType[] {  };
        }

        //update the setting tracker
        localVATTracker = true;

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localVAT);
        list.add(param);
        this.localVAT = (si.gov.fu.www.VATType[]) list.toArray(new si.gov.fu.www.VATType[list.size()]);
    }

    public boolean isFlatRateCompensationSpecified() {
        return localFlatRateCompensationTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.FlatRateCompensationType[]
     */
    public si.gov.fu.www.FlatRateCompensationType[] getFlatRateCompensation() {
        return localFlatRateCompensation;
    }

    /**
     * validate the array for FlatRateCompensation
     */
    protected void validateFlatRateCompensation(
        si.gov.fu.www.FlatRateCompensationType[] param) {
    }

    /**
     * Auto generated setter method
     * @param param FlatRateCompensation
     */
    public void setFlatRateCompensation(
        si.gov.fu.www.FlatRateCompensationType[] param) {
        validateFlatRateCompensation(param);

        localFlatRateCompensationTracker = param != null;

        this.localFlatRateCompensation = param;
    }

    /**
     * Auto generated add method for the array for convenience
     * @param param si.gov.fu.www.FlatRateCompensationType
     */
    public void addFlatRateCompensation(
        si.gov.fu.www.FlatRateCompensationType param) {
        if (localFlatRateCompensation == null) {
            localFlatRateCompensation = new si.gov.fu.www.FlatRateCompensationType[] {
                    
                };
        }

        //update the setting tracker
        localFlatRateCompensationTracker = true;

        java.util.List list = org.apache.axis2.databinding.utils.ConverterUtil.toList(localFlatRateCompensation);
        list.add(param);
        this.localFlatRateCompensation = (si.gov.fu.www.FlatRateCompensationType[]) list.toArray(new si.gov.fu.www.FlatRateCompensationType[list.size()]);
    }

    public boolean isOtherTaxesAmountSpecified() {
        return localOtherTaxesAmountTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.TaxAmountType
     */
    public si.gov.fu.www.TaxAmountType getOtherTaxesAmount() {
        return localOtherTaxesAmount;
    }

    /**
     * Auto generated setter method
     * @param param OtherTaxesAmount
     */
    public void setOtherTaxesAmount(si.gov.fu.www.TaxAmountType param) {
        localOtherTaxesAmountTracker = param != null;

        this.localOtherTaxesAmount = param;
    }

    public boolean isExemptVATTaxableAmountSpecified() {
        return localExemptVATTaxableAmountTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.TaxableAmountType
     */
    public si.gov.fu.www.TaxableAmountType getExemptVATTaxableAmount() {
        return localExemptVATTaxableAmount;
    }

    /**
     * Auto generated setter method
     * @param param ExemptVATTaxableAmount
     */
    public void setExemptVATTaxableAmount(si.gov.fu.www.TaxableAmountType param) {
        localExemptVATTaxableAmountTracker = param != null;

        this.localExemptVATTaxableAmount = param;
    }

    public boolean isReverseVATTaxableAmountSpecified() {
        return localReverseVATTaxableAmountTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.TaxableAmountType
     */
    public si.gov.fu.www.TaxableAmountType getReverseVATTaxableAmount() {
        return localReverseVATTaxableAmount;
    }

    /**
     * Auto generated setter method
     * @param param ReverseVATTaxableAmount
     */
    public void setReverseVATTaxableAmount(
        si.gov.fu.www.TaxableAmountType param) {
        localReverseVATTaxableAmountTracker = param != null;

        this.localReverseVATTaxableAmount = param;
    }

    public boolean isNontaxableAmountSpecified() {
        return localNontaxableAmountTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.TaxableAmountType
     */
    public si.gov.fu.www.TaxableAmountType getNontaxableAmount() {
        return localNontaxableAmount;
    }

    /**
     * Auto generated setter method
     * @param param NontaxableAmount
     */
    public void setNontaxableAmount(si.gov.fu.www.TaxableAmountType param) {
        localNontaxableAmountTracker = param != null;

        this.localNontaxableAmount = param;
    }

    public boolean isSpecialTaxRulesAmountSpecified() {
        return localSpecialTaxRulesAmountTracker;
    }

    /**
     * Auto generated getter method
     * @return si.gov.fu.www.TaxableAmountType
     */
    public si.gov.fu.www.TaxableAmountType getSpecialTaxRulesAmount() {
        return localSpecialTaxRulesAmount;
    }

    /**
     * Auto generated setter method
     * @param param SpecialTaxRulesAmount
     */
    public void setSpecialTaxRulesAmount(si.gov.fu.www.TaxableAmountType param) {
        localSpecialTaxRulesAmountTracker = param != null;

        this.localSpecialTaxRulesAmount = param;
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
                    namespacePrefix + ":TaxesPerSellerType", xmlWriter);
            } else {
                writeAttribute("xsi",
                    "http://www.w3.org/2001/XMLSchema-instance", "type",
                    "TaxesPerSellerType", xmlWriter);
            }
        }

        if (localSellerTaxNumberTracker) {
            if (localSellerTaxNumber == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SellerTaxNumber cannot be null!!");
            }

            localSellerTaxNumber.serialize(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "SellerTaxNumber"), xmlWriter);
        }

        if (localVATTracker) {
            if (localVAT != null) {
                for (int i = 0; i < localVAT.length; i++) {
                    if (localVAT[i] != null) {
                        localVAT[i].serialize(new javax.xml.namespace.QName(
                                "http://www.fu.gov.si/", "VAT"), xmlWriter);
                    } else {
                        // we don't have to do any thing since minOccures is zero
                    }
                }
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                    "VAT cannot be null!!");
            }
        }

        if (localFlatRateCompensationTracker) {
            if (localFlatRateCompensation != null) {
                for (int i = 0; i < localFlatRateCompensation.length; i++) {
                    if (localFlatRateCompensation[i] != null) {
                        localFlatRateCompensation[i].serialize(new javax.xml.namespace.QName(
                                "http://www.fu.gov.si/", "FlatRateCompensation"),
                            xmlWriter);
                    } else {
                        // we don't have to do any thing since minOccures is zero
                    }
                }
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                    "FlatRateCompensation cannot be null!!");
            }
        }

        if (localOtherTaxesAmountTracker) {
            if (localOtherTaxesAmount == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "OtherTaxesAmount cannot be null!!");
            }

            localOtherTaxesAmount.serialize(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "OtherTaxesAmount"), xmlWriter);
        }

        if (localExemptVATTaxableAmountTracker) {
            if (localExemptVATTaxableAmount == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ExemptVATTaxableAmount cannot be null!!");
            }

            localExemptVATTaxableAmount.serialize(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "ExemptVATTaxableAmount"),
                xmlWriter);
        }

        if (localReverseVATTaxableAmountTracker) {
            if (localReverseVATTaxableAmount == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ReverseVATTaxableAmount cannot be null!!");
            }

            localReverseVATTaxableAmount.serialize(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "ReverseVATTaxableAmount"),
                xmlWriter);
        }

        if (localNontaxableAmountTracker) {
            if (localNontaxableAmount == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "NontaxableAmount cannot be null!!");
            }

            localNontaxableAmount.serialize(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "NontaxableAmount"), xmlWriter);
        }

        if (localSpecialTaxRulesAmountTracker) {
            if (localSpecialTaxRulesAmount == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SpecialTaxRulesAmount cannot be null!!");
            }

            localSpecialTaxRulesAmount.serialize(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "SpecialTaxRulesAmount"), xmlWriter);
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

        if (localSellerTaxNumberTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "SellerTaxNumber"));

            if (localSellerTaxNumber == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SellerTaxNumber cannot be null!!");
            }

            elementList.add(localSellerTaxNumber);
        }

        if (localVATTracker) {
            if (localVAT != null) {
                for (int i = 0; i < localVAT.length; i++) {
                    if (localVAT[i] != null) {
                        elementList.add(new javax.xml.namespace.QName(
                                "http://www.fu.gov.si/", "VAT"));
                        elementList.add(localVAT[i]);
                    } else {
                        // nothing to do
                    }
                }
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                    "VAT cannot be null!!");
            }
        }

        if (localFlatRateCompensationTracker) {
            if (localFlatRateCompensation != null) {
                for (int i = 0; i < localFlatRateCompensation.length; i++) {
                    if (localFlatRateCompensation[i] != null) {
                        elementList.add(new javax.xml.namespace.QName(
                                "http://www.fu.gov.si/", "FlatRateCompensation"));
                        elementList.add(localFlatRateCompensation[i]);
                    } else {
                        // nothing to do
                    }
                }
            } else {
                throw new org.apache.axis2.databinding.ADBException(
                    "FlatRateCompensation cannot be null!!");
            }
        }

        if (localOtherTaxesAmountTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "OtherTaxesAmount"));

            if (localOtherTaxesAmount == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "OtherTaxesAmount cannot be null!!");
            }

            elementList.add(localOtherTaxesAmount);
        }

        if (localExemptVATTaxableAmountTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "ExemptVATTaxableAmount"));

            if (localExemptVATTaxableAmount == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ExemptVATTaxableAmount cannot be null!!");
            }

            elementList.add(localExemptVATTaxableAmount);
        }

        if (localReverseVATTaxableAmountTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "ReverseVATTaxableAmount"));

            if (localReverseVATTaxableAmount == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "ReverseVATTaxableAmount cannot be null!!");
            }

            elementList.add(localReverseVATTaxableAmount);
        }

        if (localNontaxableAmountTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "NontaxableAmount"));

            if (localNontaxableAmount == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "NontaxableAmount cannot be null!!");
            }

            elementList.add(localNontaxableAmount);
        }

        if (localSpecialTaxRulesAmountTracker) {
            elementList.add(new javax.xml.namespace.QName(
                    "http://www.fu.gov.si/", "SpecialTaxRulesAmount"));

            if (localSpecialTaxRulesAmount == null) {
                throw new org.apache.axis2.databinding.ADBException(
                    "SpecialTaxRulesAmount cannot be null!!");
            }

            elementList.add(localSpecialTaxRulesAmount);
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
        public static TaxesPerSellerType parse(
            javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            TaxesPerSellerType object = new TaxesPerSellerType();

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

                        if (!"TaxesPerSellerType".equals(type)) {
                            //find namespace for the prefix
                            java.lang.String nsUri = reader.getNamespaceContext()
                                                           .getNamespaceURI(nsPrefix);

                            return (TaxesPerSellerType) si.gov.fu.www.v1.cash_registers.ExtensionMapper.getTypeObject(nsUri,
                                type, reader);
                        }
                    }
                }

                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();

                reader.next();

                java.util.ArrayList list2 = new java.util.ArrayList();

                java.util.ArrayList list3 = new java.util.ArrayList();

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "SellerTaxNumber").equals(reader.getName())) {
                    object.setSellerTaxNumber(si.gov.fu.www.TaxNumberType.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "VAT").equals(reader.getName())) {
                    // Process the array and step past its final element's end.
                    list2.add(si.gov.fu.www.VATType.Factory.parse(reader));

                    //loop until we find a start element that is not part of this array
                    boolean loopDone2 = false;

                    while (!loopDone2) {
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
                            loopDone2 = true;
                        } else {
                            if (new javax.xml.namespace.QName(
                                        "http://www.fu.gov.si/", "VAT").equals(
                                        reader.getName())) {
                                list2.add(si.gov.fu.www.VATType.Factory.parse(
                                        reader));
                            } else {
                                loopDone2 = true;
                            }
                        }
                    }

                    // call the converter utility  to convert and set the array
                    object.setVAT((si.gov.fu.www.VATType[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                            si.gov.fu.www.VATType.class, list2));
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "FlatRateCompensation").equals(reader.getName())) {
                    // Process the array and step past its final element's end.
                    list3.add(si.gov.fu.www.FlatRateCompensationType.Factory.parse(
                            reader));

                    //loop until we find a start element that is not part of this array
                    boolean loopDone3 = false;

                    while (!loopDone3) {
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
                            loopDone3 = true;
                        } else {
                            if (new javax.xml.namespace.QName(
                                        "http://www.fu.gov.si/",
                                        "FlatRateCompensation").equals(
                                        reader.getName())) {
                                list3.add(si.gov.fu.www.FlatRateCompensationType.Factory.parse(
                                        reader));
                            } else {
                                loopDone3 = true;
                            }
                        }
                    }

                    // call the converter utility  to convert and set the array
                    object.setFlatRateCompensation((si.gov.fu.www.FlatRateCompensationType[]) org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                            si.gov.fu.www.FlatRateCompensationType.class, list3));
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "OtherTaxesAmount").equals(reader.getName())) {
                    object.setOtherTaxesAmount(si.gov.fu.www.TaxAmountType.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "ExemptVATTaxableAmount").equals(reader.getName())) {
                    object.setExemptVATTaxableAmount(si.gov.fu.www.TaxableAmountType.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "ReverseVATTaxableAmount").equals(reader.getName())) {
                    object.setReverseVATTaxableAmount(si.gov.fu.www.TaxableAmountType.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "NontaxableAmount").equals(reader.getName())) {
                    object.setNontaxableAmount(si.gov.fu.www.TaxableAmountType.Factory.parse(
                            reader));

                    reader.next();
                } // End of if for expected property start element

                else {
                }

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                if (reader.isStartElement() &&
                        new javax.xml.namespace.QName("http://www.fu.gov.si/",
                            "SpecialTaxRulesAmount").equals(reader.getName())) {
                    object.setSpecialTaxRulesAmount(si.gov.fu.www.TaxableAmountType.Factory.parse(
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
