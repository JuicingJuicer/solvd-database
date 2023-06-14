package main.java.com.solvd.laba.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConnectionUlti {
	private final static int SIZE = 5;
	private static int count = 0;
	private static CopyOnWriteArrayList<Connection> pool = new CopyOnWriteArrayList<>();
	private static CopyOnWriteArrayList<Connection> usedPool = new CopyOnWriteArrayList<>();
	private static Object lock = new Object();

	public static Connection getConnection() throws SQLException {
		if (pool.size() == 0) {
			if (count < SIZE) {
				count++;
				Connection c = createConnection();
				return c;
			} else { // if all connections are in use
				try {
					synchronized (lock) {
						lock.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Connection c = pool.remove(0);
		usedPool.add(c);
		return c;
	}

	public static Connection createConnection() throws SQLException {
		Properties props = new Properties();
		try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
			props.load(input);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		Connection c = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.user"),
				props.getProperty("db.password"));
		usedPool.add(c);
		return c;
	}

	public static void releaseConnection(Connection c) {
		synchronized (lock) {
			usedPool.remove(c);
			pool.add(c);
			lock.notify();
		}
	}
}
