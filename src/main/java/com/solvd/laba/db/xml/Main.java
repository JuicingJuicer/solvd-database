package main.java.com.solvd.laba.db.xml;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) throws SQLException, SAXException, IOException {
		String xsdP = "src/main/resources/materials.xsd";
		String xmlP = "src/main/resources/materials.xml";

		check(xsdP, xmlP);
	}

	static void check(String xsdP, String xmlP) {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdP));
			Validator val = schema.newValidator();
			val.validate(new StreamSource(new File(xmlP)));
			System.out.println("Good");
		} catch (IOException | SAXException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}
