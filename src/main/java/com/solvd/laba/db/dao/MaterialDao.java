package main.java.com.solvd.laba.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.Material;

public class MaterialDao extends Dao<Material> {
	protected String getStatement() {
		return "SELECT * FROM materials WHERE material_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM materials";
	}

	protected String insertStatement() {
		return "INSERT INTO materials (material_id, material_name, material_desc, material_price) VALUES (?, ?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE materials SET material_id = ?, material_name = ?, material_desc = ?, material_price = ? WHERE package_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM materials WHERE material_id =?";
	}

	protected Material create(ResultSet rs) throws SQLException {
		return new Material(rs.getInt("material_id"), rs.getString("material_name"), rs.getString("material_desc"),
				rs.getInt("material_price"));
	}

	protected void addValue(Material mat, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, mat.getMaterialId());
		if (b) {
			ps.setString(2, mat.getMaterialName());
			ps.setString(3, mat.getMaterialDesc());
			ps.setInt(4, mat.getMaterialPrice());
		}
	}

	protected void addUpdatedValue(Material mat, PreparedStatement ps) throws SQLException {
		ps.setInt(1, mat.getMaterialId());
		ps.setString(2, mat.getMaterialName());
		ps.setString(3, mat.getMaterialDesc());
		ps.setInt(4, mat.getMaterialPrice());
		ps.setInt(1, mat.getMaterialId());
	}
}
