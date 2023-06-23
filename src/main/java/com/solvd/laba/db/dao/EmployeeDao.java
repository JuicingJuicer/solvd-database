package main.java.com.solvd.laba.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.ConnectionUlti;
import main.java.com.solvd.laba.db.interfaces.IEmployeeDao;
import main.java.com.solvd.laba.db.model.Employee;

public class EmployeeDao extends Dao<Employee> implements IEmployeeDao {

	protected String getStatement() {
		return "SELECT * FROM employees WHERE emp_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM employees";
	}

	protected String insertStatement() {
		return "INSERT INTO employees (emp_id, first_name, last_name, age, email, phone_number, job_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE employees SET emp_id = ?, first_name = ?, last_name = ?, age = ?, email = ?, phone_number = ?, job_id = ? WHERE emp_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM employees WHERE emp_id =?";
	}

	protected Employee create(ResultSet rs) throws SQLException {
		return new Employee(rs.getInt("emp_id"), rs.getString("first_name"), rs.getString("last_name"),
				rs.getInt("age"), rs.getString("email"), rs.getString("phone_number"));
	}

	protected void addValue(Employee emp, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, emp.getEmpId());
		if (b) {
			ps.setString(2, emp.getFirstName());
			ps.setString(3, emp.getLastName());
			ps.setInt(4, emp.getAge());
			ps.setString(5, emp.getEmail());
			ps.setString(6, emp.getPhoneNumber());
			ps.setInt(7, emp.getJob().getJobId());
		}
	}

	protected void addUpdatedValue(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setInt(1, emp.getEmpId());
		ps.setString(2, emp.getFirstName());
		ps.setString(3, emp.getLastName());
		ps.setInt(4, emp.getAge());
		ps.setString(5, emp.getEmail());
		ps.setString(6, emp.getPhoneNumber());
		ps.setInt(7, emp.getJob().getJobId());
		ps.setInt(8, emp.getEmpId());
	}

	@Override
	public int getJId(int id) throws SQLException {
		Connection c = ConnectionUlti.getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT job_id FROM employees WHERE emp_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ConnectionUlti.releaseConnection(c);
			if (rs.next()) {
				return rs.getInt("job_id");
			}
		} finally {
			ConnectionUlti.releaseConnection(c);
		}
		return 0;
	}

	@Override
	public ArrayList<Integer> getTId(int id) throws SQLException {
		ArrayList<Integer> tIds = new ArrayList<>();
		Connection c = ConnectionUlti.getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT team_id FROM emp_teams WHERE emp_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ConnectionUlti.releaseConnection(c);
			while (rs.next()) {
				tIds.add(rs.getInt("team_id"));
			}
		} finally {
			ConnectionUlti.releaseConnection(c);
		}
		return tIds;
	}

	@Override
	public ArrayList<Employee> getEmployeeByJobId(int id) throws SQLException {
		ArrayList<Employee> emps = new ArrayList<>();
		Connection c = ConnectionUlti.getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM employees WHERE job_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emps.add(create(rs));
			}
		} finally {
			ConnectionUlti.releaseConnection(c);
		}
		return emps;
	}
}
