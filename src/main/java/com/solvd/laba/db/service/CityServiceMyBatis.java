package main.java.com.solvd.laba.db.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import main.java.com.solvd.laba.db.interfaces.ICityService;
import main.java.com.solvd.laba.db.mapper.CityMapper;
import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.ulti.SessionUtil;

public class CityServiceMyBatis implements ICityService {
	private CityMapper cityMapper;

	public CityServiceMyBatis() {
	}

	@Override
	public City getCity(int id) {
		try (SqlSession session = SessionUtil.openSession()) {
			cityMapper = session.getMapper(CityMapper.class);
			City city = cityMapper.selectCityById(id);
			return city;
		}
	}

	@Override
	public City getCityByName(String name) {
		try (SqlSession session = SessionUtil.openSession()) {
			cityMapper = session.getMapper(CityMapper.class);
			City city = cityMapper.selectCityByName(name);
			return city;
		}
	}

	@Override
	public ArrayList<City> getCities() {
		try (SqlSession session = SessionUtil.openSession()) {
			cityMapper = session.getMapper(CityMapper.class);
			ArrayList<City> cities = cityMapper.selectCities();
			return cities;
		}
	}

	@Override
	public void addCity(City city) {
		try (SqlSession session = SessionUtil.openSession()) {
			cityMapper = session.getMapper(CityMapper.class);
			cityMapper.insertCity(city);
			session.commit();
		}
	}

	@Override
	public void updateCity(City city) {
		try (SqlSession session = SessionUtil.openSession()) {
			cityMapper = session.getMapper(CityMapper.class);
			cityMapper.updateCity(city);
			session.commit();
		}
	}

	@Override
	public void deleteCity(City city) {
		try (SqlSession session = SessionUtil.openSession()) {
			cityMapper = session.getMapper(CityMapper.class);
			cityMapper.deleteCity(city);
			session.commit();
		}
	}

}
