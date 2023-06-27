package main.java.com.solvd.laba.db;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.laba.db.bl.BusinessLogicOperation;

public class BlMain {
	private static final Logger LOGGER = LogManager.getLogger(BlMain.class);

	public static void main(String[] args) throws SQLException, IOException, ParseException {
		BusinessLogicOperation bl = new BusinessLogicOperation();
		bl.task();
	}

}
