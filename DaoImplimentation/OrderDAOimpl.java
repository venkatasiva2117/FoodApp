package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.OrderDAO;
import com.dao.model.Order;
import com.db.util.DBConnection;

public class OrderDAOimpl implements OrderDAO{
	
	private String GETORDER_QUERY = "SELECT * FROM `order` WHERE `user_id` = ?";
	private String DELETE_ORDER = "DELETE FROM `order` WHERE `user_id` = ?";
	private String GETALLORDER_QUERY = "SELECT * FROM `order`";

	
	@Override
	public Order getOrderDetails(int user_id) {
		Order o = null;
		Connection connection = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(GETORDER_QUERY);
			Scanner sc = new Scanner(System.in);
			
			pstmt.setInt(1, user_id);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int order_id = res.getInt("order_id");
				int user_idd = res.getInt("user_id");
				int restaurantid = res.getInt("restaurantid");
				String orderDate = res.getString("orderDate");
				int totalAmount = res.getInt("totalAmount");
				String status = res.getString("status");
				String paymentmode = res.getString("paymentmode");
				
				o =  new Order(order_id, user_idd, restaurantid, orderDate, totalAmount, status, paymentmode);	
			}
			
			return o;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void deleteOrder(int user_id) {
		
		Connection connection = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(DELETE_ORDER);
			
			pstmt.setInt(1, user_id);
			
			int row = pstmt.executeUpdate();
			
			if(row > 0) {
				System.out.println("Order deleted Sucessfully");
			}
			else {
				System.out.println("Order not Deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> getAllOrders() {
		
		Order o = null;
		Connection connection = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(GETALLORDER_QUERY);

			List<Order>order = new ArrayList<Order>();
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int order_id = res.getInt("order_id");
				int user_idd = res.getInt("user_id");
				int restaurantid = res.getInt("restaurantid");
				String orderDate = res.getString("orderDate");
				int totalAmount = res.getInt("totalAmount");
				String status = res.getString("status");
				String paymentmode = res.getString("paymentmode");
				
				o =  new Order(order_id, user_idd, restaurantid, orderDate, totalAmount, status, paymentmode);
				order.add(o);
			}
			
			return order;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
