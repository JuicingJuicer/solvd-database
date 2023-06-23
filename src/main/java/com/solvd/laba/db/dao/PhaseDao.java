package main.java.com.solvd.laba.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.Phase;

public class PhaseDao extends Dao<Phase> {
	protected String getStatement() {
		return "SELECT * FROM phases WHERE phase_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM phases";
	}

	protected String insertStatement() {
		return "INSERT INTO phases (phase_id, phase_name) VALUES (?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE phases SET phase_id = ?, phase_name = ? WHERE phase_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM phases WHERE phase_id =?";
	}

	protected Phase create(ResultSet rs) throws SQLException {
		return new Phase(rs.getInt("phase_id"), rs.getString("phase_name"));
	}

	protected void addValue(Phase phase, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, phase.getPhaseId());
		if (b) {
			ps.setString(2, phase.getPhaseName());
		}
	}

	protected void addUpdatedValue(Phase phase, PreparedStatement ps) throws SQLException {
		ps.setInt(1, phase.getPhaseId());
		ps.setString(2, phase.getPhaseName());
		ps.setInt(3, phase.getPhaseId());
	}
}
