package baza_danych1;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile {

  public static void main(String argv[]) {

    try {

	File fXmlFile = new File("C:\\Users\\Agnieszka\\workspace\\baza_danych1\\src\\baza_danych1\\pracownik.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
			
	
	doc.getDocumentElement().normalize();

	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			
	NodeList nList = doc.getElementsByTagName("staff");
			
	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
				
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
				
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			System.out.println("id : " + eElement.getAttribute("id"));
			System.out.println("imie : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
			System.out.println("nazwisko : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
			
			System.out.println("stawka : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }

}