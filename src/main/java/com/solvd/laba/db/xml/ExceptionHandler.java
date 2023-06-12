package main.java.com.solvd.laba.db.xml;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ExceptionHandler implements ErrorHandler {
	private static final Logger LOGGER = LogManager.getLogger(ExceptionHandler.class);
	ArrayList<SAXParseException> exceptions = new ArrayList<>();

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		exceptions.add(exception);
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		exceptions.add(exception);
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		exceptions.add(exception);
	}

	public boolean isValid() {
		if (exceptions.size() == 0) {
			return true;
		}

		String s = "Exceptions: \n";
		for (SAXParseException ex : exceptions) {
			s += ex + "\n";
		}
		LOGGER.error("Not valid!");
		LOGGER.error(s);
		return false;
	}

}
