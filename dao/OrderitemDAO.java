package com.dao;

import java.util.List;

import com.dao.model.Orderitem;

public interface OrderitemDAO {

	void addOrderItem(Orderitem oi);
	Orderitem getOrderDetails(int orderid);
	void updateOrderitems(Orderitem oi);
	void deleteOrderitems(int orderid);
	List<Orderitem> getAllOrderitems();
	
	
	
}
