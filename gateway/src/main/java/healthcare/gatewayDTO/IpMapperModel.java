package healthcare.gatewayDTO;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class IpMapperModel {

	private final String fileName = "Ipmapper.xml";

	private IpMapperDTO ReadCfg() throws Exception {
		
		ClassLoader classLoader = new IpMapperModel().getClass().getClassLoader();
		File XML = new File(classLoader.getResource(fileName).getFile());
		if (XML.isFile()) {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = (Document) db.parse(XML);
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("ip");
			for (int itr = 0; itr < nodeList.getLength(); itr++) {
				Node node = nodeList.item(itr);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					IpMapperDTO ipMapperDTO = new IpMapperDTO();
					ipMapperDTO.setDocIP(eElement.getElementsByTagName("doctor").item(0).getTextContent());
					ipMapperDTO.setRoomIP(eElement.getElementsByTagName("room").item(0).getTextContent());
					ipMapperDTO.setPatientIP(eElement.getElementsByTagName("patient").item(0).getTextContent());
					ipMapperDTO.setPaymentIP(eElement.getElementsByTagName("payment").item(0).getTextContent());
					ipMapperDTO.setHospitalIP(eElement.getElementsByTagName("hospital").item(0).getTextContent());
					ipMapperDTO.setAppoimentIP(eElement.getElementsByTagName("appoiment").item(0).getTextContent());
					return ipMapperDTO;

				}
			}

		}
		IpMapperDTO ipMapperDTO = new IpMapperDTO();
		return ipMapperDTO;
	}

	public IpMapperDTO getIpMapperDTO() {
		try {
			return ReadCfg();
		} catch (Exception e) {
			IpMapperDTO ipMapperDTO = new IpMapperDTO();
			e.printStackTrace();
			return ipMapperDTO;
		}
	}

}
