package com.api.finra.vo;



public class RockersVO {
	private String name;
	private String lastName;
	private String country;
	
	public RockersVO() {}
	public RockersVO(String name, String lastName, String country) {
		this.name = name;
		this.lastName = lastName;
		this.country = country;
	}
	
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return name + " " + lastName + " " + country;
	}
	
}
