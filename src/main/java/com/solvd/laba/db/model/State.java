package main.java.com.solvd.laba.db.model;

public class State {
	private int stateId;
	private String name;

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
