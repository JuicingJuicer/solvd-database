package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.dao.CityDao;
import main.java.com.solvd.laba.db.dao.StateDao;
import main.java.com.solvd.laba.db.interfaces.ICityService;
import main.java.com.solvd.laba.db.model.City;

public class CityService implements ICityService {
	CityDao cityDao;
	StateDao stateDao;

	public CityService() {
		cityDao = new CityDao();
		stateDao = new StateDao();
	}

	public City getCity(int id) {
		try {
			City city = cityDao.get(id);
			city.setState(stateDao.get(id));
			return city;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public City getCityByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<City> getCities() {
		try {
			ArrayList<City> cities = cityDao.getAll();
			return cities;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addCity(City city) {
		try {
			cityDao.insert(city);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCity(City city) {
		try {
			cityDao.update(city);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCity(City city) {
		try {
			cityDao.delete(city);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
