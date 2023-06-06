package main.java.com.solvd.laba.db.model;

public class EmpTeam {
	private int empTeamId;
	private int empId;
	private int teamId;

	public EmpTeam(int empTeamId, int empId, int teamId) {
		this.setEmpTeamId(empTeamId);
		this.setEmpId(empId);
		this.setTeamId(teamId);
	}

	public void setEmpTeamId(int empTeamId) {
		this.empTeamId = empTeamId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getEmpTeamId() {
		return empTeamId;
	}

	public int getEmpId() {
		return empId;
	}

	public int getTeamId() {
		return teamId;
	}

	@Override
	public String toString() {
		return "EmpTeam{empTeamId=" + empTeamId + ", empId=" + empId + ", teamId=" + teamId + "}\n";
	}
}
