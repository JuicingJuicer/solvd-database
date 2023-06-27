package main.java.com.solvd.laba.db.bl;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.laba.db.factory.ServiceFactory;
import main.java.com.solvd.laba.db.interfaces.IBuildingTypeService;
import main.java.com.solvd.laba.db.interfaces.ICityService;
import main.java.com.solvd.laba.db.interfaces.IMaterialService;
import main.java.com.solvd.laba.db.interfaces.IProjectService;
import main.java.com.solvd.laba.db.interfaces.IStateService;
import main.java.com.solvd.laba.db.model.BuildingType;
import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.model.Client;
import main.java.com.solvd.laba.db.model.Material;
import main.java.com.solvd.laba.db.model.Package;
import main.java.com.solvd.laba.db.model.Phase;
import main.java.com.solvd.laba.db.model.Project;
import main.java.com.solvd.laba.db.model.Site;
import main.java.com.solvd.laba.db.model.State;

public class BusinessLogicOperation {
	private static final Logger LOGGER = LogManager.getLogger(BusinessLogicOperation.class);
	Scanner sc = new Scanner(System.in);
	private boolean valid;
	private String input;
	private int choice;

	public BusinessLogicOperation() {
	}

	public void task() throws SQLException, IOException, ParseException {
		greetings();
		Client client = getClientInfo();
		ArrayList<Client> clients = new ArrayList<>();
		clients.add(client);
		Project project = getPreProjectInfo();
		Site site = getSiteInfo();
		Package pack = packageMaker();

		project.setClients(clients);
		project.setSite(site);
		pack.setSite(site);

		LOGGER.info("Creating package ...");
		LOGGER.info("Package info");
		LOGGER.info(pack);
		LOGGER.info("Project info");
		LOGGER.info(project);
		LOGGER.info("The total price of the project is $" + packageCalc(pack));
		LOGGER.info("It will also take approximately " + TimeRandom() + " years to complete.");
		sc.close();
	}

	public void greetings() {
		LOGGER.info("Welcome to Juice Construction Company!\nLet's get started by getting your info.");
	}

	public Client getClientInfo() {
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

		LOGGER.info("Your info:\n" + client);
		return client;
	}

	public Project getPreProjectInfo() throws SQLException, IOException, ParseException {
		Project project = new Project();
		IBuildingTypeService buildingTypeService = ServiceFactory.createBuildingTypeService("mybatis");
		IProjectService projectService = ServiceFactory.createProjectService("dao");
		valid = false;

		// get project name
		LOGGER.info("On to the project details!");
		LOGGER.info("What name do you want your project to be called?");
		project.setProjectName(StringUtils.capitalize(sc.nextLine().toLowerCase()));

		// display all building types and gets user's building type choice
		LOGGER.info("Here is the important part. Which kind of building type do you want?");
		ArrayList<BuildingType> bts = buildingTypeService.getBuildingTypes();
		for (BuildingType bt : bts) {
			LOGGER.info(bt.getBuildingTypeId() + ". " + bt);
		}
		LOGGER.info("Please select a number between 1-" + bts.size());
		choice = sc.nextInt();
		do {
			if (choice > 0 && choice < bts.size()) {
				choice -= 1;
				LOGGER.info(bts.get(choice).getBuildingName() + " selected");
				project.setBuildingType(bts.get(choice));
				valid = true;
			} else {
				LOGGER.info("Please enter a valid number!");
				choice = sc.nextInt();
			}
		} while (!valid);

		// prompting user if they want their project to start today or not
		valid = false;
		LOGGER.info("Do you want to project to start today? REPLY WITH [YES/NO]");
		input = sc.nextLine().toLowerCase();
		do {
			if (input.equals("no")) {
				LOGGER.info("Okay we will wait until you are ready to start!");
				valid = true;
			} else if (input.equals("yes")) {
				LOGGER.info("Okay today will be the start date!");
				project.setStartDate(
						Date.from(java.time.LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
				ArrayList<Phase> phases = projectService.getPhases();
				project.setPhase(phases.get(0));
				LOGGER.info("Congrats the project is now in the " + project.getPhase().getPhaseName() + " phase");
				valid = true;
			} else {
				LOGGER.info("Please enter yes or no!");
				input = sc.nextLine().toLowerCase();
			}
		} while (!valid);

		LOGGER.info("Here are the project details so far!");
		LOGGER.info(project);
		return project;
	}

	public Site getSiteInfo() throws IOException, SQLException {
		Site site = new Site();
		City city = new City();
		State state = new State();
		ICityService cityService = ServiceFactory.createCityService("mybatis");
		IStateService stateService = ServiceFactory.createStateService("mybatis");
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
			if (state != null) {
				city.setState(state);
			} else {
				LOGGER.info("Invalid state!");
			}
			site.setCity(city);
		}

		// get address
		LOGGER.info("What is the address?");
		site.setAddress(StringUtils.capitalize(sc.nextLine().toLowerCase()));

		// get zip
		LOGGER.info("What is the zip?");
		site.setZip(sc.nextInt());

		LOGGER.info("Here are the site details!");
		LOGGER.info(site);
		return site;
	}

	public ArrayList<Material> materialRandom() throws IOException, SQLException {
		Random random = new Random();
		IMaterialService materialService = ServiceFactory.createMaterialService("mybatis");
		ArrayList<Material> materials = materialService.getMaterials();
		for (Material mat : materials) {
			mat.setQuantity(random.nextInt(500 - 250) + 250);
		}
		return materials;
	}

	public int TimeRandom() {
		Random random = new Random();
		int years = 0;
		years = random.nextInt(5 - 2) + 2;
		return years;
	}

	public Package packageMaker() throws IOException, SQLException {
		Package pack = new Package();
		pack.setPurchaseDate(Date.from(java.time.LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		pack.setStatus("Invoiced");
		pack.setMaterials(materialRandom());
		return pack;
	}

	public double packageCalc(Package pack) {
		double price = 0;
		for (Material mat : pack.getMaterials()) {
			price += mat.getMaterialPrice() * mat.getQuantity();
		}
		// company tax 40%
		price = price * 1.4;
		return price;
	}
}
