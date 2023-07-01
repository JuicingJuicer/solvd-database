package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.dao.PhaseDao;
import main.java.com.solvd.laba.db.interfaces.IPhaseService;
import main.java.com.solvd.laba.db.model.Phase;

public class PhaseService implements IPhaseService {
	PhaseDao phaseDao;

	public PhaseService() {
		phaseDao = new PhaseDao();
	}

	@Override
	public Phase getPhase(int id) {
		try {
			Phase phase = phaseDao.get(id);
			return phase;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ArrayList<Phase> getPhases() {
		try {
			ArrayList<Phase> phases = phaseDao.getAll();
			return phases;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
