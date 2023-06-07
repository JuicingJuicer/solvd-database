package main.java.com.solvd.laba.db;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.service.EmployeeService;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) throws SQLException {
		EmployeeService es = new EmployeeService();
		Employee emp = es.getEmployee(1);
		LOGGER.info(emp);
	}
}
