package main.java.com.solvd.laba.db.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.BuildingType;

public interface IBuildingTypeService {
	BuildingType getBuildingType(int id) throws SQLException, IOException;

	ArrayList<BuildingType> getBuildingTypes() throws SQLException, IOException;
}
