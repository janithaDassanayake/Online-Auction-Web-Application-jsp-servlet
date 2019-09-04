/**
 * 
 */
package util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author thilini
 *
 */
public class Util_quary extends Common_dbUtil {
	

	public static String queryByID(String id) throws SAXException, IOException, ParserConfigurationException {

		NodeList nodeList;
		Element element = null;
		
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\Thilini_BridWars\\WEB-INF\\User_management_Query.xml"))
				.getElementsByTagName(Constants.TAG_NAME);

		
		
		for (int value = 0; value < nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);
			if (element.getAttribute(Constants.ATTRIB_ID).equals(id))
				break;
		}
		return element.getTextContent().trim();
	}
}

	
	

	


