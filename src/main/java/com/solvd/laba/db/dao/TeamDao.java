package main.java.com.solvd.laba.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.Team;

public class TeamDao extends Dao<Team> {
	protected String getStatement() {
		return "SELECT * FROM teams WHERE team_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM teams";
	}

	protected String insertStatement() {
		return "INSERT INTO teams (team_id, team_name, team_details) VALUES (?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE teams SET team_id = ?, tean_name = ?, team_details = ? WHERE team_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM teams WHERE team_id =?";
	}

	protected Team create(ResultSet rs) throws SQLException {
		return new Team(rs.getInt("team_id"), rs.getString("team_name"), rs.getString("team_details"));
	}

	protected void addValue(Team team, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, team.getTeamId());
		if (b) {
			ps.setString(2, team.getTeamName());
			ps.setString(2, team.getTeamDetails());
		}
	}

	protected void addUpdatedValue(Team team, PreparedStatement ps) throws SQLException {
		ps.setInt(1, team.getTeamId());
		ps.setString(2, team.getTeamName());
		ps.setString(2, team.getTeamDetails());
		ps.setInt(4, team.getTeamId());
	}
}
