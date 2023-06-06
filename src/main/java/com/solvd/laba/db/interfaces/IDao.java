package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDao<T> {
	T get(int id) throws SQLException;

	ArrayList<T> getAll() throws SQLException;

	void insert(T t) throws SQLException;

	void update(T t) throws SQLException;

	void delete(T t) throws SQLException;

//	ArrayList<String> getCol() throws SQLException;
}
