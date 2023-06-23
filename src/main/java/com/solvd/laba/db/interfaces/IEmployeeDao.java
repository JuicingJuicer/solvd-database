package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Employee;

public interface IEmployeeDao extends IDao<Employee> {
	int getJId(int id) throws SQLException;

	ArrayList<Integer> getTId(int id) throws SQLException;

	ArrayList<Employee> getEmployeeByJobId(int id) throws SQLException;
}
