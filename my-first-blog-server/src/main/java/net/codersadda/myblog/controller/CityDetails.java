package net.codersadda.myblog.controller;

public class CityDetails {
	
	private String cityName;
	private String latitude;
	private String longitude;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public CityDetails(String cityName, String latitude, String longitude) {
		super();
		this.cityName = cityName;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}
