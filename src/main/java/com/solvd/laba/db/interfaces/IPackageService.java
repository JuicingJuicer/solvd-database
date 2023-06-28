package main.java.com.solvd.laba.db.interfaces;

import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Package;

public interface IPackageService {

	Package getPackage(int id);

	ArrayList<Package> getPackages();

	void addPackage(Package pack);

	void updatePackage(Package pack);

	void deletePackage(Package pack);
}
