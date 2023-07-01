package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.dao.EmployeeDao;
import main.java.com.solvd.laba.db.dao.JobDao;
import main.java.com.solvd.laba.db.dao.TeamDao;
import main.java.com.solvd.laba.db.interfaces.IEmployeeService;
import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.model.Team;

public class EmployeeService implements IEmployeeService {
	private EmployeeDao employeeDao;
	private JobDao jobDao;
	private TeamDao teamDao;

	public EmployeeService() {
		employeeDao = new EmployeeDao();
		jobDao = new JobDao();
		teamDao = new TeamDao();
	}

	@Override
	public Employee getEmployee(int id) {
		try {
			Employee employee = employeeDao.get(id);
			employee.setJob(jobDao.get(employeeDao.getJId(id)));
			employee.setTeams(getEmpTeams(id));
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Employee> getEmployeeByJobId(int jobId) {
		try {
			ArrayList<Employee> emps = new ArrayList<>();
			emps = employeeDao.getEmployeeByJobId(jobId);
			return emps;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Employee> getEmployees() {
		try {
			ArrayList<Employee> emps = new ArrayList<>();
			emps = employeeDao.getAll();
			return emps;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Employee> getEmployeeByTeamId(int teamId) {
		try {
			ArrayList<Employee> emps = new ArrayList<>();
			emps = employeeDao.getEmployeeByTeamId(teamId);
			return emps;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Team> getEmpTeams(int id) {
		try {
			ArrayList<Team> teams = new ArrayList<>();
			ArrayList<Integer> ids = employeeDao.getTId(id);
			for (int tid : ids) {
				teams.add(teamDao.get(tid));
			}
			return teams;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addEmployee(Employee emp) {
		try {
			employeeDao.insert(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(Employee emp) {
		try {
			employeeDao.update(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(Employee emp) {
		try {
			employeeDao.delete(emp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
