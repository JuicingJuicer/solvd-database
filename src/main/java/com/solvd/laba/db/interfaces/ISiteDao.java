package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Site;

public interface ISiteDao extends IDao<Site> {
	int getCId(int id) throws SQLException;

	ArrayList<Site> getSiteByCityId(int id) throws SQLException;
}
