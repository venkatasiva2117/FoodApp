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

public class GetUserDetails extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out = resp.getWriter();
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		
		UserDAO ud = new UserDAOimpl();
		User u = ud.getUser(user_id);
		
		out.print(u);
		
		
		
	}
}
