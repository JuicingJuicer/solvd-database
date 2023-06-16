package main.java.com.solvd.laba.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuildingType {
	@JsonProperty("buildingTypeId")
	private int buildingTypeId;
	@JsonProperty("buildingName")
	private String buildingName;
	@JsonProperty("buildingTag")
	private String buildingTag;
	@JsonProperty("additionalDetails")
	private String additionalDetails;

	public BuildingType() {
	}

	public BuildingType(int buildingTypeId, String buildingName, String buildingTag, String additionalDetails) {
		this.buildingTypeId = buildingTypeId;
		this.buildingName = buildingName;
		this.buildingTag = buildingTag;
		this.additionalDetails = additionalDetails;
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

	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
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

	public String getAdditionalDetails() {
		return additionalDetails;
	}

	@Override
	public String toString() {
		return "BuildingType{buildingTypeId=" + buildingTypeId + ", buildingName=" + buildingName + ", buildingTag="
				+ buildingTag + ", additionalDetails=" + additionalDetails + "}";
	}
}
