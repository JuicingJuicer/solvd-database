package main.java.com.solvd.laba.db.service;

import java.io.IOException;

import main.java.com.solvd.laba.db.mapper.EmployeeMapper;
import main.java.com.solvd.laba.db.model.Employee;

public class EmployeeService {
	private EmployeeMapper employeeMapper;

	public EmployeeService(EmployeeMapper employeeMapper) throws IOException {
		this.employeeMapper = employeeMapper;
	}

	public Employee getEmployee(int id) {
		Employee emp = employeeMapper.selectEmployeeById(id);
		return emp;
	}

//	private EmployeeDao employeeDao;
//	private JobDao jobDao;
//	private TeamDao teamDao;
//
//	public EmployeeService() {
//		employeeDao = new EmployeeDao();
//		jobDao = new JobDao();
//		teamDao = new TeamDao();
//	}
//
//	public Employee getEmployee(int id) throws SQLException {
//		Employee employee = employeeDao.get(id);
//		employee.setJob(jobDao.get(employeeDao.getJId(id)));
//		employee.setTeams(getEmpTeams(id));
//		return employee;
//	}
//
//	public ArrayList<Team> getEmpTeams(int id) throws SQLException {
//		ArrayList<Team> teams = new ArrayList<>();
//		ArrayList<Integer> ids = employeeDao.getTId(id);
//		for (int tid : ids) {
//			teams.add(teamDao.get(tid));
//		}
//		return teams;
//	}
}
