package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import main.java.com.solvd.laba.db.dao.CityDao;
import main.java.com.solvd.laba.db.dao.MaterialDao;
import main.java.com.solvd.laba.db.dao.PackageDao;
import main.java.com.solvd.laba.db.dao.SiteDao;
import main.java.com.solvd.laba.db.dao.StateDao;
import main.java.com.solvd.laba.db.interfaces.IPackageService;
import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.model.Material;
import main.java.com.solvd.laba.db.model.Package;
import main.java.com.solvd.laba.db.model.Site;

public class PackageService implements IPackageService {
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

	public Package getPackage(int id) {
		try {
			Package pack = packageDao.get(id);
			pack.setSite(getPackageSite(packageDao.getSId(id)));
			pack.setMaterials(getMatQuantity(id));
			return pack;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Site getPackageSite(int id) {
		try {
			Site site = siteDao.get(id);
			City city = cityDao.get(site.getSiteId());
			city.setState(stateDao.get(city.getCityId()));
			site.setCity(city);
			return site;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<Material> getMatQuantity(int id) {
		try {
			ArrayList<Material> mats = new ArrayList<>();
			HashMap<Integer, Integer> map = packageDao.getIdQuantity(id);
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				Material mat = materialDao.get(entry.getKey());
				mat.setQuantity(entry.getValue());
				mats.add(mat);
			}
			return mats;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Package> getPackages() {
		try {
			ArrayList<Package> packs = packageDao.getAll();
			return packs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addPackage(Package pack) {
		try {
			packageDao.insert(pack);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updatePackage(Package pack) {
		try {
			packageDao.update(pack);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletePackage(Package pack) {
		try {
			packageDao.delete(pack);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
