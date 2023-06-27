package main.java.com.solvd.laba.db.mapper;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Material;

public interface MaterialMapper {

	Material selectMaterialById(int id);

	ArrayList<Material> selectMaterials();
}
