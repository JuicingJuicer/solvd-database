package main.java.com.solvd.laba.db.mapper;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.City;

public interface CityMapper {

	City selectCityById(int id);

	City selectCityByName(String name);

	ArrayList<City> selectCities();

	void insertCity(City city);

	void updateCity(City city);

	void deleteCity(City city);
}
