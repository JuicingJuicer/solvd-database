package main.java.com.solvd.laba.db.interfaces;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Team;

public interface ITeamService {

	Team getTeam(int id);

	ArrayList<Team> getTeams();
}
