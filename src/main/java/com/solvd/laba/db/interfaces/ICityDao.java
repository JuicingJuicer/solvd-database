package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.City;

public interface ICityDao extends IDao<City> {
	int getSId(int id) throws SQLException;
}
