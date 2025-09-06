package com.dao.model;

import java.sql.Timestamp;

public class User {

	private int user_id;
	private String name;
	private String username;
	private String password;
	private String email;
	private long phone;
	private String address;
	private String role;
	Timestamp createdDate;
	Timestamp lastLoginDate;
	
	public User() {
		
	}

	public User(int user_id,String name, String username, String password, String email, long phone, String address, String role,
			Timestamp createdDate, Timestamp lastLoginDate) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.createdDate = createdDate;
		this.lastLoginDate = lastLoginDate;
	}
	
	public User(String name, String username, String password, String email, long phone, String address, String role) {
		
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
	}
	
	

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}

	

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", role=" + role + ", createdDate=" + createdDate
				+ ", lastLoginDate=" + lastLoginDate + "]";
	}
	
	
	
}
