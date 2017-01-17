import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by 33558 on 17.01.2017.
 */
public class MainXml_1  {
    public static void main(String[] args) {
        String pathFile = "1.xml";
        File xmlFile = new File(pathFile);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            Element root = document.getDocumentElement();
            System.out.println("Element : " + root.getNodeName());
            System.out.println("----------------------");
            NodeList nodeList = root.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Book: ");
                    System.out.println("Author: " + element.getElementsByTagName("author").item(0)
                            .getChildNodes().item(0).getNodeValue());
                    System.out.println("Title: " + element.getElementsByTagName("title").item(0)
                            .getChildNodes().item(0).getNodeValue());
                    System.out.println("Price: " + element.getElementsByTagName("price").item(0)
                            .getChildNodes().item(0).getNodeValue());
                    System.out.println("Genre: " + element.getElementsByTagName("genre").item(0)
                            .getChildNodes().item(0).getNodeValue());
                    System.out.println("Publish_date: " + element.getElementsByTagName("publish_date").item(0)
                            .getChildNodes().item(0).getNodeValue());
                    System.out.println("-----------------------");
                }
            }
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
