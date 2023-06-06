package main.java.com.solvd.laba.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.Job;

public class JobDao extends Dao<Job> {
	protected String getStatement() {
		return "SELECT * FROM JOBS WHERE job_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM JOBS";
	}

	protected String insertStatement() {
		return "INSERT INTO JOBS (job_id, job_title) VALUES (?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE JOBS SET job_id = ?, job_title = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM JOBS WHERE job_id =?";
	}

	protected Job create(ResultSet rs) throws SQLException {
		return new Job(rs.getInt("job_id"), rs.getString("job_title"));
	}

	protected void addValue(Job job, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, job.getJobId());
		if (b) {
			ps.setString(2, job.getJobTitle());
		}
	}

	protected void addUpdatedValue(Job job, PreparedStatement ps) throws SQLException {
		ps.setInt(1, job.getJobId());
		ps.setString(2, job.getJobTitle());
		ps.setInt(3, job.getJobId());
	}
}
