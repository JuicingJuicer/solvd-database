package main.java.com.solvd.laba.db.service;

import org.apache.ibatis.session.SqlSession;

import main.java.com.solvd.laba.db.interfaces.IStateService;
import main.java.com.solvd.laba.db.mapper.StateMapper;
import main.java.com.solvd.laba.db.model.State;
import main.java.com.solvd.laba.db.ulti.SessionUtil;

public class StateServiceMyBatis implements IStateService {
	private StateMapper stateMapper;

	@Override
	public State getState(int id) {
		try (SqlSession session = SessionUtil.openSession()) {
			stateMapper = session.getMapper(StateMapper.class);
			State state = stateMapper.selectStateById(id);
			return state;
		}
	}

	@Override
	public State getStateByName(String name) {
		try (SqlSession session = SessionUtil.openSession()) {
			stateMapper = session.getMapper(StateMapper.class);
			State state = stateMapper.selectStateByStateName(name);
			return state;
		}
	}
}
