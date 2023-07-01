package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.dao.MaterialDao;
import main.java.com.solvd.laba.db.interfaces.IMaterialService;
import main.java.com.solvd.laba.db.model.Material;

public class MaterialService implements IMaterialService {
	MaterialDao materialDao;

	public MaterialService() {
		materialDao = new MaterialDao();
	}

	@Override
	public Material getMaterial(int id) {
		try {
			Material material = materialDao.get(id);
			return material;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Material> getMaterials() {
		try {
			ArrayList<Material> materials = materialDao.getAll();
			return materials;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
