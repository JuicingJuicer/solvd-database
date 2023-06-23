package main.java.com.solvd.laba.db.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import main.java.com.solvd.laba.db.interfaces.IEmployeeService;
import main.java.com.solvd.laba.db.mapper.EmployeeMapper;
import main.java.com.solvd.laba.db.model.Employee;

public class EmployeeServiceMyBatis implements IEmployeeService {
	private SqlSession session;
	private EmployeeMapper employeeMapper;

	public EmployeeServiceMyBatis() throws IOException {
		// session creation in here for now
		InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
		session = new SqlSessionFactoryBuilder().build(stream).openSession();
		employeeMapper = session.getMapper(EmployeeMapper.class);
	}

	@Override
	public Employee getEmployee(int id) {
		Employee emp = employeeMapper.selectEmployeeById(id);
		return emp;
	}

	@Override
	public ArrayList<Employee> getEmployees() throws SQLException {
		ArrayList<Employee> emps = new ArrayList<>();
		emps = employeeMapper.selectEmployees();
		return emps;
	}

	@Override
	public ArrayList<Employee> getEmployeeByJobId(int jobId) throws SQLException {
		ArrayList<Employee> emps = new ArrayList<>();
		emps = employeeMapper.selectEmployeeByJobId(jobId);
		return emps;
	}

	@Override
	public void addEmployee(Employee emp) {
		employeeMapper.insertEmployee(emp);
		session.commit();
	}

	@Override
	public void updateEmployee(Employee emp) {
		employeeMapper.updateEmployee(emp);
		session.commit();
	}

	@Override
	public void deleteEmployee(Employee emp) {
		employeeMapper.deleteEmployee(emp);
		session.commit();
	}
}
