package main.java.com.solvd.laba.db;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.laba.db.factory.ServiceFactory;
import main.java.com.solvd.laba.db.interfaces.IEmployeeService;
import main.java.com.solvd.laba.db.interfaces.IPackageService;
import main.java.com.solvd.laba.db.interfaces.IProjectService;
import main.java.com.solvd.laba.db.interfaces.ISiteService;
import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.model.Package;
import main.java.com.solvd.laba.db.model.Project;
import main.java.com.solvd.laba.db.model.Site;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws SQLException, IOException {
		IEmployeeService es = ServiceFactory.createEmployeeService("dao");
		Employee emp = es.getEmployee(2);
		LOGGER.info(emp);

		ISiteService ss = ServiceFactory.createSiteService("dao");
		Site site = ss.getSite(1);
		LOGGER.info(site);

		IProjectService ps = ServiceFactory.createProjectService("dao");
		Project project = ps.getProject(1);
		LOGGER.info(project);

		IPackageService packService = ServiceFactory.createPackageService("dao");
		Package pack = packService.getPackage(1);
		LOGGER.info(pack);

		// Connection pool test 10 threads try to get connections
//		ExecutorService ex = Executors.newFixedThreadPool(10);
//		Runnable task = new Runnable() {
//			@Override
//			public void run() {
//				try {
//					Connection c = ConnectionUlti.getConnection();
//					Thread.sleep(2000);
//					LOGGER.info("Job done!");
//					ConnectionUlti.releaseConnection(c);
//				} catch (InterruptedException | SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		};
//
//		for (int i = 0; i < 10; i++) {
//			ex.execute(task);
//		}
//		ex.shutdown();
	}
}
