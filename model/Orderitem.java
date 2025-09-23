package com.dao.model;

public class Orderitem {

	private int orderitemid;
	private int orderid;
	private int menuid;
	private int quantity;
	private float totalPrice;
	
	public Orderitem() {
		
	}
	public Orderitem(int orderitemid,int orderid,int menuid,int quantity,float totalPrice) {
		
		this.orderitemid = orderitemid;
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
public Orderitem(int orderid,int menuid,int quantity,float totalPrice) {
		
		this.orderid = orderid;
		this.menuid = menuid;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	
	public void setOrderitemid(int orderitemid) {
		this.orderitemid = orderitemid;
	}
	public int getOrderitemid() {
		return orderitemid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getOrderid() {
		return orderid;
		
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getMenu() {
		return menuid;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setTotalprice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public float getTotalprice() {
		return totalPrice;
	}
	@Override
	public String toString() {
		return "orderitemid=" + orderitemid + ", orderid=" + orderid + ", menuid=" + menuid + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + "\n";
	}
}
