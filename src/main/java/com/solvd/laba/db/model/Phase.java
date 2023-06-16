package main.java.com.solvd.laba.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Phase {
	@JsonProperty("phaseId")
	private int phaseId;
	@JsonProperty("phaseName")
	private String phaseName;

	public Phase() {
	}

	public Phase(int phaseId, String phaseName) {
		this.phaseId = phaseId;
		this.phaseName = phaseName;
	}

	public void setPhaseId(int phaseId) {
		this.phaseId = phaseId;
	}

	public void setPhaseName(String phaseName) {
		this.phaseName = phaseName;
	}

	public int getPhaseId() {
		return phaseId;
	}

	public String getPhaseName() {
		return phaseName;
	}

	@Override
	public String toString() {
		return "Phase{phaseId=" + phaseId + ", phaseName=" + phaseName + "}";
	}
}
