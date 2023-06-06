package main.java.com.solvd.laba.db.model;

public class Phase {
	private int phaseId;
	private String phaseName;

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
		return "Phase{phaseId=" + phaseId + ", phaseName=" + phaseName + "}\n";
	}
}
