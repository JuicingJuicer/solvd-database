package main.java.com.solvd.laba.db.model;

public class City {
	private int cityId;
	private String name;
	private State state;

	public City(int cityId, String name, State state) {
		this.cityId = cityId;
		this.name = name;
		this.state = state;
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
		return "City{cityId=" + cityId + ", name=" + name + ", stateId=" + state.getStateId() + "}\n";
	}
}
