package main.java.com.solvd.laba.db.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import main.java.com.solvd.laba.db.interfaces.ITeamService;
import main.java.com.solvd.laba.db.mapper.TeamMapper;
import main.java.com.solvd.laba.db.model.Team;
import main.java.com.solvd.laba.db.ulti.SessionUtil;

public class TeamServiceMyBatis implements ITeamService {
	private TeamMapper teamMapper;

	public TeamServiceMyBatis() {
	}

	@Override
	public Team getTeam(int id) {
		try (SqlSession session = SessionUtil.openSession()) {
			teamMapper = session.getMapper(TeamMapper.class);
			Team team = teamMapper.selectTeamById(id);
			return team;
		}
	}

	@Override
	public ArrayList<Team> getTeams() {
		try (SqlSession session = SessionUtil.openSession()) {
			teamMapper = session.getMapper(TeamMapper.class);
			ArrayList<Team> teams = teamMapper.selectTeams();
			return teams;
		}
	}

}
