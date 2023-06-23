package main.java.com.solvd.laba.db.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	@XmlElement(name = "empId")
	@JsonProperty("empId")
	private int empId;
	@XmlElement(name = "firstName")
	@JsonProperty("firstName")
	private String firstName;
	@XmlElement(name = "lastName")
	@JsonProperty("lastName")
	private String lastName;
	@XmlElement(name = "age")
	@JsonProperty("age")
	private int age;
	@XmlElement(name = "email")
	@JsonProperty("email")
	private String email;
	@XmlElement(name = "phoneNumber")
	@JsonProperty("phoneNumber")
	private String phoneNumber;
	@XmlElement(name = "job")
	@JsonProperty("job")
	private Job job;
	@XmlElement(name = "team")
	@XmlElementWrapper(name = "teams")
	@JsonProperty("teams")
	private ArrayList<Team> teams;

	public Employee() {
	}

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
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", Job=" + job + ", Team(s)=" + teams + "}";
	}

}
