package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;

import main.java.com.solvd.laba.db.dao.EmployeeDao;
import main.java.com.solvd.laba.db.dao.JobDao;
import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.model.Job;

public class EmployeeService {
	private EmployeeDao ed;
	private JobDao jd;

	public EmployeeService() {
		ed = new EmployeeDao();
		jd = new JobDao();
	}

	public Employee getEmployee(int id) throws SQLException {
		Employee employee = ed.get(id);
		Job j = jd.get(ed.getJId(id));
		employee.setJob(j);
		return employee;
	}
}
