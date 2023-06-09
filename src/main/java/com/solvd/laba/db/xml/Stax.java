package main.java.com.solvd.laba.db.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

public class Stax {
	private static final Logger LOGGER = LogManager.getLogger(Stax.class);

	static void validate(String xsdP, String xmlP) {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdP));
			Validator val = schema.newValidator();
			val.validate(new StreamSource(new File(xmlP)));
			LOGGER.info("Valid!");
		} catch (IOException | SAXException e) {
			LOGGER.error("Exception: " + e.getMessage());
		}
	}

	static XMLEventReader getReader(String filePath) throws FileNotFoundException, XMLStreamException {
		String path = filePath;
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader reader = factory.createXMLEventReader(new FileInputStream(path));
		return reader;
	}

	static void parseMaterials() throws FileNotFoundException, XMLStreamException {
		XMLEventReader reader = getReader("src/main/resources/materials.xml");

		while (reader.hasNext()) {
			XMLEvent next = reader.nextEvent();
			if (next.isStartElement()) {
				StartElement startElement = next.asStartElement();
				switch (startElement.getName().getLocalPart()) {
				case "material":
					LOGGER.info("Material:");
					break;
				case "materialId":
					next = reader.nextEvent();
					LOGGER.info("Id " + Integer.parseInt(next.asCharacters().getData()));
					break;
				case "materialName":
					next = reader.nextEvent();
					LOGGER.info("Name " + next.asCharacters().getData());
					break;
				case "materialDesc":
					next = reader.nextEvent();
					LOGGER.info("Desc " + next.asCharacters().getData());
					break;
				case "materialPrice":
					next = reader.nextEvent();
					LOGGER.info("Price " + Integer.parseInt(next.asCharacters().getData()));
					break;
				}
			}
			if (next.isEndElement()) {
				EndElement end = next.asEndElement();
				if (end.getName().getLocalPart().equals("material")) {
					LOGGER.info("----------------------");
				}
			}
		}
	}

	static void parseEmployees() throws FileNotFoundException, XMLStreamException {
		XMLEventReader reader = getReader("src/main/resources/employees.xml");

		while (reader.hasNext()) {
			XMLEvent next = reader.nextEvent();
			if (next.isStartElement()) {
				StartElement startElement = next.asStartElement();
				switch (startElement.getName().getLocalPart()) {
				case "employee":
					LOGGER.info("Employee:");
					break;
				case "empId":
					next = reader.nextEvent();
					LOGGER.info("Id " + Integer.parseInt(next.asCharacters().getData()));
					break;
				case "firstName":
					next = reader.nextEvent();
					LOGGER.info("First Name " + next.asCharacters().getData());
					break;
				case "lastName":
					next = reader.nextEvent();
					LOGGER.info("Last Name " + next.asCharacters().getData());
					break;
				case "age":
					next = reader.nextEvent();
					LOGGER.info("Age " + Integer.parseInt(next.asCharacters().getData()));
					break;
				case "email":
					next = reader.nextEvent();
					LOGGER.info("Email " + next.asCharacters().getData());
					break;
				case "phoneNumber":
					next = reader.nextEvent();
					LOGGER.info("Phone Number " + next.asCharacters().getData());
					break;
				case "job":
					next = reader.nextEvent();
					LOGGER.info("Job " + next.asCharacters().getData());
					break;
				case "jobId":
					next = reader.nextEvent();
					LOGGER.info("Id " + next.asCharacters().getData());
					break;
				case "jobTitle":
					next = reader.nextEvent();
					LOGGER.info("Job Title " + next.asCharacters().getData());
					break;
				}
			}
			if (next.isEndElement()) {
				EndElement end = next.asEndElement();
				if (end.getName().getLocalPart().equals("employee")) {
					LOGGER.info("----------------------");
				}
			}
		}
	}

	static void parseClients() throws FileNotFoundException, XMLStreamException {
		XMLEventReader reader = getReader("src/main/resources/clients.xml");

		while (reader.hasNext()) {
			XMLEvent next = reader.nextEvent();
			if (next.isStartElement()) {
				StartElement startElement = next.asStartElement();
				switch (startElement.getName().getLocalPart()) {
				case "client":
					LOGGER.info("Client:");
					break;
				case "clientId":
					next = reader.nextEvent();
					LOGGER.info("Id " + Integer.parseInt(next.asCharacters().getData()));
					break;
				case "firstName":
					next = reader.nextEvent();
					LOGGER.info("First Name " + next.asCharacters().getData());
					break;
				case "lastName":
					next = reader.nextEvent();
					LOGGER.info("Last Name " + next.asCharacters().getData());
					break;
				case "email":
					next = reader.nextEvent();
					LOGGER.info("Email " + next.asCharacters().getData());
					break;
				case "phoneNumber":
					next = reader.nextEvent();
					LOGGER.info("Phone Number " + next.asCharacters().getData());
					break;
				case "companyName":
					next = reader.nextEvent();
					LOGGER.info("Company Name " + next.asCharacters().getData());
					break;
				}
			}
			if (next.isEndElement()) {
				EndElement end = next.asEndElement();
				if (end.getName().getLocalPart().equals("client")) {
					LOGGER.info("----------------------");
				}
			}
		}
	}

	static void parseSites() throws FileNotFoundException, XMLStreamException {
		XMLEventReader reader = getReader("src/main/resources/sites.xml");

		while (reader.hasNext()) {
			XMLEvent next = reader.nextEvent();
			if (next.isStartElement()) {
				StartElement startElement = next.asStartElement();
				switch (startElement.getName().getLocalPart()) {
				case "site":
					LOGGER.info("Site:");
					break;
				case "siteId":
					next = reader.nextEvent();
					LOGGER.info("Site Id " + Integer.parseInt(next.asCharacters().getData()));
					break;
				case "address":
					next = reader.nextEvent();
					LOGGER.info("Address " + next.asCharacters().getData());
					break;
				case "city":
					next = reader.nextEvent();
					LOGGER.info("City " + next.asCharacters().getData());
					break;
				case "cityId":
					next = reader.nextEvent();
					LOGGER.info("City Id " + Integer.parseInt(next.asCharacters().getData()));
					break;
				case "cityName":
					next = reader.nextEvent();
					LOGGER.info("City Name " + next.asCharacters().getData());
					break;
				case "state":
					next = reader.nextEvent();
					LOGGER.info("State " + next.asCharacters().getData());
					break;
				case "stateId":
					next = reader.nextEvent();
					LOGGER.info("State Id " + next.asCharacters().getData());
					break;
				case "stateName":
					next = reader.nextEvent();
					LOGGER.info("State Name " + next.asCharacters().getData());
					break;
				}
			}
			if (next.isEndElement()) {
				EndElement end = next.asEndElement();
				if (end.getName().getLocalPart().equals("site")) {
					LOGGER.info("----------------------");
				}
			}
		}
	}

	public static void main(String[] args) throws SQLException, SAXException, IOException, XMLStreamException {
		String xsdPM = "src/main/resources/materials.xsd";
		String xmlPM = "src/main/resources/materials.xml";
		validate(xsdPM, xmlPM);
		parseMaterials();

		String xsdPE = "src/main/resources/employees.xsd";
		String xmlPE = "src/main/resources/employees.xml";
		validate(xsdPE, xmlPE);
		parseEmployees();

		String xsdPC = "src/main/resources/clients.xsd";
		String xmlPC = "src/main/resources/clients.xml";
		validate(xsdPC, xmlPC);
		parseClients();

		String xsdPS = "src/main/resources/sites.xsd";
		String xmlPS = "src/main/resources/sites.xml";
		validate(xsdPS, xmlPS);
		parseSites();
	}
}
