package main.java.com.solvd.laba.db.ulti;

import java.io.IOException;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import main.java.com.solvd.laba.db.factory.ServiceFactory;
import main.java.com.solvd.laba.db.interfaces.IMaterialService;
import main.java.com.solvd.laba.db.interfaces.ITeamService;
import main.java.com.solvd.laba.db.model.Material;
import main.java.com.solvd.laba.db.model.Package;
import main.java.com.solvd.laba.db.model.Team;

public class RandomUtil {
	private static Random random;

	public static int randomTime() {
		random = new Random();
		int years = 0;
		years = random.nextInt(3 - 1) + 1;
		return years;
	}

	public static Package randomPackage() {
		try {
			random = new Random();
			Package pack = new Package();
			IMaterialService materialService = ServiceFactory.createMaterialService();
			ArrayList<Material> materials = materialService.getMaterials();

			for (Material mat : materials) {
				mat.setQuantity(random.nextInt(700 - 250) + 250);
			}

			pack.setPurchaseDate(Date.from(java.time.LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
			pack.setStatus("Invoiced");
			pack.setMaterials(materials);
			return pack;
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static double randomTaxPrice(Package pack) {
		double price = 0;
		for (Material mat : pack.getMaterials()) {
			price += mat.getMaterialPrice() * mat.getQuantity();
		}
		price = price * (1.25 + Math.random());
		return price;
	}

	public static Team randomTeam() {
		random = new Random();
		Team team = new Team();
		ITeamService teamService = ServiceFactory.createTeamService();
		team = teamService.getTeam(random.nextInt(teamService.getTeams().size() - 1) + 1);
		return team;
	}
}
