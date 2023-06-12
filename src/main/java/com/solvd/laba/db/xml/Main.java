package main.java.com.solvd.laba.db.xml;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import main.java.com.solvd.laba.db.model.Employee;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws SQLException, SAXException, IOException, XMLStreamException {
		ArrayList<Employee> employees = new ArrayList<>();
		String xsdPE = "src/main/resources/xml/employees.xsd";
		String xmlPE = "src/main/resources/xml/employees.xml";
		Stax.validate(xsdPE, xmlPE);
		// creates arraylist of employees
		employees = Stax.parseEmployees();
		LOGGER.info(employees);

		String xsdPM = "src/main/resources/xml/materials.xsd";
		String xmlPM = "src/main/resources/xml/materials.xml";
		Stax.validate(xsdPM, xmlPM);
		Stax.parseMaterials();

		String xsdPC = "src/main/resources/xml/clients.xsd";
		String xmlPC = "src/main/resources/xml/clients.xml";
		Stax.validate(xsdPC, xmlPC);
		Stax.parseClients();

		String xsdPS = "src/main/resources/xml/sites.xsd";
		String xmlPS = "src/main/resources/xml/sites.xml";
		Stax.validate(xsdPS, xmlPS);
		Stax.parseSites();

		String xsdPB = "src/main/resources/xml/buildingTypes.xsd";
		String xmlPB = "src/main/resources/xml/buildingTypes.xml";
		Stax.validate(xsdPB, xmlPB);
		Stax.parseBuildingTypes();
	}
}
