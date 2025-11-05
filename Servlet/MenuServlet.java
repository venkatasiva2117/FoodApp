package com.sevlet;

import java.io.IOException;
import java.util.List;

import com.dao.model.Menu;
import com.dao.imp.MenuDAOimpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		 String restarentId =req.getParameter("restarentid");

		
		int restarentid =  Integer.parseInt(restarentId);
		
		MenuDAOimpl MenuDao = new  MenuDAOimpl();
		List<Menu> MenuList = MenuDao.getAllMenuByRestarent(restarentid);
		
		System.out.println(MenuList.size());
		
		req.setAttribute("menulist", MenuList);
		req.setAttribute("restarentid", restarentid);
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
		
		
		
		
	}
}
