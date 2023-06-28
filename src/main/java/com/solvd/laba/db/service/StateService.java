package main.java.com.solvd.laba.db.service;

import java.sql.SQLException;

import main.java.com.solvd.laba.db.dao.StateDao;
import main.java.com.solvd.laba.db.interfaces.IStateService;
import main.java.com.solvd.laba.db.model.State;

public class StateService implements IStateService {
	StateDao stateDao;

	public StateService() {
		stateDao = new StateDao();
	}

	@Override
	public State getState(int id) {
		try {
			State state = stateDao.get(id);
			return state;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public State getStateByName(String name) {
		try {
			State state = stateDao.getStateByStateName(name);
			return state;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
