package main.java.com.solvd.laba.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.BuildingType;

public class BuildingTypeDao extends Dao<BuildingType> {
	protected String getStatement() {
		return "SELECT * FROM BUILDING_TYPES WHERE building_type_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM BUILDING_TYPES";
	}

	protected String insertStatement() {
		return "INSERT INTO BUILDING_TYPES (building_type_id, building_name, building_tag, additional_details) VALUES (?, ?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE BUILDING_TYPES SET building_type_id = ?, building_name = ?, building_tag = ?, additional_details = ? WHERE building_type_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM BUILDING_TYPE WHERE building_type_id =?";
	}

	protected BuildingType create(ResultSet rs) throws SQLException {
		return new BuildingType(rs.getInt("building_type_id"), rs.getString("building_name"),
				rs.getString("building_tag"), rs.getString("additional_details"));
	}

	protected void addValue(BuildingType bType, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, bType.getBuildingTypeId());
		if (b) {
			ps.setString(2, bType.getBuildingName());
			ps.setString(3, bType.getBuildingTag());
			ps.setString(4, bType.getAdditionalDetails());
		}
	}

	protected void addUpdatedValue(BuildingType bType, PreparedStatement ps) throws SQLException {
		ps.setInt(1, bType.getBuildingTypeId());
		ps.setString(2, bType.getBuildingName());
		ps.setString(3, bType.getBuildingTag());
		ps.setString(4, bType.getAdditionalDetails());
		ps.setInt(5, bType.getBuildingTypeId());
	}
}
