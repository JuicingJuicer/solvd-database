package main.java.com.solvd.laba.db.interfaces;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Project;

public interface IProjectService {

	Project getProject(int id);

	ArrayList<Project> getProjects();

	ArrayList<Project> getProjectByBuildingTypeId(int buildingTypeId);

	void addProject(Project project);

	void updateProject(Project project);

	void deleteProject(Project project);
}
