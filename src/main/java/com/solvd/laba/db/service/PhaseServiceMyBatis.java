package main.java.com.solvd.laba.db.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import main.java.com.solvd.laba.db.interfaces.IPhaseService;
import main.java.com.solvd.laba.db.mapper.PhaseMapper;
import main.java.com.solvd.laba.db.model.Phase;
import main.java.com.solvd.laba.db.ulti.SessionUtil;

public class PhaseServiceMyBatis implements IPhaseService {
	private PhaseMapper phaseMapper;

	public PhaseServiceMyBatis() {
	}

	@Override
	public Phase getPhase(int id) {
		try (SqlSession session = SessionUtil.openSession()) {
			phaseMapper = session.getMapper(PhaseMapper.class);
			Phase phase = phaseMapper.selectPhaseById(id);
			return phase;
		}
	}

	@Override
	public ArrayList<Phase> getPhases() {
		try (SqlSession session = SessionUtil.openSession()) {
			phaseMapper = session.getMapper(PhaseMapper.class);
			ArrayList<Phase> phases = phaseMapper.selectPhases();
			return phases;
		}
	}

}
