package main.java.com.solvd.laba.db.model;

import java.util.ArrayList;

public class Employee {
	private int empId;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String phoneNumber;
	private Job job;
	private ArrayList<Team> teams;

	public Employee(int empId, String firstName, String lastName, int age, String email, String phoneNumber) {
		this.setEmpId(empId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAge(age);
		this.setEmail(email);
		this.setPhoneNumber(phoneNumber);
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	public int getEmpId() {
		return empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Job getJob() {
		return job;
	}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	@Override
	public String toString() {
		return "Employee{empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", Job=" + job + "Team(s)=" + teams + "}\n";
	}

}
