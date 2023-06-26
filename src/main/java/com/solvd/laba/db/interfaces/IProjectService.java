package main.java.com.solvd.laba.db.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Project;

public interface IProjectService {

	Project getProject(int id) throws SQLException, IOException;

	ArrayList<Project> getProjects() throws SQLException, IOException;

	ArrayList<Project> getProjectByBuildingTypeId(int buildingTypeId) throws SQLException, IOException;

	void addProject(Project project) throws SQLException, IOException;

	void updateProject(Project project) throws SQLException, IOException;

	void deleteProject(Project project) throws SQLException, IOException;
}
