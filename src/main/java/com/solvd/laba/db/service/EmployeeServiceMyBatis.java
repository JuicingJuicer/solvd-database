package main.java.com.solvd.laba.db.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import main.java.com.solvd.laba.db.interfaces.IEmployeeService;
import main.java.com.solvd.laba.db.mapper.EmployeeMapper;
import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.ulti.SessionUtil;

public class EmployeeServiceMyBatis implements IEmployeeService {
	private EmployeeMapper employeeMapper;

	public EmployeeServiceMyBatis() {
	}

	@Override
	public Employee getEmployee(int id) {
		try (SqlSession session = SessionUtil.openSession()) {
			employeeMapper = session.getMapper(EmployeeMapper.class);
			Employee emp = employeeMapper.selectEmployeeById(id);
			return emp;
		}
	}

	@Override
	public ArrayList<Employee> getEmployees() {
		try (SqlSession session = SessionUtil.openSession()) {
			employeeMapper = session.getMapper(EmployeeMapper.class);
			ArrayList<Employee> emps = employeeMapper.selectEmployees();
			return emps;
		}
	}

	@Override
	public ArrayList<Employee> getEmployeeByJobId(int jobId) {
		try (SqlSession session = SessionUtil.openSession()) {
			employeeMapper = session.getMapper(EmployeeMapper.class);
			ArrayList<Employee> emps = employeeMapper.selectEmployeeByJobId(jobId);
			return emps;
		}
	}

	@Override
	public ArrayList<Employee> getEmployeeByTeamId(int teamId) {
		try (SqlSession session = SessionUtil.openSession()) {
			employeeMapper = session.getMapper(EmployeeMapper.class);
			ArrayList<Employee> emps = employeeMapper.selectEmployeeByTeamId(teamId);
			return emps;
		}
	}

	@Override
	public void addEmployee(Employee emp) {
		try (SqlSession session = SessionUtil.openSession()) {
			employeeMapper = session.getMapper(EmployeeMapper.class);
			employeeMapper.insertEmployee(emp);
			session.commit();
		}
	}

	@Override
	public void updateEmployee(Employee emp) {
		try (SqlSession session = SessionUtil.openSession()) {
			employeeMapper = session.getMapper(EmployeeMapper.class);
			employeeMapper.updateEmployee(emp);
			session.commit();
		}
	}

	@Override
	public void deleteEmployee(Employee emp) {
		try (SqlSession session = SessionUtil.openSession()) {
			employeeMapper = session.getMapper(EmployeeMapper.class);
			employeeMapper.deleteEmployee(emp);
			session.commit();
		}
	}

}
