package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Site;

public interface ISiteService {

	Site getSite(int id) throws SQLException;

	ArrayList<Site> getSites() throws SQLException;

	ArrayList<Site> getSiteByCityId(int cityId) throws SQLException;

	void addSite(Site site) throws SQLException;

	void updateSite(Site site) throws SQLException;

	void deleteSite(Site site) throws SQLException;
}
