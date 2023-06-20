package main.java.com.solvd.laba.db.model;

public class Material {
	private int materialId;
	private String materialName;
	private String materialDesc;
	private int materialPrice;
	private int quantity;

	public Material() {
	}

	public Material(int materialId, String materialName, String materialDesc, int materialPrice) {
		this.materialId = materialId;
		this.materialName = materialName;
		this.materialDesc = materialDesc;
		this.materialPrice = materialPrice;
		this.quantity = 0;
	}

	public Material(int materialId, String materialName, String materialDesc, int materialPrice, int quantity) {
		this.materialId = materialId;
		this.materialName = materialName;
		this.materialDesc = materialDesc;
		this.materialPrice = materialPrice;
		this.quantity = quantity;
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

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "Material{materialId=" + materialId + ", materialName=" + materialName + ", materialDesc=" + materialDesc
				+ ", materialPrice=" + materialPrice + ", quantity=" + quantity + "}";
	}
}
