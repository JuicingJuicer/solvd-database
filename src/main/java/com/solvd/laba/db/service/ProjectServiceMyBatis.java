package main.java.com.solvd.laba.db.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import main.java.com.solvd.laba.db.interfaces.IProjectService;
import main.java.com.solvd.laba.db.mapper.ProjectMapper;
import main.java.com.solvd.laba.db.model.Project;
import main.java.com.solvd.laba.db.ulti.SessionUtil;

public class ProjectServiceMyBatis implements IProjectService {
	private ProjectMapper projectMapper;

	public ProjectServiceMyBatis() {
	}

	@Override
	public Project getProject(int id) {
		try (SqlSession session = SessionUtil.openSession()) {
			projectMapper = session.getMapper(ProjectMapper.class);
			Project project = projectMapper.selectProjectById(id);
			return project;
		}
	}

	@Override
	public ArrayList<Project> getProjects() {
		try (SqlSession session = SessionUtil.openSession()) {
			projectMapper = session.getMapper(ProjectMapper.class);
			ArrayList<Project> projects = projectMapper.selectProjects();
			return projects;
		}
	}

	@Override
	public ArrayList<Project> getProjectByBuildingTypeId(int buildingTypeId) {
		try (SqlSession session = SessionUtil.openSession()) {
			projectMapper = session.getMapper(ProjectMapper.class);
			ArrayList<Project> projects = projectMapper.selectProjectByBuildingTypeId(buildingTypeId);
			return projects;
		}
	}

	@Override
	public void addProject(Project project) {
		try (SqlSession session = SessionUtil.openSession()) {
			projectMapper = session.getMapper(ProjectMapper.class);
			projectMapper.insertProject(project);
			session.commit();
		}
	}

	@Override
	public void updateProject(Project project) {
		try (SqlSession session = SessionUtil.openSession()) {
			projectMapper = session.getMapper(ProjectMapper.class);
			projectMapper.updateProject(project);
			session.commit();
		}
	}

	@Override
	public void deleteProject(Project project) {
		try (SqlSession session = SessionUtil.openSession()) {
			projectMapper = session.getMapper(ProjectMapper.class);
			projectMapper.deleteProject(project);
			session.commit();
		}
	}
}
