package main.java.com.solvd.laba.db.model;

public class PackageDetail {
	private int packageDetailId;
	private Package pack;
	private Material material;
	private int quantity;

	public PackageDetail(int packageDetailId, Package pack, Material material, int quantity) {
		this.packageDetailId = packageDetailId;
		this.pack = pack;
		this.material = material;
		this.quantity = quantity;
	}

	public void setPackageDetailId(int packageDetailId) {
		this.packageDetailId = packageDetailId;
	}

	public void setPack(Package pack) {
		this.pack = pack;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPackageDetailId() {
		return packageDetailId;
	}

	public Package getPack() {
		return pack;
	}

	public Material getMaterial() {
		return material;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "PackageDetail{packageDetailId=" + packageDetailId + ", packageId=" + pack.getPackageId()
				+ ", materialId=" + material.getMaterialId() + ", quantity" + quantity + "}\n";
	}
}
