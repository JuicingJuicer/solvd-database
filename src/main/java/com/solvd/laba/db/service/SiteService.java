package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;

import main.java.com.solvd.laba.db.dao.CityDao;
import main.java.com.solvd.laba.db.dao.SiteDao;
import main.java.com.solvd.laba.db.dao.StateDao;
import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.model.Site;

public class SiteService {
	SiteDao siteDao;
	CityDao cityDao;
	StateDao stateDao;

	public SiteService() {
		siteDao = new SiteDao();
		cityDao = new CityDao();
		stateDao = new StateDao();
	}

	public Site getSite(int id) throws SQLException {
		Site site = siteDao.get(id);
		City city = cityDao.get(siteDao.getCId(id));
		city.setState(stateDao.get(city.getCityId()));
		site.setCity(city);
		return site;
	}
}
