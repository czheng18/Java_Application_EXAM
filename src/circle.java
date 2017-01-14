import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class circle {
	public static void main(String argv[]) {
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File("shapes.xml"));

			doc.getDocumentElement().normalize();
			System.out.println("Root element of the doc is " + doc.getDocumentElement().getNodeName());

			NodeList listofcircle = doc.getElementsByTagName("circle");

			for (int i = 0; i < listofcircle.getLength(); ++i) {
				Node firstCircleNode = listofcircle.item(i);

				if (firstCircleNode.getNodeType() == Node.ELEMENT_NODE) {
					Element firstCircleElement = (Element) firstCircleNode;

					NodeList firstCirclelist = firstCircleElement.getElementsByTagName("id");
					Element firstidElement = (Element) firstCirclelist.item(0);

					NodeList TextFNList = firstidElement.getChildNodes();
					System.out.println("ID#: " + ((Node) TextFNList.item(0)).getNodeValue().trim());

					NodeList radiusList = firstCircleElement.getElementsByTagName("radius");
					Element radiusElement = (Element) radiusList.item(0);

					NodeList TextLNList = radiusElement.getChildNodes();
					System.out.println("radius: " + ((Node) TextLNList.item(0)).getNodeValue().trim());

					NodeList colorList = firstCircleElement.getElementsByTagName("color");
					Element colorElement = (Element) colorList.item(0);

					NodeList TextcolorList = colorElement.getChildNodes();
					System.out.println("color: " + ((Node) TextcolorList.item(0)).getNodeValue().trim());

				}
			}

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
