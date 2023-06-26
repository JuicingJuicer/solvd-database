package main.java.com.solvd.laba.db.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Employee;

public interface IEmployeeService {

	Employee getEmployee(int id) throws SQLException, IOException;

	ArrayList<Employee> getEmployees() throws SQLException, IOException;

	ArrayList<Employee> getEmployeeByJobId(int jobId) throws SQLException, IOException;

	void addEmployee(Employee emp) throws SQLException, IOException;

	void updateEmployee(Employee emp) throws SQLException, IOException;

	void deleteEmployee(Employee emp) throws SQLException, IOException;
}
