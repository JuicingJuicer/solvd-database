package main.java.com.solvd.laba.db.model;

public class EmpTeam {
	private int empTeamId;
	private Employee emp;
	private Team team;

	public EmpTeam(int empTeamId, Employee empId, Team team) {
		this.setEmpTeamId(empTeamId);
		this.setEmp(empId);
		this.setTeam(team);
	}

	public void setEmpTeamId(int empTeamId) {
		this.empTeamId = empTeamId;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getEmpTeamId() {
		return empTeamId;
	}

	public Employee getEmp() {
		return emp;
	}

	public Team getTeam() {
		return team;
	}

	@Override
	public String toString() {
		return "EmpTeam{empTeamId=" + empTeamId + ", empId=" + emp.getEmpId() + ", teamId=" + team.getTeamId() + "}\n";
	}
}
