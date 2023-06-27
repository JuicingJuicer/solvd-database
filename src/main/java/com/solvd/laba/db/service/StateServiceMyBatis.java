package main.java.com.solvd.laba.db.service;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import main.java.com.solvd.laba.db.interfaces.IStateService;
import main.java.com.solvd.laba.db.mapper.StateMapper;
import main.java.com.solvd.laba.db.model.State;
import main.java.com.solvd.laba.db.ulti.SessionUtil;

public class StateServiceMyBatis implements IStateService {
	private StateMapper stateMapper;

	@Override
	public State getState(int id) throws SQLException, IOException {
		try (SqlSession session = SessionUtil.openSession()) {
			stateMapper = session.getMapper(StateMapper.class);
			State state = stateMapper.selectStateById(id);
			return state;
		}
	}

	@Override
	public State getStateByName(String name) throws SQLException, IOException {
		try (SqlSession session = SessionUtil.openSession()) {
			stateMapper = session.getMapper(StateMapper.class);
			State state = stateMapper.selectStateByStateName(name);
			return state;
		}
	}
}
