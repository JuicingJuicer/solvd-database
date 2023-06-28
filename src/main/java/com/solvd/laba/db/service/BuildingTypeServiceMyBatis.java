package main.java.com.solvd.laba.db.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import main.java.com.solvd.laba.db.interfaces.IBuildingTypeService;
import main.java.com.solvd.laba.db.mapper.BuildingTypeMapper;
import main.java.com.solvd.laba.db.model.BuildingType;
import main.java.com.solvd.laba.db.ulti.SessionUtil;

public class BuildingTypeServiceMyBatis implements IBuildingTypeService {
	private BuildingTypeMapper buildingTypeMapper;

	public BuildingTypeServiceMyBatis() {
	}

	@Override
	public BuildingType getBuildingType(int id) {
		try (SqlSession session = SessionUtil.openSession()) {
			buildingTypeMapper = session.getMapper(BuildingTypeMapper.class);
			BuildingType buildingType = buildingTypeMapper.selectBuildingTypeById(id);
			return buildingType;
		}
	}

	@Override
	public ArrayList<BuildingType> getBuildingTypes() {
		try (SqlSession session = SessionUtil.openSession()) {
			buildingTypeMapper = session.getMapper(BuildingTypeMapper.class);
			ArrayList<BuildingType> buildingTypes = buildingTypeMapper.selectBuildingTypes();
			return buildingTypes;
		}
	}

}
