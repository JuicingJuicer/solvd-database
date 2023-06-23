package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Project;

public interface IProjectService {

	Project getProject(int id) throws SQLException;

	ArrayList<Project> getProjects() throws SQLException;

	ArrayList<Project> getProjectByBuildingTypeId(int buildingTypeId) throws SQLException;

	void addProject(Project project) throws SQLException;

	void updateProject(Project project) throws SQLException;

	void deleteProject(Project project) throws SQLException;
}
