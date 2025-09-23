package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		Connection connection = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from `user` WHERE `username` = ? and `password` = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet res = pstmt.executeQuery();
			String gusername = "";
			String gpassword = "";
			while(res.next()) {
				 gusername = res.getString("username");
				 gpassword = res.getString("password");
			}
			
			if(gusername.equals(username) & gpassword.equals(password)) {
				resp.sendRedirect("menu.html");
			}
			else{
				out.print("Enter the correct password or correct name..");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
