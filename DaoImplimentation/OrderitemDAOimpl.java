package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.OrderitemDAO;
import com.dao.model.Orderitem;
import com.db.util.DBConnection;

public class OrderitemDAOimpl implements OrderitemDAO{
	
	private String INSERT_ORDER_DETAILS="INSERT INTO `orderitem` (`orderid`,`menuid`,`quantity`,`totalPrice`) values (?,?,?,?);";
	private String GET_ORDER_DETAILS = "SELECT * FROM `orderitem` WHERE `orderitemid` = ?";
	private String UPDATE_ORDER_DETAILS = "UPDATE `orderitem` SET `orderid` = ?, `menuid` = ?,`quantity` = ?,`totalPrice` = ? Where `orderitemid`=?";
	private String DELETE_ORDER_DETAILS = "DELETE FROM `orderitem` WHERE `orderitemid` = ?";
	private String ALL_ORDER_DETAILS = "SELECT * FROM `orderitem`";
	@Override
	public void addOrderItem(Orderitem oi) {
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement  pstmt= connection.prepareStatement(INSERT_ORDER_DETAILS);) {
			
			pstmt.setInt(1,oi.getOrderid());
			pstmt.setInt(2, oi.getMenu());
			pstmt.setInt(3, oi.getQuantity());
			pstmt.setFloat(4, oi.getTotalprice());
			
			int  row = pstmt.executeUpdate();
			if(row > 0) {
				System.out.println("Order item is Added");
			}
			else {
			    System.out.println("No Orders are Added");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Orderitem getOrderDetails(int orderid) {
		
		Orderitem oi = null;
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ORDER_DETAILS);){
			pstmt.setInt(1, orderid);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int orderitemid = res.getInt("orderitemid");
				int orderId = res.getInt("orderid");
				int menuid = res.getInt("menuid");
				int quantity = res.getInt("quantity");
				float totalPrice = res.getFloat("totalPrice");
				
				oi = new Orderitem(orderitemid, orderId, menuid, quantity, totalPrice);
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oi;
	}

	@Override
	public void updateOrderitems(Orderitem oi) {
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_ORDER_DETAILS);){
			
			pstmt.setInt(1, oi.getOrderid());
			pstmt.setInt(2, oi.getMenu());
			pstmt.setInt(3, oi.getQuantity());
			pstmt.setFloat(4, oi.getTotalprice());
			pstmt.setInt(5, oi.getOrderitemid());
			
			int row = pstmt.executeUpdate();
			
			System.out.println(row + " Orderitem is updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderitems(int orderitemid) {
		
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt= connection.prepareStatement(DELETE_ORDER_DETAILS);){
			
			pstmt.setInt(1, orderitemid);
			
			int row = pstmt.executeUpdate();
			System.out.println(row  + " Row Deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Orderitem> getAllOrderitems() {
		Orderitem oi = null;
		
		List<Orderitem> list = new ArrayList<Orderitem>();
		Connection connection = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(ALL_ORDER_DETAILS);
			ResultSet res = pstmt.executeQuery();
			
			
			while(res.next()) {
				int orderitems = res.getInt("orderitemid");
				int orderId = res.getInt("orderid");
				int menuid = res.getInt("menuid");
				int quantity = res.getInt("quantity");
				float totalPrice = res.getFloat("totalPrice");
				
				Orderitem allorderitems = new Orderitem(orderitems, orderId, menuid, quantity, totalPrice);
				list.add(allorderitems);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	

	

	
}
