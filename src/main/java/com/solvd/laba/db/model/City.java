package main.java.com.solvd.laba.db.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "city")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
	@XmlElement(name = "cityId")
	@JsonProperty("cityId")
	private int cityId;
	@XmlElement(name = "name")
	@JsonProperty("name")
	private String cityName;
	@XmlElement(name = "state")
	@JsonProperty("state")
	private State state;

	public City() {
	}

	public City(int cityId, String cityName) {
		this.cityId = cityId;
		this.cityName = cityName;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getCityId() {
		return cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public State getState() {
		return state;
	}

	@Override
	public String toString() {
		return "City{cityId=" + cityId + ", cityName=" + cityName + ", state=" + state + "}";
	}
}
