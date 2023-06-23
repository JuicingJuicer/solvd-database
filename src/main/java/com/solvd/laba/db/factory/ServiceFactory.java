package main.java.com.solvd.laba.db.factory;

import java.io.IOException;

import main.java.com.solvd.laba.db.interfaces.ICityService;
import main.java.com.solvd.laba.db.interfaces.IEmployeeService;
import main.java.com.solvd.laba.db.service.CityService;
import main.java.com.solvd.laba.db.service.CityServiceMyBatis;
import main.java.com.solvd.laba.db.service.EmployeeService;
import main.java.com.solvd.laba.db.service.EmployeeServiceMyBatis;

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
}
