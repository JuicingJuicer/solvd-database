package main.java.com.solvd.laba.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import main.java.com.solvd.laba.db.ConnectionUlti;
import main.java.com.solvd.laba.db.interfaces.IPackageDao;
import main.java.com.solvd.laba.db.model.Package;

public class PackageDao extends Dao<Package> implements IPackageDao {
	protected String getStatement() {
		return "SELECT * FROM PACKAGES WHERE package_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM PACKAGES";
	}

	protected String insertStatement() {
		return "INSERT INTO PACKAGES (package_id, purchase_date, status, site_id) VALUES (?, ?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE PACKAGES SET package_id = ?, purchase_date = ?, status = ?, site_id = ? WHERE package_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM PACKAGES WHERE package_id =?";
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
		try (Connection c = ConnectionUlti.getConnection()) {
			PreparedStatement ps = c.prepareStatement("SELECT site_id FROM PACKAGES WHERE package_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
//			ConnectionUlti.releaseConnection(c);
			if (rs.next()) {
				return rs.getInt("site_id");
			}
		}
		return 0;
	}

	@Override
	public HashMap<Integer, Integer> getIdQuantity(int id) throws SQLException {
		HashMap<Integer, Integer> map = new HashMap<>();
		try (Connection c = ConnectionUlti.getConnection()) {
			PreparedStatement ps = c
					.prepareStatement("SELECT material_id, quantity FROM PACKAGE_DETAILS WHERE package_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				map.put(rs.getInt("material_id"), rs.getInt("quantity"));
			}
		}
//		ConnectionUlti.releaseConnection(c);
		return map;
	}
}
