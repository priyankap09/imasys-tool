package com.litap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String password;
	
	
	private String imagepath;
	private String role;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userdetail_id")
	private Userdetails userdetails;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Userdetails getUserdetails() {
		return userdetails;
	}
	public void setUserdetails(Userdetails userdetails) {
		this.userdetails = userdetails;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	transient MultipartFile images;//MultipartFile object contains image details
	
	
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public MultipartFile getImages() {
		return images;
	}
	public void setImages(MultipartFile images) {
		this.images = images;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", imagepath=" + imagepath
				+ ", role=" + role + ", userdetails=" + userdetails + "]";
	}
	
	
	
}
