package com.sevlet;

import java.io.IOException;

import com.dao.MenuDAO;
import com.dao.imp.MenuDAOimpl;
import com.dao.model.Cart;
import com.dao.model.CartItem;
import com.dao.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		
		                               
		
		Integer currRestarentId = (Integer)session.getAttribute("restarentid");
		Integer  newRestarentId = Integer.parseInt(req.getParameter("restarentid"));
		System.out.println(newRestarentId+"Rest id from the menu");
		System.out.println(currRestarentId+"Rest id from the session");
		
		if(cart == null || currRestarentId == null || !currRestarentId.equals(newRestarentId)) {
			cart = new Cart();
			session.setAttribute("cart", cart);
			
			session.setAttribute("restarentid",newRestarentId);
			
			
			
			
		}
		
		
			String action = req.getParameter("action");
				if("add".equals(action)) {
					addItemToCart(req,cart);
				}
				else if("update".equals(action)) {
					updateCartItem(req,cart);
				}else if("remove".equals(action)) {
					removeItemrowCart(req,cart);
				}
			
			RequestDispatcher rd= req.getRequestDispatcher("cart.jsp");
			rd.forward(req, resp);
		}
		
	
	private void addItemToCart(HttpServletRequest req, Cart cart) {

		int menuid = Integer.parseInt(req.getParameter("menuid"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		MenuDAO menuDAO = new MenuDAOimpl();
		Menu menuItem = menuDAO.getMenu(menuid);
		
		System.out.println("The menu in Cart Servlet" + menuItem);
		
		if(menuItem != null) {
			CartItem item = new CartItem(menuid,
					menuItem.getItemName(),
					menuItem.getPrice(),
					quantity);
			
			cart.addItem(item);
		}
		
	}
	
	
	

	private void removeItemrowCart(HttpServletRequest req, Cart cart) {
		int menuid = Integer.parseInt(req.getParameter("itemId"));
		System.out.println("Menu id from remove button"+menuid);
		cart.removeItem(menuid);
		
	}

	private void updateCartItem(HttpServletRequest req, Cart cart) {

		int menuid = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		cart.UpdateItem(menuid, quantity);
	}

	


}
