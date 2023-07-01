package main.java.com.solvd.laba.db.decorator;

import main.java.com.solvd.laba.db.interfaces.ITeamModel;
import main.java.com.solvd.laba.db.model.Team;

public class TeamDecorator implements ITeamModel {
	protected Team team;

	public TeamDecorator(Team team) {
		this.team = team;
	}

	@Override
	public void showDetails() {
		this.team.showDetails();
	}
}
