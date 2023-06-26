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

	public Site getSite(int id) throws SQLException {
		Site site = siteDao.get(id);
		City city = cityDao.get(siteDao.getCId(id));
		city.setState(stateDao.get(city.getCityId()));
		site.setCity(city);
		return site;
	}

	@Override
	public ArrayList<Site> getSites() throws SQLException {
		ArrayList<Site> sites = new ArrayList<>();
		sites = siteDao.getAll();
		return sites;
	}

	@Override
	public ArrayList<Site> getSiteByCityId(int cityId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSite(Site site) throws SQLException {
		siteDao.insert(site);
	}

	@Override
	public void updateSite(Site site) throws SQLException {
		siteDao.update(site);
	}

	@Override
	public void deleteSite(Site site) throws SQLException {
		siteDao.delete(site);
	}
}
