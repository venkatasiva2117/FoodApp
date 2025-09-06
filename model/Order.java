package com.dao.model;

public class Order {

	private int order_id;
	private int user_id;
	private int restaurantid;
	private String orderDate;
	private int totalAmount;
	private String status;
	private String paymentmode;
	
	public Order() {
		
	}
	
	public Order(int order_id, int user_id, int restaurantid, String orderDate, int totalAmount, String status,
			String paymentmode) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.restaurantid = restaurantid;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentmode = paymentmode;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", user_id=" + user_id + ", restaurantid=" + restaurantid
				+ ", orderDate=" + orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentmode="
				+ paymentmode + "]";
	}
	
	
	
	
}
