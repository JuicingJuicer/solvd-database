package main.java.com.solvd.laba.db.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import main.java.com.solvd.laba.db.interfaces.ISiteService;
import main.java.com.solvd.laba.db.mapper.SiteMapper;
import main.java.com.solvd.laba.db.model.Site;

public class SiteServiceMyBatis implements ISiteService {
	private SqlSession session;
	private SiteMapper siteMapper;

	public SiteServiceMyBatis() throws IOException {
		InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
		session = new SqlSessionFactoryBuilder().build(stream).openSession();
		siteMapper = session.getMapper(SiteMapper.class);
	}

	@Override
	public Site getSite(int id) throws SQLException {
		Site site = siteMapper.selectSiteById(id);
		return site;
	}

	@Override
	public ArrayList<Site> getSites() throws SQLException {
		ArrayList<Site> sites = new ArrayList<>();
		sites = siteMapper.selectSites();
		return sites;
	}

	@Override
	public ArrayList<Site> getSiteByCityId(int cityId) throws SQLException {
		ArrayList<Site> sites = new ArrayList<>();
		sites = siteMapper.selectSiteByCityId(cityId);
		return sites;
	}

	@Override
	public void addSite(Site site) throws SQLException {
		siteMapper.insertSite(site);
		session.commit();
	}

	@Override
	public void updateSite(Site site) throws SQLException {
		siteMapper.updateSite(site);
		session.commit();
	}

	@Override
	public void deleteSite(Site site) throws SQLException {
		siteMapper.deleteSite(site);
		session.commit();
	}
}
