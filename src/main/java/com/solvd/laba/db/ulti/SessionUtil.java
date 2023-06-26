package main.java.com.solvd.laba.db.ulti;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {
	public static SqlSession openSession() throws IOException {
		InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession();
		return session;
	}
}
