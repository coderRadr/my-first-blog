package net.codersadda.myblog.controller;

public class CityJSON {
	
	private String id;
	private String name;
	private String country;
	private COordinates coord;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public COordinates getCoord() {
		return coord;
	}
	public void setCoord(COordinates coord) {
		this.coord = coord;
	}
	
	

}
