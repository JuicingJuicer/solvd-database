package main.java.com.solvd.laba.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.State;

public class StateDao extends Dao<State> {
	protected String getStatement() {
		return "SELECT * FROM STATES WHERE state_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM STATES";
	}

	protected String insertStatement() {
		return "INSERT INTO STATES (state_id, name) VALUES (?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE STATES SET state_id = ?, name = ? WHERE state_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM STATES WHERE state_id =?";
	}

	protected State create(ResultSet rs) throws SQLException {
		return new State(rs.getInt("state_id"), rs.getString("name"));
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
