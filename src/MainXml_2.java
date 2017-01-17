import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by 33558 on 17.01.2017.
 */
public class MainXml_2 {
    public static void main(String[] args) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element rootElement = document.createElement("catalog");
            document.appendChild(rootElement);

            Element book1 = document.createElement("book1");
            rootElement.appendChild(book1);

            Element author1 = document.createElement("author1");
            author1.setTextContent("Author 1");
            book1.appendChild(author1);

            Element title1 = document.createElement("title1");
            title1.setTextContent("Book 1 Title");
            book1.appendChild(title1);

            Element book2 = document.createElement("book2");
            rootElement.appendChild(book2);

            Element author2 = document.createElement("author2");
            author2.setTextContent("Author 2");
            book2.appendChild(author2);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("2.xml"));

            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
