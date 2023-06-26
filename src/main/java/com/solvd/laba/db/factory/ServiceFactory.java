package main.java.com.solvd.laba.db.factory;

import java.io.IOException;

import main.java.com.solvd.laba.db.interfaces.ICityService;
import main.java.com.solvd.laba.db.interfaces.IEmployeeService;
import main.java.com.solvd.laba.db.interfaces.IPackageService;
import main.java.com.solvd.laba.db.interfaces.IProjectService;
import main.java.com.solvd.laba.db.interfaces.ISiteService;
import main.java.com.solvd.laba.db.service.CityService;
import main.java.com.solvd.laba.db.service.CityServiceMyBatis;
import main.java.com.solvd.laba.db.service.EmployeeService;
import main.java.com.solvd.laba.db.service.EmployeeServiceMyBatis;
import main.java.com.solvd.laba.db.service.PackageService;
import main.java.com.solvd.laba.db.service.PackageServiceMyBatis;
import main.java.com.solvd.laba.db.service.ProjectService;
import main.java.com.solvd.laba.db.service.ProjectServiceMyBatis;
import main.java.com.solvd.laba.db.service.SiteService;
import main.java.com.solvd.laba.db.service.SiteServiceMyBatis;

public class ServiceFactory {
	public static IEmployeeService createEmployeeService(String type) throws IOException {
		type = type.toLowerCase();
		switch (type) {
		case "dao":
			return new EmployeeService();
		case "mybatis":
			return new EmployeeServiceMyBatis();
		default:
			return null;
		}
	}

	public static ICityService createCityService(String type) throws IOException {
		type = type.toLowerCase();
		switch (type) {
		case "dao":
			return new CityService();
		case "mybatis":
			return new CityServiceMyBatis();
		default:
			return null;
		}
	}

	public static IPackageService createPackageService(String type) throws IOException {
		type = type.toLowerCase();
		switch (type) {
		case "dao":
			return new PackageService();
		case "mybatis":
			return new PackageServiceMyBatis();
		default:
			return null;
		}
	}

	public static IProjectService createProjectService(String type) throws IOException {
		type = type.toLowerCase();
		switch (type) {
		case "dao":
			return new ProjectService();
		case "mybatis":
			return new ProjectServiceMyBatis();
		default:
			return null;
		}
	}

	public static ISiteService createSiteService(String type) throws IOException {
		type = type.toLowerCase();
		switch (type) {
		case "dao":
			return new SiteService();
		case "mybatis":
			return new SiteServiceMyBatis();
		default:
			return null;
		}
	}
}
