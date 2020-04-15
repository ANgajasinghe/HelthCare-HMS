package healthcare.gatewayDTO;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class IpMapperModel {

	private final String fileName = "Ipmapper.xml";
	private final String Path = "C:\\PAF";

	private IpMapperDTO ReadCfg() throws Exception {
		File dirFile = new File(Path);
		if (dirFile.isDirectory()) {
			File ipFile = new File(Path + "\\" + fileName);
			if (ipFile.exists() && ipFile.isFile()) {
				return this.IPXMLREADER(ipFile);
			}
			else {
				return this.IPXMLREADER(LOAD_FROM_RES(fileName));
			}
		}
		else {
			return this.IPXMLREADER(LOAD_FROM_RES(fileName));
		}

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
	
	
	private final IpMapperDTO IPXMLREADER(File XML) {
		try {
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
						ipMapperDTO.setUserIP(eElement.getElementsByTagName("user").item(0).getTextContent());
						ipMapperDTO.setGatewayIP(eElement.getElementsByTagName("gateway").item(0).getTextContent());
						return ipMapperDTO;
					}
				}
			}
		} catch (DOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IpMapperDTO ipMapperDTO = new IpMapperDTO();
		return ipMapperDTO;	
	}
	
	
	private final File LOAD_FROM_RES(String fileString) {
		ClassLoader classLoader = new IpMapperModel().getClass().getClassLoader();
		File XML = new File(classLoader.getResource(fileString).getFile());
		return XML;
	}

}
