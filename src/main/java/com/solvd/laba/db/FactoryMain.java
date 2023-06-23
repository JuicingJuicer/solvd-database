package main.java.com.solvd.laba.db;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.laba.db.factory.ServiceFactory;
import main.java.com.solvd.laba.db.interfaces.ICityService;
import main.java.com.solvd.laba.db.interfaces.IEmployeeService;
import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.model.Employee;

public class FactoryMain {
	private static final Logger LOGGER = LogManager.getLogger(FactoryMain.class);

	public static void main(String[] args) throws IOException, SQLException {
		IEmployeeService es = ServiceFactory.createEmployeeService("DAO");
		Employee emp = es.getEmployee(1);
		LOGGER.info(emp);

		IEmployeeService es2 = ServiceFactory.createEmployeeService("mybatis");
		Employee emp2 = es2.getEmployee(1);
		LOGGER.info(emp2);

		ICityService cs = ServiceFactory.createCityService("DaO");
		City city = cs.getCity(2);
		LOGGER.info(city);

		ICityService cs2 = ServiceFactory.createCityService("MyBatis");
		City city2 = cs2.getCity(2);
		LOGGER.info(city2);
	}

}
