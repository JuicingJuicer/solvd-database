package main.java.com.solvd.laba.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildingType {
	@JsonProperty("buildingTypeId")
	private int buildingTypeId;
	@JsonProperty("buildingName")
	private String buildingName;
	@JsonProperty("buildingTag")
	private String buildingTag;
	@JsonProperty("time")
	private int time;

	public BuildingType() {
	}

	public BuildingType(int buildingTypeId, String buildingName, String buildingTag, int time) {
		this.buildingTypeId = buildingTypeId;
		this.buildingName = buildingName;
		this.buildingTag = buildingTag;
		this.time = time;
	}

	public void setBuildingTypeId(int buildingTypeId) {
		this.buildingTypeId = buildingTypeId;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public void setBuildingTag(String buildingTag) {
		this.buildingTag = buildingTag;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getBuildingTypeId() {
		return buildingTypeId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public String getBuildingTag() {
		return buildingTag;
	}

	public int getTime() {
		return time;
	}

	@Override
	public String toString() {
		return "BuildingType{buildingTypeId=" + buildingTypeId + ", buildingName=" + buildingName + ", buildingTag="
				+ buildingTag + ", time=" + time + "years}";
	}
}
