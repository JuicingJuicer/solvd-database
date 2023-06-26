package main.java.com.solvd.laba.db.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.model.Package;

public interface IPackageService {

	Package getPackage(int id) throws SQLException, IOException;

	ArrayList<Package> getPackages() throws SQLException, IOException;

	void addPackage(Package pack) throws SQLException, IOException;

	void updatePackage(Package pack) throws SQLException, IOException;

	void deletePackage(Package pack) throws SQLException, IOException;
}
