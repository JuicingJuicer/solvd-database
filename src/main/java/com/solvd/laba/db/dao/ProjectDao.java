package main.java.com.solvd.laba.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.com.solvd.laba.db.interfaces.IProjectDao;
import main.java.com.solvd.laba.db.model.Project;
import main.java.com.solvd.laba.db.ulti.ConnectionUtil;

public class ProjectDao extends Dao<Project> implements IProjectDao {

	protected String getStatement() {
		return "SELECT * FROM projects WHERE project_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM projects";
	}

	protected String insertStatement() {
		return "INSERT INTO projects (project_id, project_name, building_type, phase_id, start_date, end_date, site_id, team_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE projects SET project_id = ?, project_name = ?, building_type = ?, phase_id = ?, start_date = ?, end_date = ?, site_id = ?, team_id = ? WHERE project_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM projects WHERE project_id =?";
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
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionUtil.getConnection();
			String query = "SELECT " + col + " FROM projects WHERE project_id=?";
			ps = c.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(col);
			}
		} finally {
			if (c != null) {
				ConnectionUtil.releaseConnection(c);
			}
			if (ps != null) {
				ps.close();
			}
		}
		return 0;
	}

	@Override
	public ArrayList<Integer> getCId(int id) throws SQLException {
		ArrayList<Integer> cIds = new ArrayList<>();
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionUtil.getConnection();
			ps = c.prepareStatement("SELECT client_id FROM client_projects WHERE project_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cIds.add(rs.getInt("client_id"));
			}
		} finally {
			if (c != null) {
				ConnectionUtil.releaseConnection(c);
			}
			if (ps != null) {
				ps.close();
			}
		}
		return cIds;
	}

}
