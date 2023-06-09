package main.java.com.solvd.laba.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConnectionUlti {
	private final static int SIZE = 15;
	private static CopyOnWriteArrayList<Connection> pool = new CopyOnWriteArrayList<>();
	private static CopyOnWriteArrayList<Connection> usedPool = new CopyOnWriteArrayList<>();
	private static Object lock = new Object();

	static {
		try {
			populatePool();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		Properties props = new Properties();
		try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
			props.load(input);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		Connection c = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.user"),
				props.getProperty("db.password"));
		return c;
	}

//	public static Connection getConnection() {
//		if (pool.size() == 0) {
//			try {
//				synchronized (lock) {
//					lock.wait();
//				}
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		Connection c = pool.remove(0);
//		usedPool.add(c);
//		return c;
//	}

	public static void populatePool() throws SQLException {
		Properties props = new Properties();
		try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
			props.load(input);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		for (int i = 0; i < SIZE; i++) {
			Connection c = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.user"),
					props.getProperty("db.password"));
			pool.add(c);
		}
	}

	public static void releaseConnection(Connection c) {
		synchronized (lock) {
			usedPool.remove(c);
			pool.add(c);
			lock.notify();
		}
	}
}
