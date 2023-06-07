package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.Employee;

public interface IEmployeeDao extends IDao<Employee> {
	int getJId(int id) throws SQLException;
}
