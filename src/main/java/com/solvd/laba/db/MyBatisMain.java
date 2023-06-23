package main.java.com.solvd.laba.db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.model.Package;
import main.java.com.solvd.laba.db.model.Project;
import main.java.com.solvd.laba.db.model.Site;
import main.java.com.solvd.laba.db.service.CityServiceMyBatis;
import main.java.com.solvd.laba.db.service.EmployeeServiceMyBatis;
import main.java.com.solvd.laba.db.service.PackageServiceMyBatis;
import main.java.com.solvd.laba.db.service.ProjectServiceMyBatis;
import main.java.com.solvd.laba.db.service.SiteServiceMyBatis;

public class MyBatisMain {
	private static final Logger LOGGER = LogManager.getLogger(MyBatisMain.class);

	public static void main(String[] args) throws IOException, SQLException {
		EmployeeServiceMyBatis es = new EmployeeServiceMyBatis();
		Employee emp = es.getEmployee(2);
		LOGGER.info(emp);

		ArrayList<Employee> emps = new ArrayList<>();
		emps = es.getEmployeeByJobId(2);
		LOGGER.info(emps);

		CityServiceMyBatis cs = new CityServiceMyBatis();
		City city = cs.getCityByName("Denver");
		LOGGER.info(city);

		City city2 = cs.getCity(2);
		LOGGER.info(city2);

		PackageServiceMyBatis ps = new PackageServiceMyBatis();
		Package pack = ps.getPackage(1);
		LOGGER.info(pack);

		ArrayList<Package> packs = new ArrayList<>();
		packs = ps.getPackages();
		LOGGER.info(packs);

		ProjectServiceMyBatis projS = new ProjectServiceMyBatis();
		Project project = projS.getProject(1);
		LOGGER.info(project);

		ArrayList<Project> projects = new ArrayList<>();
		projects = projS.getProjectByBuildingTypeId(2);
		LOGGER.info(projects);

		SiteServiceMyBatis ss = new SiteServiceMyBatis();
		Site site = ss.getSite(1);
		LOGGER.info(site);

		ArrayList<Site> sites = new ArrayList<>();
		sites = ss.getSiteByCityId(5);
		LOGGER.info(sites);
	}

}
