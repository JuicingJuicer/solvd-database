package main.java.com.solvd.laba.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import main.java.com.solvd.laba.db.interfaces.IPackageDao;
import main.java.com.solvd.laba.db.model.Package;
import main.java.com.solvd.laba.db.ulti.ConnectionUtil;

public class PackageDao extends Dao<Package> implements IPackageDao {
	protected String getStatement() {
		return "SELECT * FROM packages WHERE package_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM packages";
	}

	protected String insertStatement() {
		return "INSERT INTO packages (package_id, purchase_date, status, site_id) VALUES (?, ?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE packages SET package_id = ?, purchase_date = ?, status = ?, site_id = ? WHERE package_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM packages WHERE package_id =?";
	}

	protected Package create(ResultSet rs) throws SQLException {
		return new Package(rs.getInt("package_id"), rs.getDate("purchase_date"), rs.getString("status"));
	}

	protected void addValue(Package pack, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, pack.getPackageId());
		if (b) {
			ps.setDate(2, new java.sql.Date(pack.getPurchaseDate().getTime()));
			ps.setString(3, pack.getStatus());
			ps.setInt(4, pack.getSite().getSiteId());
		}
	}

	protected void addUpdatedValue(Package pack, PreparedStatement ps) throws SQLException {
		ps.setInt(1, pack.getPackageId());
		ps.setDate(2, new java.sql.Date(pack.getPurchaseDate().getTime()));
		ps.setString(3, pack.getStatus());
		ps.setInt(4, pack.getSite().getSiteId());
		ps.setInt(5, pack.getPackageId());
	}

	@Override
	public int getSId(int id) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionUtil.getConnection();
			ps = c.prepareStatement("SELECT site_id FROM packages WHERE package_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("site_id");
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

	@Override
	public HashMap<Integer, Integer> getIdQuantity(int id) throws SQLException {
		HashMap<Integer, Integer> map = new HashMap<>();
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionUtil.getConnection();
			ps = c.prepareStatement("SELECT material_id, quantity FROM package_details WHERE package_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				map.put(rs.getInt("material_id"), rs.getInt("quantity"));
			}
		} finally {
			if (c != null) {
				ConnectionUtil.releaseConnection(c);
			}
			if (ps != null) {
				ps.close();
			}
		}
		return map;
	}
}
