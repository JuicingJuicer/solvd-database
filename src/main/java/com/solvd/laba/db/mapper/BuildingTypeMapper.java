package main.java.com.solvd.laba.db.mapper;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.BuildingType;

public interface BuildingTypeMapper {

	BuildingType selectBuildingTypeById(int id);

	ArrayList<BuildingType> selectBuildingTypes();
}
