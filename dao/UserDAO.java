package com.dao;

import java.util.List;

import com.dao.model.User;


public interface UserDAO {

	void addUser(User u);
	User getUser(int id);
	void updateUser(User u);
	int deleteUser(int id);
	List<User>getAllUsers();
	
}
