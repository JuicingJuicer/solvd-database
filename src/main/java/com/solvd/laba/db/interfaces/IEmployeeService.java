package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Employee;

public interface IEmployeeService {

	Employee getEmployee(int id) throws SQLException;

	ArrayList<Employee> getEmployees() throws SQLException;

	ArrayList<Employee> getEmployeeByJobId(int jobId) throws SQLException;

	void addEmployee(Employee emp) throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void deleteEmployee(Employee emp) throws SQLException;
}
