package main.java.com.solvd.laba.db.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import main.java.com.solvd.laba.db.interfaces.ICityService;
import main.java.com.solvd.laba.db.mapper.CityMapper;
import main.java.com.solvd.laba.db.model.City;

public class CityServiceMyBatis implements ICityService {
	private SqlSession session;
	private CityMapper cityMapper;

	public CityServiceMyBatis() throws IOException {
		InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
		session = new SqlSessionFactoryBuilder().build(stream).openSession();
		cityMapper = session.getMapper(CityMapper.class);
	}

	@Override
	public City getCity(int id) throws SQLException {
		City city = cityMapper.selectCityById(id);
		return city;
	}

	@Override
	public City getCityByName(String name) throws SQLException {
		City city = cityMapper.selectCityByName(name);
		return city;
	}

	@Override
	public ArrayList<City> getCities() throws SQLException {
		ArrayList<City> cities = new ArrayList<>();
		cities = cityMapper.selectCities();
		return cities;
	}

	@Override
	public void addCity(City city) throws SQLException {
		cityMapper.insertCity(city);
		session.commit();
	}

	@Override
	public void updateCity(City city) throws SQLException {
		cityMapper.updateCity(city);
		session.commit();
	}

	@Override
	public void deleteCity(City city) throws SQLException {
		cityMapper.deleteCity(city);
		session.commit();
	}

}
