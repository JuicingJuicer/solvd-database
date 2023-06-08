package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;
import java.util.HashMap;

public interface IPackageDao {
	int getSId(int id) throws SQLException;

	HashMap<Integer, Integer> getIdQuantity(int id) throws SQLException;
}
