package com.sevlet;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.dao.OrderDAO;
import com.dao.imp.OrderDAOimpl;
import com.dao.model.Order;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter the userid");
		int userid = sc.nextInt();
		System.out.println("Enter the restarentid");
		int restarentid = sc.nextInt();
		//Timestamp orderdate = new Timestamp(new java.util.Date().getTime());
		Timestamp orderdate =  Timestamp.valueOf(LocalDateTime.now());
		System.out.println("Enter the totalAmount");
		double totalAmount = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter the status");
		String status = sc.nextLine();
		System.out.println("Enter the name");
		String pamentMethod = sc.nextLine();
		
		Order o = new Order(userid, restarentid, orderdate, totalAmount, status, pamentMethod);
		
		OrderDAO order = new OrderDAOimpl();
		order.addOrder(o);
	}
}
