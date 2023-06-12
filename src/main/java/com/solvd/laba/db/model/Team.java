package main.java.com.solvd.laba.db.model;

public class Team {
	private int teamId;
	private String teamName;
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
