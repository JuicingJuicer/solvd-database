package main.java.com.solvd.laba.db.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Site;

public interface ISiteService {

	Site getSite(int id) throws SQLException, IOException;

	ArrayList<Site> getSites() throws SQLException, IOException;

	ArrayList<Site> getSiteByCityId(int cityId) throws SQLException, IOException;

	void addSite(Site site) throws SQLException, IOException;

	void updateSite(Site site) throws SQLException, IOException;

	void deleteSite(Site site) throws SQLException, IOException;
}
