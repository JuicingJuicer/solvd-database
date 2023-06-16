package main.java.com.solvd.laba.db.json;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.model.Client;
import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.model.Project;
import main.java.com.solvd.laba.db.model.Site;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		City city = mapper.readValue(new File("src/main/resources/json/city.json"), City.class);
		LOGGER.info(city);

		Client client = mapper.readValue(new File("src/main/resources/json/client.json"), Client.class);
		LOGGER.info(client);

		Site site = mapper.readValue(new File("src/main/resources/json/site.json"), Site.class);
		LOGGER.info(site);

		Employee emp = mapper.readValue(new File("src/main/resources/json/employee.json"), Employee.class);
		LOGGER.info(emp);

		Project project = mapper.readValue(new File("src/main/resources/json/project.json"), Project.class);
		LOGGER.info(project);
	}

}
