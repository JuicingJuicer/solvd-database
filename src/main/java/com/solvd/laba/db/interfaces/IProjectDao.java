package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Project;

public interface IProjectDao extends IDao<Project> {
	int getIdByCol(String col, int id) throws SQLException;

	ArrayList<Integer> getCId(int id) throws SQLException;
}
