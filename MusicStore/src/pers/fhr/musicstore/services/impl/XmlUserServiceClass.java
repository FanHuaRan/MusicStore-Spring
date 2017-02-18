package pers.fhr.musicstore.services.impl;
import java.io.File; 
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList; 
import org.springframework.stereotype.Service;

import pers.fhr.musicstore.services.IUserService;
@Service
public class XmlUserServiceClass implements IUserService {

	@Override
	public String findUser(String userName, String password) {
		try {
		File file=new File("");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(file); 
		NodeList nl = doc.getElementsByTagName("user");
		for (int i = 0; i < nl.getLength(); i++) { 
			// Node node=n1.get
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public boolean insertUser(String userName, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
