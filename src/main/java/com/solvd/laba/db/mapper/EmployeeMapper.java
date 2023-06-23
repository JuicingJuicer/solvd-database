package main.java.com.solvd.laba.db.mapper;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Employee;

public interface EmployeeMapper {

	Employee selectEmployeeById(int id);

	ArrayList<Employee> selectEmployees();

	ArrayList<Employee> selectEmployeeByJobId(int id);

	void insertEmployee(Employee emp);

	void updateEmployee(Employee emp);

	void deleteEmployee(Employee emp);
}
