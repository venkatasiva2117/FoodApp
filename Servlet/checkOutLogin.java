package com.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.model.User;
import com.db.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/checkoutlogin")
public class checkOutLogin extends HttpServlet{


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		
		try (Connection connection = DBConnection.Getconnection();
				PreparedStatement pstmt = connection.prepareStatement("select * from `user` WHERE `username` = ? and `password` = ?");){
			//PreparedStatement pstmt = connection.prepareStatement("select * from `user` WHERE `username` = ? and `password` = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet res = pstmt.executeQuery();
			
		
			if(res.next()) {
		
				User user = new User();
				 user.setUser_id(res.getInt("user_id"));
				 user.setEmail(res.getString("email"));
				 user.setPassword(res.getString("password"));
				 user.setUsername(res.getString("username"));
				 
				 req.getSession().setAttribute("user", user);
				 
				 resp.sendRedirect("checkout.jsp");
			}
			else{
				out.print("Enter the correct password or correct name..");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
