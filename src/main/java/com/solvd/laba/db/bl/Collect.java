package main.java.com.solvd.laba.db.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.laba.db.decorator.TeamWithEmployee;
import main.java.com.solvd.laba.db.factory.ServiceFactory;
import main.java.com.solvd.laba.db.interfaces.IBuildingTypeService;
import main.java.com.solvd.laba.db.interfaces.ICityService;
import main.java.com.solvd.laba.db.interfaces.IEmployeeService;
import main.java.com.solvd.laba.db.interfaces.IPhaseService;
import main.java.com.solvd.laba.db.interfaces.IStateService;
import main.java.com.solvd.laba.db.interfaces.ITeamModel;
import main.java.com.solvd.laba.db.model.BuildingType;
import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.model.Client;
import main.java.com.solvd.laba.db.model.Phase;
import main.java.com.solvd.laba.db.model.Project;
import main.java.com.solvd.laba.db.model.Site;
import main.java.com.solvd.laba.db.model.State;
import main.java.com.solvd.laba.db.ulti.RandomUtil;

public class Collect {
	private static final Logger LOGGER = LogManager.getLogger(Collect.class);
	Scanner sc = new Scanner(System.in);
	private boolean valid;
	private String input;
	private int choice;

	public Collect() {
	}

	public Client collectClientInfo() {
		Client client = new Client();
		valid = false;

		// get first name
		LOGGER.info("What is your first name?");
		client.setFirstName(StringUtils.capitalize(sc.nextLine().toLowerCase()));

		// get last name
		LOGGER.info("What is your last name?");
		client.setLastName(StringUtils.capitalize(sc.nextLine().toLowerCase()));

		// get email
		LOGGER.info("What is your email?");
		client.setEmail(sc.nextLine().toLowerCase());

		// get phone number
		LOGGER.info("What is your phone number?");
		client.setPhoneNumber(sc.nextLine());

		// prompting user if they are with a company or not
		LOGGER.info("Are you associated with any company? REPLY WITH [YES/NO]");
		input = sc.nextLine().toLowerCase();
		do {
			if (input.equals("no")) {
				LOGGER.info("Okay that's all! On to the next step!");
				valid = true;
			} else if (input.equals("yes")) {
				LOGGER.info("What is the company name?");
				client.setCompanyName(StringUtils.capitalize(sc.nextLine().toLowerCase()));
				valid = true;
			} else {
				LOGGER.info("Please enter yes or no!");
				input = sc.nextLine().toLowerCase();
			}
		} while (!valid);

		LOGGER.info("Your info:\n" + client + "\n");
		return client;
	}

	public Project collectPreProjectInfo() throws SQLException, IOException, ParseException {
		Project project = new Project();
		IBuildingTypeService buildingTypeService = ServiceFactory.createBuildingTypeService();
		IPhaseService phaseService = ServiceFactory.createPhaseService();
		IEmployeeService employeeService = ServiceFactory.createEmployeeService();
		valid = false;
		Calendar cal = Calendar.getInstance();

		// get project name
		LOGGER.info("On to the project details!");
		LOGGER.info("What name do you want your project to be called?");
		project.setProjectName(StringUtils.capitalize(sc.nextLine().toLowerCase()));

		// display all building types and gets user's building type choice
		LOGGER.info("Which kind of building type do you want?");
		ArrayList<BuildingType> bts = buildingTypeService.getBuildingTypes();
		for (BuildingType bt : bts) {
			LOGGER.info(bt.getBuildingTypeId() + ". " + bt.getBuildingName() + " | Minimum Years: " + bt.getTime());
		}
		LOGGER.info("Please select a number between 1-" + bts.size());
		choice = sc.nextInt();
		do {
			if (choice > 0 && choice <= bts.size()) {
				choice -= 1;
				LOGGER.info(bts.get(choice).getBuildingName() + " selected");
				LOGGER.info("Processing information ...\n");
				project.setBuildingType(bts.get(choice));
				valid = true;
			} else {
				LOGGER.info("Please enter a valid number!");
				choice = sc.nextInt();
			}
		} while (!valid);
		sc.nextLine();

		// setting phase
		ArrayList<Phase> phases = phaseService.getPhases();
		project.setPhase(phases.get(0));

		// setting start date
		project.setStartDate(Date.from(java.time.LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));

		// setting end date
		cal.setTime(project.getStartDate());
		cal.add(Calendar.YEAR, project.getBuildingType().getTime() + RandomUtil.randomTime());
		project.setEndDate(cal.getTime());

		// setting team (decorator application)
		project.setTeam(RandomUtil.randomTeam());
		ITeamModel teamEmp = new TeamWithEmployee(project.getTeam());
		((TeamWithEmployee) teamEmp).setEmployees((employeeService).getEmployeeByTeamId(project.getTeam().getTeamId()));
		LOGGER.info("Here is the team assigned to your project: ");
		teamEmp.showDetails();

		LOGGER.info("Here are the project details so far!");
		LOGGER.info(project + "\n");
		return project;
	}

	public Site collectSiteInfo() throws IOException, SQLException {
		Site site = new Site();
		City city = new City();
		State state = new State();
		ICityService cityService = ServiceFactory.createCityService();
		IStateService stateService = ServiceFactory.createStateService();
		valid = false;

		// prompt user for city of the site if city doesn't exist in cities table then
		// it will be created instead
		LOGGER.info("Time to get the project site details");
		LOGGER.info("What city will the site be in?");
		input = sc.nextLine().toLowerCase();
		city = cityService.getCityByName(input);
		if (city != null) {
			site.setCity(city);
		} else {
			city = new City();
			city.setCityName(StringUtils.capitalize(input));
			LOGGER.info("What state is the city located in?");
			input = sc.nextLine().toLowerCase();
			state = stateService.getStateByName(input);
			do {
				if (state != null) {
					city.setState(state);
				} else {
					LOGGER.info("Invalid state! Please try again!");
					input = sc.nextLine().toLowerCase();
					state = stateService.getStateByName(input);
				}
			} while (state == null);
			site.setCity(city);
		}

		// get address
		LOGGER.info("What is the address?");
		site.setAddress(StringUtils.capitalize(sc.nextLine().toLowerCase()));

		// get zip
		LOGGER.info("What is the zip?");
		site.setZip(sc.nextInt());

		LOGGER.info("Here are the site details!");
		LOGGER.info(site + "\n");
		return site;
	}
}
