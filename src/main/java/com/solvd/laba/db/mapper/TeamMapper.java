package main.java.com.solvd.laba.db.mapper;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Team;

public interface TeamMapper {

	Team selectTeamById(int id);

	ArrayList<Team> selectTeams();
}
