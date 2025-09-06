package com.dao.model;

public class Restaurant {
	
	private int restaurantid;
	private String name;
	private String address;
	private long phone;
	private float rating;
	private String cusineType;
	private String isActive;
	private int eta;
	private int adminUserId;
	private String imagePath;
	
	public Restaurant() {
		
	}
	public Restaurant(int restaurantid, String name, String address, long phone, float rating, String cusineType,
			String isActive, int eta, int adminUserId, String imagePath) {
		super();
		this.restaurantid = restaurantid;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.cusineType = cusineType;
		this.isActive = isActive;
		this.eta = eta;
		this.adminUserId = adminUserId;
		this.imagePath = imagePath;
	}
	
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getCusineType() {
		return cusineType;
	}
	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}
	public int getAdminUserId() {
		return adminUserId;
	}
	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantid=" + restaurantid + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", rating=" + rating + ", cusineType=" + cusineType + ", isActive=" + isActive + ", eta="
				+ eta + ", adminUserId=" + adminUserId + ", imagePath=" + imagePath + "]";
	}
	
	
	
	
	

}
