package main.java.com.solvd.laba.db.decorator;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.model.Team;

public class TeamWithEmployee extends TeamDecorator {
	private static final Logger LOGGER = LogManager.getLogger(TeamWithEmployee.class);
	ArrayList<Employee> employees;

	public TeamWithEmployee(Team team) {
		super(team);
	}

	@Override
	public void showDetails() {
		super.showDetails();
		LOGGER.info("Employee(s) of team: " + getEmployees() + "\n");
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}
}
