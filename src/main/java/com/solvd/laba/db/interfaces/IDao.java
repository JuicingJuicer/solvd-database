package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDao<T> {
	T get(long id) throws SQLException;

	ArrayList<String> getCol() throws SQLException;

	ArrayList<T> getAll() throws SQLException;

	void insert(T t);

	void update(T t, String[] p);

	void delete(T t) throws SQLException;
}
