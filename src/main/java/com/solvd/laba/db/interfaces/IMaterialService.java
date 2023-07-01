package main.java.com.solvd.laba.db.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Material;

public interface IMaterialService {

	Material getMaterial(int id) throws SQLException, IOException;

	ArrayList<Material> getMaterials() throws SQLException, IOException;
}
