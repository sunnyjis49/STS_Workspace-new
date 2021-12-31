package demo.xmlparser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class UpdateXmlFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create document
		File file = new File("G:\\Test/file.xml");
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			Document doc = saxBuilder.build(file);
			//Getting the root element
			Element rootElement =doc.getRootElement();
			System.out.println("Root Element:"+rootElement.getName());
			Element staff = rootElement.getChild("staff");
			System.out.println("staff:"+rootElement.getChild("staff"));
			//Adding new attribute
			//staff.setAttribute(new Attribute("staffid", "123"));
			//Updating first name
			staff.getChild("firstname").setText("Sunny");
			//creating new elements
			Element lastname = staff.getChild("lastname");
			Element nickname = staff.getChild("nickname");
			Element salary = staff.getChild("salary");
			/*System.out.println(staff.getChild("firstname").getContentSize());*/
			if(lastname==null){
			lastname = new Element("lastname");
			lastname.setText("Hasan");
			staff.addContent(lastname);
			}
			if(nickname==null){
			nickname = new Element("nickname").setText("sanu");
			staff.addContent(nickname);
			}
			if(salary==null){
			salary = new Element("salary").setText("30000");
			staff.addContent(salary);
			}
			//updating salary for specific staff here whose staffid = 1234	
			List staffList =rootElement.getChildren("staff");
			System.out.println(staffList);
			for(int i=0;i<staffList.size();i++){
				Element node =(Element) staffList.get(i);
				System.out.println("Node:"+node.getAttributeValue("staffid"));
				String staffid = node.getAttributeValue("staffid");
				if(staffid.equalsIgnoreCase("1234")){
					node.getChild("salary").setText("35000");
				}
			}
			XMLOutputter xmlOutputter = new XMLOutputter();
			xmlOutputter.setFormat(Format.getPrettyFormat());
			xmlOutputter.output(doc, new FileWriter("G:\\Test/file.xml"));
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
