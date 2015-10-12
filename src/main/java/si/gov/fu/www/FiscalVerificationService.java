/**
 * FiscalVerificationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.3  Built on : Jun 27, 2015 (11:17:49 BST)
 */
package si.gov.fu.www;


/*
 *  FiscalVerificationService java interface
 */
public interface FiscalVerificationService {
    /**
     * Auto generated method signature
     *
     * @param invoiceRequest
     */
    public si.gov.fu.www.InvoiceResponse invoice(
        si.gov.fu.www.InvoiceRequest invoiceRequest)
        throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param echoRequest
     */
    public si.gov.fu.www.EchoResponse echo(
        si.gov.fu.www.EchoRequest echoRequest) throws java.rmi.RemoteException;

    /**
     * Auto generated method signature
     *
     * @param businessPremiseRequest
     */
    public si.gov.fu.www.BusinessPremiseResponse businessPremise(
        si.gov.fu.www.BusinessPremiseRequest businessPremiseRequest)
        throws java.rmi.RemoteException;

    //
}
