import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Rectangle {

	public Rectangle() {

	}

	public static void main(String argv[]) {
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File("shapes.xml"));

			doc.getDocumentElement().normalize();
			System.out.println("Root element of the doc is " + doc.getDocumentElement().getNodeName());

			NodeList listofcircle = doc.getElementsByTagName("triangle");

			for (int i = 0; i < listofcircle.getLength(); ++i) {
				Node firstRectangleNode = listofcircle.item(i);

				if (firstRectangleNode.getNodeType() == Node.ELEMENT_NODE) {
					Element firstRectangleElement = (Element) firstRectangleNode;

					NodeList firstCirclelist = firstRectangleElement.getElementsByTagName("id");
					Element firstidElement = (Element) firstCirclelist.item(0);

					NodeList TextFNList = firstidElement.getChildNodes();
					System.out.println("ID#: " + ((Node) TextFNList.item(0)).getNodeValue().trim());

					NodeList lengthList = firstRectangleElement.getElementsByTagName("length");
					Element LengthElement = (Element) lengthList.item(0);

					NodeList LengthList = LengthElement.getChildNodes();
					System.out.println("length: " + ((Node) LengthList.item(0)).getNodeValue().trim());

					NodeList widthList = firstRectangleElement.getElementsByTagName("width");
					Element widthElement = (Element) widthList.item(0);

					NodeList WidthList = widthElement.getChildNodes();
					System.out.println("width: " + ((Node) WidthList.item(0)).getNodeValue().trim());

					NodeList colorList = firstRectangleElement.getElementsByTagName("color");
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
