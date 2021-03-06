package demo.xmlparser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;


public class ReadXmlFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Create a document from a file or input stream
			File inputFile = new File("G:\\Test/file.xml");
			SAXBuilder saxBuilder = new SAXBuilder();//create a document builder
			Document document = saxBuilder.build(inputFile);
			//getting the root element i.e company
			Element rootElement = document.getRootElement();
			System.out.println("Root Element::"+rootElement);
			//Return list of  subelements of specified name
			System.out.println("Children::"+rootElement.getChildren("employee"));
			//Return list of all subelements
			System.out.println("All children:"+rootElement.getChildren());
			//return first child node
			System.out.println("getChild::"+rootElement.getChild("employee"));
			List empList =rootElement.getChildren("employee");
			
			for(int i=0;i<empList.size();i++){
				Element employee =(Element) empList.get(i);
				System.out.println("\nCurrent Employee:"+employee.getName());
				//return specific attribute
				Attribute empid = employee.getAttribute("empid");
				System.out.println("Employee Id:"+empid.getValue());
				System.out.println("First Name:"+employee.getChild("firstname").getText());
				System.out.println("Last Name:"+employee.getChild("lastname").getText());
				System.out.println("Nick Name:"+employee.getChild("nickname").getText());
				System.out.println("Salary:"+employee.getChild("salary").getText());
			}
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		catch (JDOMException je) {
			System.out.println(je.getMessage());
		}
		
	}

}
