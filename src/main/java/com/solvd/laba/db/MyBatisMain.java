package main.java.com.solvd.laba.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.java.com.solvd.laba.db.mapper.BuildingTypeMapper;
import main.java.com.solvd.laba.db.mapper.CityMapper;
import main.java.com.solvd.laba.db.mapper.ClientMapper;
import main.java.com.solvd.laba.db.mapper.EmployeeMapper;
import main.java.com.solvd.laba.db.mapper.JobMapper;
import main.java.com.solvd.laba.db.mapper.MaterialMapper;
import main.java.com.solvd.laba.db.mapper.PackageMapper;
import main.java.com.solvd.laba.db.mapper.PhaseMapper;
import main.java.com.solvd.laba.db.mapper.ProjectMapper;
import main.java.com.solvd.laba.db.mapper.SiteMapper;
import main.java.com.solvd.laba.db.mapper.StateMapper;
import main.java.com.solvd.laba.db.mapper.TeamMapper;
import main.java.com.solvd.laba.db.model.BuildingType;
import main.java.com.solvd.laba.db.model.City;
import main.java.com.solvd.laba.db.model.Client;
import main.java.com.solvd.laba.db.model.Employee;
import main.java.com.solvd.laba.db.model.Job;
import main.java.com.solvd.laba.db.model.Material;
import main.java.com.solvd.laba.db.model.Package;
import main.java.com.solvd.laba.db.model.Phase;
import main.java.com.solvd.laba.db.model.Project;
import main.java.com.solvd.laba.db.model.Site;
import main.java.com.solvd.laba.db.model.State;
import main.java.com.solvd.laba.db.model.Team;

public class MyBatisMain {
	private static final Logger LOGGER = LogManager.getLogger(MyBatisMain.class);

	public static void main(String[] args) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
				SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession()) {
			JobMapper jobMapper = session.getMapper(JobMapper.class);
			Job job = jobMapper.selectJobById(1);
			LOGGER.info(job);

			TeamMapper teamMapper = session.getMapper(TeamMapper.class);
			Team team = teamMapper.selectTeamById(1);
			LOGGER.info(team);

			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
			Employee emp = employeeMapper.selectEmployeeById(1);
			LOGGER.info(emp);

			StateMapper stateMapper = session.getMapper(StateMapper.class);
			State state = stateMapper.selectStateById(5);
			LOGGER.info(state);

			CityMapper cityMapper = session.getMapper(CityMapper.class);
			City city = cityMapper.selectCityById(3);
			LOGGER.info(city);

			BuildingTypeMapper buildingTypeMapper = session.getMapper(BuildingTypeMapper.class);
			BuildingType buildingType = buildingTypeMapper.selectBuildingTypeById(4);
			LOGGER.info(buildingType);

			PhaseMapper phaseMapper = session.getMapper(PhaseMapper.class);
			Phase phase = phaseMapper.selectPhaseById(4);
			LOGGER.info(phase);

			ClientMapper clientMapper = session.getMapper(ClientMapper.class);
			Client client = clientMapper.selectClientById(3);
			LOGGER.info(client);

			MaterialMapper materialMapper = session.getMapper(MaterialMapper.class);
			Material material = materialMapper.selectMaterialById(3);
			LOGGER.info(material);

			PackageMapper packageMapper = session.getMapper(PackageMapper.class);
			Package pack = packageMapper.selectPackageById(1);
			LOGGER.info(pack);

			SiteMapper siteMapper = session.getMapper(SiteMapper.class);
			Site site = siteMapper.selectSiteById(2);
			LOGGER.info(site);

			ProjectMapper projectMapper = session.getMapper(ProjectMapper.class);
			Project project = projectMapper.selectProjectById(1);
			LOGGER.info(project);
		}
	}

}
