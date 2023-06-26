package main.java.com.solvd.laba.db.service;

import java.io.IOException;
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
	public Employee getEmployee(int id) throws SQLException {
		Employee employee = employeeDao.get(id);
		employee.setJob(jobDao.get(employeeDao.getJId(id)));
		employee.setTeams(getEmpTeams(id));
		return employee;
	}

	@Override
	public ArrayList<Employee> getEmployeeByJobId(int jobId) throws SQLException {
		ArrayList<Employee> emps = new ArrayList<>();
		emps = employeeDao.getEmployeeByJobId(jobId);
		return emps;
	}

	@Override
	public ArrayList<Employee> getEmployees() throws SQLException {
		ArrayList<Employee> emps = new ArrayList<>();
		emps = employeeDao.getAll();
		return emps;
	}

	public ArrayList<Team> getEmpTeams(int id) throws SQLException {
		ArrayList<Team> teams = new ArrayList<>();
		ArrayList<Integer> ids = employeeDao.getTId(id);
		for (int tid : ids) {
			teams.add(teamDao.get(tid));
		}
		return teams;
	}

	@Override
	public void addEmployee(Employee emp) throws SQLException {
		employeeDao.insert(emp);
	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		employeeDao.update(emp);
	}

	@Override
	public void deleteEmployee(Employee emp) throws SQLException {
		employeeDao.delete(emp);
	}

	@Override
	public ArrayList<Employee> getEmployeeByTeamId(int teamId) throws SQLException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
