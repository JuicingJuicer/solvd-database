package main.java.com.solvd.laba.db.interfaces;

import java.io.IOException;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.State;

public interface IStateService {

	State getState(int id) throws SQLException, IOException;

	State getStateByName(String name) throws SQLException, IOException;
}
