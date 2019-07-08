//********************************************************************************
//
//    Copyright (C) 2015  GoUnitis, Jurij Zelic s.p.
//
//    This program is free software; you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation; either version 2 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU Lesser General Public License for more details.
//
//********************************************************************************
//    Revision history:
//        12.10.2015: J. Zelic - First Version
//********************************************************************************
package si.gounitis.fursplugin.tests;

import org.junit.Ignore;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import si.gounitis.fursplugin.helpers.SignApache;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:test.properties")
public class TestSign {
    private static String ID_VALUE = "data";

    @Value("${issuer.signcert.alias}")
    public String signingCertAlias;

    @Ignore
    @Test
    public void testSign() {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("A");
            doc.appendChild(rootElement);

            //Element subElement = doc.createElement("A1");
            //rootElement.appendChild(subElement);

            Element firstSubElement = doc.createElement("B");
            firstSubElement.setAttribute("Id",ID_VALUE);
            firstSubElement.setIdAttribute("Id", true);  // sign B element
            rootElement.appendChild(firstSubElement);
            //subElement.appendChild(firstSubElement);

            Element secondSubElement = doc.createElement("C");
            firstSubElement.appendChild(secondSubElement);

            //Document sdoc = Sign.signDocument(doc, "#"+ID_VALUE, "signcert");
            //printDocument(sdoc);

            Document sdoc = SignApache.signDocument(doc, "#" + ID_VALUE, signingCertAlias);
            printDocument(sdoc);
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
