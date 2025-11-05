package com.sevlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import com.dao.OrderDAO;
import com.dao.imp.OrderDAOimpl;
import com.dao.imp.OrderitemDAOimpl;
import com.dao.model.Cart;
import com.dao.model.CartItem;
import com.dao.model.Order;
import com.dao.model.Orderitem;
import com.dao.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet{

	//private OrderDAO orderdao;
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Checkout page is called");
		HttpSession session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		User user = (User)session.getAttribute("user");
		System.out.println(user);
		
		if(user==null) {
			System.out.println("reachrd to user null");
			RequestDispatcher rd = req.getRequestDispatcher("loginCheckoutoPlaceOrder.html");
			rd.forward(req, resp);
		}
		
		if(cart != null && user != null && !cart.getItems().isEmpty()) {
			System.out.println("reachrd to add database");
			String PaymentMethod = req.getParameter("payment-mode");
			//String Address = req.getParameter("address");
			
			Order order = new Order();
			order.setUser_id(user.getUser_id());
			order.setRestaurantid((int)session.getAttribute("restarentid"));
			order.setOrderDate(new Timestamp(new Date().getTime()));
			order.setPaymentmode(PaymentMethod);
			order.setStatus("CONFIRMED");
			
			double totalAmount = 0;
			for(CartItem item :cart.getItems().values()) {
				totalAmount += item.getPrice() * item.getQuantity();
			}
			
			order.setTotalAmount(totalAmount);
			System.out.println( "Order details" + order);
			

			OrderDAO orderdao = new OrderDAOimpl();
			int orderid = orderdao.addOrder(order);
			
			for(CartItem item : cart.getItems().values()) {
				int itemid = item.getItemId();
				int quantity = item.getQuantity();
				double totalPrice = item.getPrice();
				
				Orderitem orderitem = new Orderitem(orderid, itemid, quantity, totalPrice);
				
				
				OrderitemDAOimpl orderI;
				
				orderI = new OrderitemDAOimpl();
				orderI.addOrderItem(orderitem);
				
				  resp.sendRedirect("placedorder.html");
			}
		
		}
	
		
		
	}
	
	
	
	
}
