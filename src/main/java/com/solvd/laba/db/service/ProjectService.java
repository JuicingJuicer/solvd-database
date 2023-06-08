package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.dao.BuildingTypeDao;
import main.java.com.solvd.laba.db.dao.CityDao;
import main.java.com.solvd.laba.db.dao.ClientDao;
import main.java.com.solvd.laba.db.dao.PhaseDao;
import main.java.com.solvd.laba.db.dao.ProjectDao;
import main.java.com.solvd.laba.db.dao.SiteDao;
import main.java.com.solvd.laba.db.dao.StateDao;
import main.java.com.solvd.laba.db.dao.TeamDao;
import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.model.Client;
import main.java.com.solvd.laba.db.model.Project;
import main.java.com.solvd.laba.db.model.Site;

public class ProjectService {
	ProjectDao projectDao;
	BuildingTypeDao buildingTypeDao;
	PhaseDao phaseDao;
	TeamDao teamDao;
	SiteDao siteDao;
	ClientDao clientDao;
	CityDao cityDao;
	StateDao stateDao;

	public ProjectService() {
		projectDao = new ProjectDao();
		buildingTypeDao = new BuildingTypeDao();
		phaseDao = new PhaseDao();
		teamDao = new TeamDao();
		siteDao = new SiteDao();
		clientDao = new ClientDao();
		cityDao = new CityDao();
		stateDao = new StateDao();
	}

	public Project getProject(int id) throws SQLException {
		Project project = projectDao.get(id);
		project.setBuildingType(buildingTypeDao.get(projectDao.getIdByCol("building_type", id)));
		project.setPhase(phaseDao.get(projectDao.getIdByCol("phase_id", id)));
		project.setSite(getProjectSite(projectDao.getIdByCol("site_id", id)));
		project.setTeam(teamDao.get(projectDao.getIdByCol("team_id", id)));
		project.setClients(getProjectClients(id));
		return project;
	}

	// Q: Can service classes use other service class methods
	public Site getProjectSite(int id) throws SQLException {
		Site site = siteDao.get(id);
		City city = cityDao.get(site.getSiteId());
		city.setState(stateDao.get(city.getCityId()));
		site.setCity(city);
		return site;
	}

	public ArrayList<Client> getProjectClients(int id) throws SQLException {
		ArrayList<Client> clients = new ArrayList<>();
		ArrayList<Integer> ids = projectDao.getCId(id);
		for (int cid : ids) {
			clients.add(clientDao.get(cid));
		}
		return clients;
	}
}
