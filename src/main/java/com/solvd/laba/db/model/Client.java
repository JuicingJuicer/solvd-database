package main.java.com.solvd.laba.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Client {
	@JsonProperty("clientId")
	private int clientId;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("email")
	private String email;
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	@JsonProperty("companyName")
	private String companyName;

	public Client() {
	}

	public Client(int clientId, String firstName, String lastName, String email, String phoneNumber,
			String companyName) {
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.companyName = companyName;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getClientId() {
		return clientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	@Override
	public String toString() {
		return "Client{clientId=" + clientId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", companyName=" + companyName + "}";
	}
}
