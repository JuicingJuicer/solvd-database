package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.State;

public interface IStateDao {
	State getStateByStateName(String name) throws SQLException;
}
