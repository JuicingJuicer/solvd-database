package main.java.com.solvd.laba.db.interfaces;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.BuildingType;

public interface IBuildingTypeService {
	BuildingType getBuildingType(int id);

	ArrayList<BuildingType> getBuildingTypes();
}
