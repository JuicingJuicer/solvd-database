package main.java.com.solvd.laba.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.interfaces.IDao;
import main.java.com.solvd.laba.db.ulti.ConnectionUtil;

public abstract class Dao<T> implements IDao<T> {
	@Override
	public T get(int id) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionUtil.getConnection();
			ps = c.prepareStatement(getStatement());
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return create(rs);
			}
			ps.close();
		} finally {
			if (c != null) {
				ConnectionUtil.releaseConnection(c);
			}
			if (ps != null) {
				ps.close();
			}
		}
		return null;
	}

	@Override
	public ArrayList<T> getAll() throws SQLException {
		ArrayList<T> all = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionUtil.getConnection();
			ps = c.prepareStatement(getAllStatement());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				all.add(create(rs));
			}
		} finally {
			if (c != null) {
				ConnectionUtil.releaseConnection(c);
			}
			if (ps != null) {
				ps.close();
			}
		}
		return all;
	}

	@Override
	public void insert(T t) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionUtil.getConnection();
			ps = c.prepareStatement(getAllStatement());
			addValue(t, ps, true);
			ps.executeUpdate();
		} finally {
			if (c != null) {
				ConnectionUtil.releaseConnection(c);
			}
			if (ps != null) {
				ps.close();
			}
		}
	}

	@Override
	public void update(T t) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionUtil.getConnection();
			ps = c.prepareStatement(getAllStatement());
			addUpdatedValue(t, ps);
			ps.executeUpdate();
		} finally {
			if (c != null) {
				ConnectionUtil.releaseConnection(c);
			}
			if (ps != null) {
				ps.close();
			}
		}
	}

	@Override
	public void delete(T t) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionUtil.getConnection();
			ps = c.prepareStatement(getAllStatement());
			addValue(t, ps, false);
			ps.executeUpdate();
		} finally {
			if (c != null) {
				ConnectionUtil.releaseConnection(c);
			}
			if (ps != null) {
				ps.close();
			}
		}
	}

	protected abstract String getStatement();

	protected abstract String getAllStatement();

	protected abstract String insertStatement();

	protected abstract String updateStatement();

	protected abstract String deleteStatement();

	protected abstract T create(ResultSet rs) throws SQLException;

	// if boolean is true then it will add all values otherwise it will add id only
	protected abstract void addValue(T t, PreparedStatement ps, boolean b) throws SQLException;

	protected abstract void addUpdatedValue(T t, PreparedStatement ps) throws SQLException;
}
