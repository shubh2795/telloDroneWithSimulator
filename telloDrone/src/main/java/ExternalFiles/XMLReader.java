package ExternalFiles;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.*;
import java.io.*;

public class XMLReader {
    public static void Reader() {


try {
        File inputFile = new File("Missions.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);

        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        NodeList message = doc.getElementsByTagName("Mission");


        for (int i = 0; i < message.getLength(); i++) {
            String a = String.valueOf(message.item(i).getChildNodes());

                          System.out.println(a);


        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    }
}
