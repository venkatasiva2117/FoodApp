package com.sevlet;

import java.io.IOException;
import java.util.List;

import com.dao.imp.RestaurantDAOimpi;
import com.dao.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class RestaurantsServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     RestaurantDAOimpi restaurantDAOimpi =   new RestaurantDAOimpi();
     
    List<Restaurant> allrestaurants =  restaurantDAOimpi.getAllRestaurant();
    
   System.out.println("fetched : " + allrestaurants.size());
    req.setAttribute("allrestaurants", allrestaurants);
    
    RequestDispatcher rd =   req.getRequestDispatcher("home.jsp");
    rd.forward(req, resp);
    }
}
