package com.litap.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Userdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;
	
	private String name, address, email, phone, gender,mobno;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userdetails")
	private List<User> user = new ArrayList<User>();
	
	
	

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	@Override
	public String toString() {
		return "Userdetails [userid=" + userid + ", name=" + name + ", address=" + address + ", email=" + email
				+ ", phone=" + phone + ", gender=" + gender + ", mobno=" + mobno + ", user=" + user + "]";
	}
	
	
	 

} 
