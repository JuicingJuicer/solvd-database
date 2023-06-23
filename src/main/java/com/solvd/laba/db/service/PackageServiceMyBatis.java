package main.java.com.solvd.laba.db.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import main.java.com.solvd.laba.db.interfaces.IPackageService;
import main.java.com.solvd.laba.db.mapper.PackageMapper;
import main.java.com.solvd.laba.db.model.Package;

public class PackageServiceMyBatis implements IPackageService {
	private SqlSession session;
	private PackageMapper packageMapper;

	public PackageServiceMyBatis() throws IOException {
		InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
		session = new SqlSessionFactoryBuilder().build(stream).openSession();
		packageMapper = session.getMapper(PackageMapper.class);
	}

	@Override
	public Package getPackage(int id) {
		Package pack = packageMapper.selectPackageById(id);
		return pack;
	}

	@Override
	public ArrayList<Package> getPackages() throws SQLException {
		ArrayList<Package> packs = new ArrayList<>();
		packs = packageMapper.selectPackages();
		return packs;
	}

	@Override
	public void addPackage(Package pack) {
		packageMapper.insertPackage(pack);
		session.commit();
	}

	@Override
	public void updatePackage(Package pack) {
		packageMapper.updatePackage(pack);
		session.commit();
	}

	@Override
	public void deletePackage(Package pack) {
		packageMapper.deletePackage(pack);
		session.commit();
	}
}
