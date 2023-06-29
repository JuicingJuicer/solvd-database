package main.java.com.solvd.laba.db.model;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {
	@JsonProperty("projectId")
	private int projectId;
	@JsonProperty("projectName")
	private String projectName;
	@JsonProperty("startDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private java.util.Date startDate;
	@JsonProperty("endDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private java.util.Date endDate;
	@JsonProperty("buildingType")
	private BuildingType buildingType;
	@JsonProperty("phase")
	private Phase phase;
	@JsonProperty("site")
	private Site site;
	@JsonProperty("team")
	private Team team;
	@JsonProperty("clients")
	private ArrayList<Client> clients;

	public Project() {
	}

	public Project(int projectId, String projectName, Date startDate, Date endDate) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
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

	public ArrayList<Client> getClients() {
		return clients;
	}

	@Override
	public String toString() {
		return "Project{projectId=" + projectId + ", projectName=" + projectName + ", startDate=" + startDate
				+ ", endDate=" + endDate + ",\nBuildingType=" + buildingType + ",\nPhase=" + phase + ",\nSite=" + site
				+ ",\nTeam=" + team + ",\nClient(s)" + clients + "}";
	}
}
