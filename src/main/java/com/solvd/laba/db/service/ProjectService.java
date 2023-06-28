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
import main.java.com.solvd.laba.db.interfaces.IProjectService;
import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.model.Client;
import main.java.com.solvd.laba.db.model.Phase;
import main.java.com.solvd.laba.db.model.Project;
import main.java.com.solvd.laba.db.model.Site;

public class ProjectService implements IProjectService {
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

	public Project getProject(int id) {
		try {
			Project project = projectDao.get(id);
			project.setBuildingType(buildingTypeDao.get(projectDao.getIdByCol("building_type", id)));
			project.setPhase(phaseDao.get(projectDao.getIdByCol("phase_id", id)));
			project.setSite(getProjectSite(projectDao.getIdByCol("site_id", id)));
			project.setTeam(teamDao.get(projectDao.getIdByCol("team_id", id)));
			project.setClients(getProjectClients(id));
			return project;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Site getProjectSite(int id) {
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

	public ArrayList<Client> getProjectClients(int id) {
		try {
			ArrayList<Client> clients = new ArrayList<>();
			ArrayList<Integer> ids = projectDao.getCId(id);
			for (int cid : ids) {
				clients.add(clientDao.get(cid));
			}
			return clients;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Project> getProjects() {
		try {
			ArrayList<Project> projects = projectDao.getAll();
			return projects;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Project> getProjectByBuildingTypeId(int buildingTypeId) {
		try {
			ArrayList<Project> projects = projectDao.getProjectByBuildingTypeId(buildingTypeId);
			return projects;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addProject(Project project) {
		try {
			projectDao.insert(project);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProject(Project project) {
		try {
			projectDao.update(project);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProject(Project project) {
		try {
			projectDao.delete(project);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Phase> getPhases() {
		try {
			ArrayList<Phase> phases = phaseDao.getAll();
			return phases;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
