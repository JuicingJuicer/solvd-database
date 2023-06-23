package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.City;

public interface ICityService {

	City getCity(int id) throws SQLException;

	City getCityByName(String name) throws SQLException;

	ArrayList<City> getCities() throws SQLException;

	void addCity(City city) throws SQLException;

	void updateCity(City city) throws SQLException;

	void deleteCity(City city) throws SQLException;
}
