package main.java.com.solvd.laba.db.factory;

import java.io.IOException;

import main.java.com.solvd.laba.db.interfaces.IBuildingTypeService;
import main.java.com.solvd.laba.db.interfaces.ICityService;
import main.java.com.solvd.laba.db.interfaces.IEmployeeService;
import main.java.com.solvd.laba.db.interfaces.IMaterialService;
import main.java.com.solvd.laba.db.interfaces.IPackageService;
import main.java.com.solvd.laba.db.interfaces.IProjectService;
import main.java.com.solvd.laba.db.interfaces.ISiteService;
import main.java.com.solvd.laba.db.interfaces.IStateService;
import main.java.com.solvd.laba.db.service.BuildingTypeService;
import main.java.com.solvd.laba.db.service.BuildingTypeServiceMyBatis;
import main.java.com.solvd.laba.db.service.CityService;
import main.java.com.solvd.laba.db.service.CityServiceMyBatis;
import main.java.com.solvd.laba.db.service.EmployeeService;
import main.java.com.solvd.laba.db.service.EmployeeServiceMyBatis;
import main.java.com.solvd.laba.db.service.MaterialService;
import main.java.com.solvd.laba.db.service.MaterialServiceMyBatis;
import main.java.com.solvd.laba.db.service.PackageService;
import main.java.com.solvd.laba.db.service.PackageServiceMyBatis;
import main.java.com.solvd.laba.db.service.ProjectService;
import main.java.com.solvd.laba.db.service.ProjectServiceMyBatis;
import main.java.com.solvd.laba.db.service.SiteService;
import main.java.com.solvd.laba.db.service.SiteServiceMyBatis;
import main.java.com.solvd.laba.db.service.StateService;
import main.java.com.solvd.laba.db.service.StateServiceMyBatis;

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

	public static IBuildingTypeService createBuildingTypeService(String type) throws IOException {
		type = type.toLowerCase();
		switch (type) {
		case "dao":
			return new BuildingTypeService();
		case "mybatis":
			return new BuildingTypeServiceMyBatis();
		default:
			return null;
		}
	}

	public static IStateService createStateService(String type) throws IOException {
		type = type.toLowerCase();
		switch (type) {
		case "dao":
			return new StateService();
		case "mybatis":
			return new StateServiceMyBatis();
		default:
			return null;
		}
	}

	public static IMaterialService createMaterialService(String type) throws IOException {
		type = type.toLowerCase();
		switch (type) {
		case "dao":
			return new MaterialService();
		case "mybatis":
			return new MaterialServiceMyBatis();
		default:
			return null;
		}
	}
}
