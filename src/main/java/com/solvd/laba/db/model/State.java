package main.java.com.solvd.laba.db.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "state")
@XmlAccessorType(XmlAccessType.FIELD)
public class State {
	@XmlElement(name = "stateId")
	@JsonProperty("stateId")
	private int stateId;
	@XmlElement(name = "name")
	@JsonProperty("name")
	private String name;

	public State() {
	}

	public State(int stateId, String name) {
		this.stateId = stateId;
		this.name = name;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStateId() {
		return stateId;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "State{stateId=" + stateId + ", name=" + name + "}";
	}
}
