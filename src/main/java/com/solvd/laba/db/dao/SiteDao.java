package main.java.com.solvd.laba.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.ConnectionUlti;
import main.java.com.solvd.laba.db.interfaces.ISiteDao;
import main.java.com.solvd.laba.db.model.Site;

public class SiteDao extends Dao<Site> implements ISiteDao {

	protected String getStatement() {
		return "SELECT * FROM SITES WHERE site_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM SITES";
	}

	protected String insertStatement() {
		return "INSERT INTO SITES (site_id, address, city_id, zip) VALUES (?, ?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE SITES SET site_id = ?, address = ?, city_id = ?, zip = ? WHERE site_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM SITES WHERE site_id =?";
	}

	protected Site create(ResultSet rs) throws SQLException {
		return new Site(rs.getInt("site_id"), rs.getString("address"), rs.getInt("zip"));
	}

	protected void addValue(Site site, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, site.getSiteId());
		if (b) {
			ps.setString(2, site.getAddress());
			ps.setInt(3, site.getCity().getCityId());
			ps.setInt(4, site.getZip());
		}
	}

	protected void addUpdatedValue(Site site, PreparedStatement ps) throws SQLException {
		ps.setInt(1, site.getSiteId());
		ps.setString(2, site.getAddress());
		ps.setInt(3, site.getCity().getCityId());
		ps.setInt(4, site.getZip());
		ps.setInt(5, site.getSiteId());
	}

	@Override
	public int getCId(int id) throws SQLException {
		Connection c = ConnectionUlti.getConnection();
		try {
			PreparedStatement ps = c.prepareStatement("SELECT city_id FROM SITES WHERE site_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("city_id");
			}
		} finally {
			ConnectionUlti.releaseConnection(c);
		}
		return 0;
	}
}
