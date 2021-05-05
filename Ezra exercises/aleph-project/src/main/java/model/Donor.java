package model;

import java.io.Serializable;

// this is modeling records that belong to donor database


public class Donor implements Serializable{
	private Integer id_donor;
	private Integer id_account;
	private String title;
	private String first_name;
	private String last_name;
	private String address;
	private String city;
	private String state;
	private Integer zip;
	private String phone;
	private String email;
	private String email_alt;
	private String soc_sec;
	private String notes;
	private boolean allow_school_contact;
	private boolean donor_status;
	private Integer id_userpass;
	
	public Donor() {
	}
	public Donor(String title, String first_name, String last_name, String address, String city,
			 String state, Integer zip, String phone, String email,
			 String email_alt, String soc_sec, String notes, boolean allow_school_contact, 
			 boolean donor_status, Integer id_userpass) {
				this(null, null, title, first_name, last_name,  address,  city, state, zip,  phone,  email,
						  email_alt,  soc_sec,  notes, allow_school_contact, donor_status, id_userpass);
			}
	
	public Donor(Integer id_donor, String title, String first_name, String last_name, String address, String city,
	 String state, Integer zip, String phone, String email,
	 String email_alt, String soc_sec, String notes, boolean allow_school_contact, 
	 boolean donor_status, Integer id_userpass) {
		this(id_donor, null, title, first_name, last_name,  address,  city, state, zip,  phone,  email,
				  email_alt,  soc_sec,  notes, allow_school_contact, donor_status, id_userpass);
	}
		
//		this.id_donor=id_donor;
//		this.title=title;
//		this.first_name=first_name;
//		this.last_name=last_name;
//		this.address=address;
//		this.city=city;
//		this.state=state;
//		this.zip=zip;
//		this.phone=phone;
//		this.email=email;
//		this.email_alt=email_alt;
//		this.soc_sec=soc_sec;
//		this.notes=notes;
//		this.allow_school_contact=allow_school_contact;
//		this.donor_status=donor_status;	
	
	public Donor(Integer id_donor, Integer id_account, String title, String first_name, String last_name, String address, String city,
			 String state, Integer zip, String phone, String email,
			 String email_alt, String soc_sec, String notes, boolean allow_school_contact, boolean donor_status, Integer id_userpass) {
				this.id_account=id_account;
				this.id_donor=id_donor;
				this.title=title;
				this.first_name=first_name;
				this.last_name=last_name;
				this.address=address;
				this.city=city;
				this.state=state;
				this.zip=zip;
				this.phone=phone;
				this.email=email;
				this.email_alt=email_alt;
				this.soc_sec=soc_sec;
				this.notes=notes;
				this.allow_school_contact=allow_school_contact;
				this.donor_status=donor_status;
				this.id_userpass = id_userpass;
			}

	public Integer getId_donor() {
		return id_donor;
	}
	public void setId_donor(Integer id_donor) {
		this.id_donor = id_donor;
	}
	public Integer getId_account() {
		return id_account;
	}

	public void setId_account(Integer id_account) {
		this.id_account = id_account;
	}
	public String getTitle()
			{
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_alt() {
		return email_alt;
	}
	public void setEmail_alt(String email_alt) {
		this.email_alt = email_alt;
	}
	public String getSoc_sec() {
		return soc_sec;
	}
	public void setSoc_sec(String soc_sec) {
		this.soc_sec = soc_sec;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public boolean isAllow_school_contact() {
		return allow_school_contact;
	}
	public void setAllow_school_contact(boolean allow_school_contact) {
		this.allow_school_contact = allow_school_contact;
	}
	public boolean isDonor_status() {
		return donor_status;
	}
	public void setDonor_status(boolean donor_status) {
		this.donor_status = donor_status;
	}

	public Integer getId_userpass() {
		return id_userpass;
	}
	
	public void setId_userpass(Integer id_userpass) {
		this.id_userpass = id_userpass;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (allow_school_contact ? 1231 : 1237);
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + (donor_status ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((email_alt == null) ? 0 : email_alt.hashCode());
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((id_account == null) ? 0 : id_account.hashCode());
		result = prime * result + ((id_donor == null) ? 0 : id_donor.hashCode());
		result = prime * result + ((id_userpass == null) ? 0 : id_userpass.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((soc_sec == null) ? 0 : soc_sec.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Donor other = (Donor) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (allow_school_contact != other.allow_school_contact)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (donor_status != other.donor_status)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (email_alt == null) {
			if (other.email_alt != null)
				return false;
		} else if (!email_alt.equals(other.email_alt))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id_account == null) {
			if (other.id_account != null)
				return false;
		} else if (!id_account.equals(other.id_account))
			return false;
		if (id_donor == null) {
			if (other.id_donor != null)
				return false;
		} else if (!id_donor.equals(other.id_donor))
			return false;
		if (id_userpass == null) {
			if (other.id_userpass != null)
				return false;
		} else if (!id_userpass.equals(other.id_userpass))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (soc_sec == null) {
			if (other.soc_sec != null)
				return false;
		} else if (!soc_sec.equals(other.soc_sec))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
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
		return "Donor [id_donor=" + id_donor + ", id_account=" + id_account + ", title=" + title + ", first_name="
				+ first_name + ", last_name=" + last_name + ", address=" + address + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", phone=" + phone + ", email=" + email + ", email_alt=" + email_alt
				+ ", soc_sec=" + soc_sec + ", notes=" + notes + ", allow_school_contact=" + allow_school_contact
				+ ", donor_status=" + donor_status + ", id_userpass=" + id_userpass + "]";
	}
	
	
}
	