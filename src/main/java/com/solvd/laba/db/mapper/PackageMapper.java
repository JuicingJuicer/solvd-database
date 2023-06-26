package main.java.com.solvd.laba.db.mapper;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Package;

public interface PackageMapper {

	Package selectPackageById(int id);

	ArrayList<Package> selectPackages();

	void insertPackage(Package pack);

	void updatePackage(Package pack);

	void deletePackage(Package pack);
}
