package com.dao;



import java.util.List;

import com.dao.model.Order;

public interface OrderDAO {

	Order getOrderDetails(int user_id);
	void deleteOrder(int user_id);
	List<Order> getAllOrders();
	
}
