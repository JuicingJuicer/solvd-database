package main.java.com.solvd.laba.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.ConnectionUlti;
import main.java.com.solvd.laba.db.interfaces.IDao;
import main.java.com.solvd.laba.db.model.Employee;

public class EmployeeDao implements IDao<Employee> {
	JobDao jb = new JobDao();

	@Override
	public Employee get(long id) throws SQLException {
		Employee e = new Employee();
		try (Connection c = ConnectionUlti.getConnection()) {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM EMPLOYEES WHERE emp_id=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e.setEmpId(rs.getLong("emp_id"));
				e.setFirstName(rs.getString("first_name"));
				e.setLastName(rs.getString("last_name"));
				e.setAge(rs.getInt("age"));
				e.setEmail(rs.getString("email"));
				e.setPhoneNumber(rs.getString("phone_number"));
				e.setJob(jb.get(rs.getInt("job_id")));
			}
		}
		return e;
	}

	@Override
	public ArrayList<String> getCol() throws SQLException {
		ArrayList<String> col = new ArrayList<>();
		try (Connection c = ConnectionUlti.getConnection()) {
			PreparedStatement ps = c.prepareStatement("SHOW columns FROM EMPLOYEES");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				col.add(rs.getString("Field"));
			}
		}
		return col;
	}

	@Override
	public ArrayList<Employee> getAll() throws SQLException {
		ArrayList<Employee> employees = new ArrayList<>();
		try (Connection c = ConnectionUlti.getConnection()) {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM EMPLOYEES");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employees.add(new Employee(rs.getLong("emp_id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getInt("age"), rs.getString("email"), rs.getString("phone_number"),
						jb.get(rs.getInt("job_id"))));
			}
		}
		return employees;
	}

	@Override
	public void insert(Employee emp) {
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(emp);
	}

	@Override
	public void update(Employee emp, String[] p) {
		insert(emp);
	}

	@Override
	public void delete(Employee emp) throws SQLException {
		try (Connection c = ConnectionUlti.getConnection()) {
			PreparedStatement ps = c.prepareStatement("DELETE FROM EMPLOYEES WHERE emp_id =?");
			ps.setLong(1, emp.getEmpId());
			ResultSet rs = ps.executeQuery();
		}
	}

	public static void main(String[] args) throws SQLException {
		EmployeeDao ed = new EmployeeDao();
		System.out.println(ed.getAll());
	}
}
