package main.java.com.solvd.laba.db.model;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import main.java.com.solvd.laba.db.xml.DateAdapter;

@XmlRootElement(name = "package")
@XmlAccessorType(XmlAccessType.FIELD)
public class Package {
	@XmlElement(name = "packageId")
	private int packageId;
	@XmlElement(name = "purchaseDate")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private java.util.Date purchaseDate;
	@XmlElement(name = "status")
	private String status;
	@XmlElement(name = "site")
	private Site site;
	@XmlTransient
	private ArrayList<Material> materials;

	public Package() {
	}

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

	public void setMaterials(ArrayList<Material> materials) {
		this.materials = materials;
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

	public ArrayList<Material> getMaterials() {
		return materials;
	}

	@Override
	public String toString() {
		return "Package{packageId=" + packageId + ", purchaseDate=" + purchaseDate + ", status=" + status + ",\nSite="
				+ site + ",\nMaterials=" + materials + "}";
	}
}
