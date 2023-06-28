package main.java.com.solvd.laba.db.interfaces;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Employee;

public interface IEmployeeService {

	Employee getEmployee(int id);

	ArrayList<Employee> getEmployees();

	ArrayList<Employee> getEmployeeByJobId(int jobId);

	void addEmployee(Employee emp);

	void updateEmployee(Employee emp);

	void deleteEmployee(Employee emp);
}
