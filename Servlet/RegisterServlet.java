package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserDAO;
import com.dao.model.User;
import com.daoimpl.UserDAOimpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		long number = Long.parseLong(req.getParameter("number"));
		String role = req.getParameter("role");
		String address = req.getParameter("address");
		User u = new User(name, username, password, email, number, address, role);
		UserDAO ui = new UserDAOimpl();
		ui.addUser(u);
		
		out.print("User add sucessfully");
		
		
		
		
		
	}

}
