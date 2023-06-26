package main.java.com.solvd.laba.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.State;

public class StateDao extends Dao<State> {
	protected String getStatement() {
		return "SELECT * FROM states WHERE state_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM states";
	}

	protected String insertStatement() {
		return "INSERT INTO states (state_id, state_name) VALUES (?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE states SET state_id = ?, state_name = ? WHERE state_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM states WHERE state_id =?";
	}

	protected State create(ResultSet rs) throws SQLException {
		return new State(rs.getInt("state_id"), rs.getString("state_name"));
	}

	protected void addValue(State state, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, state.getStateId());
		if (b) {
			ps.setString(2, state.getStateName());
		}
	}

	protected void addUpdatedValue(State state, PreparedStatement ps) throws SQLException {
		ps.setInt(1, state.getStateId());
		ps.setString(2, state.getStateName());
		ps.setInt(3, state.getStateId());
	}
}
