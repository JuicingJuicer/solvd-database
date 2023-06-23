package main.java.com.solvd.laba.db.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import main.java.com.solvd.laba.db.interfaces.IProjectService;
import main.java.com.solvd.laba.db.mapper.ProjectMapper;
import main.java.com.solvd.laba.db.model.Project;

public class ProjectServiceMyBatis implements IProjectService {
	private SqlSession session;
	private ProjectMapper projectMapper;

	public ProjectServiceMyBatis() throws IOException {
		InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
		session = new SqlSessionFactoryBuilder().build(stream).openSession();
		projectMapper = session.getMapper(ProjectMapper.class);
	}

	@Override
	public Project getProject(int id) throws SQLException {
		Project project = projectMapper.selectProjectById(id);
		return project;
	}

	@Override
	public ArrayList<Project> getProjects() throws SQLException {
		ArrayList<Project> projects = new ArrayList<>();
		projects = projectMapper.selectProjects();
		return projects;
	}

	@Override
	public ArrayList<Project> getProjectByBuildingTypeId(int buildingTypeId) throws SQLException {
		ArrayList<Project> projects = new ArrayList<>();
		projects = projectMapper.selectProjectByBuildingTypeId(buildingTypeId);
		return projects;
	}

	@Override
	public void addProject(Project project) throws SQLException {
		projectMapper.insertProject(project);
		session.commit();
	}

	@Override
	public void updateProject(Project project) throws SQLException {
		projectMapper.updateProject(project);
		session.commit();
	}

	@Override
	public void deleteProject(Project project) throws SQLException {
		projectMapper.deleteProject(project);
		session.commit();
	}
}
