package main.java.com.solvd.laba.db.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.City;

public interface ICityService {

	City getCity(int id) throws SQLException, IOException;

	City getCityByName(String name) throws SQLException, IOException;

	ArrayList<City> getCities() throws SQLException, IOException;

	void addCity(City city) throws SQLException, IOException;

	void updateCity(City city) throws SQLException, IOException;

	void deleteCity(City city) throws SQLException, IOException;
}
