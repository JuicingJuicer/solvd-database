package main.java.com.solvd.laba.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.interfaces.ICityDao;
import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.ulti.ConnectionUtil;

public class CityDao extends Dao<City> implements ICityDao {

	protected String getStatement() {
		return "SELECT * FROM cities WHERE city_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM cities";
	}

	protected String insertStatement() {
		return "INSERT INTO cities (city_id, city_name, state_id, zip) VALUES (?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE cities SET city_id = ?, city_name = ?, state_id = ? WHERE city_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM cities WHERE city_id =?";
	}

	protected City create(ResultSet rs) throws SQLException {
		return new City(rs.getInt("city_id"), rs.getString("city_name"));
	}

	protected void addValue(City city, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, city.getCityId());
		if (b) {
			ps.setString(2, city.getCityName());
			ps.setInt(3, city.getState().getStateId());
		}
	}

	protected void addUpdatedValue(City city, PreparedStatement ps) throws SQLException {
		ps.setInt(1, city.getCityId());
		ps.setString(2, city.getCityName());
		ps.setInt(3, city.getState().getStateId());
		ps.setInt(4, city.getCityId());
	}

	@Override
	public int getSId(int id) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionUtil.getConnection();
			ps = c.prepareStatement("SELECT state_id FROM cities WHERE city_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("state_id");
			}
		} finally {
			if (c != null) {
				ConnectionUtil.releaseConnection(c);
			}
			if (ps != null) {
				ps.close();
			}
		}
		return 0;
	}
}
