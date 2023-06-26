package main.java.com.solvd.laba.db.service;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import main.java.com.solvd.laba.db.interfaces.IPackageService;
import main.java.com.solvd.laba.db.mapper.PackageMapper;
import main.java.com.solvd.laba.db.model.Package;
import main.java.com.solvd.laba.db.ulti.SessionUtil;

public class PackageServiceMyBatis implements IPackageService {
	private PackageMapper packageMapper;

	public PackageServiceMyBatis() throws IOException {
	}

	@Override
	public Package getPackage(int id) throws IOException {
		try (SqlSession session = SessionUtil.openSession()) {
			packageMapper = session.getMapper(PackageMapper.class);
			Package pack = packageMapper.selectPackageById(id);
			return pack;
		}
	}

	@Override
	public ArrayList<Package> getPackages() throws IOException {
		try (SqlSession session = SessionUtil.openSession()) {
			packageMapper = session.getMapper(PackageMapper.class);
			ArrayList<Package> packs = packageMapper.selectPackages();
			return packs;
		}
	}

	@Override
	public void addPackage(Package pack) throws IOException {
		try (SqlSession session = SessionUtil.openSession()) {
			packageMapper = session.getMapper(PackageMapper.class);
			packageMapper.insertPackage(pack);
			session.commit();
		}
	}

	@Override
	public void updatePackage(Package pack) throws IOException {
		try (SqlSession session = SessionUtil.openSession()) {
			packageMapper = session.getMapper(PackageMapper.class);
			packageMapper.updatePackage(pack);
			session.commit();
		}
	}

	@Override
	public void deletePackage(Package pack) throws IOException {
		try (SqlSession session = SessionUtil.openSession()) {
			packageMapper = session.getMapper(PackageMapper.class);
			packageMapper.deletePackage(pack);
			session.commit();
		}
	}
}
