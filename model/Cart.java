package com.dao.model;

import java.util.HashMap;

public class Cart {

	private HashMap<Integer,CartItem> items = new HashMap<Integer, CartItem>();
	
	public Cart() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside the Cart Construdtor");
	}
	

	public HashMap<Integer, CartItem> getItems() {
		return items;
	}



	public void setItems(HashMap<Integer, CartItem> items) {
		this.items = items;
	}
	

	private CartItem existingItem = null;

	public void addItem(CartItem item) {
		
		System.out.println("CartItem in my Cart.java "+item);
		
		int itemId = item.getItemId();
		if(items.containsKey(itemId)) {
			System.out.println("Inside the if of cart.java ");
			existingItem = items.get(itemId);
			int newQua = item.getQuantity();
			int oldQua = existingItem.getQuantity();
			int sumQua = newQua + oldQua;
			
			existingItem.setQuantity(sumQua);
		}else {
			items.put(itemId,item);
		}
		
	} 
	
	public void UpdateItem(int itemId,int quantity) {
		if(items.containsKey(itemId)) {
			if(quantity <= 0) {
				items.remove(itemId);
			}
			else {
				CartItem existingItem = items.get(itemId);
				existingItem.setQuantity(quantity);
			}
		}
	}
	
	public void removeItem(int item) {
		items.remove(item);
	}
	
	public HashMap<Integer, CartItem> getAllItems(){
		return items;
	}
	
	public double getTotalPrice() {
		double total = 0;
		for(CartItem item : items.values()) {
			total += item.getPrice() * item.getQuantity();
		}
		return total;
	}
	
	
	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}

	
	
	
}
