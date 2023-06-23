package main.java.com.solvd.laba.db.mapper;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Site;

public interface SiteMapper {

	Site selectSiteById(int id);

	ArrayList<Site> selectSites();

	ArrayList<Site> selectSiteByCityId(int cityId);

	void insertSite(Site site);

	void updateSite(Site site);

	void deleteSite(Site site);
}
