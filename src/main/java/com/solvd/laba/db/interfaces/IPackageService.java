package main.java.com.solvd.laba.db.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Package;

public interface IPackageService {

	Package getPackage(int id) throws SQLException;

	ArrayList<Package> getPackages() throws SQLException;

	void addPackage(Package pack) throws SQLException;

	void updatePackage(Package pack) throws SQLException;

	void deletePackage(Package pack) throws SQLException;
}
