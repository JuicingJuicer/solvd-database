package main.java.com.solvd.laba.db.model;

public class Site {
	private int siteId;
	private String address;
	private City city;
	private int zip;

	public Site(int siteId, String address, int zip) {
		this.siteId = siteId;
		this.address = address;
		this.zip = zip;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getSiteId() {
		return siteId;
	}

	public String getAddress() {
		return address;
	}

	public City getCity() {
		return city;
	}

	public int getZip() {
		return zip;
	}

	@Override
	public String toString() {
		return "Site{siteId=" + siteId + ", address=" + address + ", city=" + city + ", zip=" + zip + "}";
	}
}
