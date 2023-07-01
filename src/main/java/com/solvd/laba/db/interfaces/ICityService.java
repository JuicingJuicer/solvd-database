package main.java.com.solvd.laba.db.interfaces;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.City;

public interface ICityService {

	City getCity(int id);

	City getCityByName(String name);

	ArrayList<City> getCities();

	void addCity(City city);

	void updateCity(City city);

	void deleteCity(City city);
}
