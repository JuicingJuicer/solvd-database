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

	public City getCity(int id) throws SQLException {
		City city = cityDao.get(id);
		city.setState(stateDao.get(id));
		return city;
	}

	@Override
	public City getCityByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<City> getCities() throws SQLException {
		ArrayList<City> cities = new ArrayList<>();
		cities = cityDao.getAll();
		return cities;
	}

	@Override
	public void addCity(City city) throws SQLException {
		cityDao.insert(city);
	}

	@Override
	public void updateCity(City city) throws SQLException {
		cityDao.update(city);
	}

	@Override
	public void deleteCity(City city) throws SQLException {
		cityDao.delete(city);
	}
}
