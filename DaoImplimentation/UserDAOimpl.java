package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import com.dao.UserDAO;
import com.dao.model.User;
import com.db.util.DBConnection;




public class UserDAOimpl implements UserDAO{


	private String UPDATE_QUERY = "Insert into `user`(`name`,`username`,`password`,`email`,`phone`,`role`,`address`) values(?,?,?,?,?,?,?)";
	private String GET_USER = "SELECT * from `user` where `user_id` = ?";
	private String UPDATE_USER_QUERY = "UPDATE user "
            + "SET name=?, username=?, password=?, email=?, phone=?, address=?, role=? "
            + "WHERE user_id=?";
	private String DELETE_QUERY = "DELETE FROM `user` WHERE `user_id` = ?";

	@Override
	public void addUser(User u) {
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt  = connection.prepareStatement(UPDATE_QUERY);){

			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getUsername());
			pstmt.setString(3, u.getPassword());
			pstmt.setString(4, u.getEmail());
			pstmt.setLong(5, u.getPhone());
			pstmt.setString(6, u.getRole());
			pstmt.setString(7, u.getAddress());
			



			int row = pstmt.executeUpdate();

			if(row>=1) {
				System.out.println("User Added Sucessfully");
			}
			else {
				System.out.println("User Not ADDED");
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public User getUser(int id) {



		User u = null;
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(GET_USER);) {

			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();



			while(res.next()) {
				int user_id = res.getInt("user_id");
				String name = res.getString("name");
				String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				long phone = res.getLong("phone");
				String role = res.getString("role");
				Timestamp createdDate = res.getTimestamp("createdDate");
				Timestamp lastLoginDate = res.getTimestamp("lastLoginDate");	
				u = new User(user_id,name, username, password, email, phone, email, role, createdDate, lastLoginDate);

			}

			return u;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
    public void updateUser(User u) {
        Connection connection = DBConnection.getConnection();

        try (PreparedStatement pstmt = connection.prepareStatement(UPDATE_USER_QUERY)) {
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getUsername());
            pstmt.setString(3, u.getPassword());
            pstmt.setString(4, u.getEmail());
            pstmt.setLong(5, u.getPhone());
            pstmt.setString(6, u.getAddress());
            pstmt.setString(7, u.getRole());
            pstmt.setInt(8, u.getUser_id());
            

            int res = pstmt.executeUpdate();
            System.out.println(res + " User Details updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public int deleteUser(int id) {
		
		
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(DELETE_QUERY);) {
			
			
			pstmt.setInt(1, id);
			
			int row = pstmt.executeUpdate();
			
			if(row>=1) {
				System.out.println("User deleted");
			}
			else {
				System.out.println("User not deleted");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User>list = new ArrayList<User>();
		
		User u = null;
		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement("Select * from user");) {

			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int user_id = res.getInt("user_id");
				String name = res.getString("name");
				String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				long phone = res.getLong("phone");
				String address = res.getString("address");
				String role = res.getString("role");
				Timestamp createdDate = res.getTimestamp("createdDate");
				Timestamp lastLoginDate = res.getTimestamp("lastLoginDate");	
				u = new User(user_id,name, username, password, email, phone, address, role, createdDate, lastLoginDate);

				list.add(u);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
