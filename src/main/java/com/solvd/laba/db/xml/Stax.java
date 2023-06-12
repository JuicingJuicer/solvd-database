package main.java.com.solvd.laba.db.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

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

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.model.Job;
import main.java.com.solvd.laba.db.model.Team;

public class Stax {
	private static final Logger LOGGER = LogManager.getLogger(Stax.class);

	static void validate(String xsdP, String xmlP) {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdP));
			Validator val = schema.newValidator();
			ExceptionHandler eh = new ExceptionHandler();
			val.setErrorHandler(eh);
			val.validate(new StreamSource(new File(xmlP)));
			if (eh.isValid()) {
				LOGGER.info("Valid!");
			}
		} catch (SAXException | IOException e) {
			LOGGER.error("Exception: " + e.getMessage());
		}
	}

	static XMLEventReader getReader(String filePath) throws FileNotFoundException, XMLStreamException {
		String path = filePath;
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader reader = factory.createXMLEventReader(new FileInputStream(path));
		return reader;
	}

	static ArrayList<Employee> parseEmployees() throws FileNotFoundException, XMLStreamException {
		XMLEventReader reader = getReader("src/main/resources/xml/employees.xml");
		ArrayList<Employee> emps = new ArrayList<>();
		Employee emp = null;
		Job job = null;
		Team team = null;
		ArrayList<Team> teams = null;

		while (reader.hasNext()) {
			XMLEvent next = reader.nextEvent();
			if (next.isStartElement()) {
				StartElement startElement = next.asStartElement();
				switch (startElement.getName().getLocalPart()) {
				case "employee":
					emp = new Employee();
					break;
				case "empId":
					next = reader.nextEvent();
					if (StringUtils.isNumeric(next.asCharacters().getData())) {
						emp.setEmpId(Integer.parseInt(next.asCharacters().getData()));
					}
					break;
				case "firstName":
					next = reader.nextEvent();
					emp.setFirstName(next.asCharacters().getData());
					break;
				case "lastName":
					next = reader.nextEvent();
					emp.setLastName(next.asCharacters().getData());
					break;
				case "age":
					next = reader.nextEvent();
					if (StringUtils.isNumeric(next.asCharacters().getData())) {
						emp.setAge(Integer.parseInt(next.asCharacters().getData()));
					}
					break;
				case "email":
					next = reader.nextEvent();
					emp.setEmail(next.asCharacters().getData());
					break;
				case "phoneNumber":
					next = reader.nextEvent();
					emp.setPhoneNumber(next.asCharacters().getData());
					break;
				case "job":
					next = reader.nextEvent();
					job = new Job();
					break;
				case "jobId":
					next = reader.nextEvent();
					if (StringUtils.isNumeric(next.asCharacters().getData())) {
						job.setJobId(Integer.parseInt(next.asCharacters().getData()));
					}
					break;
				case "jobTitle":
					next = reader.nextEvent();
					job.setJobTitle(next.asCharacters().getData());
					break;
				case "teams":
					next = reader.nextEvent();
					teams = new ArrayList<>();
					break;
				case "team":
					next = reader.nextEvent();
					team = new Team();
					teams.add(team);
					break;
				case "teamId":
					next = reader.nextEvent();
					if (StringUtils.isNumeric(next.asCharacters().getData())) {
						team.setTeamId(Integer.parseInt(next.asCharacters().getData()));
					}
					break;
				case "teamName":
					next = reader.nextEvent();
					team.setTeamName(next.asCharacters().getData());
					break;
				case "teamDetails":
					next = reader.nextEvent();
					team.setTeamDetails(next.asCharacters().getData());
					break;
				}
			}
			if (next.isEndElement()) {
				EndElement end = next.asEndElement();
				if (end.getName().getLocalPart().equals("employee")) {
					emp.setJob(job);
					emp.setTeams(teams);
					emps.add(emp);
				}
			}
		}
		return emps;
	}

	static void parseMaterials() throws FileNotFoundException, XMLStreamException {
		XMLEventReader reader = getReader("src/main/resources/xml/materials.xml");

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

	static void parseClients() throws FileNotFoundException, XMLStreamException {
		XMLEventReader reader = getReader("src/main/resources/xml/clients.xml");

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
		XMLEventReader reader = getReader("src/main/resources/xml/sites.xml");

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

	static void parseBuildingTypes() throws FileNotFoundException, XMLStreamException {
		XMLEventReader reader = getReader("src/main/resources/xml/buildingTypes.xml");

		while (reader.hasNext()) {
			XMLEvent next = reader.nextEvent();
			if (next.isStartElement()) {
				StartElement startElement = next.asStartElement();
				switch (startElement.getName().getLocalPart()) {
				case "buildingType":
					LOGGER.info("Building Type:");
					break;
				case "buildingTypeId":
					next = reader.nextEvent();
					LOGGER.info("Building Type Id " + Integer.parseInt(next.asCharacters().getData()));
					break;
				case "buildTag":
					next = reader.nextEvent();
					LOGGER.info("Building Tag" + next.asCharacters().getData());
					break;
				case "additionalDetails":
					next = reader.nextEvent();
					LOGGER.info("Additional Details" + next.asCharacters().getData());
					break;
				}
			}
			if (next.isEndElement()) {
				EndElement end = next.asEndElement();
				if (end.getName().getLocalPart().equals("buildingType")) {
					LOGGER.info("----------------------");
				}
			}
		}
	}
}
