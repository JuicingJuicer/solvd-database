package main.java.com.solvd.laba.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.Project;

public class ProjectDao extends Dao<Project> {
	BuildingTypeDao btd = new BuildingTypeDao();
	PhaseDao pd = new PhaseDao();
	SiteDao sd = new SiteDao();
	TeamDao td = new TeamDao();

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
		return new Project(rs.getInt("project_id"), rs.getString("project_name"), btd.get(rs.getInt("building_type")),
				pd.get(rs.getInt("phase_id")), rs.getDate("start_date"), rs.getDate("end_date"),
				sd.get(rs.getInt("site_id")), td.get(rs.getInt("team_id")));
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

	public static void main(String[] args) throws SQLException {
		ProjectDao a = new ProjectDao();
		Project p = a.get(1);
		System.out.println(p);
	}
}
