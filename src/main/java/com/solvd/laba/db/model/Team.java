package main.java.com.solvd.laba.db.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "team")
@XmlAccessorType(XmlAccessType.FIELD)
public class Team {
	@XmlElement(name = "teamId")
	@JsonProperty("teamId")
	private int teamId;
	@XmlElement(name = "teamName")
	@JsonProperty("teamName")
	private String teamName;
	@XmlElement(name = "teamDetails")
	@JsonProperty("teamDetails")
	private String teamDetails;

	public Team() {
	}

	public Team(int teamId, String teamName, String teamDetails) {
		this.setTeamId(teamId);
		this.setTeamName(teamName);
		this.setTeamDetails(teamDetails);
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setTeamDetails(String teamDetails) {
		this.teamDetails = teamDetails;
	}

	public int getTeamId() {
		return teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public String getTeamDetails() {
		return teamDetails;
	}

	@Override
	public String toString() {
		return "Team{teamId=" + teamId + ", teamName=" + teamName + ", teamDetails=" + teamDetails + "}";
	}
}
