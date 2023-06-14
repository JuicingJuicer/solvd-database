package main.java.com.solvd.laba.db.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
	@XmlElement(name = "cityId")
	private int cityId;
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "state")
	private State state;

	public City() {
	}

	public City(int cityId, String name) {
		this.cityId = cityId;
		this.name = name;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getCityId() {
		return cityId;
	}

	public String getName() {
		return name;
	}

	public State getState() {
		return state;
	}

	@Override
	public String toString() {
		return "City{cityId=" + cityId + ", name=" + name + ", state=" + state + "}";
	}
}
