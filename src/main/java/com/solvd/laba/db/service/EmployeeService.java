package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.dao.EmployeeDao;
import main.java.com.solvd.laba.db.dao.JobDao;
import main.java.com.solvd.laba.db.dao.TeamDao;
import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.model.Team;

public class EmployeeService {
	private EmployeeDao employeeDao;
	private JobDao jobDao;
	private TeamDao teamDao;

	public EmployeeService() {
		employeeDao = new EmployeeDao();
		jobDao = new JobDao();
		teamDao = new TeamDao();
	}

	public Employee getEmployee(int id) throws SQLException {
		Employee employee = employeeDao.get(id);
		employee.setJob(jobDao.get(employeeDao.getJId(id)));
		employee.setTeams(getEmpTeams(id));
		return employee;
	}

	public ArrayList<Team> getEmpTeams(int id) throws SQLException {
		ArrayList<Team> teams = new ArrayList<>();
		ArrayList<Integer> ids = employeeDao.getTId(id);
		for (int tid : ids) {
			teams.add(teamDao.get(tid));
		}
		return teams;
	}
}
