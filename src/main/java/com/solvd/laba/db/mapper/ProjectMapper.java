package main.java.com.solvd.laba.db.mapper;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Project;

public interface ProjectMapper {

	Project selectProjectById(int id);

	ArrayList<Project> selectProjects();

	ArrayList<Project> selectProjectByBuildingTypeId(int buildingTypeId);

	void insertProject(Project project);

	void updateProject(Project project);

	void deleteProject(Project project);
}
