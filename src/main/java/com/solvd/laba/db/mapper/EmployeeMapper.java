package main.java.com.solvd.laba.db.mapper;

import main.java.com.solvd.laba.db.model.Employee;

public interface EmployeeMapper {

	Employee selectEmployeeById(int id);
}
