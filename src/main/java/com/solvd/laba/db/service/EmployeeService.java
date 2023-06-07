package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.dao.EmployeeDao;
import main.java.com.solvd.laba.db.dao.JobDao;
import main.java.com.solvd.laba.db.dao.TeamDao;
import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.model.Job;
import main.java.com.solvd.laba.db.model.Team;

public class EmployeeService {
	private EmployeeDao ed;
	private JobDao jd;
	private TeamDao td;

	public EmployeeService() {
		ed = new EmployeeDao();
		jd = new JobDao();
		td = new TeamDao();
	}

	public Employee getEmployee(int id) throws SQLException {
		Employee employee = ed.get(id);
		employee.setJob(getJob(id));
		employee.setTeams(getEmpTeams(id));
		return employee;
	}

	public Job getJob(int id) throws SQLException {
		return jd.get(ed.getJId(id));
	}

	public ArrayList<Team> getEmpTeams(int id) throws SQLException {
		ArrayList<Team> teams = new ArrayList<>();
		ArrayList<Integer> ids = ed.getTId(id);
		for (int tid : ids) {
			teams.add(td.get(tid));
		}
		return teams;
	}
}
