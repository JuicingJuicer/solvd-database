package main.java.com.solvd.laba.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.ConnectionUlti;
import main.java.com.solvd.laba.db.interfaces.IDao;
import main.java.com.solvd.laba.db.model.Job;

public class JobDao implements IDao<Job> {
	@Override
	public Job get(long id) throws SQLException {
		Job j = new Job();
		try (Connection c = ConnectionUlti.getConnection()) {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM JOBS WHERE job_id=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				j.setJobId(rs.getLong("job_id"));
				j.setJobTitle(rs.getString("job_title"));
			}
		}
		return j;
	}

	@Override
	public ArrayList<String> getCol() throws SQLException {
		ArrayList<String> col = new ArrayList<>();
		try (Connection c = ConnectionUlti.getConnection()) {
			PreparedStatement ps = c.prepareStatement("SHOW columns FROM JOBS");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				col.add(rs.getString("Field"));
			}
		}
		return col;
	}

	@Override
	public ArrayList<Job> getAll() throws SQLException {
		ArrayList<Job> jobs = new ArrayList<>();
		try (Connection c = ConnectionUlti.getConnection()) {
			PreparedStatement ps = c.prepareStatement("SELECT * FROM JOBS");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				jobs.add(new Job(rs.getLong("job_id"), rs.getString("job_title")));
			}
		}
		return jobs;
	}

	@Override
	public void insert(Job job) {
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.add(job);
	}

	@Override
	public void update(Job job, String[] p) {
		insert(job);
	}

	@Override
	public void delete(Job job) {
		ArrayList<Job> jobs = new ArrayList<>();
		jobs.remove(job);
	}
}
