package main.java.com.solvd.laba.db.model;

import java.util.Date;
import java.util.HashMap;

public class Package {
	private int packageId;
	private java.util.Date purchaseDate;
	private String status;
	private Site site;
	private HashMap<Material, Integer> materialQuantity;

	public Package(int packageId, Date purchaseDate, String status) {
		this.packageId = packageId;
		this.purchaseDate = purchaseDate;
		this.status = status;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public void setPurchaseDate(java.util.Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public void setMaterialQuantity(HashMap<Material, Integer> materialQuantity) {
		this.materialQuantity = materialQuantity;
	}

	public int getPackageId() {
		return packageId;
	}

	public java.util.Date getPurchaseDate() {
		return purchaseDate;
	}

	public String getStatus() {
		return status;
	}

	public Site getSite() {
		return site;
	}

	public HashMap<Material, Integer> getMaterialQuantity() {
		return materialQuantity;
	}

	@Override
	public String toString() {
		return "Package{packageId=" + packageId + ", purchaseDate=" + purchaseDate + ", status=" + status + ", site="
				+ site + ", materialQuantity=" + materialQuantity + "}";
	}
}
