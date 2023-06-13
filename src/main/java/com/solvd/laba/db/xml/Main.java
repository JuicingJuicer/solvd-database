package main.java.com.solvd.laba.db.xml;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.model.Package;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args)
			throws SQLException, SAXException, IOException, XMLStreamException, JAXBException {
		// JAXB Employee
		Employee emp = null;
		JAXBContext context = JAXBContext.newInstance(Employee.class);
		Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
		emp = (Employee) jaxbUnmarshaller.unmarshal(new File("src/main/resources/xml/employees2.xml"));
		LOGGER.info(emp);

		// JAXB Package
		Package pack = null;
		JAXBContext con = JAXBContext.newInstance(Package.class);
		Unmarshaller um = con.createUnmarshaller();
		pack = (Package) um.unmarshal(new File("src/main/resources/xml/package.xml"));
		LOGGER.info(pack);

//		// Stax
//		ArrayList<Employee> employees = new ArrayList<>();
//		String xsdPE = "src/main/resources/xml/employees.xsd";
//		String xmlPE = "src/main/resources/xml/employees.xml";
//		Stax.validate(xsdPE, xmlPE);
//		// creates arraylist of employees
//		employees = Stax.parseEmployees();
//		LOGGER.info(employees);
//
//		String xsdPM = "src/main/resources/xml/materials.xsd";
//		String xmlPM = "src/main/resources/xml/materials.xml";
//		Stax.validate(xsdPM, xmlPM);
//		Stax.parseMaterials();
//
//		String xsdPC = "src/main/resources/xml/clients.xsd";
//		String xmlPC = "src/main/resources/xml/clients.xml";
//		Stax.validate(xsdPC, xmlPC);
//		Stax.parseClients();
//
//		String xsdPS = "src/main/resources/xml/sites.xsd";
//		String xmlPS = "src/main/resources/xml/sites.xml";
//		Stax.validate(xsdPS, xmlPS);
//		Stax.parseSites();
//
//		String xsdPB = "src/main/resources/xml/buildingTypes.xsd";
//		String xmlPB = "src/main/resources/xml/buildingTypes.xml";
//		Stax.validate(xsdPB, xmlPB);
//		Stax.parseBuildingTypes();
	}

}
