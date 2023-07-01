package main.java.com.solvd.laba.db.factory;

import main.java.com.solvd.laba.db.interfaces.IBuildingTypeService;
import main.java.com.solvd.laba.db.interfaces.ICityService;
import main.java.com.solvd.laba.db.interfaces.IEmployeeService;
import main.java.com.solvd.laba.db.interfaces.IMaterialService;
import main.java.com.solvd.laba.db.interfaces.IPackageService;
import main.java.com.solvd.laba.db.interfaces.IPhaseService;
import main.java.com.solvd.laba.db.interfaces.IProjectService;
import main.java.com.solvd.laba.db.interfaces.ISiteService;
import main.java.com.solvd.laba.db.interfaces.IStateService;
import main.java.com.solvd.laba.db.interfaces.ITeamService;
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
import main.java.com.solvd.laba.db.service.PhaseService;
import main.java.com.solvd.laba.db.service.PhaseServiceMyBatis;
import main.java.com.solvd.laba.db.service.ProjectService;
import main.java.com.solvd.laba.db.service.ProjectServiceMyBatis;
import main.java.com.solvd.laba.db.service.SiteService;
import main.java.com.solvd.laba.db.service.SiteServiceMyBatis;
import main.java.com.solvd.laba.db.service.StateService;
import main.java.com.solvd.laba.db.service.StateServiceMyBatis;
import main.java.com.solvd.laba.db.service.TeamService;
import main.java.com.solvd.laba.db.service.TeamServiceMyBatis;

public class ServiceFactory {
	public static IEmployeeService createEmployeeService() {
		String type = System.getProperty("employee_type");
		switch (type.toLowerCase()) {
		case "dao":
			return new EmployeeService();
		case "mybatis":
			return new EmployeeServiceMyBatis();
		default:
			return null;
		}
	}

	public static ICityService createCityService() {
		String type = System.getProperty("city_type");
		switch (type.toLowerCase()) {
		case "dao":
			return new CityService();
		case "mybatis":
			return new CityServiceMyBatis();
		default:
			return null;
		}
	}

	public static IPackageService createPackageService() {
		String type = System.getProperty("package_type");
		switch (type.toLowerCase()) {
		case "dao":
			return new PackageService();
		case "mybatis":
			return new PackageServiceMyBatis();
		default:
			return null;
		}
	}

	public static IProjectService createProjectService() {
		String type = System.getProperty("project_type");
		switch (type.toLowerCase()) {
		case "dao":
			return new ProjectService();
		case "mybatis":
			return new ProjectServiceMyBatis();
		default:
			return null;
		}
	}

	public static ISiteService createSiteService() {
		String type = System.getProperty("site_type");
		switch (type.toLowerCase()) {
		case "dao":
			return new SiteService();
		case "mybatis":
			return new SiteServiceMyBatis();
		default:
			return null;
		}
	}

	public static IBuildingTypeService createBuildingTypeService() {
		String type = System.getProperty("building_type");
		switch (type.toLowerCase()) {
		case "dao":
			return new BuildingTypeService();
		case "mybatis":
			return new BuildingTypeServiceMyBatis();
		default:
			return null;
		}
	}

	public static IStateService createStateService() {
		String type = System.getProperty("state_type");
		switch (type.toLowerCase()) {
		case "dao":
			return new StateService();
		case "mybatis":
			return new StateServiceMyBatis();
		default:
			return null;
		}
	}

	public static IMaterialService createMaterialService() {
		String type = System.getProperty("material_type");
		switch (type.toLowerCase()) {
		case "dao":
			return new MaterialService();
		case "mybatis":
			return new MaterialServiceMyBatis();
		default:
			return null;
		}
	}

	public static IPhaseService createPhaseService() {
		String type = System.getProperty("phase_type");
		switch (type.toLowerCase()) {
		case "dao":
			return new PhaseService();
		case "mybatis":
			return new PhaseServiceMyBatis();
		default:
			return null;
		}
	}

	public static ITeamService createTeamService() {
		String type = System.getProperty("team_type");
		switch (type.toLowerCase()) {
		case "dao":
			return new TeamService();
		case "mybatis":
			return new TeamServiceMyBatis();
		default:
			return null;
		}
	}
}
