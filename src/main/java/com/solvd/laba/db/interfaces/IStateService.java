package main.java.com.solvd.laba.db.interfaces;

import main.java.com.solvd.laba.db.model.State;

public interface IStateService {

	State getState(int id);

	State getStateByName(String name);
}
