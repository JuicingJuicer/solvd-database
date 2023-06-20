package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import main.java.com.solvd.laba.db.dao.CityDao;
import main.java.com.solvd.laba.db.dao.MaterialDao;
import main.java.com.solvd.laba.db.dao.PackageDao;
import main.java.com.solvd.laba.db.dao.SiteDao;
import main.java.com.solvd.laba.db.dao.StateDao;
import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.model.Material;
import main.java.com.solvd.laba.db.model.Package;
import main.java.com.solvd.laba.db.model.Site;

public class PackageService {
	PackageDao packageDao;
	SiteDao siteDao;
	CityDao cityDao;
	StateDao stateDao;
	MaterialDao materialDao;

	public PackageService() {
		packageDao = new PackageDao();
		siteDao = new SiteDao();
		cityDao = new CityDao();
		stateDao = new StateDao();
		materialDao = new MaterialDao();
	}

	public Package getPackage(int id) throws SQLException {
		Package pack = packageDao.get(id);
		pack.setSite(getPackageSite(packageDao.getSId(id)));
//		pack.setMaterialQuantity(getMatQuantity(id));
		return pack;
	}

	public Site getPackageSite(int id) throws SQLException {
		Site site = siteDao.get(id);
		City city = cityDao.get(site.getSiteId());
		city.setState(stateDao.get(city.getCityId()));
		site.setCity(city);
		return site;
	}

	public HashMap<Material, Integer> getMatQuantity(int id) throws SQLException {
		HashMap<Material, Integer> matQuantity = new HashMap<>();
		HashMap<Integer, Integer> map = packageDao.getIdQuantity(id);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			matQuantity.put(materialDao.get(entry.getKey()), entry.getValue());
		}
		return matQuantity;
	}
}
