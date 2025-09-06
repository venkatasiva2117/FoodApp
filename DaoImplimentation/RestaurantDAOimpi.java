package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.RestaurantDAO;
import com.dao.model.Restaurant;
import com.db.util.DBConnection;

public class RestaurantDAOimpi implements RestaurantDAO{

	private String ADD_RESTAURANT = "INSERT INTO `restaurant` (`restaurantid`,`name`, `address`, `phone`, `rating`, `cusineType`, `isActive`, `eta`, `adminUserId`, `imagePath`) values(?,?,?,?,?,?,?,?,?,?)";
	private String UPDATE_RESTAURANT = "UPDATE `restaurant` SET `name` = ?, `address`= ?, `phone` =  ?, `rating`=?, `cusineType` = ?, `isActive` = ? , `eta` = ?, `adminUserId`= ?, `imagePath` = ? WHERE `restaurantid`= ?";
	private String GET_RESTAURANT = "SELECT * from `restaurant` WHERE `restaurantid` = ?";
	private String DELETE_RESTAURANT = "DELETE FROM restaurant WHERE `restaurantid` = ?";
	private String GETALL_RESTAURANT = "Select * from `restaurant`";
	@Override
	public void addRestaurant(Restaurant r) {



		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(ADD_RESTAURANT);){


			pstmt.setInt(1, r.getRestaurantid());
			pstmt.setString(2, r.getName());
			pstmt.setString(3, r.getAddress());
			pstmt.setLong(4,r.getPhone());
			pstmt.setFloat(5, r.getRating());
			pstmt.setString(6, r.getCusineType());
			pstmt.setString(7, r.getIsActive());
			pstmt.setInt(8, r.getEta());
			pstmt.setInt(9, r.getAdminUserId());
			pstmt.setString(10, r.getImagePath());


			int row = pstmt.executeUpdate();

			if(row > 0) {
				System.out.println("Restaurant added sucessfully");
			}
			else {
				System.out.println("Restaurant not added");
			}


		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public Restaurant getRestaurant(int r_id) {


		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_RESTAURANT);) {


			pstmt.setInt(1, r_id);

			ResultSet res = pstmt.executeQuery();


			while(res.next()) {
				int restaurantid = res.getInt("restaurantid");
				String name = res.getString("name");
				String address = res.getString("address");
				long phone = res.getLong("phone");
				float rating = res.getFloat("rating");
				String cusineType = res.getString("cusineType");
				String isActive = res.getString("isActive");
				int eta = res.getInt("eta");
				int adminUserId = res.getInt("adminUserId");
				String imagePath = res.getString("imagePath");

				Restaurant restaurant = new Restaurant(restaurantid, name, address, phone, rating, cusineType, isActive, eta, adminUserId, imagePath);

				return restaurant;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateRestaurant(Restaurant r) {


		try (Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_RESTAURANT);){


			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getAddress());
			pstmt.setLong(3, r.getPhone());
			pstmt.setFloat(4, r.getRating());
			pstmt.setString(5, r.getCusineType());
			pstmt.setString(6, r.getIsActive());
			pstmt.setInt(7, r.getEta());
			pstmt.setInt(8, r.getAdminUserId());
			pstmt.setString(9, r.getImagePath());
			pstmt.setInt(10, r.getRestaurantid());


			int row = pstmt.executeUpdate();

			if(row > 0) {
				System.out.println("Sucessfully Updated");
			}
			else {
				System.out.println("Not Updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public int deleteRestaurant(int r_id) {

		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(DELETE_RESTAURANT);) {

			pstmt.setInt(1, r_id);

			int  row = pstmt.executeUpdate();

			if(row > 0) {
				System.out.println("restaurant is Sucessfully deleted");
			}
			else {
				System.out.println("Restaurant is not deleted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Restaurant> getAllRestaurant() {


		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GETALL_RESTAURANT);) {
			
			List<Restaurant> res_list = new ArrayList<Restaurant>();
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int restaurantid = res.getInt("restaurantid");
				String name = res.getString("name");
				String address = res.getString("address");
				long phone = res.getLong("phone");
				float rating = res.getFloat("rating");
				String cusineType = res.getString("cusineType");
				String isActive = res.getString("isActive");
				int eta = res.getInt("eta");
				int adminUserId = res.getInt("adminUserId");
				String imagePath = res.getString("imagePath");
				
				Restaurant restaurant = new Restaurant(restaurantid, name, address, phone, rating, cusineType, isActive, eta, adminUserId, imagePath);
				  res_list.add(restaurant);
			}
			
			return res_list;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}








}
