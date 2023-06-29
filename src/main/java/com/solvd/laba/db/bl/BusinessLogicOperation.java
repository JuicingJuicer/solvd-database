package main.java.com.solvd.laba.db.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.laba.db.model.Client;
import main.java.com.solvd.laba.db.model.Package;
import main.java.com.solvd.laba.db.model.Project;
import main.java.com.solvd.laba.db.model.Site;
import main.java.com.solvd.laba.db.ulti.RandomUtil;

public class BusinessLogicOperation {
	private static final Logger LOGGER = LogManager.getLogger(BusinessLogicOperation.class);
	private Collect collector;

	public BusinessLogicOperation() {
		collector = new Collect();
	}

	public void clientProjectOperation() {
		try {
			LOGGER.info("Welcome to Juice Construction Company!\nLet's get started by getting your info.");
			Calendar start = Calendar.getInstance();
			Calendar end = Calendar.getInstance();
			ArrayList<Client> clients = new ArrayList<>();

			Client client = collector.collectClientInfo();
			Project project = collector.collectPreProjectInfo();
			Site site = collector.collectSiteInfo();
			Package pack = RandomUtil.randomPackage();

			clients.add(client);
			project.setClients(clients);
			project.setSite(site);
			pack.setSite(site);
			start.setTime(project.getStartDate());
			end.setTime(project.getEndDate());

			LOGGER.info("Creating package ...");
			LOGGER.info("Your Package info:");
			LOGGER.info(pack + "\n");
			LOGGER.info("Your Project info:");
			LOGGER.info(project + "\n");
			LOGGER.info(
					"The total price of the project is $" + String.format("%.2f", (RandomUtil.randomTaxPrice(pack))));
			LOGGER.info("It will also take approximately " + (end.get(Calendar.YEAR) - start.get(Calendar.YEAR))
					+ " years to complete.");
		} catch (SQLException | IOException | ParseException e) {
			e.printStackTrace();
		}
	}
}
