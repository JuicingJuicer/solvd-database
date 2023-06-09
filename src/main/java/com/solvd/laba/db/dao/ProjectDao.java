package main.java.com.solvd.laba.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.ConnectionUlti;
import main.java.com.solvd.laba.db.interfaces.IProjectDao;
import main.java.com.solvd.laba.db.model.Project;

public class ProjectDao extends Dao<Project> implements IProjectDao {

	protected String getStatement() {
		return "SELECT * FROM PROJECTS WHERE project_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM PROJECTS";
	}

	protected String insertStatement() {
		return "INSERT INTO PROJECTS (project_id, project_name, building_type, phase_id, start_date, end_date, site_id, team_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE PROJECTS SET project_id = ?, project_name = ?, building_type = ?, phase_id = ?, start_date = ?, end_date = ?, site_id = ?, team_id = ? WHERE project_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM PROJECTS WHERE project_id =?";
	}

	protected Project create(ResultSet rs) throws SQLException {
		return new Project(rs.getInt("project_id"), rs.getString("project_name"), rs.getDate("start_date"),
				rs.getDate("end_date"));
	}

	protected void addValue(Project project, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, project.getProjectId());
		if (b) {
			ps.setString(2, project.getProjectName());
			ps.setInt(3, project.getBuildingType().getBuildingTypeId());
			ps.setInt(4, project.getPhase().getPhaseId());
			ps.setDate(5, new java.sql.Date(project.getStartDate().getTime()));
			ps.setDate(5, new java.sql.Date(project.getEndDate().getTime()));
			ps.setInt(7, project.getSite().getSiteId());
			ps.setInt(8, project.getTeam().getTeamId());
		}
	}

	protected void addUpdatedValue(Project project, PreparedStatement ps) throws SQLException {
		ps.setInt(1, project.getProjectId());
		ps.setString(2, project.getProjectName());
		ps.setInt(3, project.getBuildingType().getBuildingTypeId());
		ps.setInt(4, project.getPhase().getPhaseId());
		ps.setDate(5, new java.sql.Date(project.getStartDate().getTime()));
		ps.setDate(5, new java.sql.Date(project.getEndDate().getTime()));
		ps.setInt(7, project.getSite().getSiteId());
		ps.setInt(8, project.getTeam().getTeamId());
		ps.setInt(9, project.getProjectId());
	}

	@Override
	public int getIdByCol(String col, int id) throws SQLException {
		try (Connection c = ConnectionUlti.getConnection()) {
			String query = "SELECT " + col + " FROM PROJECTS WHERE project_id=?";
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
//			ConnectionUlti.releaseConnection(c);
			if (rs.next()) {
				return rs.getInt(col);
			}
		}
		return 0;
	}

	@Override
	public ArrayList<Integer> getCId(int id) throws SQLException {
		ArrayList<Integer> cIds = new ArrayList<>();
		try (Connection c = ConnectionUlti.getConnection()) {
			PreparedStatement ps = c.prepareStatement("SELECT client_id FROM client_projects WHERE project_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cIds.add(rs.getInt("client_id"));
			}
		}
//		ConnectionUlti.releaseConnection(c);
		return cIds;
	}

}
