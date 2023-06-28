package main.java.com.solvd.laba.db.interfaces;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Site;

public interface ISiteService {

	Site getSite(int id);

	ArrayList<Site> getSites();

	ArrayList<Site> getSiteByCityId(int cityId);

	void addSite(Site site);

	void updateSite(Site site);

	void deleteSite(Site site);
}
