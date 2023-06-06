package main.java.com.solvd.laba.db.model;

public class Material {
	private int materialId;
	private String materialName;
	private String materialDesc;
	private int materialPrice;

	public Material(int materialId, String materialName, String materialDesc, int materialPrice) {
		this.materialId = materialId;
		this.materialName = materialName;
		this.materialDesc = materialDesc;
		this.materialPrice = materialPrice;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public void setMaterialDesc(String materialDesc) {
		this.materialDesc = materialDesc;
	}

	public void setMaterialPrice(int materialPrice) {
		this.materialPrice = materialPrice;
	}

	public int getMaterialId() {
		return materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public String getMaterialDesc() {
		return materialDesc;
	}

	public int getMaterialPrice() {
		return materialPrice;
	}

	@Override
	public String toString() {
		return "Material{materialId=" + materialId + ", materialName=" + materialName + ", materialDesc=" + materialDesc
				+ ", materialPrice" + materialPrice + "}\n";
	}
}
