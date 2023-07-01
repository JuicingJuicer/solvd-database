package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.dao.TeamDao;
import main.java.com.solvd.laba.db.interfaces.ITeamService;
import main.java.com.solvd.laba.db.model.Team;

public class TeamService implements ITeamService {
	TeamDao teamDao;

	@Override
	public Team getTeam(int id) {
		try {
			Team team = teamDao.get(id);
			return team;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Team> getTeams() {
		try {
			ArrayList<Team> teams = teamDao.getAll();
			return teams;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
