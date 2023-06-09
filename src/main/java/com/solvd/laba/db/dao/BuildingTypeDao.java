package main.java.com.solvd.laba.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.BuildingType;

public class BuildingTypeDao extends Dao<BuildingType> {
	protected String getStatement() {
		return "SELECT * FROM building_types WHERE building_type_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM building_types";
	}

	protected String insertStatement() {
		return "INSERT INTO building_types (building_type_id, building_name, building_tag, additional_details) VALUES (?, ?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE building_types SET building_type_id = ?, building_name = ?, building_tag = ?, additional_details = ? WHERE building_type_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM building_types WHERE building_type_id =?";
	}

	protected BuildingType create(ResultSet rs) throws SQLException {
		return new BuildingType(rs.getInt("building_type_id"), rs.getString("building_name"),
				rs.getString("building_tag"), rs.getInt("time"));
	}

	protected void addValue(BuildingType bType, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, bType.getBuildingTypeId());
		if (b) {
			ps.setString(2, bType.getBuildingName());
			ps.setString(3, bType.getBuildingTag());
			ps.setInt(4, bType.getTime());
		}
	}

	protected void addUpdatedValue(BuildingType bType, PreparedStatement ps) throws SQLException {
		ps.setInt(1, bType.getBuildingTypeId());
		ps.setString(2, bType.getBuildingName());
		ps.setString(3, bType.getBuildingTag());
		ps.setInt(4, bType.getTime());
		ps.setInt(5, bType.getBuildingTypeId());
	}
}
