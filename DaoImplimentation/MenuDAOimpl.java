package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dao.MenuDAO;
import com.dao.model.Menu;
import com.db.util.DBConnection;



public class MenuDAOimpl implements MenuDAO {

	private String Add_menu = "INSERT INTO menu (restaurantid, itemName, description, price, rating, isAvailable, imagePath) VALUES (?,?,?,?,?,?,?)";

	private String GET_MENU = "SELECT * FROM `menu` WHERE `menu_id` = ?";

	private String UPDATE_MENU = "UPDATE `menu` SET `restaurantid` = ?,`itemName` = ?,`description` = ?,`price` = ?,`rating`=?,`isAvailable` = ?,`imagePath`= ? WHERE `menu_id` = ?";
	private String DELETE_QUERY = "DELETE FROM `menu` WHERE `menu_id` = ?";
	
	private String GET_ALL_MENU = "SELECT * FROM `menu`"; 
	@Override
	public void addMenu(Menu m) {
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(Add_menu)) {

			pstmt.setInt(1, m.getRestaurantid());
			pstmt.setString(2, m.getItemName());
			pstmt.setString(3, m.getDescription());
			pstmt.setDouble(4, m.getPrice());
			pstmt.setFloat(5, m.getRating());
			pstmt.setString(6, m.getIsAvailable());
			pstmt.setString(7, m.getImagePath());
			

			int row = pstmt.executeUpdate();
			if(row >= 1) System.out.println("Menu added successfully!");
			else System.out.println("Failed to add menu.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Menu getMenu(int menu_id)
	{ 

		Menu m = null;
		try(  Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_MENU);) {



			pstmt.setInt(1, menu_id);
			ResultSet res = pstmt.executeQuery();

			while(res.next()) {
				int id = res.getInt("menu_id");
				int restaurantid =res.getInt("restaurantid");
				String itemName = res.getString("itemName");
				String description = res.getString("description");
				double price = res.getDouble("price");
				float rating = res.getFloat("rating");
				String isAvailable = res.getString("isAvailable");
				String imagePath = res.getString("imagePath");

				m =  new Menu(id, restaurantid, itemName, description, price, rating, isAvailable, imagePath);

			}

			return m;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; 
	}
	@Override
	public void updateMenu(Menu m) {


		try (Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(UPDATE_MENU);){

			pstmt.setInt(1, m.getRestaurantid());
			pstmt.setString(2, m.getItemName());
			pstmt.setString(3, m.getDescription());
			pstmt.setDouble(4, m.getPrice());
			pstmt.setFloat(5, m.getRating());
			pstmt.setString(6, m.getIsAvailable());
			pstmt.setString(7, m.getImagePath());
			pstmt.setInt(8, m.getMenu_id());

			int res = pstmt.executeUpdate();
			System.out.println(res + " User Details updated.");

		} catch (SQLException e) {

			e.printStackTrace();
		}


	}
	@Override
	public int deleteMenu(int menu_id) 
	{ 

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);){

			pstmt.setInt(1, menu_id);

			int row = pstmt.executeUpdate();


			if(row > 0) {
				System.out.println(row + " Menu Deleted.");
			}
			else {
				System.out.println(row + " Menu Not Deleted.");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
		
	}


	@Override
	public List<Menu> getAllMenu() { 

		List<Menu> list = new ArrayList<Menu>();

		Menu m = null;
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_ALL_MENU);){

			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int menu_id = res.getInt("menu_id");
				int restaurantid = res.getInt("restaurantid");
				String itemName = res.getString("itemName");
				String description = res.getString("description");
				double price = res.getDouble("price");
				float rating = res.getFloat("rating");
				String isAvailable = res.getString("isAvailable");
				String imagePath = res.getString("imagePath");
			    m  = new Menu(menu_id, restaurantid, itemName, description, price, rating, isAvailable, imagePath);
			    
			    list.add(m);
			}
			
			
	
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
		 
	}
}
