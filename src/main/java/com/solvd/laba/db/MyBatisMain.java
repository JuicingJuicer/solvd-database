package main.java.com.solvd.laba.db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.laba.db.decorator.TeamWithEmployee;
import main.java.com.solvd.laba.db.factory.ServiceFactory;
import main.java.com.solvd.laba.db.interfaces.ICityService;
import main.java.com.solvd.laba.db.interfaces.IEmployeeService;
import main.java.com.solvd.laba.db.interfaces.IPackageService;
import main.java.com.solvd.laba.db.interfaces.IProjectService;
import main.java.com.solvd.laba.db.interfaces.ISiteService;
import main.java.com.solvd.laba.db.interfaces.ITeamModel;
import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.model.Package;
import main.java.com.solvd.laba.db.model.Project;
import main.java.com.solvd.laba.db.model.Site;
import main.java.com.solvd.laba.db.model.Team;
import main.java.com.solvd.laba.db.service.EmployeeServiceMyBatis;

public class MyBatisMain {
	private static final Logger LOGGER = LogManager.getLogger(MyBatisMain.class);

	public static void main(String[] args) throws IOException, SQLException {
		IEmployeeService es = ServiceFactory.createEmployeeService("mybatis");
		Employee emp = es.getEmployee(2);
		LOGGER.info(emp);

		ArrayList<Employee> emps = new ArrayList<>();
		emps = es.getEmployeeByJobId(2);
		LOGGER.info(emps);

		ICityService cs = ServiceFactory.createCityService("mybatis");
		City city = cs.getCityByName("Denver");
		LOGGER.info(city);

		City city2 = cs.getCity(2);
		LOGGER.info(city2);

		IPackageService ps = ServiceFactory.createPackageService("mybatis");
		Package pack = ps.getPackage(1);
		LOGGER.info(pack);

		ArrayList<Package> packs = new ArrayList<>();
		packs = ps.getPackages();
		LOGGER.info(packs);

		IProjectService projS = ServiceFactory.createProjectService("mybatis");
		Project project = projS.getProject(1);
		LOGGER.info(project);

		ArrayList<Project> projects = new ArrayList<>();
		projects = projS.getProjectByBuildingTypeId(2);
		LOGGER.info(projects);

		ISiteService ss = ServiceFactory.createSiteService("mybatis");
		Site site = ss.getSite(1);
		LOGGER.info(site);

		ArrayList<Site> sites = new ArrayList<>();
		sites = ss.getSiteByCityId(5);
		LOGGER.info(sites);

		// decorator
		Team team = new Team(1, "Team A", "");
		team.showDetails();
		ITeamModel teamEmp = new TeamWithEmployee(team);
		((TeamWithEmployee) teamEmp).setEmployees(((EmployeeServiceMyBatis) es).getEmployeeByTeamId(team.getTeamId()));
		teamEmp.showDetails();
	}

}
