package main.java.com.solvd.laba.db;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.laba.db.bl.BusinessLogicOperation;
import main.java.com.solvd.laba.db.ulti.RandomUtil;

public class Main {
	/* Arguments 
	 -Demployee_type=mybatis 
	 -Dcity_type=mybatis 
	 -Dpackage_type=mybatis
	 -Dproject_type=mybatis 
	 -Dsite_type=mybatis 
	 -Dbuilding_type=mybatis
	 -Dstate_type=mybatis 
	 -Dmaterial_type=mybatis 
	 -Dphase_type=mybatis
	 -Dteam_type=mybatis
	 */
	public static void main(String[] args) {
		BusinessLogicOperation bl = new BusinessLogicOperation();
		bl.clientProjectOperation();
	}
}
