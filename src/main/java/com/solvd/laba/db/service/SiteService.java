package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.dao.CityDao;
import main.java.com.solvd.laba.db.dao.SiteDao;
import main.java.com.solvd.laba.db.dao.StateDao;
import main.java.com.solvd.laba.db.interfaces.ISiteService;
import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.model.Site;

public class SiteService implements ISiteService {
	SiteDao siteDao;
	CityDao cityDao;
	StateDao stateDao;

	public SiteService() {
		siteDao = new SiteDao();
		cityDao = new CityDao();
		stateDao = new StateDao();
	}

	public Site getSite(int id) {
		try {
			Site site = siteDao.get(id);
			City city = cityDao.get(siteDao.getCId(id));
			city.setState(stateDao.get(city.getCityId()));
			site.setCity(city);
			return site;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Site> getSites() {
		try {
			ArrayList<Site> sites = new ArrayList<>();
			sites = siteDao.getAll();
			return sites;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Site> getSiteByCityId(int cityId) {
		try {
			ArrayList<Site> sites = new ArrayList<>();
			sites = siteDao.getSiteByCityId(cityId);
			return sites;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addSite(Site site) {
		try {
			siteDao.insert(site);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateSite(Site site) {
		try {
			siteDao.update(site);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteSite(Site site) {
		try {
			siteDao.delete(site);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
