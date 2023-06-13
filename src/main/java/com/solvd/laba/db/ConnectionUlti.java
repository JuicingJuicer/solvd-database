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
	private final static int SIZE = 5;
	private static CopyOnWriteArrayList<Connection> pool = new CopyOnWriteArrayList<>();
	private static CopyOnWriteArrayList<Connection> usedPool = new CopyOnWriteArrayList<>();
	private static boolean isInitialized = false;
	private static Object lock = new Object();

	public static Connection getConnection() throws SQLException {
		// gets new connection
		if (!isInitialized) {
			Properties props = new Properties();
			try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
				props.load(input);
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			isInitialized = true;
			Connection c = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.user"),
					props.getProperty("db.password"));
			return c;
		} else { // gets connection from pool
			Connection c = pool.remove(0);
			usedPool.add(c);
			return c;
		}
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

	public static void releaseConnection(Connection c) {
		synchronized (lock) {
			usedPool.remove(c);
			pool.add(c);
			lock.notify();
		}
	}
}
