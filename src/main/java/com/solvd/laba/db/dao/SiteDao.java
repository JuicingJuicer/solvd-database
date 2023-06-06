package main.java.com.solvd.laba.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.Site;

public class SiteDao extends Dao<Site> {
	CityDao cd = new CityDao();

	protected String getStatement() {
		return "SELECT * FROM SITE WHERE site_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM SITE";
	}

	protected String insertStatement() {
		return "INSERT INTO SITE (site_id, address, city_id, zip) VALUES (?, ?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE SITE SET site_id = ?, address = ?, city_id = ?, zip = ? WHERE site_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM SITE WHERE site_id =?";
	}

	protected Site create(ResultSet rs) throws SQLException {
		return new Site(rs.getInt("site_id"), rs.getString("address"), cd.get(rs.getInt("city_id")), rs.getInt("zip"));
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
}
