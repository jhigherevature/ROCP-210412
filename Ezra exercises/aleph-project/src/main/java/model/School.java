package model;

import java.io.Serializable;

public class School implements Serializable {
	private Integer id_school;
	private String name_school;
	private String address;
	private String city;
	private String state;
	private Integer zip;
	private String website;
	private String id_tax;


	public School() {
	}
	public School(Integer id_school, String name_school, String address, String city,
			 String state, Integer zip, String website, String id_tax) {
		this.id_school= null;
		this.name_school= name_school;
		this.address= address;
		this.city= city;
		this.state= state;
		this.zip=zip;
		this.website= website;
		this.id_tax= id_tax;
	}
	public School(String name_school, String address, String city,
			 String state, Integer zip, String website) {
		this(null, name_school, address, city, state, zip, website, null);
	}
	/**
	 * @return the id_school
	 */
	public Integer getId_school() {
		return id_school;
	}
	/**
	 * @param id_school the id_school to set
	 */
	public void setId_school(Integer id_school) {
		this.id_school = id_school;
	}
	/**
	 * @return the name_school
	 */
	public String getName_school() {
		return name_school;
	}
	/**
	 * @param name_school the name_school to set
	 */
	public void setName_school(String name_school) {
		this.name_school = name_school;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zip
	 */
	public Integer getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	/**
	 * @return the id_tax
	 */
	public String getId_tax() {
		return id_tax;
	}
	/**
	 * @param id_tax the id_tax to set
	 */
	public void setId_tax(String id_tax) {
		this.id_tax = id_tax;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((id_school == null) ? 0 : id_school.hashCode());
		result = prime * result + ((id_tax == null) ? 0 : id_tax.hashCode());
		result = prime * result + ((name_school == null) ? 0 : name_school.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		School other = (School) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id_school == null) {
			if (other.id_school != null)
				return false;
		} else if (!id_school.equals(other.id_school))
			return false;
		if (id_tax == null) {
			if (other.id_tax != null)
				return false;
		} else if (!id_tax.equals(other.id_tax))
			return false;
		if (name_school == null) {
			if (other.name_school != null)
				return false;
		} else if (!name_school.equals(other.name_school))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "School [id_school=" + id_school + ", name_school=" + name_school + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zip=" + zip + ", website=" + website + ", id_tax=" + id_tax + "]";
	}
	
	
}
