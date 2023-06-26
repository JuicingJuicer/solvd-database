package main.java.com.solvd.laba.db.service;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import main.java.com.solvd.laba.db.interfaces.ISiteService;
import main.java.com.solvd.laba.db.mapper.SiteMapper;
import main.java.com.solvd.laba.db.model.Site;
import main.java.com.solvd.laba.db.ulti.SessionUtil;

public class SiteServiceMyBatis implements ISiteService {
	private SiteMapper siteMapper;

	public SiteServiceMyBatis() {
	}

	@Override
	public Site getSite(int id) throws IOException {
		try (SqlSession session = SessionUtil.openSession()) {
			siteMapper = session.getMapper(SiteMapper.class);
			Site site = siteMapper.selectSiteById(id);
			return site;
		}
	}

	@Override
	public ArrayList<Site> getSites() throws IOException {
		try (SqlSession session = SessionUtil.openSession()) {
			siteMapper = session.getMapper(SiteMapper.class);
			ArrayList<Site> sites = siteMapper.selectSites();
			return sites;
		}
	}

	@Override
	public ArrayList<Site> getSiteByCityId(int cityId) throws IOException {
		try (SqlSession session = SessionUtil.openSession()) {
			siteMapper = session.getMapper(SiteMapper.class);
			ArrayList<Site> sites = siteMapper.selectSiteByCityId(cityId);
			return sites;
		}
	}

	@Override
	public void addSite(Site site) throws IOException {
		try (SqlSession session = SessionUtil.openSession()) {
			siteMapper = session.getMapper(SiteMapper.class);
			siteMapper.insertSite(site);
			session.commit();
		}
	}

	@Override
	public void updateSite(Site site) throws IOException {
		try (SqlSession session = SessionUtil.openSession()) {
			siteMapper = session.getMapper(SiteMapper.class);
			siteMapper.updateSite(site);
			session.commit();
		}
	}

	@Override
	public void deleteSite(Site site) throws IOException {
		try (SqlSession session = SessionUtil.openSession()) {
			siteMapper = session.getMapper(SiteMapper.class);
			siteMapper.deleteSite(site);
			session.commit();
		}
	}
}
