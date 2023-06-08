package main.java.com.solvd.laba.db;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.laba.db.dao.MaterialDao;
import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.model.Material;
import main.java.com.solvd.laba.db.model.Package;
import main.java.com.solvd.laba.db.model.Project;
import main.java.com.solvd.laba.db.model.Site;
import main.java.com.solvd.laba.db.service.EmployeeService;
import main.java.com.solvd.laba.db.service.PackageService;
import main.java.com.solvd.laba.db.service.ProjectService;
import main.java.com.solvd.laba.db.service.SiteService;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws SQLException {
		EmployeeService es = new EmployeeService();
		Employee emp = es.getEmployee(2);
		LOGGER.info(emp);

		SiteService ss = new SiteService();
		Site site = ss.getSite(1);
		LOGGER.info(site);

		ProjectService ps = new ProjectService();
		Project project = ps.getProject(1);
		LOGGER.info(project);

		MaterialDao md = new MaterialDao();
		Material material = md.get(1);
		LOGGER.info(material);

		PackageService packService = new PackageService();
		Package pack = packService.getPackage(1);
		LOGGER.info(pack);
	}
}
