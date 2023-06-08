package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;

import main.java.com.solvd.laba.db.dao.CityDao;
import main.java.com.solvd.laba.db.dao.StateDao;
import main.java.com.solvd.laba.db.model.City;

public class CityService {
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
}
