package main.java.com.solvd.laba.db.model;

import java.util.Date;

public class Project {
	private int projectId;
	private String projectName;
	private BuildingType buildingType;
	private Phase phase;
	private java.util.Date startDate;
	private java.util.Date endDate;
	private Site site;
	private Team team;

	public Project(int projectId, String projectName, BuildingType buildingType, Phase phase, Date startDate,
			Date endDate, Site site, Team team) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.buildingType = buildingType;
		this.phase = phase;
		this.startDate = startDate;
		this.endDate = endDate;
		this.site = site;
		this.team = team;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setBuildingType(BuildingType buildingType) {
		this.buildingType = buildingType;
	}

	public void setPhase(Phase phase) {
		this.phase = phase;
	}

	public void setStartDate(java.util.Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getProjectId() {
		return projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}

	public Phase getPhase() {
		return phase;
	}

	public java.util.Date getStartDate() {
		return startDate;
	}

	public java.util.Date getEndDate() {
		return endDate;
	}

	public Site getSite() {
		return site;
	}

	public Team getTeam() {
		return team;
	}

	@Override
	public String toString() {
		return "Project{projectName=" + projectName + ", buildingType=" + buildingType.getBuildingTypeId()
				+ ", phaseId=" + phase.getPhaseId() + ", startDate=" + startDate + ", endDate=" + endDate + ", siteId="
				+ site.getSiteId() + ", teamId=" + team.getTeamId() + "}\n";
	}
}
