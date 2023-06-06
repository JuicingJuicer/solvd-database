package main.java.com.solvd.laba.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.EmpTeam;

public class EmpTeamDao extends Dao<EmpTeam> {
	EmployeeDao ed = new EmployeeDao();
	TeamDao td = new TeamDao();

	protected String getStatement() {
		return "SELECT * FROM EMP_TEAMS WHERE emp_team_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM EMP_TEAMS";
	}

	protected String insertStatement() {
		return "INSERT INTO EMP_TEAMS (emp_team_id, emp_id, team_id) VALUES (?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE EMP_TEAMS SET emp_team_id = ?, emp_id = ?, team_id = ? WHERE emp_team_id";
	}

	protected String deleteStatement() {
		return "DELETE FROM EMP_TEAMS WHERE emp_team_id =?";
	}

	protected EmpTeam create(ResultSet rs) throws SQLException {
		return new EmpTeam(rs.getInt("emp_team_id"), ed.get(rs.getInt("emp_id")), td.get(rs.getInt("team_id")));
	}

	protected void addValue(EmpTeam et, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, et.getEmpTeamId());
		if (b) {
			ps.setInt(2, et.getEmp().getEmpId());
			ps.setInt(3, et.getTeam().getTeamId());
		}
	}

	protected void addUpdatedValue(EmpTeam et, PreparedStatement ps) throws SQLException {
		ps.setInt(1, et.getEmpTeamId());
		ps.setInt(2, et.getEmp().getEmpId());
		ps.setInt(3, et.getTeam().getTeamId());
		ps.setInt(4, et.getEmpTeamId());
	}
}
