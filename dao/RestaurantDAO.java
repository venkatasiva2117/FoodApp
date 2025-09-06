package com.dao;

import java.util.List;

import com.dao.model.Restaurant;

public interface RestaurantDAO {
	
	void addRestaurant(Restaurant r);
	Restaurant getRestaurant(int r_id);
	void updateRestaurant(Restaurant r);
	int deleteRestaurant(int r_id);
	List<Restaurant> getAllRestaurant();

}
