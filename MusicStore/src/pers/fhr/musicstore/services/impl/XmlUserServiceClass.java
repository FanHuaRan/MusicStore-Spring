package pers.fhr.musicstore.services.impl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pers.fhr.musicstore.services.IUserService;
@Service
public class XmlUserServiceClass implements IUserService {
	private static Logger logger = Logger.getLogger(XmlUserServiceClass.class);
	@Override
	public String findUserRole(String userName, String password) {
		try {
		File file = getUserXmlFile();
		Document doc = getDocument(file); 
		Element root = doc.getDocumentElement(); // 获取根元素
		NodeList users = root.getElementsByTagName("user");
		for (int i = 0; i < users.getLength(); i++) { 
			Element user = (Element) users.item(i);
			String name=user.getAttribute("username");
			String pwd=user.getAttribute("password");
			if(name.equals(userName)&&pwd.equals(password)){
				return user.getAttribute("role");
			}
		}} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} 
		return null;
	}
	public String findUserPassword(String userName){
		try {
			File file = getUserXmlFile();
			Document doc = getDocument(file); 
			Element root = doc.getDocumentElement(); // 获取根元素
			NodeList users = root.getElementsByTagName("user");
			for (int i = 0; i < users.getLength(); i++) { 
				Element user = (Element) users.item(i);
				String name=user.getAttribute("username");
				if(name.equals(userName)){
					return user.getAttribute("password");
				}
			}} catch (Exception e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			} 
			return null;
	}
	
	@Override
	public boolean insertUser(String userName, String password,String role) {
		try {
			File file = getUserXmlFile();
			Document doc= getDocument(file);
			Element root = doc.getDocumentElement(); 
			Element user = createUserElement(userName, password, role, doc);
			root.appendChild(user);
			Source sour = new DOMSource(doc);
		    Result result = new StreamResult (new FileOutputStream(file));
		    return write (sour, result);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} 
		
		return false;
	}

	private Element createUserElement(String userName, String password, String role, Document doc) {
		Element user = doc.createElement("user");
		user.setAttribute("username", userName);
		user.setAttribute("password", password);
		user.setAttribute("role", role);
		return user;
	}
	  private boolean write(Source source,Result result) {
		    TransformerFactory tffactory = TransformerFactory.newInstance();
		    Transformer tr;
		    try {
		      tr = tffactory.newTransformer();
		      tr.transform(source, result);
		      return true;
		    } catch (TransformerConfigurationException e) {
		      logger.error(e.getMessage());
		      e.printStackTrace();
		      
		    } catch (TransformerException e) {
		    	logger.error(e.getMessage());
		      e.printStackTrace();
		    }
		    return false;
	  }
	  private Document getDocument(File file) throws ParserConfigurationException, SAXException, IOException {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			return doc;
		}

		private File getUserXmlFile() {
			 String path = XmlUserServiceClass.class.getClass().getResource("/").getPath();
	         path = path.substring(1, path.indexOf("classes"));
			File file=new File(path+"musicstore-users");
			return file;
		}

}
