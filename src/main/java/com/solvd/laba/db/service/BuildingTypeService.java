package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.dao.BuildingTypeDao;
import main.java.com.solvd.laba.db.interfaces.IBuildingTypeService;
import main.java.com.solvd.laba.db.model.BuildingType;

public class BuildingTypeService implements IBuildingTypeService {
	BuildingTypeDao buildingTypeDao;

	public BuildingTypeService() {
		buildingTypeDao = new BuildingTypeDao();
	}

	@Override
	public BuildingType getBuildingType(int id) {
		try {
			BuildingType buildingType = buildingTypeDao.get(id);
			return buildingType;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<BuildingType> getBuildingTypes() {
		try {
			ArrayList<BuildingType> buildingTypes = buildingTypeDao.getAll();
			return buildingTypes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
