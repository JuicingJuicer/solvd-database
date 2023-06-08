package main.java.com.solvd.laba.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.solvd.laba.db.model.Client;

public class ClientDao extends Dao<Client> {
	protected String getStatement() {
		return "SELECT * FROM CLIENTS WHERE client_id=?";
	}

	protected String getAllStatement() {
		return "SELECT * FROM CLIENTS";
	}

	protected String insertStatement() {
		return "INSERT INTO CLIENTS (client_id, first_name, last_name, email, phone_number, company_name) VALUES (?, ?, ?, ?, ?, ?)";
	}

	protected String updateStatement() {
		return "UPDATE CLIENTS SET client_id = ?, first_name = ?, last_name = ?, email = ?, phone_number = ?, company_name = ?, job_id = ? WHERE client_id = ?";
	}

	protected String deleteStatement() {
		return "DELETE FROM CLIENTS WHERE client_id =?";
	}

	protected Client create(ResultSet rs) throws SQLException {
		return new Client(rs.getInt("client_id"), rs.getString("first_name"), rs.getString("last_name"),
				rs.getString("email"), rs.getString("phone_number"), rs.getString("company_name"));
	}

	protected void addValue(Client client, PreparedStatement ps, boolean b) throws SQLException {
		ps.setInt(1, client.getClientId());
		if (b) {
			ps.setString(2, client.getFirstName());
			ps.setString(3, client.getLastName());
			ps.setString(4, client.getEmail());
			ps.setString(5, client.getPhoneNumber());
			ps.setString(6, client.getCompanyName());
		}
	}

	protected void addUpdatedValue(Client client, PreparedStatement ps) throws SQLException {
		ps.setInt(1, client.getClientId());
		ps.setString(2, client.getFirstName());
		ps.setString(3, client.getLastName());
		ps.setString(4, client.getEmail());
		ps.setString(5, client.getPhoneNumber());
		ps.setString(6, client.getCompanyName());
		ps.setInt(7, client.getClientId());
	}
}
