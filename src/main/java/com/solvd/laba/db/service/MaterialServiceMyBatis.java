package main.java.com.solvd.laba.db.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import main.java.com.solvd.laba.db.interfaces.IMaterialService;
import main.java.com.solvd.laba.db.mapper.MaterialMapper;
import main.java.com.solvd.laba.db.model.Material;
import main.java.com.solvd.laba.db.ulti.SessionUtil;

public class MaterialServiceMyBatis implements IMaterialService {
	private MaterialMapper materialMapper;

	@Override
	public Material getMaterial(int id) {
		try (SqlSession session = SessionUtil.openSession()) {
			materialMapper = session.getMapper(MaterialMapper.class);
			Material material = materialMapper.selectMaterialById(id);
			return material;
		}
	}

	@Override
	public ArrayList<Material> getMaterials() {
		try (SqlSession session = SessionUtil.openSession()) {
			materialMapper = session.getMapper(MaterialMapper.class);
			ArrayList<Material> materials = materialMapper.selectMaterials();
			return materials;
		}
	}
}
