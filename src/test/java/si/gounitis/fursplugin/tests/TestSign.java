package si.gounitis.fursplugin.tests;

import org.junit.Test;
import si.gounitis.fursplugin.helpers.Sign;

import static org.junit.Assert.assertEquals;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/**
 * Created by Jure on 9.10.2015.
 */
public class TestSign {
    private static String ID_VALUE = "data";

    @Test
    public void testInvoice() {
        System.setProperty("javax.net.ssl.trustStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        System.setProperty("javax.net.ssl.keyStore", "keys/keystore.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "changeit");

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("A");
            doc.appendChild(rootElement);

            Element firstSubElement = doc.createElement("B");
            firstSubElement.setAttribute("Id",ID_VALUE);
            firstSubElement.setIdAttribute("Id", true);  // sign B element
            rootElement.appendChild(firstSubElement);

            Element secondSubElement = doc.createElement("C");
            firstSubElement.appendChild(secondSubElement);

            Document sdoc = Sign.signDocument(doc, "#"+ID_VALUE, "signcert");
            printDocument(sdoc);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void printDocument(Document sdoc) {
        try {
            DOMSource domSource = new DOMSource(sdoc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(domSource, result);
            System.out.println("XML IN String format is: \n" + writer.toString());
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
